package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Question2 {
    // Q3
    public static int countBandMembersInternal(List<Artist> artists) {
    	/* Replace the following external iteration to internal.
        int totalMembers = 0;
        for(Artist a : artists){
        	Stream<Artist> members = a.getMembers();
        	totalMembers += members.count();
        }
        
        return totalMembers;
        */
    	
    	//One alternative
    	//artists.stream().map(a -> a.getMembers().count())
    	//.reduce(0L, (acc, i) -> acc + i)
    	//.intValue();
    	
    	
    	return artists.stream()
    			.flatMap(artist -> artist.getMembers())
    			.collect(toList())
    			.size();
    }
}
