package com.talabat.feature.bnplcore.data.remote;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/bnplcore/data/remote/BnplOverduesResponseResult;", "", "count", "", "totalAmount", "", "(ID)V", "getCount", "()I", "getTotalAmount", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_bnpl-core_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BnplOverduesResponseResult {
    private final int count;
    private final double totalAmount;

    public BnplOverduesResponseResult(@Json(name = "count") int i11, @Json(name = "totalAmount") double d11) {
        this.count = i11;
        this.totalAmount = d11;
    }

    public static /* synthetic */ BnplOverduesResponseResult copy$default(BnplOverduesResponseResult bnplOverduesResponseResult, int i11, double d11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = bnplOverduesResponseResult.count;
        }
        if ((i12 & 2) != 0) {
            d11 = bnplOverduesResponseResult.totalAmount;
        }
        return bnplOverduesResponseResult.copy(i11, d11);
    }

    public final int component1() {
        return this.count;
    }

    public final double component2() {
        return this.totalAmount;
    }

    @NotNull
    public final BnplOverduesResponseResult copy(@Json(name = "count") int i11, @Json(name = "totalAmount") double d11) {
        return new BnplOverduesResponseResult(i11, d11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BnplOverduesResponseResult)) {
            return false;
        }
        BnplOverduesResponseResult bnplOverduesResponseResult = (BnplOverduesResponseResult) obj;
        return this.count == bnplOverduesResponseResult.count && Intrinsics.areEqual((Object) Double.valueOf(this.totalAmount), (Object) Double.valueOf(bnplOverduesResponseResult.totalAmount));
    }

    public final int getCount() {
        return this.count;
    }

    public final double getTotalAmount() {
        return this.totalAmount;
    }

    public int hashCode() {
        return (this.count * 31) + Double.doubleToLongBits(this.totalAmount);
    }

    @NotNull
    public String toString() {
        int i11 = this.count;
        double d11 = this.totalAmount;
        return "BnplOverduesResponseResult(count=" + i11 + ", totalAmount=" + d11 + ")";
    }
}
