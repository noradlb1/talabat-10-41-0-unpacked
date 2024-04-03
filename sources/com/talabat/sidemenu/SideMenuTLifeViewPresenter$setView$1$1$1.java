package com.talabat.sidemenu;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.sidemenu.SideMenuTLifeViewPresenter$setView$1$1$1", f = "SideMenuTLifeViewPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTLifeViewPresenter$setView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61385h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTLifeViewPresenter f61386i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f61387j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SideMenuTLifeViewHolder f61388k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTLifeViewPresenter$setView$1$1$1(SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter, boolean z11, SideMenuTLifeViewHolder sideMenuTLifeViewHolder, Continuation<? super SideMenuTLifeViewPresenter$setView$1$1$1> continuation) {
        super(2, continuation);
        this.f61386i = sideMenuTLifeViewPresenter;
        this.f61387j = z11;
        this.f61388k = sideMenuTLifeViewHolder;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SideMenuTLifeViewPresenter$setView$1$1$1(this.f61386i, this.f61387j, this.f61388k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTLifeViewPresenter$setView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61385h == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean access$isFreeCoffeeEligible = this.f61386i.isFreeCoffeeEligible();
            Intrinsics.checkNotNullExpressionValue(access$isFreeCoffeeEligible, "isFreeCoffeeEligible()");
            if (access$isFreeCoffeeEligible.booleanValue()) {
                this.f61386i.enableTLifeWidget(this.f61387j);
                this.f61388k.setFreeCoffee();
            } else {
                this.f61386i.enableTLifeWidget(false);
                this.f61386i.hideView();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
