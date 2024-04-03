package com.adyen.checkout.core.card;

import android.annotation.SuppressLint;
import android.app.Application;
import android.support.annotation.NonNull;
import com.adyen.checkout.base.HostProvider;
import com.adyen.checkout.core.card.internal.CardEncryptorImpl;
import com.adyen.checkout.core.card.internal.CardFormatterImpl;
import com.adyen.checkout.core.card.internal.CardValidatorImpl;
import java.util.Date;
import java.util.concurrent.Callable;

public final class Cards {
    @NonNull
    public static final CardEncryptor ENCRYPTOR = new CardEncryptorImpl();
    @NonNull
    public static final CardFormatter FORMATTER = new CardFormatterImpl(' ', '/');
    @NonNull
    public static final CardValidator VALIDATOR = new CardValidatorImpl(' ', '/');

    private Cards() {
        throw new IllegalStateException("No instances.");
    }

    @SuppressLint({"LambdaLast"})
    @NonNull
    public static Callable<EncryptedCard> fetchPublicKeyAndEncrypt(@NonNull Application application, @NonNull HostProvider hostProvider, @NonNull final String str, @NonNull final Card card, @NonNull final Date date) {
        final CardApi instance = CardApi.getInstance(application, hostProvider);
        return new Callable<EncryptedCard>() {
            public EncryptedCard call() throws Exception {
                return Cards.ENCRYPTOR.encryptFields(card, date, instance.getPublicKey(str).call()).call();
            }
        };
    }

    @SuppressLint({"LambdaLast"})
    @NonNull
    public static Callable<String> fetchPublicKeyAndEncryptToToken(@NonNull Application application, @NonNull HostProvider hostProvider, @NonNull String str, @NonNull String str2, @NonNull Card card, @NonNull Date date) {
        final CardApi instance = CardApi.getInstance(application, hostProvider);
        final String str3 = str2;
        final String str4 = str;
        final Card card2 = card;
        final Date date2 = date;
        return new Callable<String>() {
            public String call() throws Exception {
                return Cards.ENCRYPTOR.encrypt(str4, card2, date2, instance.getPublicKey(str3).call()).call();
            }
        };
    }
}
