package uz.pdp.codingbat.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDto {

    private String probName;

    private Integer problemCategory;
}
