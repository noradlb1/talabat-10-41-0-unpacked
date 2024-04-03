package com.talabat.configuration.location;

import com.visa.checkout.PurchaseInfo;
import java.util.Currency;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b'\b\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0018HÆ\u0003J\t\u00100\u001a\u00020\u0018HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J¹\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018HÆ\u0001J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0018HÖ\u0001J\t\u0010=\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&¨\u0006?"}, d2 = {"Lcom/talabat/configuration/location/Country;", "", "country", "Lcom/talabat/configuration/country/Country;", "canShowCollectionWidget", "", "cities", "", "Lcom/talabat/configuration/location/City;", "currency", "Ljava/util/Currency;", "currencyCode", "", "isCity", "isComplianceEnabled", "isContactlessPaymentEnabled", "isDefault", "isI18nSupported", "isMapEnabled", "isTalabatCreditEnabled", "isTalabatPayEnabled", "isTokenizationEnabled", "isVisaCheckoutAvailable", "numberOfDecimalPlaces", "", "tokenizationProvider", "(Lcom/talabat/configuration/country/Country;ZLjava/util/List;Ljava/util/Currency;Ljava/lang/String;ZZZZZZZZZZII)V", "getCanShowCollectionWidget", "()Z", "getCities", "()Ljava/util/List;", "getCountry", "()Lcom/talabat/configuration/country/Country;", "getCurrency", "()Ljava/util/Currency;", "getCurrencyCode", "()Ljava/lang/String;", "getNumberOfDecimalPlaces", "()I", "getTokenizationProvider", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Country {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean canShowCollectionWidget;
    @NotNull
    private final List<City> cities;
    @NotNull
    private final com.talabat.configuration.country.Country country;
    @NotNull
    private final Currency currency;
    @NotNull
    private final String currencyCode;
    private final boolean isCity;
    private final boolean isComplianceEnabled;
    private final boolean isContactlessPaymentEnabled;
    private final boolean isDefault;
    private final boolean isI18nSupported;
    private final boolean isMapEnabled;
    private final boolean isTalabatCreditEnabled;
    private final boolean isTalabatPayEnabled;
    private final boolean isTokenizationEnabled;
    private final boolean isVisaCheckoutAvailable;
    private final int numberOfDecimalPlaces;
    private final int tokenizationProvider;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/configuration/location/Country$Companion;", "", "()V", "default", "Lcom/talabat/configuration/location/Country;", "country", "Lcom/talabat/configuration/country/Country;", "currencyCode", "", "numberOfDecimalPlaces", "", "isTokenizationEnabled", "", "tokenizationProvider", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Country default$default(Companion companion, com.talabat.configuration.country.Country country, String str, int i11, boolean z11, int i12, int i13, Object obj) {
            boolean z12;
            int i14;
            if ((i13 & 2) != 0) {
                str = PurchaseInfo.Currency.AED;
            }
            String str2 = str;
            if ((i13 & 4) != 0) {
                i11 = 2;
            }
            int i15 = i11;
            if ((i13 & 8) != 0) {
                z12 = false;
            } else {
                z12 = z11;
            }
            if ((i13 & 16) != 0) {
                i14 = 0;
            } else {
                i14 = i12;
            }
            return companion.m9575default(country, str2, i15, z12, i14);
        }

        @NotNull
        /* renamed from: default  reason: not valid java name */
        public final Country m9575default(@NotNull com.talabat.configuration.country.Country country, @NotNull String str, int i11, boolean z11, int i12) {
            boolean z12 = z11;
            Intrinsics.checkNotNullParameter(country, "country");
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            Currency instance = Currency.getInstance(PurchaseInfo.Currency.AED);
            Currency currency = instance;
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(\"AED\")");
            return new Country(country, false, emptyList, currency, str, false, false, false, false, false, false, false, false, z12, false, i11, i12);
        }
    }

    public Country(@NotNull com.talabat.configuration.country.Country country2, boolean z11, @NotNull List<City> list, @NotNull Currency currency2, @NotNull String str, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, boolean z22, int i11, int i12) {
        Intrinsics.checkNotNullParameter(country2, "country");
        Intrinsics.checkNotNullParameter(list, "cities");
        Intrinsics.checkNotNullParameter(currency2, "currency");
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        this.country = country2;
        this.canShowCollectionWidget = z11;
        this.cities = list;
        this.currency = currency2;
        this.currencyCode = str;
        this.isCity = z12;
        this.isComplianceEnabled = z13;
        this.isContactlessPaymentEnabled = z14;
        this.isDefault = z15;
        this.isI18nSupported = z16;
        this.isMapEnabled = z17;
        this.isTalabatCreditEnabled = z18;
        this.isTalabatPayEnabled = z19;
        this.isTokenizationEnabled = z21;
        this.isVisaCheckoutAvailable = z22;
        this.numberOfDecimalPlaces = i11;
        this.tokenizationProvider = i12;
    }

    public static /* synthetic */ Country copy$default(Country country2, com.talabat.configuration.country.Country country3, boolean z11, List list, Currency currency2, String str, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, boolean z22, int i11, int i12, int i13, Object obj) {
        Country country4 = country2;
        int i14 = i13;
        return country2.copy((i14 & 1) != 0 ? country4.country : country3, (i14 & 2) != 0 ? country4.canShowCollectionWidget : z11, (i14 & 4) != 0 ? country4.cities : list, (i14 & 8) != 0 ? country4.currency : currency2, (i14 & 16) != 0 ? country4.currencyCode : str, (i14 & 32) != 0 ? country4.isCity : z12, (i14 & 64) != 0 ? country4.isComplianceEnabled : z13, (i14 & 128) != 0 ? country4.isContactlessPaymentEnabled : z14, (i14 & 256) != 0 ? country4.isDefault : z15, (i14 & 512) != 0 ? country4.isI18nSupported : z16, (i14 & 1024) != 0 ? country4.isMapEnabled : z17, (i14 & 2048) != 0 ? country4.isTalabatCreditEnabled : z18, (i14 & 4096) != 0 ? country4.isTalabatPayEnabled : z19, (i14 & 8192) != 0 ? country4.isTokenizationEnabled : z21, (i14 & 16384) != 0 ? country4.isVisaCheckoutAvailable : z22, (i14 & 32768) != 0 ? country4.numberOfDecimalPlaces : i11, (i14 & 65536) != 0 ? country4.tokenizationProvider : i12);
    }

    @NotNull
    public final com.talabat.configuration.country.Country component1() {
        return this.country;
    }

    public final boolean component10() {
        return this.isI18nSupported;
    }

    public final boolean component11() {
        return this.isMapEnabled;
    }

    public final boolean component12() {
        return this.isTalabatCreditEnabled;
    }

    public final boolean component13() {
        return this.isTalabatPayEnabled;
    }

    public final boolean component14() {
        return this.isTokenizationEnabled;
    }

    public final boolean component15() {
        return this.isVisaCheckoutAvailable;
    }

    public final int component16() {
        return this.numberOfDecimalPlaces;
    }

    public final int component17() {
        return this.tokenizationProvider;
    }

    public final boolean component2() {
        return this.canShowCollectionWidget;
    }

    @NotNull
    public final List<City> component3() {
        return this.cities;
    }

    @NotNull
    public final Currency component4() {
        return this.currency;
    }

    @NotNull
    public final String component5() {
        return this.currencyCode;
    }

    public final boolean component6() {
        return this.isCity;
    }

    public final boolean component7() {
        return this.isComplianceEnabled;
    }

    public final boolean component8() {
        return this.isContactlessPaymentEnabled;
    }

    public final boolean component9() {
        return this.isDefault;
    }

    @NotNull
    public final Country copy(@NotNull com.talabat.configuration.country.Country country2, boolean z11, @NotNull List<City> list, @NotNull Currency currency2, @NotNull String str, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, boolean z22, int i11, int i12) {
        com.talabat.configuration.country.Country country3 = country2;
        Intrinsics.checkNotNullParameter(country3, "country");
        Intrinsics.checkNotNullParameter(list, "cities");
        Intrinsics.checkNotNullParameter(currency2, "currency");
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        return new Country(country3, z11, list, currency2, str, z12, z13, z14, z15, z16, z17, z18, z19, z21, z22, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country2 = (Country) obj;
        return this.country == country2.country && this.canShowCollectionWidget == country2.canShowCollectionWidget && Intrinsics.areEqual((Object) this.cities, (Object) country2.cities) && Intrinsics.areEqual((Object) this.currency, (Object) country2.currency) && Intrinsics.areEqual((Object) this.currencyCode, (Object) country2.currencyCode) && this.isCity == country2.isCity && this.isComplianceEnabled == country2.isComplianceEnabled && this.isContactlessPaymentEnabled == country2.isContactlessPaymentEnabled && this.isDefault == country2.isDefault && this.isI18nSupported == country2.isI18nSupported && this.isMapEnabled == country2.isMapEnabled && this.isTalabatCreditEnabled == country2.isTalabatCreditEnabled && this.isTalabatPayEnabled == country2.isTalabatPayEnabled && this.isTokenizationEnabled == country2.isTokenizationEnabled && this.isVisaCheckoutAvailable == country2.isVisaCheckoutAvailable && this.numberOfDecimalPlaces == country2.numberOfDecimalPlaces && this.tokenizationProvider == country2.tokenizationProvider;
    }

    public final boolean getCanShowCollectionWidget() {
        return this.canShowCollectionWidget;
    }

    @NotNull
    public final List<City> getCities() {
        return this.cities;
    }

    @NotNull
    public final com.talabat.configuration.country.Country getCountry() {
        return this.country;
    }

    @NotNull
    public final Currency getCurrency() {
        return this.currency;
    }

    @NotNull
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final int getNumberOfDecimalPlaces() {
        return this.numberOfDecimalPlaces;
    }

    public final int getTokenizationProvider() {
        return this.tokenizationProvider;
    }

    public int hashCode() {
        int hashCode = this.country.hashCode() * 31;
        boolean z11 = this.canShowCollectionWidget;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((((hashCode + (z11 ? 1 : 0)) * 31) + this.cities.hashCode()) * 31) + this.currency.hashCode()) * 31) + this.currencyCode.hashCode()) * 31;
        boolean z13 = this.isCity;
        if (z13) {
            z13 = true;
        }
        int i11 = (hashCode2 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isComplianceEnabled;
        if (z14) {
            z14 = true;
        }
        int i12 = (i11 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.isContactlessPaymentEnabled;
        if (z15) {
            z15 = true;
        }
        int i13 = (i12 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isDefault;
        if (z16) {
            z16 = true;
        }
        int i14 = (i13 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.isI18nSupported;
        if (z17) {
            z17 = true;
        }
        int i15 = (i14 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isMapEnabled;
        if (z18) {
            z18 = true;
        }
        int i16 = (i15 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isTalabatCreditEnabled;
        if (z19) {
            z19 = true;
        }
        int i17 = (i16 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.isTalabatPayEnabled;
        if (z21) {
            z21 = true;
        }
        int i18 = (i17 + (z21 ? 1 : 0)) * 31;
        boolean z22 = this.isTokenizationEnabled;
        if (z22) {
            z22 = true;
        }
        int i19 = (i18 + (z22 ? 1 : 0)) * 31;
        boolean z23 = this.isVisaCheckoutAvailable;
        if (!z23) {
            z12 = z23;
        }
        return ((((i19 + (z12 ? 1 : 0)) * 31) + this.numberOfDecimalPlaces) * 31) + this.tokenizationProvider;
    }

    public final boolean isCity() {
        return this.isCity;
    }

    public final boolean isComplianceEnabled() {
        return this.isComplianceEnabled;
    }

    public final boolean isContactlessPaymentEnabled() {
        return this.isContactlessPaymentEnabled;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean isI18nSupported() {
        return this.isI18nSupported;
    }

    public final boolean isMapEnabled() {
        return this.isMapEnabled;
    }

    public final boolean isTalabatCreditEnabled() {
        return this.isTalabatCreditEnabled;
    }

    public final boolean isTalabatPayEnabled() {
        return this.isTalabatPayEnabled;
    }

    public final boolean isTokenizationEnabled() {
        return this.isTokenizationEnabled;
    }

    public final boolean isVisaCheckoutAvailable() {
        return this.isVisaCheckoutAvailable;
    }

    @NotNull
    public String toString() {
        com.talabat.configuration.country.Country country2 = this.country;
        boolean z11 = this.canShowCollectionWidget;
        List<City> list = this.cities;
        Currency currency2 = this.currency;
        String str = this.currencyCode;
        boolean z12 = this.isCity;
        boolean z13 = this.isComplianceEnabled;
        boolean z14 = this.isContactlessPaymentEnabled;
        boolean z15 = this.isDefault;
        boolean z16 = this.isI18nSupported;
        boolean z17 = this.isMapEnabled;
        boolean z18 = this.isTalabatCreditEnabled;
        boolean z19 = this.isTalabatPayEnabled;
        boolean z21 = this.isTokenizationEnabled;
        boolean z22 = this.isVisaCheckoutAvailable;
        int i11 = this.numberOfDecimalPlaces;
        int i12 = this.tokenizationProvider;
        return "Country(country=" + country2 + ", canShowCollectionWidget=" + z11 + ", cities=" + list + ", currency=" + currency2 + ", currencyCode=" + str + ", isCity=" + z12 + ", isComplianceEnabled=" + z13 + ", isContactlessPaymentEnabled=" + z14 + ", isDefault=" + z15 + ", isI18nSupported=" + z16 + ", isMapEnabled=" + z17 + ", isTalabatCreditEnabled=" + z18 + ", isTalabatPayEnabled=" + z19 + ", isTokenizationEnabled=" + z21 + ", isVisaCheckoutAvailable=" + z22 + ", numberOfDecimalPlaces=" + i11 + ", tokenizationProvider=" + i12 + ")";
    }
}
