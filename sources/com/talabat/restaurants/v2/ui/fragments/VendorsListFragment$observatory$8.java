package com.talabat.restaurants.v2.ui.fragments;

import androidx.paging.PagingData;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import com.talabat.restaurants.v2.ui.viewmodels.VendorListFragmentViewModelPaged;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.restaurants.v2.ui.fragments.VendorsListFragment$observatory$8", f = "VendorsListFragment.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
public final class VendorsListFragment$observatory$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61257h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61258i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Landroidx/paging/PagingData;", "Ldatamodels/RestaurantListItemModel;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.restaurants.v2.ui.fragments.VendorsListFragment$observatory$8$1", f = "VendorsListFragment.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.restaurants.v2.ui.fragments.VendorsListFragment$observatory$8$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PagingData<RestaurantListItemModel>, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f61259h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f61260i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(vendorsListFragment, continuation);
            r02.f61260i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PagingData<RestaurantListItemModel> pagingData, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pagingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f61259h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                RestaurantsListAdapterRefactor access$getVendorsListAdapter = vendorsListFragment.getVendorsListAdapter();
                this.f61259h = 1;
                if (access$getVendorsListAdapter.submitData((PagingData) this.f61260i, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$observatory$8(VendorsListFragment vendorsListFragment, Continuation<? super VendorsListFragment$observatory$8> continuation) {
        super(2, continuation);
        this.f61258i = vendorsListFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VendorsListFragment$observatory$8(this.f61258i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VendorsListFragment$observatory$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61257h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<RestaurantListItemModel>> pagedVendors = ((VendorListFragmentViewModelPaged) VendorsListFragment.access$getViewModel(this.f61258i)).getPagedVendors();
            final VendorsListFragment vendorsListFragment = this.f61258i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f61257h = 1;
            if (FlowKt.collectLatest(pagedVendors, r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
