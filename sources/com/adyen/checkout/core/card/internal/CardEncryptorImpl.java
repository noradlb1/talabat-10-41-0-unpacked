package com.adyen.checkout.core.card.internal;

import adyen.com.adyencse.encrypter.exception.EncrypterException;
import adyen.com.adyencse.pojo.Card;
import android.support.annotation.NonNull;
import com.adyen.checkout.core.card.Card;
import com.adyen.checkout.core.card.CardEncryptor;
import com.adyen.checkout.core.card.EncryptedCard;
import com.adyen.checkout.core.card.EncryptionException;
import java.util.Date;
import java.util.concurrent.Callable;

public final class CardEncryptorImpl implements CardEncryptor {
    @NonNull
    public Callable<String> encrypt(@NonNull String str, @NonNull Card card, @NonNull Date date, @NonNull String str2) {
        final Card card2 = card;
        final String str3 = str;
        final Date date2 = date;
        final String str4 = str2;
        return new Callable<String>() {
            public String call() throws Exception {
                Integer expiryMonth = card2.getExpiryMonth();
                Integer expiryYear = card2.getExpiryYear();
                String str = null;
                String valueOf = expiryMonth != null ? String.valueOf(expiryMonth) : null;
                if (expiryYear != null) {
                    str = String.valueOf(expiryYear);
                }
                return new Card.Builder().setHolderName(str3).setNumber(card2.getNumber()).setExpiryMonth(valueOf).setExpiryYear(str).setCvc(card2.getSecurityCode()).setGenerationTime(date2).build().serialize(str4);
            }
        };
    }

    @NonNull
    public Callable<EncryptedCard> encryptFields(@NonNull final com.adyen.checkout.core.card.Card card, @NonNull final Date date, @NonNull final String str) {
        return new Callable<EncryptedCard>() {
            public EncryptedCard call() throws Exception {
                String str;
                try {
                    String number = card.getNumber();
                    String str2 = null;
                    String serialize = number != null ? new Card.Builder().setNumber(number).setGenerationTime(date).build().serialize(str) : null;
                    Integer expiryMonth = card.getExpiryMonth();
                    Integer expiryYear = card.getExpiryYear();
                    if (expiryMonth != null && expiryYear != null) {
                        str2 = new Card.Builder().setExpiryMonth(String.valueOf(expiryMonth)).setGenerationTime(date).build().serialize(str);
                        str = new Card.Builder().setExpiryYear(String.valueOf(expiryYear)).setGenerationTime(date).build().serialize(str);
                    } else if (expiryMonth == null && expiryYear == null) {
                        str = null;
                    } else {
                        throw new IllegalStateException("Both expiryMonth and expiryYear need to be set for encryption.");
                    }
                    String serialize2 = new Card.Builder().setCvc(card.getSecurityCode()).setGenerationTime(date).build().serialize(str);
                    EncryptedCard.Builder encryptedNumber = new EncryptedCard.Builder().setEncryptedNumber(serialize);
                    if (str2 == null || str == null) {
                        encryptedNumber.clearEncryptedExpiryDate();
                    } else {
                        encryptedNumber.setEncryptedExpiryDate(str2, str);
                    }
                    return encryptedNumber.setEncryptedSecurityCode(serialize2).build();
                } catch (EncrypterException e11) {
                    throw new EncryptionException(e11.getMessage(), e11.getCause());
                }
            }
        };
    }
}
