package com.talabat.talabatcommon.views.wallet.walletCardManagement.model;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardCVVState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateCardNumberState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletValidateExpiryDateState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ,\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardValidator;", "", "()V", "getCardType", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardType;", "cardNumber", "", "isAmexAvailable", "", "getFilledCard", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletCardModel;", "cardExpiry", "securityCode", "isCardHolderNameFlagEnabled", "isLuhnValid", "removeWhiteSpaces", "text", "validateCVV", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardCVVState;", "walletCardType", "cvv", "isViewFilled", "validateCardExpiryDate", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateExpiryDateState;", "expiryDate", "validateCardNumber", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletValidateCardNumberState;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardValidator {
    @NotNull
    public static final WalletCardValidator INSTANCE = new WalletCardValidator();

    private WalletCardValidator() {
    }

    public static /* synthetic */ WalletCardType getCardType$default(WalletCardValidator walletCardValidator, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return walletCardValidator.getCardType(str, z11);
    }

    private final boolean isLuhnValid(String str) {
        String stringBuffer = new StringBuffer(str).reverse().toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer, "StringBuffer(cardNumber).reverse().toString()");
        int length = stringBuffer.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char charAt = stringBuffer.charAt(i13);
            if (!Character.isDigit(charAt)) {
                return false;
            }
            int digit = Character.digit(charAt, 10);
            if (i13 % 2 == 0) {
                i11 += digit;
            } else {
                i12 += (digit / 5) + ((digit * 2) % 10);
            }
        }
        if ((i11 + i12) % 10 == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final WalletCardType getCardType(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        String take = StringsKt___StringsKt.take(str, 4);
        if (WalletCardValidatorKt.VISA_PATTERN.matcher(take).find()) {
            return WalletCardType.VISA;
        }
        if (WalletCardValidatorKt.VISA_ELECTRON_PATTERN.matcher(take).find()) {
            return WalletCardType.VISA;
        }
        if (WalletCardValidatorKt.MASTERCARD_PATTERN.matcher(take).find()) {
            return WalletCardType.MASTER_CARD;
        }
        if (WalletCardValidatorKt.AMEX_PATTERN.matcher(take).find()) {
            if (z11) {
                return WalletCardType.AMEX;
            }
            return WalletCardType.UN_KNOWN;
        } else if (WalletCardValidatorKt.MEEZA_CARD_PATTERN.matcher(take).find()) {
            return WalletCardType.MEEZA;
        } else {
            return WalletCardType.UN_KNOWN;
        }
    }

    @NotNull
    public final WalletCardModel getFilledCard(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11) {
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (str2 != null) {
            str4 = StringsKt___StringsKt.take(str2, 2);
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (str2 != null) {
            str7 = StringsKt___StringsKt.takeLast(str2, 2);
        }
        if (str7 == null) {
            str6 = "";
        } else {
            str6 = str7;
        }
        String removeWhiteSpaces = removeWhiteSpaces(str);
        String removeWhiteSpaces2 = removeWhiteSpaces(str3);
        String take = StringsKt___StringsKt.take(removeWhiteSpaces(str), 6);
        String empty = StringUtils.empty(StringCompanionObject.INSTANCE);
        if (z11) {
            empty = "Talabat";
        }
        return new WalletCardModel(removeWhiteSpaces, take, str5, str6, removeWhiteSpaces2, empty);
    }

    @NotNull
    public final String removeWhiteSpaces(@Nullable String str) {
        String str2;
        if (str != null) {
            str2 = new Regex("\\s").replace((CharSequence) str, "");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @NotNull
    public final WalletValidateCardCVVState validateCVV(@NotNull WalletCardType walletCardType, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(walletCardType, "walletCardType");
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_CVV_KEY);
        if (z11 && str.length() != walletCardType.getCvvLength()) {
            return WalletValidateCardCVVState.FailureValidateCVVState.INSTANCE;
        }
        if (str.length() == walletCardType.getCvvLength()) {
            return WalletValidateCardCVVState.SuccessValidateCVVState.INSTANCE;
        }
        return WalletValidateCardCVVState.DefaultValidateCVVState.INSTANCE;
    }

    @NotNull
    public final WalletValidateExpiryDateState validateCardExpiryDate(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "expiryDate");
        String take = StringsKt___StringsKt.take(str, 2);
        String takeLast = StringsKt___StringsKt.takeLast(str, 2);
        if (z11 && str.length() != 5) {
            return new WalletValidateExpiryDateState.FailureValidateExpiryDate(WalletCardExpiryDateValidationErrorState.INVALID);
        }
        if (str.length() == 5 && WalletCardListMapper.Companion.hasCardExpired(take, takeLast)) {
            return new WalletValidateExpiryDateState.FailureValidateExpiryDate(WalletCardExpiryDateValidationErrorState.EXPIRED);
        }
        if (str.length() != 5 || WalletCardListMapper.Companion.hasCardExpired(take, takeLast)) {
            return WalletValidateExpiryDateState.DefaultValidateExpiryDate.INSTANCE;
        }
        return WalletValidateExpiryDateState.SuccessValidateExpiryDate.INSTANCE;
    }

    @NotNull
    public final WalletValidateCardNumberState validateCardNumber(@NotNull String str, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        int cardNumberLength = getCardType(str, z12).getCardNumberLength();
        WalletCardType cardType = getCardType(str, z12);
        if (str.length() >= 4 && cardType == WalletCardType.UN_KNOWN) {
            return new WalletValidateCardNumberState.FailureValidateCardNumber(WalletCardNumberValidationErrorState.CARD_NOT_SUPPORTED);
        }
        if (z11 && str.length() != cardNumberLength) {
            return new WalletValidateCardNumberState.FailureValidateCardNumber(WalletCardNumberValidationErrorState.INVALID_CARD_LENGTH);
        }
        if (cardNumberLength == str.length() && !isLuhnValid(str)) {
            return new WalletValidateCardNumberState.FailureValidateCardNumber(WalletCardNumberValidationErrorState.INVALID_CARD);
        }
        if (cardNumberLength == str.length() && isLuhnValid(str) && cardType != WalletCardType.UN_KNOWN) {
            return WalletValidateCardNumberState.SuccessValidateCardNumber.INSTANCE;
        }
        if (str.length() < 4 || cardType == WalletCardType.UN_KNOWN) {
            return WalletValidateCardNumberState.DefaultValidateCardNumber.INSTANCE;
        }
        return new WalletValidateCardNumberState.ShowCardIcon(cardType);
    }
}
