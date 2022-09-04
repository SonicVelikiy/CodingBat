package uz.pdp.codingbat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.codingbat.Entity.Users;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.UserDto;
import uz.pdp.codingbat.Service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/api/user")
    public HttpEntity<ApiResponse> addUser(@RequestBody UserDto userDto) {
        ApiResponse apiResponse = userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/api/user/{id}")
    public HttpEntity<ApiResponse> editUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        ApiResponse apiResponse = userService.editUser(id, userDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED).body(apiResponse);
    }

    @DeleteMapping("/api/user/{id}")
    public HttpEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.deleteUser(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND).body(apiResponse);
    }
}
