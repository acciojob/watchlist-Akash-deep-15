package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository mr;

    public void addMovie(Movie m) {
        mr.addMovie(m);
    }

    public void addDirector(Director d){
    mr.addDirector(d);
    }

    public void makePair(String mName, String dName) {
        mr.makePair(mName, dName);
    }

    public Movie returnMovie(String mName) {
        return mr.getMovie(mName);
    }

    public Director returnDirector(String dName) {
        return mr.getDirector(dName);
    }

    public List<String> getByDirector(String name) {
        return mr.getByDirector(name);
    }

    public List<String> allMovies() {
        return mr.allMovies();
    }

    public void deleteDirector(String name) {
        mr.deleteDirector(name);
    }

    public void deleteAllMovies() {
        mr.deleteALlMovies();
    }

}
