package edu.nyu.cs;

import java.util.Scanner;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    
    System.out.println("Welcome to blackjack!");
    int c1 = drawCard();
    int c2 = drawCard();
    System.out.println("Your cards are: " + (c1) + " and " + (c2));
    if ((c1 + c2)==21) {
      System.out.println("Blackjack! You win!");
    }
    if ((c1 + c2)==22) {
      System.out.println("You have bust?");
    }
    System.out.println("Would you like to hit or stand?");
    Scanner scn = new Scanner(System.in);
    String input = scn.nextLine();
    int myTotal = c1 + c2;
    String mySum = "Your cards are: " + (c1) + ", " + (c2) + ", ";
    int newCard = drawCard();
    if (input.equals("stand")) {
      dealerHit(myTotal, ("Your cards are: " + (c1) + " and " + (c2)));
    }
    while (input.equals("hit")) {
      newCard = drawCard();
      String statement = mySum + "and " + newCard;
      System.out.println(statement);
      mySum = (mySum) + (newCard) + ", ";
      myTotal = myTotal + newCard;
      if (myTotal==21) {
        System.out.println("Blackjack!");
        System.out.println("You win!");
        break;
      }
      if (myTotal>21) {
        System.out.println("You have bust!");
        System.out.println("Dealer wins!");
        break;
      }
      else {
        System.out.println("Would you like to hit or stand?");
        input = scn.nextLine();
      }

    if (input.equals("stand")) {
      dealerHit(myTotal, (statement));
    }
  }

scn.close();


  } // main
  public static int drawCard() {
    double draw = Math.round(Math.floor(Math.random() *(10) + 2));
    int card = (int)(Math.round(draw));
    return card;
  }

  public static void dealerHit(int t, String s) {
    int d1 = drawCard();
    int d2 = drawCard();
    int nextCard = drawCard();
    int dealerTotal = d1 + d2;
    String dSummary = "The dealer's cards are: " + (d1) + ", " + (d2) + ", ";
    String finalSum = "The dealer's cards are: " + (d1) + ", " + (d2) + ", ";
    if (dealerTotal>21) {
      System.out.println(s);
      System.out.println(finalSum);
      System.out.println("The dealer has bust!");
      System.out.println("You win!");
    }
    if (dealerTotal>=17) {
      System.out.println("The dealer stands.");
      System.out.println(s);
      System.out.println("The dealer's cards are: " + (d1) + " and " + (d2));
      if (dealerTotal==21) {
        System.out.println("Blackjack!");
        System.out.println("Dealer wins!");
      }
      else if (dealerTotal>t) {
        System.out.println("Dealer wins!");
      }
      else if (dealerTotal<t) {
        System.out.println("You win!");
      }
      else if (dealerTotal==t) {
        System.out.println("Tie!");
    }
  }
    while (dealerTotal<=16) {
      System.out.println("The dealer hits.");
      nextCard = drawCard();
      finalSum = (dSummary) + "and " + nextCard;
      dSummary = (dSummary) + (nextCard) + ", ";
      dealerTotal = dealerTotal + nextCard;
      if (dealerTotal>21) {
        System.out.println(s);
        System.out.println(finalSum);
        System.out.println("The dealer has bust!");
        System.out.println("You win!");
        break;
      }
      else if (dealerTotal==21) {
        System.out.println(s);
        System.out.println(finalSum);
        System.out.println("Dealer wins!");
        break;
      }
      else if (dealerTotal>t) {
        System.out.println(s);
        System.out.println(finalSum);
        System.out.println("Dealer wins!");
        break;
      }
      else {
      if (dealerTotal>=17) {
        System.out.println("The dealer stands.");
        System.out.println(s);
        System.out.println(finalSum);
        if (dealerTotal>t) {
          System.out.println("Dealer wins!");
        }
        else if (dealerTotal<t) {
          System.out.println("You win!");
        }
        else if (dealerTotal==t) {
          System.out.println("Tie!");
        }
      }
      }
    }

  }
  }


