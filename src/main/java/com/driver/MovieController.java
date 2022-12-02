package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService ms;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie m) {
        ms.addMovie(m);
        return new ResponseEntity("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addMovie(@RequestBody Director d) {
        ms.addDirector(d);
        return new ResponseEntity("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String mName, @RequestParam String dName) {
        ms.makePair(mName, dName);
        return new ResponseEntity("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie>  getMovieByName(@PathVariable("name") String name) {
        return new ResponseEntity(ms.returnMovie(name), HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirector(@PathVariable("name") String name) {
        return new ResponseEntity(ms.returnDirector(name), HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>>  getMoviesByDirectorName(@PathVariable("director") String name) {
        return new ResponseEntity(ms.getByDirector(name), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return new ResponseEntity(ms.allMovies(), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name) {
        ms.deleteDirector(name);
        return new ResponseEntity(name + " removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity deleteAllDirectors() {
        ms.deleteAllMovies();
        return new ResponseEntity("All directors deleted successfully", HttpStatus.CREATED);
    }
}
