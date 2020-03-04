package portfolio;


import portfolio.investments.Investment;

import java.util.ArrayList;
import java.util.List;


public class Portfolio<T extends Investment> {

  List<T> portfolio = new ArrayList<>();

    public boolean contains(T s){
        return portfolio.contains(s);
    }

    public void buy(T s){
        // Need to look if Object is already in Portfolio
        for(int i = 0; i<portfolio.size();i++){
            T share = portfolio.get(i);
            if(share.equals(s)){
                    share.setCount(share.getCount()+s.getCount()); // add newly bought shares to existing ones
                return;
            }
        }
        portfolio.add(s); // Shares weren't in portfolio
    }


    public void sell(String s, double num){
        T share = getShare(s);
        if(portfolio.contains(share)) {
            share.setCount(share.getCount() - num); // remove sold shares
            if (share.getCount() < 1) {
                portfolio.remove(share);  // no shares left --> shouldn't be in the portfolio
            }
        }
    }


    public T getShare(String s){
       //get share by title
        for(int i=0; i<portfolio.size(); i++){
            T share = portfolio.get(i);
            if(share.getTitel().equals(s)){
                return share;
            }
        }
       return null;
    }
}
