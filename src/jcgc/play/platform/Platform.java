package jcgc.play.platform;

import jcgc.play.content.*;
import jcgc.play.exception.MovieExistException;
import jcgc.play.util.FileUtils;

import java.util.*;

public class Platform {
    private String name;
    private List<Content> contents;
    private Map<Content, Integer> moviesMapViews;

    public Platform(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
        this.moviesMapViews = new HashMap<>();
    }

    public void addMovie(Content content) {

        Content movieContent = this.lookForTitle(content.getTitle());

        if (movieContent != null) {
            throw new MovieExistException(content.getTitle());
        }

        FileUtils.writeContent(content);
        this.contents.add(content);
    }

    public void playMovie(Content content) {
        int actualCounter = moviesMapViews.getOrDefault(content, 0);
        System.out.println(content.getTitle() + " has been played " +  actualCounter + " times.");

        this.viewerCounter(content);
        content.play();
    }

    private void viewerCounter(Content content) {
        int actualCounter = moviesMapViews.getOrDefault(content, 0);
        moviesMapViews.put(content, actualCounter + 1);
    }

    public List<String> showTitles() {
        return contents.stream()
                .map(Content::getTitle)
                .toList();
    }

    public List<SummaryContent> getSummaryContents() {
        return contents.stream()
                .map(mc -> new SummaryContent(mc.getTitle(), mc.getDuration(), mc.getGenre()))
                .toList();
    }

    public void deleteMovie(Content content) {
        this.contents.remove(content);
    }

    public Content lookForTitle(String title) {
        return contents.stream()
                .filter(movieContent -> movieContent.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Content> lookForGenre(Genre genre) {
        return contents.stream()
                .filter(movieContent -> movieContent.getGenre().equals(genre))
                .toList();
    }

    public int getTotalDuration() {
        return contents.stream()
                .mapToInt(Content::getDuration)
                .sum();
    }

    public List<Content> getPopularMovies(int quantity) {
        return contents.stream()
                .sorted(Comparator.comparing(Content::getScore).reversed())
                .limit(quantity)
                .toList();
    }

    public List<Movie> getAllMovies() {
        return contents.stream()
                .filter(Movie.class::isInstance)
                .map(Movie.class::cast)
                .toList();
    }

    public List<Documental> getAllDocumentals() {
        return contents.stream()
                .filter(Documental.class::isInstance)
                .map(Documental.class::cast)
                .toList();
    }

    public List<Promocionable> getAllPromocionables() {
        return contents.stream()
                .filter(content -> content instanceof Promocionable)
                .map(contenidoProm -> (Promocionable) contenidoProm)
                .toList();
    }

    public String getName() {
        return name;
    }

    public List<Content> getContents() {
        return contents;
    }
}
