package com.talabat.talabatlife.ui.onBoarding.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\nHÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\nHÖ\u0001R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017¨\u0006<"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "Landroid/os/Parcelable;", "freeTrialEligible", "", "planId", "", "planTitle", "planAmount", "", "freeTrialDays", "", "freeTrialTitle", "subscriptionPaymentDate", "actionText", "onBoardingTitle", "onBoardingSubTitle", "descriptionText", "nextBillingText", "nextBillingSubText", "(ZLjava/lang/String;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getDescriptionText", "setDescriptionText", "getFreeTrialDays", "()I", "setFreeTrialDays", "(I)V", "getFreeTrialEligible", "()Z", "setFreeTrialEligible", "(Z)V", "getFreeTrialTitle", "setFreeTrialTitle", "getNextBillingSubText", "setNextBillingSubText", "getNextBillingText", "setNextBillingText", "getOnBoardingSubTitle", "setOnBoardingSubTitle", "getOnBoardingTitle", "setOnBoardingTitle", "getPlanAmount", "()F", "setPlanAmount", "(F)V", "getPlanId", "setPlanId", "getPlanTitle", "setPlanTitle", "getSubscriptionPaymentDate", "setSubscriptionPaymentDate", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class TLifeOnBoardingPlanDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TLifeOnBoardingPlanDisplayModel> CREATOR = new Creator();
    @NotNull
    private String actionText;
    @NotNull
    private String descriptionText;
    private int freeTrialDays;
    private boolean freeTrialEligible;
    @NotNull
    private String freeTrialTitle;
    @NotNull
    private String nextBillingSubText;
    @NotNull
    private String nextBillingText;
    @NotNull
    private String onBoardingSubTitle;
    @NotNull
    private String onBoardingTitle;
    private float planAmount;
    @NotNull
    private String planId;
    @NotNull
    private String planTitle;
    @NotNull
    private String subscriptionPaymentDate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TLifeOnBoardingPlanDisplayModel> {
        @NotNull
        public final TLifeOnBoardingPlanDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TLifeOnBoardingPlanDisplayModel(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final TLifeOnBoardingPlanDisplayModel[] newArray(int i11) {
            return new TLifeOnBoardingPlanDisplayModel[i11];
        }
    }

    public TLifeOnBoardingPlanDisplayModel() {
        this(false, (String) null, (String) null, 0.0f, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 8191, (DefaultConstructorMarker) null);
    }

    public TLifeOnBoardingPlanDisplayModel(boolean z11, @NotNull String str, @NotNull String str2, float f11, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10) {
        Intrinsics.checkNotNullParameter(str, BNPLCheckoutFlutterFragment.PLAN_ID_EXTRA);
        Intrinsics.checkNotNullParameter(str2, "planTitle");
        Intrinsics.checkNotNullParameter(str3, "freeTrialTitle");
        Intrinsics.checkNotNullParameter(str4, "subscriptionPaymentDate");
        Intrinsics.checkNotNullParameter(str5, "actionText");
        Intrinsics.checkNotNullParameter(str6, "onBoardingTitle");
        Intrinsics.checkNotNullParameter(str7, "onBoardingSubTitle");
        Intrinsics.checkNotNullParameter(str8, "descriptionText");
        Intrinsics.checkNotNullParameter(str9, "nextBillingText");
        Intrinsics.checkNotNullParameter(str10, "nextBillingSubText");
        this.freeTrialEligible = z11;
        this.planId = str;
        this.planTitle = str2;
        this.planAmount = f11;
        this.freeTrialDays = i11;
        this.freeTrialTitle = str3;
        this.subscriptionPaymentDate = str4;
        this.actionText = str5;
        this.onBoardingTitle = str6;
        this.onBoardingSubTitle = str7;
        this.descriptionText = str8;
        this.nextBillingText = str9;
        this.nextBillingSubText = str10;
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final String getDescriptionText() {
        return this.descriptionText;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    @NotNull
    public final String getNextBillingSubText() {
        return this.nextBillingSubText;
    }

    @NotNull
    public final String getNextBillingText() {
        return this.nextBillingText;
    }

    @NotNull
    public final String getOnBoardingSubTitle() {
        return this.onBoardingSubTitle;
    }

    @NotNull
    public final String getOnBoardingTitle() {
        return this.onBoardingTitle;
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

    @NotNull
    public final String getSubscriptionPaymentDate() {
        return this.subscriptionPaymentDate;
    }

    public final void setActionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionText = str;
    }

    public final void setDescriptionText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descriptionText = str;
    }

    public final void setFreeTrialDays(int i11) {
        this.freeTrialDays = i11;
    }

    public final void setFreeTrialEligible(boolean z11) {
        this.freeTrialEligible = z11;
    }

    public final void setFreeTrialTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.freeTrialTitle = str;
    }

    public final void setNextBillingSubText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nextBillingSubText = str;
    }

    public final void setNextBillingText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nextBillingText = str;
    }

    public final void setOnBoardingSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onBoardingSubTitle = str;
    }

    public final void setOnBoardingTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onBoardingTitle = str;
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

    public final void setSubscriptionPaymentDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subscriptionPaymentDate = str;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.freeTrialEligible ? 1 : 0);
        parcel.writeString(this.planId);
        parcel.writeString(this.planTitle);
        parcel.writeFloat(this.planAmount);
        parcel.writeInt(this.freeTrialDays);
        parcel.writeString(this.freeTrialTitle);
        parcel.writeString(this.subscriptionPaymentDate);
        parcel.writeString(this.actionText);
        parcel.writeString(this.onBoardingTitle);
        parcel.writeString(this.onBoardingSubTitle);
        parcel.writeString(this.descriptionText);
        parcel.writeString(this.nextBillingText);
        parcel.writeString(this.nextBillingSubText);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TLifeOnBoardingPlanDisplayModel(boolean r14, java.lang.String r15, java.lang.String r16, float r17, int r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r14
        L_0x0009:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0014
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r2 = com.talabat.talabatcommon.extentions.StringUtils.empty(r2)
            goto L_0x0015
        L_0x0014:
            r2 = r15
        L_0x0015:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0020
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0022
        L_0x0020:
            r3 = r16
        L_0x0022:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0028
            r4 = 0
            goto L_0x002a
        L_0x0028:
            r4 = r17
        L_0x002a:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0035
            kotlin.jvm.internal.IntCompanionObject r5 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r5 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r5)
            goto L_0x0037
        L_0x0035:
            r5 = r18
        L_0x0037:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0042
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
            goto L_0x0044
        L_0x0042:
            r6 = r19
        L_0x0044:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004f
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
            goto L_0x0051
        L_0x004f:
            r7 = r20
        L_0x0051:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x005c
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r8)
            goto L_0x005e
        L_0x005c:
            r8 = r21
        L_0x005e:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0069
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r9)
            goto L_0x006b
        L_0x0069:
            r9 = r22
        L_0x006b:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0076
            kotlin.jvm.internal.StringCompanionObject r10 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r10)
            goto L_0x0078
        L_0x0076:
            r10 = r23
        L_0x0078:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0083
            kotlin.jvm.internal.StringCompanionObject r11 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r11 = com.talabat.talabatcommon.extentions.StringUtils.empty(r11)
            goto L_0x0085
        L_0x0083:
            r11 = r24
        L_0x0085:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0090
            kotlin.jvm.internal.StringCompanionObject r12 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r12 = com.talabat.talabatcommon.extentions.StringUtils.empty(r12)
            goto L_0x0092
        L_0x0090:
            r12 = r25
        L_0x0092:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x009d
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r0 = com.talabat.talabatcommon.extentions.StringUtils.empty(r0)
            goto L_0x009f
        L_0x009d:
            r0 = r26
        L_0x009f:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel.<init>(boolean, java.lang.String, java.lang.String, float, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
