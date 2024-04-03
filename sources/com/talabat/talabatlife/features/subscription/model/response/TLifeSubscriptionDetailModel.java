package com.talabat.talabatlife.features.subscription.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0004\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailModel;", "", "membershipId", "", "isActive", "", "isAutoRenewable", "nextBillingDate", "endDate", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getEndDate", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMembershipId", "getNextBillingDate", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionDetailModel {
    @SerializedName("endDate")
    @Nullable
    private final String endDate;
    @SerializedName("isActive")
    @Nullable
    private final Boolean isActive;
    @SerializedName("isAutorenewable")
    @Nullable
    private final Boolean isAutoRenewable;
    @SerializedName("membershipId")
    @Nullable
    private final String membershipId;
    @SerializedName("nextBillingDate")
    @Nullable
    private final String nextBillingDate;

    public TLifeSubscriptionDetailModel() {
        this((String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public TLifeSubscriptionDetailModel(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3) {
        this.membershipId = str;
        this.isActive = bool;
        this.isAutoRenewable = bool2;
        this.nextBillingDate = str2;
        this.endDate = str3;
    }

    public static /* synthetic */ TLifeSubscriptionDetailModel copy$default(TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel, String str, Boolean bool, Boolean bool2, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tLifeSubscriptionDetailModel.membershipId;
        }
        if ((i11 & 2) != 0) {
            bool = tLifeSubscriptionDetailModel.isActive;
        }
        Boolean bool3 = bool;
        if ((i11 & 4) != 0) {
            bool2 = tLifeSubscriptionDetailModel.isAutoRenewable;
        }
        Boolean bool4 = bool2;
        if ((i11 & 8) != 0) {
            str2 = tLifeSubscriptionDetailModel.nextBillingDate;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            str3 = tLifeSubscriptionDetailModel.endDate;
        }
        return tLifeSubscriptionDetailModel.copy(str, bool3, bool4, str4, str3);
    }

    @Nullable
    public final String component1() {
        return this.membershipId;
    }

    @Nullable
    public final Boolean component2() {
        return this.isActive;
    }

    @Nullable
    public final Boolean component3() {
        return this.isAutoRenewable;
    }

    @Nullable
    public final String component4() {
        return this.nextBillingDate;
    }

    @Nullable
    public final String component5() {
        return this.endDate;
    }

    @NotNull
    public final TLifeSubscriptionDetailModel copy(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3) {
        return new TLifeSubscriptionDetailModel(str, bool, bool2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TLifeSubscriptionDetailModel)) {
            return false;
        }
        TLifeSubscriptionDetailModel tLifeSubscriptionDetailModel = (TLifeSubscriptionDetailModel) obj;
        return Intrinsics.areEqual((Object) this.membershipId, (Object) tLifeSubscriptionDetailModel.membershipId) && Intrinsics.areEqual((Object) this.isActive, (Object) tLifeSubscriptionDetailModel.isActive) && Intrinsics.areEqual((Object) this.isAutoRenewable, (Object) tLifeSubscriptionDetailModel.isAutoRenewable) && Intrinsics.areEqual((Object) this.nextBillingDate, (Object) tLifeSubscriptionDetailModel.nextBillingDate) && Intrinsics.areEqual((Object) this.endDate, (Object) tLifeSubscriptionDetailModel.endDate);
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getMembershipId() {
        return this.membershipId;
    }

    @Nullable
    public final String getNextBillingDate() {
        return this.nextBillingDate;
    }

    public int hashCode() {
        String str = this.membershipId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isActive;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isAutoRenewable;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.nextBillingDate;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endDate;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isActive() {
        return this.isActive;
    }

    @Nullable
    public final Boolean isAutoRenewable() {
        return this.isAutoRenewable;
    }

    @NotNull
    public String toString() {
        String str = this.membershipId;
        Boolean bool = this.isActive;
        Boolean bool2 = this.isAutoRenewable;
        String str2 = this.nextBillingDate;
        String str3 = this.endDate;
        return "TLifeSubscriptionDetailModel(membershipId=" + str + ", isActive=" + bool + ", isAutoRenewable=" + bool2 + ", nextBillingDate=" + str2 + ", endDate=" + str3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TLifeSubscriptionDetailModel(java.lang.String r5, java.lang.Boolean r6, java.lang.Boolean r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailModel.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
