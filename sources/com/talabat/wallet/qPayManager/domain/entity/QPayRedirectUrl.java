package com.talabat.wallet.qPayManager.domain.entity;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrl;", "", "displayMessage", "", "isValid", "", "redirectUrl", "responseCode", "", "verificationCode", "(Ljava/lang/String;ZLjava/lang/String;II)V", "getDisplayMessage", "()Ljava/lang/String;", "()Z", "setValid", "(Z)V", "getRedirectUrl", "getResponseCode", "()I", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayRedirectUrl {
    @NotNull
    @ModelMapping({"DisplayMessage"})
    private final String displayMessage;
    @ModelMapping({"IsValid"})
    private boolean isValid;
    @NotNull
    @ModelMapping({"RedirectUrl"})
    private final String redirectUrl;
    @ModelMapping({"ResponseCode"})
    private final int responseCode;
    @ModelMapping({"verificationCode"})
    private final int verificationCode;

    public QPayRedirectUrl() {
        this((String) null, false, (String) null, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    public QPayRedirectUrl(@NotNull String str, boolean z11, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "displayMessage");
        Intrinsics.checkNotNullParameter(str2, "redirectUrl");
        this.displayMessage = str;
        this.isValid = z11;
        this.redirectUrl = str2;
        this.responseCode = i11;
        this.verificationCode = i12;
    }

    public static /* synthetic */ QPayRedirectUrl copy$default(QPayRedirectUrl qPayRedirectUrl, String str, boolean z11, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = qPayRedirectUrl.displayMessage;
        }
        if ((i13 & 2) != 0) {
            z11 = qPayRedirectUrl.isValid;
        }
        boolean z12 = z11;
        if ((i13 & 4) != 0) {
            str2 = qPayRedirectUrl.redirectUrl;
        }
        String str3 = str2;
        if ((i13 & 8) != 0) {
            i11 = qPayRedirectUrl.responseCode;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = qPayRedirectUrl.verificationCode;
        }
        return qPayRedirectUrl.copy(str, z12, str3, i14, i12);
    }

    @NotNull
    public final String component1() {
        return this.displayMessage;
    }

    public final boolean component2() {
        return this.isValid;
    }

    @NotNull
    public final String component3() {
        return this.redirectUrl;
    }

    public final int component4() {
        return this.responseCode;
    }

    public final int component5() {
        return this.verificationCode;
    }

    @NotNull
    public final QPayRedirectUrl copy(@NotNull String str, boolean z11, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "displayMessage");
        Intrinsics.checkNotNullParameter(str2, "redirectUrl");
        return new QPayRedirectUrl(str, z11, str2, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QPayRedirectUrl)) {
            return false;
        }
        QPayRedirectUrl qPayRedirectUrl = (QPayRedirectUrl) obj;
        return Intrinsics.areEqual((Object) this.displayMessage, (Object) qPayRedirectUrl.displayMessage) && this.isValid == qPayRedirectUrl.isValid && Intrinsics.areEqual((Object) this.redirectUrl, (Object) qPayRedirectUrl.redirectUrl) && this.responseCode == qPayRedirectUrl.responseCode && this.verificationCode == qPayRedirectUrl.verificationCode;
    }

    @NotNull
    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    @NotNull
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final int getVerificationCode() {
        return this.verificationCode;
    }

    public int hashCode() {
        int hashCode = this.displayMessage.hashCode() * 31;
        boolean z11 = this.isValid;
        if (z11) {
            z11 = true;
        }
        return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.redirectUrl.hashCode()) * 31) + this.responseCode) * 31) + this.verificationCode;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final void setValid(boolean z11) {
        this.isValid = z11;
    }

    @NotNull
    public String toString() {
        String str = this.displayMessage;
        boolean z11 = this.isValid;
        String str2 = this.redirectUrl;
        int i11 = this.responseCode;
        int i12 = this.verificationCode;
        return "QPayRedirectUrl(displayMessage=" + str + ", isValid=" + z11 + ", redirectUrl=" + str2 + ", responseCode=" + i11 + ", verificationCode=" + i12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QPayRedirectUrl(java.lang.String r4, boolean r5, java.lang.String r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000f
            r5 = 0
        L_0x000f:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x001a:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0025
            kotlin.jvm.internal.IntCompanionObject r5 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r7 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r5)
        L_0x0025:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0030
            kotlin.jvm.internal.IntCompanionObject r5 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r8 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r5)
        L_0x0030:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrl.<init>(java.lang.String, boolean, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
