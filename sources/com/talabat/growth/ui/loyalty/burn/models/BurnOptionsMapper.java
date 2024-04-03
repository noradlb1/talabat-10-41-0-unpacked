package com.talabat.growth.ui.loyalty.burn.models;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnItemResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnListResponse;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionCategory;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionCategoryMeta;
import com.talabat.growth.ui.loyalty.burn.models.VoucherOfferType;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001d"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/BurnOptionsMapper;", "", "()V", "getBurnItemCategoryViewType", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;", "viewMode", "", "getLoyaltyOfferType", "Lcom/talabat/growth/ui/loyalty/burn/models/VoucherOfferType;", "itemResponse", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getVoucherOfferType", "map", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "response", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnListResponse;", "mapMarketPlaceBurnItemResponse", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad", "mapMarketPlaceBurnOptionCategory", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "categoryResponse", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;", "removeImageSizeParameters", "url", "setMetaInfo", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryMetaDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsMapper {
    @NotNull
    public static final BurnOptionsMapper INSTANCE = new BurnOptionsMapper();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VoucherOptionType.values().length];
            iArr[VoucherOptionType.LOYALTY.ordinal()] = 1;
            iArr[VoucherOptionType.NFP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VoucherDiscountType.values().length];
            iArr2[VoucherDiscountType.FLAT.ordinal()] = 1;
            iArr2[VoucherDiscountType.PERCENTAGE.ordinal()] = 2;
            iArr2[VoucherDiscountType.DELIVERY_PERCENTAGE.ordinal()] = 3;
            iArr2[VoucherDiscountType.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private BurnOptionsMapper() {
    }

    private final BurnItemCategoryViewType getBurnItemCategoryViewType(String str) {
        boolean z11;
        if (str == null) {
            z11 = true;
        } else {
            z11 = Intrinsics.areEqual((Object) str, (Object) BurnItemCategoryViewType.SWIM_LANE_HALF_WIDTH_CARDS.getValue());
        }
        if (z11) {
            return BurnItemCategoryViewType.SWIM_LANE_HALF_WIDTH_CARDS;
        }
        BurnItemCategoryViewType burnItemCategoryViewType = BurnItemCategoryViewType.HERO_CARD;
        if (Intrinsics.areEqual((Object) str, (Object) burnItemCategoryViewType.getValue())) {
            return burnItemCategoryViewType;
        }
        return BurnItemCategoryViewType.SWIM_LANE_FULL_WIDTH_CARDS;
    }

    private final VoucherOfferType getLoyaltyOfferType(MarketPlaceBurnItemResponse marketPlaceBurnItemResponse, LocationConfigurationRepository locationConfigurationRepository) {
        VoucherOfferType voucherOfferType;
        float f11;
        int i11;
        int i12 = WhenMappings.$EnumSwitchMapping$1[VoucherDiscountType.Companion.from(marketPlaceBurnItemResponse.getDiscountType()).ordinal()];
        if (i12 == 1) {
            Float discountValue = marketPlaceBurnItemResponse.getDiscountValue();
            if (discountValue != null) {
                f11 = discountValue.floatValue();
            } else {
                f11 = 0.0f;
            }
            voucherOfferType = new VoucherOfferType.Discount(CurrencyFormatter.Companion.formatAmountWithoutDecimalsIfPossible(locationConfigurationRepository, f11, true));
        } else if (i12 == 2) {
            Float discountValue2 = marketPlaceBurnItemResponse.getDiscountValue();
            if (discountValue2 != null) {
                i11 = (int) discountValue2.floatValue();
            } else {
                i11 = 0;
            }
            voucherOfferType = new VoucherOfferType.PercentageDiscount(String.valueOf(i11));
        } else if (i12 == 3) {
            return new VoucherOfferType.FreeDelivery();
        } else {
            if (i12 == 4) {
                return new VoucherOfferType.Unknown();
            }
            throw new NoWhenBranchMatchedException();
        }
        return voucherOfferType;
    }

    private final VoucherOfferType getVoucherOfferType(MarketPlaceBurnItemResponse marketPlaceBurnItemResponse, LocationConfigurationRepository locationConfigurationRepository) {
        int i11;
        VoucherOptionType voucherOptionType = marketPlaceBurnItemResponse.getVoucherOptionType();
        if (voucherOptionType == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[voucherOptionType.ordinal()];
        }
        if (i11 == 1) {
            return getLoyaltyOfferType(marketPlaceBurnItemResponse, locationConfigurationRepository);
        }
        if (i11 == 2) {
            return new VoucherOfferType.Lifestyle();
        }
        if (LoyaltyBurnOptionType.Companion.getRedeemBurnOptionType(marketPlaceBurnItemResponse.getBurnOptionType()) == LoyaltyBurnOptionType.CHARITY) {
            return new VoucherOfferType.Charity();
        }
        return new VoucherOfferType.Unknown();
    }

    private final String removeImageSizeParameters(String str) {
        String str2 = null;
        if (str != null) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) TypeDescription.Generic.OfWildcardType.SYMBOL, false, 2, (Object) null)) {
                str = str.substring(0, StringsKt__StringsKt.indexOf$default((CharSequence) str, TypeDescription.Generic.OfWildcardType.SYMBOL, 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            str2 = str;
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private final BurnItemCategoryMetaDisplayModel setMetaInfo(MarketPlaceBurnOptionCategory marketPlaceBurnOptionCategory) {
        BurnItemCategoryMetaDisplayModel burnItemCategoryMetaDisplayModel = new BurnItemCategoryMetaDisplayModel((BurnItemCategoryViewType) null, 1, (DefaultConstructorMarker) null);
        MarketPlaceBurnOptionCategoryMeta meta = marketPlaceBurnOptionCategory.getMeta();
        if (meta != null) {
            burnItemCategoryMetaDisplayModel.setViewMode(INSTANCE.getBurnItemCategoryViewType(meta.getViewMode()));
        }
        return burnItemCategoryMetaDisplayModel;
    }

    @NotNull
    public final BurnListDisplayModel map(@Nullable MarketPlaceBurnListResponse marketPlaceBurnListResponse, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        BurnListDisplayModel burnListDisplayModel = new BurnListDisplayModel(0, 0, 0, (List) null, 15, (DefaultConstructorMarker) null);
        if (marketPlaceBurnListResponse != null) {
            burnListDisplayModel.setPageNumber(IntKt.orZero(marketPlaceBurnListResponse.getPageNumber()));
            burnListDisplayModel.setPageSize(IntKt.orZero(marketPlaceBurnListResponse.getPageSize()));
            burnListDisplayModel.setTotalCount(IntKt.orZero(marketPlaceBurnListResponse.getTotalCount()));
            MarketPlaceBurnOptionCategory[] data = marketPlaceBurnListResponse.getData();
            if (data != null) {
                for (MarketPlaceBurnOptionCategory mapMarketPlaceBurnOptionCategory : data) {
                    burnListDisplayModel.getData().add(INSTANCE.mapMarketPlaceBurnOptionCategory(mapMarketPlaceBurnOptionCategory, locationConfigurationRepository));
                }
            }
        }
        return burnListDisplayModel;
    }

    @NotNull
    public final BurnItemDisplayModel mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad(@NotNull MarketPlaceBurnItemResponse marketPlaceBurnItemResponse, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        String str;
        MarketPlaceBurnItemResponse marketPlaceBurnItemResponse2 = marketPlaceBurnItemResponse;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        Intrinsics.checkNotNullParameter(marketPlaceBurnItemResponse2, "itemResponse");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        BurnItemDisplayModel burnItemDisplayModel = new BurnItemDisplayModel((String) null, (String) null, 0, (String) null, (String) null, 0, (LoyaltyBurnOptionType) null, (String) null, (String) null, (VoucherOptionType) null, (SubscriptionRestriction) null, (VoucherOfferType) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
        String id2 = marketPlaceBurnItemResponse.getId();
        String str2 = "";
        if (id2 == null) {
            id2 = str2;
        }
        burnItemDisplayModel.setId(id2);
        String title = marketPlaceBurnItemResponse.getTitle();
        if (title == null) {
            title = str2;
        }
        burnItemDisplayModel.setTitle(title);
        burnItemDisplayModel.setCountry(IntKt.orZero(marketPlaceBurnItemResponse.getCountry()));
        BurnOptionsMapper burnOptionsMapper = INSTANCE;
        burnItemDisplayModel.setThumbnailURL(burnOptionsMapper.removeImageSizeParameters(marketPlaceBurnItemResponse.getThumbnailURL()));
        String imageURL = marketPlaceBurnItemResponse.getImageURL();
        if (imageURL != null) {
            str = StringsKt__StringsKt.trim((CharSequence) imageURL).toString();
        } else {
            str = null;
        }
        burnItemDisplayModel.setImageURL(burnOptionsMapper.removeImageSizeParameters(str));
        burnItemDisplayModel.setPointsCost(IntKt.orZero(marketPlaceBurnItemResponse.getPointsCost()));
        String description = marketPlaceBurnItemResponse.getDescription();
        if (description == null) {
            description = str2;
        }
        burnItemDisplayModel.setDescription(description);
        burnItemDisplayModel.setBurnOptionType(LoyaltyBurnOptionType.Companion.getRedeemBurnOptionType(marketPlaceBurnItemResponse.getBurnOptionType()));
        String tag = marketPlaceBurnItemResponse.getTag();
        if (tag != null) {
            str2 = tag;
        }
        burnItemDisplayModel.setTag(str2);
        VoucherOptionType voucherOptionType = marketPlaceBurnItemResponse.getVoucherOptionType();
        if (voucherOptionType == null) {
            voucherOptionType = VoucherOptionType.NONE;
        }
        burnItemDisplayModel.setVoucherOptionType(voucherOptionType);
        SubscriptionRestriction subscriptionRestriction = marketPlaceBurnItemResponse.getSubscriptionRestriction();
        if (subscriptionRestriction == null) {
            subscriptionRestriction = SubscriptionRestriction.UNRESTRICTED;
        }
        burnItemDisplayModel.setSubscriptionRestriction(subscriptionRestriction);
        burnItemDisplayModel.setVoucherOfferType(burnOptionsMapper.getVoucherOfferType(marketPlaceBurnItemResponse2, locationConfigurationRepository2));
        return burnItemDisplayModel;
    }

    @NotNull
    public final BurnItemCategoryDisplayModel mapMarketPlaceBurnOptionCategory(@NotNull MarketPlaceBurnOptionCategory marketPlaceBurnOptionCategory, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(marketPlaceBurnOptionCategory, "categoryResponse");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = new BurnItemCategoryDisplayModel();
        String categoryName = marketPlaceBurnOptionCategory.getCategoryName();
        String str = "";
        if (categoryName == null) {
            categoryName = str;
        }
        burnItemCategoryDisplayModel.setCategoryName(categoryName);
        String categoryId = marketPlaceBurnOptionCategory.getCategoryId();
        if (categoryId == null) {
            categoryId = str;
        }
        burnItemCategoryDisplayModel.setCategoryId(categoryId);
        String categoryType = marketPlaceBurnOptionCategory.getCategoryType();
        if (categoryType == null) {
            categoryType = str;
        }
        burnItemCategoryDisplayModel.setCategoryType(categoryType);
        String subtitle = marketPlaceBurnOptionCategory.getSubtitle();
        if (subtitle == null) {
            subtitle = str;
        }
        burnItemCategoryDisplayModel.setSubtitle(subtitle);
        String imageURL = marketPlaceBurnOptionCategory.getImageURL();
        if (imageURL != null) {
            str = imageURL;
        }
        burnItemCategoryDisplayModel.setImageURL(str);
        MarketPlaceBurnItemResponse[] burnItemsResponse = marketPlaceBurnOptionCategory.getBurnItemsResponse();
        if (burnItemsResponse != null) {
            for (MarketPlaceBurnItemResponse mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad : burnItemsResponse) {
                burnItemCategoryDisplayModel.getBurnItemsDisplayModel().add(INSTANCE.mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad(mapMarketPlaceBurnItemResponse$com_talabat_NewArchi_GrowthSquad_GrowthSquad, locationConfigurationRepository));
            }
        }
        burnItemCategoryDisplayModel.setMeta(INSTANCE.setMetaInfo(marketPlaceBurnOptionCategory));
        return burnItemCategoryDisplayModel;
    }
}
