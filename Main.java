package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Random rand = new Random();
        //1 = Spade, 2 = Heart, 3 = Clover, 4 = Diamond
	    int [] hand = {23,45,12,4,32};
//        System.out.println(face(23));
//	    System.out.println(suit(14));
//	    System.out.println(cardToString(52));
//	    int hello= rand.nextInt(52);
//	    int[] deck = createShuffledDeck();
//	    System.out.println(nextCard(deck));
//	    print(deck);
//	    System.out.println(cardsToString(hand));
//        task8();
//        System.out.println(bestPokerHand(hand));
//        System.out.println(pokerHand(bestPokerHand(hand)));
        play();
    }

    public static void print(int[] rv){
        for(int i = 0; i < rv.length; i++){
            System.out.print(cardToString(rv[i]) + " ");
        }
    }

    //Create a function that takes an int card (1-52), and returns its face. You should return an int from 1-13 where:
    //1 = A, 2 = 2, 3 = 3, ... , 10 = 10, 11 = J, 12 = Q, 13 = K.
    public static int face(int card){
        return card % 13;
    } // Exit face()

    //Create a function that takes an int card (1-52), and returns its suit. You should return an int from 1-4 where:
    //1 = Spade, 2 = Heart, 3 = Clover, 4 = Diamond
    public static int suit(int card){
        if(card <= 13){
            return 1;
        }
        if(card <= 26){
            return 2;
        }
        if(card <= 39){
            return 3;
        }
        if(card <= 52){
            return 4;
        }
        return 0;
    } // Exit suit()

    //Create a function that takes an int card (1-52), and returns a nice looking String.
    //Use A, J, Q, K for face. Because we want cards to be 2 letters, the 10 presents a problem. Use X instead of 10.
    public static String cardToString(int card){
        String rv = "";
        if(suit(card) == 1){
            rv += "S";
        }
        if(suit(card) == 2){
            rv += "H";
        }
        if(suit(card) == 3){
            rv += "C";
        }
        if(suit(card) == 4){
            rv += "D";
        }
        int num = card % 13;
        if(num == 0){
            rv+="K";
        }
        else if(num == 1){
            rv += "A";
        }
        else if(num <= 9){
            rv += num;
        }
        else if(num == 10){
            rv += "X";
        }
        else if(num==11){
            rv += "J";
        }
        else if(num == 12){
            rv += "Q";
        }
        return rv;
    } // Exit cardToString()

    //Create a function that takes an int[] of cards, and returns a nice looking String.
    // If the int[] is null, return "[]".
    public static String cardsToString(int[] cards){
        if(cards == null){
            return "[]";
        }
        String rv = "[";
        for(int i = 0; i < cards.length; i++){
            rv += cardToString(cards[i]) + ", ";
        }
        return rv.substring(0,rv.length()-2) + "]";
    } // Exit cardsToString()

    //Create a function that takes a 52 element int[] of cards called deck, and shuffles it.
    //Swap each card in the deck with another card at a random index. A card may be swapped with itself.
    public static void shuffle(int[] deck){
        for(int i = 0; i < deck.length; i++){
            int storage = deck[i];
            Random rand = new Random();
            int boom= rand.nextInt(52);
            deck[i] = deck[boom];
            deck[boom] = storage;
        }
    } // Exit shuffle()

    //Create a function that creates a 52 element shuffled int[] of cards.
    public static int[] createShuffledDeck(){
        int[] deck = new int[52];
        for(int i = 0; i < deck.length; i++){
            deck[i] = i+1;
        }
        shuffle(deck);
        return deck;
    } // createShuffleDeck()

    //Create a function that returns the next card in the deck. As we "use" cards,
    // we should set their spot in the deck to 0 to represent empty.
    // You should use cards in index order, meaning that as you're using cards, the deck with have 0's at the front.
    // If you run out of cards in the deck, return 0.
    public static int nextCard(int[] deck){
        for(int i = 0; i < deck.length; i++){
            if(deck[i] != 0){
                int rv = deck[i];
                deck[i] =0;
                return rv;
            }
        }
        return 0;
    } // Exit nextCard()

    //Create a function called task8() and follow these steps:
    //1. Create a shuffled deck.
    //2. Print the deck.
	//3. Create a for loop that prints the first 5 cards in the deck, 1 card per line.
	//4. Look at the hand to determine its best poker value. Paste the output into the submission box, and indicate its best poker value as a comment.
    public static void task8(){
        int[] funky = createShuffledDeck();
        for(int i= 0; i < funky.length; i++){
            System.out.println(funky[i]);
        }
        for(int i = 0; i < 5; i++){
            System.out.print(cardToString(funky[i]) + " ");
        }  // Exit task8()
    }

    //Create a function that takes a 5 element int[] of cards called hand,
    //and returns its best poker hand using the values in the picture.
    //You don't need to worry about the fact that a pair of 10's beats a pair of 9's,
    //and we can just say that those 2 hands tie.
    public static int bestPokerHand(int[] hand){
        for(int i = 0; i < hand.length-1; i++){
            if(hand[i] > hand[i+1]){
                int t = hand[i];
                hand[i] = hand[i+1];
                hand[i+1] = t;
                i= -1;
            }
        }
        String[] cards = new String[hand.length];
        for(int i = 0; i < cards.length; i++){
            cards[i] = cardToString(hand[i]);
        }
        int count = 0;
        char flush = cards[0].charAt(0);
        for(int i = 0; i < cards.length; i++){
            if(cards[i].charAt(0) == flush){
                count++;
            }
        }
        int countRoyal = 0;
        int countX = 0;
        int countReg = 0;
        if(count == 5){
            for(int i = 0; i < count; i++){
                if(cards[i].charAt(1) == 'A' ||cards[i].charAt(1) == 'K' ||cards[i].charAt(1) == 'Q' ||cards[i].charAt(1) == 'J'){
                    countRoyal++;
                }
                else if(cards[i].charAt(1) == 'X'){
                    countX++;
                }
                else{
                    countReg++;
                }
            }
            if(countReg == 0){
                return 1; //Royal Flush
            }
            else if(countRoyal == 0){
                return 2; //Straight Flush
            }
            else{
                return 5; //Flush
            }
        }
        else{
            int[] faces = new int[5];
            for(int i = 0; i < 5; i++){
                faces[i] = face(hand[i]);
            }
            for(int i = 0; i < faces.length-1; i++){
                if(faces[i] > faces[i+1]){
                    int t = faces[i];
                    faces[i] = faces[i+1];
                    faces[i+1] = t;
                    i= -1;
                }
            }
            boolean four1 = faces[0] == faces[1] && faces[1] == faces[2] && faces[2] == faces[3];
            boolean four2 = faces[1] == faces[2] && faces[2] == faces[3] && faces[3] == faces[4];
            if(four1 || four2){
                return 3; // Four of a Kind
            }
            boolean full1 = faces[0] == faces[1] && faces[2] == faces[3] && faces[3] == faces[4];
            boolean full2 = faces[0] == faces[1] && faces[1] == faces[2] && faces[3] == faces[4];
            if(full1 || full2){
                return 4; // Full House
            }
            int countStraight = 0;
            for(int i = 0; i < faces.length-1; i++){
                if(faces[i] == faces[i+1] -1){
                    countStraight++;
                }
            }
            if(countStraight == 4){
                return 6; // Straight
            }
            boolean three1 = faces[0] == faces[1] && faces [1] == faces[2];
            boolean three2 = faces[1] == faces[2] && faces [2] == faces[3];
            boolean three3 = faces[2] == faces[3] && faces [3] == faces[4];
            if(three1||three2||three3){
                return 7; // Three of a Kind
            }
            boolean tp1 = faces[0] == faces[1] && faces[2] == faces[3];
            boolean tp2 = faces[1] == faces[2] && faces[3] == faces[4];
            boolean tp3 = faces[0] == faces[1] && faces[3] == faces[4];
            if(tp1||tp2||tp3){
                return 8; // Two Pair
            }
            boolean op1 = faces[0] == faces[1];
            boolean op2 = faces[1] == faces[2];
            boolean op3 = faces[2] == faces[3];
            boolean op4 = faces[3] == faces[4];
            if(op1||op2||op3||op4){
                return 9; // One Pair
            }
        }
        return 10; // High Card
    } // Exit bestPokerHand()

    //Create a function that takes a poker hand called hand as an int from 1-10, and returns the name of that poker hand
    public static String pokerHand(int hand){
        if(hand == 1){
            return "Royal Flush";
        }
        else if(hand == 2){
            return "Straight Flush";
        }
        else if(hand == 3){
            return "Four of a Kind";
        }
        else if(hand == 4){
            return "Full House";
        }
        else if(hand == 5){
            return "Flush";
        }
        else if(hand == 6){
            return "Straight";
        }
        else if(hand == 7){
            return "Three of a Kind";
        }
        else if(hand == 8){
            return "Two Pairs";
        }
        else if(hand == 9){
            return "One Pairs";
        }
        else if(hand == 10){
            return "High Card";
        }
        else{
            return "That's not a hand, buddy. Try again. :(";
        }
    } // Exit pokerHand()

    //  1. Create a shuffled deck of 52 cards.
    //	2. Create 2 five element hands called handA, handB.
    //	3. Deal cards into each hand in alternating order. IE, give a card to handA, give a card to handB, give a card to handA, etc... Yes, it must be alternating.
    //	4. Display "Player 1's turn" and show them their hand.
    //	5. Ask them which card they want to replace, using numbers 1-5. If they don't want to replace a card, they should type in 0.
    //	6. Since users are allowed to replace more than 1 card, keep asking them this question until they enter 0.
    //	7. Only after they've indicated all the cards to replace, go through and replace those cards with new cards.
    //	8. Display the new hand.
    //	9. Repeat steps 4-8 for Player 2.
    //	10. Determine the winner and print either "Player 1 Wins!" or "Player 2 Wins!"
    public static void play() {
        int[] playa = createShuffledDeck();
        int[] handA = new int[5];
        int[] handB = new int[5];
        int[] hands = new int[10];
        for (int i = 0; i < hands.length; i++) {
            hands[i] = nextCard(playa);
        }
        for(int i = 0; i < handA.length; i++){
            handA[i] = hands[i*2];
        }
        for(int i = 0; i < handB.length; i++){
            handB[i] = hands[(i*2)+1];
        }
        System.out.println("Player 1's cards:\n");
        for(int i = 0; i < handA.length; i++){
            System.out.print(cardToString(handA[i]) + " ");
        }
        System.out.println("\nWould you like to replace any cards? If so, type the number 1-5 to show which card to replace. Otherwise, type 0.\n");
        Scanner sc = new Scanner(System.in);
        int replace1 = sc.nextInt();
        while(replace1 != 0){
            handA[replace1 -1] = nextCard(playa);
            System.out.print("Anything else?\n");
            replace1 = sc.nextInt();
        }
        print(handA);
        System.out.println("\nPlayer 2's cards:\n");
        for(int i = 0; i < handA.length; i++){
            System.out.print(cardToString(handB[i]) + " ");
        }
        System.out.println("\nWould you like to replace any cards? If so, type the number 1-5 to show which card to replace. Otherwise, type 0.\n");
        int replace2 = sc.nextInt();
        while(replace2 != 0){
            handB[replace2 -1] = nextCard(playa);
            System.out.print("Anything else?\n");
            replace2 = sc.nextInt();
        }
        print(handB);
        int num1 = bestPokerHand(handA);
        int num2 = bestPokerHand(handB);
        if(num1 > num2){
            System.out.println("\nPlayer 1 wins!");
        }
        else if (num2 > num1){
            System.out.println("\nPlayer 2 wins!");
        }
        else{
            System.out.println("\nIt's a tie");
        }
    } // Exit play()
}