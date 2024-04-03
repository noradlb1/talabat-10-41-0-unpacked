package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/impl/RefreshCustomerInformationUseCaseImpl;", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "customerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;)V", "fetchCustomerAddresses", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCustomerInfo", "refreshCustomerInformation", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RefreshCustomerInformationUseCaseImpl implements RefreshCustomerInformationUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CustomerAddressesRepository customerAddressesRepository;
    @NotNull
    private final CustomerInfoRepository customerInfoRepository;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;

    public RefreshCustomerInformationUseCaseImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CustomerAddressesRepository customerAddressesRepository2, @NotNull CustomerRepository customerRepository2, @NotNull CustomerInfoRepository customerInfoRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(customerAddressesRepository2, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(customerInfoRepository2, "customerInfoRepository");
        this.dispatcher = coroutineDispatcher;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.customerInfoRepository = customerInfoRepository2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchCustomerAddresses(kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1 r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1) r0
            int r1 = r0.f12351k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12351k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1 r0 = new com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerAddresses$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f12349i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12351k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f12348h
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0054
        L_0x002d:
            r5 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.talabat.user.address.domain.repository.CustomerAddressesRepository r5 = r4.customerAddressesRepository     // Catch:{ all -> 0x005b }
            com.talabat.configuration.ConfigurationLocalRepository r2 = r4.configurationLocalRepository     // Catch:{ all -> 0x005b }
            com.talabat.configuration.country.Country r2 = r2.selectedCountry()     // Catch:{ all -> 0x005b }
            int r2 = r2.getCountryId()     // Catch:{ all -> 0x005b }
            r0.f12348h = r4     // Catch:{ all -> 0x005b }
            r0.f12351k = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r5.getCustomerAddressesFor(r2, r0)     // Catch:{ all -> 0x005b }
            if (r5 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r4
        L_0x0054:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0067
        L_0x005b:
            r5 = move-exception
            r0 = r4
        L_0x005d:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0067:
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = r0.customerRepository
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r1 == 0) goto L_0x0075
            r1 = r5
            java.util.List r1 = (java.util.List) r1
            r0.setCustomerAddresses(r1)
        L_0x0075:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r0 != 0) goto L_0x0080
            java.util.List r5 = (java.util.List) r5
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Success r5 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Success.INSTANCE
            goto L_0x0082
        L_0x0080:
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Failed r5 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Failed.INSTANCE
        L_0x0082:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl.fetchCustomerAddresses(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchCustomerInfo(kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1 r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1) r0
            int r1 = r0.f12355k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12355k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1 r0 = new com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl$fetchCustomerInfo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f12353i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12355k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f12352h
            com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0054
        L_0x002d:
            r5 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository r5 = r4.customerInfoRepository     // Catch:{ all -> 0x005b }
            com.talabat.configuration.ConfigurationLocalRepository r2 = r4.configurationLocalRepository     // Catch:{ all -> 0x005b }
            com.talabat.configuration.country.Country r2 = r2.selectedCountry()     // Catch:{ all -> 0x005b }
            int r2 = r2.getCountryId()     // Catch:{ all -> 0x005b }
            r0.f12352h = r4     // Catch:{ all -> 0x005b }
            r0.f12355k = r3     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r5.fetchCustomerInfo(r2, r0)     // Catch:{ all -> 0x005b }
            if (r5 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r4
        L_0x0054:
            datamodels.CustomerInfo r5 = (datamodels.CustomerInfo) r5     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0067
        L_0x005b:
            r5 = move-exception
            r0 = r4
        L_0x005d:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0067:
            library.talabat.mvp.login.domain.repository.CustomerRepository r0 = r0.customerRepository
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r5)
            if (r1 == 0) goto L_0x0075
            r1 = r5
            datamodels.CustomerInfo r1 = (datamodels.CustomerInfo) r1
            r0.saveCustomerInfo(r1)
        L_0x0075:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r0 != 0) goto L_0x0080
            datamodels.CustomerInfo r5 = (datamodels.CustomerInfo) r5
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Success r5 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Success.INSTANCE
            goto L_0x0082
        L_0x0080:
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Failed r5 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Failed.INSTANCE
        L_0x0082:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.domain.usecase.business.impl.RefreshCustomerInformationUseCaseImpl.fetchCustomerInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object refreshCustomerInformation(@NotNull Continuation<? super RefreshCustomerInformationUseCase.Result> continuation) {
        return BuildersKt.withContext(this.dispatcher, new RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2(this, (Continuation<? super RefreshCustomerInformationUseCaseImpl$refreshCustomerInformation$2>) null), continuation);
    }
}
