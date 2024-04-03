package com.adyen.checkout.core.card;

import android.support.annotation.NonNull;
import java.util.Date;
import java.util.concurrent.Callable;

public interface CardEncryptor {
    @NonNull
    Callable<String> encrypt(@NonNull String str, @NonNull Card card, @NonNull Date date, @NonNull String str2);

    @NonNull
    Callable<EncryptedCard> encryptFields(@NonNull Card card, @NonNull Date date, @NonNull String str);
}
