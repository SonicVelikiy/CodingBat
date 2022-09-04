package uz.pdp.codingbat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.Entity.ProgramingLanguage;
import uz.pdp.codingbat.Repository.ProgramingLanguageRepository;

import java.util.List;

@Service
public class ProgramingLanguageService {

    @Autowired
    ProgramingLanguageRepository programingLanguageRepository;

    public List<ProgramingLanguage> getProgramingLanguage() {
        return programingLanguageRepository.findAll();
    }
}
