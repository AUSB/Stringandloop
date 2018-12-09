Given	a	long	sentence,	find	all	its	words;	the	dis6nct	
ones	(regardless	of	case);	display	them;	sort	them;	
and	then	locate	the	longest	and	most	frequent	ones.
14	
A	"word"	is	defined	as	a	sequence	of	characters	terminated	by	
space,	punctua6on,	or	end-of-string.		
1. Use	split	with	a	regex	
2. Turn	array	to	a	collec

package com.example.practice;

import java.util.*;

public class WordSmith
{

    public static void main(String[] args)
    {
        // Start with a long sentence:
        // ---------------------------
        String line = "Hello, this is a long sentence. Find the longest word";
        line +=" in it; i.e. split it and find the longest. Also, find the most";
        line +=" frequently used word. Finally, show all words space deli`mited.";

        // Use split to btreak it into an array of words:
        // ----------------------------------------------
        String [] splitArr = line.split("[ .,;]+");
        System.out.println("Number of words = " + splitArr.length);
        for (int i = 0; i < splitArr.length; i++)
        {
            System.out.print(splitArr[i]+",");
        }
        System.out.println("\n");

        // Turn the array into a set (if you want the distinct ones):
        // ----------------------------------------------------------
        Set<String> set = new TreeSet<String>();
        for (String s : splitArr)
        {
            set.add(s.toLowerCase());
        }

        // Display the distinct words, sorted (because it is a TreeSet):
        // ------------------------------------------------------------
        System.out.println("Distinct word count = " + set.size());
        for (String s : set) System.out.print(s + " ");
        System.out.println("\n");

        // To find the longest word, do this:
        // ----------------------------------
        String longest = "";
        for (String s : set)
        {
            if (s.length() > longest.length()) longest = s;
        }
        System.out.println("The longest word is: " + longest + "\n");

        // To find the most frequent word in the original sentence.
        // We go back to the array rather than work with the set
        // because in a set, all words are distinct so there is no
        // notion of "most frequent". We will use a map that stores
        // distinct words along with their repetition counts.
        // --------------------------------------------------------
        Map<String,Integer> map = new TreeMap<String,Integer>();
        for (String s : splitArr)
        {
            s = s.toLowerCase();
            if (!map.containsKey(s)) // first encounter
            {
                map.put(s, 1);
            }
            else
            {
                int oldCount = map.get(s);
                int newCount = oldCount + 1;
                map.put(s, newCount);
            }
        }
        // Let's see the map:
        System.out.println("The word-count map:\n" + map);

        // now find the highest count value
        int repeats = 0;
        String frequent = "";
        for (String s : map.keySet())
        {
            int count = map.get(s);
            if (count >= repeats) // use > or >=
            {
                repeats = count;
                frequent = s;
            }
        }
        System.out.println("The most frequent word is: " + frequent);
        System.out.println("It repeats " + repeats + " times.");
        // Note: in case of a tie, this loop finds the last occuring one.
        // But if you replace >= with >, it finds the first occuring one.
    }
}
