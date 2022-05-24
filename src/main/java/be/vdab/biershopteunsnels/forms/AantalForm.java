package be.vdab.biershopteunsnels.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record AantalForm(@NotNull @Positive Integer aantal) {
}
