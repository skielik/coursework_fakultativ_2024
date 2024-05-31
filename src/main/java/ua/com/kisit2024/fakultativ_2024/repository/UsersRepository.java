package ua.com.kisit2024.fakultativ_2024.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit2024.fakultativ_2024.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username);

    List<Users> findAllByUsernameAndPassword(String username, String password);
}
