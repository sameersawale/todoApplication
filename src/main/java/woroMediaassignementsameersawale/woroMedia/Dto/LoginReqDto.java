package woroMediaassignementsameersawale.woroMedia.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginReqDto {

    private String userName;

    private String password;
}
