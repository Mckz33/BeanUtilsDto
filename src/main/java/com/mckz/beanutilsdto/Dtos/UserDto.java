package com.mckz.beanutilsdto.Dtos;

import com.mckz.beanutilsdto.models.UserModel;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private String nome;
    private String email;

    public UserDto convert(UserModel userModel){
        BeanUtils.copyProperties(userModel, this, "id", "password", "admin");
        return this;
    }
    public List<UserDto> convertList(List<UserModel> listUser){
        UserDto userDto = new UserDto();
        List<UserDto> userDtoList = new ArrayList<>();
        listUser.forEach(u-> {
            userDtoList.add(userDto.convert(u));
        });
        return userDtoList;
    }
}
