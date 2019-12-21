package mystore;

import mystore.acciones.IrACategoria;
import mystore.acciones.Ordernar;
import mystore.acciones.Decidido;
import mystore.preguntas.LaPaginaWomen;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CuandoUsuarioOrdenaPorLista {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void prepararEscenario() {
        actor = Actor.named("Jorge");
        actor.can(BrowseTheWeb.with(navegador));
    }

    @Test
    public void conCriterioOrdenAlfabetico() {
        BrowseTheWeb.as(actor).setImplicitTimeout(20, SECONDS);
        actor.has(Decidido.ingresarConUsuarioYContrasena());
        actor.attemptsTo(IrACategoria.women());
        actor.attemptsTo(Ordernar.ordenAlfabeticoDesdeA());
        actor.should(seeThat("Titulo del primer resultado por orden alfabético es blouse",
                LaPaginaWomen.primerTituloDeProducto(), equalTo("Blouse")));
    }
}
