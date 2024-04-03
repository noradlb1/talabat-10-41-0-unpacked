package com.talabat.talabatlife.ui.onBoarding.model;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "", "title", "", "description", "action", "isUserInWaitList", "", "onBoardingTitle", "onBoardingSubTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getDescription", "setDescription", "()Z", "setUserInWaitList", "(Z)V", "getOnBoardingSubTitle", "setOnBoardingSubTitle", "getOnBoardingTitle", "setOnBoardingTitle", "getTitle", "setTitle", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingWaitListDisplayModel {
    @NotNull
    private String action;
    @NotNull
    private String description;
    private boolean isUserInWaitList;
    @NotNull
    private String onBoardingSubTitle;
    @NotNull
    private String onBoardingTitle;
    @NotNull
    private String title;

    public TLifeOnBoardingWaitListDisplayModel() {
        this((String) null, (String) null, (String) null, false, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public TLifeOnBoardingWaitListDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(str4, "onBoardingTitle");
        Intrinsics.checkNotNullParameter(str5, "onBoardingSubTitle");
        this.title = str;
        this.description = str2;
        this.action = str3;
        this.isUserInWaitList = z11;
        this.onBoardingTitle = str4;
        this.onBoardingSubTitle = str5;
    }

    @NotNull
    public final String getAction() {
        return this.action;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getOnBoardingSubTitle() {
        return this.onBoardingSubTitle;
    }

    @NotNull
    public final String getOnBoardingTitle() {
        return this.onBoardingTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isUserInWaitList() {
        return this.isUserInWaitList;
    }

    public final void setAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.action = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setOnBoardingSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onBoardingSubTitle = str;
    }

    public final void setOnBoardingTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.onBoardingTitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setUserInWaitList(boolean z11) {
        this.isUserInWaitList = z11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TLifeOnBoardingWaitListDisplayModel(java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, java.lang.String r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r5 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r5 = com.talabat.talabatcommon.extentions.StringUtils.empty(r5)
        L_0x000a:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0014
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x0014:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x001f
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x001f:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0025
            r8 = 0
        L_0x0025:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0030
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x0030:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x003b
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r10 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x003b:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
