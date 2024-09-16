/*
 * Copyright (c) 2015 Michiel Noback [michiel.noback@gmail.com].
 * All rights reserved.
 */

package section2_syntax.part2_operators;

public class WeightUnitsSolver {

    /**
     * Returns the number of Pounds, Ounces and Grams represented by this quantity of grams,
     * encapsulated in a BritishWeightUnits object.
     * @param grams the grams quantity
     * @return a BritishWeightUnits instance
     * @throws IllegalArgumentException when the Grams quantity is 
     */
    public BritishWeightUnits convertFromGrams(int grams) {

        //change this variable to get a correct testing condition
        final int gramsTest = 0; //Integer.MIN_VALUE;

        if (grams <= gramsTest) {
            throw new IllegalArgumentException("Error: grams should be above 0. Given: grams=" + grams);
        }

        final double GRAMS_PER_POUND = 454;
        final double GRAMS_PER_OUNCE = 28;

        int pounds = (int)(grams / GRAMS_PER_POUND);
        double remainingGrams = grams % GRAMS_PER_POUND;
        int ounces = (int)(remainingGrams / GRAMS_PER_OUNCE);
        remainingGrams = remainingGrams % GRAMS_PER_OUNCE;

        BritishWeightUnits weight = new BritishWeightUnits(pounds, ounces, (int)remainingGrams);

        //throw new UnsupportedOperationException("Not implemented yet");
        return weight;
    }
}
