package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import com.google.android.exoplayer2.C;
import com.talabat.sdsquad.core.DisplayModel;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\bq\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B±\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001d\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\t¢\u0006\u0002\u0010-J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0006HÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\t\u0010m\u001a\u00020\tHÆ\u0003J\t\u0010n\u001a\u00020\tHÆ\u0003J\t\u0010o\u001a\u00020\tHÆ\u0003J\t\u0010p\u001a\u00020\u0006HÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\t\u0010s\u001a\u00020\tHÆ\u0003J\t\u0010t\u001a\u00020\u0006HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\tHÆ\u0003J\t\u0010w\u001a\u00020\tHÆ\u0003J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dHÆ\u0003J\t\u0010y\u001a\u00020\u001fHÆ\u0003J\u000f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dHÆ\u0003J\t\u0010{\u001a\u00020\u0006HÆ\u0003J\t\u0010|\u001a\u00020\u0006HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\tHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u000eHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000eHÆ\u0003Jþ\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\t2\b\b\u0002\u0010,\u001a\u00020\tHÆ\u0001J\u0016\u0010\u0001\u001a\u00020\t2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010!\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00103\"\u0004\b<\u0010=R\u001a\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00103\"\u0004\bC\u0010=R\u001a\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010/\"\u0004\bE\u00101R\u001a\u0010'\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010/\"\u0004\bG\u00101R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d¢\u0006\b\n\u0000\u001a\u0004\bH\u0010:R\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00103R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010JR\u001a\u0010%\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010J\"\u0004\bP\u0010LR\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010JR\u001a\u0010+\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010J\"\u0004\bQ\u0010LR\u001a\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010J\"\u0004\bR\u0010LR\u001a\u0010*\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010J\"\u0004\bS\u0010LR\u001a\u0010&\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010J\"\u0004\bT\u0010LR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010J\"\u0004\bU\u0010LR\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010JR\u001a\u0010,\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010J\"\u0004\bV\u0010LR\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010JR\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010J\"\u0004\bW\u0010LR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010?\"\u0004\bY\u0010AR\u001a\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00103\"\u0004\b[\u0010=R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010/\"\u0004\ba\u00101R\u0011\u0010\u001b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bb\u0010JR\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010/\"\u0004\bd\u00101R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\be\u0010/R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010/\"\u0004\bg\u00101R\u001a\u0010)\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00103\"\u0004\bi\u0010=¨\u0006\u0001"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Lcom/talabat/sdsquad/core/DisplayModel;", "id", "", "branchId", "vendorName", "", "cuisines", "isNew", "", "rate", "", "deliveryTime", "minimumOrderAmount", "", "deliveryFee", "ratingCount", "isTgo", "hasDiscounts", "hasOffers", "isExtra", "upSellImage", "isBusy", "isClosed", "isOpen", "vendorLogo", "isSponsor", "showUpSellImage", "filtersId", "", "creationDate", "Ljava/util/Date;", "cuisinesIds", "coverImage", "baseUrl", "decimalCount", "deliveryTimeText", "isCashOnly", "isLiveTracking", "discountTxt", "priceTag", "verticalType", "isGrlEnabled", "isDarkStore", "isSafeDropOff", "(IILjava/lang/String;Ljava/lang/String;ZFIDDLjava/lang/String;ZZZZLjava/lang/String;ZZZLjava/lang/String;ZZLjava/util/List;Ljava/util/Date;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;IIZZZ)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getBranchId", "()I", "getCoverImage", "getCreationDate", "()Ljava/util/Date;", "getCuisines", "setCuisines", "getCuisinesIds", "()Ljava/util/List;", "getDecimalCount", "setDecimalCount", "(I)V", "getDeliveryFee", "()D", "setDeliveryFee", "(D)V", "getDeliveryTime", "setDeliveryTime", "getDeliveryTimeText", "setDeliveryTimeText", "getDiscountTxt", "setDiscountTxt", "getFiltersId", "getHasDiscounts", "()Z", "setHasDiscounts", "(Z)V", "getHasOffers", "setHasOffers", "getId", "setCashOnly", "setDarkStore", "setExtra", "setGrlEnabled", "setLiveTracking", "setNew", "setSafeDropOff", "setTgo", "getMinimumOrderAmount", "setMinimumOrderAmount", "getPriceTag", "setPriceTag", "getRate", "()F", "setRate", "(F)V", "getRatingCount", "setRatingCount", "getShowUpSellImage", "getUpSellImage", "setUpSellImage", "getVendorLogo", "getVendorName", "setVendorName", "getVerticalType", "setVerticalType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorDisplayModel implements DisplayModel {
    @NotNull
    private String baseUrl;
    private final int branchId;
    @NotNull
    private final String coverImage;
    @NotNull
    private final Date creationDate;
    @NotNull
    private String cuisines;
    @NotNull
    private final List<Integer> cuisinesIds;
    private int decimalCount;
    private double deliveryFee;
    private int deliveryTime;
    @NotNull
    private String deliveryTimeText;
    @NotNull
    private String discountTxt;
    @NotNull
    private final List<Integer> filtersId;
    private boolean hasDiscounts;
    private boolean hasOffers;

    /* renamed from: id  reason: collision with root package name */
    private final int f61350id;
    private final boolean isBusy;
    private boolean isCashOnly;
    private final boolean isClosed;
    private boolean isDarkStore;
    private boolean isExtra;
    private boolean isGrlEnabled;
    private boolean isLiveTracking;
    private boolean isNew;
    private final boolean isOpen;
    private boolean isSafeDropOff;
    private final boolean isSponsor;
    private boolean isTgo;
    private double minimumOrderAmount;
    private int priceTag;
    private float rate;
    @NotNull
    private String ratingCount;
    private final boolean showUpSellImage;
    @NotNull
    private String upSellImage;
    @NotNull
    private final String vendorLogo;
    @NotNull
    private String vendorName;
    private int verticalType;

    public VendorDisplayModel(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11, float f11, int i13, double d11, double d12, @NotNull String str3, boolean z12, boolean z13, boolean z14, boolean z15, @NotNull String str4, boolean z16, boolean z17, boolean z18, @NotNull String str5, boolean z19, boolean z21, @NotNull List<Integer> list, @NotNull Date date, @NotNull List<Integer> list2, @NotNull String str6, @NotNull String str7, int i14, @NotNull String str8, boolean z22, boolean z23, @NotNull String str9, int i15, int i16, boolean z24, boolean z25, boolean z26) {
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str4;
        String str14 = str5;
        List<Integer> list3 = list;
        Date date2 = date;
        List<Integer> list4 = list2;
        String str15 = str6;
        String str16 = str7;
        String str17 = str8;
        String str18 = str9;
        Intrinsics.checkNotNullParameter(str10, "vendorName");
        Intrinsics.checkNotNullParameter(str11, "cuisines");
        Intrinsics.checkNotNullParameter(str12, "ratingCount");
        Intrinsics.checkNotNullParameter(str13, "upSellImage");
        Intrinsics.checkNotNullParameter(str14, "vendorLogo");
        Intrinsics.checkNotNullParameter(list3, "filtersId");
        Intrinsics.checkNotNullParameter(date2, "creationDate");
        Intrinsics.checkNotNullParameter(list4, "cuisinesIds");
        Intrinsics.checkNotNullParameter(str15, "coverImage");
        Intrinsics.checkNotNullParameter(str16, "baseUrl");
        Intrinsics.checkNotNullParameter(str17, "deliveryTimeText");
        Intrinsics.checkNotNullParameter(str18, "discountTxt");
        this.f61350id = i11;
        this.branchId = i12;
        this.vendorName = str10;
        this.cuisines = str11;
        this.isNew = z11;
        this.rate = f11;
        this.deliveryTime = i13;
        this.minimumOrderAmount = d11;
        this.deliveryFee = d12;
        this.ratingCount = str12;
        this.isTgo = z12;
        this.hasDiscounts = z13;
        this.hasOffers = z14;
        this.isExtra = z15;
        this.upSellImage = str13;
        this.isBusy = z16;
        this.isClosed = z17;
        this.isOpen = z18;
        this.vendorLogo = str14;
        this.isSponsor = z19;
        this.showUpSellImage = z21;
        this.filtersId = list3;
        this.creationDate = date2;
        this.cuisinesIds = list4;
        this.coverImage = str15;
        this.baseUrl = str16;
        this.decimalCount = i14;
        this.deliveryTimeText = str17;
        this.isCashOnly = z22;
        this.isLiveTracking = z23;
        this.discountTxt = str18;
        this.priceTag = i15;
        this.verticalType = i16;
        this.isGrlEnabled = z24;
        this.isDarkStore = z25;
        this.isSafeDropOff = z26;
    }

    public static /* synthetic */ VendorDisplayModel copy$default(VendorDisplayModel vendorDisplayModel, int i11, int i12, String str, String str2, boolean z11, float f11, int i13, double d11, double d12, String str3, boolean z12, boolean z13, boolean z14, boolean z15, String str4, boolean z16, boolean z17, boolean z18, String str5, boolean z19, boolean z21, List list, Date date, List list2, String str6, String str7, int i14, String str8, boolean z22, boolean z23, String str9, int i15, int i16, boolean z24, boolean z25, boolean z26, int i17, int i18, Object obj) {
        VendorDisplayModel vendorDisplayModel2 = vendorDisplayModel;
        int i19 = i17;
        return vendorDisplayModel.copy((i19 & 1) != 0 ? vendorDisplayModel2.f61350id : i11, (i19 & 2) != 0 ? vendorDisplayModel2.branchId : i12, (i19 & 4) != 0 ? vendorDisplayModel2.vendorName : str, (i19 & 8) != 0 ? vendorDisplayModel2.cuisines : str2, (i19 & 16) != 0 ? vendorDisplayModel2.isNew : z11, (i19 & 32) != 0 ? vendorDisplayModel2.rate : f11, (i19 & 64) != 0 ? vendorDisplayModel2.deliveryTime : i13, (i19 & 128) != 0 ? vendorDisplayModel2.minimumOrderAmount : d11, (i19 & 256) != 0 ? vendorDisplayModel2.deliveryFee : d12, (i19 & 512) != 0 ? vendorDisplayModel2.ratingCount : str3, (i19 & 1024) != 0 ? vendorDisplayModel2.isTgo : z12, (i19 & 2048) != 0 ? vendorDisplayModel2.hasDiscounts : z13, (i19 & 4096) != 0 ? vendorDisplayModel2.hasOffers : z14, (i19 & 8192) != 0 ? vendorDisplayModel2.isExtra : z15, (i19 & 16384) != 0 ? vendorDisplayModel2.upSellImage : str4, (i19 & 32768) != 0 ? vendorDisplayModel2.isBusy : z16, (i19 & 65536) != 0 ? vendorDisplayModel2.isClosed : z17, (i19 & 131072) != 0 ? vendorDisplayModel2.isOpen : z18, (i19 & 262144) != 0 ? vendorDisplayModel2.vendorLogo : str5, (i19 & 524288) != 0 ? vendorDisplayModel2.isSponsor : z19, (i19 & 1048576) != 0 ? vendorDisplayModel2.showUpSellImage : z21, (i19 & 2097152) != 0 ? vendorDisplayModel2.filtersId : list, (i19 & 4194304) != 0 ? vendorDisplayModel2.creationDate : date, (i19 & 8388608) != 0 ? vendorDisplayModel2.cuisinesIds : list2, (i19 & 16777216) != 0 ? vendorDisplayModel2.coverImage : str6, (i19 & 33554432) != 0 ? vendorDisplayModel2.baseUrl : str7, (i19 & 67108864) != 0 ? vendorDisplayModel2.decimalCount : i14, (i19 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? vendorDisplayModel2.deliveryTimeText : str8, (i19 & 268435456) != 0 ? vendorDisplayModel2.isCashOnly : z22, (i19 & 536870912) != 0 ? vendorDisplayModel2.isLiveTracking : z23, (i19 & 1073741824) != 0 ? vendorDisplayModel2.discountTxt : str9, (i19 & Integer.MIN_VALUE) != 0 ? vendorDisplayModel2.priceTag : i15, (i18 & 1) != 0 ? vendorDisplayModel2.verticalType : i16, (i18 & 2) != 0 ? vendorDisplayModel2.isGrlEnabled : z24, (i18 & 4) != 0 ? vendorDisplayModel2.isDarkStore : z25, (i18 & 8) != 0 ? vendorDisplayModel2.isSafeDropOff : z26);
    }

    public final int component1() {
        return this.f61350id;
    }

    @NotNull
    public final String component10() {
        return this.ratingCount;
    }

    public final boolean component11() {
        return this.isTgo;
    }

    public final boolean component12() {
        return this.hasDiscounts;
    }

    public final boolean component13() {
        return this.hasOffers;
    }

    public final boolean component14() {
        return this.isExtra;
    }

    @NotNull
    public final String component15() {
        return this.upSellImage;
    }

    public final boolean component16() {
        return this.isBusy;
    }

    public final boolean component17() {
        return this.isClosed;
    }

    public final boolean component18() {
        return this.isOpen;
    }

    @NotNull
    public final String component19() {
        return this.vendorLogo;
    }

    public final int component2() {
        return this.branchId;
    }

    public final boolean component20() {
        return this.isSponsor;
    }

    public final boolean component21() {
        return this.showUpSellImage;
    }

    @NotNull
    public final List<Integer> component22() {
        return this.filtersId;
    }

    @NotNull
    public final Date component23() {
        return this.creationDate;
    }

    @NotNull
    public final List<Integer> component24() {
        return this.cuisinesIds;
    }

    @NotNull
    public final String component25() {
        return this.coverImage;
    }

    @NotNull
    public final String component26() {
        return this.baseUrl;
    }

    public final int component27() {
        return this.decimalCount;
    }

    @NotNull
    public final String component28() {
        return this.deliveryTimeText;
    }

    public final boolean component29() {
        return this.isCashOnly;
    }

    @NotNull
    public final String component3() {
        return this.vendorName;
    }

    public final boolean component30() {
        return this.isLiveTracking;
    }

    @NotNull
    public final String component31() {
        return this.discountTxt;
    }

    public final int component32() {
        return this.priceTag;
    }

    public final int component33() {
        return this.verticalType;
    }

    public final boolean component34() {
        return this.isGrlEnabled;
    }

    public final boolean component35() {
        return this.isDarkStore;
    }

    public final boolean component36() {
        return this.isSafeDropOff;
    }

    @NotNull
    public final String component4() {
        return this.cuisines;
    }

    public final boolean component5() {
        return this.isNew;
    }

    public final float component6() {
        return this.rate;
    }

    public final int component7() {
        return this.deliveryTime;
    }

    public final double component8() {
        return this.minimumOrderAmount;
    }

    public final double component9() {
        return this.deliveryFee;
    }

    @NotNull
    public final VendorDisplayModel copy(int i11, int i12, @NotNull String str, @NotNull String str2, boolean z11, float f11, int i13, double d11, double d12, @NotNull String str3, boolean z12, boolean z13, boolean z14, boolean z15, @NotNull String str4, boolean z16, boolean z17, boolean z18, @NotNull String str5, boolean z19, boolean z21, @NotNull List<Integer> list, @NotNull Date date, @NotNull List<Integer> list2, @NotNull String str6, @NotNull String str7, int i14, @NotNull String str8, boolean z22, boolean z23, @NotNull String str9, int i15, int i16, boolean z24, boolean z25, boolean z26) {
        int i17 = i11;
        Intrinsics.checkNotNullParameter(str, "vendorName");
        Intrinsics.checkNotNullParameter(str2, "cuisines");
        Intrinsics.checkNotNullParameter(str3, "ratingCount");
        Intrinsics.checkNotNullParameter(str4, "upSellImage");
        Intrinsics.checkNotNullParameter(str5, "vendorLogo");
        Intrinsics.checkNotNullParameter(list, "filtersId");
        Intrinsics.checkNotNullParameter(date, "creationDate");
        Intrinsics.checkNotNullParameter(list2, "cuisinesIds");
        Intrinsics.checkNotNullParameter(str6, "coverImage");
        Intrinsics.checkNotNullParameter(str7, "baseUrl");
        Intrinsics.checkNotNullParameter(str8, "deliveryTimeText");
        Intrinsics.checkNotNullParameter(str9, "discountTxt");
        return new VendorDisplayModel(i11, i12, str, str2, z11, f11, i13, d11, d12, str3, z12, z13, z14, z15, str4, z16, z17, z18, str5, z19, z21, list, date, list2, str6, str7, i14, str8, z22, z23, str9, i15, i16, z24, z25, z26);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorDisplayModel)) {
            return false;
        }
        VendorDisplayModel vendorDisplayModel = (VendorDisplayModel) obj;
        return this.f61350id == vendorDisplayModel.f61350id && this.branchId == vendorDisplayModel.branchId && Intrinsics.areEqual((Object) this.vendorName, (Object) vendorDisplayModel.vendorName) && Intrinsics.areEqual((Object) this.cuisines, (Object) vendorDisplayModel.cuisines) && this.isNew == vendorDisplayModel.isNew && Intrinsics.areEqual((Object) Float.valueOf(this.rate), (Object) Float.valueOf(vendorDisplayModel.rate)) && this.deliveryTime == vendorDisplayModel.deliveryTime && Intrinsics.areEqual((Object) Double.valueOf(this.minimumOrderAmount), (Object) Double.valueOf(vendorDisplayModel.minimumOrderAmount)) && Intrinsics.areEqual((Object) Double.valueOf(this.deliveryFee), (Object) Double.valueOf(vendorDisplayModel.deliveryFee)) && Intrinsics.areEqual((Object) this.ratingCount, (Object) vendorDisplayModel.ratingCount) && this.isTgo == vendorDisplayModel.isTgo && this.hasDiscounts == vendorDisplayModel.hasDiscounts && this.hasOffers == vendorDisplayModel.hasOffers && this.isExtra == vendorDisplayModel.isExtra && Intrinsics.areEqual((Object) this.upSellImage, (Object) vendorDisplayModel.upSellImage) && this.isBusy == vendorDisplayModel.isBusy && this.isClosed == vendorDisplayModel.isClosed && this.isOpen == vendorDisplayModel.isOpen && Intrinsics.areEqual((Object) this.vendorLogo, (Object) vendorDisplayModel.vendorLogo) && this.isSponsor == vendorDisplayModel.isSponsor && this.showUpSellImage == vendorDisplayModel.showUpSellImage && Intrinsics.areEqual((Object) this.filtersId, (Object) vendorDisplayModel.filtersId) && Intrinsics.areEqual((Object) this.creationDate, (Object) vendorDisplayModel.creationDate) && Intrinsics.areEqual((Object) this.cuisinesIds, (Object) vendorDisplayModel.cuisinesIds) && Intrinsics.areEqual((Object) this.coverImage, (Object) vendorDisplayModel.coverImage) && Intrinsics.areEqual((Object) this.baseUrl, (Object) vendorDisplayModel.baseUrl) && this.decimalCount == vendorDisplayModel.decimalCount && Intrinsics.areEqual((Object) this.deliveryTimeText, (Object) vendorDisplayModel.deliveryTimeText) && this.isCashOnly == vendorDisplayModel.isCashOnly && this.isLiveTracking == vendorDisplayModel.isLiveTracking && Intrinsics.areEqual((Object) this.discountTxt, (Object) vendorDisplayModel.discountTxt) && this.priceTag == vendorDisplayModel.priceTag && this.verticalType == vendorDisplayModel.verticalType && this.isGrlEnabled == vendorDisplayModel.isGrlEnabled && this.isDarkStore == vendorDisplayModel.isDarkStore && this.isSafeDropOff == vendorDisplayModel.isSafeDropOff;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final int getBranchId() {
        return this.branchId;
    }

    @NotNull
    public final String getCoverImage() {
        return this.coverImage;
    }

    @NotNull
    public final Date getCreationDate() {
        return this.creationDate;
    }

    @NotNull
    public final String getCuisines() {
        return this.cuisines;
    }

    @NotNull
    public final List<Integer> getCuisinesIds() {
        return this.cuisinesIds;
    }

    public final int getDecimalCount() {
        return this.decimalCount;
    }

    public final double getDeliveryFee() {
        return this.deliveryFee;
    }

    public final int getDeliveryTime() {
        return this.deliveryTime;
    }

    @NotNull
    public final String getDeliveryTimeText() {
        return this.deliveryTimeText;
    }

    @NotNull
    public final String getDiscountTxt() {
        return this.discountTxt;
    }

    @NotNull
    public final List<Integer> getFiltersId() {
        return this.filtersId;
    }

    public final boolean getHasDiscounts() {
        return this.hasDiscounts;
    }

    public final boolean getHasOffers() {
        return this.hasOffers;
    }

    public final int getId() {
        return this.f61350id;
    }

    public final double getMinimumOrderAmount() {
        return this.minimumOrderAmount;
    }

    public final int getPriceTag() {
        return this.priceTag;
    }

    public final float getRate() {
        return this.rate;
    }

    @NotNull
    public final String getRatingCount() {
        return this.ratingCount;
    }

    public final boolean getShowUpSellImage() {
        return this.showUpSellImage;
    }

    @NotNull
    public final String getUpSellImage() {
        return this.upSellImage;
    }

    @NotNull
    public final String getVendorLogo() {
        return this.vendorLogo;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        int hashCode = ((((((this.f61350id * 31) + this.branchId) * 31) + this.vendorName.hashCode()) * 31) + this.cuisines.hashCode()) * 31;
        boolean z11 = this.isNew;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int floatToIntBits = (((((((((((hashCode + (z11 ? 1 : 0)) * 31) + Float.floatToIntBits(this.rate)) * 31) + this.deliveryTime) * 31) + Double.doubleToLongBits(this.minimumOrderAmount)) * 31) + Double.doubleToLongBits(this.deliveryFee)) * 31) + this.ratingCount.hashCode()) * 31;
        boolean z13 = this.isTgo;
        if (z13) {
            z13 = true;
        }
        int i11 = (floatToIntBits + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.hasDiscounts;
        if (z14) {
            z14 = true;
        }
        int i12 = (i11 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.hasOffers;
        if (z15) {
            z15 = true;
        }
        int i13 = (i12 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isExtra;
        if (z16) {
            z16 = true;
        }
        int hashCode2 = (((i13 + (z16 ? 1 : 0)) * 31) + this.upSellImage.hashCode()) * 31;
        boolean z17 = this.isBusy;
        if (z17) {
            z17 = true;
        }
        int i14 = (hashCode2 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isClosed;
        if (z18) {
            z18 = true;
        }
        int i15 = (i14 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isOpen;
        if (z19) {
            z19 = true;
        }
        int hashCode3 = (((i15 + (z19 ? 1 : 0)) * 31) + this.vendorLogo.hashCode()) * 31;
        boolean z21 = this.isSponsor;
        if (z21) {
            z21 = true;
        }
        int i16 = (hashCode3 + (z21 ? 1 : 0)) * 31;
        boolean z22 = this.showUpSellImage;
        if (z22) {
            z22 = true;
        }
        int hashCode4 = (((((((((((((((i16 + (z22 ? 1 : 0)) * 31) + this.filtersId.hashCode()) * 31) + this.creationDate.hashCode()) * 31) + this.cuisinesIds.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + this.baseUrl.hashCode()) * 31) + this.decimalCount) * 31) + this.deliveryTimeText.hashCode()) * 31;
        boolean z23 = this.isCashOnly;
        if (z23) {
            z23 = true;
        }
        int i17 = (hashCode4 + (z23 ? 1 : 0)) * 31;
        boolean z24 = this.isLiveTracking;
        if (z24) {
            z24 = true;
        }
        int hashCode5 = (((((((i17 + (z24 ? 1 : 0)) * 31) + this.discountTxt.hashCode()) * 31) + this.priceTag) * 31) + this.verticalType) * 31;
        boolean z25 = this.isGrlEnabled;
        if (z25) {
            z25 = true;
        }
        int i18 = (hashCode5 + (z25 ? 1 : 0)) * 31;
        boolean z26 = this.isDarkStore;
        if (z26) {
            z26 = true;
        }
        int i19 = (i18 + (z26 ? 1 : 0)) * 31;
        boolean z27 = this.isSafeDropOff;
        if (!z27) {
            z12 = z27;
        }
        return i19 + (z12 ? 1 : 0);
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public final boolean isCashOnly() {
        return this.isCashOnly;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isDarkStore() {
        return this.isDarkStore;
    }

    public final boolean isExtra() {
        return this.isExtra;
    }

    public final boolean isGrlEnabled() {
        return this.isGrlEnabled;
    }

    public final boolean isLiveTracking() {
        return this.isLiveTracking;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final boolean isSafeDropOff() {
        return this.isSafeDropOff;
    }

    public final boolean isSponsor() {
        return this.isSponsor;
    }

    public final boolean isTgo() {
        return this.isTgo;
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setCashOnly(boolean z11) {
        this.isCashOnly = z11;
    }

    public final void setCuisines(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cuisines = str;
    }

    public final void setDarkStore(boolean z11) {
        this.isDarkStore = z11;
    }

    public final void setDecimalCount(int i11) {
        this.decimalCount = i11;
    }

    public final void setDeliveryFee(double d11) {
        this.deliveryFee = d11;
    }

    public final void setDeliveryTime(int i11) {
        this.deliveryTime = i11;
    }

    public final void setDeliveryTimeText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deliveryTimeText = str;
    }

    public final void setDiscountTxt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.discountTxt = str;
    }

    public final void setExtra(boolean z11) {
        this.isExtra = z11;
    }

    public final void setGrlEnabled(boolean z11) {
        this.isGrlEnabled = z11;
    }

    public final void setHasDiscounts(boolean z11) {
        this.hasDiscounts = z11;
    }

    public final void setHasOffers(boolean z11) {
        this.hasOffers = z11;
    }

    public final void setLiveTracking(boolean z11) {
        this.isLiveTracking = z11;
    }

    public final void setMinimumOrderAmount(double d11) {
        this.minimumOrderAmount = d11;
    }

    public final void setNew(boolean z11) {
        this.isNew = z11;
    }

    public final void setPriceTag(int i11) {
        this.priceTag = i11;
    }

    public final void setRate(float f11) {
        this.rate = f11;
    }

    public final void setRatingCount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ratingCount = str;
    }

    public final void setSafeDropOff(boolean z11) {
        this.isSafeDropOff = z11;
    }

    public final void setTgo(boolean z11) {
        this.isTgo = z11;
    }

    public final void setUpSellImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.upSellImage = str;
    }

    public final void setVendorName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorName = str;
    }

    public final void setVerticalType(int i11) {
        this.verticalType = i11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f61350id;
        int i12 = this.branchId;
        String str = this.vendorName;
        String str2 = this.cuisines;
        boolean z11 = this.isNew;
        float f11 = this.rate;
        int i13 = this.deliveryTime;
        double d11 = this.minimumOrderAmount;
        double d12 = this.deliveryFee;
        String str3 = this.ratingCount;
        boolean z12 = this.isTgo;
        boolean z13 = this.hasDiscounts;
        boolean z14 = this.hasOffers;
        boolean z15 = this.isExtra;
        String str4 = this.upSellImage;
        boolean z16 = this.isBusy;
        boolean z17 = this.isClosed;
        boolean z18 = this.isOpen;
        String str5 = this.vendorLogo;
        boolean z19 = this.isSponsor;
        boolean z21 = this.showUpSellImage;
        List<Integer> list = this.filtersId;
        Date date = this.creationDate;
        List<Integer> list2 = this.cuisinesIds;
        String str6 = this.coverImage;
        String str7 = this.baseUrl;
        int i14 = this.decimalCount;
        String str8 = this.deliveryTimeText;
        boolean z22 = this.isCashOnly;
        boolean z23 = this.isLiveTracking;
        String str9 = this.discountTxt;
        int i15 = this.priceTag;
        int i16 = this.verticalType;
        boolean z24 = this.isGrlEnabled;
        boolean z25 = this.isDarkStore;
        boolean z26 = this.isSafeDropOff;
        return "VendorDisplayModel(id=" + i11 + ", branchId=" + i12 + ", vendorName=" + str + ", cuisines=" + str2 + ", isNew=" + z11 + ", rate=" + f11 + ", deliveryTime=" + i13 + ", minimumOrderAmount=" + d11 + ", deliveryFee=" + d12 + ", ratingCount=" + str3 + ", isTgo=" + z12 + ", hasDiscounts=" + z13 + ", hasOffers=" + z14 + ", isExtra=" + z15 + ", upSellImage=" + str4 + ", isBusy=" + z16 + ", isClosed=" + z17 + ", isOpen=" + z18 + ", vendorLogo=" + str5 + ", isSponsor=" + z19 + ", showUpSellImage=" + z21 + ", filtersId=" + list + ", creationDate=" + date + ", cuisinesIds=" + list2 + ", coverImage=" + str6 + ", baseUrl=" + str7 + ", decimalCount=" + i14 + ", deliveryTimeText=" + str8 + ", isCashOnly=" + z22 + ", isLiveTracking=" + z23 + ", discountTxt=" + str9 + ", priceTag=" + i15 + ", verticalType=" + i16 + ", isGrlEnabled=" + z24 + ", isDarkStore=" + z25 + ", isSafeDropOff=" + z26 + ")";
    }
}
