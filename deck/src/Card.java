import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
    enum Suit {
        TREBOLES, DIAMANTES, CORAZONES, PICAS
    }

    enum Color {
        ROJO, NEGRO
    }

    private Suit suit;
    private Color color;
    private String value;

    public Card(Suit suit, String value) {
        this.suit = suit;
        this.value = value;
        this.color = (suit == Suit.CORAZONES || suit == Suit.DIAMANTES) ? Color.ROJO : Color.NEGRO;
    }

    public Suit getSuit() {
        return suit;
    }

    public Color getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + "," + color + "," + value;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
        for (Card.Suit suit : Card.Suit.values()) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            Card card = cards.remove(rand.nextInt(cards.size()));
            System.out.println(card);
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card);
            }
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas para una mano.");
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}

