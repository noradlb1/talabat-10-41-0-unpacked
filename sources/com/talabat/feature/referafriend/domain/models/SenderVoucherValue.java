package com.talabat.feature.referafriend.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/referafriend/domain/models/SenderVoucherValue;", "", "ar", "", "ckb", "en", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAr", "()Ljava/lang/String;", "getCkb", "getEn", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_refer-a-friend_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SenderVoucherValue {
    @Nullable

    /* renamed from: ar  reason: collision with root package name */
    private final String f58726ar;
    @Nullable
    private final String ckb;
    @Nullable

    /* renamed from: en  reason: collision with root package name */
    private final String f58727en;

    public SenderVoucherValue() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public SenderVoucherValue(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f58726ar = str;
        this.ckb = str2;
        this.f58727en = str3;
    }

    public static /* synthetic */ SenderVoucherValue copy$default(SenderVoucherValue senderVoucherValue, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = senderVoucherValue.f58726ar;
        }
        if ((i11 & 2) != 0) {
            str2 = senderVoucherValue.ckb;
        }
        if ((i11 & 4) != 0) {
            str3 = senderVoucherValue.f58727en;
        }
        return senderVoucherValue.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.f58726ar;
    }

    @Nullable
    public final String component2() {
        return this.ckb;
    }

    @Nullable
    public final String component3() {
        return this.f58727en;
    }

    @NotNull
    public final SenderVoucherValue copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new SenderVoucherValue(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SenderVoucherValue)) {
            return false;
        }
        SenderVoucherValue senderVoucherValue = (SenderVoucherValue) obj;
        return Intrinsics.areEqual((Object) this.f58726ar, (Object) senderVoucherValue.f58726ar) && Intrinsics.areEqual((Object) this.ckb, (Object) senderVoucherValue.ckb) && Intrinsics.areEqual((Object) this.f58727en, (Object) senderVoucherValue.f58727en);
    }

    @Nullable
    public final String getAr() {
        return this.f58726ar;
    }

    @Nullable
    public final String getCkb() {
        return this.ckb;
    }

    @Nullable
    public final String getEn() {
        return this.f58727en;
    }

    public int hashCode() {
        String str = this.f58726ar;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ckb;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f58727en;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f58726ar;
        String str2 = this.ckb;
        String str3 = this.f58727en;
        return "SenderVoucherValue(ar=" + str + ", ckb=" + str2 + ", en=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SenderVoucherValue(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
