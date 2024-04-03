package com.talabat.wallet.helpers;

import android.util.SparseArray;
import com.talabat.configuration.country.Country;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068BX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/helpers/WalletFunWithFlagHelper;", "", "()V", "DEFAULT_COUNTRY", "", "countries", "Landroid/util/SparseArray;", "getCountries", "()Landroid/util/SparseArray;", "getSubscriptionFeatureFwfKey", "feature", "getWalletFeatureFwfKey", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletFunWithFlagHelper {
    @NotNull
    private static final String DEFAULT_COUNTRY = "kwt";
    @NotNull
    public static final WalletFunWithFlagHelper INSTANCE = new WalletFunWithFlagHelper();
    @NotNull
    private static final SparseArray<String> countries = new SparseArray<>();

    private WalletFunWithFlagHelper() {
    }

    private final SparseArray<String> getCountries() {
        SparseArray<String> sparseArray = countries;
        sparseArray.put(Country.KUWAIT.getCountryId(), DEFAULT_COUNTRY);
        sparseArray.put(Country.KSA.getCountryId(), "ksa");
        sparseArray.put(Country.BAHRAIN.getCountryId(), "bhr");
        sparseArray.put(Country.UAE.getCountryId(), "uae");
        sparseArray.put(Country.OMAN.getCountryId(), "omn");
        sparseArray.put(Country.QATAR.getCountryId(), "qat");
        sparseArray.put(Country.LEBANON.getCountryId(), "lbn");
        sparseArray.put(Country.JORDAN.getCountryId(), "jor");
        sparseArray.put(Country.EGYPT.getCountryId(), "egy");
        sparseArray.put(Country.IRAQ.getCountryId(), "irq");
        return sparseArray;
    }

    @NotNull
    public final String getSubscriptionFeatureFwfKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        String str2 = getCountries().get(GlobalDataModel.SelectedCountryId);
        if (str2 == null) {
            str2 = DEFAULT_COUNTRY;
        }
        return "subscription-android-" + str + str2;
    }

    @NotNull
    public final String getWalletFeatureFwfKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "feature");
        String str2 = getCountries().get(GlobalDataModel.SelectedCountryId);
        if (str2 == null) {
            str2 = DEFAULT_COUNTRY;
        }
        return "wallet-android-" + str + PayFeatureFlagConstants.ENABLED_STRING + str2;
    }
}
