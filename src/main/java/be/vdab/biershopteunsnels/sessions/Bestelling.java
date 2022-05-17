package be.vdab.biershopteunsnels.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;


@Component
@SessionScope
public class Bestelling implements Serializable {

    private final static long serialVersionUID = 1L;
    private int aantal = 0;

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }



}
