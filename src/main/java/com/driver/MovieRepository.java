package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
@Component
public class MovieRepository {

    HashMap<String,Movie> moviesmap = new HashMap<>();
    HashMap<String,Director> directormap =  new HashMap<>();
    HashMap<String, ArrayList<String>> pairmap = new HashMap<>();


    public void addMovie(Movie m) {        // adding movie..
        moviesmap.put(m.getName(),m);
    }

    public void addDirector(Director d) {           // adding director..
        directormap.put(d.getName(),d);
    }

    public void makePair(String mName, String dName) {
        if(moviesmap.containsKey(mName) && directormap.containsKey(dName)) {
            ArrayList<String> movieList = new ArrayList<>();
            movieList = pairmap.get(dName);
            movieList.add(mName);
            pairmap.put(dName, movieList);
        }
    }

    public Movie getMovie(String mName) {
        return moviesmap.get(mName);
    }

    public Director getDirector(String dName) {
        return directormap.get(dName);
    }

    public List<String> getByDirector(String name) {
        List<String> resList = new ArrayList<>();

        if(pairmap.containsKey(name))
        resList =  pairmap.get((name));

        return resList;
    }

    public List<String> allMovies() {
        List<String> allList = new ArrayList<>();

        for(String i: moviesmap.keySet()) {
            allList.add(i);
        }
        return allList;
    }

    public void deleteDirector(String name) {

        ArrayList<String> list = new ArrayList<>();

        if(pairmap.containsKey(name)) {
            list = pairmap.get(name);

            for(String i: list) {
                if(moviesmap.containsKey(i))
                    moviesmap.remove(i);
            }

            pairmap.remove(name);
        }

        if(directormap.containsKey(name))
            directormap.remove(name);
    }

    public void deleteALlMovies() {

        HashSet<String> movies = new HashSet<>();

        for(String directors: pairmap.keySet()) {
            for(String movie: pairmap.get(directors)) {
                movies.add(movie);
            }
        }

        for(String i: movies) {
            if(moviesmap.containsKey(i)) {
                moviesmap.remove(i);
            }
        }

    }


}
