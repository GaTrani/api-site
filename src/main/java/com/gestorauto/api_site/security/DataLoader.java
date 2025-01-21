package com.gestorauto.api_site.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gestorauto.api_site.entities.User;
import com.gestorauto.api_site.repositories.*;;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Adicione um usuário para teste se não existir
        if (userRepository.findByEmail("teste@exemplo.com").isEmpty()) {
            User user = new User();
            user.setName("Teste");
            user.setEmail("teste@exemplo.com");
            user.setPassword(passwordEncoder.encode("1234")); // Certifique-se de usar uma senha codificada
            userRepository.save(user);
        }
    }
}
