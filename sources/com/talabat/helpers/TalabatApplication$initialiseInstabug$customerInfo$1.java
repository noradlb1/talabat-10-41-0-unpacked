package com.talabat.helpers;

import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ldatamodels/CustomerInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpers.TalabatApplication$initialiseInstabug$customerInfo$1", f = "TalabatApplication.kt", i = {}, l = {1106}, m = "invokeSuspend", n = {}, s = {})
public final class TalabatApplication$initialiseInstabug$customerInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CustomerInfo>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$initialiseInstabug$customerInfo$1(TalabatApplication talabatApplication, Continuation<? super TalabatApplication$initialiseInstabug$customerInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = talabatApplication;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TalabatApplication$initialiseInstabug$customerInfo$1 talabatApplication$initialiseInstabug$customerInfo$1 = new TalabatApplication$initialiseInstabug$customerInfo$1(this.this$0, continuation);
        talabatApplication$initialiseInstabug$customerInfo$1.L$0 = obj;
        return talabatApplication$initialiseInstabug$customerInfo$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super CustomerInfo> continuation) {
        return ((TalabatApplication$initialiseInstabug$customerInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TalabatApplication talabatApplication = this.this$0;
            Result.Companion companion = Result.Companion;
            CustomerInfoRepository customerInfoRepository = talabatApplication.getCustomerInfoRepository();
            this.label = 1;
            obj = customerInfoRepository.getCachedCustomerInfo(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((CustomerInfo) obj);
        if (Result.m6335isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }
}
