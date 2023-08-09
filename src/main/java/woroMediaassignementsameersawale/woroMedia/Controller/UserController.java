package woroMediaassignementsameersawale.woroMedia.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import woroMediaassignementsameersawale.woroMedia.Dto.LoginReqDto;
import woroMediaassignementsameersawale.woroMedia.Dto.LoginResDto;
import woroMediaassignementsameersawale.woroMedia.Entity.User;
import woroMediaassignementsameersawale.woroMedia.Security.JwtTokenProvider;
import woroMediaassignementsameersawale.woroMedia.Service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/add")
    public ResponseEntity registerUser(@RequestBody User user) throws Exception {
        User user1= userService.registerUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @RequestBody LoginReqDto loginReqDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginReqDto.getUserName(), loginReqDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.createToken(authentication);
        return ResponseEntity.ok(new LoginResDto(jwt));
    }

    @GetMapping("/get")
    public ResponseEntity current(){
        User user= userService.getAuthenticateUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
