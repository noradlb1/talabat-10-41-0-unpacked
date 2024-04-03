package datamodels;

public class TransactionCoupon {
    float Discount;
    int Id;
    boolean IsSelected = true;

    public TransactionCoupon(int i11, float f11) {
        this.Id = i11;
        this.Discount = f11;
    }

    public String logValues() {
        return this.Id + "," + this.Discount;
    }

    public TransactionCoupon(float f11) {
        this.Discount = f11;
    }
}
