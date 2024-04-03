package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.MyPossibleVouchers;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.MyPossibleVouchersRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.PossibleCustomerVoucher;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.SubscriptionRestriction;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherResponseModel;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t\u001a\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"enLocal", "Ljava/util/Locale;", "getMyPossibleVoucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/PossibleCustomerVoucher;", "getVoucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "id", "", "model", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherResponseModel;", "voucherTitle", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "mapBounds", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "boundsResponse", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BoundsResponse;", "mapToDiscountType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/DiscountType;", "type", "mapToVoucherType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherType;", "mapToApplyVoucherViewHolderDisplayModel", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyPossibleVouchersRootResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelMapperKt {
    @NotNull
    private static final Locale enLocal = new Locale("en", Profile.Country.US);

    private static final VoucherDisplayModel getMyPossibleVoucherDisplayModel(PossibleCustomerVoucher possibleCustomerVoucher) {
        VoucherDisplayModel voucherDisplayModel = new VoucherDisplayModel((String) null, (String) null, (String) null, false, (VoucherType) null, (VoucherData) null, (DisabledReason) null, (SubscriptionRestriction) null, (String) null, 511, (DefaultConstructorMarker) null);
        String id2 = possibleCustomerVoucher.getId();
        String str = "";
        if (id2 == null) {
            id2 = str;
        }
        voucherDisplayModel.setId(id2);
        String title = possibleCustomerVoucher.getTitle();
        if (title == null) {
            title = str;
        }
        voucherDisplayModel.setTitle(title);
        String subTitle = possibleCustomerVoucher.getSubTitle();
        if (subTitle == null) {
            subTitle = str;
        }
        voucherDisplayModel.setSubTitle(subTitle);
        voucherDisplayModel.setApplied(BooleanKt.orFalse(possibleCustomerVoucher.isApplied()));
        String type = possibleCustomerVoucher.getType();
        if (type == null) {
            type = str;
        }
        voucherDisplayModel.setType(mapToVoucherType(type));
        voucherDisplayModel.setVoucherData(getVoucherDisplayModel(possibleCustomerVoucher.getId(), possibleCustomerVoucher.getModel(), voucherDisplayModel.getTitle(), possibleCustomerVoucher.getVoucherOptionType()));
        SubscriptionRestriction subscriptionRestriction = possibleCustomerVoucher.getSubscriptionRestriction();
        if (subscriptionRestriction == null) {
            subscriptionRestriction = SubscriptionRestriction.UNRESTRICTED;
        }
        voucherDisplayModel.setSubscriptionRestriction(subscriptionRestriction);
        String restrictionDescription = possibleCustomerVoucher.getRestrictionDescription();
        if (restrictionDescription != null) {
            str = restrictionDescription;
        }
        voucherDisplayModel.setRestrictionDescription(str);
        return voucherDisplayModel;
    }

    @NotNull
    public static final VoucherData getVoucherDisplayModel(@Nullable String str, @Nullable VoucherResponseModel voucherResponseModel, @NotNull String str2, @Nullable VoucherOptionType voucherOptionType) {
        String str3;
        VoucherOptionType voucherOptionType2;
        Intrinsics.checkNotNullParameter(str2, "voucherTitle");
        if (voucherResponseModel == null) {
            return new VoucherData((String) null, (String) null, 0, 0.0f, (DiscountType) null, 0.0f, 0.0f, (Bounds) null, (VoucherOptionType) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 131071, (DefaultConstructorMarker) null);
        }
        String str4 = "";
        if (str == null) {
            str3 = str4;
        } else {
            str3 = str;
        }
        int orZero = IntKt.orZero(voucherResponseModel.getPointsCost());
        float orZero2 = FloatKt.orZero(voucherResponseModel.getDiscountValue());
        String discountType = voucherResponseModel.getDiscountType();
        if (discountType != null) {
            str4 = discountType;
        }
        DiscountType mapToDiscountType = mapToDiscountType(str4);
        float orZero3 = FloatKt.orZero(voucherResponseModel.getMaxDiscountCap());
        float orZero4 = FloatKt.orZero(voucherResponseModel.getMinOrderValue());
        Bounds mapBounds = mapBounds(voucherResponseModel.getBounds());
        if (voucherOptionType == null) {
            voucherOptionType2 = VoucherOptionType.NONE;
        } else {
            voucherOptionType2 = voucherOptionType;
        }
        return new VoucherData(str3, str2, orZero, orZero2, mapToDiscountType, orZero3, orZero4, mapBounds, voucherOptionType2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, 130560, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final Bounds mapBounds(@Nullable BoundsResponse boundsResponse) {
        List list;
        List list2;
        List list3;
        Boolean excludeCategories;
        List<String> skuIds;
        boolean z11;
        List<String> categoryIds;
        boolean z12;
        List<String> productIds;
        boolean z13;
        boolean z14 = false;
        if (boundsResponse == null || (productIds = boundsResponse.getProductIds()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = new ArrayList();
            for (Object next : productIds) {
                String str = (String) next;
                if (str == null || str.length() == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    list.add(next);
                }
            }
        }
        if (boundsResponse == null || (categoryIds = boundsResponse.getCategoryIds()) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = new ArrayList();
            for (Object next2 : categoryIds) {
                String str2 = (String) next2;
                if (str2 == null || str2.length() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    list2.add(next2);
                }
            }
        }
        if (boundsResponse == null || (skuIds = boundsResponse.getSkuIds()) == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list3 = new ArrayList();
            for (Object next3 : skuIds) {
                String str3 = (String) next3;
                if (str3 == null || str3.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    list3.add(next3);
                }
            }
        }
        if (!(boundsResponse == null || (excludeCategories = boundsResponse.getExcludeCategories()) == null)) {
            z14 = excludeCategories.booleanValue();
        }
        return new Bounds(list, list2, list3, z14);
    }

    public static final void mapToApplyVoucherViewHolderDisplayModel(@NotNull ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel, @NotNull MyPossibleVouchersRootResponse myPossibleVouchersRootResponse) {
        List<PossibleCustomerVoucher> possibleCustomerVouchers;
        Intrinsics.checkNotNullParameter(applyVoucherViewHolderDisplayModel, "<this>");
        Intrinsics.checkNotNullParameter(myPossibleVouchersRootResponse, "response");
        MyPossibleVouchers myPossibleVouchers = (MyPossibleVouchers) myPossibleVouchersRootResponse.getResult();
        if (myPossibleVouchers != null && (possibleCustomerVouchers = myPossibleVouchers.getPossibleCustomerVouchers()) != null) {
            for (PossibleCustomerVoucher myPossibleVoucherDisplayModel : possibleCustomerVouchers) {
                applyVoucherViewHolderDisplayModel.getMyVouchers().add(getMyPossibleVoucherDisplayModel(myPossibleVoucherDisplayModel));
            }
        }
    }

    @NotNull
    public static final DiscountType mapToDiscountType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        String lowerCase = str.toLowerCase(enLocal);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        DiscountType discountType = DiscountType.PERCENTAGE;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) discountType.getValue())) {
            return discountType;
        }
        DiscountType discountType2 = DiscountType.FLAT;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) discountType2.getValue())) {
            return discountType2;
        }
        DiscountType discountType3 = DiscountType.DELIVERY_PERCENTAGE;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) discountType3.getValue())) {
            return discountType3;
        }
        DiscountType discountType4 = DiscountType.FLAT_DELIVERY;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) discountType4.getValue())) {
            return discountType4;
        }
        return DiscountType.NONE;
    }

    @NotNull
    public static final VoucherType mapToVoucherType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        String lowerCase = str.toLowerCase(enLocal);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        VoucherType voucherType = VoucherType.VOUCHER;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) voucherType.getValue())) {
            return voucherType;
        }
        VoucherType voucherType2 = VoucherType.REDEEM_OPTION;
        if (Intrinsics.areEqual((Object) lowerCase, (Object) voucherType2.getValue())) {
            return voucherType2;
        }
        return VoucherType.NONE;
    }
}
