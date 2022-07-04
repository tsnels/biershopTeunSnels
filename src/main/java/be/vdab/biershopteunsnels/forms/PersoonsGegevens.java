package be.vdab.biershopteunsnels.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public record PersoonsGegevens(@NotBlank String naam,@NotBlank String straat,@NotBlank String huisNr, @Min(1000) @Max(9999) Integer postcode,@NotBlank String gemeente) {
}