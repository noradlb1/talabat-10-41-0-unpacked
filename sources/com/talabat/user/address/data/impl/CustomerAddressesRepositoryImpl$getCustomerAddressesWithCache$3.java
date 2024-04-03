package com.talabat.user.address.data.impl;

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
@DebugMetadata(c = "com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3", f = "CustomerAddressesRepositoryImpl.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12154h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepositoryImpl f12155i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12156j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, int i11, Continuation<? super CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3> continuation) {
        super(2, continuation);
        this.f12155i = customerAddressesRepositoryImpl;
        this.f12156j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3(this.f12155i, this.f12156j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12154h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl = this.f12155i;
            int i12 = this.f12156j;
            this.f12154h = 1;
            if (customerAddressesRepositoryImpl.fetchAndCachAddressToPrefs(i12, this) == coroutine_suspended) {
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
