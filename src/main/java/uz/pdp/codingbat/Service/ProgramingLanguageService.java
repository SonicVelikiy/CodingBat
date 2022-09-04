package uz.pdp.codingbat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.Entity.ProgramingLanguage;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProgramingLanguageDto;
import uz.pdp.codingbat.Repository.ProgramingLanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramingLanguageService {

    @Autowired
    ProgramingLanguageRepository programingLanguageRepository;

    public List<ProgramingLanguage> getProgramingLanguage() {
        return programingLanguageRepository.findAll();
    }

    public ApiResponse addProgramingLanguage(ProgramingLanguageDto programingLanguageDto) {
        boolean existsByLangName = programingLanguageRepository.existsByLangName(programingLanguageDto.getLangName());
        if (existsByLangName) {
            return new ApiResponse("Bunday nomli dasturlash tili mavjud", false);
        }
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setLangName(programingLanguageDto.getLangName());
        programingLanguageRepository.save(programingLanguage);
        return new ApiResponse("Dasturlash tili qo'shildi", true);
    }

    public ApiResponse editProgramingLanguage(Integer id, ProgramingLanguageDto programingLanguageDto) {
        Optional<ProgramingLanguage> programingLanguageRepositoryById = programingLanguageRepository.findById(id);
        if (!programingLanguageRepositoryById.isPresent()) {
            return new ApiResponse("Bunday dasturlash tili mavjud emas", false);
        }
        boolean existsByLangNameAndIdNot = programingLanguageRepository.existsByLangNameAndIdNot(programingLanguageDto.getLangName(), id);
        if (existsByLangNameAndIdNot) {
            return new ApiResponse("Bunday dasturlash tili mavjud", false);
        }

        ProgramingLanguage programingLanguage = programingLanguageRepositoryById.get();

        programingLanguage.setLangName(programingLanguageDto.getLangName());

        programingLanguageRepository.save(programingLanguage);
        return new ApiResponse("Dasturlash tili o'zgartirildi", true);
    }

    public ApiResponse deleteProgramingLanguage(Integer id) {
        Optional<ProgramingLanguage> programingLanguageRepositoryById = programingLanguageRepository.findById(id);
        if (!programingLanguageRepositoryById.isPresent()) {
            return new ApiResponse("Bunday dasturlash tili topilmadi", false);
        }
        programingLanguageRepository.deleteById(id);
        return new ApiResponse("Dasturlash tili o'chirildi", true);
    }
}
