package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.ProblemCategory;
import uz.pdp.codingbat.Entity.ProgramingLanguage;

@Repository
public interface ProblemCategoryRepository extends JpaRepository<ProblemCategory, Integer> {

    boolean existsByCategoryNameAndProgramingLanguage(String categoryName, ProgramingLanguage programingLanguage);

    boolean existsByCategoryNameAndIdNot(String categoryName, Integer id);

}
