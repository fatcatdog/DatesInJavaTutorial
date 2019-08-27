package finished;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FinishedDailyPractice {
	
	//creating a date formater for help manipulating date objects in the future
    private static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Lets print today's date object without any type of manipulation: ");
		
		//here we are declaring all of our variables 
		
		//i didnt label these variables very specifically which is a bad practice,
		//in general your variable names should have some additional logic in them 
		//to assist new users of your code
		
		Date date;
		Calendar c;
		Date tomorrowDatePlusOne;
		Date previousDatePlusOne;
		String userinput;
		int yearsAlive;
		Date ourBirthdayDateObject;
		Long todayInMillis;
		Long ourBirthdayDateObjectInMillis;
		Long millisecondsAliveSinceBirth;
		int daysAlive;
		Calendar cal;
		Date ourNextBirthday;
		Long ourNextBirthdayDateObjectInMillis;
        int daysUntilBday;
        
        //using our first date object
        
		date = new Date(); 
		
//		System.out.println("Our raw date is: " + date);
//		
//		System.out.println("Our formatted date is: " + dateFormat.format(date));
//
//		System.out.println("Lets try get tomorrow date printed:");
		
		//lets use our calendar util package
		
		//by creating a calendar we can use all of the calender helper methods like .get(Calendar.YEAR)
        c = Calendar.getInstance();
        
        //adding one day to totoday's date
        c.add(Calendar.DATE, 1);

        //turning tomorrow's date object into mills
        tomorrowDatePlusOne = c.getTime();

//       System.out.println("Tomorrow's date is: " + dateFormat.format(tomorrowDatePlusOne));	
        
        //subtracting two days from calendar object to get yesterday's date (remmeber we already added one date)
        c.add(Calendar.DATE, -2);

        //turning date into ms
        previousDatePlusOne = c.getTime();

//      System.out.println("Yesterday's date is: " + dateFormat.format(previousDatePlusOne));
		
        System.out.println("Lets get user input");
        
        //importing a scanner to get user input 
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter your birth date as mm/dd/yyyy");
        
        //using our scanner 
        userinput = scanner.nextLine();
        
        System.out.println("User inputted birthday: " + userinput);
        
        //this is just a string, so we can provide as much user input validation here as we want
        
        String[] words = userinput.split("/");
        
        //this could be much improved, but this just checks that something like XXXXX/XXXXXX/XXXXX was inputted
        
        if(words.length != 3) {
        	System.out.println("Sorry invalid input...");
        	return;
        }
        
//        System.out.println("Our array is: " + words);
//        
//        for(int i = 0; i < words.length; i++) {
//        	System.out.println(words[i]);
//        }
        
        //getting our user inputted year 
        yearsAlive =  c.get(Calendar.YEAR) - Integer.parseInt(words[2]);
        
        System.out.println("years alive: " + yearsAlive);
        
        //creating a date object from user input 
        ourBirthdayDateObject = dateFormat.parse(userinput);
        
        System.out.println("Your birthday is: " + ourBirthdayDateObject);
        
        //Now lets do some manipulation to get how many days we have been alive, and how many days until our birthday

        try {
        	
        	//today in mils (amount of mls - January 1, 1970, 00:00:00 GTM )
            todayInMillis = date.getTime();

//            System.out.println("today in millis: " + todayInMillis);

            //getting our birthday in mils
             ourBirthdayDateObjectInMillis = ourBirthdayDateObject.getTime();
            
//            System.out.println("birthday in millis: " + ourBirthdayDateObjectInMillis);
            
            //getting mils difference between birthdate and todays date
            
             millisecondsAliveSinceBirth = todayInMillis - ourBirthdayDateObjectInMillis;
            
            //getting an int amount of days from our mils
             daysAlive = (int) (millisecondsAliveSinceBirth / (1000*60*60*24));
            
            System.out.println("You've been alive for " + daysAlive + " days :)");
            
            //importing a new calendar object to do some additional manipultation to get next years birthday
             cal = Calendar.getInstance();
           
            cal.setTime(ourBirthdayDateObject);
            
            //adding how many years alive + 1 (next birthday's year)
            cal.add(Calendar.YEAR, (yearsAlive + 1));
            
            //creating a date object from our calendar object 
             ourNextBirthday = cal.getTime();
            
            System.out.println("Next birthday: " + ourNextBirthday);
            
            //creating a mils amount from our date object 
             ourNextBirthdayDateObjectInMillis = ourNextBirthday.getTime();
            
//            System.out.println("next milis: " + ourNextBirthdayDateObjectInMillis);
            
//            System.out.println("today in milis: " + todayInMillis);
            
            //getings days until bday by next birthday in mils - today in mils / math to turn mils into days
             daysUntilBday = (int) ((ourNextBirthdayDateObjectInMillis - todayInMillis) / (1000*60*60*24));

            System.out.println("Day's until birthday: " + daysUntilBday + " :)");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

}
