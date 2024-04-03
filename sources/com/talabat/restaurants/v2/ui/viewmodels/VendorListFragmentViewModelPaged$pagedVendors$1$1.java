package com.talabat.restaurants.v2.ui.viewmodels;

import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"Ldatamodels/RestaurantListItemModel;", "restaurantListItemModel", "<anonymous parameter 1>", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$pagedVendors$1$1", f = "VendorListFragmentViewModelPaged.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VendorListFragmentViewModelPaged$pagedVendors$1$1 extends SuspendLambda implements Function3<RestaurantListItemModel, RestaurantListItemModel, Continuation<? super RestaurantListItemModel>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61282h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61283i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ VendorListFragmentViewModelPaged f61284j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorListFragmentViewModelPaged$pagedVendors$1$1(VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged, Continuation<? super VendorListFragmentViewModelPaged$pagedVendors$1$1> continuation) {
        super(3, continuation);
        this.f61284j = vendorListFragmentViewModelPaged;
    }

    @Nullable
    public final Object invoke(@Nullable RestaurantListItemModel restaurantListItemModel, @Nullable RestaurantListItemModel restaurantListItemModel2, @Nullable Continuation<? super RestaurantListItemModel> continuation) {
        VendorListFragmentViewModelPaged$pagedVendors$1$1 vendorListFragmentViewModelPaged$pagedVendors$1$1 = new VendorListFragmentViewModelPaged$pagedVendors$1$1(this.f61284j, continuation);
        vendorListFragmentViewModelPaged$pagedVendors$1$1.f61283i = restaurantListItemModel;
        return vendorListFragmentViewModelPaged$pagedVendors$1$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer num;
        Pair<Integer, RestaurantListItemModel> inlineAd;
        Restaurant restaurant;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61282h == 0) {
            ResultKt.throwOnFailure(obj);
            RestaurantListItemModel restaurantListItemModel = (RestaurantListItemModel) this.f61283i;
            Pair<Integer, RestaurantListItemModel> inlineAd2 = this.f61284j.getInlineAd();
            if (inlineAd2 == null) {
                return null;
            }
            VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged = this.f61284j;
            if (restaurantListItemModel == null || (restaurant = restaurantListItemModel.restaurant) == null) {
                num = null;
            } else {
                num = Boxing.boxInt(restaurant.itemPosition);
            }
            if (!Intrinsics.areEqual((Object) num, (Object) inlineAd2.getFirst()) || (inlineAd = vendorListFragmentViewModelPaged.getInlineAd()) == null) {
                return null;
            }
            return inlineAd.getSecond();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
