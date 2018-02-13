import java.util.Scanner;

public class Blackjack {
    public static void main(String[]args) {

        Scanner scnr = new Scanner(System.in);
        P1Random rng = new P1Random();              //calls the random number generator
        int myNumber = 0;
        int dealerHand = 0;
        boolean gameNumber = true;
        float playerWins = 0;
        int dealerWins = 0;
        int ties = 0;

        int gameNum = 1;
        while (gameNumber == true) {             //loops game until 4 is pressed

            System.out.println("START GAME #" + gameNum);
            System.out.println("");
            gameNum++;
            boolean playingHand = true;
            int hand = 0;
            while(playingHand) {                   //loops new cards
                myNumber = rng.nextInt(13) + 1;

                switch (myNumber) {

                    case 1:
                        System.out.println("Your card is a ACE!");
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand );
                        System.out.println("");
                        break;

                    case 11:
                        System.out.println("Your card is a JACK!");
                        myNumber =10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println("");
                        break;

                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        myNumber =10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println("");
                        break;

                    case 13:
                        System.out.println("Your card is a KING!");
                        myNumber =10;
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Your card is a " + myNumber + "!");
                        hand += myNumber;
                        System.out.println("Your hand is: " + hand);
                        System.out.println("");

                }
                if(hand == 21){
                    System.out.println("BLACKJACK! You win!");
                    System.out.println("");
                    playerWins += 1;
                    break;
                }
                else if(hand > 21){
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println("");
                    dealerWins += 1;
                    break;
                }
                boolean showingOptions = true;
                int choice=0;
                while(showingOptions) {
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println("");
                    System.out.println("Choose an option: ");

                    choice = scnr.nextInt();
                    if (choice < 1 || choice > 4) {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        System.out.println("");
                    } else if (choice == 1) {                  //prints another card
                        playingHand = true;
                        showingOptions = false;
                    } else if (choice == 2) {
                        dealerHand = rng.nextInt(11) + 16;                                      //tells who wins
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);
                        if (hand == 21) {
                            System.out.println("BLACKJACK! You win!");
                            System.out.println("");
                            playerWins += 1;
                        } else if (hand > 21) {
                            System.out.println("You exceeded 21! You lose.");
                            dealerWins +=1;
                        } else if (hand == dealerHand) {
                            System.out.println("");
                            System.out.println("It's a tie! No one wins!");
                            ties += 1;
                        } else if (hand > dealerHand) {
                            System.out.println("You win!");
                            playerWins +=1;
                        } else if (hand < dealerHand && dealerHand <= 21) {
                            System.out.println("");
                            System.out.println("Dealer wins!");
                            dealerWins += 1;
                        }
                        else if(hand < dealerHand && dealerHand >21) {
                            System.out.println("");
                            System.out.println("You win!");
                            playerWins += 1;
                        }
                        System.out.println("");
                        playingHand = false;
                        showingOptions = false;
                    } else if (choice == 3) {               //data is recorded as it goes and printed here
                        playingHand = true;
                        showingOptions = true;
                        System.out.println("Number of Player wins: " + (int) playerWins);
                        System.out.println("Number of Dealer wins: " + dealerWins);
                        System.out.println("Number of tie games: " + ties);
                        float totalGame = playerWins + dealerWins + ties;                                  //tally's the total number of games
                        float percentWin = 100 * (playerWins / totalGame);                                //divides wins by total number of games to create percentage
                        String percentWinAsString = String.format("%.1f", percentWin);
                        System.out.println("Total # of games played is: " + (int) totalGame);
                        System.out.print("Percentage of Player wins: " + percentWinAsString + "%");
                        System.out.println("");
                    } else if (choice == 4) {                                 //ends loop, ends program
                        playingHand = false;
                        gameNumber = false;
                        showingOptions = false;
                    }
                }
            }
        }
    }

}
