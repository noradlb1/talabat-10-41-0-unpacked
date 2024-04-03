package com.talabat.domain.address;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"getCustomerAddressesSingle", "Lio/reactivex/Single;", "", "Lcom/talabat/domain/address/Address;", "Lcom/talabat/domain/address/CustomerAddressesRepository;", "countryId", "", "com_talabat_domain_address_address"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CustomerAddressesRepositoryKt {
    @NotNull
    public static final Single<List<Address>> getCustomerAddressesSingle(@NotNull CustomerAddressesRepository customerAddressesRepository, int i11) {
        Intrinsics.checkNotNullParameter(customerAddressesRepository, "<this>");
        return RxSingleKt.rxSingle$default((CoroutineContext) null, new CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1(customerAddressesRepository, i11, (Continuation<? super CustomerAddressesRepositoryKt$getCustomerAddressesSingle$1>) null), 1, (Object) null);
    }
}
