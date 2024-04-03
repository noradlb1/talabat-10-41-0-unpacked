package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003Jc\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020=HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006?"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "", "id", "", "title", "subTitle", "isApplied", "", "type", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "disabledReason", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DisabledReason;", "subscriptionRestriction", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;", "restrictionDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DisabledReason;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;Ljava/lang/String;)V", "getDisabledReason", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DisabledReason;", "setDisabledReason", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DisabledReason;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setApplied", "(Z)V", "isDisabled", "getRestrictionDescription", "setRestrictionDescription", "getSubTitle", "setSubTitle", "getSubscriptionRestriction", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;", "setSubscriptionRestriction", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/SubscriptionRestriction;)V", "getTitle", "setTitle", "getType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;", "setType", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;)V", "getVoucherData", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "setVoucherData", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDisplayModel {
    @NotNull
    private DisabledReason disabledReason;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f11769id;
    private boolean isApplied;
    @NotNull
    private String restrictionDescription;
    @NotNull
    private String subTitle;
    @NotNull
    private SubscriptionRestriction subscriptionRestriction;
    @NotNull
    private String title;
    @NotNull
    private VoucherType type;
    @NotNull
    private VoucherData voucherData;

    public VoucherDisplayModel() {
        this((String) null, (String) null, (String) null, false, (VoucherType) null, (VoucherData) null, (DisabledReason) null, (SubscriptionRestriction) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public VoucherDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull VoucherType voucherType, @NotNull VoucherData voucherData2, @NotNull DisabledReason disabledReason2, @NotNull SubscriptionRestriction subscriptionRestriction2, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "subTitle");
        Intrinsics.checkNotNullParameter(voucherType, "type");
        Intrinsics.checkNotNullParameter(voucherData2, "voucherData");
        Intrinsics.checkNotNullParameter(disabledReason2, "disabledReason");
        Intrinsics.checkNotNullParameter(subscriptionRestriction2, "subscriptionRestriction");
        Intrinsics.checkNotNullParameter(str4, "restrictionDescription");
        this.f11769id = str;
        this.title = str2;
        this.subTitle = str3;
        this.isApplied = z11;
        this.type = voucherType;
        this.voucherData = voucherData2;
        this.disabledReason = disabledReason2;
        this.subscriptionRestriction = subscriptionRestriction2;
        this.restrictionDescription = str4;
    }

    public static /* synthetic */ VoucherDisplayModel copy$default(VoucherDisplayModel voucherDisplayModel, String str, String str2, String str3, boolean z11, VoucherType voucherType, VoucherData voucherData2, DisabledReason disabledReason2, SubscriptionRestriction subscriptionRestriction2, String str4, int i11, Object obj) {
        VoucherDisplayModel voucherDisplayModel2 = voucherDisplayModel;
        int i12 = i11;
        return voucherDisplayModel.copy((i12 & 1) != 0 ? voucherDisplayModel2.f11769id : str, (i12 & 2) != 0 ? voucherDisplayModel2.title : str2, (i12 & 4) != 0 ? voucherDisplayModel2.subTitle : str3, (i12 & 8) != 0 ? voucherDisplayModel2.isApplied : z11, (i12 & 16) != 0 ? voucherDisplayModel2.type : voucherType, (i12 & 32) != 0 ? voucherDisplayModel2.voucherData : voucherData2, (i12 & 64) != 0 ? voucherDisplayModel2.disabledReason : disabledReason2, (i12 & 128) != 0 ? voucherDisplayModel2.subscriptionRestriction : subscriptionRestriction2, (i12 & 256) != 0 ? voucherDisplayModel2.restrictionDescription : str4);
    }

    @NotNull
    public final String component1() {
        return this.f11769id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.subTitle;
    }

    public final boolean component4() {
        return this.isApplied;
    }

    @NotNull
    public final VoucherType component5() {
        return this.type;
    }

    @NotNull
    public final VoucherData component6() {
        return this.voucherData;
    }

    @NotNull
    public final DisabledReason component7() {
        return this.disabledReason;
    }

    @NotNull
    public final SubscriptionRestriction component8() {
        return this.subscriptionRestriction;
    }

    @NotNull
    public final String component9() {
        return this.restrictionDescription;
    }

    @NotNull
    public final VoucherDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull VoucherType voucherType, @NotNull VoucherData voucherData2, @NotNull DisabledReason disabledReason2, @NotNull SubscriptionRestriction subscriptionRestriction2, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "subTitle");
        VoucherType voucherType2 = voucherType;
        Intrinsics.checkNotNullParameter(voucherType2, "type");
        VoucherData voucherData3 = voucherData2;
        Intrinsics.checkNotNullParameter(voucherData3, "voucherData");
        DisabledReason disabledReason3 = disabledReason2;
        Intrinsics.checkNotNullParameter(disabledReason3, "disabledReason");
        SubscriptionRestriction subscriptionRestriction3 = subscriptionRestriction2;
        Intrinsics.checkNotNullParameter(subscriptionRestriction3, "subscriptionRestriction");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "restrictionDescription");
        return new VoucherDisplayModel(str, str2, str3, z11, voucherType2, voucherData3, disabledReason3, subscriptionRestriction3, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherDisplayModel)) {
            return false;
        }
        VoucherDisplayModel voucherDisplayModel = (VoucherDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.f11769id, (Object) voucherDisplayModel.f11769id) && Intrinsics.areEqual((Object) this.title, (Object) voucherDisplayModel.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) voucherDisplayModel.subTitle) && this.isApplied == voucherDisplayModel.isApplied && this.type == voucherDisplayModel.type && Intrinsics.areEqual((Object) this.voucherData, (Object) voucherDisplayModel.voucherData) && this.disabledReason == voucherDisplayModel.disabledReason && this.subscriptionRestriction == voucherDisplayModel.subscriptionRestriction && Intrinsics.areEqual((Object) this.restrictionDescription, (Object) voucherDisplayModel.restrictionDescription);
    }

    @NotNull
    public final DisabledReason getDisabledReason() {
        return this.disabledReason;
    }

    @NotNull
    public final String getId() {
        return this.f11769id;
    }

    @NotNull
    public final String getRestrictionDescription() {
        return this.restrictionDescription;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final SubscriptionRestriction getSubscriptionRestriction() {
        return this.subscriptionRestriction;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final VoucherType getType() {
        return this.type;
    }

    @NotNull
    public final VoucherData getVoucherData() {
        return this.voucherData;
    }

    public int hashCode() {
        int hashCode = ((((this.f11769id.hashCode() * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31;
        boolean z11 = this.isApplied;
        if (z11) {
            z11 = true;
        }
        return ((((((((((hashCode + (z11 ? 1 : 0)) * 31) + this.type.hashCode()) * 31) + this.voucherData.hashCode()) * 31) + this.disabledReason.hashCode()) * 31) + this.subscriptionRestriction.hashCode()) * 31) + this.restrictionDescription.hashCode();
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final boolean isDisabled() {
        return this.disabledReason != DisabledReason.NONE;
    }

    public final void setApplied(boolean z11) {
        this.isApplied = z11;
    }

    public final void setDisabledReason(@NotNull DisabledReason disabledReason2) {
        Intrinsics.checkNotNullParameter(disabledReason2, "<set-?>");
        this.disabledReason = disabledReason2;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11769id = str;
    }

    public final void setRestrictionDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restrictionDescription = str;
    }

    public final void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void setSubscriptionRestriction(@NotNull SubscriptionRestriction subscriptionRestriction2) {
        Intrinsics.checkNotNullParameter(subscriptionRestriction2, "<set-?>");
        this.subscriptionRestriction = subscriptionRestriction2;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setType(@NotNull VoucherType voucherType) {
        Intrinsics.checkNotNullParameter(voucherType, "<set-?>");
        this.type = voucherType;
    }

    public final void setVoucherData(@NotNull VoucherData voucherData2) {
        Intrinsics.checkNotNullParameter(voucherData2, "<set-?>");
        this.voucherData = voucherData2;
    }

    @NotNull
    public String toString() {
        String str = this.f11769id;
        String str2 = this.title;
        String str3 = this.subTitle;
        boolean z11 = this.isApplied;
        VoucherType voucherType = this.type;
        VoucherData voucherData2 = this.voucherData;
        DisabledReason disabledReason2 = this.disabledReason;
        SubscriptionRestriction subscriptionRestriction2 = this.subscriptionRestriction;
        String str4 = this.restrictionDescription;
        return "VoucherDisplayModel(id=" + str + ", title=" + str2 + ", subTitle=" + str3 + ", isApplied=" + z11 + ", type=" + voucherType + ", voucherData=" + voucherData2 + ", disabledReason=" + disabledReason2 + ", subscriptionRestriction=" + subscriptionRestriction2 + ", restrictionDescription=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherDisplayModel(java.lang.String r28, java.lang.String r29, java.lang.String r30, boolean r31, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType r32, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r33, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason r34, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction r35, java.lang.String r36, int r37, kotlin.jvm.internal.DefaultConstructorMarker r38) {
        /*
            r27 = this;
            r0 = r37
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000f
        L_0x000d:
            r1 = r28
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001c
        L_0x001a:
            r2 = r29
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0029
        L_0x0027:
            r3 = r30
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x002f
            r4 = 0
            goto L_0x0031
        L_0x002f:
            r4 = r31
        L_0x0031:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0038
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType r5 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType.NONE
            goto L_0x003a
        L_0x0038:
            r5 = r32
        L_0x003a:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0064
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData r6 = new com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData
            r7 = r6
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 131071(0x1ffff, float:1.8367E-40)
            r26 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0066
        L_0x0064:
            r6 = r33
        L_0x0066:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x006d
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason r7 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason.NONE
            goto L_0x006f
        L_0x006d:
            r7 = r34
        L_0x006f:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0076
            com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction r8 = com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction.UNRESTRICTED
            goto L_0x0078
        L_0x0076:
            r8 = r35
        L_0x0078:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0083
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
            goto L_0x0085
        L_0x0083:
            r0 = r36
        L_0x0085:
            r28 = r27
            r29 = r1
            r30 = r2
            r31 = r3
            r32 = r4
            r33 = r5
            r34 = r6
            r35 = r7
            r36 = r8
            r37 = r0
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherType, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.DisabledReason, com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
