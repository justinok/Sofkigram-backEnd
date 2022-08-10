package com.justin.Sofkigram;

import com.justin.Sofkigram.entity.Like;
import com.justin.Sofkigram.entity.Post;
import com.justin.Sofkigram.repository.ILikeRepository;
import com.justin.Sofkigram.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SofkigramApplication implements CommandLineRunner {

	@Autowired
	private IPostRepository postRepository;
	@Autowired
	private ILikeRepository likeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SofkigramApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Post post = new Post("este seria el mensaje", "y este el titulo");
		Like like = new Like("Justin","123455");
		post.getLikes().add(like);

		like.getPosts().add(post);

		this.postRepository.save(post);
	}
}
