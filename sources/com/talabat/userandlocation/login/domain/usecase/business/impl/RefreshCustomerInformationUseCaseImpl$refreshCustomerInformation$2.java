package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCaseKt;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2", f = "RefreshCustomerInformationUseCaseImpl.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RefreshCustomerInformationUseCase.Result>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12356h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RefreshCustomerInformationUseCaseImpl f12357i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2(RefreshCustomerInformationUseCaseImpl refreshCustomerInformationUseCaseImpl, Continuation<? super RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2> continuation) {
        super(2, continuation);
        this.f12357i = refreshCustomerInformationUseCaseImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2 refreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2 = new RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2(this.f12357i, continuation);
        refreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2.L$0 = obj;
        return refreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super RefreshCustomerInformationUseCase.Result> continuation) {
        return ((RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12356h;
        boolean z11 = false;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.f12356h = 1;
            obj = AwaitKt.awaitAll((Deferred<? extends T>[]) new Deferred[]{BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1(this.f12357i, (Continuation<? super RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerInfoAsync$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerAddressesAsync$1(this.f12357i, (Continuation<? super RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2$fetchCustomerAddressesAsync$1>) null), 3, (Object) null)}, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable iterable = (Iterable) obj;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!RefreshCustomerInformationUseCaseKt.isSuccess((RefreshCustomerInformationUseCase.Result) it.next())) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return RefreshCustomerInformationUseCase.Result.Success.INSTANCE;
        }
        return RefreshCustomerInformationUseCase.Result.Failed.INSTANCE;
    }
}
