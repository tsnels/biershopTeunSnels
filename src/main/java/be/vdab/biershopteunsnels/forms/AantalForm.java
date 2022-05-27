package be.vdab.biershopteunsnels.forms;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record AantalForm(@NotNull @Positive @Min(1) Integer aantal) {
}
