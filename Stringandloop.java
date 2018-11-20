/*Implement	these	methods:
§ public	boolean isOdd(int	n)
Returns	true	if	n	is	odd	else	returns	false.
§ public	char	getFullGrade(int	mark)
Returns	the	full	le?er	grade	(A,B,C,D,E,F)	given
the	mark	(out	of	100)	in	a	course.
§ public	boolean isLeap(int	year)
Returns	true	if	the	year	is	a	leap	else	returns	false.
A	leap	year	is	divisible	by	4	and	if	it	is	divisible	by	100	then	it	must
also	be	divisible	by	400;	e.g.	2016	is,	2000	is,	but	2100	is	not.

Implement	these	methods:
§ public	boolean isPrime(int	n)
Returns	true	if	n	is	prime,	else	returns	false.
§ public	int	log2	(int	n)
Returns	the	number	of	repeated	division	of	n	by	2	un8l	the
result	of	the	division	is	1
§ public	double	factorial(int	n)
Returns	n!
§ public	double	oddRecipSum	(int	n)
Returns	the	sum	of	the	reciprocals	of	odd	integers	with
alterna8ng	signs	between	1	and	106	(should	around	π/4)*/



package com.example.lesperan.testbed.chapter3;

public class Examples {

    public static double factorial(int n){
        double result = 1;
        for (int i = 1; i <= n; i++){
            result = result * i;
        }
        return result;
    }

    public static boolean isPrime(int n){
        boolean result = true;
        for (int i = 2; result && i < n; i++){
            if (n % i == 0){
                result = false;
            }
        }
        return result;
    }

    public static int log2(int n){
        int result = 0;
        for (int r = n / 2; r > 0; r = r / 2){
            result++;
        }
        return result;
    }

    public static double oddRecipSum(int n){
        double result = 1;
        for (int i = 3; i <= n; i += 4){
            result -= 1.0 / i;
            result += 1.0 / (i + 2);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("factorial(5) returns " + Examples.factorial(5));
        System.out.println("isPrime(13) returns " + isPrime(13));
        System.out.println("isPrime(15) returns " + isPrime(15));
        System.out.println("log2(16) returns " + log2(16));
        System.out.println("log2(17) returns " + log2(17));
        System.out.println("oddRecipSum(1000000) returns " + oddRecipSum(1000000));
    }

}

/*In	a	class	with	a	String	aDribute	implement	these	features:
§ A	constructor	that	takes	a	string	parameter
Must	set	the	aDribute	accordingly.
§ public	String	get()	and	public	void	set(String	s)
Accessor	and	mutator.
§ public	int repeatCount(char	c)	and	(String	c)
Returns	the	number	of	-mes	c	occurs	in	the	state.
§ public	String	toDayName(int	d)
Returns	the	state	with	any	0-6	digit	replaced	with	Sun…Sat.
§ public	String	trimLeadingBlanks()
Returns	the	state	with	any	leading	spaces	removed.


Given	a	String	s,	write	a	fragment	that:
§ Mine	all	telephone	numbers	in	it.
§ Determines	if	s	has	a	person's	height	(expressed	in	feet
and	inches,	as	in	5'9")	imbedded	in	it.
§ Determines	the	largest	word	in	s.	We	define	a	word	as	a
sequence	of	non-space	characters.	Use	split.
§ Validates	that	s	represents	a	query	string.	These	are	used
in	web	applicasons.	They	begin	with	?	and	consist	of	one
or	more	var=value	clauses	delimited	by	&.
§ Validates	that	s	is	a	DNA	strand	(consists	of	A,C,G,T,	begins
with	ATG	and	its	length	is	divisible	by	3).	If	so,	output	the
most	frequent	amino	acid	in	it	(any	sequence	of	3	leDers).*/

package com.example.lesperan.testbed.chapter4;

import java.util.Objects;

public class ObjectWStringAttribute {
    private String att = "";

    public ObjectWStringAttribute(String input){
        this.att = input;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public int repeatCount(char c){
        int count = 0;
        for(int i = 0; i < this.att.length(); i++){
            if(this.att.charAt(i) == c){
                count++;
            }
        }
        return count;
    }

    public int repeatCount(String s){
        int count = 0;
        for(int pos = 0; this.att.indexOf(s,pos) >= 0; pos = this.att.indexOf(s,pos) + 1){
            count++;
        }
        return count;
    }

    public String toDayName(int d){
        final String convert = "0Sun1Mon2Tue3Wed4Thu5Fri6Sat";
        int pos = convert.indexOf("" + d);
        String day = convert.substring(pos+1,pos+4);
        return this.att.replaceAll("" + d, day);
    }

    public String trimLeadingBlanks(){
        String result = "";
        int i = 0;
        for(; i < this.att.length() && this.att.charAt(i) == ' '; i++);
        result = this.att.substring(i);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectWStringAttribute that = (ObjectWStringAttribute) o;
        return this.att.equals(that.getAtt());
    }

    @Override
    public String toString() {
        return "ObjectWStringAttribute{" +
                "att='" + att + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ObjectWStringAttribute o =
                new ObjectWStringAttribute("    Hi. Today is 1.");
        System.out.println("o.getAtt() returns " + o.getAtt());
        o.setAtt(o.getAtt() + " It is a rainy day");
        System.out.println("o.getAtt() returns " + o.getAtt());
        System.out.println("o.repeatCount('i') returns " + o.repeatCount('i'));
        System.out.println("o.repeatCount(\"is\") returns " + o.repeatCount("is"));
        System.out.println("o.toDayName(1) returns " + o.toDayName(1));
        System.out.println("o.trimLeadingBlanks() returns " + o.trimLeadingBlanks());
    }
}


/*A	constructor	that	takes	a	string	parameter
Must	set	the	aDribute	accordingly.
§ public	String	get()	and	public	void	set(String	s)
Accessor	and	mutator.
§ public	int repeatCount(char	c)	and	(String	c)
Returns	the	number	of	-mes	c	occurs	in	the	state.
§ public	String	toDayName(int	d)
Returns	the	state	with	any	0-6	digit	replaced	with	Sun…Sat.
§ public	String	trimLeadingBlanks()
Returns	the	state	with	any	leading	spaces	removed.

Given	a	String	s,	write	a	fragment	that:
§ Mine	all	telephone	numbers	in	it.
§ Determines	if	s	has	a	person's	height	(expressed	in	feet
and	inches,	as	in	5'9")	imbedded	in	it.
§ Determines	the	largest	word	in	s.	We	define	a	word	as	a
sequence	of	non-space	characters.	Use	split.
§ Validates	that	s	represents	a	query	string.	These	are	used
in	web	applicasons.	They	begin	with	?	and	consist	of	one
or	more	var=value	clauses	delimited	by	&.
§ Validates	that	s	is	a	DNA	strand	(consists	of	A,C,G,T,	begins
with	ATG	and	its	length	is	divisible	by	3).	If	so,	output	the
most	frequent	amino	acid	in	it	(any	sequence	of	3	leDers).*/

package com.example.lesperan.testbed.chapter4;

import java.util.regex.*;

public class RegexExamples {

    public static boolean hasPostalCode(String s) {
        String regex = "[A-Za-z]\\d[A-Za-z][ ]?\\d[A-Za-z]\\d";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        return myMatcher.find();
    }

    public static void printAllPostalCodes(String s) {
        String regex = "[A-Za-z]\\d[A-Za-z][ ]?\\d[A-Za-z]\\d";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        for (; myMatcher.find(); ) {
            System.out.println(s.substring(myMatcher.start(), myMatcher.end()));
        }
    }

    public static void printAllDigitsInAllPostalCodes(String s) {
        String regex = "[A-Za-z](\\d)[A-Za-z][ ]?(\\d)[A-Za-z](\\d)";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        for (; myMatcher.find(); ) {
            for (int grp = 1; grp <= myMatcher.groupCount(); grp++) {
                System.out.println(myMatcher.group(grp));
                System.out.println(s.substring(myMatcher.start(), myMatcher.end()));
            }
        }
    }

    public static void printAllPhoneNumbers(String s) {
        String regex = "[1-9]\\d\\d\\-\\d\\d\\d\\d";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        for (; myMatcher.find(); ) {
            System.out.println(s.substring(myMatcher.start(), myMatcher.end()));
        }
    }

    public static boolean hasHeight(String s) {
        String regex = "\\d\'(\\d|1[01])";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        return myMatcher.find();
    }

    public static String largestWordIn(String s) {
        String regex = "\\s+";
        String[] words = s.split(regex);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            // System.out.println(words[i]); // uncomment to print all words found
            if (words[i].length() > result.length()) {
                result = words[i];
            }
        }
        return result;
    }

    public static boolean isValidQueryString(String s) {
        String regex = "^\\?[a-zA-Z]+=[^\\&]+(\\&\\&[a-zA-Z]+=[^\\&]+)*$";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        return myMatcher.find();
    }

    public static boolean isValidDNA(String s) {
        String regex = "^ATG([ACGT][ACGT][ACGT])*$";
        Pattern myPattern = Pattern.compile(regex);
        Matcher myMatcher = myPattern.matcher(s);
        return myMatcher.find();
    }

    public static String mostFrequentAminoAcid(String s){
        String mostFreqAA = "ATG";
        int mostFreqAACount = 1;
        for (int i = 3; i < s.length(); i += 3){
            if (s.substring(i,i+3).equals(mostFreqAA)){
                mostFreqAACount++;
            }
        }
        for (int i = 3; i < s.length(); i += 3){
            String currentAA = s.substring(i,i+3);
            int currentAACount = 0;
            for (int j = 0; j < s.length(); j += 3){
                if (s.substring(j,j+3).equals(currentAA)){
                    currentAACount++;
                }
            }
            if (currentAACount > mostFreqAACount){
                mostFreqAA = currentAA;
                mostFreqAACount = currentAACount;
            }
        }
        return mostFreqAA;
    }

    public static void main(String[] args) {
        String s1 = "York University EECS is at M3J 1P3.  Their number is 736-5053.  Their fax number is 736-5872.  Glendon College is located at m4n3m6.";
        System.out.println("s1 is \"" + s1 + "\"");
        System.out.println("\nhasPostalCode(s1) returns " + hasPostalCode(s1));
        System.out.println("\nCalling printAllPostalCodes(s1) produces");
        printAllPostalCodes(s1);
        System.out.println("\nCalling printAllDigitsInAllPostalCodes(s1) produces");
        printAllDigitsInAllPostalCodes(s1);
        System.out.println("\nCalling printAllPhoneNumbers(s1) produces");
        printAllPhoneNumbers(s1);
        System.out.println("\nhasHeight(\"I an 5'6\".\") returns " + hasHeight("I an 5'6\"."));
        System.out.println("hasHeight(\"I an tall.\") returns " + hasHeight("I an tall."));
        System.out.println("\nlargestWordIn(s1) returns " + largestWordIn(s1));
        System.out.println("\nisValidQueryString(\"?abc=3adef5&&ghi=456\") returns " + isValidQueryString("?abc=3adef5&&ghi=456"));
        System.out.println("isValidQueryString(\"?abc=3adef5&&ghi=\") returns " + isValidQueryString("?abc=3adef5&&ghi="));
        System.out.println("\nisValidDNA(\"ATGGAT\") returns " + isValidDNA("ATGGAT"));
        System.out.println("isValidDNA(\"ATGGA\") returns " + isValidDNA("ATGGA"));
        System.out.println("\nmostFrequentAminoAcid(\"ATGGATAGTGAT\") returns " + mostFrequentAminoAcid("ATGGATAGTGAT"));
    }
}


package com.example.lesperan.testbed.chapter5;

import java.util.Date;
import java.util.Random;

/*
 * If we pick an integer in [1,1M] randomly, how likely is it to get one whose digit sum is divisible by 7?
 *
 * Compute the probability by sampling 10% of those integers and store the sample in a collection.
 *
 * Here we use an array to represent the collection.
 */
public class SumDiv7_Array
{
    private int population;  // population size
    private int sample;  // sample size
    private Random rng;
    private int count;  // count of samples meeting criterion
    private int[] bag;  // random sample set

    public SumDiv7_Array(int population, double samplingPercentage)
    {
        this.population = population;
        this.sample = (int) (population * samplingPercentage);
        this.rng = new Random();
        this.count = 0;
        this.bag = new int[this.sample + 1]; // create array
    }

    public void simulate()
    {
        for (int i = 0; i < this.sample; i++)
        {
            // pick a distinct int from population
            // if it fits the criterion, count it
            int n = pickDistinct();
            this.bag[i] = n;  // store sample in array
            int sum = digitSum(n);
            if (sum % 7 == 0) this.count++;  // if it meets criterion, count it
        }
    }

    private int pickDistinct()
    {
        int n;
        do
        {
            n = 1 + rng.nextInt(this.population);
        } while (contains(this.bag, this.count, n));
        return n;
    }

    // return true or false depending on whether x is in ar
    private boolean contains(int[] ar, int size, int x)
    {
        boolean found = false;
        for (int i = 0; (i < size) && !found; i++)
        {
            found = (ar[i] == x);
        }
        return found;
    }

    // return the sum of the digits of x
    private int digitSum(int x)
    {
        int sum = 0;
        for (int r = x; r != 0; r = r / 10)
        {
            int digit = r % 10;
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        long start = (new Date()).getTime();

        SumDiv7_Array var = new SumDiv7_Array(1000000, .1);
        var.simulate();
        System.out.println("Probalility of meeting criterion is " + var.count / (double) var.sample);
        System.out.println("Sample is ");
        for (int i = 0; i < var.count; i++)
        {
            System.out.print(var.bag[i] + " ");
        }

        long finish = (new Date()).getTime();

        System.out.println("\nRunning time was " + (finish-start) + " ms.");


    }
}
