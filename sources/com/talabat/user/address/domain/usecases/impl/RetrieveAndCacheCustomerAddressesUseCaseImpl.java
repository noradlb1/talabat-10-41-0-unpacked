package com.talabat.user.address.domain.usecases.impl;

import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/user/address/domain/usecases/impl/RetrieveAndCacheCustomerAddressesUseCaseImpl;", "Lcom/talabat/user/address/domain/usecases/RetrieveAndCacheCustomerAddressesUseCase;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "(Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;)V", "retrieveAndCacheCustomerAddresses", "", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetrieveAndCacheCustomerAddressesUseCaseImpl implements RetrieveAndCacheCustomerAddressesUseCase {
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    @NotNull
    private final CustomerRepository customerRepository;

    public RetrieveAndCacheCustomerAddressesUseCaseImpl(@NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object retrieveAndCacheCustomerAddresses(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1 r0 = (com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1) r0
            int r1 = r0.f12163k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12163k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1 r0 = new com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl$retrieveAndCacheCustomerAddresses$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12161i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12163k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f12160h
            com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl r5 = (com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r6 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0051 }
            com.talabat.user.address.domain.repository.CustomerAddressesRepository r6 = r4.customerAddressesRepository     // Catch:{ all -> 0x0051 }
            r0.f12160h = r4     // Catch:{ all -> 0x0051 }
            r0.f12163k = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r6 = r6.getCustomerAddressesWithCache(r5, r0)     // Catch:{ all -> 0x0051 }
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r5 = r4
        L_0x004a:
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x005d
        L_0x0051:
            r6 = move-exception
            r5 = r4
        L_0x0053:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x005d:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r6)
            if (r0 == 0) goto L_0x006b
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            library.talabat.mvp.login.domain.repository.CustomerRepository r5 = r5.customerRepository
            r5.setCustomerAddresses(r0)
        L_0x006b:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r5 == 0) goto L_0x007b
            java.lang.Exception r6 = new java.lang.Exception
            java.lang.String r0 = "Retrieve and cache customer addresses failed"
            r6.<init>(r0, r5)
            com.talabat.talabatcore.logger.LogManager.logException(r6)
        L_0x007b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.user.address.domain.usecases.impl.RetrieveAndCacheCustomerAddressesUseCaseImpl.retrieveAndCacheCustomerAddresses(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
