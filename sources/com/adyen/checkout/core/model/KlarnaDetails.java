package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class KlarnaDetails extends OpenInvoiceDetails {
    @NonNull
    public static final Parcelable.Creator<KlarnaDetails> CREATOR = new Parcelable.Creator<KlarnaDetails>() {
        public KlarnaDetails createFromParcel(@NonNull Parcel parcel) {
            return new KlarnaDetails(parcel);
        }

        public KlarnaDetails[] newArray(int i11) {
            return new KlarnaDetails[i11];
        }
    };

    public static final class Builder {
        private KlarnaDetails mKlarnaDetails;

        public Builder(@NonNull PersonalDetails personalDetails, @NonNull Address address) {
            KlarnaDetails klarnaDetails = new KlarnaDetails();
            this.mKlarnaDetails = klarnaDetails;
            klarnaDetails.f40138b = personalDetails;
            klarnaDetails.f40139c = address;
        }

        @NonNull
        public KlarnaDetails build() {
            return this.mKlarnaDetails;
        }

        @NonNull
        public Builder setConsentCheckbox(@Nullable Boolean bool) {
            this.mKlarnaDetails.f40142f = bool;
            return this;
        }

        @NonNull
        public Builder setDeliveryAddress(@Nullable Address address) {
            this.mKlarnaDetails.f40141e = address;
            return this;
        }

        @NonNull
        public Builder setSeparateDeliveryAddress(@Nullable Boolean bool) {
            this.mKlarnaDetails.f40140d = bool;
            return this;
        }
    }

    private KlarnaDetails() {
    }

    private KlarnaDetails(@NonNull Parcel parcel) {
        super(parcel);
    }
}
