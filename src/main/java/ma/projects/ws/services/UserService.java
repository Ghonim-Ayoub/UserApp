package ma.projects.ws.services;

import java.util.List;

import ma.projects.ws.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService  {

    UserDto createUser(UserDto user);

    UserDto getUser(String email);

    UserDto getUserByUserId(String userId);

    UserDto updateUser(String id, UserDto userDto);

    void deleteUser(String userId);

    List<UserDto> getUsers(int page, int limit, String search, int status);

}
