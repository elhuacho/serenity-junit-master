package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaLogin {
    public static final Target EMAIL = Target.the("Entrada de Email").located(By.id("email"));
    public static final Target PASSWORD = Target.the("Entrada de Contraseña").located(By.id("passwd"));
    public static final Target BOTON_SIGN_IN = Target.the("Botón de Sign in").located(By.id("SubmitLogin"));
}
