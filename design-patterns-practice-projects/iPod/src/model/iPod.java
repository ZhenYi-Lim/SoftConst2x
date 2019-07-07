package model;

import model.media.AbstractMedia;
import model.media.Movie;
import model.media.Photo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class iPod implements Iterable<AbstractMedia> {

    private String name;
    private Collection<AbstractMedia> movies;
    private Collection<AbstractMedia> photos;
    private Collection<AbstractMedia> songs;
    // TODO: add fields here which represent this iPod's Movies, Photos, and Songs, they should be of the Collection type

    public iPod(String name) {
        this.name = name;
        movies = new HashSet<>();
        photos = new HashSet<>();
        songs = new HashSet<>();
    }

    // getters
    public String getName() { return name; }

    public void addMedia(AbstractMedia media) {
        if (media instanceof Movie) {
            movies.add(media);
        } else if (media instanceof Photo) {
            photos.add(media);
        } else {
            songs.add(media);
        }
    }

    @Override
    public Iterator<AbstractMedia> iterator() {
        return new AbstractMediaIterator();
    }

    private class AbstractMediaIterator implements Iterator<AbstractMedia> {
        Iterator<AbstractMedia> movieIterator = movies.iterator();
        Iterator<AbstractMedia> photoIterator = photos.iterator();
        Iterator<AbstractMedia> songIterator = songs.iterator();

        @Override
        public boolean hasNext() {
            return movieIterator.hasNext() || photoIterator.hasNext() || songIterator.hasNext();
        }

        @Override
        public AbstractMedia next() {
            if (movieIterator.hasNext()) {
                return movieIterator.next();
            } else if (photoIterator.hasNext()) {
                return photoIterator.next();
            } else {
                return songIterator.next();
            }
        }
    }
}