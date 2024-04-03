package com.talabat.darkstores.data.repository;

import JsonModels.Request.RestaurantInfoRequest.RestaurantInfoRequestModel;
import JsonModels.Response.MenuItemResponse;
import com.talabat.helpers.AppUrls;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "LJsonModels/Response/MenuItemResponse;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl$getMigratedVendor$2", f = "DarkstoresRepositoryImpl.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class DarkstoresRepositoryImpl$getMigratedVendor$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MenuItemResponse>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56208h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56209i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f56210j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresRepositoryImpl$getMigratedVendor$2(DarkstoresRepositoryImpl darkstoresRepositoryImpl, String str, Continuation<? super DarkstoresRepositoryImpl$getMigratedVendor$2> continuation) {
        super(2, continuation);
        this.f56209i = darkstoresRepositoryImpl;
        this.f56210j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkstoresRepositoryImpl$getMigratedVendor$2(this.f56209i, this.f56210j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super MenuItemResponse> continuation) {
        return ((DarkstoresRepositoryImpl$getMigratedVendor$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56208h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RestaurantInfoRequestModel restaurantInfoRequestModel = new RestaurantInfoRequestModel(String.valueOf(this.f56209i.selectedAreaId.get()), (String) this.f56209i.selectedLatitude.get(), (String) this.f56209i.selectedLongitude.get(), String.valueOf(this.f56209i.selectedCountryId.get()));
            ApiHandler.Services callApi = ApiHandler.callApi();
            String str = AppUrls.SPLIT_RESTAURANT_INFO_WITH_LOCATION;
            Intrinsics.checkNotNullExpressionValue(str, "SPLIT_RESTAURANT_INFO_WITH_LOCATION");
            Observable<MenuItemResponse> restaurantInfoWithLocation = callApi.getRestaurantInfoWithLocation(StringsKt__StringsJVMKt.replace$default(str, "{branchId}", this.f56210j, false, 4, (Object) null), restaurantInfoRequestModel);
            Intrinsics.checkNotNullExpressionValue(restaurantInfoWithLocation, "callApi()\n              …stModel\n                )");
            this.f56208h = 1;
            obj = RxAwaitKt.awaitFirst(restaurantInfoWithLocation, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
