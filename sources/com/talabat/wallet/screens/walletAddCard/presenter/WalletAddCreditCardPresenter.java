package com.talabat.wallet.screens.walletAddCard.presenter;

import JsonModels.Response.WalletSaveCreditCardResponse;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.screens.walletAddCard.WalletAddCardListener;
import com.talabat.wallet.screens.walletAddCard.interactor.WalletAddCreditCardInteractor;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardView;
import datamodels.Country;
import datamodels.WalletCreditCard;
import io.reactivex.Scheduler;
import java.util.Calendar;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u001a\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020%H\u0016J\u0012\u0010.\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u000fH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/presenter/WalletAddCreditCardPresenter;", "Lcom/talabat/wallet/screens/walletAddCard/presenter/IWalletAddCreditCardPresenter;", "Lcom/talabat/wallet/screens/walletAddCard/WalletAddCardListener;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "walletAddCreditCardView", "Lcom/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardView;", "(Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/payment/PaymentConfigurationRepository;Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;Lcom/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardView;)V", "AMEX", "", "MASTERCARD", "MEEZACARD", "VISA", "walletAddCreditCardInteractor", "Lcom/talabat/wallet/screens/walletAddCard/interactor/WalletAddCreditCardInteractor;", "getCreditCardNumberLength", "", "paymentOption", "getMaximumLengthForSecurityCode", "getPaymentMethodOptionName", "cardBin", "isLuhnValid", "", "cardNumber", "onCardErrorReceived", "", "message", "onCheckoutResponseReceived", "response", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/CheckoutResponse;", "walletCreditCard", "Ldatamodels/WalletCreditCard;", "onDestroy", "onNetworkError", "onServerError", "onWalletSaveCardResponseReceived", "walletSaveCreditCardResponse", "LJsonModels/Response/WalletSaveCreditCardResponse;", "saveCreditCard", "card", "setWalletAddCreditCardInteractor", "validateExpiryDate", "filledDate", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardPresenter implements IWalletAddCreditCardPresenter, WalletAddCardListener {
    @NotNull
    private final String AMEX = "AMEX";
    @NotNull
    private final String MASTERCARD = "MASTERCARD";
    @NotNull
    private final String MEEZACARD = "Meeza";
    @NotNull
    private final String VISA = "VISA";
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    @Nullable
    private WalletAddCreditCardInteractor walletAddCreditCardInteractor;
    @Nullable
    private WalletAddCreditCardView walletAddCreditCardView;

    public WalletAddCreditCardPresenter(@NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull PaymentConfigurationRepository paymentConfigurationRepository2, @NotNull GenerateCardTokenUseCase generateCardTokenUseCase, @NotNull WalletAddCreditCardView walletAddCreditCardView2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "paymentConfigurationRepository");
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase, "generateCardTokenUseCase");
        Intrinsics.checkNotNullParameter(walletAddCreditCardView2, "walletAddCreditCardView");
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        LogManager.debug("[ALOV]: WalletAddCreditCardPresenter::init");
        this.walletAddCreditCardInteractor = new WalletAddCreditCardInteractor(generateCardTokenUseCase, (Scheduler) null, (Scheduler) null, this, 6, (DefaultConstructorMarker) null);
        this.walletAddCreditCardView = walletAddCreditCardView2;
    }

    public int getCreditCardNumberLength(@Nullable String str) {
        if (!TalabatUtils.isNullOrEmpty(str) && Intrinsics.areEqual((Object) this.AMEX, (Object) str)) {
            return 15;
        }
        return 16;
    }

    public int getMaximumLengthForSecurityCode(@Nullable String str) {
        if (!TalabatUtils.isNullOrEmpty(str) && Intrinsics.areEqual((Object) this.AMEX, (Object) str)) {
            return 4;
        }
        return 3;
    }

    @Nullable
    public String getPaymentMethodOptionName(@Nullable String str) {
        try {
            Pattern compile = Pattern.compile("^4\\d*");
            Pattern compile2 = Pattern.compile("^4(026|17500|405|508|844|91[37])");
            Pattern compile3 = Pattern.compile("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)\\d*");
            Pattern compile4 = Pattern.compile("^3[47]\\d*");
            Pattern compile5 = Pattern.compile("^(6011|65|64[4-9]|622)\\d*");
            Pattern compile6 = Pattern.compile("^(36|38|30[0-5])\\d*");
            Pattern compile7 = Pattern.compile("^35\\d*");
            Pattern compile8 = Pattern.compile("^(5018|5020|5038|6020|6304|6703|6759|676[1-3])\\d*");
            Pattern compile9 = Pattern.compile("^62\\d*");
            Pattern compile10 = Pattern.compile("^5078\\d*");
            if (str == null) {
                return null;
            }
            if (compile.matcher(str).find()) {
                return this.VISA;
            }
            if (compile2.matcher(str).find()) {
                return this.VISA;
            }
            if (compile3.matcher(str).find()) {
                return this.MASTERCARD;
            }
            if (!compile4.matcher(str).find()) {
                if (!compile5.matcher(str).find() && !compile6.matcher(str).find() && !compile7.matcher(str).find() && !compile8.matcher(str).find() && !compile9.matcher(str).find() && compile10.matcher(str).find()) {
                    return this.MEEZACARD;
                }
                return null;
            } else if (this.paymentConfigurationRepository.walletConfig().isAmexAvailable()) {
                return this.AMEX;
            } else {
                return null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean isLuhnValid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
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

    public void onCardErrorReceived(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        LogManager.debug("[ALOV]: onCardErrorReceived :: " + str);
        WalletAddCreditCardView walletAddCreditCardView2 = this.walletAddCreditCardView;
        if (walletAddCreditCardView2 != null) {
            walletAddCreditCardView2.onErrorReceived();
        }
    }

    public void onCheckoutResponseReceived(@NotNull CheckoutResponse checkoutResponse, @NotNull WalletCreditCard walletCreditCard) {
        Intrinsics.checkNotNullParameter(checkoutResponse, "response");
        Intrinsics.checkNotNullParameter(walletCreditCard, "walletCreditCard");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            LogManager.debug("[ALOV]: onCheckoutResponseReceived: " + selectedCountry + " :: " + checkoutResponse + " :: " + walletCreditCard);
            WalletAddCreditCardInteractor walletAddCreditCardInteractor2 = this.walletAddCreditCardInteractor;
            if (walletAddCreditCardInteractor2 != null) {
                String token = checkoutResponse.getToken();
                String valueOf = String.valueOf(selectedCountry.f13845id);
                String str = GlobalDataModel.SelectedLanguage;
                Intrinsics.checkNotNullExpressionValue(str, "SelectedLanguage");
                walletAddCreditCardInteractor2.postCard(walletCreditCard, token, valueOf, str);
            }
        }
    }

    public void onDestroy() {
        this.walletAddCreditCardView = null;
    }

    public void onNetworkError() {
        LogManager.debug("[ALOV]: onNetworkError");
        WalletAddCreditCardView walletAddCreditCardView2 = this.walletAddCreditCardView;
        if (walletAddCreditCardView2 != null) {
            walletAddCreditCardView2.onNetworkError();
        }
    }

    public void onServerError() {
        LogManager.debug("[ALOV]: onServerError");
        WalletAddCreditCardView walletAddCreditCardView2 = this.walletAddCreditCardView;
        if (walletAddCreditCardView2 != null) {
            walletAddCreditCardView2.onServerError();
        }
    }

    public void onWalletSaveCardResponseReceived(@Nullable WalletSaveCreditCardResponse walletSaveCreditCardResponse, @NotNull WalletCreditCard walletCreditCard) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(walletCreditCard, "walletCreditCard");
        LogManager.debug("[ALOV]: onWalletSaveCardResponseReceived :: " + walletSaveCreditCardResponse + " :: " + walletCreditCard);
        Integer num = null;
        if (walletSaveCreditCardResponse != null) {
            bool = walletSaveCreditCardResponse.isValid();
        } else {
            bool = null;
        }
        if (walletSaveCreditCardResponse != null) {
            num = walletSaveCreditCardResponse.getVerificationCode();
        }
        if (bool != null && bool.booleanValue() && num != null && num.intValue() == 1) {
            WalletAddCreditCardView walletAddCreditCardView2 = this.walletAddCreditCardView;
            if (walletAddCreditCardView2 != null) {
                walletAddCreditCardView2.openWebView(walletSaveCreditCardResponse.getRedirectUrl());
            }
        } else if (bool == null || !bool.booleanValue() || num == null || num.intValue() != 0) {
            WalletAddCreditCardView walletAddCreditCardView3 = this.walletAddCreditCardView;
            if (walletAddCreditCardView3 != null) {
                walletAddCreditCardView3.onErrorReceived();
            }
        } else {
            WalletAddCreditCardView walletAddCreditCardView4 = this.walletAddCreditCardView;
            if (walletAddCreditCardView4 != null) {
                walletAddCreditCardView4.onNonThreeDSCardSaved();
            }
        }
    }

    public void saveCreditCard(@NotNull WalletCreditCard walletCreditCard) {
        Intrinsics.checkNotNullParameter(walletCreditCard, "card");
        Customer instance = Customer.getInstance();
        if (instance != null && instance.isLoggedIn()) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
            WalletAddCreditCardView walletAddCreditCardView2 = this.walletAddCreditCardView;
            if (walletAddCreditCardView2 != null) {
                walletAddCreditCardView2.setUpViewBeforeResponse();
            }
            WalletAddCreditCardInteractor walletAddCreditCardInteractor2 = this.walletAddCreditCardInteractor;
            if (walletAddCreditCardInteractor2 != null) {
                String valueOf = String.valueOf(selectedCountry.f13845id);
                String str = GlobalDataModel.SelectedLanguage;
                Intrinsics.checkNotNullExpressionValue(str, "SelectedLanguage");
                walletAddCreditCardInteractor2.postCreditCardToCheckout(walletCreditCard, valueOf, str);
            }
        }
    }

    @VisibleForTesting
    public final void setWalletAddCreditCardInteractor(@Nullable WalletAddCreditCardInteractor walletAddCreditCardInteractor2) {
        this.walletAddCreditCardInteractor = walletAddCreditCardInteractor2;
    }

    public boolean validateExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "filledDate");
        if (str.length() == 5) {
            try {
                int parseInt = Integer.parseInt(StringsKt__StringsKt.substring(str, new IntRange(0, 1)));
                String substring = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                int parseInt2 = Integer.parseInt(substring);
                String substring2 = String.valueOf(Calendar.getInstance().get(1)).substring(2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                int parseInt3 = Integer.parseInt(substring2);
                int i11 = Calendar.getInstance().get(2) + 1;
                if (parseInt3 > parseInt2) {
                    return false;
                }
                if (i11 < parseInt || parseInt3 != parseInt2) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
