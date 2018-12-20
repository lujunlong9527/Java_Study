package 第46条;


import java.util.*;

/**
 * <p>for-each循坏优先于传统的for循坏</p>
 *
 * @author ljl
 * @date 2018/12/18
 **/
public class Main {

    public static void main(String[] args) {
        //错误的写法
//        testBad();
        //改进后的写法
        testGood();
        //使用foreach代替传统for循坏
        testBetter();
    }

    private static void testBad(){
        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());
        List<Card> deck = new ArrayList<>();
        //报错
        for (Iterator<Suit> i = suits.iterator(); i.hasNext();){
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                //问题在i.next  本意是外部循坏不懂
                deck.add(new Card(i.next(), j.next()));
            }
        }
        System.out.println(deck);
    }
    private static void testGood(){
        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext();){
            //保存外部元素
            Suit suit = i.next();
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();){
                deck.add(new Card(suit, j.next()));
            }
        }
        System.out.println(deck);
    }

    private static void testBetter(){
        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());
        List<Card> deck = new ArrayList<>();
        for (Suit suit : suits){
            for (Rank rank : ranks){
                deck.add(new Card(suit,rank));
            }
        }
        System.out.println(deck);

    }

    enum Suit{ CLUB, DIAMOND, HEART, SPADE}
    enum Rank{ ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE}


    private static class Card{
        private Suit suit;
        private Rank rank;

        public Suit getSuit() {
            return suit;
        }

        public void setSuit(Suit suit) {
            this.suit = suit;
        }

        public Rank getRank() {
            return rank;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }

        private Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override public String toString() {
            return "Card{" + "suit=" + suit + ", rank=" + rank + '}';
        }
    }


}
