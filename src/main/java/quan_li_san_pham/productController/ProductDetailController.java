package quan_li_san_pham.productController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import quan_li_san_pham.products.Books;
import quan_li_san_pham.products.Clothes;
import quan_li_san_pham.products.Electronics;
import quan_li_san_pham.products.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductDetailController implements Initializable {
    @FXML
    private TextField ProductIDField;
    @FXML
    private TextField ProductNameField;
    @FXML
    private TextField ProductPriceField;
    @FXML
    private TextField ProductQuantityField;
    @FXML
    private TextField ProductNoteField;
    @FXML
    private TextField ProductTypeField;
    @FXML
    private TextField BooksAuthorField;
    @FXML
    private TextField BooksPublisherField;
    @FXML
    private TextField BooksLanguageField;
    @FXML
    private TextField BooksNumPageField;
    @FXML
    private TextField ClothesBrandField;
    @FXML
    private TextField ClothesSizeField;
    @FXML
    private TextField ClothesStyleField;
    @FXML
    private TextField ClothesMaterialField;
    @FXML
    private TextField ClothesGenderField;
    @FXML
    private TextField ElectBrandField;
    @FXML
    private TextField ElectWPField;
    @FXML
    private TextField ElectModelField;

    public static ProductDetailController instance;
    @FXML
    private AnchorPane BooksAnchorPane;
    @FXML
    private AnchorPane ElectAnchorPane;
    @FXML
    private AnchorPane ClothesAnchorPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         instance = this;
         BooksAnchorPane.setVisible(false);
         ClothesAnchorPane.setVisible(false);
         ElectAnchorPane.setVisible(false);
    }

    public void init(Product select){
        ProductIDField.setText(select.getProductId());
        ProductNameField.setText(select.getProductName());
        ProductPriceField.setText(String.valueOf(select.getProductPrice()));
        ProductQuantityField.setText(String.valueOf(select.getProductQuantity()));
        ProductNoteField.setText(select.getProductNote());
        ProductTypeField.setText(select.getProductType());

        if(select instanceof Books){
            BooksAuthorField.setText(((Books) select).getAuthor());
            BooksPublisherField.setText(((Books) select).getPublisher());
            BooksLanguageField.setText(((Books) select).getLanguage());
            BooksNumPageField.setText(String.valueOf(((Books) select).getNumPage()));
            BooksAnchorPane.setVisible(true);
            ClothesAnchorPane.setVisible(false);
            ElectAnchorPane.setVisible(false);
        }
        if(select instanceof Clothes){
            ClothesBrandField.setText(((Clothes) select).getBrand());
            ClothesSizeField.setText(((Clothes) select).getSize());
            ClothesStyleField.setText(((Clothes) select).getStyle());
            ClothesMaterialField.setText(((Clothes) select).getMaterial());
            ClothesGenderField.setText(((Clothes) select).getGender());
            BooksAnchorPane.setVisible(false);
            ClothesAnchorPane.setVisible(true);
            ElectAnchorPane.setVisible(false);
        }
        if(select instanceof Electronics){
            ElectBrandField.setText(((Electronics) select).getBrand());
            ElectWPField.setText(((Electronics) select).getWarrantyPeriod());
            ElectModelField.setText(((Electronics) select).getModel());
            BooksAnchorPane.setVisible(false);
            ClothesAnchorPane.setVisible(false);
            ElectAnchorPane.setVisible(true);
        }
    }

    public void ConfirmHandle(){
        ProductController.instance.setAnchorPaneVisible();
    }
}
