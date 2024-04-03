package com.talabat.restaurants.v2.domain.swimlane;

import buisnessmodels.TalabatFormatter;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.helpers.ImagesHelper;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.PriceDisplayType;
import datamodels.FeaturedProductItem;
import datamodels.FeaturedProducts;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ot.a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002>\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0001Bs\u0012\u0006\u0010\b\u001a\u00020\t\u0012D\b\u0002\u0010\n\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00050\u000b\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00050\u000e¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0000¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0003H\u0002JM\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002RJ\u0010\n\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00050\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/restaurants/v2/domain/swimlane/GetDisplayFeatureProductsUseCase;", "Lkotlin/Function7;", "", "", "", "Lio/reactivex/Single;", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureProductsUseCase", "Lkotlin/Function6;", "Ldatamodels/FeaturedProducts;", "getVendorsUseCase", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "Ldatamodels/Restaurant;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;)V", "buildFeatureItemsDisplayList", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "featureProductItems", "Ldatamodels/FeaturedProductItem;", "vendors", "buildFeatureItemsDisplayList$com_talabat_talabat_talabat", "getPriceDisplayType", "Lcom/talabat/restaurants/v2/ui/displaymodels/PriceDisplayType;", "featureProductItem", "getShowRocketDeliveryTime", "deliveryTimeInteger", "invoke", "isForceUpdate", "verticalId", "latitude", "longitude", "areaId", "countryId", "cityId", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDisplayFeatureProductsUseCase implements Function7<Boolean, Integer, String, String, Integer, Integer, Integer, Single<List<? extends FeatureProductListDisplayModel>>> {
    @NotNull
    private final Function6<Boolean, String, String, Integer, Integer, List<Integer>, Single<List<FeaturedProducts>>> getFeatureProductsUseCase;
    @NotNull
    private final Function1<GetVendorsUseCase.Params, Single<List<Restaurant>>> getVendorsUseCase;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public GetDisplayFeatureProductsUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull Function6<? super Boolean, ? super String, ? super String, ? super Integer, ? super Integer, ? super List<Integer>, ? extends Single<List<FeaturedProducts>>> function6, @NotNull Function1<? super GetVendorsUseCase.Params, ? extends Single<List<Restaurant>>> function1) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(function6, "getFeatureProductsUseCase");
        Intrinsics.checkNotNullParameter(function1, "getVendorsUseCase");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getFeatureProductsUseCase = function6;
        this.getVendorsUseCase = function1;
    }

    private final PriceDisplayType getPriceDisplayType(FeaturedProductItem featuredProductItem) {
        if (featuredProductItem.getPrice() <= 0.0d) {
            return PriceDisplayType.PRICE_ON_SELECTION;
        }
        if (featuredProductItem.isDiscounted()) {
            return PriceDisplayType.DISCOUNT;
        }
        return PriceDisplayType.ONLY_PRICE;
    }

    private final boolean getShowRocketDeliveryTime(int i11) {
        return i11 <= 30;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final List m10740invoke$lambda2(GetDisplayFeatureProductsUseCase getDisplayFeatureProductsUseCase, List list, List list2) {
        FeatureProductListDisplayModel featureProductListDisplayModel;
        Intrinsics.checkNotNullParameter(getDisplayFeatureProductsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(list, "featureProducts");
        Intrinsics.checkNotNullParameter(list2, "vendors");
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new GetDisplayFeatureProductsUseCase$invoke$lambda2$$inlined$sortedBy$1());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FeaturedProducts featuredProducts = (FeaturedProducts) it.next();
            List<FeatureProductDisplayModel> buildFeatureItemsDisplayList$com_talabat_talabat_talabat = getDisplayFeatureProductsUseCase.buildFeatureItemsDisplayList$com_talabat_talabat_talabat(featuredProducts.getItems(), sortedWith);
            if (!buildFeatureItemsDisplayList$com_talabat_talabat_talabat.isEmpty()) {
                featureProductListDisplayModel = new FeatureProductListDisplayModel(buildFeatureItemsDisplayList$com_talabat_talabat_talabat, featuredProducts.getTitle(), featuredProducts.getPosition());
            } else {
                featureProductListDisplayModel = null;
            }
            if (featureProductListDisplayModel != null) {
                arrayList.add(featureProductListDisplayModel);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<FeatureProductDisplayModel> buildFeatureItemsDisplayList$com_talabat_talabat_talabat(@NotNull List<FeaturedProductItem> list, @NotNull List<? extends Restaurant> list2) {
        Iterator it;
        ArrayList arrayList;
        Boolean bool;
        GetDisplayFeatureProductsUseCase getDisplayFeatureProductsUseCase = this;
        List<FeaturedProductItem> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "featureProductItems");
        Intrinsics.checkNotNullParameter(list2, "vendors");
        ArrayList arrayList2 = new ArrayList();
        Iterable iterable = list3;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            FeaturedProductItem featuredProductItem = (FeaturedProductItem) it2.next();
            Restaurant vendor = featuredProductItem.getVendor();
            if (vendor != null) {
                String str = vendor.f13873name;
                Intrinsics.checkNotNullExpressionValue(str, "it.name");
                int i11 = vendor.f13872id;
                String name2 = featuredProductItem.getName();
                int id2 = featuredProductItem.getId();
                String str2 = vendor.deliveryTime;
                Intrinsics.checkNotNullExpressionValue(str2, "it.deliveryTime");
                int deliveryTimeInteger = vendor.getDeliveryTimeInteger();
                String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency((float) featuredProductItem.getOldPrice());
                Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance()\n          …tItem.oldPrice.toFloat())");
                it = it2;
                ArrayList arrayList4 = arrayList2;
                String formattedCurrency2 = TalabatFormatter.getInstance().getFormattedCurrency((float) featuredProductItem.getPrice());
                Intrinsics.checkNotNullExpressionValue(formattedCurrency2, "getInstance()\n          …ductItem.price.toFloat())");
                String itemThumbnail = ImagesHelper.Companion.getItemThumbnail(featuredProductItem.getThumbnail());
                boolean isDiscounted = featuredProductItem.isDiscounted();
                PriceDisplayType priceDisplayType = getDisplayFeatureProductsUseCase.getPriceDisplayType(featuredProductItem);
                boolean showRocketDeliveryTime = getDisplayFeatureProductsUseCase.getShowRocketDeliveryTime(vendor.getDeliveryTimeInteger());
                FeatureProductDisplayModel featureProductDisplayModel = r5;
                FeatureProductDisplayModel featureProductDisplayModel2 = new FeatureProductDisplayModel(str, i11, name2, id2, str2, deliveryTimeInteger, formattedCurrency, formattedCurrency2, itemThumbnail, isDiscounted, priceDisplayType, showRocketDeliveryTime, vendor, featuredProductItem);
                arrayList = arrayList4;
                bool = Boolean.valueOf(arrayList.add(featureProductDisplayModel));
            } else {
                it = it2;
                arrayList = arrayList2;
                bool = null;
            }
            arrayList3.add(bool);
            getDisplayFeatureProductsUseCase = this;
            arrayList2 = arrayList;
            it2 = it;
        }
        return arrayList2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), (String) obj3, (String) obj4, ((Number) obj5).intValue(), ((Number) obj6).intValue(), ((Number) obj7).intValue());
    }

    @NotNull
    public Single<List<FeatureProductListDisplayModel>> invoke(boolean z11, int i11, @NotNull String str, @NotNull String str2, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(str, "latitude");
        Intrinsics.checkNotNullParameter(str2, "longitude");
        Single<List<FeatureProductListDisplayModel>> zip = Single.zip(this.getFeatureProductsUseCase.invoke(Boolean.valueOf(z11), str, str2, Integer.valueOf(i12), Integer.valueOf(i13), CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11))), this.getVendorsUseCase.invoke(new GetVendorsUseCase.Params(false, i12, i14, i13, str, str2, i11)), new a(this));
        Intrinsics.checkNotNullExpressionValue(zip, "zip(\n            feature…         }\n            })");
        return zip;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetDisplayFeatureProductsUseCase(ITalabatFeatureFlag iTalabatFeatureFlag, Function6 function6, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iTalabatFeatureFlag, (i11 & 2) != 0 ? new GetFeatureProductsUseCase((SwimlaneRepository) null, 1, (DefaultConstructorMarker) null) : function6, function1);
    }
}
