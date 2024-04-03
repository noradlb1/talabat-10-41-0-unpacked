package com.adyen.checkout.core.card;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class Card implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<Card> CREATOR = new Parcelable.Creator<Card>() {
        public Card createFromParcel(Parcel parcel) {
            return new Card(parcel);
        }

        public Card[] newArray(int i11) {
            return new Card[i11];
        }
    };
    /* access modifiers changed from: private */
    public Integer mExpiryMonth;
    /* access modifiers changed from: private */
    public Integer mExpiryYear;
    /* access modifiers changed from: private */
    public String mNumber;
    /* access modifiers changed from: private */
    public String mSecurityCode;

    public static final class Builder {
        private Card mCard = new Card();

        @NonNull
        public Card build() {
            return this.mCard;
        }

        @NonNull
        public Builder clearExpiryDate() {
            Integer unused = this.mCard.mExpiryMonth = null;
            Integer unused2 = this.mCard.mExpiryYear = null;
            return this;
        }

        @NonNull
        public Builder setExpiryDate(int i11, int i12) {
            Integer unused = this.mCard.mExpiryMonth = Integer.valueOf(i11);
            Integer unused2 = this.mCard.mExpiryYear = Integer.valueOf(i12);
            return this;
        }

        @NonNull
        public Builder setNumber(@Nullable String str) {
            String unused = this.mCard.mNumber = str;
            return this;
        }

        @NonNull
        public Builder setSecurityCode(@Nullable String str) {
            String unused = this.mCard.mSecurityCode = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public Integer getExpiryMonth() {
        return this.mExpiryMonth;
    }

    @Nullable
    public Integer getExpiryYear() {
        return this.mExpiryYear;
    }

    @Nullable
    public String getNumber() {
        return this.mNumber;
    }

    @Nullable
    public String getSecurityCode() {
        return this.mSecurityCode;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mNumber);
        parcel.writeSerializable(this.mExpiryMonth);
        parcel.writeSerializable(this.mExpiryYear);
        parcel.writeString(this.mSecurityCode);
    }

    private Card() {
    }

    private Card(@NonNull Parcel parcel) {
        this.mNumber = parcel.readString();
        this.mExpiryMonth = (Integer) parcel.readSerializable();
        this.mExpiryYear = (Integer) parcel.readSerializable();
        this.mSecurityCode = parcel.readString();
    }
}
