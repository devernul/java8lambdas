package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, elem) -> acc+elem);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
    	//return artists.stream().map(a -> a.getName() + ":" + a.getNationality()).collect(toList());
    	return artists.stream().flatMap(a -> Stream.of(a.getName(), a.getNationality())).collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
    	return input.stream()
    			.filter((album -> album.getTrackList().size() < 4))
    			.collect(toList());
    }
    
    public static void main(String[] args){
    	List<String> list = Question1.getNamesAndOrigins(Arrays.asList(new Artist("A", "B"), new Artist("C", "D"), new Artist("E", "F")));
    	for(String s : list){
    		System.out.println(s);
    	}
    }
}
