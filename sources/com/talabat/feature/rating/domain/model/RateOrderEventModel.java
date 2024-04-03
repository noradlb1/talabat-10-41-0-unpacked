package com.talabat.feature.rating.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "", "transactionId", "", "vendorId", "vendorName", "branchId", "screenName", "screenType", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/String;", "getEventOrigin", "getScreenName", "getScreenType", "getTransactionId", "getVendorId", "getVendorName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RateOrderEventModel {
    @NotNull
    private final String branchId;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String transactionId;
    @NotNull
    private final String vendorId;
    @NotNull
    private final String vendorName;

    public RateOrderEventModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public RateOrderEventModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "vendorName");
        Intrinsics.checkNotNullParameter(str4, "branchId");
        Intrinsics.checkNotNullParameter(str5, "screenName");
        Intrinsics.checkNotNullParameter(str6, "screenType");
        Intrinsics.checkNotNullParameter(str7, "eventOrigin");
        this.transactionId = str;
        this.vendorId = str2;
        this.vendorName = str3;
        this.branchId = str4;
        this.screenName = str5;
        this.screenType = str6;
        this.eventOrigin = str7;
    }

    public static /* synthetic */ RateOrderEventModel copy$default(RateOrderEventModel rateOrderEventModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = rateOrderEventModel.transactionId;
        }
        if ((i11 & 2) != 0) {
            str2 = rateOrderEventModel.vendorId;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = rateOrderEventModel.vendorName;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = rateOrderEventModel.branchId;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = rateOrderEventModel.screenName;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = rateOrderEventModel.screenType;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = rateOrderEventModel.eventOrigin;
        }
        return rateOrderEventModel.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.transactionId;
    }

    @NotNull
    public final String component2() {
        return this.vendorId;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    @NotNull
    public final String component4() {
        return this.branchId;
    }

    @NotNull
    public final String component5() {
        return this.screenName;
    }

    @NotNull
    public final String component6() {
        return this.screenType;
    }

    @NotNull
    public final String component7() {
        return this.eventOrigin;
    }

    @NotNull
    public final RateOrderEventModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "vendorId");
        Intrinsics.checkNotNullParameter(str3, "vendorName");
        Intrinsics.checkNotNullParameter(str4, "branchId");
        Intrinsics.checkNotNullParameter(str5, "screenName");
        Intrinsics.checkNotNullParameter(str6, "screenType");
        String str8 = str7;
        Intrinsics.checkNotNullParameter(str8, "eventOrigin");
        return new RateOrderEventModel(str, str2, str3, str4, str5, str6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RateOrderEventModel)) {
            return false;
        }
        RateOrderEventModel rateOrderEventModel = (RateOrderEventModel) obj;
        return Intrinsics.areEqual((Object) this.transactionId, (Object) rateOrderEventModel.transactionId) && Intrinsics.areEqual((Object) this.vendorId, (Object) rateOrderEventModel.vendorId) && Intrinsics.areEqual((Object) this.vendorName, (Object) rateOrderEventModel.vendorName) && Intrinsics.areEqual((Object) this.branchId, (Object) rateOrderEventModel.branchId) && Intrinsics.areEqual((Object) this.screenName, (Object) rateOrderEventModel.screenName) && Intrinsics.areEqual((Object) this.screenType, (Object) rateOrderEventModel.screenType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) rateOrderEventModel.eventOrigin);
    }

    @NotNull
    public final String getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getTransactionId() {
        return this.transactionId;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        return (((((((((((this.transactionId.hashCode() * 31) + this.vendorId.hashCode()) * 31) + this.vendorName.hashCode()) * 31) + this.branchId.hashCode()) * 31) + this.screenName.hashCode()) * 31) + this.screenType.hashCode()) * 31) + this.eventOrigin.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.transactionId;
        String str2 = this.vendorId;
        String str3 = this.vendorName;
        String str4 = this.branchId;
        String str5 = this.screenName;
        String str6 = this.screenType;
        String str7 = this.eventOrigin;
        return "RateOrderEventModel(transactionId=" + str + ", vendorId=" + str2 + ", vendorName=" + str3 + ", branchId=" + str4 + ", screenName=" + str5 + ", screenType=" + str6 + ", eventOrigin=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RateOrderEventModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            java.lang.String r0 = ""
            if (r15 == 0) goto L_0x0008
            r15 = r0
            goto L_0x0009
        L_0x0008:
            r15 = r7
        L_0x0009:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r8
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002b
            r5 = r0
            goto L_0x002c
        L_0x002b:
            r5 = r12
        L_0x002c:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0032
            r14 = r0
            goto L_0x0033
        L_0x0032:
            r14 = r13
        L_0x0033:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.domain.model.RateOrderEventModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
