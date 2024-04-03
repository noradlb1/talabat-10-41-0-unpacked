package com.talabat.restaurants.v2.ui.viewmodels;

import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged$loadVendorList$1$1", f = "VendorListFragmentViewModelPaged.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VendorListFragmentViewModelPaged$loadVendorList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61280h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VendorListFragmentViewModelPaged f61281i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorListFragmentViewModelPaged$loadVendorList$1$1(VendorListFragmentViewModelPaged vendorListFragmentViewModelPaged, Continuation<? super VendorListFragmentViewModelPaged$loadVendorList$1$1> continuation) {
        super(2, continuation);
        this.f61281i = vendorListFragmentViewModelPaged;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VendorListFragmentViewModelPaged$loadVendorList$1$1(this.f61281i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VendorListFragmentViewModelPaged$loadVendorList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer num;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61280h == 0) {
            ResultKt.throwOnFailure(obj);
            Pair<Integer, RestaurantListItemModel> inlineAd = this.f61281i.getInlineAd();
            if (inlineAd != null) {
                num = inlineAd.getFirst();
            } else {
                num = null;
            }
            if (num != null) {
                this.f61281i.getSource().invalidate();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
