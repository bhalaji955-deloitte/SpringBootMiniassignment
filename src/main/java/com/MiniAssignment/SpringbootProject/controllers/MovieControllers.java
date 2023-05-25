package com.MiniAssignment.SpringbootProject.controllers;

import com.MiniAssignment.SpringbootProject.models.Movie;
import com.MiniAssignment.SpringbootProject.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieControllers {

    private static Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieService movieservice;
    @PostMapping("/importCsv")
    public List<Movie>importCsv(){
        return movieservice.readCsv();
    }
    @GetMapping
    public List<Movie> findAll(){
        logger.info("findAll books " + this.getClass().getName());
        return movieservice.findAll();
    }
    @PostMapping
    public Movie save(@RequestBody Movie movie){
        logger.info("save book " + this.getClass().getName());
        return movieservice.save(movie);
    }
    @GetMapping("/{id}")
    public Movie findById(@PathVariable(value = "id") String id){
        logger.info("find book by id" + this.getClass().getName());
        return movieservice.findById(id);
    }
    @GetMapping("/director/{director}/year-range/{startYear}/{endYear}")
    public List<String> getMoviesByDirectorAndYearRange(@PathVariable String director,
                                                          @PathVariable int startYear,
                                                          @PathVariable int endYear) {
        return movieservice.getdirector(director, startYear, endYear);
    }
    @GetMapping("/english-titles")
    public List<String> getEnglishMoviesWithUserReviewsGreaterThan(
    @RequestParam int userReviewFilter){
        return  movieservice.getEnglishTitlesWithUserReviewsGreaterThan(userReviewFilter);
    }
    @GetMapping("/highest-budget")
    public List<String> getHighestBudgetMoviesForYearAndCountry(
     @RequestParam String year, @RequestParam String country) {
            return movieservice.    getHighestBudgetTitlesForYearAndCountry(year,country);
        }
}
