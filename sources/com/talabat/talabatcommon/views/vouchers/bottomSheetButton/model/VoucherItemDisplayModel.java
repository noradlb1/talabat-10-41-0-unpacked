package com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model;

import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003JO\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "", "title", "", "subtitle", "status", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "customerVoucherId", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "voucherDeepLink", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;Ljava/lang/String;Z)V", "getCustomerVoucherId", "()Ljava/lang/String;", "setCustomerVoucherId", "(Ljava/lang/String;)V", "()Z", "setSelected", "(Z)V", "getStatus", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "setStatus", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;)V", "getSubtitle", "setSubtitle", "getTitle", "setTitle", "getVoucherDeepLink", "setVoucherDeepLink", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "setVoucherOptionType", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemDisplayModel {
    @NotNull
    private String customerVoucherId;
    private boolean isSelected;
    @NotNull
    private VouchersStatusFilter status;
    @NotNull
    private String subtitle;
    @NotNull
    private String title;
    @NotNull
    private String voucherDeepLink;
    @NotNull
    private VoucherOptionType voucherOptionType;

    public VoucherItemDisplayModel() {
        this((String) null, (String) null, (VouchersStatusFilter) null, (String) null, (VoucherOptionType) null, (String) null, false, 127, (DefaultConstructorMarker) null);
    }

    public VoucherItemDisplayModel(@NotNull String str, @NotNull String str2, @NotNull VouchersStatusFilter vouchersStatusFilter, @NotNull String str3, @NotNull VoucherOptionType voucherOptionType2, @NotNull String str4, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, "status");
        Intrinsics.checkNotNullParameter(str3, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(voucherOptionType2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        Intrinsics.checkNotNullParameter(str4, "voucherDeepLink");
        this.title = str;
        this.subtitle = str2;
        this.status = vouchersStatusFilter;
        this.customerVoucherId = str3;
        this.voucherOptionType = voucherOptionType2;
        this.voucherDeepLink = str4;
        this.isSelected = z11;
    }

    public static /* synthetic */ VoucherItemDisplayModel copy$default(VoucherItemDisplayModel voucherItemDisplayModel, String str, String str2, VouchersStatusFilter vouchersStatusFilter, String str3, VoucherOptionType voucherOptionType2, String str4, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucherItemDisplayModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = voucherItemDisplayModel.subtitle;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            vouchersStatusFilter = voucherItemDisplayModel.status;
        }
        VouchersStatusFilter vouchersStatusFilter2 = vouchersStatusFilter;
        if ((i11 & 8) != 0) {
            str3 = voucherItemDisplayModel.customerVoucherId;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            voucherOptionType2 = voucherItemDisplayModel.voucherOptionType;
        }
        VoucherOptionType voucherOptionType3 = voucherOptionType2;
        if ((i11 & 32) != 0) {
            str4 = voucherItemDisplayModel.voucherDeepLink;
        }
        String str7 = str4;
        if ((i11 & 64) != 0) {
            z11 = voucherItemDisplayModel.isSelected;
        }
        return voucherItemDisplayModel.copy(str, str5, vouchersStatusFilter2, str6, voucherOptionType3, str7, z11);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final VouchersStatusFilter component3() {
        return this.status;
    }

    @NotNull
    public final String component4() {
        return this.customerVoucherId;
    }

    @NotNull
    public final VoucherOptionType component5() {
        return this.voucherOptionType;
    }

    @NotNull
    public final String component6() {
        return this.voucherDeepLink;
    }

    public final boolean component7() {
        return this.isSelected;
    }

    @NotNull
    public final VoucherItemDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull VouchersStatusFilter vouchersStatusFilter, @NotNull String str3, @NotNull VoucherOptionType voucherOptionType2, @NotNull String str4, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subtitle");
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, "status");
        Intrinsics.checkNotNullParameter(str3, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(voucherOptionType2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        Intrinsics.checkNotNullParameter(str4, "voucherDeepLink");
        return new VoucherItemDisplayModel(str, str2, vouchersStatusFilter, str3, voucherOptionType2, str4, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherItemDisplayModel)) {
            return false;
        }
        VoucherItemDisplayModel voucherItemDisplayModel = (VoucherItemDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) voucherItemDisplayModel.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) voucherItemDisplayModel.subtitle) && this.status == voucherItemDisplayModel.status && Intrinsics.areEqual((Object) this.customerVoucherId, (Object) voucherItemDisplayModel.customerVoucherId) && this.voucherOptionType == voucherItemDisplayModel.voucherOptionType && Intrinsics.areEqual((Object) this.voucherDeepLink, (Object) voucherItemDisplayModel.voucherDeepLink) && this.isSelected == voucherItemDisplayModel.isSelected;
    }

    @NotNull
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    @NotNull
    public final VouchersStatusFilter getStatus() {
        return this.status;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getVoucherDeepLink() {
        return this.voucherDeepLink;
    }

    @NotNull
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.title.hashCode() * 31) + this.subtitle.hashCode()) * 31) + this.status.hashCode()) * 31) + this.customerVoucherId.hashCode()) * 31) + this.voucherOptionType.hashCode()) * 31) + this.voucherDeepLink.hashCode()) * 31;
        boolean z11 = this.isSelected;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setCustomerVoucherId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customerVoucherId = str;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public final void setStatus(@NotNull VouchersStatusFilter vouchersStatusFilter) {
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, "<set-?>");
        this.status = vouchersStatusFilter;
    }

    public final void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setVoucherDeepLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.voucherDeepLink = str;
    }

    public final void setVoucherOptionType(@NotNull VoucherOptionType voucherOptionType2) {
        Intrinsics.checkNotNullParameter(voucherOptionType2, "<set-?>");
        this.voucherOptionType = voucherOptionType2;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        VouchersStatusFilter vouchersStatusFilter = this.status;
        String str3 = this.customerVoucherId;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        String str4 = this.voucherDeepLink;
        boolean z11 = this.isSelected;
        return "VoucherItemDisplayModel(title=" + str + ", subtitle=" + str2 + ", status=" + vouchersStatusFilter + ", customerVoucherId=" + str3 + ", voucherOptionType=" + voucherOptionType2 + ", voucherDeepLink=" + str4 + ", isSelected=" + z11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherItemDisplayModel(java.lang.String r6, java.lang.String r7, com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter r8, java.lang.String r9, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r10, java.lang.String r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x000a:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0014
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0014:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x001b
            com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter r8 = com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter.ALL
        L_0x001b:
            r0 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0026
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0026:
            r1 = r9
            r7 = r13 & 16
            if (r7 == 0) goto L_0x002d
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r10 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType.NONE
        L_0x002d:
            r2 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0038
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r11 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0038:
            r3 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0043
            kotlin.jvm.internal.BooleanCompanionObject r7 = kotlin.jvm.internal.BooleanCompanionObject.INSTANCE
            boolean r12 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((kotlin.jvm.internal.BooleanCompanionObject) r7)
        L_0x0043:
            r4 = r12
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel.<init>(java.lang.String, java.lang.String, com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter, java.lang.String, com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
