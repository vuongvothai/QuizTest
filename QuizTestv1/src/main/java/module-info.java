module com.vtv.quiztestv1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.vtv.quiztestv1 to javafx.fxml;
    exports com.vtv.quiztestv1;
    exports com.vtv.utils;
}
