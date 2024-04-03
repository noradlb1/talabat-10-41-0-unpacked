package com.talabat.user.address.domain.repository;

import com.talabat.domain.address.Address;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/talabat/domain/address/Address;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.user.address.domain.repository.CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1", f = "CustomerAddressesRepository.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Address>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12157h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CustomerAddressesRepository f12158i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12159j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1(CustomerAddressesRepository customerAddressesRepository, int i11, Continuation<? super CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1> continuation) {
        super(2, continuation);
        this.f12158i = customerAddressesRepository;
        this.f12159j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1(this.f12158i, this.f12159j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<Address>> continuation) {
        return ((CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12157h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerAddressesRepository customerAddressesRepository = this.f12158i;
            int i12 = this.f12159j;
            this.f12157h = 1;
            obj = customerAddressesRepository.getCustomerAddressesFor(i12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
