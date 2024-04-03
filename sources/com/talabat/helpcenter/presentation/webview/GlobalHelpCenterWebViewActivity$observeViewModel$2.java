package com.talabat.helpcenter.presentation.webview;

import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterWebEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity$observeViewModel$2", f = "GlobalHelpCenterWebViewActivity.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalHelpCenterWebViewActivity$observeViewModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60772h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterWebViewActivity f60773i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalHelpCenterWebViewActivity$observeViewModel$2(GlobalHelpCenterWebViewActivity globalHelpCenterWebViewActivity, Continuation<? super GlobalHelpCenterWebViewActivity$observeViewModel$2> continuation) {
        super(2, continuation);
        this.f60773i = globalHelpCenterWebViewActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlobalHelpCenterWebViewActivity$observeViewModel$2(this.f60773i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlobalHelpCenterWebViewActivity$observeViewModel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60772h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<GlobalHelpCenterWebEvent> globalHelpCenterEvents = this.f60773i.getViewModel().getGlobalHelpCenterEvents();
            AnonymousClass1 r12 = new AdaptedFunctionReference(this.f60773i) {
                @Nullable
                public final Object invoke(@NotNull GlobalHelpCenterWebEvent globalHelpCenterWebEvent, @NotNull Continuation<? super Unit> continuation) {
                    return ((GlobalHelpCenterWebViewActivity) this.f23889b).observeGlobalHelpCenterEvents(globalHelpCenterWebEvent);
                }
            };
            this.f60772h = 1;
            if (FlowKt.collectLatest(globalHelpCenterEvents, r12, this) == coroutine_suspended) {
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
