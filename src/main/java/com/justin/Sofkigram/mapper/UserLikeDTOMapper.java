package com.justin.Sofkigram.mapper;


import com.justin.Sofkigram.dto.UserLikeDTO;
import com.justin.Sofkigram.entity.UserLike;
import com.justin.Sofkigram.repository.IUserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLikeDTOMapper {

    @Autowired
    IUserLikeRepository IUserLikeRepository;

    public UserLikeDTO userLikeMapper(UserLike userLike) {
        UserLikeDTO userLikeDTO = new UserLikeDTO();

        userLikeDTO.setId(userLike.getId());
        userLikeDTO.setUserName(userLikeDTO.getUserName());
        userLikeDTO.setDni(userLikeDTO.getDni());

        return userLikeDTO;
    }

    public UserLike dtoMapper(UserLikeDTO userLikeDTO) {
        UserLike userLike = new UserLike();

        userLike.setUserName(userLikeDTO.getUserName());
        userLike.setDni(userLikeDTO.getDni());

        return userLike;
    }
}
