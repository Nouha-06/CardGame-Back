package com.univ.cardgame;
import com.univ.cardgame.constante.RoleEnum;
import com.univ.cardgame.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.univ.cardgame.repository.UserRepository;

@SpringBootApplication
public class CardGameApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args)  {
        SpringApplication.run(CardGameApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        // blanc password: PwdCardGame123
        // administrator
        UserEntity admin = new UserEntity();
        admin.setLogin("admin.cardgame@gmail.com");
        admin.setPassword("$2a$10$IhsGsxq/.QRAzN/N7QVMS.u3ChLlrQG93UXQGNuAZwWulBUPkHGQq");
        admin.setUserName("admin");
        List<RoleEnum> roles = new ArrayList<>();
        roles.add(RoleEnum.ROLE_PLAYER);
        roles.add(RoleEnum.ROLE_ADMIN);
        admin.setRoles(roles);
        userRepository.save(admin);

        // players
        UserEntity player1 = new UserEntity();
        player1.setLogin("yannis.yahi@gmail.com");
        player1.setPassword("$2a$10$IhsGsxq/.QRAzN/N7QVMS.u3ChLlrQG93UXQGNuAZwWulBUPkHGQq");
        player1.setUserName("yannis");
        roles.remove(RoleEnum.ROLE_ADMIN);
        player1.setRoles(roles);
        userRepository.save(player1);

        UserEntity player2 = new UserEntity();
        player2.setLogin("julia.ata@gmail.com");
        player2.setPassword("$2a$10$IhsGsxq/.QRAzN/N7QVMS.u3ChLlrQG93UXQGNuAZwWulBUPkHGQq");
        player2.setUserName("julia");
        player2.setRoles(roles);
        userRepository.save(player2);

        UserEntity player3 = new UserEntity();
        player3.setLogin("nouhaila.mellouki@gmail.com");
        player3.setPassword("$2a$10$IhsGsxq/.QRAzN/N7QVMS.u3ChLlrQG93UXQGNuAZwWulBUPkHGQq");
        player3.setUserName("nouhaila");
        player3.setRoles(roles);
        userRepository.save(player3);

        UserEntity player4 = new UserEntity();
        player4.setLogin("abdellah.yacouba@gmail.com");
        player4.setPassword("$2a$10$IhsGsxq/.QRAzN/N7QVMS.u3ChLlrQG93UXQGNuAZwWulBUPkHGQq");
        player4.setUserName("abdellah");
        player4.setRoles(roles);
        userRepository.save(player4);
    }
}
