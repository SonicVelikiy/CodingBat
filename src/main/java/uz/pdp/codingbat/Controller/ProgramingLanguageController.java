package uz.pdp.codingbat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.codingbat.Entity.ProgramingLanguage;
import uz.pdp.codingbat.Payload.ApiResponse;
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
    public HttpEntity<ApiResponse> addProgramingLanguage(){
        
    }
}
