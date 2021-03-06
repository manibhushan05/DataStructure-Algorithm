package com.wfs.dynamicprogramming;

import java.util.List;

/**
 * Created by Suryasnata on 5/16/2017.
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange
{
   private int coinArr[];

   private int totalSum;

   public CoinChange(int[] coinArr, int totalSum) {
        this.coinArr = coinArr;
        this.totalSum = totalSum;
   }

   public List<Long> getMinCoins()
   {
        return  getMinCoins(coinArr , totalSum);
   }

   private List<Long> getMinCoins(int coinArr[] , int totalSum)
   {
       int tempCoinArr1[] =new int[totalSum+1];
       int tempCoinArr2[] =new int[totalSum+1];

       for(int coin=1;coin<tempCoinArr1.length;coin++)
       {
           tempCoinArr1[coin] = Integer.MAX_VALUE;
           tempCoinArr2[coin] = -1;
       }

       for(int coin=0;coin<coinArr.length;coin++)
       {
           for(int i=1;i<tempCoinArr1.length;i++)
           {
               if(i<coinArr[coin])
                   continue;
               else if(tempCoinArr1[i - coinArr[coin]] < tempCoinArr1[i])
               {
                   tempCoinArr1[i] = tempCoinArr1[i - coinArr[coin]] +1;
                   tempCoinArr2[i] = coin ;
               }
           }
       }
       return null;
   }

    public static void main(String[] args) {
        CoinChange coinChange  =new CoinChange(new int[]{7,2,3,6} , 13);
        coinChange.getMinCoins();
    }

}
