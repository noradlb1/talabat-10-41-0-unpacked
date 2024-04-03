package com.talabat.talabatcommon.feature.vouchers.monolith.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsResultResponse;", "", "id", "", "name", "", "image", "price", "", "description", "(ILjava/lang/String;Ljava/lang/String;FLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getId", "()I", "getImage", "getName", "getPrice", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsResultResponse {
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private final int f61689id;
    @SerializedName("image")
    @NotNull
    private final String image;
    @SerializedName("name")
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f61690name;
    @SerializedName("price")
    private final float price;

    public VoucherItemsResultResponse() {
        this(0, (String) null, (String) null, 0.0f, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public VoucherItemsResultResponse(int i11, @NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "image");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.f61689id = i11;
        this.f61690name = str;
        this.image = str2;
        this.price = f11;
        this.description = str3;
    }

    public static /* synthetic */ VoucherItemsResultResponse copy$default(VoucherItemsResultResponse voucherItemsResultResponse, int i11, String str, String str2, float f11, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = voucherItemsResultResponse.f61689id;
        }
        if ((i12 & 2) != 0) {
            str = voucherItemsResultResponse.f61690name;
        }
        String str4 = str;
        if ((i12 & 4) != 0) {
            str2 = voucherItemsResultResponse.image;
        }
        String str5 = str2;
        if ((i12 & 8) != 0) {
            f11 = voucherItemsResultResponse.price;
        }
        float f12 = f11;
        if ((i12 & 16) != 0) {
            str3 = voucherItemsResultResponse.description;
        }
        return voucherItemsResultResponse.copy(i11, str4, str5, f12, str3);
    }

    public final int component1() {
        return this.f61689id;
    }

    @NotNull
    public final String component2() {
        return this.f61690name;
    }

    @NotNull
    public final String component3() {
        return this.image;
    }

    public final float component4() {
        return this.price;
    }

    @NotNull
    public final String component5() {
        return this.description;
    }

    @NotNull
    public final VoucherItemsResultResponse copy(int i11, @NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "image");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new VoucherItemsResultResponse(i11, str, str2, f11, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoucherItemsResultResponse)) {
            return false;
        }
        VoucherItemsResultResponse voucherItemsResultResponse = (VoucherItemsResultResponse) obj;
        return this.f61689id == voucherItemsResultResponse.f61689id && Intrinsics.areEqual((Object) this.f61690name, (Object) voucherItemsResultResponse.f61690name) && Intrinsics.areEqual((Object) this.image, (Object) voucherItemsResultResponse.image) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(voucherItemsResultResponse.price)) && Intrinsics.areEqual((Object) this.description, (Object) voucherItemsResultResponse.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.f61689id;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.f61690name;
    }

    public final float getPrice() {
        return this.price;
    }

    public int hashCode() {
        return (((((((this.f61689id * 31) + this.f61690name.hashCode()) * 31) + this.image.hashCode()) * 31) + Float.floatToIntBits(this.price)) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.f61689id;
        String str = this.f61690name;
        String str2 = this.image;
        float f11 = this.price;
        String str3 = this.description;
        return "VoucherItemsResultResponse(id=" + i11 + ", name=" + str + ", image=" + str2 + ", price=" + f11 + ", description=" + str3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VoucherItemsResultResponse(int r4, java.lang.String r5, java.lang.String r6, float r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsResultResponse.<init>(int, java.lang.String, java.lang.String, float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
