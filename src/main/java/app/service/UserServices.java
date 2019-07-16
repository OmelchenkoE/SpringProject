package app.service;

import app.domain.User;
import app.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServices {
    @Autowired
    private final UserRepo userRepo;

    public User create(User user) {
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword()) || user.getRoles().size() < 1) {
            throw new UnsupportedOperationException("Incorrect user fields");
        }
        user.setActive(true);
        userRepo.save(user);
        return user;
    }

    public Optional<User> read(User user) {
        return userRepo.findById(user.getId());
    }

    public List<User> readAll() {
        return userRepo.findAll();
    }

    public void delete(int id) {
        userRepo.deleteById(id);
    }
}