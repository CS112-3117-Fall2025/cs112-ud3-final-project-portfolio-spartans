module cs112.ud3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens cs112.ud3 to javafx.fxml;
    exports cs112.ud3;
    exports cs112.ud3.UD2.Baseball;
}