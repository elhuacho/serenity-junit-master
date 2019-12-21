package mystore;

import mystore.preguntas.LaPaginaMiCuenta;
import mystore.acciones.Decidido;
import mystore.acciones.IngresarCon;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CuandoUsuarioSeLoguea {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void prepararEscenario() {
        actor = Actor.named("Jorge");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Test
    public void ingresarAMyAccountCorrectamente() {
        actor.has(Decidido.ingresarConUsuarioYContrasena());
        actor.attemptsTo(IngresarCon.usuario("juantor16@gmail.com").contrasena("Argentina1"));
        actor.should(
                seeThat("Subtitulo de pagina My Account", LaPaginaMiCuenta.subtitulo(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders."))
        );
    }
}
