package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0001\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0016\b\u0001\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003Je\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\u0016\b\u0003\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/Financial;", "", "id", "", "paymentMedium", "", "currencyCode", "refundValue", "", "compensationValue", "details", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;IILjava/util/Map;)V", "getCompensationValue", "()I", "getCurrencyCode", "()Ljava/lang/String;", "getDetails", "()Ljava/util/Map;", "getId", "getPaymentMedium", "getRefundValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Financial {
    private final int compensationValue;
    @Nullable
    private final String currencyCode;
    @Nullable
    private final Map<String, String> details;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f29802id;
    @Nullable
    private final Map<String, String> paymentMedium;
    private final int refundValue;

    public Financial(@NotNull @Json(name = "id") String str, @Nullable @Json(name = "paymentMedium") Map<String, String> map, @Nullable @Json(name = "currencyCode") String str2, @Json(name = "refundValue") int i11, @Json(name = "compensationValue") int i12, @Nullable @Json(name = "details") Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f29802id = str;
        this.paymentMedium = map;
        this.currencyCode = str2;
        this.refundValue = i11;
        this.compensationValue = i12;
        this.details = map2;
    }

    public static /* synthetic */ Financial copy$default(Financial financial, String str, Map<String, String> map, String str2, int i11, int i12, Map<String, String> map2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = financial.f29802id;
        }
        if ((i13 & 2) != 0) {
            map = financial.paymentMedium;
        }
        Map<String, String> map3 = map;
        if ((i13 & 4) != 0) {
            str2 = financial.currencyCode;
        }
        String str3 = str2;
        if ((i13 & 8) != 0) {
            i11 = financial.refundValue;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = financial.compensationValue;
        }
        int i15 = i12;
        if ((i13 & 32) != 0) {
            map2 = financial.details;
        }
        return financial.copy(str, map3, str3, i14, i15, map2);
    }

    @NotNull
    public final String component1() {
        return this.f29802id;
    }

    @Nullable
    public final Map<String, String> component2() {
        return this.paymentMedium;
    }

    @Nullable
    public final String component3() {
        return this.currencyCode;
    }

    public final int component4() {
        return this.refundValue;
    }

    public final int component5() {
        return this.compensationValue;
    }

    @Nullable
    public final Map<String, String> component6() {
        return this.details;
    }

    @NotNull
    public final Financial copy(@NotNull @Json(name = "id") String str, @Nullable @Json(name = "paymentMedium") Map<String, String> map, @Nullable @Json(name = "currencyCode") String str2, @Json(name = "refundValue") int i11, @Json(name = "compensationValue") int i12, @Nullable @Json(name = "details") Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new Financial(str, map, str2, i11, i12, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Financial)) {
            return false;
        }
        Financial financial = (Financial) obj;
        return Intrinsics.areEqual((Object) this.f29802id, (Object) financial.f29802id) && Intrinsics.areEqual((Object) this.paymentMedium, (Object) financial.paymentMedium) && Intrinsics.areEqual((Object) this.currencyCode, (Object) financial.currencyCode) && this.refundValue == financial.refundValue && this.compensationValue == financial.compensationValue && Intrinsics.areEqual((Object) this.details, (Object) financial.details);
    }

    public final int getCompensationValue() {
        return this.compensationValue;
    }

    @Nullable
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @Nullable
    public final Map<String, String> getDetails() {
        return this.details;
    }

    @NotNull
    public final String getId() {
        return this.f29802id;
    }

    @Nullable
    public final Map<String, String> getPaymentMedium() {
        return this.paymentMedium;
    }

    public final int getRefundValue() {
        return this.refundValue;
    }

    public int hashCode() {
        int hashCode = this.f29802id.hashCode() * 31;
        Map<String, String> map = this.paymentMedium;
        int i11 = 0;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.currencyCode;
        int hashCode3 = (((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.refundValue) * 31) + this.compensationValue) * 31;
        Map<String, String> map2 = this.details;
        if (map2 != null) {
            i11 = map2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        return "Financial(id=" + this.f29802id + ", paymentMedium=" + this.paymentMedium + ", currencyCode=" + this.currencyCode + ", refundValue=" + this.refundValue + ", compensationValue=" + this.compensationValue + ", details=" + this.details + ')';
    }
}
