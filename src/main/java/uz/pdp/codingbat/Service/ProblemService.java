package uz.pdp.codingbat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.Entity.Problem;
import uz.pdp.codingbat.Entity.ProblemCategory;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProblemDto;
import uz.pdp.codingbat.Repository.ProblemCategoryRepository;
import uz.pdp.codingbat.Repository.ProblemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {

    @Autowired
    ProblemRepository problemRepository;

    @Autowired
    ProblemCategoryRepository problemCategoryRepository;

    public List<Problem> getProblems() {
        return problemRepository.findAll();
    }

    public ApiResponse addProblem(ProblemDto problemDto) {
        boolean existsByProbName = problemRepository.existsByProbName(problemDto.getProbName());
        if (existsByProbName) {
            return new ApiResponse("Bunday nomli savol bazada mavjud", false);
        }
        Optional<ProblemCategory> problemCategoryRepositoryById = problemCategoryRepository.findById(problemDto.getProblemCategory());
        if (!problemCategoryRepositoryById.isPresent()) {
            return new ApiResponse("Bunday problemCategory bazada mavjud emas", false);
        }
        Problem problem = new Problem();
        problem.setProbName(problemDto.getProbName());
        problem.setProblemCategory(problemCategoryRepositoryById.get());
        problemRepository.save(problem);
        return new ApiResponse("Savol bazaga qo'shildi", true);
    }

    public ApiResponse editProblem(Integer id, ProblemDto problemDto) {
        Optional<Problem> problemRepositoryById = problemRepository.findById(id);
        if (!problemRepositoryById.isPresent()) {
            return new ApiResponse("Bunday savol bazada mavjud emas", false);
        }
        boolean existsByProbNameAndIdNot = problemRepository.existsByProbNameAndIdNot(problemDto.getProbName(), id);
        if (existsByProbNameAndIdNot) {
            return new ApiResponse("Bunday nomli savol bazada mavjud", false);
        }

        Optional<ProblemCategory> problemCategoryRepositoryById = problemCategoryRepository.findById(problemDto.getProblemCategory());
        if (!problemCategoryRepositoryById.isPresent()) {
            return new ApiResponse("Bunday savol kategoriyasi bazada mavjud emas", false);
        }

        Problem problem = problemRepositoryById.get();
        problem.setProblemCategory(problemCategoryRepositoryById.get());
        problem.setProbName(problemDto.getProbName());
        problemRepository.save(problem);
        return new ApiResponse("Savol o'zgartirildi", true);
    }

    public ApiResponse deleteProblem(Integer id) {
        Optional<Problem> problemRepositoryById = problemRepository.findById(id);
        if (!problemRepositoryById.isPresent()) {
            return new ApiResponse("Bunday savol bazadan topilmadi", false);
        }

        problemRepository.deleteById(id);
        return new ApiResponse("Savol bazadan o'chirildi", true);
    }
}
