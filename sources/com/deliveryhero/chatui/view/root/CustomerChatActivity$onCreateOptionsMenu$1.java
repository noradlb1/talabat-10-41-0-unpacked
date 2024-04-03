package com.deliveryhero.chatui.view.root;

import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.chatui.view.root.CustomerChatActivity$onCreateOptionsMenu$1", f = "CustomerChatActivity.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerChatActivity$onCreateOptionsMenu$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29700h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerChatActivity f29701i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerChatActivity$onCreateOptionsMenu$1(CustomerChatActivity customerChatActivity, Continuation<? super CustomerChatActivity$onCreateOptionsMenu$1> continuation) {
        super(2, continuation);
        this.f29701i = customerChatActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerChatActivity$onCreateOptionsMenu$1(this.f29701i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomerChatActivity$onCreateOptionsMenu$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Set<String> set;
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29700h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Bundle access$getRestoredStateBundle$p = this.f29701i.restoredStateBundle;
            if (access$getRestoredStateBundle$p != null) {
                set = access$getRestoredStateBundle$p.keySet();
            } else {
                set = null;
            }
            if (set == null || set.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                CustomerChatViewModel access$getViewModel = this.f29701i.getViewModel();
                this.f29700h = 1;
                if (access$getViewModel.reFetchChannelFeatureFlags(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Job unused = this.f29701i.observeCallStatus();
        return Unit.INSTANCE;
    }
}
