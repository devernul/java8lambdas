package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/** A Performance by some musicians - eg an Album or Gig. */
public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
    	//return getMusicians().flatMap(a -> { if(a.isSolo()) return Stream.of(a); else return Stream.concat(Stream.of(a), a.getMembers());});
    	//return getMusicians().flatMap(a -> { return Stream.concat(Stream.of(a), a.getMembers());});
    	return getMusicians().flatMap(a -> concat(Stream.of(a), a.getMembers()));
    }
}
