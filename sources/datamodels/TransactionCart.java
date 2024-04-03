package datamodels;

import androidx.annotation.Nullable;
import buisnessmodels.TalabatFormatter;
import java.util.ArrayList;

public class TransactionCart {
    int AreaId;
    float GemDiscount;
    float GrandTotal;
    TransactionRestaurant[] Restaurants;
    float Total;
    private float binDiscount;
    private int binNumber;
    private String binValidate;
    private String deliveryMode;
    boolean isGemAccepted;
    private String last4Digits;
    ArrayList<TransactionVoucher> vouchers;

    public static class Builder {
        /* access modifiers changed from: private */
        public int areaId;
        /* access modifiers changed from: private */
        public float binDiscount;
        /* access modifiers changed from: private */
        public int binNumber;
        /* access modifiers changed from: private */
        public String binValidate;
        /* access modifiers changed from: private */
        public String deliveryMode;
        /* access modifiers changed from: private */
        public float gemDiscount;
        /* access modifiers changed from: private */
        public float grandTotal;
        /* access modifiers changed from: private */
        public boolean isGemAccepted;
        /* access modifiers changed from: private */
        public String last4Digits;
        /* access modifiers changed from: private */
        public float total;
        /* access modifiers changed from: private */
        public TransactionRestaurant transactionRestaurant;
        /* access modifiers changed from: private */
        public ArrayList<TransactionVoucher> vouchers;

        public TransactionCart build() {
            return new TransactionCart(this);
        }

        public Builder setAreaId(int i11) {
            this.areaId = i11;
            return this;
        }

        public Builder setBinDiscount(float f11) {
            this.binDiscount = f11;
            return this;
        }

        public Builder setBinNumber(int i11) {
            this.binNumber = i11;
            return this;
        }

        public Builder setBinValidate(String str) {
            this.binValidate = str;
            return this;
        }

        public Builder setDeliveryMode(String str) {
            this.deliveryMode = str;
            return this;
        }

        public Builder setGemAccepted(boolean z11) {
            this.isGemAccepted = z11;
            return this;
        }

        public Builder setGemDiscount(float f11) {
            this.gemDiscount = f11;
            return this;
        }

        public Builder setGrandTotal(float f11) {
            this.grandTotal = TalabatFormatter.getInstance().getRoundedAmount(f11);
            return this;
        }

        public Builder setLast4Digits(String str) {
            this.last4Digits = str;
            return this;
        }

        public Builder setTotal(float f11) {
            this.total = TalabatFormatter.getInstance().getRoundedAmount(f11);
            return this;
        }

        public Builder setTransactionRestaurant(TransactionRestaurant transactionRestaurant2) {
            this.transactionRestaurant = transactionRestaurant2;
            return this;
        }

        public Builder setVouchers(ArrayList<TransactionVoucher> arrayList) {
            this.vouchers = arrayList;
            return this;
        }
    }

    public TransactionCart(Builder builder) {
        this.AreaId = builder.areaId;
        TransactionRestaurant[] transactionRestaurantArr = new TransactionRestaurant[1];
        this.Restaurants = transactionRestaurantArr;
        transactionRestaurantArr[0] = builder.transactionRestaurant;
        this.vouchers = builder.vouchers;
        this.Total = builder.total;
        this.GrandTotal = builder.grandTotal;
        this.GemDiscount = builder.gemDiscount;
        this.isGemAccepted = builder.isGemAccepted;
        this.binNumber = builder.binNumber;
        this.binDiscount = builder.binDiscount;
        this.binValidate = builder.binValidate;
        this.last4Digits = builder.last4Digits;
        this.deliveryMode = builder.deliveryMode;
    }

    public int getAreaId() {
        return this.AreaId;
    }

    public float getGrandTotalAmount() {
        return this.GrandTotal;
    }

    @Nullable
    public TransactionRestaurant getRestaurant() {
        TransactionRestaurant[] transactionRestaurantArr = this.Restaurants;
        if (transactionRestaurantArr.length > 0) {
            return transactionRestaurantArr[0];
        }
        return null;
    }

    public float getTotalAmount() {
        return this.Total;
    }

    public ArrayList<TransactionVoucher> getVouchers() {
        return this.vouchers;
    }
}
