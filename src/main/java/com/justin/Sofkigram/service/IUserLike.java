package com.justin.Sofkigram.service;

import com.justin.Sofkigram.dto.UserLikeDTO;

public interface IUserLike {
    UserLikeDTO createUser (UserLikeDTO userLike);

    UserLikeDTO findUser(UserLikeDTO userLikeDTO);
    UserLikeDTO createLike();
    UserLikeDTO deleteLike();
    void deleteUserLike(Integer id);
}
