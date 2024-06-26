package com.workintech.backend.util;

import com.workintech.backend.dto.AddressResponse;
import com.workintech.backend.dto.UserResponse;
import com.workintech.backend.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoConvertion {

    public static List<UserResponse> convertUserList (List<User> userList){
        List<UserResponse> userResponses = new ArrayList<>();

        userList.stream().forEach(user -> userResponses.add(new UserResponse(user.getId(), user.getName(), user.getEmail()
                , AddressDtoConvertion.convertAddressList(user.getAddresses()) , OrderDtoConvertion.convertOrderList(user.getOrderList()) )));

        return userResponses;
    }

    public static UserResponse convertUser(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail()
                ,AddressDtoConvertion.convertAddressList(user.getAddresses()) , OrderDtoConvertion.convertOrderList(user.getOrderList()));
    }
}
