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
        for(int i = 0; i<portfolio.size();i++){
            if(portfolio.get(i).equals(s)){
                portfolio.get(i).setCount(portfolio.get(i).getCount()+s.getCount());
            }

        }
        portfolio.add(s);
    }

    public void sell(String s, double num){
        if(portfolio.contains(getShare(s))) {
            getShare(s).setCount(getShare(s).getCount() - num);

            if (getShare(s).getCount() < 1) {

                portfolio.remove(getShare(s));
            }
        }


    }

    public double getCount(T s){
        return s.getCount();
    }

    public T getShare(String s){
        for(int i=0; i<portfolio.size(); i++){
            if(portfolio.get(i).getTitel().equals(s)){
                return portfolio.get(i);
            }

        }

        return null;

    }
}
