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
public class SofkigramApplication {



	public static void main(String[] args) {
		SpringApplication.run(SofkigramApplication.class, args);
	}


}
