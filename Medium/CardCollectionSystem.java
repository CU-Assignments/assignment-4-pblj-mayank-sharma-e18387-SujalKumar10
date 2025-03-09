import java.util.ArrayList;
import java.util.Scanner;

class Card {
    private String symbol;
    private String rank;

    public Card(String symbol, String rank) {
        this.symbol = symbol;
        this.rank = rank;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Card [Symbol: " + symbol + ", Rank: " + rank + "]";
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Card");
            System.out.println("2. Search by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter Symbol (Hearts, Diamonds, etc.): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Rank (Ace, 2, King, etc.): ");
                    String rank = scanner.nextLine();
                    cards.add(new Card(symbol, rank));
                    System.out.println("Card added successfully!");
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Enter Symbol to search: ");
                    String searchSymbol = scanner.nextLine();
                    boolean found = false;
                    for (Card card : cards) {
                        if (card.getSymbol().equalsIgnoreCase(searchSymbol)) {
                            System.out.println(card);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No cards found with the symbol: " + searchSymbol);
                    }
                    break;

                case 3:
                    if (cards.isEmpty()) {
                        System.out.println("No cards in the collection.");
                    } else {
                        for (Card card : cards) {
                            System.out.println(card);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
