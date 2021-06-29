package tacocloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacocloud.data.UserRepository;
import tacocloud.entity.RegisterForm;

/**
 * 注册控制器
 *
 * @author insight
 * @since 2021/5/9
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserRepository userRepo,
                              PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 呈现表单页面
     */
    @GetMapping
    public String registerForm() {
        return "registration";
    }

    /**
     * 处理注册请求
     */
    @PostMapping
    public String processRegistration(RegisterForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}