package com.checkout.tokenization.entity;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/tokenization/entity/PhoneEntity;", "", "number", "", "countryCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getNumber", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneEntity {
    @NotNull
    private final String countryCode;
    @NotNull
    private final String number;

    public PhoneEntity(@NotNull @Json(name = "number") String str, @NotNull @Json(name = "country_code") String str2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        this.number = str;
        this.countryCode = str2;
    }

    public static /* synthetic */ PhoneEntity copy$default(PhoneEntity phoneEntity, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = phoneEntity.number;
        }
        if ((i11 & 2) != 0) {
            str2 = phoneEntity.countryCode;
        }
        return phoneEntity.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.number;
    }

    @NotNull
    public final String component2() {
        return this.countryCode;
    }

    @NotNull
    public final PhoneEntity copy(@NotNull @Json(name = "number") String str, @NotNull @Json(name = "country_code") String str2) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        return new PhoneEntity(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneEntity)) {
            return false;
        }
        PhoneEntity phoneEntity = (PhoneEntity) obj;
        return Intrinsics.areEqual((Object) this.number, (Object) phoneEntity.number) && Intrinsics.areEqual((Object) this.countryCode, (Object) phoneEntity.countryCode);
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    public int hashCode() {
        return (this.number.hashCode() * 31) + this.countryCode.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.number;
        String str2 = this.countryCode;
        return "PhoneEntity(number=" + str + ", countryCode=" + str2 + ")";
    }
}
