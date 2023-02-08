package com.example.demo.models.dto;

//import com.example.demo.models.validation.UniqueUserEmail;
import javax.validation.constraints.Size;



public class UserRegisterDto {
    private String username;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;

    public UserRegisterDto() {
    }

    @Size(min = 3, message = "Please use more then 3 symbols")

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min = 3, message = "Please use more then 3 symbols")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Size(min = 3, message = "Please use more then 3 symbols")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Size(min = 3, message = "Please use more then 3 symbols")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
