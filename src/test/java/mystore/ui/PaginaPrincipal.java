package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPrincipal {
    public static final Target CATEGORIA_WOMEN = Target.the("El botón de categoría Women en página principal")
            .locatedBy("//a[@title='Women']");
}
