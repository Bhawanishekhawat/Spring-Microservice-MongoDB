package user.management.user.service.entity;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
@Document("user_data")
public class User {
	@Id
	private String id;
	@NotNull(message = "{firstName}")
	private String firstName;
	@NotNull(message = "{lastName}")
	private String lastName;
	@Digits(integer = 10, fraction = 0, message = "{MobileNo}")
	@Min(value = 1000000000, message = "{MobileNo}")
	@NotNull(message = "{mobile_No}")
	private Long mobileNo;
	@Email(message = "{email}")
	@NotNull(message = "{email_id}")
	private String emailId;
	@NotNull(message = "{dateOfBirth}")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dob;
	@NotNull(message = "{address}")
	private String address;

}
