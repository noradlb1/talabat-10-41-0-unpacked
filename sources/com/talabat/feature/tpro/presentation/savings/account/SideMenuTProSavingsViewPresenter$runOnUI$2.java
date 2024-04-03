package com.talabat.feature.tpro.presentation.savings.account;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter$runOnUI$2", f = "SideMenuTProSavingsViewPresenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTProSavingsViewPresenter$runOnUI$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59417h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f59418i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTProSavingsViewPresenter$runOnUI$2(Function0<Unit> function0, Continuation<? super SideMenuTProSavingsViewPresenter$runOnUI$2> continuation) {
        super(2, continuation);
        this.f59418i = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SideMenuTProSavingsViewPresenter$runOnUI$2(this.f59418i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTProSavingsViewPresenter$runOnUI$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59417h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f59418i.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
