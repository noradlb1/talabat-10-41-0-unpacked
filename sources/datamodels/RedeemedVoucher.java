package datamodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0012HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015¨\u0006<"}, d2 = {"Ldatamodels/RedeemedVoucher;", "", "id", "", "title", "discountValue", "", "discountType", "maxDiscountCap", "minOrderValue", "tag", "validTil", "termsAndConditions", "deepLink", "description", "voucherCode", "campaignReferenceId", "redeemedVouchersCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCampaignReferenceId", "()Ljava/lang/String;", "getDeepLink", "getDescription", "getDiscountType", "getDiscountValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getId", "getMaxDiscountCap", "getMinOrderValue", "getRedeemedVouchersCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTag", "getTermsAndConditions", "getTitle", "getValidTil", "getVoucherCode", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ldatamodels/RedeemedVoucher;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemedVoucher {
    @Nullable
    private final String campaignReferenceId;
    @Nullable
    private final String deepLink;
    @Nullable
    private final String description;
    @Nullable
    private final String discountType;
    @Nullable
    private final Float discountValue;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f13871id;
    @Nullable
    private final Float maxDiscountCap;
    @Nullable
    private final Float minOrderValue;
    @Nullable
    private final Integer redeemedVouchersCount;
    @Nullable
    private final String tag;
    @Nullable
    private final String termsAndConditions;
    @Nullable
    private final String title;
    @Nullable
    private final String validTil;
    @Nullable
    private final String voucherCode;

    public RedeemedVoucher() {
        this((String) null, (String) null, (Float) null, (String) null, (Float) null, (Float) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 16383, (DefaultConstructorMarker) null);
    }

    public RedeemedVoucher(@Nullable String str, @Nullable String str2, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, @Nullable Float f13, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num) {
        this.f13871id = str;
        this.title = str2;
        this.discountValue = f11;
        this.discountType = str3;
        this.maxDiscountCap = f12;
        this.minOrderValue = f13;
        this.tag = str4;
        this.validTil = str5;
        this.termsAndConditions = str6;
        this.deepLink = str7;
        this.description = str8;
        this.voucherCode = str9;
        this.campaignReferenceId = str10;
        this.redeemedVouchersCount = num;
    }

    public static /* synthetic */ RedeemedVoucher copy$default(RedeemedVoucher redeemedVoucher, String str, String str2, Float f11, String str3, Float f12, Float f13, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, int i11, Object obj) {
        RedeemedVoucher redeemedVoucher2 = redeemedVoucher;
        int i12 = i11;
        return redeemedVoucher.copy((i12 & 1) != 0 ? redeemedVoucher2.f13871id : str, (i12 & 2) != 0 ? redeemedVoucher2.title : str2, (i12 & 4) != 0 ? redeemedVoucher2.discountValue : f11, (i12 & 8) != 0 ? redeemedVoucher2.discountType : str3, (i12 & 16) != 0 ? redeemedVoucher2.maxDiscountCap : f12, (i12 & 32) != 0 ? redeemedVoucher2.minOrderValue : f13, (i12 & 64) != 0 ? redeemedVoucher2.tag : str4, (i12 & 128) != 0 ? redeemedVoucher2.validTil : str5, (i12 & 256) != 0 ? redeemedVoucher2.termsAndConditions : str6, (i12 & 512) != 0 ? redeemedVoucher2.deepLink : str7, (i12 & 1024) != 0 ? redeemedVoucher2.description : str8, (i12 & 2048) != 0 ? redeemedVoucher2.voucherCode : str9, (i12 & 4096) != 0 ? redeemedVoucher2.campaignReferenceId : str10, (i12 & 8192) != 0 ? redeemedVoucher2.redeemedVouchersCount : num);
    }

    @Nullable
    public final String component1() {
        return this.f13871id;
    }

    @Nullable
    public final String component10() {
        return this.deepLink;
    }

    @Nullable
    public final String component11() {
        return this.description;
    }

    @Nullable
    public final String component12() {
        return this.voucherCode;
    }

    @Nullable
    public final String component13() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final Integer component14() {
        return this.redeemedVouchersCount;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Float component3() {
        return this.discountValue;
    }

    @Nullable
    public final String component4() {
        return this.discountType;
    }

    @Nullable
    public final Float component5() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float component6() {
        return this.minOrderValue;
    }

    @Nullable
    public final String component7() {
        return this.tag;
    }

    @Nullable
    public final String component8() {
        return this.validTil;
    }

    @Nullable
    public final String component9() {
        return this.termsAndConditions;
    }

    @NotNull
    public final RedeemedVoucher copy(@Nullable String str, @Nullable String str2, @Nullable Float f11, @Nullable String str3, @Nullable Float f12, @Nullable Float f13, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num) {
        return new RedeemedVoucher(str, str2, f11, str3, f12, f13, str4, str5, str6, str7, str8, str9, str10, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemedVoucher)) {
            return false;
        }
        RedeemedVoucher redeemedVoucher = (RedeemedVoucher) obj;
        return Intrinsics.areEqual((Object) this.f13871id, (Object) redeemedVoucher.f13871id) && Intrinsics.areEqual((Object) this.title, (Object) redeemedVoucher.title) && Intrinsics.areEqual((Object) this.discountValue, (Object) redeemedVoucher.discountValue) && Intrinsics.areEqual((Object) this.discountType, (Object) redeemedVoucher.discountType) && Intrinsics.areEqual((Object) this.maxDiscountCap, (Object) redeemedVoucher.maxDiscountCap) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) redeemedVoucher.minOrderValue) && Intrinsics.areEqual((Object) this.tag, (Object) redeemedVoucher.tag) && Intrinsics.areEqual((Object) this.validTil, (Object) redeemedVoucher.validTil) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) redeemedVoucher.termsAndConditions) && Intrinsics.areEqual((Object) this.deepLink, (Object) redeemedVoucher.deepLink) && Intrinsics.areEqual((Object) this.description, (Object) redeemedVoucher.description) && Intrinsics.areEqual((Object) this.voucherCode, (Object) redeemedVoucher.voucherCode) && Intrinsics.areEqual((Object) this.campaignReferenceId, (Object) redeemedVoucher.campaignReferenceId) && Intrinsics.areEqual((Object) this.redeemedVouchersCount, (Object) redeemedVoucher.redeemedVouchersCount);
    }

    @Nullable
    public final String getCampaignReferenceId() {
        return this.campaignReferenceId;
    }

    @Nullable
    public final String getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDiscountType() {
        return this.discountType;
    }

    @Nullable
    public final Float getDiscountValue() {
        return this.discountValue;
    }

    @Nullable
    public final String getId() {
        return this.f13871id;
    }

    @Nullable
    public final Float getMaxDiscountCap() {
        return this.maxDiscountCap;
    }

    @Nullable
    public final Float getMinOrderValue() {
        return this.minOrderValue;
    }

    @Nullable
    public final Integer getRedeemedVouchersCount() {
        return this.redeemedVouchersCount;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getValidTil() {
        return this.validTil;
    }

    @Nullable
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    public int hashCode() {
        String str = this.f13871id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.discountValue;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str3 = this.discountType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f12 = this.maxDiscountCap;
        int hashCode5 = (hashCode4 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Float f13 = this.minOrderValue;
        int hashCode6 = (hashCode5 + (f13 == null ? 0 : f13.hashCode())) * 31;
        String str4 = this.tag;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.validTil;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.termsAndConditions;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.deepLink;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.description;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.voucherCode;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.campaignReferenceId;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num = this.redeemedVouchersCount;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode13 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f13871id;
        String str2 = this.title;
        Float f11 = this.discountValue;
        String str3 = this.discountType;
        Float f12 = this.maxDiscountCap;
        Float f13 = this.minOrderValue;
        String str4 = this.tag;
        String str5 = this.validTil;
        String str6 = this.termsAndConditions;
        String str7 = this.deepLink;
        String str8 = this.description;
        String str9 = this.voucherCode;
        String str10 = this.campaignReferenceId;
        Integer num = this.redeemedVouchersCount;
        return "RedeemedVoucher(id=" + str + ", title=" + str2 + ", discountValue=" + f11 + ", discountType=" + str3 + ", maxDiscountCap=" + f12 + ", minOrderValue=" + f13 + ", tag=" + str4 + ", validTil=" + str5 + ", termsAndConditions=" + str6 + ", deepLink=" + str7 + ", description=" + str8 + ", voucherCode=" + str9 + ", campaignReferenceId=" + str10 + ", redeemedVouchersCount=" + num + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedeemedVoucher(java.lang.String r16, java.lang.String r17, java.lang.Float r18, java.lang.String r19, java.lang.Float r20, java.lang.Float r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.Integer r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r28
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r29
        L_0x0072:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.RedeemedVoucher.<init>(java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Float, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
