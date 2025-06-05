import java.util.*;

public class Q54 {

    public static HashMap<String, Integer> pokerHands = new HashMap<String, Integer>();
    public static HashMap<String, Integer> pokerCards = new HashMap<String, Integer>();
    public static int tiebreakerCount=0;

    public static void main(String[] args) {
        String adress = "https://projecteuler.net/resources/documents/0054_poker.txt";
        ArrayList<String> games=URLReader.readReturnArrayList(adress);




        createPokerHands();
        createPokerCards();

        System.out.println(pokerCards);
        System.out.println(pokerHands);
        HashMap<String,Integer> results= new HashMap<String,Integer>();
        results.put("Player1", 0);
        results.put("Player2", 0);
        results.put("Draw", 0);
        System.out.println(results);
        System.out.println(tiebreakerCount);





        for (int i = 0; i < games.size(); i++) {


            String hand1= games.get(i).substring(0,14);
            String hand2= games.get(i).substring(15,games.get(i).length());
            String winner= determineWinner(hand1,hand2);

            if(results.containsKey(winner)){
                results.replace(winner,results.get(winner)+1);
            }
            else{
                results.put(winner,1);
            }


        }
        System.out.println(results);
        System.out.println(tiebreakerCount);


        System.out.println(determineWinner("5D 8C 9S JS AC","2C 5C 7D 8S QH"));
        System.out.println(determineWinner("5H 5C 6S 7S KD","2C 3S 8S 8D TD"));
        System.out.println(determineWinner("4D 6S 9H QH QC","3D 6D 7H QD QS"));
        System.out.println(determineWinner("2H 2D 4C 4D 4S","3C 3D 3S 9S 9D"));
        System.out.println(determineWinner("5H 5C 6S 7S KD","2C 3S 8S 8D TD"));


    }
    public static void createPokerHands() {
        String[] hands= new String[]{"High Card", "One Pair", "Two Pair", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };


        for (int i = 0; i < hands.length; i++) {
            pokerHands.put(hands[i], i);
        }
    }
    public static HashMap<String, Integer> getPokerHands() {

        return pokerHands;
    }
    public static void createPokerCards() {

        String[] royals= new String[]{"T","J", "Q", "K", "A"};
        for (int i = 2; i < 10; i++) {
            pokerCards.put(String.valueOf(i), i-2);
        }
        for (int i = 0; i < royals.length; i++) {
            pokerCards.put(royals[i], i+8);
        }

    }
    public static HashMap<String, Integer> getPokerCards() {

        createPokerCards();
        return pokerCards;
    }
    public static String determineWinner(String player1, String player2) {
        String[] player1Hand=player1.split(" ");
        String[] player2Hand=player2.split(" ");
        String winner;
        if(pokerHands.get( getHand(player1Hand))>pokerHands.get( getHand(player2Hand))){
            winner = "Player1";

        } else if (pokerHands.get( getHand(player1Hand))<pokerHands.get( getHand(player2Hand))) {
            winner = "Player2";
        }else{

            winner = "Draw";



            //TODO: yeah im gonna fix this

            winner = tieBreaker(player1Hand, player2Hand);
        }


        return winner;
    }

    public static String tieBreaker(String[] player1, String[] player2) {

        String winner = "";
        tiebreakerCount++;
    /*
    TODO: it doesn't work, assume it works

     */

        int[] order1 = new int[player1.length];
        for (int i = 0; i < player1.length; i++) {
            order1[i] =pokerCards.get(String.valueOf(player1[i].charAt(0)));
        }
        Arrays.sort(order1);
        int[] order2 = new int[player2.length];
        for (int i = 0; i < player2.length; i++) {
            order2[i] =pokerCards.get(String.valueOf(player2[i].charAt(0)));
        }
        Arrays.sort(order2);
        if(checkStraight(player1)){
            if (order1[order1.length-1]==12 && order1[0]==0){
                order1[order1.length-1]=-1;
                Arrays.sort(order1);
            }
            if (order2[order2.length-1]==12 && order2[0]==0){
                order2[order2.length-1]=-1;
                Arrays.sort(order2);
            }

        }
        if(checkFlush(player1)||checkStraight(player1)){

            if(order1[order1.length-1]>order2[order2.length-1]){
                return "Player1";
            }
            if(order1[order1.length-1]<order2[order2.length-1]){
                return "Player2";
            }
            if(order2[order2.length-1]==order1[order1.length-1]){
                return "Draw";
            }


        }

        else{
           return findTieWinner(order1,order2);

        }


        return winner;

    }
    public static String findTieWinner(int[] player1, int[] player2) {
        String winner = "Draw";
        int ply1fq = mostFreqEle(player1);
        int ply2fq = mostFreqEle(player2);
        if (ply1fq == ply2fq) {
            int count1=0;
            int count2=0;
            for (int i = 0; i < player1.length; i++) {
                if (player1[i] == ply1fq) {
                    count1++;
                }
            }
            for (int i = 0; i < player2.length; i++) {
                if (player2[i] == ply2fq) {
                    count2++;
                }
            }
            if(count2>count1){
                winner = "Player2";
            }
            if(count1>count2){
                winner = "Player1";
            }

            int[] order1 = new int[player1.length-count1];
            int[] order2 = new int[player2.length-count2];
            int adder1=0;
            int adder2=0;

            for (int i = 0; i < player1.length; i++) {
                if (player1[i] != ply1fq) {
                    order1[adder1] = player1[i];
                    adder1++;

                }

            }
            for (int i = 0; i < player2.length; i++) {
                if (player2[i] != ply2fq) {
                    order2[adder2] = player2[i];
                    adder2++;

                }
            }
            winner = findTieWinner(order1,order2);


        } else if (ply1fq > ply2fq) {
            winner = "Player1";

        }
        else if (ply1fq < ply2fq) {
            winner = "Player2";
        }
        return winner;


    }


    public static boolean checkFlush(String[] cards) {
        //checks if flush of a string array of cards
        char card1=cards[0].charAt(1);
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].charAt(1)!=card1) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkStraight(String[] cards){
        //checks if straight of a string array of cards

        int[] order = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            order[i] =pokerCards.get(String.valueOf(cards[i].charAt(0)));
        }
        Arrays.sort(order);
        if (order[order.length-1]==12 && order[0]==0){
            order[order.length-1]=-1;
            Arrays.sort(order);
            for (int i = 1; i < order.length; i++) {
                if (Math.abs(order[i]-order[i-1])!=1) {
                    return false;

                }
            }



        }
        else{
            for (int i = 1; i < order.length; i++) {
                if (Math.abs(order[i]-order[i-1])!=1) {
                    return false;

                }
            }
        }

        return true;



    }

    public static HashMap<String, Integer> countGetter(String temp) {

        //counts



        char[] ch = temp.toCharArray();
        boolean[] b = new boolean[temp.length()];

        HashMap<String, Integer> countos = new HashMap<String, Integer>();
        for (int i = 0; i < ch.length; i++) {
            if (b[i]) continue;     // Skip already counted characters
            int c = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    c++;
                    b[j] = true;     // Mark character as counted
                }
            }
            if( ch[i] >= '0' && ch[i] <= '9' ){
                countos.put(String.valueOf(ch[i]), c);
            }

        }
        return countos;




    }




    public static String getHand(String[] cards) {
        boolean flush=checkFlush(cards);
        boolean straight=checkStraight(cards);
        String temp="";
        for (int i=0;i<cards.length;i++) {
            temp+=cards[i];
        }
        if (flush&&straight) {

            if (temp.contains("A")&&temp.contains("J")) {
                return "Royal Flush";
            }
            return "Straight Flush";
        }
        if (flush) {
            return "Flush";
        }
        if (straight) {
            return "Straight";
        }
        HashMap<String, Integer> countos = countGetter(temp);

        if(countos.containsValue(4)){
            return "Four of a Kind";

        }
        if(countos.containsValue(3) && countos.containsValue(2)){
            return "Full House";

        }
        if(countos.containsValue(3)){
            return "Three of a Kind";
        }
        int dualcount=0;
        for (String i : countos.keySet()) {
            if(countos.get(i)==2){
                dualcount++;
            }
        }
        if(dualcount==2){
            return "Two Pair";
        }
        if(dualcount==1){
            return "One Pair";
        }
        return "High Card";








    }
    static int mostFreqEle(int[] arr) {

        // Sort the array
        Arrays.sort(arr);

        // Find the max frequency using linear traversal
        int maxCnt = 1, res = arr[0], currCnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                currCnt++;
            else
                currCnt = 1;

            if (currCnt > maxCnt || (currCnt == maxCnt && arr[i] > res)) {
                maxCnt = currCnt;
                res = arr[i];
            }
        }

        return res;
    }




}
