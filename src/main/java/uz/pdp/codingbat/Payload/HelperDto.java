package uz.pdp.codingbat.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HelperDto {

    private String helperTitle;

    private String helperContent;

    private Integer programingLanguage;
}
