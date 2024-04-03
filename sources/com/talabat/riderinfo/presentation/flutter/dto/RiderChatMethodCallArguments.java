package com.talabat.riderinfo.presentation.flutter.dto;

import com.talabat.riderinfo.domain.entity.RiderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/talabat/riderinfo/presentation/flutter/dto/RiderChatMethodCallArguments;", "", "orderId", "", "vendorName", "riderInfo", "Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "screenName", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/riderinfo/domain/entity/RiderInfo;Ljava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getRiderInfo", "()Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "getScreenName", "getVendorName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderChatMethodCallArguments {
    @Nullable
    private final String orderId;
    @Nullable
    private final RiderInfo riderInfo;
    @Nullable
    private final String screenName;
    @Nullable
    private final String vendorName;

    public RiderChatMethodCallArguments() {
        this((String) null, (String) null, (RiderInfo) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public RiderChatMethodCallArguments(@Nullable String str, @Nullable String str2, @Nullable RiderInfo riderInfo2, @Nullable String str3) {
        this.orderId = str;
        this.vendorName = str2;
        this.riderInfo = riderInfo2;
        this.screenName = str3;
    }

    public static /* synthetic */ RiderChatMethodCallArguments copy$default(RiderChatMethodCallArguments riderChatMethodCallArguments, String str, String str2, RiderInfo riderInfo2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = riderChatMethodCallArguments.orderId;
        }
        if ((i11 & 2) != 0) {
            str2 = riderChatMethodCallArguments.vendorName;
        }
        if ((i11 & 4) != 0) {
            riderInfo2 = riderChatMethodCallArguments.riderInfo;
        }
        if ((i11 & 8) != 0) {
            str3 = riderChatMethodCallArguments.screenName;
        }
        return riderChatMethodCallArguments.copy(str, str2, riderInfo2, str3);
    }

    @Nullable
    public final String component1() {
        return this.orderId;
    }

    @Nullable
    public final String component2() {
        return this.vendorName;
    }

    @Nullable
    public final RiderInfo component3() {
        return this.riderInfo;
    }

    @Nullable
    public final String component4() {
        return this.screenName;
    }

    @NotNull
    public final RiderChatMethodCallArguments copy(@Nullable String str, @Nullable String str2, @Nullable RiderInfo riderInfo2, @Nullable String str3) {
        return new RiderChatMethodCallArguments(str, str2, riderInfo2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderChatMethodCallArguments)) {
            return false;
        }
        RiderChatMethodCallArguments riderChatMethodCallArguments = (RiderChatMethodCallArguments) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) riderChatMethodCallArguments.orderId) && Intrinsics.areEqual((Object) this.vendorName, (Object) riderChatMethodCallArguments.vendorName) && Intrinsics.areEqual((Object) this.riderInfo, (Object) riderChatMethodCallArguments.riderInfo) && Intrinsics.areEqual((Object) this.screenName, (Object) riderChatMethodCallArguments.screenName);
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final RiderInfo getRiderInfo() {
        return this.riderInfo;
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @Nullable
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        String str = this.orderId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.vendorName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        RiderInfo riderInfo2 = this.riderInfo;
        int hashCode3 = (hashCode2 + (riderInfo2 == null ? 0 : riderInfo2.hashCode())) * 31;
        String str3 = this.screenName;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.orderId;
        String str2 = this.vendorName;
        RiderInfo riderInfo2 = this.riderInfo;
        String str3 = this.screenName;
        return "RiderChatMethodCallArguments(orderId=" + str + ", vendorName=" + str2 + ", riderInfo=" + riderInfo2 + ", screenName=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RiderChatMethodCallArguments(String str, String str2, RiderInfo riderInfo2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : riderInfo2, (i11 & 8) != 0 ? null : str3);
    }
}
