package com.talabat.helpcenter.presentation.viewModel;

import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterWebEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterViewModel$onCloseButtonTapped$1", f = "GlobalHelpCenterViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalHelpCenterViewModel$onCloseButtonTapped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60766h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterViewModel f60767i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalHelpCenterViewModel$onCloseButtonTapped$1(GlobalHelpCenterViewModel globalHelpCenterViewModel, Continuation<? super GlobalHelpCenterViewModel$onCloseButtonTapped$1> continuation) {
        super(2, continuation);
        this.f60767i = globalHelpCenterViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlobalHelpCenterViewModel$onCloseButtonTapped$1(this.f60767i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlobalHelpCenterViewModel$onCloseButtonTapped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60766h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow access$getMGlobalHelpCenterEvent$p = this.f60767i.mGlobalHelpCenterEvent;
            GlobalHelpCenterWebEvent.HelpCenterClosed helpCenterClosed = GlobalHelpCenterWebEvent.HelpCenterClosed.INSTANCE;
            this.f60766h = 1;
            if (access$getMGlobalHelpCenterEvent$p.emit(helpCenterClosed, this) == coroutine_suspended) {
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
