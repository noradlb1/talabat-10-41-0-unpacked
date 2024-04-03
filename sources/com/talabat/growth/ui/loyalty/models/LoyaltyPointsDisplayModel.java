package com.talabat.growth.ui.loyalty.models;

import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006,"}, d2 = {"Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "", "totalPoints", "", "expirationText", "", "pointsType", "points", "unSignedPoints", "pointsTransactionString", "date", "subTitle", "title", "icon", "isCancellation", "", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getExpirationText", "setExpirationText", "getIcon", "()I", "setIcon", "(I)V", "()Z", "setCancellation", "(Z)V", "getPoints", "setPoints", "getPointsTransactionString", "setPointsTransactionString", "getPointsType", "setPointsType", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "getTotalPoints", "setTotalPoints", "getUnSignedPoints", "setUnSignedPoints", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsDisplayModel {
    @NotNull
    private String date;
    @NotNull
    private String expirationText;
    private int icon;
    private boolean isCancellation;
    @NotNull
    private String points;
    private int pointsTransactionString;
    private int pointsType;
    @NotNull
    private String subTitle;
    @NotNull
    private String title;
    private int totalPoints;
    @NotNull
    private String unSignedPoints;

    public LoyaltyPointsDisplayModel() {
        this(0, (String) null, 0, (String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, false, 2047, (DefaultConstructorMarker) null);
    }

    public LoyaltyPointsDisplayModel(int i11, @NotNull String str, int i12, @NotNull String str2, @NotNull String str3, int i13, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i14, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "expirationText");
        Intrinsics.checkNotNullParameter(str2, Param.POINTS);
        Intrinsics.checkNotNullParameter(str3, "unSignedPoints");
        Intrinsics.checkNotNullParameter(str4, "date");
        Intrinsics.checkNotNullParameter(str5, "subTitle");
        Intrinsics.checkNotNullParameter(str6, "title");
        this.totalPoints = i11;
        this.expirationText = str;
        this.pointsType = i12;
        this.points = str2;
        this.unSignedPoints = str3;
        this.pointsTransactionString = i13;
        this.date = str4;
        this.subTitle = str5;
        this.title = str6;
        this.icon = i14;
        this.isCancellation = z11;
    }

    @NotNull
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final String getExpirationText() {
        return this.expirationText;
    }

    public final int getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getPoints() {
        return this.points;
    }

    public final int getPointsTransactionString() {
        return this.pointsTransactionString;
    }

    public final int getPointsType() {
        return this.pointsType;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getTotalPoints() {
        return this.totalPoints;
    }

    @NotNull
    public final String getUnSignedPoints() {
        return this.unSignedPoints;
    }

    public final boolean isCancellation() {
        return this.isCancellation;
    }

    public final void setCancellation(boolean z11) {
        this.isCancellation = z11;
    }

    public final void setDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.date = str;
    }

    public final void setExpirationText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expirationText = str;
    }

    public final void setIcon(int i11) {
        this.icon = i11;
    }

    public final void setPoints(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.points = str;
    }

    public final void setPointsTransactionString(int i11) {
        this.pointsTransactionString = i11;
    }

    public final void setPointsType(int i11) {
        this.pointsType = i11;
    }

    public final void setSubTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setTotalPoints(int i11) {
        this.totalPoints = i11;
    }

    public final void setUnSignedPoints(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.unSignedPoints = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyPointsDisplayModel(int r14, java.lang.String r15, int r16, java.lang.String r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r13 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r3 = com.talabat.talabatcommon.extentions.StringUtils.empty(r3)
            goto L_0x0016
        L_0x0015:
            r3 = r15
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            r4 = r2
            goto L_0x001e
        L_0x001c:
            r4 = r16
        L_0x001e:
            r5 = r0 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0026
            r5 = r6
            goto L_0x0028
        L_0x0026:
            r5 = r17
        L_0x0028:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002e
            r7 = r6
            goto L_0x0030
        L_0x002e:
            r7 = r18
        L_0x0030:
            r8 = r0 & 32
            r9 = -1
            if (r8 == 0) goto L_0x0037
            r8 = r9
            goto L_0x0039
        L_0x0037:
            r8 = r19
        L_0x0039:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003f
            r10 = r6
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0047
            r11 = r6
            goto L_0x0049
        L_0x0047:
            r11 = r21
        L_0x0049:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r6 = r22
        L_0x0050:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r9 = r23
        L_0x0057:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r2 = r24
        L_0x005e:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r7
            r20 = r8
            r21 = r10
            r22 = r11
            r23 = r6
            r24 = r9
            r25 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel.<init>(int, java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
