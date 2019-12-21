package mystore.acciones;

import mystore.constantes.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class Decidido implements Task {

    public Decidido() {

    }

    public static Performable ingresarConUsuarioYContrasena() {
        return Tasks.instrumented(Decidido.class);
    }

    @Override
    @Step("{0} ha decidido ingresar con su cuenta")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Navegar.hacia(Constantes.PAGINA_SIGN_IN)
        );
    }
}
