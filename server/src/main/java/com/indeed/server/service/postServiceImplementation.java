package com.indeed.server.service;

import com.indeed.server.dao.PostDao;
import com.indeed.server.dto.PostDTO;
import com.indeed.server.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class postServiceImplementation implements PostService{

    @Autowired
    PostDao postDao;


    @Override
    public PostModel savePost(PostDTO postDTO) {
        PostModel  postModel = new PostModel();

        postModel.setProfile(postDTO.getProfile());
        postModel.setDescription(postDTO.getDescription());
        postModel.setTechnology(postDTO.getTechnology());
        postModel.setSalary(postDTO.getSalary());
        postModel.setType(postDTO.getType());
        postModel.setExperience(postDTO.getExperience());

       return postDao.save(postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postDao.findAll();
    }
}
