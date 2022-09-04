package uz.pdp.codingbat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.Entity.Users;
import uz.pdp.codingbat.Payload.ApiResponse;
import uz.pdp.codingbat.Payload.UserDto;
import uz.pdp.codingbat.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public ApiResponse addUser(UserDto userDto) {
        boolean existsByEmail = userRepository.existsByEmail(userDto.getEmail());
        if (existsByEmail) {
            return new ApiResponse("Bunday email mavjud", false);
        }
        Users users = new Users();
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        userRepository.save(users);
        return new ApiResponse("Email qo'shildi", true);
    }

    public ApiResponse editUser(Integer id, UserDto userDto) {
        boolean existsByEmailAndIdNot = userRepository.existsByEmailAndIdNot(userDto.getEmail(), id);
        if (existsByEmailAndIdNot) {
            return new ApiResponse("Bunday email mavjud", false);
        }
        Optional<Users> userRepositoryById = userRepository.findById(id);
        if (!userRepositoryById.isPresent()) {
            return new ApiResponse("Bunday email bazada mavjud emas", false);
        }

        Users users = userRepositoryById.get();
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        userRepository.save(users);
        return new ApiResponse("User o'zgartirildi", true);
    }

    public ApiResponse deleteUser(Integer id) {
        Optional<Users> userRepositoryById = userRepository.findById(id);
        if (!userRepositoryById.isPresent()) {
            return new ApiResponse("Bunday user bazadan topilmadi", false);
        }

        userRepository.deleteById(id);
        return new ApiResponse("User bazadan o'chirildi", true);
    }
}
