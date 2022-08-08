package com.justin.Sofkigram.service;
import com.justin.Sofkigram.dto.UserLikeDTO;
import com.justin.Sofkigram.mapper.Mapper;
import com.justin.Sofkigram.repository.IUserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikeServiceImplementation {

    @Autowired
    private Mapper mapper;

    @Autowired
    private IUserLikeRepository userLikeRepository;




    @Override
    public UserLikeDTO createUser(UserLikeDTO userLikeDTO) {
        return mapper
                .fromEntityToUserLikeDto(userLikeRepository
                        .save(mapper.fromUserLikeDtoToEntity(userLikeDTO)));
    }

    @Override
    public UserLikeDTO findUser(UserLikeDTO userLikeDTO) {
        return null;
    }

    @Override
    public UserLikeDTO createLike() {

        return null;
    }

    @Override
    public UserLikeDTO deleteLike() {
        return null;
    }

    @Override
    public void deleteUserLike(Integer id) {

    }

}
