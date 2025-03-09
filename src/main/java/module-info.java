module org.example.demo5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.luisfelipe.doublependulumsimulator to javafx.fxml;
    exports com.luisfelipe.doublependulumsimulator;
}