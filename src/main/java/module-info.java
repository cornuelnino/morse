module com.example.testmorse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testmorse to javafx.fxml;
    exports com.example.testmorse;
}