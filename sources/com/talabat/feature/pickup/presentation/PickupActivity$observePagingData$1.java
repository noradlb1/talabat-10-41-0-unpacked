package com.talabat.feature.pickup.presentation;

import androidx.lifecycle.Lifecycle;
import androidx.paging.PagingData;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.pickup.presentation.PickupActivity$observePagingData$1", f = "PickupActivity.kt", i = {}, l = {238}, m = "invokeSuspend", n = {}, s = {})
public final class PickupActivity$observePagingData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58645h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58646i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Landroidx/paging/PagingData;", "Ldatamodels/Restaurant;", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.feature.pickup.presentation.PickupActivity$observePagingData$1$1", f = "PickupActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.feature.pickup.presentation.PickupActivity$observePagingData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PagingData<Restaurant>, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f58647h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f58648i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(pickupActivity, continuation);
            r02.f58648i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PagingData<Restaurant> pagingData, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pagingData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f58647h == 0) {
                ResultKt.throwOnFailure(obj);
                PickupAdapter access$getPickupAdapter$p = pickupActivity.pickupAdapter;
                Lifecycle lifecycle = pickupActivity.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
                access$getPickupAdapter$p.submitData(lifecycle, (PagingData) this.f58648i);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$observePagingData$1(PickupActivity pickupActivity, Continuation<? super PickupActivity$observePagingData$1> continuation) {
        super(2, continuation);
        this.f58646i = pickupActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PickupActivity$observePagingData$1(this.f58646i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PickupActivity$observePagingData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58645h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<Restaurant>> pickupPager = this.f58646i.getPickupViewModel().pickupPager(this.f58646i.getEventOrigin());
            final PickupActivity pickupActivity = this.f58646i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f58645h = 1;
            if (FlowKt.collectLatest(pickupPager, r12, this) == coroutine_suspended) {
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
