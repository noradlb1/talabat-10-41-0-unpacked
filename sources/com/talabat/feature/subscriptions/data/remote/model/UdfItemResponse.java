package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/UdfItemResponse;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UdfItemResponse {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String IS_FREE_COFFEE_ENABLED = "isFreeCoffeeEnabled";
    @NotNull
    public static final String MDF = "minimumDeliveryFee";
    @NotNull
    private final String key;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/UdfItemResponse$Companion;", "", "()V", "IS_FREE_COFFEE_ENABLED", "", "MDF", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UdfItemResponse(@NotNull @Json(name = "key") String str, @NotNull @Json(name = "value") String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.key = str;
        this.value = str2;
    }

    public static /* synthetic */ UdfItemResponse copy$default(UdfItemResponse udfItemResponse, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = udfItemResponse.key;
        }
        if ((i11 & 2) != 0) {
            str2 = udfItemResponse.value;
        }
        return udfItemResponse.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.key;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final UdfItemResponse copy(@NotNull @Json(name = "key") String str, @NotNull @Json(name = "value") String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new UdfItemResponse(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UdfItemResponse)) {
            return false;
        }
        UdfItemResponse udfItemResponse = (UdfItemResponse) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) udfItemResponse.key) && Intrinsics.areEqual((Object) this.value, (Object) udfItemResponse.value);
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.key;
        String str2 = this.value;
        return "UdfItemResponse(key=" + str + ", value=" + str2 + ")";
    }
}
