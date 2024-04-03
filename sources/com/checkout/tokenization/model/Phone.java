package com.checkout.tokenization.model;

import com.checkout.base.model.Country;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/tokenization/model/Phone;", "", "number", "", "country", "Lcom/checkout/base/model/Country;", "(Ljava/lang/String;Lcom/checkout/base/model/Country;)V", "getCountry", "()Lcom/checkout/base/model/Country;", "getNumber", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Phone {
    @NotNull
    private final Country country;
    @NotNull
    private final String number;

    public Phone(@NotNull String str, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(country2, "country");
        this.number = str;
        this.country = country2;
    }

    public static /* synthetic */ Phone copy$default(Phone phone, String str, Country country2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = phone.number;
        }
        if ((i11 & 2) != 0) {
            country2 = phone.country;
        }
        return phone.copy(str, country2);
    }

    @NotNull
    public final String component1() {
        return this.number;
    }

    @NotNull
    public final Country component2() {
        return this.country;
    }

    @NotNull
    public final Phone copy(@NotNull String str, @NotNull Country country2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(country2, "country");
        return new Phone(str, country2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) obj;
        return Intrinsics.areEqual((Object) this.number, (Object) phone.number) && this.country == phone.country;
    }

    @NotNull
    public final Country getCountry() {
        return this.country;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.country.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.number;
        Country country2 = this.country;
        return "Phone(number=" + str + ", country=" + country2 + ")";
    }
}
