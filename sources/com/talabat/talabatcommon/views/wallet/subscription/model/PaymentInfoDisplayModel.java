package com.talabat.talabatcommon.views.wallet.subscription.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\t\u0010H\u001a\u00020\u0007HÖ\u0001J\u0019\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001a\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010+\"\u0004\b?\u0010-R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR\u001a\u0010\u0018\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001d¨\u0006N"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "Landroid/os/Parcelable;", "planId", "", "planTitle", "freeTrialTitle", "freeTrialDays", "", "freeTrialEligible", "", "subscriptionPaymentDate", "actionText", "planAmount", "", "mode", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;", "threeDSUrl", "transactionId", "feature", "Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;", "description", "shouldIgnoreTopUpVerification", "currency", "mov", "tncPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;FLcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;Ljava/lang/String;ZLjava/lang/String;FLjava/lang/String;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getCurrency", "setCurrency", "getDescription", "setDescription", "getFeature", "()Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;", "setFeature", "(Lcom/talabat/talabatcommon/feature/walletPayment/model/request/WalletPaymentFeature;)V", "getFreeTrialDays", "()I", "setFreeTrialDays", "(I)V", "getFreeTrialEligible", "()Z", "setFreeTrialEligible", "(Z)V", "getFreeTrialTitle", "setFreeTrialTitle", "getMode", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;", "setMode", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletBottomSheetPaymentMode;)V", "getMov", "()F", "setMov", "(F)V", "getPlanAmount", "setPlanAmount", "getPlanId", "setPlanId", "getPlanTitle", "setPlanTitle", "getShouldIgnoreTopUpVerification", "setShouldIgnoreTopUpVerification", "getSubscriptionPaymentDate", "setSubscriptionPaymentDate", "getThreeDSUrl", "setThreeDSUrl", "getTncPath", "setTncPath", "getTransactionId", "setTransactionId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class PaymentInfoDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<PaymentInfoDisplayModel> CREATOR = new Creator();
    @NotNull
    private String actionText;
    @NotNull
    private String currency;
    @NotNull
    private String description;
    @NotNull
    private WalletPaymentFeature feature;
    private int freeTrialDays;
    private boolean freeTrialEligible;
    @Nullable
    private String freeTrialTitle;
    @NotNull
    private WalletBottomSheetPaymentMode mode;
    private float mov;
    private float planAmount;
    @NotNull
    private String planId;
    @NotNull
    private String planTitle;
    private boolean shouldIgnoreTopUpVerification;
    @NotNull
    private String subscriptionPaymentDate;
    @NotNull
    private String threeDSUrl;
    @NotNull
    private String tncPath;
    @NotNull
    private String transactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaymentInfoDisplayModel> {
        @NotNull
        public final PaymentInfoDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentInfoDisplayModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readFloat(), WalletBottomSheetPaymentMode.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), WalletPaymentFeature.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readFloat(), parcel.readString());
        }

        @NotNull
        public final PaymentInfoDisplayModel[] newArray(int i11) {
            return new PaymentInfoDisplayModel[i11];
        }
    }

    public PaymentInfoDisplayModel() {
        this((String) null, (String) null, (String) null, 0, false, (String) null, (String) null, 0.0f, (WalletBottomSheetPaymentMode) null, (String) null, (String) null, (WalletPaymentFeature) null, (String) null, false, (String) null, 0.0f, (String) null, 131071, (DefaultConstructorMarker) null);
    }

    public PaymentInfoDisplayModel(@NotNull String str, @NotNull String str2, @Nullable String str3, int i11, boolean z11, @NotNull String str4, @NotNull String str5, float f11, @NotNull WalletBottomSheetPaymentMode walletBottomSheetPaymentMode, @NotNull String str6, @NotNull String str7, @NotNull WalletPaymentFeature walletPaymentFeature, @NotNull String str8, boolean z12, @NotNull String str9, float f12, @NotNull String str10) {
        String str11 = str4;
        String str12 = str5;
        WalletBottomSheetPaymentMode walletBottomSheetPaymentMode2 = walletBottomSheetPaymentMode;
        String str13 = str6;
        String str14 = str7;
        WalletPaymentFeature walletPaymentFeature2 = walletPaymentFeature;
        String str15 = str8;
        String str16 = str9;
        String str17 = str10;
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "planTitle");
        Intrinsics.checkNotNullParameter(str11, "subscriptionPaymentDate");
        Intrinsics.checkNotNullParameter(str12, "actionText");
        Intrinsics.checkNotNullParameter(walletBottomSheetPaymentMode2, SessionsConfigParameter.SYNC_MODE);
        Intrinsics.checkNotNullParameter(str13, "threeDSUrl");
        Intrinsics.checkNotNullParameter(str14, "transactionId");
        Intrinsics.checkNotNullParameter(walletPaymentFeature2, "feature");
        Intrinsics.checkNotNullParameter(str15, "description");
        Intrinsics.checkNotNullParameter(str16, "currency");
        Intrinsics.checkNotNullParameter(str17, TalabatCommonNavigationActions.EXTRA_TNC_PATH);
        this.planId = str;
        this.planTitle = str2;
        this.freeTrialTitle = str3;
        this.freeTrialDays = i11;
        this.freeTrialEligible = z11;
        this.subscriptionPaymentDate = str11;
        this.actionText = str12;
        this.planAmount = f11;
        this.mode = walletBottomSheetPaymentMode2;
        this.threeDSUrl = str13;
        this.transactionId = str14;
        this.feature = walletPaymentFeature2;
        this.description = str15;
        this.shouldIgnoreTopUpVerification = z12;
        this.currency = str16;
        this.mov = f12;
        this.tncPath = str17;
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final WalletPaymentFeature getFeature() {
        return this.feature;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @Nullable
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final WalletBottomSheetPaymentMode getMode() {
        return this.mode;
    }

    public final float getMov() {
        return this.mov;
    }

    public final float getPlanAmount() {
        return this.planAmount;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    @NotNull
    public final String getPlanTitle() {
        return this.planTitle;
    }

    public final boolean getShouldIgnoreTopUpVerification() {
        return this.shouldIgnoreTopUpVerification;
    }

    @NotNull
    public final String getSubscriptionPaymentDate() {
        return this.subscriptionPaymentDate;
    }

    @NotNull
    public final String getThreeDSUrl() {
        return this.threeDSUrl;
    }

    @NotNull
    public final String getTncPath() {
        return this.tncPath;
    }

    @NotNull
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final void setActionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionText = str;
    }

    public final void setCurrency(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currency = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setFeature(@NotNull WalletPaymentFeature walletPaymentFeature) {
        Intrinsics.checkNotNullParameter(walletPaymentFeature, "<set-?>");
        this.feature = walletPaymentFeature;
    }

    public final void setFreeTrialDays(int i11) {
        this.freeTrialDays = i11;
    }

    public final void setFreeTrialEligible(boolean z11) {
        this.freeTrialEligible = z11;
    }

    public final void setFreeTrialTitle(@Nullable String str) {
        this.freeTrialTitle = str;
    }

    public final void setMode(@NotNull WalletBottomSheetPaymentMode walletBottomSheetPaymentMode) {
        Intrinsics.checkNotNullParameter(walletBottomSheetPaymentMode, "<set-?>");
        this.mode = walletBottomSheetPaymentMode;
    }

    public final void setMov(float f11) {
        this.mov = f11;
    }

    public final void setPlanAmount(float f11) {
        this.planAmount = f11;
    }

    public final void setPlanId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planId = str;
    }

    public final void setPlanTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planTitle = str;
    }

    public final void setShouldIgnoreTopUpVerification(boolean z11) {
        this.shouldIgnoreTopUpVerification = z11;
    }

    public final void setSubscriptionPaymentDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subscriptionPaymentDate = str;
    }

    public final void setThreeDSUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.threeDSUrl = str;
    }

    public final void setTncPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tncPath = str;
    }

    public final void setTransactionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.transactionId = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.planId);
        parcel.writeString(this.planTitle);
        parcel.writeString(this.freeTrialTitle);
        parcel.writeInt(this.freeTrialDays);
        parcel.writeInt(this.freeTrialEligible ? 1 : 0);
        parcel.writeString(this.subscriptionPaymentDate);
        parcel.writeString(this.actionText);
        parcel.writeFloat(this.planAmount);
        parcel.writeString(this.mode.name());
        parcel.writeString(this.threeDSUrl);
        parcel.writeString(this.transactionId);
        parcel.writeString(this.feature.name());
        parcel.writeString(this.description);
        parcel.writeInt(this.shouldIgnoreTopUpVerification ? 1 : 0);
        parcel.writeString(this.currency);
        parcel.writeFloat(this.mov);
        parcel.writeString(this.tncPath);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentInfoDisplayModel(java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, boolean r23, java.lang.String r24, java.lang.String r25, float r26, com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode r27, java.lang.String r28, java.lang.String r29, com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature r30, java.lang.String r31, boolean r32, java.lang.String r33, float r34, java.lang.String r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r1 = com.talabat.talabatcommon.extentions.StringUtils.empty(r1)
            goto L_0x000f
        L_0x000d:
            r1 = r19
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x001c
        L_0x001a:
            r2 = r20
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0029
        L_0x0027:
            r3 = r21
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            kotlin.jvm.internal.IntCompanionObject r4 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r4 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r4)
            goto L_0x0036
        L_0x0034:
            r4 = r22
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003c
            r5 = 0
            goto L_0x003e
        L_0x003c:
            r5 = r23
        L_0x003e:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0049
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x004b
        L_0x0049:
            r7 = r24
        L_0x004b:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0056
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x0058
        L_0x0056:
            r8 = r25
        L_0x0058:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x005e
            r9 = 0
            goto L_0x0060
        L_0x005e:
            r9 = r26
        L_0x0060:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0067
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode r11 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode.NONE
            goto L_0x0069
        L_0x0067:
            r11 = r27
        L_0x0069:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0074
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r12)
            goto L_0x0076
        L_0x0074:
            r12 = r28
        L_0x0076:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0081
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r13 = com.talabat.talabatcommon.extentions.StringUtils.empty(r13)
            goto L_0x0083
        L_0x0081:
            r13 = r29
        L_0x0083:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x008a
            com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature r14 = com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature.NONE
            goto L_0x008c
        L_0x008a:
            r14 = r30
        L_0x008c:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0097
            kotlin.jvm.internal.StringCompanionObject r15 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r15 = com.talabat.talabatcommon.extentions.StringUtils.empty(r15)
            goto L_0x0099
        L_0x0097:
            r15 = r31
        L_0x0099:
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x009f
            r6 = 0
            goto L_0x00a1
        L_0x009f:
            r6 = r32
        L_0x00a1:
            r10 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x00ac
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r10)
            goto L_0x00ae
        L_0x00ac:
            r10 = r33
        L_0x00ae:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00b8
            r16 = 0
            goto L_0x00ba
        L_0x00b8:
            r16 = r34
        L_0x00ba:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00c7
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
            goto L_0x00c9
        L_0x00c7:
            r0 = r35
        L_0x00c9:
            r19 = r18
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r6
            r34 = r10
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, int, boolean, java.lang.String, java.lang.String, float, com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletBottomSheetPaymentMode, java.lang.String, java.lang.String, com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature, java.lang.String, boolean, java.lang.String, float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
