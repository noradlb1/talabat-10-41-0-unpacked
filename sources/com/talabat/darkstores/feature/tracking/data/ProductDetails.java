package com.talabat.darkstores.feature.tracking.data;

import com.talabat.darkstores.common.SwimlaneTrackingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003J|\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/ProductDetails;", "", "id", "", "name", "description", "price", "", "quantity", "", "photoUrl", "categoryId", "isFavorite", "", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "listPosition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;ZLcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/Integer;)V", "getCategoryId", "()Ljava/lang/String;", "getDescription", "getId", "()Z", "getListPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getPhotoUrl", "getPrice", "()F", "getQuantity", "()I", "getSwimlaneTrackingData", "()Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FILjava/lang/String;Ljava/lang/String;ZLcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/Integer;)Lcom/talabat/darkstores/feature/tracking/data/ProductDetails;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductDetails {
    @Nullable
    private final String categoryId;
    @Nullable
    private final String description;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56627id;
    private final boolean isFavorite;
    @Nullable
    private final Integer listPosition;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56628name;
    @Nullable
    private final String photoUrl;
    private final float price;
    private final int quantity;
    @Nullable
    private final SwimlaneTrackingData swimlaneTrackingData;

    public ProductDetails(@NotNull String str, @NotNull String str2, @Nullable String str3, float f11, int i11, @Nullable String str4, @Nullable String str5, boolean z11, @Nullable SwimlaneTrackingData swimlaneTrackingData2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.f56627id = str;
        this.f56628name = str2;
        this.description = str3;
        this.price = f11;
        this.quantity = i11;
        this.photoUrl = str4;
        this.categoryId = str5;
        this.isFavorite = z11;
        this.swimlaneTrackingData = swimlaneTrackingData2;
        this.listPosition = num;
    }

    public static /* synthetic */ ProductDetails copy$default(ProductDetails productDetails, String str, String str2, String str3, float f11, int i11, String str4, String str5, boolean z11, SwimlaneTrackingData swimlaneTrackingData2, Integer num, int i12, Object obj) {
        ProductDetails productDetails2 = productDetails;
        int i13 = i12;
        return productDetails.copy((i13 & 1) != 0 ? productDetails2.f56627id : str, (i13 & 2) != 0 ? productDetails2.f56628name : str2, (i13 & 4) != 0 ? productDetails2.description : str3, (i13 & 8) != 0 ? productDetails2.price : f11, (i13 & 16) != 0 ? productDetails2.quantity : i11, (i13 & 32) != 0 ? productDetails2.photoUrl : str4, (i13 & 64) != 0 ? productDetails2.categoryId : str5, (i13 & 128) != 0 ? productDetails2.isFavorite : z11, (i13 & 256) != 0 ? productDetails2.swimlaneTrackingData : swimlaneTrackingData2, (i13 & 512) != 0 ? productDetails2.listPosition : num);
    }

    @NotNull
    public final String component1() {
        return this.f56627id;
    }

    @Nullable
    public final Integer component10() {
        return this.listPosition;
    }

    @NotNull
    public final String component2() {
        return this.f56628name;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    public final float component4() {
        return this.price;
    }

    public final int component5() {
        return this.quantity;
    }

    @Nullable
    public final String component6() {
        return this.photoUrl;
    }

    @Nullable
    public final String component7() {
        return this.categoryId;
    }

    public final boolean component8() {
        return this.isFavorite;
    }

    @Nullable
    public final SwimlaneTrackingData component9() {
        return this.swimlaneTrackingData;
    }

    @NotNull
    public final ProductDetails copy(@NotNull String str, @NotNull String str2, @Nullable String str3, float f11, int i11, @Nullable String str4, @Nullable String str5, boolean z11, @Nullable SwimlaneTrackingData swimlaneTrackingData2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        return new ProductDetails(str, str2, str3, f11, i11, str4, str5, z11, swimlaneTrackingData2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetails)) {
            return false;
        }
        ProductDetails productDetails = (ProductDetails) obj;
        return Intrinsics.areEqual((Object) this.f56627id, (Object) productDetails.f56627id) && Intrinsics.areEqual((Object) this.f56628name, (Object) productDetails.f56628name) && Intrinsics.areEqual((Object) this.description, (Object) productDetails.description) && Intrinsics.areEqual((Object) Float.valueOf(this.price), (Object) Float.valueOf(productDetails.price)) && this.quantity == productDetails.quantity && Intrinsics.areEqual((Object) this.photoUrl, (Object) productDetails.photoUrl) && Intrinsics.areEqual((Object) this.categoryId, (Object) productDetails.categoryId) && this.isFavorite == productDetails.isFavorite && Intrinsics.areEqual((Object) this.swimlaneTrackingData, (Object) productDetails.swimlaneTrackingData) && Intrinsics.areEqual((Object) this.listPosition, (Object) productDetails.listPosition);
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.f56627id;
    }

    @Nullable
    public final Integer getListPosition() {
        return this.listPosition;
    }

    @NotNull
    public final String getName() {
        return this.f56628name;
    }

    @Nullable
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final float getPrice() {
        return this.price;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @Nullable
    public final SwimlaneTrackingData getSwimlaneTrackingData() {
        return this.swimlaneTrackingData;
    }

    public int hashCode() {
        int hashCode = ((this.f56627id.hashCode() * 31) + this.f56628name.hashCode()) * 31;
        String str = this.description;
        int i11 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.price)) * 31) + this.quantity) * 31;
        String str2 = this.photoUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.categoryId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z11 = this.isFavorite;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode4 + (z11 ? 1 : 0)) * 31;
        SwimlaneTrackingData swimlaneTrackingData2 = this.swimlaneTrackingData;
        int hashCode5 = (i12 + (swimlaneTrackingData2 == null ? 0 : swimlaneTrackingData2.hashCode())) * 31;
        Integer num = this.listPosition;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode5 + i11;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @NotNull
    public String toString() {
        String str = this.f56627id;
        String str2 = this.f56628name;
        String str3 = this.description;
        float f11 = this.price;
        int i11 = this.quantity;
        String str4 = this.photoUrl;
        String str5 = this.categoryId;
        boolean z11 = this.isFavorite;
        SwimlaneTrackingData swimlaneTrackingData2 = this.swimlaneTrackingData;
        Integer num = this.listPosition;
        return "ProductDetails(id=" + str + ", name=" + str2 + ", description=" + str3 + ", price=" + f11 + ", quantity=" + i11 + ", photoUrl=" + str4 + ", categoryId=" + str5 + ", isFavorite=" + z11 + ", swimlaneTrackingData=" + swimlaneTrackingData2 + ", listPosition=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProductDetails(java.lang.String r15, java.lang.String r16, java.lang.String r17, float r18, int r19, java.lang.String r20, java.lang.String r21, boolean r22, com.talabat.darkstores.common.SwimlaneTrackingData r23, java.lang.Integer r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r10 = r2
            goto L_0x000b
        L_0x0009:
            r10 = r21
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0012
            r1 = 0
            r11 = r1
            goto L_0x0014
        L_0x0012:
            r11 = r22
        L_0x0014:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x001a
            r12 = r2
            goto L_0x001c
        L_0x001a:
            r12 = r23
        L_0x001c:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0022
            r13 = r2
            goto L_0x0024
        L_0x0022:
            r13 = r24
        L_0x0024:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.tracking.data.ProductDetails.<init>(java.lang.String, java.lang.String, java.lang.String, float, int, java.lang.String, java.lang.String, boolean, com.talabat.darkstores.common.SwimlaneTrackingData, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
