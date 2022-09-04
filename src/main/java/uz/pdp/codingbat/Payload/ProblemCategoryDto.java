package uz.pdp.codingbat.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemCategoryDto {

    private String categoryName;

    private Integer categoryLevel;

    private Integer programingLanguage;
}
