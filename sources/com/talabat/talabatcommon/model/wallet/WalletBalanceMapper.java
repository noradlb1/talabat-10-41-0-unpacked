package com.talabat.talabatcommon.model.wallet;

import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.location.LocationExtensionsKt;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResultModel;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletBalanceMapper;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletBalanceMapper$Companion;", "", "()V", "mapWalletBalanceResponse", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WalletBalanceDisplayModel mapWalletBalanceResponse(@Nullable WalletCreditBalanceResponse walletCreditBalanceResponse, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
            Float balanceAmount;
            Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
            WalletBalanceDisplayModel walletBalanceDisplayModel = new WalletBalanceDisplayModel();
            if (walletCreditBalanceResponse != null) {
                ArrayList<WalletErrorMessageModel> responseMessages = walletCreditBalanceResponse.getResponseMessages();
                if (responseMessages != null) {
                    walletBalanceDisplayModel.setServerErrorMessage(WalletErrorModelMapper.Companion.extractServerError(responseMessages));
                }
                WalletCreditBalanceResultModel result = walletCreditBalanceResponse.getResult();
                if (!(result == null || (balanceAmount = result.getBalanceAmount()) == null)) {
                    float floatValue = balanceAmount.floatValue();
                    Country selectedCountry = locationConfigurationRepository.selectedCountry();
                    Intrinsics.checkNotNull(selectedCountry);
                    walletBalanceDisplayModel.setWalletBalanceLoaded(true);
                    walletBalanceDisplayModel.setAmountCurrency(selectedCountry.getCurrencyCode());
                    try {
                        walletBalanceDisplayModel.setWalletBalance(Float.parseFloat(CurrencyFormatter.Companion.getFormattedCurrency((double) floatValue, false, selectedCountry.getCurrencyCode(), selectedCountry.getNumberOfDecimalPlaces(), LocationExtensionsKt.decimalPattern(selectedCountry))));
                    } catch (Exception unused) {
                    }
                }
            }
            return walletBalanceDisplayModel;
        }
    }
}
