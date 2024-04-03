package com.talabat.restaurants.v2.ui.fragments;

import androidx.paging.CombinedLoadStates;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.restaurants.v2.ui.fragments.VendorsListFragment$observatory$9", f = "VendorsListFragment.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
public final class VendorsListFragment$observatory$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61262h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f61263i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$observatory$9(VendorsListFragment vendorsListFragment, Continuation<? super VendorsListFragment$observatory$9> continuation) {
        super(2, continuation);
        this.f61263i = vendorsListFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VendorsListFragment$observatory$9(this.f61263i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VendorsListFragment$observatory$9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61262h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<CombinedLoadStates> distinctUntilChangedBy = FlowKt.distinctUntilChangedBy(this.f61263i.getVendorsListAdapter().getLoadStateFlow(), AnonymousClass1.INSTANCE);
            final VendorsListFragment vendorsListFragment = this.f61263i;
            AnonymousClass2 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull CombinedLoadStates combinedLoadStates, @NotNull Continuation<? super Unit> continuation) {
                    vendorsListFragment.setFeatureProductsSwimlane(vendorsListFragment.getVendorsListAdapter().snapshot().getItems());
                    return Unit.INSTANCE;
                }
            };
            this.f61262h = 1;
            if (distinctUntilChangedBy.collect(r12, this) == coroutine_suspended) {
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
