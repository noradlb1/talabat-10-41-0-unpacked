package com.talabat.feature.fees.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/talabat/feature/fees/data/remote/dto/Fee;", "", "feeType", "", "name", "setupValue", "", "valueType", "", "total", "tags", "", "(Ljava/lang/String;Ljava/lang/String;DIDLjava/util/Map;)V", "getFeeType", "()Ljava/lang/String;", "getName", "getSetupValue", "()D", "getTags", "()Ljava/util/Map;", "getTotal", "getValueType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Fee {
    @NotNull
    private final String feeType;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58511name;
    private final double setupValue;
    @NotNull
    private final Map<String, Object> tags;
    private final double total;
    private final int valueType;

    public Fee(@NotNull @Json(name = "fee_type") String str, @NotNull String str2, @Json(name = "setup_value") double d11, @Json(name = "value_type") int i11, @Json(name = "total") double d12, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "feeType");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(map, "tags");
        this.feeType = str;
        this.f58511name = str2;
        this.setupValue = d11;
        this.valueType = i11;
        this.total = d12;
        this.tags = map;
    }

    public static /* synthetic */ Fee copy$default(Fee fee, String str, String str2, double d11, int i11, double d12, Map map, int i12, Object obj) {
        Fee fee2 = fee;
        return fee.copy((i12 & 1) != 0 ? fee2.feeType : str, (i12 & 2) != 0 ? fee2.f58511name : str2, (i12 & 4) != 0 ? fee2.setupValue : d11, (i12 & 8) != 0 ? fee2.valueType : i11, (i12 & 16) != 0 ? fee2.total : d12, (i12 & 32) != 0 ? fee2.tags : map);
    }

    @NotNull
    public final String component1() {
        return this.feeType;
    }

    @NotNull
    public final String component2() {
        return this.f58511name;
    }

    public final double component3() {
        return this.setupValue;
    }

    public final int component4() {
        return this.valueType;
    }

    public final double component5() {
        return this.total;
    }

    @NotNull
    public final Map<String, Object> component6() {
        return this.tags;
    }

    @NotNull
    public final Fee copy(@NotNull @Json(name = "fee_type") String str, @NotNull String str2, @Json(name = "setup_value") double d11, @Json(name = "value_type") int i11, @Json(name = "total") double d12, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "feeType");
        Intrinsics.checkNotNullParameter(str2, "name");
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "tags");
        return new Fee(str, str2, d11, i11, d12, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fee)) {
            return false;
        }
        Fee fee = (Fee) obj;
        return Intrinsics.areEqual((Object) this.feeType, (Object) fee.feeType) && Intrinsics.areEqual((Object) this.f58511name, (Object) fee.f58511name) && Intrinsics.areEqual((Object) Double.valueOf(this.setupValue), (Object) Double.valueOf(fee.setupValue)) && this.valueType == fee.valueType && Intrinsics.areEqual((Object) Double.valueOf(this.total), (Object) Double.valueOf(fee.total)) && Intrinsics.areEqual((Object) this.tags, (Object) fee.tags);
    }

    @NotNull
    public final String getFeeType() {
        return this.feeType;
    }

    @NotNull
    public final String getName() {
        return this.f58511name;
    }

    public final double getSetupValue() {
        return this.setupValue;
    }

    @NotNull
    public final Map<String, Object> getTags() {
        return this.tags;
    }

    public final double getTotal() {
        return this.total;
    }

    public final int getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return (((((((((this.feeType.hashCode() * 31) + this.f58511name.hashCode()) * 31) + Double.doubleToLongBits(this.setupValue)) * 31) + this.valueType) * 31) + Double.doubleToLongBits(this.total)) * 31) + this.tags.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.feeType;
        String str2 = this.f58511name;
        double d11 = this.setupValue;
        int i11 = this.valueType;
        double d12 = this.total;
        Map<String, Object> map = this.tags;
        return "Fee(feeType=" + str + ", name=" + str2 + ", setupValue=" + d11 + ", valueType=" + i11 + ", total=" + d12 + ", tags=" + map + ")";
    }
}
