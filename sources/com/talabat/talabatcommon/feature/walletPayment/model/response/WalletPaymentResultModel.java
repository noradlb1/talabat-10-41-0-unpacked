package com.talabat.talabatcommon.feature.walletPayment.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentResultModel;", "", "redirectUrl", "", "walletTransactionId", "walletTransactionStatus", "", "errorMessage", "errorCategory", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getErrorCategory", "()I", "getErrorMessage", "()Ljava/lang/String;", "getRedirectUrl", "getWalletTransactionId", "getWalletTransactionStatus", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentResultModel {
    @SerializedName("errorCategory")
    private final int errorCategory;
    @SerializedName("errorMessage")
    @Nullable
    private final String errorMessage;
    @SerializedName("redirectUrl")
    @Nullable
    private final String redirectUrl;
    @SerializedName("walletTransactionId")
    @Nullable
    private final String walletTransactionId;
    @SerializedName("walletTransactionStatus")
    private final int walletTransactionStatus;

    public WalletPaymentResultModel() {
        this((String) null, (String) null, 0, (String) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public WalletPaymentResultModel(@Nullable String str, @Nullable String str2, int i11, @Nullable String str3, int i12) {
        this.redirectUrl = str;
        this.walletTransactionId = str2;
        this.walletTransactionStatus = i11;
        this.errorMessage = str3;
        this.errorCategory = i12;
    }

    public static /* synthetic */ WalletPaymentResultModel copy$default(WalletPaymentResultModel walletPaymentResultModel, String str, String str2, int i11, String str3, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = walletPaymentResultModel.redirectUrl;
        }
        if ((i13 & 2) != 0) {
            str2 = walletPaymentResultModel.walletTransactionId;
        }
        String str4 = str2;
        if ((i13 & 4) != 0) {
            i11 = walletPaymentResultModel.walletTransactionStatus;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            str3 = walletPaymentResultModel.errorMessage;
        }
        String str5 = str3;
        if ((i13 & 16) != 0) {
            i12 = walletPaymentResultModel.errorCategory;
        }
        return walletPaymentResultModel.copy(str, str4, i14, str5, i12);
    }

    @Nullable
    public final String component1() {
        return this.redirectUrl;
    }

    @Nullable
    public final String component2() {
        return this.walletTransactionId;
    }

    public final int component3() {
        return this.walletTransactionStatus;
    }

    @Nullable
    public final String component4() {
        return this.errorMessage;
    }

    public final int component5() {
        return this.errorCategory;
    }

    @NotNull
    public final WalletPaymentResultModel copy(@Nullable String str, @Nullable String str2, int i11, @Nullable String str3, int i12) {
        return new WalletPaymentResultModel(str, str2, i11, str3, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPaymentResultModel)) {
            return false;
        }
        WalletPaymentResultModel walletPaymentResultModel = (WalletPaymentResultModel) obj;
        return Intrinsics.areEqual((Object) this.redirectUrl, (Object) walletPaymentResultModel.redirectUrl) && Intrinsics.areEqual((Object) this.walletTransactionId, (Object) walletPaymentResultModel.walletTransactionId) && this.walletTransactionStatus == walletPaymentResultModel.walletTransactionStatus && Intrinsics.areEqual((Object) this.errorMessage, (Object) walletPaymentResultModel.errorMessage) && this.errorCategory == walletPaymentResultModel.errorCategory;
    }

    public final int getErrorCategory() {
        return this.errorCategory;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Nullable
    public final String getWalletTransactionId() {
        return this.walletTransactionId;
    }

    public final int getWalletTransactionStatus() {
        return this.walletTransactionStatus;
    }

    public int hashCode() {
        String str = this.redirectUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.walletTransactionId;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.walletTransactionStatus) * 31;
        String str3 = this.errorMessage;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.errorCategory;
    }

    @NotNull
    public String toString() {
        String str = this.redirectUrl;
        String str2 = this.walletTransactionId;
        int i11 = this.walletTransactionStatus;
        String str3 = this.errorMessage;
        int i12 = this.errorCategory;
        return "WalletPaymentResultModel(redirectUrl=" + str + ", walletTransactionId=" + str2 + ", walletTransactionStatus=" + i11 + ", errorMessage=" + str3 + ", errorCategory=" + i12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletPaymentResultModel(java.lang.String r4, java.lang.String r5, int r6, java.lang.String r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            r5 = -1
            if (r4 == 0) goto L_0x0016
            r2 = r5
            goto L_0x0017
        L_0x0016:
            r2 = r6
        L_0x0017:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r7
        L_0x001d:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r9 = r5
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentResultModel.<init>(java.lang.String, java.lang.String, int, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
