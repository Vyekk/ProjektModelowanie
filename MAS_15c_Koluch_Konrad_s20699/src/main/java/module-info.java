module ekomp.mas_15c_koluch_konrad_s20699 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ekomp to javafx.fxml;
    exports ekomp;
    exports ekomp.Controllers;
    opens ekomp.Controllers to javafx.fxml;
}