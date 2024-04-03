package datamodels;

import androidx.annotation.Nullable;

public class TransactionChoice {
    int CategoryIdx;
    int Id;
    float Price;
    int Qty;
    @Nullable
    Integer couponId;
    boolean isDiscountItem;
    @Nullable
    Float oldPrice;
    int parentChoiceId;

    public TransactionChoice(int i11, int i12, float f11, int i13, boolean z11, int i14, Integer num, float f12) {
        this.Id = i11;
        this.CategoryIdx = i12;
        this.Price = f11;
        this.Qty = i13;
        this.isDiscountItem = z11;
        this.parentChoiceId = i14;
        this.couponId = num;
        this.oldPrice = Float.valueOf(f12);
    }
}
