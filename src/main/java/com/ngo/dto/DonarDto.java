package com.ngo.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonarDto {
	
	
	private Long donarId;
   
	@NotEmpty
	@Size(min=3, message = "Name Must be Atleast 3 Character !!")
	private String donarName;
   
	@NotEmpty
	@Size(min=10,max=10,message = "Donar Contact No Must be 10 digit !! ")
	private String doanrContact;
	
	@NotEmpty
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donarPan;
	
	@NotEmpty
	private String donarGender;
    @NotEmpty
	private String donarDOB;

	private Double donarAmount;

}
