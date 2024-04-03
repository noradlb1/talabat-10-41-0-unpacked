package com.talabat.core.flutter.channels.impl.data.tpro.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/tpro/dto/TproArguments;", "", "branchId", "", "isProVendor", "", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getBranchId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/talabat/core/flutter/channels/impl/data/tpro/dto/TproArguments;", "equals", "other", "hashCode", "toString", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproArguments {
    @Nullable
    private final Integer branchId;
    @Nullable
    private final Boolean isProVendor;

    public TproArguments() {
        this((Integer) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public TproArguments(@Nullable Integer num, @Nullable Boolean bool) {
        this.branchId = num;
        this.isProVendor = bool;
    }

    public static /* synthetic */ TproArguments copy$default(TproArguments tproArguments, Integer num, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = tproArguments.branchId;
        }
        if ((i11 & 2) != 0) {
            bool = tproArguments.isProVendor;
        }
        return tproArguments.copy(num, bool);
    }

    @Nullable
    public final Integer component1() {
        return this.branchId;
    }

    @Nullable
    public final Boolean component2() {
        return this.isProVendor;
    }

    @NotNull
    public final TproArguments copy(@Nullable Integer num, @Nullable Boolean bool) {
        return new TproArguments(num, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TproArguments)) {
            return false;
        }
        TproArguments tproArguments = (TproArguments) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) tproArguments.branchId) && Intrinsics.areEqual((Object) this.isProVendor, (Object) tproArguments.isProVendor);
    }

    @Nullable
    public final Integer getBranchId() {
        return this.branchId;
    }

    public int hashCode() {
        Integer num = this.branchId;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.isProVendor;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode + i11;
    }

    @Nullable
    public final Boolean isProVendor() {
        return this.isProVendor;
    }

    @NotNull
    public String toString() {
        Integer num = this.branchId;
        Boolean bool = this.isProVendor;
        return "TproArguments(branchId=" + num + ", isProVendor=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TproArguments(Integer num, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : bool);
    }
}
