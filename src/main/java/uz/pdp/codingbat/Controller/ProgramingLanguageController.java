package uz.pdp.codingbat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.Entity.ProgramingLanguage;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.ProgramingLanguageDto;
import uz.pdp.codingbat.Service.ProgramingLanguageService;

import java.util.List;

@RestController
public class ProgramingLanguageController {

    @Autowired
    ProgramingLanguageService programingLanguageService;

    @GetMapping("/api/proglang")
    public List<ProgramingLanguage> getProgramingLanguage() {
        return programingLanguageService.getProgramingLanguage();
    }

    @PostMapping("/api/proglang")
    public HttpEntity<ApiResponse> addProgramingLanguage(@RequestBody ProgramingLanguageDto programingLanguageDto) {
        ApiResponse apiResponse = programingLanguageService.addProgramingLanguage(programingLanguageDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/api/proglang/{id}")
    public HttpEntity<ApiResponse> editProgramingLanguage(@PathVariable Integer id, @RequestBody ProgramingLanguageDto programingLanguageDto) {
        ApiResponse apiResponse = programingLanguageService.editProgramingLanguage(id, programingLanguageDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/api/proglang/{id}")
    public HttpEntity<ApiResponse> deleteProgramingLanguage(@PathVariable Integer id) {
        ApiResponse apiResponse = programingLanguageService.deleteProgramingLanguage(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
