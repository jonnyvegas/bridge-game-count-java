package bridgegame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Hand.java
 * COMP 182
 * October 6, 2014
 * Prof. Putnam
 * This program will score a hand based on the rules of bridge with the input
 * coming from a file, which will be split into cards.
 * @author Jonathan Villegas
 */
public class Hand 
{
    //Maximum number of cards per suit.
    final int MAX_NUM_OF_CARDS = 13;
    private char[] clubs = new char[MAX_NUM_OF_CARDS];
    private char[] diamonds = new char[MAX_NUM_OF_CARDS];
    private char[] spades = new char[MAX_NUM_OF_CARDS];
    private char[] hearts = new char[MAX_NUM_OF_CARDS];
    private int numOfClubs = 0;
    private int numOfDiamonds = 0;
    private int numOfSpades = 0;
    private int numOfHearts = 0;
    private int score = 0;
    
    public Hand()
    {
        //Each hand will initialize 0, which means the slot is empty.
        for(int i = 0; i < MAX_NUM_OF_CARDS; i++)
        {
            clubs[i] = '0';
            diamonds[i] = '0';
            spades[i] = '0';
            hearts[i] = '0';
        }
    }
    
    //Adds a club to the club array.
    public void addClub(String theCard)
    {
        char rank = theCard.charAt(0);
        //Find out the value of the card based on the rank.
        int index = getValue(rank);
        clubs[index] = rank;
        numOfClubs++;
    }
    
    //Adds a diamond to the diamond array.
    //Precondition: theCard has the rank and the suit of the card.
    //Postcondition: the rank of theCard is added to the diamond array.
    public void addDiamond(String theCard)
    {
        char rank = theCard.charAt(0);
        //Find out the value of the card based on the rank.
        int index = getValue(rank);
        diamonds[index] = rank;
        numOfDiamonds++;
    }
    
    //Adds a spade to the spade array.
    //Precondition: theCard has the rank and the suit of the card.
    //Postcondition: the rank of theCard is added to the spade array.
    public void addSpade(String theCard)
    {
        char rank = theCard.charAt(0);
        //Find out the value of the card based on the rank.
        int index = getValue(rank);
        spades[index] = rank;
        numOfSpades++;
    }
    //Adds a heart to the heart array.
    //Precondition: theCard has the rank and the suit of the card.
    //Postcondition: the rank of theCard is added to the heart array.
    public void addHeart(String theCard)
    {
        char rank = theCard.charAt(0);
        //Find out the value of the card based on the rank.
        int index = getValue(rank);
        hearts[index] = rank;
        numOfHearts++;
    }
    
    //Prints the hand.
    public void printHand()
    {
        System.out.print("CLUBS: ");
        if(numOfClubs == 0)
        {
            System.out.println("");
        }
        else
        {
           System.out.print("      ");
           for(int i = 0; i < MAX_NUM_OF_CARDS; i++)
           {
               //If the char in the array is '0', the card doesn't exist.
               if(clubs[i] != '0')
               {
                   //If is it a T, we want to print 10 instead.
                   if(clubs[i] == 'T')
                   {
                       System.out.print("10" + " ");
                   }
                   else
                   {
                       System.out.print(clubs[i] + "  ");
                   }
                }
           }
           System.out.println("");
        }
        
        System.out.print("DIAMONDS: ");
        if(numOfDiamonds == 0)
        {
            System.out.println("");
        }
        else
        {
           System.out.print("  ");
           for(int i = 0; i < MAX_NUM_OF_CARDS; i++)
           {
               //If the char in the array is '0', the card doesn't exist.
               if(diamonds[i] != '0')
               {
                   //If the char is a T, we want to print 10.
                   if(diamonds[i] == 'T')
                   {
                       System.out.print("10" + " ");
                   }
                   else
                   {
                       System.out.print(diamonds[i] + "  ");
                   }
               }               
           }
           System.out.println("");
        }
        
        System.out.print("SPADES: ");
        if(numOfSpades == 0)
        {
            System.out.println("");
        }
        else
        {
           System.out.print("     ");
           for(int i = 0; i < MAX_NUM_OF_CARDS; i++)
           {
               //If the char in the array is '0', the card doesn't exist.
               if(spades[i] != '0')
               {
                   //If a T, we want to print a 10.
                   if(spades[i] == 'T')
                   {
                       System.out.print("10" + " ");
                   }
                   else
                   {
                       System.out.print(spades[i] + "  ");
                   }
               }               
           }
           System.out.println("");
        }
        System.out.print("HEARTS: ");
        if(numOfHearts == 0)
        {
            System.out.println("");
        }
        else
        {
           System.out.print("     ");
           for(int i = 0; i < MAX_NUM_OF_CARDS; i++)
           {
               //If the char in the array is '0', the card doesn't exist.
               if(hearts[i] != '0')
               {
                   //If the char is a T, print a 10.
                   if(hearts[i] == 'T')
                   {
                       System.out.print("10" + " ");
                   }
                   else
                   {
                       System.out.print(hearts[i] + "  ");
                   }
               }               
           }
           System.out.println("");
        }
    }
    
    /**
     * Gets the correct value based on the rank of the card.
     * Also adds the correct number to the score based on the card.
     * @param c The rank of the card as a character.
     * @return The value of the card.
     */
    public int getValue(char c)
    {
        if(c == 'A')
        {
            score = score + 4;
            return 0;
        }
        else if(c == 'K')
        {
            score = score + 3;
            return 1;
        }
        else if(c == 'Q')
        {
            score = score + 2;
            return 2;
        }
        else if(c == 'J')
        {
            score = score + 1;
            return 3;
        }
        else if(c == 'T')
        {
            return 4;
        }
        else if(c == '9')
        {
            return 5;
        }
        else if(c == '8')
        {
            return 6;
        }
        else if(c == '7')
        {
            return 7;
        }
        else if(c == '6')
        {
            return 8;
        }
        else if(c == '5')
        {
            return 9;
        }
        else if(c == '4')
        {
            return 10;
        }
        else if(c == '3')
        {
            return 11;
        }
        //c == '2'
        else
        {
            return 12;
        }
    }
    
    /**
     * Calculates the score based on what is in the hand.
     */
    public void calculateScore()
    {
        int numOfSuit = 0;
        //Go through each suit.
        for(int i = 0; i < 4; i++)
        {
            if(i == 0)
            {
                numOfSuit = numOfClubs;
            }
            else if(i == 1)
            {
                numOfSuit = numOfDiamonds;
            }
            else if(i == 2)
            {
                numOfSuit = numOfSpades;
            }
            else if(i == 3)
            {
                numOfSuit = numOfHearts;
            }
            //No cards in suit.
            if(numOfSuit == 0)
            {
                score = score + 3;
            }
            //Singleton.
            else if(numOfSuit == 1)
            {
                score = score + 2;
            }
            //Doubleton.
            else if(numOfSuit == 2)
            {
                score = score + 1;
            }
            //More than 5 in the hand.
            else if(numOfSuit > 5)
            {
                int scoreToAdd = numOfSuit - 5;
                score = score + scoreToAdd;
            }
        }
    }

    /**
     * Returns the score of the hand.
     * @return The score.
     */
    public int getScore()
    {
        return score;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {   
        try
        {
            Hand theHand = new Hand();
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            String str, str2;
            str = input.readLine();
            StringTokenizer cardList = new StringTokenizer(str, " ");
            while (cardList.hasMoreTokens())
            {
               str2 = cardList.nextToken();
               char suit = str2.charAt(1);
               if(suit == 'C')
               {
                   theHand.addClub(str2);
               }
               else if(suit == 'D')
               {
                   theHand.addDiamond(str2);
               }
               else if(suit == 'S')
               {
                   theHand.addSpade(str2);
               }
               else if(suit == 'H')
               {
                   theHand.addHeart(str2);
               }
            }

            theHand.printHand();
            theHand.calculateScore();
            int theScore = theHand.getScore();
            System.out.println("The score is: " + theScore);
        }
        catch(FileNotFoundException e)
        {
            String str;
            str = e.toString();
            System.out.println(str);
            System.out.println("The file was not found. Please check "
                    + "the name and try again.");
        }
        catch(IOException e)
        {
            String str;
            str = e.toString();
            System.out.println(str);
        }
    }
}
