package uz.pdp.codingbat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.Entity.ProblemCategory;
import uz.pdp.codingbat.Entity.ProgramingLanguage;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProblemCategoryDto;
import uz.pdp.codingbat.Repository.ProblemCategoryRepository;
import uz.pdp.codingbat.Repository.ProgramingLanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemCategoryService {

    @Autowired
    ProblemCategoryRepository problemCategoryRepository;

    @Autowired
    ProgramingLanguageRepository programingLanguageRepository;

    public List<ProblemCategory> getProblemCategory() {

        return problemCategoryRepository.findAll();
    }

    public ApiResponse addProblemCategory(ProblemCategoryDto problemCategoryDto) {
        boolean existsByCategoryName = problemCategoryRepository.existsByCategoryName(problemCategoryDto.getCategoryName());
        if (existsByCategoryName) {
            return new ApiResponse("Bunday nomli kategoriya bazada mavjud", false);
        }
        Optional<ProgramingLanguage> programingLanguageRepositoryById = programingLanguageRepository.findById(problemCategoryDto.getProgramingLanguage());

        if (!programingLanguageRepositoryById.isPresent()) {
            return new ApiResponse("Bunday dasturlash tili mavjud emas", false);
        }
        ProblemCategory problemCategory = new ProblemCategory();
        problemCategory.setCategoryLevel(problemCategoryDto.getCategoryLevel());
        problemCategory.setCategoryName(problemCategoryDto.getCategoryName());
        problemCategory.setProgramingLanguage(programingLanguageRepositoryById.get());
        problemCategoryRepository.save(problemCategory);
        return new ApiResponse("Savol kategoriyasi qo'shildi", true);
    }

    public ApiResponse editProblemCategory(Integer id, ProblemCategoryDto problemCategoryDto) {
        boolean existsByCategoryNameAndIdNot = problemCategoryRepository.existsByCategoryNameAndIdNot(problemCategoryDto.getCategoryName(), id);
        if (existsByCategoryNameAndIdNot) {
            return new ApiResponse("Bunday kategoriya bazada mavjud", false);
        }
        Optional<ProblemCategory> problemCategoryRepositoryById = problemCategoryRepository.findById(id);
        if (!problemCategoryRepositoryById.isPresent()) {
            return new ApiResponse("Bunday kategoriya bazada mavjud emas", false);
        }

        Optional<ProgramingLanguage> programingLanguageRepositoryById = programingLanguageRepository.findById(problemCategoryDto.getProgramingLanguage());
        if (!programingLanguageRepositoryById.isPresent()) {
            return new ApiResponse("Bunday dasturlash tili bazada mavjud emas", false);
        }

        ProblemCategory problemCategory = problemCategoryRepositoryById.get();
        problemCategory.setCategoryLevel(problemCategoryDto.getCategoryLevel());
        problemCategory.setCategoryName(problemCategoryDto.getCategoryName());
        problemCategory.setProgramingLanguage(programingLanguageRepositoryById.get());
        problemCategoryRepository.save(problemCategory);
        return new ApiResponse("Kategoriya o'zgartirildi", true);

    }

    public ApiResponse deleteProblemCategory(Integer id) {
        Optional<ProblemCategory> problemCategoryRepositoryById = problemCategoryRepository.findById(id);
        if (!problemCategoryRepositoryById.isPresent()) {
            return new ApiResponse("Bunday kategoriya bazadan topilmadi", false);
        }
        problemCategoryRepository.deleteById(id);
        return new ApiResponse("Kategoriya o'chirildi", true);
    }
}
