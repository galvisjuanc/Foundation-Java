package jcgc.play.exception;

public class MovieExistException extends RuntimeException{

    public MovieExistException(String title){
        super("The movie " + title + " does exist in the platform.");
    }
}
