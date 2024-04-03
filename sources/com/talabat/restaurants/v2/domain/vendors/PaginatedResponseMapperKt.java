package com.talabat.restaurants.v2.domain.vendors;

import buisnessmodels.TalabatFormatter;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.helpers.ImagesHelper;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.PriceDisplayType;
import datamodels.FeaturedProductItem;
import datamodels.FeaturedProducts;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import datamodels.Swimlane;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017H\u0002\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u0011\u001a\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u00112\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"FAST_DELIVERY_THRESHOLD", "", "getInsertPosition", "positionFromResponse", "restaurants", "", "Ldatamodels/RestaurantListItemModel;", "getPriceDisplayType", "Lcom/talabat/restaurants/v2/ui/displaymodels/PriceDisplayType;", "featureProductItem", "Ldatamodels/FeaturedProductItem;", "getShowRocketDeliveryTime", "", "deliveryTimeInteger", "insertFeaturedProduct", "", "response", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "insertRewardsMission", "insertSwimlanes", "isPositionValid", "position", "makeFeaturedProductDisplayList", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "featuredProducts", "getOffset", "toListViewModel", "verticalIds", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PaginatedResponseMapperKt {
    private static final int FAST_DELIVERY_THRESHOLD = 30;

    private static final int getInsertPosition(int i11, List<RestaurantListItemModel> list) {
        int i12;
        boolean z11;
        if (list.isEmpty()) {
            return -1;
        }
        if (i11 == 0 && list.get(0).type == 1) {
            return 0;
        }
        Iterator<RestaurantListItemModel> it = list.iterator();
        int i13 = 0;
        while (true) {
            if (!it.hasNext()) {
                i13 = -1;
                break;
            }
            Restaurant restaurant = it.next().restaurant;
            if (restaurant != null) {
                i12 = restaurant.itemPosition;
            } else {
                i12 = -1;
            }
            if (i12 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i13++;
        }
        if (i13 == -1) {
            return -1;
        }
        return i13 + 1;
    }

    public static final int getOffset(@NotNull RestaurantListResponsePaginated restaurantListResponsePaginated) {
        Intrinsics.checkNotNullParameter(restaurantListResponsePaginated, "<this>");
        if (restaurantListResponsePaginated.getPage() - 1 < 0) {
            return 0;
        }
        return restaurantListResponsePaginated.getSize() * (restaurantListResponsePaginated.getPage() - 1);
    }

    private static final PriceDisplayType getPriceDisplayType(FeaturedProductItem featuredProductItem) {
        if (featuredProductItem.getPrice() <= 0.0d) {
            return PriceDisplayType.PRICE_ON_SELECTION;
        }
        if (featuredProductItem.isDiscounted()) {
            return PriceDisplayType.DISCOUNT;
        }
        return PriceDisplayType.ONLY_PRICE;
    }

    private static final boolean getShowRocketDeliveryTime(int i11) {
        return i11 <= 30;
    }

    private static final void insertFeaturedProduct(List<RestaurantListItemModel> list, RestaurantListResponsePaginated restaurantListResponsePaginated) {
        boolean z11;
        List<FeaturedProducts> featuredProducts = restaurantListResponsePaginated.getFeaturedProducts();
        if (featuredProducts != null) {
            for (FeaturedProducts featuredProducts2 : featuredProducts) {
                int insertPosition = getInsertPosition(featuredProducts2.getPosition(), list);
                if (isPositionValid(insertPosition, list)) {
                    Collection items = featuredProducts2.getItems();
                    if (items == null || items.isEmpty()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        List<FeatureProductDisplayModel> makeFeaturedProductDisplayList = makeFeaturedProductDisplayList(featuredProducts2.getItems());
                        if (true ^ makeFeaturedProductDisplayList.isEmpty()) {
                            list.add(insertPosition, new RestaurantListItemModel(14, new FeatureProductListDisplayModel(makeFeaturedProductDisplayList, featuredProducts2.getTitle(), featuredProducts2.getPosition())));
                        }
                    }
                }
            }
        }
    }

    private static final void insertRewardsMission(List<RestaurantListItemModel> list, RestaurantListResponsePaginated restaurantListResponsePaginated) {
        int i11;
        List<Mission> asReversed;
        boolean z11;
        boolean z12;
        Iterator<RestaurantListItemModel> it = list.iterator();
        int i12 = 0;
        while (true) {
            i11 = -1;
            if (!it.hasNext()) {
                i12 = -1;
                break;
            }
            if (it.next().type == 12) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                break;
            }
            i12++;
        }
        if (i12 == -1) {
            Iterator<RestaurantListItemModel> it2 = list.iterator();
            int i13 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (it2.next().type == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i11 = i13;
                    break;
                }
                i13++;
            }
        } else {
            i11 = i12 + 1;
        }
        List<Mission> missions = restaurantListResponsePaginated.getMissions();
        if (missions != null && (asReversed = CollectionsKt__ReversedViewsKt.asReversed(missions)) != null) {
            for (Mission mission : asReversed) {
                if (isPositionValid(i11, list)) {
                    RestaurantListItemModel fromRewardsMission = RestaurantListItemModel.fromRewardsMission(mission);
                    Intrinsics.checkNotNullExpressionValue(fromRewardsMission, "fromRewardsMission(it)");
                    list.add(i11, fromRewardsMission);
                }
            }
        }
    }

    private static final void insertSwimlanes(List<RestaurantListItemModel> list, RestaurantListResponsePaginated restaurantListResponsePaginated) {
        List<Swimlane> swimlanes = restaurantListResponsePaginated.getSwimlanes();
        if (swimlanes != null) {
            for (Swimlane swimlane : swimlanes) {
                int insertPosition = getInsertPosition(swimlane.getPosition(), list);
                if (isPositionValid(insertPosition, list)) {
                    RestaurantListItemModel fromVendorSwimlane = RestaurantListItemModel.fromVendorSwimlane(swimlane);
                    Intrinsics.checkNotNullExpressionValue(fromVendorSwimlane, "fromVendorSwimlane(it)");
                    list.add(insertPosition, fromVendorSwimlane);
                }
            }
        }
    }

    private static final boolean isPositionValid(int i11, List<RestaurantListItemModel> list) {
        return i11 >= 0 && i11 <= list.size();
    }

    private static final List<FeatureProductDisplayModel> makeFeaturedProductDisplayList(List<FeaturedProductItem> list) {
        Iterator it;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                FeaturedProductItem featuredProductItem = (FeaturedProductItem) it2.next();
                Restaurant vendor = featuredProductItem.getVendor();
                if (vendor != null) {
                    String str = vendor.f13873name;
                    Intrinsics.checkNotNullExpressionValue(str, "vendor.name");
                    int i11 = vendor.f13872id;
                    String name2 = featuredProductItem.getName();
                    int id2 = featuredProductItem.getId();
                    String str2 = vendor.deliveryTime;
                    Intrinsics.checkNotNullExpressionValue(str2, "vendor.deliveryTime");
                    int deliveryTimeInteger = vendor.getDeliveryTimeInteger();
                    String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency((float) featuredProductItem.getOldPrice());
                    Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance()\n          …tItem.oldPrice.toFloat())");
                    String formattedCurrency2 = TalabatFormatter.getInstance().getFormattedCurrency((float) featuredProductItem.getPrice());
                    Intrinsics.checkNotNullExpressionValue(formattedCurrency2, "getInstance()\n          …ductItem.price.toFloat())");
                    it = it2;
                    FeatureProductDisplayModel featureProductDisplayModel = r3;
                    FeatureProductDisplayModel featureProductDisplayModel2 = new FeatureProductDisplayModel(str, i11, name2, id2, str2, deliveryTimeInteger, formattedCurrency, formattedCurrency2, ImagesHelper.Companion.getItemThumbnail(featuredProductItem.getThumbnail()), featuredProductItem.isDiscounted(), getPriceDisplayType(featuredProductItem), getShowRocketDeliveryTime(vendor.getDeliveryTimeInteger()), vendor, featuredProductItem);
                    arrayList.add(featureProductDisplayModel);
                } else {
                    it = it2;
                }
                it2 = it;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<datamodels.RestaurantListItemModel> toListViewModel(@org.jetbrains.annotations.NotNull library.talabat.com.talabatlib.RestaurantListResponsePaginated r6, @org.jetbrains.annotations.Nullable java.util.List<java.lang.Integer> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List r0 = r6.getVendors()
            r1 = 0
            if (r0 == 0) goto L_0x0046
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
            r3 = r1
        L_0x001e:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0041
            java.lang.Object r4 = r0.next()
            int r5 = r3 + 1
            if (r3 >= 0) goto L_0x002f
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x002f:
            datamodels.Restaurant r4 = (datamodels.Restaurant) r4
            int r3 = getOffset(r6)
            int r3 = r3 + r5
            r4.itemPosition = r3
            datamodels.RestaurantListItemModel r3 = datamodels.RestaurantListItemModel.fromVendor(r4)
            r2.add(r3)
            r3 = r5
            goto L_0x001e
        L_0x0041:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r2)
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            int r2 = r6.getPage()
            r3 = 1
            if (r2 > r3) goto L_0x009a
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x005c
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r2 = r1
            goto L_0x005d
        L_0x005c:
            r2 = r3
        L_0x005d:
            if (r2 != 0) goto L_0x009a
            com.talabat.core.experiment.data.TalabatExperiment r2 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.experiment.data.TalabatExperimentConstants r4 = com.talabat.core.experiment.data.TalabatExperimentConstants.CAN_SHOW_FLUTTER_VL_COLLECTION
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r5 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.APPTIMIZE
            boolean r2 = r2.getBooleanVariant(r4, r1, r5)
            if (r2 == 0) goto L_0x007f
            if (r7 == 0) goto L_0x007a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r2)
            boolean r7 = r7.equals(r2)
            goto L_0x007b
        L_0x007a:
            r7 = r1
        L_0x007b:
            if (r7 == 0) goto L_0x007f
            r7 = r3
            goto L_0x0080
        L_0x007f:
            r7 = r1
        L_0x0080:
            if (r7 == 0) goto L_0x008a
            datamodels.RestaurantListItemModel r7 = datamodels.RestaurantListItemModel.fromFlutterCollections()
            r0.add(r1, r7)
            r1 = r3
        L_0x008a:
            datamodels.RestaurantListItemModel r7 = datamodels.RestaurantListItemModel.fromHeader()
            r0.add(r1, r7)
            insertSwimlanes(r0, r6)
            insertFeaturedProduct(r0, r6)
            insertRewardsMission(r0, r6)
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.v2.domain.vendors.PaginatedResponseMapperKt.toListViewModel(library.talabat.com.talabatlib.RestaurantListResponsePaginated, java.util.List):java.util.List");
    }
}
