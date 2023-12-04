package semestarovka.reposetories;

import semestarovka.models.User;
import semestarovka.reposetories.Crudrepo;

import java.util.UUID;

public interface Userrepo extends Crudrepo<User> {
    User findUser(String email, String password);
    void userCookie(UUID uuid, int userId);
    void deleteUser(int userId);
    void updateUser(int userId, String firstName, String lastName, int age, String email, String password);
    User findById(int userId);

    User findByUsername(String username);

    User findUserByCookie(UUID uuid);
}

