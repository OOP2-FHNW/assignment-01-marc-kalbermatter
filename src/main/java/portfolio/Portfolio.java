package portfolio;


import portfolio.investments.Investment;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a genetic portfolio
 *
 * @param <T> Type parameter
 */
public class Portfolio<T extends Investment> {

    List<T> portfolio = new ArrayList<>();

    /**
     * Method to check if portfolio already contains share
     *
     * @param s an object of type T that might be in the portfolio
     * @return True if the portfolio already contains Object, otherwise false
     */
    public boolean contains(T s) {
        return portfolio.contains(s);
    }

    /**
     * Method to buy new shares and add them to the portfolio
     *
     * @param s an object of type T that is bought
     */
    public void buy(T s) {
        // Need to look if Object is already in Portfolio
        for (int i = 0; i < portfolio.size(); i++) {
            T share = portfolio.get(i);
            if (share.equals(s)) {
                share.setCount(share.getCount() + s.getCount()); // add newly bought shares to existing ones
                return;
            }
        }
        portfolio.add(s); // Shares weren't in portfolio, need to be added
    }

    /**
     * Method to sell a certain amount of a specifc share
     *
     * @param s   A string that is equal to the title of the object
     * @param num The amount of the object we want to sell
     */
    public void sell(String s, double num) {
        T share = getShare(s);
        if (portfolio.contains(share)) {
            share.setCount(share.getCount() - num); // remove sold shares
            if (share.getCount() < 1) {
                portfolio.remove(share);  // no shares left --> shouldn't be in the portfolio
            }
        }
    }

    /**
     * Method to get share by its title
     *
     * @param s A string that is equal to the titlle of the object
     * @return The object if it is in the portfolio, esle returns null
     */
    public T getShare(String s) {
        for (int i = 0; i < portfolio.size(); i++) {
            T share = portfolio.get(i);
            if (share.getTitel().equals(s)) {
                return share;
            }
        }
        return null;
    }
}
