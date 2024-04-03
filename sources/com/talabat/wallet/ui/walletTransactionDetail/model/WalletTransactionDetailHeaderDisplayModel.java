package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001e¨\u0006>"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "", "id", "", "orderId", "", "name", "date", "imageUrl", "amount", "", "expiryDays", "creditSource", "transactionType", "refund", "transactionTypeId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAmount", "()F", "setAmount", "(F)V", "getCreditSource", "()Ljava/lang/String;", "setCreditSource", "(Ljava/lang/String;)V", "getDate", "setDate", "getExpiryDays", "()I", "setExpiryDays", "(I)V", "getId", "setId", "getImageUrl", "setImageUrl", "getName", "setName", "getOrderId", "setOrderId", "getRefund", "setRefund", "getTransactionType", "setTransactionType", "getTransactionTypeId", "setTransactionTypeId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailHeaderDisplayModel {
    private float amount;
    @NotNull
    private String creditSource;
    @NotNull
    private String date;
    private int expiryDays;

    /* renamed from: id  reason: collision with root package name */
    private int f12825id;
    @NotNull
    private String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f12826name;
    @NotNull
    private String orderId;
    @NotNull
    private String refund;
    @NotNull
    private String transactionType;
    private int transactionTypeId;

    public WalletTransactionDetailHeaderDisplayModel() {
        this(0, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, 0, 2047, (DefaultConstructorMarker) null);
    }

    public WalletTransactionDetailHeaderDisplayModel(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, float f11, int i12, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i13) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "date");
        Intrinsics.checkNotNullParameter(str4, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str5, "creditSource");
        Intrinsics.checkNotNullParameter(str6, "transactionType");
        Intrinsics.checkNotNullParameter(str7, "refund");
        this.f12825id = i11;
        this.orderId = str;
        this.f12826name = str2;
        this.date = str3;
        this.imageUrl = str4;
        this.amount = f11;
        this.expiryDays = i12;
        this.creditSource = str5;
        this.transactionType = str6;
        this.refund = str7;
        this.transactionTypeId = i13;
    }

    public static /* synthetic */ WalletTransactionDetailHeaderDisplayModel copy$default(WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel, int i11, String str, String str2, String str3, String str4, float f11, int i12, String str5, String str6, String str7, int i13, int i14, Object obj) {
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel2 = walletTransactionDetailHeaderDisplayModel;
        int i15 = i14;
        return walletTransactionDetailHeaderDisplayModel.copy((i15 & 1) != 0 ? walletTransactionDetailHeaderDisplayModel2.f12825id : i11, (i15 & 2) != 0 ? walletTransactionDetailHeaderDisplayModel2.orderId : str, (i15 & 4) != 0 ? walletTransactionDetailHeaderDisplayModel2.f12826name : str2, (i15 & 8) != 0 ? walletTransactionDetailHeaderDisplayModel2.date : str3, (i15 & 16) != 0 ? walletTransactionDetailHeaderDisplayModel2.imageUrl : str4, (i15 & 32) != 0 ? walletTransactionDetailHeaderDisplayModel2.amount : f11, (i15 & 64) != 0 ? walletTransactionDetailHeaderDisplayModel2.expiryDays : i12, (i15 & 128) != 0 ? walletTransactionDetailHeaderDisplayModel2.creditSource : str5, (i15 & 256) != 0 ? walletTransactionDetailHeaderDisplayModel2.transactionType : str6, (i15 & 512) != 0 ? walletTransactionDetailHeaderDisplayModel2.refund : str7, (i15 & 1024) != 0 ? walletTransactionDetailHeaderDisplayModel2.transactionTypeId : i13);
    }

    public final int component1() {
        return this.f12825id;
    }

    @NotNull
    public final String component10() {
        return this.refund;
    }

    public final int component11() {
        return this.transactionTypeId;
    }

    @NotNull
    public final String component2() {
        return this.orderId;
    }

    @NotNull
    public final String component3() {
        return this.f12826name;
    }

    @NotNull
    public final String component4() {
        return this.date;
    }

    @NotNull
    public final String component5() {
        return this.imageUrl;
    }

    public final float component6() {
        return this.amount;
    }

    public final int component7() {
        return this.expiryDays;
    }

    @NotNull
    public final String component8() {
        return this.creditSource;
    }

    @NotNull
    public final String component9() {
        return this.transactionType;
    }

    @NotNull
    public final WalletTransactionDetailHeaderDisplayModel copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, float f11, int i12, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i13) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, "name");
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "date");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, ObservableAttributesNames.IMAGE_URL_V2);
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "creditSource");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "transactionType");
        String str13 = str7;
        Intrinsics.checkNotNullParameter(str13, "refund");
        return new WalletTransactionDetailHeaderDisplayModel(i11, str, str8, str9, str10, f11, i12, str11, str12, str13, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailHeaderDisplayModel)) {
            return false;
        }
        WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel = (WalletTransactionDetailHeaderDisplayModel) obj;
        return this.f12825id == walletTransactionDetailHeaderDisplayModel.f12825id && Intrinsics.areEqual((Object) this.orderId, (Object) walletTransactionDetailHeaderDisplayModel.orderId) && Intrinsics.areEqual((Object) this.f12826name, (Object) walletTransactionDetailHeaderDisplayModel.f12826name) && Intrinsics.areEqual((Object) this.date, (Object) walletTransactionDetailHeaderDisplayModel.date) && Intrinsics.areEqual((Object) this.imageUrl, (Object) walletTransactionDetailHeaderDisplayModel.imageUrl) && Intrinsics.areEqual((Object) Float.valueOf(this.amount), (Object) Float.valueOf(walletTransactionDetailHeaderDisplayModel.amount)) && this.expiryDays == walletTransactionDetailHeaderDisplayModel.expiryDays && Intrinsics.areEqual((Object) this.creditSource, (Object) walletTransactionDetailHeaderDisplayModel.creditSource) && Intrinsics.areEqual((Object) this.transactionType, (Object) walletTransactionDetailHeaderDisplayModel.transactionType) && Intrinsics.areEqual((Object) this.refund, (Object) walletTransactionDetailHeaderDisplayModel.refund) && this.transactionTypeId == walletTransactionDetailHeaderDisplayModel.transactionTypeId;
    }

    public final float getAmount() {
        return this.amount;
    }

    @NotNull
    public final String getCreditSource() {
        return this.creditSource;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    public final int getExpiryDays() {
        return this.expiryDays;
    }

    public final int getId() {
        return this.f12825id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f12826name;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final String getRefund() {
        return this.refund;
    }

    @NotNull
    public final String getTransactionType() {
        return this.transactionType;
    }

    public final int getTransactionTypeId() {
        return this.transactionTypeId;
    }

    public int hashCode() {
        return (((((((((((((((((((this.f12825id * 31) + this.orderId.hashCode()) * 31) + this.f12826name.hashCode()) * 31) + this.date.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + Float.floatToIntBits(this.amount)) * 31) + this.expiryDays) * 31) + this.creditSource.hashCode()) * 31) + this.transactionType.hashCode()) * 31) + this.refund.hashCode()) * 31) + this.transactionTypeId;
    }

    public final void setAmount(float f11) {
        this.amount = f11;
    }

    public final void setCreditSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.creditSource = str;
    }

    public final void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setExpiryDays(int i11) {
        this.expiryDays = i11;
    }

    public final void setId(int i11) {
        this.f12825id = i11;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f12826name = str;
    }

    public final void setOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderId = str;
    }

    public final void setRefund(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refund = str;
    }

    public final void setTransactionType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.transactionType = str;
    }

    public final void setTransactionTypeId(int i11) {
        this.transactionTypeId = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f12825id;
        String str = this.orderId;
        String str2 = this.f12826name;
        String str3 = this.date;
        String str4 = this.imageUrl;
        float f11 = this.amount;
        int i12 = this.expiryDays;
        String str5 = this.creditSource;
        String str6 = this.transactionType;
        String str7 = this.refund;
        int i13 = this.transactionTypeId;
        return "WalletTransactionDetailHeaderDisplayModel(id=" + i11 + ", orderId=" + str + ", name=" + str2 + ", date=" + str3 + ", imageUrl=" + str4 + ", amount=" + f11 + ", expiryDays=" + i12 + ", creditSource=" + str5 + ", transactionType=" + str6 + ", refund=" + str7 + ", transactionTypeId=" + i13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletTransactionDetailHeaderDisplayModel(int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, float r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0016
        L_0x0015:
            r3 = r13
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0021
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0022
        L_0x0021:
            r4 = r14
        L_0x0022:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002d
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
            goto L_0x002e
        L_0x002d:
            r5 = r15
        L_0x002e:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0039
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
            goto L_0x003b
        L_0x0039:
            r6 = r16
        L_0x003b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0041
            r7 = 0
            goto L_0x0043
        L_0x0041:
            r7 = r17
        L_0x0043:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r2 = r18
        L_0x004a:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0055
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x0057
        L_0x0055:
            r8 = r19
        L_0x0057:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0062
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x0064
        L_0x0062:
            r9 = r20
        L_0x0064:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x006f
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r10)
            goto L_0x0071
        L_0x006f:
            r10 = r21
        L_0x0071:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0077
            r0 = -1
            goto L_0x0079
        L_0x0077:
            r0 = r22
        L_0x0079:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r2
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, float, int, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
