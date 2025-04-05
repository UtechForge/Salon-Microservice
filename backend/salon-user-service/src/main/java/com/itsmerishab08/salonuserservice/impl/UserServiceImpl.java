package com.itsmerishab08.salonuserservice.impl;

import com.itsmerishab08.salonuserservice.entity.UserEntity;
import com.itsmerishab08.salonuserservice.model.UserModel;
import com.itsmerishab08.salonuserservice.repository.UserRepository;
import com.itsmerishab08.salonuserservice.request.UserRequest;
import com.itsmerishab08.salonuserservice.response.BaseResponse;
import com.itsmerishab08.salonuserservice.response.UserResponse;
import com.itsmerishab08.salonuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public BaseResponse createUpdateUser(UserRequest user) {
        BaseResponse response = new BaseResponse();
        try{
            if(user.getId() != null){
                UserEntity userEntity = userRepository.findByIdAndDeletedAtNull(user.getId());
                if(userEntity == null)
                    throw  new Exception("User not found with the given Id");
                userEntity.setUserName(user.getUserName());
                userEntity.setEmail(user.getEmail());
                userEntity.setPhoneNumber(user.getPhoneNumber());
                userEntity.setRole(user.getRole());
                userEntity.setUpdatedAt(new Date());
                userRepository.save(userEntity);
                logger.info("User updated successfully");
            }
           else{
                UserEntity userEntity  = new UserEntity();
                userEntity.setId(UUID.randomUUID().toString());
                userEntity.setUserName(user.getUserName());
                userEntity.setEmail(user.getEmail());
                userEntity.setPhoneNumber(user.getPhoneNumber());
                userEntity.setRole(user.getRole());
                userEntity.setCreatedAt(new Date());
                userEntity.setUpdatedAt(new Date());
                userRepository.save(userEntity);
                logger.info("User created with id {}", user.getId());
            }
           response.setStatusCode(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public BaseResponse deleteUser(UserRequest user) {
        BaseResponse response = new BaseResponse();
        try {
            UserEntity userEntity = userRepository.findByIdAndDeletedAtNull(user.getId());
            if(userEntity == null)
                throw new Exception("User doesn't exist with the given Id");
            userEntity.setDeletedAt(new Date());
            userRepository.save(userEntity);
            logger.info("User deleted successfully");
            response.setStatusCode(HttpStatus.OK);
        }catch (Exception e) {
            logger.error(e.getMessage());
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public UserResponse getUserById(UserRequest user) {
        UserResponse response = new UserResponse();
        try{
            UserEntity userEntity = userRepository.findByIdAndDeletedAtNull(user.getId());
            if(userEntity == null)
                throw  new Exception("User not found with the given Id");
            UserModel model = new UserModel();
            model.setId(userEntity.getId());
            model.setUserName(userEntity.getUserName());
            model.setEmail(userEntity.getEmail());
            model.setPhoneNumber(userEntity.getPhoneNumber());
            model.setRole(userEntity.getRole());
            response.setUserModel(model);
            response.setStatusCode(HttpStatus.OK);
        }catch (Exception e) {
            logger.error(e.getMessage());
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @Override
    public UserResponse getUserList(UserRequest user) {
        UserResponse response = new UserResponse();
        try{
            List<UserEntity> userEntityList = userRepository.findAllByDeletedAtNull(PageRequest.of(user.getPageNumber()-1, user.getPageSize()));
            if(!userEntityList.isEmpty())
            {
                List<UserModel> userModelList = new ArrayList<>();
                for(UserEntity userEntity : userEntityList)
                {
                    UserModel model = new UserModel();
                    model.setId(userEntity.getId());
                    model.setUserName(userEntity.getUserName());
                    model.setEmail(userEntity.getEmail());
                    model.setPhoneNumber(userEntity.getPhoneNumber());
                    model.setRole(userEntity.getRole());
                    userModelList.add(model);
                }
                response.setUsers(userModelList);
            }
            response.setStatusCode(HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST);
        }
        return response;

    }
}
