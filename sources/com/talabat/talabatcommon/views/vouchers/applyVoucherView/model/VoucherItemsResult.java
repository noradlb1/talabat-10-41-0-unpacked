package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;", "", "id", "", "name", "", "image", "price", "", "description", "(ILjava/lang/String;Ljava/lang/String;FLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getImage", "setImage", "getName", "setName", "getPrice", "()F", "setPrice", "(F)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsResult {
    @NotNull
    private String description;

    /* renamed from: id  reason: collision with root package name */
    private int f11770id;
    @NotNull
    private String image;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f11771name;
    private float price;

    public VoucherItemsResult() {
        this(0, (String) null, (String) null, 0.0f, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public VoucherItemsResult(int i11, @NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "image");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.f11770id = i11;
        this.f11771name = str;
        this.image = str2;
        this.price = f11;
        this.description = str3;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.f11770id;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.f11771name;
    }

    public final float getPrice() {
        return this.price;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setId(int i11) {
        this.f11770id = i11;
    }

    public final void setImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11771name = str;
    }

    public final void setPrice(float f11) {
        this.price = f11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherItemsResult(int r4, java.lang.String r5, java.lang.String r6, float r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 0
        L_0x0005:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x000d
            r10 = r0
            goto L_0x000e
        L_0x000d:
            r10 = r5
        L_0x000e:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r6
        L_0x0015:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            r7 = 0
        L_0x001a:
            r2 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r0 = r8
        L_0x0021:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsResult.<init>(int, java.lang.String, java.lang.String, float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
