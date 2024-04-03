package com.talabat.talabatcommon.views.darkstores.lookingGlass.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010<J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\nHÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010+\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006B"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "", "id", "", "name", "description", "imageUrl", "price", "", "discount", "", "originalPrice", "discountText", "tags", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/Integer;", "setDiscount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDiscountText", "setDiscountText", "getId", "setId", "getImageUrl", "setImageUrl", "getName", "setName", "getOriginalPrice", "()Ljava/lang/Double;", "setOriginalPrice", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "originalPriceDisplayText", "getOriginalPriceDisplayText", "setOriginalPriceDisplayText", "getPrice", "setPrice", "priceDisplayText", "getPriceDisplayText", "setPriceDisplayText", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;)Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GDisplayItem {
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("discount")
    @Nullable
    private Integer discount;
    @SerializedName("discount_text")
    @Nullable
    private String discountText;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f11725id;
    @SerializedName("image_url")
    @Nullable
    private String imageUrl;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f11726name;
    @SerializedName("original_price")
    @Nullable
    private Double originalPrice;
    @NotNull
    private String originalPriceDisplayText;
    @SerializedName("price")
    @Nullable
    private Double price;
    @NotNull
    private String priceDisplayText;
    @SerializedName("tags")
    @Nullable
    private List<String> tags;

    public GDisplayItem() {
        this((String) null, (String) null, (String) null, (String) null, (Double) null, (Integer) null, (Double) null, (String) null, (List) null, 511, (DefaultConstructorMarker) null);
    }

    public GDisplayItem(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable Integer num, @Nullable Double d12, @Nullable String str5, @Nullable List<String> list) {
        this.f11725id = str;
        this.f11726name = str2;
        this.description = str3;
        this.imageUrl = str4;
        this.price = d11;
        this.discount = num;
        this.originalPrice = d12;
        this.discountText = str5;
        this.tags = list;
        this.priceDisplayText = "";
        this.originalPriceDisplayText = "";
    }

    public static /* synthetic */ GDisplayItem copy$default(GDisplayItem gDisplayItem, String str, String str2, String str3, String str4, Double d11, Integer num, Double d12, String str5, List list, int i11, Object obj) {
        GDisplayItem gDisplayItem2 = gDisplayItem;
        int i12 = i11;
        return gDisplayItem.copy((i12 & 1) != 0 ? gDisplayItem2.f11725id : str, (i12 & 2) != 0 ? gDisplayItem2.f11726name : str2, (i12 & 4) != 0 ? gDisplayItem2.description : str3, (i12 & 8) != 0 ? gDisplayItem2.imageUrl : str4, (i12 & 16) != 0 ? gDisplayItem2.price : d11, (i12 & 32) != 0 ? gDisplayItem2.discount : num, (i12 & 64) != 0 ? gDisplayItem2.originalPrice : d12, (i12 & 128) != 0 ? gDisplayItem2.discountText : str5, (i12 & 256) != 0 ? gDisplayItem2.tags : list);
    }

    @Nullable
    public final String component1() {
        return this.f11725id;
    }

    @Nullable
    public final String component2() {
        return this.f11726name;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.imageUrl;
    }

    @Nullable
    public final Double component5() {
        return this.price;
    }

    @Nullable
    public final Integer component6() {
        return this.discount;
    }

    @Nullable
    public final Double component7() {
        return this.originalPrice;
    }

    @Nullable
    public final String component8() {
        return this.discountText;
    }

    @Nullable
    public final List<String> component9() {
        return this.tags;
    }

    @NotNull
    public final GDisplayItem copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d11, @Nullable Integer num, @Nullable Double d12, @Nullable String str5, @Nullable List<String> list) {
        return new GDisplayItem(str, str2, str3, str4, d11, num, d12, str5, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GDisplayItem)) {
            return false;
        }
        GDisplayItem gDisplayItem = (GDisplayItem) obj;
        return Intrinsics.areEqual((Object) this.f11725id, (Object) gDisplayItem.f11725id) && Intrinsics.areEqual((Object) this.f11726name, (Object) gDisplayItem.f11726name) && Intrinsics.areEqual((Object) this.description, (Object) gDisplayItem.description) && Intrinsics.areEqual((Object) this.imageUrl, (Object) gDisplayItem.imageUrl) && Intrinsics.areEqual((Object) this.price, (Object) gDisplayItem.price) && Intrinsics.areEqual((Object) this.discount, (Object) gDisplayItem.discount) && Intrinsics.areEqual((Object) this.originalPrice, (Object) gDisplayItem.originalPrice) && Intrinsics.areEqual((Object) this.discountText, (Object) gDisplayItem.discountText) && Intrinsics.areEqual((Object) this.tags, (Object) gDisplayItem.tags);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getDiscount() {
        return this.discount;
    }

    @Nullable
    public final String getDiscountText() {
        return this.discountText;
    }

    @Nullable
    public final String getId() {
        return this.f11725id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f11726name;
    }

    @Nullable
    public final Double getOriginalPrice() {
        return this.originalPrice;
    }

    @NotNull
    public final String getOriginalPriceDisplayText() {
        return this.originalPriceDisplayText;
    }

    @Nullable
    public final Double getPrice() {
        return this.price;
    }

    @NotNull
    public final String getPriceDisplayText() {
        return this.priceDisplayText;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        String str = this.f11725id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11726name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d11 = this.price;
        int hashCode5 = (hashCode4 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num = this.discount;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Double d12 = this.originalPrice;
        int hashCode7 = (hashCode6 + (d12 == null ? 0 : d12.hashCode())) * 31;
        String str5 = this.discountText;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<String> list = this.tags;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode8 + i11;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setDiscount(@Nullable Integer num) {
        this.discount = num;
    }

    public final void setDiscountText(@Nullable String str) {
        this.discountText = str;
    }

    public final void setId(@Nullable String str) {
        this.f11725id = str;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setName(@Nullable String str) {
        this.f11726name = str;
    }

    public final void setOriginalPrice(@Nullable Double d11) {
        this.originalPrice = d11;
    }

    public final void setOriginalPriceDisplayText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originalPriceDisplayText = str;
    }

    public final void setPrice(@Nullable Double d11) {
        this.price = d11;
    }

    public final void setPriceDisplayText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.priceDisplayText = str;
    }

    public final void setTags(@Nullable List<String> list) {
        this.tags = list;
    }

    @NotNull
    public String toString() {
        String str = this.f11725id;
        String str2 = this.f11726name;
        String str3 = this.description;
        String str4 = this.imageUrl;
        Double d11 = this.price;
        Integer num = this.discount;
        Double d12 = this.originalPrice;
        String str5 = this.discountText;
        List<String> list = this.tags;
        return "GDisplayItem(id=" + str + ", name=" + str2 + ", description=" + str3 + ", imageUrl=" + str4 + ", price=" + d11 + ", discount=" + num + ", originalPrice=" + d12 + ", discountText=" + str5 + ", tags=" + list + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GDisplayItem(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Double r15, java.lang.Integer r16, java.lang.Double r17, java.lang.String r18, java.util.List r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0032
        L_0x0030:
            r7 = r16
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r17
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            java.lang.String r9 = ""
            goto L_0x0043
        L_0x0041:
            r9 = r18
        L_0x0043:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r2 = r19
        L_0x004a:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Integer, java.lang.Double, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
