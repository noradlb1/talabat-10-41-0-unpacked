package com.talabat.feature.subscriptions.data.usecase;

import buisnessmodels.Cart;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$invoke$1", f = "GetTProOrderStatusUseCaseImpl.kt", i = {}, l = {77, 84}, m = "invokeSuspend", n = {}, s = {})
public final class GetTProOrderStatusUseCaseImpl$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f58964h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetTProOrderStatusUseCaseImpl f58965i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Restaurant f58966j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<TProOrderStatus, Unit> f58967k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Cart f58968l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f58969m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f58970n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f58971o;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$invoke$1$1", f = "GetTProOrderStatusUseCaseImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl$invoke$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f58972h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(f11, function1, getTProOrderStatusUseCaseImpl2, restaurant2, cart, z11, z12, z13, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z11;
            boolean z12;
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f58972h == 0) {
                ResultKt.throwOnFailure(obj);
                Float f11 = f11;
                if (f11 == null || Intrinsics.areEqual(f11, 0.0f)) {
                    function1.invoke(new TProOrderStatus(false, 0.0d, false, false, 15, (DefaultConstructorMarker) null));
                } else {
                    GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl = getTProOrderStatusUseCaseImpl2;
                    Restaurant restaurant = restaurant2;
                    Intrinsics.checkNotNullExpressionValue(restaurant, "restaurant");
                    Cart cart = cart;
                    Intrinsics.checkNotNullExpressionValue(cart, "cart");
                    boolean access$checkDeliveryValue = getTProOrderStatusUseCaseImpl.checkDeliveryValue(restaurant, cart);
                    GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl2 = getTProOrderStatusUseCaseImpl2;
                    float floatValue = f11.floatValue();
                    Cart cart2 = cart;
                    Intrinsics.checkNotNullExpressionValue(cart2, "cart");
                    float access$calculateMOVdifference = getTProOrderStatusUseCaseImpl2.calculateMOVdifference(floatValue, cart2);
                    boolean z13 = true;
                    if (access$calculateMOVdifference <= 0.0f) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z14 = z11;
                    double d11 = (double) access$calculateMOVdifference;
                    if (!access$checkDeliveryValue || !z11) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    TProOrderStatus tProOrderStatus = new TProOrderStatus(z14, d11, z12, z12);
                    if (z13) {
                        Cart cart3 = cart;
                        if (!tProOrderStatus.isFreeDelivery() || !tProOrderStatus.isFreeDeliveryEligibleVendor()) {
                            z13 = false;
                        }
                        cart3.setFreeDelivery(z13);
                    }
                    getTProOrderStatusUseCaseImpl2.observeDataOnSuccess(tProOrderStatus, z13, f11.floatValue());
                    function1.invoke(tProOrderStatus);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetTProOrderStatusUseCaseImpl$invoke$1(GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl, Restaurant restaurant, Function1<? super TProOrderStatus, Unit> function1, Cart cart, boolean z11, boolean z12, boolean z13, Continuation<? super GetTProOrderStatusUseCaseImpl$invoke$1> continuation) {
        super(2, continuation);
        this.f58965i = getTProOrderStatusUseCaseImpl;
        this.f58966j = restaurant;
        this.f58967k = function1;
        this.f58968l = cart;
        this.f58969m = z11;
        this.f58970n = z12;
        this.f58971o = z13;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GetTProOrderStatusUseCaseImpl$invoke$1(this.f58965i, this.f58966j, this.f58967k, this.f58968l, this.f58969m, this.f58970n, this.f58971o, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GetTProOrderStatusUseCaseImpl$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f58964h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl = this.f58965i;
            Restaurant restaurant = this.f58966j;
            Intrinsics.checkNotNullExpressionValue(restaurant, "restaurant");
            this.f58964h = 1;
            obj = getTProOrderStatusUseCaseImpl.getMovForVendor(restaurant, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final Float f11 = (Float) obj;
        ISubscriptionsTracker access$getSubscriptionsTracker$p = this.f58965i.subscriptionsTracker;
        if (f11 != null) {
            str = f11.toString();
        } else {
            str = null;
        }
        ISubscriptionsTracker.DefaultImpls.tProOrderStatus$default(access$getSubscriptionsTracker$p, "GetTProOrderStatusUseCase -> mov fetched", str, (Boolean) null, 4, (Object) null);
        CoroutineDispatcher main = this.f58965i.coroutineDispatchersFactory.main();
        final Function1<TProOrderStatus, Unit> function1 = this.f58967k;
        final GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl2 = this.f58965i;
        final Restaurant restaurant2 = this.f58966j;
        final Cart cart = this.f58968l;
        final boolean z11 = this.f58969m;
        final boolean z12 = this.f58970n;
        final boolean z13 = this.f58971o;
        AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.f58964h = 2;
        if (BuildersKt.withContext(main, r32, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
