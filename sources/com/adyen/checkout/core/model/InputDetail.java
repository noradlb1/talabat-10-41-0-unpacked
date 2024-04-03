package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.CheckoutException;
import java.util.List;

public interface InputDetail extends Parcelable {

    public enum Type {
        ADDRESS,
        ANDROID_PAY_TOKEN,
        BOOLEAN,
        CARD_TOKEN,
        DATE,
        EMAIL_ADDRESS,
        FIELD_SET,
        GOOGLE_PAY_TOKEN,
        IBAN,
        RADIO,
        SELECT,
        SAMSUNG_PAY_TOKEN,
        SECURITY_CODE,
        TELEPHONE,
        TEXT
    }

    @Nullable
    List<InputDetail> getChildInputDetails();

    @Nullable
    <T extends Configuration> T getConfiguration(@NonNull Class<T> cls) throws CheckoutException;

    @Nullable
    List<Item> getItems();

    @NonNull
    String getKey();

    @NonNull
    Type getType();

    @Nullable
    String getValue();

    boolean isOptional();
}
