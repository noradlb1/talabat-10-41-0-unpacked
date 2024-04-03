package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$3"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsViewModel$isReadyToSaveAddress$$inlined$combine$1 implements Flow<Boolean> {
    final /* synthetic */ Flow[] $flowArray$inlined;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@¨\u0006\u0006"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel$isReadyToSaveAddress$$inlined$combine$1$3", f = "BillingAddressDetailsViewModel.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel$isReadyToSaveAddress$$inlined$combine$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Boolean[], Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Boolean[] boolArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass3 r02 = new AnonymousClass3(continuation);
            r02.L$0 = flowCollector;
            r02.L$1 = boolArr;
            return r02.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Boolean[] boolArr = (Boolean[]) ((Object[]) this.L$1);
                int length = boolArr.length;
                boolean z11 = false;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        z11 = true;
                        break;
                    } else if (!boolArr[i12].booleanValue()) {
                        break;
                    } else {
                        i12++;
                    }
                }
                Boolean boxBoolean = Boxing.boxBoolean(z11);
                this.label = 1;
                if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
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

    public BillingAddressDetailsViewModel$isReadyToSaveAddress$$inlined$combine$1(Flow[] flowArr) {
        this.$flowArray$inlined = flowArr;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        final Flow[] flowArr = this.$flowArray$inlined;
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, new Function0<Boolean[]>() {
            @Nullable
            public final Boolean[] invoke() {
                return new Boolean[flowArr.length];
            }
        }, new AnonymousClass3((Continuation) null), continuation);
        if (combineInternal == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }
}
