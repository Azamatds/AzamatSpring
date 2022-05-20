//package com.example.azamatspring.Service;
//
//import com.example.azamatspring.Entity.Role;
//import com.example.azamatspring.Entity.Users;
//import com.example.azamatspring.Repository.RoleRepository;
//import com.example.azamatspring.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public Users getUserByUserName(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public Users createUser(Users user) {
//        Users chechUser = getUserByUserName(user.getUsername());
//        if (chechUser == null) {
//            Role role = roleRepository.findByName("ROLE_USER");
//            if (role != null) {
//                List<Role> roleList = new ArrayList<>();
//                roleList.add(role);
//                user.setRoles(roleList);
//                user.setPassword(passwordEncoder.encode(user.getPassword()));
//                return userRepository.save(user);
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users users = getUserByUserName(username);
//        if (users != null) {
//            User securityUser = new User(users.getUsername(),
//                    users.getPassword(), users.getRoles());
//            return securityUser;
//        }
//        throw new UsernameNotFoundException("User not found");
//    }
//
//    @PostConstruct
//    public void addValues() {
//        Role role1 = new Role(null, "ROLE_USER");
//        Role role2 = new Role(null, "ROLE_ADMIN");
//        roleRepository.save(role1);
//        roleRepository.save(role2);
//
//        List<Users> users = Arrays.asList(
//                new Users(null, "user", "87777777777", "user", null),
//                new Users(null, "admin", "87777777777", "admin", null)
//        );
//
//        for (Users u : users) {
//            createUser(u);
//        }
//    }
//}
//
