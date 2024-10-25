package com.booleanuk;

import java.util.HashMap;
import java.util.Map;

public class Poker {
    private static final Map<String, Integer> cardValues = new HashMap<>();

    static {
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("J", 11);
        cardValues.put("Q", 12);
        cardValues.put("K", 13);
        cardValues.put("A", 14);
    }

    public String[] winningPair(String[] firstHand, String[] secondHand) {
        String[] pair1 = getPair(firstHand);
        String[] pair2 = getPair(secondHand);

        if (pair1.length == 0 && pair2.length == 0) {
            return new String[]{};
        } else if (pair1.length == 0) {
            return pair2;
        } else if (pair2.length == 0) {
            return pair1;
        } else {
            return cardValues.get(pair1[0]) > cardValues.get(pair2[0]) ? pair1 : pair2;
        }
    }

    private String[] getPair(String[] hand) {
        if (hand[0].equals(hand[1])) {
            return hand;
        }
        return new String[]{};
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        String[] winningPair = new String[]{};
        int highestValue = 0;

        for (String[] hand : hands) {
            String[] pair = getPair(hand);
            if (pair.length > 0) {
                int pairValue = cardValues.get(pair[0]);
                if (pairValue > highestValue) {
                    highestValue = pairValue;
                    winningPair = pair;
                }
            }
        }

        return winningPair;
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
        String[] winningHand = new String[]{};
        int highestValue = 0;
        boolean hasThreeOfAKind = false;

        for (String[] hand : hands) {
            String[] threeOfAKind = getThreeOfAKind(hand);
            String[] pair = getPair(hand);

            if (threeOfAKind.length > 0) {
                int value = cardValues.get(threeOfAKind[0]);
                if (!hasThreeOfAKind || value > highestValue) {
                    highestValue = value;
                    winningHand = threeOfAKind;
                    hasThreeOfAKind = true;
                }
            } else if (!hasThreeOfAKind && pair.length > 0) {
                int value = cardValues.get(pair[0]);
                if (value > highestValue) {
                    highestValue = value;
                    winningHand = pair;
                }
            }
        }

        return winningHand;
    }

    private String[] getThreeOfAKind(String[] hand) {
        if (hand.length == 3 && hand[0].equals(hand[1]) && hand[1].equals(hand[2])) {
            return hand;
        }
        return new String[]{};
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
