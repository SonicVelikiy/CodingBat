package uz.pdp.codingbat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.Entity.Problem;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProblemDto;
import uz.pdp.codingbat.Service.ProblemCategoryService;
import uz.pdp.codingbat.Service.ProblemService;

import java.util.List;

@RestController
public class ProblemController {

    @Autowired
    ProblemService problemService;

    @GetMapping("/api/problems")
    public List<Problem> getProblems() {
        return problemService.getProblems();
    }

    @PostMapping("/api/problem")
    public HttpEntity<ApiResponse> addProblem(@RequestBody ProblemDto problemDto) {
        ApiResponse apiResponse = problemService.addProblem(problemDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/api/problem/{id}")
    public HttpEntity<ApiResponse> editProblem(@PathVariable Integer id, @RequestBody ProblemDto problemDto) {
        ApiResponse apiResponse = problemService.editProblem(id, problemDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/api/problem/{id}")
    public HttpEntity<ApiResponse> deleteProblem(@PathVariable Integer id){
        ApiResponse apiResponse = problemService.deleteProblem(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
