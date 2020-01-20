import java.util.ArrayList;
import java.util.List;


/**
 * ババ抜きの実装、途中まで。
 *
 * カードをランダムに配り、被った手持ちのカードを捨てるところまで実装した。
 *
 */
class PlayBabanuki {
    //自分のカードのリスト
    static List<String> player1_cards = new ArrayList<String>();
    // 相手のカードのリスト
    static List<String> player2_cards = new ArrayList<String>();

    /**
     * トランプのカードを用意し、シャッフルして配る。
     *
     */
    public static void shuffle() {
        //1～10までとJQKをそれぞれ２枚づつ＋Jokerのカードを用意する。
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            list.add(String.valueOf(i));
            list.add(String.valueOf(i));
        }

        list.add("J");
        list.add("J");
        list.add("Q");
        list.add("Q");
        list.add("K");
        list.add("K");
        list.add("Joker");

        //自分と相手にランダムにカードを配る。
        while (list.size() > 1) {
            int select_num = (int) (Math.random() * list.size());

            //自分のリストに追加
            player1_cards.add(list.get(select_num));
            list.remove(select_num);
            select_num = (int) (Math.random() * list.size());

            //相手のリストに追加
            player2_cards.add(list.get(select_num));
            list.remove(select_num);
        }
        System.out.println("シャッフルされたトランプが配られる。");
        System.out.println(player1_cards);
        System.out.println(player2_cards);
    }

    /**
     * 配られたカードの中でダブっているものを取り除くメソッド。
     * String terget; 対象のカード
     * String comparison; 対象のカードと比較するカード
     * @return
     */
    public static int discardDoubleCard() {
        for (int i = 0;i < player1_cards.size(); i++ ){
            // 一つずつ対象のカードを取り出す
            String target = player1_cards.get(i);
            for (int n = 0; n < player1_cards.size(); n++ ){
                // 比較対象のカードを取り出す(対象のカードと比較するカードをダブらせないように)
                if (i != n){
                    String comparison = player1_cards.get(n);
                    if (target.equals(comparison)){
                        player1_cards.remove(i);
                        player1_cards.remove(n);
                    }
                }
            }
        }
        //相手のカードについて同じ動作をする(ここは可能な限り一つにまとめるべき)
        for (int i = 0;i < player2_cards.size(); i++ ){
            // 一つずつ対象のカードを取り出す
            String target = player2_cards.get(i);
            for (int n = 0; n < player2_cards.size(); n++ ){
                // 比較対象のカードを取り出す(対象のカードと比較するカードをダブらせないように)
                if (i != n){
                    String comparison = player2_cards.get(n);
                    if (target.equals(comparison)){
                        player2_cards.remove(i);
                        player2_cards.remove(n);
                    }
                }
            }
        }
        System.out.println("ダブりのあるトランプを捨てた。");
        System.out.println(player1_cards);
        System.out.println(player2_cards);
        int haveCard =player1_cards.size();
        return haveCard;
    }
}

public class Main {
    public static void main(String[] args) {
        PlayBabanuki.shuffle();
        PlayBabanuki.discardDoubleCard();
    }
}
