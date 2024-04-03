package com.talabat.feature.subscriptions.domain.model;

import com.talabat.configuration.country.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/CountryParams;", "", "country", "Lcom/talabat/configuration/country/Country;", "(Lcom/talabat/configuration/country/Country;)V", "getCountry", "()Lcom/talabat/configuration/country/Country;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryParams {
    @NotNull
    private final Country country;

    public CountryParams(@NotNull Country country2) {
        Intrinsics.checkNotNullParameter(country2, "country");
        this.country = country2;
    }

    public static /* synthetic */ CountryParams copy$default(CountryParams countryParams, Country country2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            country2 = countryParams.country;
        }
        return countryParams.copy(country2);
    }

    @NotNull
    public final Country component1() {
        return this.country;
    }

    @NotNull
    public final CountryParams copy(@NotNull Country country2) {
        Intrinsics.checkNotNullParameter(country2, "country");
        return new CountryParams(country2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CountryParams) && this.country == ((CountryParams) obj).country;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    public int hashCode() {
        return this.country.hashCode();
    }

    @NotNull
    public String toString() {
        Country country2 = this.country;
        return "CountryParams(country=" + country2 + ")";
    }
}
