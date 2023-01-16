package by.itstep.organizaer.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactsDto {
    @Nullable
    String address;

    @NotEmpty
    List<@NotEmpty @Pattern(regexp = "^(\\+)+\\d+$") @Size(max = 16, min = 6) String> phones;

    List<@Email String> email;

    List<@Pattern(regexp = "^(\\@)+\\w+$") String> messengers;

}
