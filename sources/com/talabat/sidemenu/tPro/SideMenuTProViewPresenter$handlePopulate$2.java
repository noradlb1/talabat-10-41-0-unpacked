package com.talabat.sidemenu.tPro;

import kotlin.Metadata;
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
@DebugMetadata(c = "com.talabat.sidemenu.tPro.SideMenuTProViewPresenter$handlePopulate$2", f = "SideMenuTProViewPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTProViewPresenter$handlePopulate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61398h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTProViewPresenter f61399i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProViewPresenter$handlePopulate$2(SideMenuTProViewPresenter sideMenuTProViewPresenter, Continuation<? super SideMenuTProViewPresenter$handlePopulate$2> continuation) {
        super(2, continuation);
        this.f61399i = sideMenuTProViewPresenter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SideMenuTProViewPresenter$handlePopulate$2(this.f61399i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTProViewPresenter$handlePopulate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61398h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f61399i.populate();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
