package JsonModels.Response.LoyaltyVoucherResponse;

import com.google.gson.annotations.SerializedName;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u0000 32\u00020\u0001:\u00013Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003Js\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u00020\u001c2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010\u001dR\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018¨\u00064"}, d2 = {"LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult;", "", "id", "", "customerId", "", "title", "brandId", "discountValue", "", "discountType", "maxDiscountCap", "minOrderValue", "loyaltyVoucherBounds", "LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherBounds;", "voucherOptionType", "(Ljava/lang/String;ILjava/lang/String;IFLjava/lang/String;FFLJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherBounds;Ljava/lang/String;)V", "getBrandId", "()I", "setBrandId", "(I)V", "getCustomerId", "setCustomerId", "getDiscountType", "()Ljava/lang/String;", "setDiscountType", "(Ljava/lang/String;)V", "isDeliveryDiscountType", "", "()Z", "isDeliveryPercentage", "isDiscountAvailable", "isPercentage", "getTitle", "setTitle", "getVoucherOptionType", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyVoucherResult {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DELIVERY_PERCENTAGE_DISCOUNT = "DELIVERY_PERCENTAGE";
    @NotNull
    public static final String FLAT_DELIVERY_DISCOUNT = "FLAT_DELIVERY";
    @NotNull
    public static final String FLAT_DISCOUNT = "FLAT";
    @NotNull
    public static final String PERCENTAGE_DISCOUNT = "PERCENTAGE";
    @NotNull
    public static final String VOUCHER_CODE_VOUCHER_OPTION_TYPE = "MARKETING";
    @SerializedName("brandId")
    private int brandId;
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("discountType")
    @Nullable
    private String discountType;
    @SerializedName("discountValue")
    @JvmField
    public float discountValue;
    @SerializedName("id")
    @Nullable
    @JvmField

    /* renamed from: id  reason: collision with root package name */
    public String f476id;
    @SerializedName("bounds")
    @NotNull
    @JvmField
    public LoyaltyVoucherBounds loyaltyVoucherBounds;
    @SerializedName("maxDiscountCap")
    @JvmField
    public float maxDiscountCap;
    @SerializedName("minOrderValue")
    @JvmField
    public float minOrderValue;
    @SerializedName("title")
    @Nullable
    private String title;
    @NotNull
    private final String voucherOptionType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult$Companion;", "", "()V", "DELIVERY_PERCENTAGE_DISCOUNT", "", "FLAT_DELIVERY_DISCOUNT", "FLAT_DISCOUNT", "PERCENTAGE_DISCOUNT", "VOUCHER_CODE_VOUCHER_OPTION_TYPE", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LoyaltyVoucherResult() {
        this((String) null, 0, (String) null, 0, 0.0f, (String) null, 0.0f, 0.0f, (LoyaltyVoucherBounds) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    public LoyaltyVoucherResult(@Nullable String str, int i11, @Nullable String str2, int i12, float f11, @Nullable String str3, float f12, float f13, @NotNull LoyaltyVoucherBounds loyaltyVoucherBounds2, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(loyaltyVoucherBounds2, "loyaltyVoucherBounds");
        Intrinsics.checkNotNullParameter(str4, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        this.f476id = str;
        this.customerId = i11;
        this.title = str2;
        this.brandId = i12;
        this.discountValue = f11;
        this.discountType = str3;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.loyaltyVoucherBounds = loyaltyVoucherBounds2;
        this.voucherOptionType = str4;
    }

    public static /* synthetic */ LoyaltyVoucherResult copy$default(LoyaltyVoucherResult loyaltyVoucherResult, String str, int i11, String str2, int i12, float f11, String str3, float f12, float f13, LoyaltyVoucherBounds loyaltyVoucherBounds2, String str4, int i13, Object obj) {
        LoyaltyVoucherResult loyaltyVoucherResult2 = loyaltyVoucherResult;
        int i14 = i13;
        return loyaltyVoucherResult.copy((i14 & 1) != 0 ? loyaltyVoucherResult2.f476id : str, (i14 & 2) != 0 ? loyaltyVoucherResult2.customerId : i11, (i14 & 4) != 0 ? loyaltyVoucherResult2.title : str2, (i14 & 8) != 0 ? loyaltyVoucherResult2.brandId : i12, (i14 & 16) != 0 ? loyaltyVoucherResult2.discountValue : f11, (i14 & 32) != 0 ? loyaltyVoucherResult2.discountType : str3, (i14 & 64) != 0 ? loyaltyVoucherResult2.maxDiscountCap : f12, (i14 & 128) != 0 ? loyaltyVoucherResult2.minOrderValue : f13, (i14 & 256) != 0 ? loyaltyVoucherResult2.loyaltyVoucherBounds : loyaltyVoucherBounds2, (i14 & 512) != 0 ? loyaltyVoucherResult2.voucherOptionType : str4);
    }

    @Nullable
    public final String component1() {
        return this.f476id;
    }

    @NotNull
    public final String component10() {
        return this.voucherOptionType;
    }

    public final int component2() {
        return this.customerId;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.brandId;
    }

    public final float component5() {
        return this.discountValue;
    }

    @Nullable
    public final String component6() {
        return this.discountType;
    }

    public final float component7() {
        return this.maxDiscountCap;
    }

    public final float component8() {
        return this.minOrderValue;
    }

    @NotNull
    public final LoyaltyVoucherBounds component9() {
        return this.loyaltyVoucherBounds;
    }

    @NotNull
    public final LoyaltyVoucherResult copy(@Nullable String str, int i11, @Nullable String str2, int i12, float f11, @Nullable String str3, float f12, float f13, @NotNull LoyaltyVoucherBounds loyaltyVoucherBounds2, @NotNull String str4) {
        LoyaltyVoucherBounds loyaltyVoucherBounds3 = loyaltyVoucherBounds2;
        Intrinsics.checkNotNullParameter(loyaltyVoucherBounds3, "loyaltyVoucherBounds");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        return new LoyaltyVoucherResult(str, i11, str2, i12, f11, str3, f12, f13, loyaltyVoucherBounds3, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoyaltyVoucherResult)) {
            return false;
        }
        LoyaltyVoucherResult loyaltyVoucherResult = (LoyaltyVoucherResult) obj;
        return Intrinsics.areEqual((Object) this.f476id, (Object) loyaltyVoucherResult.f476id) && this.customerId == loyaltyVoucherResult.customerId && Intrinsics.areEqual((Object) this.title, (Object) loyaltyVoucherResult.title) && this.brandId == loyaltyVoucherResult.brandId && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(loyaltyVoucherResult.discountValue)) && Intrinsics.areEqual((Object) this.discountType, (Object) loyaltyVoucherResult.discountType) && Intrinsics.areEqual((Object) Float.valueOf(this.maxDiscountCap), (Object) Float.valueOf(loyaltyVoucherResult.maxDiscountCap)) && Intrinsics.areEqual((Object) Float.valueOf(this.minOrderValue), (Object) Float.valueOf(loyaltyVoucherResult.minOrderValue)) && Intrinsics.areEqual((Object) this.loyaltyVoucherBounds, (Object) loyaltyVoucherResult.loyaltyVoucherBounds) && Intrinsics.areEqual((Object) this.voucherOptionType, (Object) loyaltyVoucherResult.voucherOptionType);
    }

    public final int getBrandId() {
        return this.brandId;
    }

    public final int getCustomerId() {
        return this.customerId;
    }

    @Nullable
    public final String getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getVoucherOptionType() {
        return this.voucherOptionType;
    }

    public int hashCode() {
        String str = this.f476id;
        int i11 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.customerId) * 31;
        String str2 = this.title;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.brandId) * 31) + Float.floatToIntBits(this.discountValue)) * 31;
        String str3 = this.discountType;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return ((((((((hashCode2 + i11) * 31) + Float.floatToIntBits(this.maxDiscountCap)) * 31) + Float.floatToIntBits(this.minOrderValue)) * 31) + this.loyaltyVoucherBounds.hashCode()) * 31) + this.voucherOptionType.hashCode();
    }

    public final boolean isDeliveryDiscountType() {
        if (Intrinsics.areEqual((Object) this.discountType, (Object) DELIVERY_PERCENTAGE_DISCOUNT) || Intrinsics.areEqual((Object) this.discountType, (Object) FLAT_DELIVERY_DISCOUNT)) {
            return true;
        }
        return false;
    }

    public final boolean isDeliveryPercentage() {
        return Intrinsics.areEqual((Object) this.discountType, (Object) DELIVERY_PERCENTAGE_DISCOUNT);
    }

    public final boolean isDiscountAvailable() {
        return this.discountValue > 0.0f;
    }

    public final boolean isPercentage() {
        return Intrinsics.areEqual((Object) this.discountType, (Object) PERCENTAGE_DISCOUNT);
    }

    public final void setBrandId(int i11) {
        this.brandId = i11;
    }

    public final void setCustomerId(int i11) {
        this.customerId = i11;
    }

    public final void setDiscountType(@Nullable String str) {
        this.discountType = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.f476id;
        int i11 = this.customerId;
        String str2 = this.title;
        int i12 = this.brandId;
        float f11 = this.discountValue;
        String str3 = this.discountType;
        float f12 = this.maxDiscountCap;
        float f13 = this.minOrderValue;
        LoyaltyVoucherBounds loyaltyVoucherBounds2 = this.loyaltyVoucherBounds;
        String str4 = this.voucherOptionType;
        return "LoyaltyVoucherResult(id=" + str + ", customerId=" + i11 + ", title=" + str2 + ", brandId=" + i12 + ", discountValue=" + f11 + ", discountType=" + str3 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", loyaltyVoucherBounds=" + loyaltyVoucherBounds2 + ", voucherOptionType=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyVoucherResult(java.lang.String r17, int r18, java.lang.String r19, int r20, float r21, java.lang.String r22, float r23, float r24, JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds r25, java.lang.String r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r16 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r18
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r2
            goto L_0x001c
        L_0x001a:
            r5 = r19
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = r20
        L_0x0023:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002a
            r6 = r7
            goto L_0x002c
        L_0x002a:
            r6 = r21
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r7
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r7 = r24
        L_0x0042:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0061
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds r9 = new JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 15
            r15 = 0
            r17 = r9
            r18 = r10
            r19 = r11
            r20 = r12
            r21 = r13
            r22 = r14
            r23 = r15
            r17.<init>(r18, r19, r20, r21, r22, r23)
            goto L_0x0063
        L_0x0061:
            r9 = r25
        L_0x0063:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = "NONE"
            goto L_0x006c
        L_0x006a:
            r0 = r26
        L_0x006c:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r5
            r21 = r4
            r22 = r6
            r23 = r2
            r24 = r8
            r25 = r7
            r26 = r9
            r27 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult.<init>(java.lang.String, int, java.lang.String, int, float, java.lang.String, float, float, JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
