package com.mckz.beanutilsdto.services;

import com.mckz.beanutilsdto.Dtos.UserDto;
import com.mckz.beanutilsdto.models.UserModel;
import com.mckz.beanutilsdto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }
    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    //++++++++++++++++++++++++++
    public UserDto create(UserModel userModel){
        UserDto userDto = new UserDto();
        userDto.convert(userModel);
        userModel.setAdmin(false);
        userRepository.save(userModel);
        return userDto;
    }
    public List<UserDto> getAll(){
        UserDto userDto = new UserDto();
        return userDto.convertList(userRepository.findAll());
    }
}
