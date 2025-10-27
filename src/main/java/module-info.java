module co.edu.uniquindio.poo.envioproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires java.desktop;


    exports co.edu.uniquindio.poo.envioproyecto;


    opens co.edu.uniquindio.poo.envioproyecto to javafx.fxml;
    opens co.edu.uniquindio.poo.envioproyecto.ViewController to javafx.fxml;


    opens co.edu.uniquindio.poo.envioproyecto.model to javafx.base;
}
