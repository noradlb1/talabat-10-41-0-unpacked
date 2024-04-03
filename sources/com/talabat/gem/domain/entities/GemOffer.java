package com.talabat.gem.domain.entities;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tHÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\fHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\u0004\u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00062"}, d2 = {"Lcom/talabat/gem/domain/entities/GemOffer;", "Ljava/io/Serializable;", "id", "", "discountPercentage", "", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "restaurants", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "expirationTimestamp", "", "brandingMessage", "collectionTitle", "collectionSubtitle", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandingMessage", "()Ljava/lang/String;", "getCollectionSubtitle", "getCollectionTitle", "getDiscountPercentage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getExpirationTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "getRestaurants", "()Ljava/util/List;", "getTiers", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/gem/domain/entities/GemOffer;", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOffer implements Serializable {
    @Nullable
    private final String brandingMessage;
    @Nullable
    private final String collectionSubtitle;
    @Nullable
    private final String collectionTitle;
    @Nullable
    private final Double discountPercentage;
    @Nullable
    private final Long expirationTimestamp;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f60328id;
    @Nullable
    private final List<GemRestaurant> restaurants;
    @Nullable
    private final List<GemTier> tiers;

    public GemOffer() {
        this((String) null, (Double) null, (List) null, (List) null, (Long) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public GemOffer(@Nullable String str, @Nullable Double d11, @Nullable List<GemTier> list, @Nullable List<GemRestaurant> list2, @Nullable Long l11, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.f60328id = str;
        this.discountPercentage = d11;
        this.tiers = list;
        this.restaurants = list2;
        this.expirationTimestamp = l11;
        this.brandingMessage = str2;
        this.collectionTitle = str3;
        this.collectionSubtitle = str4;
    }

    public static /* synthetic */ GemOffer copy$default(GemOffer gemOffer, String str, Double d11, List list, List list2, Long l11, String str2, String str3, String str4, int i11, Object obj) {
        GemOffer gemOffer2 = gemOffer;
        int i12 = i11;
        return gemOffer.copy((i12 & 1) != 0 ? gemOffer2.f60328id : str, (i12 & 2) != 0 ? gemOffer2.discountPercentage : d11, (i12 & 4) != 0 ? gemOffer2.tiers : list, (i12 & 8) != 0 ? gemOffer2.restaurants : list2, (i12 & 16) != 0 ? gemOffer2.expirationTimestamp : l11, (i12 & 32) != 0 ? gemOffer2.brandingMessage : str2, (i12 & 64) != 0 ? gemOffer2.collectionTitle : str3, (i12 & 128) != 0 ? gemOffer2.collectionSubtitle : str4);
    }

    @Nullable
    public final String component1() {
        return this.f60328id;
    }

    @Nullable
    public final Double component2() {
        return this.discountPercentage;
    }

    @Nullable
    public final List<GemTier> component3() {
        return this.tiers;
    }

    @Nullable
    public final List<GemRestaurant> component4() {
        return this.restaurants;
    }

    @Nullable
    public final Long component5() {
        return this.expirationTimestamp;
    }

    @Nullable
    public final String component6() {
        return this.brandingMessage;
    }

    @Nullable
    public final String component7() {
        return this.collectionTitle;
    }

    @Nullable
    public final String component8() {
        return this.collectionSubtitle;
    }

    @NotNull
    public final GemOffer copy(@Nullable String str, @Nullable Double d11, @Nullable List<GemTier> list, @Nullable List<GemRestaurant> list2, @Nullable Long l11, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new GemOffer(str, d11, list, list2, l11, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemOffer)) {
            return false;
        }
        GemOffer gemOffer = (GemOffer) obj;
        return Intrinsics.areEqual((Object) this.f60328id, (Object) gemOffer.f60328id) && Intrinsics.areEqual((Object) this.discountPercentage, (Object) gemOffer.discountPercentage) && Intrinsics.areEqual((Object) this.tiers, (Object) gemOffer.tiers) && Intrinsics.areEqual((Object) this.restaurants, (Object) gemOffer.restaurants) && Intrinsics.areEqual((Object) this.expirationTimestamp, (Object) gemOffer.expirationTimestamp) && Intrinsics.areEqual((Object) this.brandingMessage, (Object) gemOffer.brandingMessage) && Intrinsics.areEqual((Object) this.collectionTitle, (Object) gemOffer.collectionTitle) && Intrinsics.areEqual((Object) this.collectionSubtitle, (Object) gemOffer.collectionSubtitle);
    }

    @Nullable
    public final String getBrandingMessage() {
        return this.brandingMessage;
    }

    @Nullable
    public final String getCollectionSubtitle() {
        return this.collectionSubtitle;
    }

    @Nullable
    public final String getCollectionTitle() {
        return this.collectionTitle;
    }

    @Nullable
    public final Double getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Nullable
    public final Long getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Nullable
    public final String getId() {
        return this.f60328id;
    }

    @Nullable
    public final List<GemRestaurant> getRestaurants() {
        return this.restaurants;
    }

    @Nullable
    public final List<GemTier> getTiers() {
        return this.tiers;
    }

    public int hashCode() {
        String str = this.f60328id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d11 = this.discountPercentage;
        int hashCode2 = (hashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        List<GemTier> list = this.tiers;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<GemRestaurant> list2 = this.restaurants;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Long l11 = this.expirationTimestamp;
        int hashCode5 = (hashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str2 = this.brandingMessage;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collectionTitle;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collectionSubtitle;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode7 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f60328id;
        Double d11 = this.discountPercentage;
        List<GemTier> list = this.tiers;
        List<GemRestaurant> list2 = this.restaurants;
        Long l11 = this.expirationTimestamp;
        String str2 = this.brandingMessage;
        String str3 = this.collectionTitle;
        String str4 = this.collectionSubtitle;
        return "GemOffer(id=" + str + ", discountPercentage=" + d11 + ", tiers=" + list + ", restaurants=" + list2 + ", expirationTimestamp=" + l11 + ", brandingMessage=" + str2 + ", collectionTitle=" + str3 + ", collectionSubtitle=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GemOffer(java.lang.String r10, java.lang.Double r11, java.util.List r12, java.util.List r13, java.lang.Long r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.entities.GemOffer.<init>(java.lang.String, java.lang.Double, java.util.List, java.util.List, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
