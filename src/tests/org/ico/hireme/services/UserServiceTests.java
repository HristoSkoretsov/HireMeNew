package org.ico.hireme.services;

import org.ico.hireme.domain.entities.User;
import org.ico.hireme.models.binding.UserRegisterBindingModel;
import org.ico.hireme.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {

    private static final String PASSWORD = "pass";

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() {
        when(this.bCryptPasswordEncoder.encode(anyString()))
                .thenReturn(PASSWORD);
    }

    @Test
    public void testRegister_withUsernameAndPassword_passwordShouldBeEncoded() {
        when(this.userRepository.save(any()))
                .thenAnswer(i -> i.getArgumentAt(0,UserRepository.class));
        final String USERNAME = "niki";
        final String PASSWORD = "niki123";
        final String cp = "niki123";

        UserRegisterBindingModel userRegisterBindingModel = new UserRegisterBindingModel();
        userRegisterBindingModel.setPassword(PASSWORD);
        userRegisterBindingModel.setUsername(USERNAME);
        userRegisterBindingModel.setConfirmPassword(cp);

        this.userService.createUser(userRegisterBindingModel);

        assertEquals(
                "Password was not or wrongly encoded!",
                PASSWORD,
                true
        );
    }



}
