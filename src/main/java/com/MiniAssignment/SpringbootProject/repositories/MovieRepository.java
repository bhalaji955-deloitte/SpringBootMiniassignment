package com.MiniAssignment.SpringbootProject.repositories;


import com.MiniAssignment.SpringbootProject.models.Movie;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public List<Movie> findAll() {
        return dynamoDBMapper.scan(Movie.class, new DynamoDBScanExpression());
    }

    public  Movie save(Movie movie){
        dynamoDBMapper.save(movie);
        return movie;
    }
    public Movie findById(String id) {
        return dynamoDBMapper.load(Movie.class, id);
    }


}

