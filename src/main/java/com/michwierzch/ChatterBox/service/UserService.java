package com.michwierzch.ChatterBox.service;

import com.michwierzch.ChatterBox.model.UserModel;
import com.michwierzch.ChatterBox.repository.UserRepository;
import com.michwierzch.ChatterBox.model.ConfirmationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    public String singUpUser(UserModel userModel) {
        boolean userExists = userRepository.findByUsername(userModel.getUsername())
                .isPresent();
        boolean userEmailExists = userRepository.findByEmail(userModel.getEmail())
                .isPresent();

        if (userExists){
            //TODO: CHECK IF ATTRIBUTES ARE THE SAME AND
            //TODO: IF EMAIL NOT CONFIRMED SEND CONFIRMATION EMAIL.
            throw new IllegalStateException("Username taken");
        }
        if (userEmailExists){
            throw new IllegalStateException("Email already in use!");
        }
        String encodedPass = bCryptPasswordEncoder
                .encode(userModel.getPassword());

        userModel.setPassword(encodedPass);

        userRepository.save(userModel);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                userModel
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableAppUser(String username) {
        return userRepository.enableAppUser(username);
    }
}
