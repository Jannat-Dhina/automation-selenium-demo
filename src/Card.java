package src;

public class Card {
    private String nameOnCard;
    private String cardNumber;
    private String cardCVC;
    private String expInMM;
    private String expInYY;

    public Card(String nameOnCard, String cardNumber, String cardCVC, String expInMM, String expInYY) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cardCVC = cardCVC;
        this.expInMM = expInMM;
        this.expInYY = expInYY;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardCVC() {
        return cardCVC;
    }

    public String getExpInMM() {
        return expInMM;
    }

    public String getExpInYY() {
        return expInYY;
    }
}
