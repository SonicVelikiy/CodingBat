package uz.pdp.codingbat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.codingbat.Entity.ProgramingLanguage;

@Repository
public interface ProgramingLanguageRepository extends JpaRepository<ProgramingLanguage, Integer> {
}
