package datamodels;

public class TransactionPromotion {
    int Id;
    boolean IsSelected = true;

    public TransactionPromotion(int i11) {
        this.Id = i11;
    }

    public String logValues() {
        return String.valueOf(this.Id);
    }
}
