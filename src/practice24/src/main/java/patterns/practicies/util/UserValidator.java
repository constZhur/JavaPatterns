package patterns.practicies.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import patterns.practicies.model.User;
import patterns.practicies.service.UserService;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User findUser = userService.findUserByEmail(user.getEmail());
        if (findUser != null)
            errors.rejectValue("email", "", "Пользователь с такой электронной почтой уже существует");
    }
}
