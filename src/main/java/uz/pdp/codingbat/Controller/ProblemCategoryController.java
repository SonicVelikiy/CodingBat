package uz.pdp.codingbat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.Entity.ProblemCategory;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProblemCategoryDto;
import uz.pdp.codingbat.Service.ProblemCategoryService;

import java.util.List;

@RestController
public class ProblemCategoryController {
    @Autowired
    ProblemCategoryService problemCategoryService;

    @GetMapping("/api/probcateg")
    public List<ProblemCategory> getProblemCategory() {

        return problemCategoryService.getProblemCategory();
    }

    @PostMapping("/api/probcateg")
    public HttpEntity<ApiResponse> addProblemCategory(@RequestBody ProblemCategoryDto problemCategoryDto) {
        ApiResponse apiResponse = problemCategoryService.addProblemCategory(problemCategoryDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/api/probcateg/{id}")
    public HttpEntity<ApiResponse> editProblemCategory(@PathVariable Integer id, @RequestBody ProblemCategoryDto problemCategoryDto) {
        ApiResponse apiResponse = problemCategoryService.editProblemCategory(id, problemCategoryDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/api/probcateg/{id}")
    public HttpEntity<ApiResponse> deleteProblemCategory(@PathVariable Integer id) {
        ApiResponse apiResponse = problemCategoryService.deleteProblemCategory(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
