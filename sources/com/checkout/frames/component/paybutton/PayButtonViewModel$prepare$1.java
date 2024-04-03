package com.checkout.frames.component.paybutton;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.checkout.frames.component.paybutton.PayButtonViewModel$prepare$1", f = "PayButtonViewModel.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class PayButtonViewModel$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PayButtonViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayButtonViewModel$prepare$1(PayButtonViewModel payButtonViewModel, Continuation<? super PayButtonViewModel$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = payButtonViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayButtonViewModel$prepare$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PayButtonViewModel$prepare$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Boolean> isReadyForTokenization = this.this$0.paymentStateManager.isReadyForTokenization();
            final PayButtonViewModel payButtonViewModel = this.this$0;
            AnonymousClass1 r12 = new FlowCollector<Boolean>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                @Nullable
                public final Object emit(boolean z11, @NotNull Continuation<? super Unit> continuation) {
                    payButtonViewModel.getButtonState().isEnabled().setValue(Boxing.boxBoolean(z11));
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (isReadyForTokenization.collect(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
