package com.talabat.talabatcommon.feature.walletCardManagement.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "", "displayMessage", "", "isValid", "", "redirectUrl", "responseCode", "", "verificationCode", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDisplayMessage", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "setValid", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRedirectUrl", "getResponseCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVerificationCode", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardResponse {
    @SerializedName("DisplayMessage")
    @Nullable
    private final String displayMessage;
    @SerializedName("IsValid")
    @Nullable
    private Boolean isValid;
    @SerializedName("RedirectUrl")
    @Nullable
    private final String redirectUrl;
    @SerializedName("ResponseCode")
    @Nullable
    private final Integer responseCode;
    @SerializedName("verificationCode")
    @Nullable
    private final Integer verificationCode;

    public WalletAddCardResponse() {
        this((String) null, (Boolean) null, (String) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public WalletAddCardResponse(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        this.displayMessage = str;
        this.isValid = bool;
        this.redirectUrl = str2;
        this.responseCode = num;
        this.verificationCode = num2;
    }

    public static /* synthetic */ WalletAddCardResponse copy$default(WalletAddCardResponse walletAddCardResponse, String str, Boolean bool, String str2, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletAddCardResponse.displayMessage;
        }
        if ((i11 & 2) != 0) {
            bool = walletAddCardResponse.isValid;
        }
        Boolean bool2 = bool;
        if ((i11 & 4) != 0) {
            str2 = walletAddCardResponse.redirectUrl;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            num = walletAddCardResponse.responseCode;
        }
        Integer num3 = num;
        if ((i11 & 16) != 0) {
            num2 = walletAddCardResponse.verificationCode;
        }
        return walletAddCardResponse.copy(str, bool2, str3, num3, num2);
    }

    @Nullable
    public final String component1() {
        return this.displayMessage;
    }

    @Nullable
    public final Boolean component2() {
        return this.isValid;
    }

    @Nullable
    public final String component3() {
        return this.redirectUrl;
    }

    @Nullable
    public final Integer component4() {
        return this.responseCode;
    }

    @Nullable
    public final Integer component5() {
        return this.verificationCode;
    }

    @NotNull
    public final WalletAddCardResponse copy(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2) {
        return new WalletAddCardResponse(str, bool, str2, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletAddCardResponse)) {
            return false;
        }
        WalletAddCardResponse walletAddCardResponse = (WalletAddCardResponse) obj;
        return Intrinsics.areEqual((Object) this.displayMessage, (Object) walletAddCardResponse.displayMessage) && Intrinsics.areEqual((Object) this.isValid, (Object) walletAddCardResponse.isValid) && Intrinsics.areEqual((Object) this.redirectUrl, (Object) walletAddCardResponse.redirectUrl) && Intrinsics.areEqual((Object) this.responseCode, (Object) walletAddCardResponse.responseCode) && Intrinsics.areEqual((Object) this.verificationCode, (Object) walletAddCardResponse.verificationCode);
    }

    @Nullable
    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Nullable
    public final Integer getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public final Integer getVerificationCode() {
        return this.verificationCode;
    }

    public int hashCode() {
        String str = this.displayMessage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isValid;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.redirectUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.responseCode;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.verificationCode;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isValid() {
        return this.isValid;
    }

    public final void setValid(@Nullable Boolean bool) {
        this.isValid = bool;
    }

    @NotNull
    public String toString() {
        String str = this.displayMessage;
        Boolean bool = this.isValid;
        String str2 = this.redirectUrl;
        Integer num = this.responseCode;
        Integer num2 = this.verificationCode;
        return "WalletAddCardResponse(displayMessage=" + str + ", isValid=" + bool + ", redirectUrl=" + str2 + ", responseCode=" + num + ", verificationCode=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletAddCardResponse(java.lang.String r5, java.lang.Boolean r6, java.lang.String r7, java.lang.Integer r8, java.lang.Integer r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse.<init>(java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
