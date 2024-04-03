package com.adyen.checkout.core.card;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class EncryptedCard implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<EncryptedCard> CREATOR = new Parcelable.Creator<EncryptedCard>() {
        public EncryptedCard createFromParcel(Parcel parcel) {
            return new EncryptedCard(parcel);
        }

        public EncryptedCard[] newArray(int i11) {
            return new EncryptedCard[i11];
        }
    };
    /* access modifiers changed from: private */
    public String mEncryptedExpiryMonth;
    /* access modifiers changed from: private */
    public String mEncryptedExpiryYear;
    /* access modifiers changed from: private */
    public String mEncryptedNumber;
    /* access modifiers changed from: private */
    public String mEncryptedSecurityCode;

    public static final class Builder {
        private EncryptedCard mEncryptedCard = new EncryptedCard();

        @NonNull
        public EncryptedCard build() {
            return this.mEncryptedCard;
        }

        @NonNull
        public Builder clearEncryptedExpiryDate() {
            String unused = this.mEncryptedCard.mEncryptedExpiryMonth = null;
            String unused2 = this.mEncryptedCard.mEncryptedExpiryYear = null;
            return this;
        }

        @NonNull
        public Builder setEncryptedExpiryDate(@NonNull String str, @NonNull String str2) {
            String unused = this.mEncryptedCard.mEncryptedExpiryMonth = str;
            String unused2 = this.mEncryptedCard.mEncryptedExpiryYear = str2;
            return this;
        }

        @NonNull
        public Builder setEncryptedNumber(@Nullable String str) {
            String unused = this.mEncryptedCard.mEncryptedNumber = str;
            return this;
        }

        @NonNull
        public Builder setEncryptedSecurityCode(@Nullable String str) {
            String unused = this.mEncryptedCard.mEncryptedSecurityCode = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getEncryptedExpiryMonth() {
        return this.mEncryptedExpiryMonth;
    }

    @Nullable
    public String getEncryptedExpiryYear() {
        return this.mEncryptedExpiryYear;
    }

    @Nullable
    public String getEncryptedNumber() {
        return this.mEncryptedNumber;
    }

    @Nullable
    public String getEncryptedSecurityCode() {
        return this.mEncryptedSecurityCode;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mEncryptedNumber);
        parcel.writeString(this.mEncryptedExpiryMonth);
        parcel.writeString(this.mEncryptedExpiryYear);
        parcel.writeString(this.mEncryptedSecurityCode);
    }

    private EncryptedCard() {
    }

    private EncryptedCard(@NonNull Parcel parcel) {
        this.mEncryptedNumber = parcel.readString();
        this.mEncryptedExpiryMonth = parcel.readString();
        this.mEncryptedExpiryYear = parcel.readString();
        this.mEncryptedSecurityCode = parcel.readString();
    }
}
