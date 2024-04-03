package com.talabat.user.address.data.impl;

import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.domain.address.Address;
import com.talabat.feature.address.data.convert.AddressDtoToAddressMapper;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ApiStatus;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.data.local.AddressesLocalDataSource;
import com.talabat.user.address.data.local.AddressesLocalDataSourceImp;
import com.talabat.user.address.data.local.CustomerAddressLocalDataModel;
import com.talabat.user.address.data.remote.AddressDtoMapper;
import com.talabat.user.address.data.remote.AddressRemoteDataSource;
import com.talabat.user.address.data.remote.api.AddressApi;
import com.talabat.user.address.data.remote.dto.AddAddressDto;
import com.talabat.user.address.data.remote.dto.UpdateAddressDto;
import com.talabat.user.address.domain.repository.AddAddressRepositoryException;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.user.address.domain.repository.DeleteAddressRepositoryException;
import com.talabat.user.address.domain.repository.UpdateAddressRepositoryException;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uw.a;
import uw.b;
import uw.c;
import uw.d;
import uw.e;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0016\u0010,\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eH\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/talabat/user/address/data/impl/CustomerAddressesRepositoryImpl;", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "addressApi", "Lcom/talabat/user/address/data/remote/api/AddressApi;", "fallBackAddressApi", "addressRemoteDataSource", "Lcom/talabat/user/address/data/remote/AddressRemoteDataSource;", "addressDtoMapper", "Lcom/talabat/user/address/data/remote/AddressDtoMapper;", "customer", "Lbuisnessmodels/Customer;", "addressesLocalDataSource", "Lcom/talabat/user/address/data/local/AddressesLocalDataSource;", "dispatcherIO", "Lkotlinx/coroutines/CoroutineDispatcher;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/user/address/data/remote/api/AddressApi;Lcom/talabat/user/address/data/remote/api/AddressApi;Lcom/talabat/user/address/data/remote/AddressRemoteDataSource;Lcom/talabat/user/address/data/remote/AddressDtoMapper;Lbuisnessmodels/Customer;Lcom/talabat/user/address/data/local/AddressesLocalDataSource;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "addressDtoToAddressMapper", "Lcom/talabat/feature/address/data/convert/AddressDtoToAddressMapper;", "addAddress", "Lio/reactivex/Single;", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository$Result;", "address", "Lcom/talabat/domain/address/Address;", "deleteAddress", "Lio/reactivex/Completable;", "profileId", "", "fetchAndCachAddressToPrefs", "", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCustomerAddresses", "getCustomerAddressesFor", "getCustomerAddressesFromFallback", "getCustomerAddressesWithCache", "getTrackingAttributes", "", "handleThrowable", "", "throwable", "", "refreshCacheAddresses", "addresses", "trackFallbackAddressServiceAPI", "apiStatus", "Lcom/talabat/observability/common/ApiStatus;", "trackMicroServiceAPI", "updateAddress", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerAddressesRepositoryImpl implements CustomerAddressesRepository {
    @NotNull
    @Deprecated
    public static final String API_NAME_FALLBACK_SERVICE = "address_fallback_api";
    @NotNull
    @Deprecated
    public static final String API_NAME_MICROSERVICE = "address_microservice_api";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final AddressApi addressApi;
    @NotNull
    private final AddressDtoMapper addressDtoMapper;
    @NotNull
    private final AddressDtoToAddressMapper addressDtoToAddressMapper;
    @NotNull
    private final AddressRemoteDataSource addressRemoteDataSource;
    @NotNull
    private final AddressesLocalDataSource addressesLocalDataSource;
    @NotNull
    private final Customer customer;
    @NotNull
    private final CoroutineDispatcher dispatcherIO;
    @NotNull
    private final AddressApi fallBackAddressApi;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/user/address/data/impl/CustomerAddressesRepositoryImpl$Companion;", "", "()V", "API_NAME_FALLBACK_SERVICE", "", "API_NAME_MICROSERVICE", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CustomerAddressesRepositoryImpl(@NotNull AddressApi addressApi2, @NotNull AddressApi addressApi3, @NotNull AddressRemoteDataSource addressRemoteDataSource2, @NotNull AddressDtoMapper addressDtoMapper2, @NotNull Customer customer2, @NotNull AddressesLocalDataSource addressesLocalDataSource2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(addressApi2, "addressApi");
        Intrinsics.checkNotNullParameter(addressApi3, "fallBackAddressApi");
        Intrinsics.checkNotNullParameter(addressRemoteDataSource2, "addressRemoteDataSource");
        Intrinsics.checkNotNullParameter(addressDtoMapper2, "addressDtoMapper");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        Intrinsics.checkNotNullParameter(addressesLocalDataSource2, "addressesLocalDataSource");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcherIO");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.addressApi = addressApi2;
        this.fallBackAddressApi = addressApi3;
        this.addressRemoteDataSource = addressRemoteDataSource2;
        this.addressDtoMapper = addressDtoMapper2;
        this.customer = customer2;
        this.addressesLocalDataSource = addressesLocalDataSource2;
        this.dispatcherIO = coroutineDispatcher;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.addressDtoToAddressMapper = new AddressDtoToAddressMapper();
    }

    /* access modifiers changed from: private */
    /* renamed from: addAddress$lambda-4  reason: not valid java name */
    public static final CustomerAddressesRepository.Result m5871addAddress$lambda4(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, AddAddressDto addAddressDto) {
        Integer num;
        Intrinsics.checkNotNullParameter(customerAddressesRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(addAddressDto, "it");
        if (addAddressDto.getError() == null) {
            return new CustomerAddressesRepository.Result.Success(customerAddressesRepositoryImpl.addressDtoMapper.map(addAddressDto));
        }
        Address map = customerAddressesRepositoryImpl.addressDtoMapper.map(addAddressDto);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(Integer.parseInt(addAddressDto.getError().getStatusCode())));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(num)) {
            num = -1;
        }
        return new CustomerAddressesRepository.Result.Failed(map, ((Number) num).intValue(), addAddressDto.getError().getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: addAddress$lambda-5  reason: not valid java name */
    public static final SingleSource m5872addAddress$lambda5(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.error((Throwable) new AddAddressRepositoryException(th2));
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteAddress$lambda-9  reason: not valid java name */
    public static final CompletableSource m5873deleteAddress$lambda9(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Completable.error((Throwable) new DeleteAddressRepositoryException(th2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchAndCachAddressToPrefs(int r5, kotlin.coroutines.Continuation<? super java.util.List<com.talabat.domain.address.Address>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1 r0 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1) r0
            int r1 = r0.f12143k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12143k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1 r0 = new com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchAndCachAddressToPrefs$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12141i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12143k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f12140h
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl r5 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.f12140h = r4
            r0.f12143k = r3
            java.lang.Object r6 = r4.fetchCustomerAddresses(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r5 = r4
        L_0x0044:
            java.util.List r6 = (java.util.List) r6
            com.talabat.user.address.data.local.AddressesLocalDataSource r5 = r5.addressesLocalDataSource
            com.talabat.user.address.data.local.CustomerAddressLocalDataModel r0 = new com.talabat.user.address.data.local.CustomerAddressLocalDataModel
            r0.<init>(r6)
            r5.cacheCustomerAddresses(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl.fetchAndCachAddressToPrefs(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchCustomerAddresses(int r7, kotlin.coroutines.Continuation<? super java.util.List<com.talabat.domain.address.Address>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1 r0 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1) r0
            int r1 = r0.f12149m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12149m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1 r0 = new com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$fetchCustomerAddresses$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f12147k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12149m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r7 = r0.f12145i
            java.lang.Object r0 = r0.f12144h
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl r0 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00d5
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            int r7 = r0.f12146j
            java.lang.Object r2 = r0.f12144h
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl r2 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x0061
        L_0x0045:
            r8 = move-exception
            goto L_0x006a
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            com.talabat.observability.common.ApiStatus r8 = com.talabat.observability.common.ApiStatus.LOADING     // Catch:{ all -> 0x0068 }
            r6.trackMicroServiceAPI(r8)     // Catch:{ all -> 0x0068 }
            com.talabat.user.address.data.remote.api.AddressApi r8 = r6.addressApi     // Catch:{ all -> 0x0068 }
            r0.f12144h = r6     // Catch:{ all -> 0x0068 }
            r0.f12146j = r7     // Catch:{ all -> 0x0068 }
            r0.f12149m = r4     // Catch:{ all -> 0x0068 }
            java.lang.Object r8 = r8.getCustomerAddressesFor(r7, r0)     // Catch:{ all -> 0x0068 }
            if (r8 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r2 = r6
        L_0x0061:
            com.talabat.user.address.data.remote.api.CustomerAddressesResponse r8 = (com.talabat.user.address.data.remote.api.CustomerAddressesResponse) r8     // Catch:{ all -> 0x0045 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x0074
        L_0x0068:
            r8 = move-exception
            r2 = r6
        L_0x006a:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x0074:
            r5 = r8
            r8 = r7
            r7 = r5
            boolean r4 = kotlin.Result.m6336isSuccessimpl(r7)
            if (r4 == 0) goto L_0x00c7
            com.talabat.observability.common.ApiStatus r8 = com.talabat.observability.common.ApiStatus.SUCCESS
            r2.trackMicroServiceAPI(r8)
            boolean r8 = kotlin.Result.m6335isFailureimpl(r7)
            if (r8 == 0) goto L_0x0089
            r7 = 0
        L_0x0089:
            com.talabat.user.address.data.remote.api.CustomerAddressesResponse r7 = (com.talabat.user.address.data.remote.api.CustomerAddressesResponse) r7
            if (r7 == 0) goto L_0x00c2
            java.util.List r7 = r7.getResult()
            if (r7 == 0) goto L_0x00c2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r7)
            if (r7 == 0) goto L_0x00c2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            com.talabat.feature.address.data.convert.AddressDtoToAddressMapper r8 = r2.addressDtoToAddressMapper
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L_0x00ae:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00eb
            java.lang.Object r1 = r7.next()
            com.talabat.feature.address.data.AddressDto r1 = (com.talabat.feature.address.data.AddressDto) r1
            com.talabat.domain.address.Address r1 = r8.apply((com.talabat.feature.address.data.AddressDto) r1)
            r0.add(r1)
            goto L_0x00ae
        L_0x00c2:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x00eb
        L_0x00c7:
            r0.f12144h = r2
            r0.f12145i = r7
            r0.f12149m = r3
            java.lang.Object r8 = r2.getCustomerAddressesFromFallback(r8, r0)
            if (r8 != r1) goto L_0x00d4
            return r1
        L_0x00d4:
            r0 = r2
        L_0x00d5:
            java.util.List r8 = (java.util.List) r8
            com.talabat.observability.common.ApiStatus r1 = com.talabat.observability.common.ApiStatus.FAILURE
            r0.trackMicroServiceAPI(r1)
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.String r1 = "Couldn't retrieve customer addresses"
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r7)
            r0.<init>(r1, r7)
            com.talabat.talabatcore.logger.LogManager.logException(r0)
            r0 = r8
        L_0x00eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl.fetchCustomerAddresses(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCustomerAddressesFromFallback(int r5, kotlin.coroutines.Continuation<? super java.util.List<com.talabat.domain.address.Address>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1 r0 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1) r0
            int r1 = r0.f12153k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12153k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1 r0 = new com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl$getCustomerAddressesFromFallback$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12151i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12153k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f12150h
            com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl r5 = (com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r6 = move-exception
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0056 }
            com.talabat.observability.common.ApiStatus r6 = com.talabat.observability.common.ApiStatus.LOADING     // Catch:{ all -> 0x0056 }
            r4.trackFallbackAddressServiceAPI(r6)     // Catch:{ all -> 0x0056 }
            com.talabat.user.address.data.remote.api.AddressApi r6 = r4.fallBackAddressApi     // Catch:{ all -> 0x0056 }
            r0.f12150h = r4     // Catch:{ all -> 0x0056 }
            r0.f12153k = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r6 = r6.getCustomerAddressesFor(r5, r0)     // Catch:{ all -> 0x0056 }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r5 = r4
        L_0x004f:
            com.talabat.user.address.data.remote.api.CustomerAddressesResponse r6 = (com.talabat.user.address.data.remote.api.CustomerAddressesResponse) r6     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0062
        L_0x0056:
            r6 = move-exception
            r5 = r4
        L_0x0058:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0062:
            boolean r0 = kotlin.Result.m6336isSuccessimpl(r6)
            if (r0 == 0) goto L_0x00b2
            com.talabat.observability.common.ApiStatus r0 = com.talabat.observability.common.ApiStatus.SUCCESS
            r5.trackFallbackAddressServiceAPI(r0)
            boolean r0 = kotlin.Result.m6335isFailureimpl(r6)
            if (r0 == 0) goto L_0x0074
            r6 = 0
        L_0x0074:
            com.talabat.user.address.data.remote.api.CustomerAddressesResponse r6 = (com.talabat.user.address.data.remote.api.CustomerAddressesResponse) r6
            if (r6 == 0) goto L_0x00ad
            java.util.List r6 = r6.getResult()
            if (r6 == 0) goto L_0x00ad
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r6)
            if (r6 == 0) goto L_0x00ad
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            com.talabat.feature.address.data.convert.AddressDtoToAddressMapper r5 = r5.addressDtoToAddressMapper
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0099:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00c9
            java.lang.Object r1 = r6.next()
            com.talabat.feature.address.data.AddressDto r1 = (com.talabat.feature.address.data.AddressDto) r1
            com.talabat.domain.address.Address r1 = r5.apply((com.talabat.feature.address.data.AddressDto) r1)
            r0.add(r1)
            goto L_0x0099
        L_0x00ad:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x00c9
        L_0x00b2:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            com.talabat.observability.common.ApiStatus r1 = com.talabat.observability.common.ApiStatus.FAILURE
            r5.trackFallbackAddressServiceAPI(r1)
            java.lang.Exception r5 = new java.lang.Exception
            java.lang.String r1 = "FALLBACK API: Couldn't retrieve customer addresses"
            java.lang.Throwable r6 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            r5.<init>(r1, r6)
            com.talabat.talabatcore.logger.LogManager.logException(r5)
        L_0x00c9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.user.address.data.impl.CustomerAddressesRepositoryImpl.getCustomerAddressesFromFallback(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map<String, String> getTrackingAttributes() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("isLoggedIn", String.valueOf(this.customer.isLoggedIn())), TuplesKt.to("tokenIsNull", String.valueOf(this.customer.isLoggedIn())));
    }

    /* access modifiers changed from: private */
    public final void handleThrowable(Throwable th2) {
        Pair[] pairArr = new Pair[1];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        ObservabilityManager.trackUnExpectedScenario("getAddressesFormSplashErrorsInCashingFlow", MapsKt__MapsKt.mutableMapOf(pairArr));
        LogManager.error$default(th2, (String) null, 2, (Object) null);
    }

    private final void trackFallbackAddressServiceAPI(ApiStatus apiStatus) {
        ObservabilityManager.trackEvent("address_fallback_api", apiStatus, getTrackingAttributes());
    }

    private final void trackMicroServiceAPI(ApiStatus apiStatus) {
        ObservabilityManager.trackEvent("address_microservice_api", apiStatus, getTrackingAttributes());
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-7  reason: not valid java name */
    public static final CustomerAddressesRepository.Result m5874updateAddress$lambda7(CustomerAddressesRepositoryImpl customerAddressesRepositoryImpl, UpdateAddressDto updateAddressDto) {
        Integer num;
        Intrinsics.checkNotNullParameter(customerAddressesRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(updateAddressDto, "it");
        if (updateAddressDto.getError() == null) {
            return new CustomerAddressesRepository.Result.Success(customerAddressesRepositoryImpl.addressDtoMapper.map(updateAddressDto));
        }
        Address map = customerAddressesRepositoryImpl.addressDtoMapper.map(updateAddressDto);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(Integer.parseInt(updateAddressDto.getError().getStatusCode())));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(num)) {
            num = -1;
        }
        return new CustomerAddressesRepository.Result.Failed(map, ((Number) num).intValue(), updateAddressDto.getError().getMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAddress$lambda-8  reason: not valid java name */
    public static final SingleSource m5875updateAddress$lambda8(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.error((Throwable) new UpdateAddressRepositoryException(th2));
    }

    @NotNull
    public Single<CustomerAddressesRepository.Result> addAddress(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Single<R> onErrorResumeNext = this.addressRemoteDataSource.addAddress(this.addressDtoMapper.mapToAddressPayload(address)).map(new c(this)).onErrorResumeNext(new d());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressRemoteDataSource.…epositoryException(it)) }");
        return onErrorResumeNext;
    }

    @NotNull
    public Completable deleteAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "profileId");
        Completable onErrorResumeNext = this.addressRemoteDataSource.deleteAddress(str).onErrorResumeNext(new e());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressRemoteDataSource\n…epositoryException(it)) }");
        return onErrorResumeNext;
    }

    @Nullable
    public Object getCustomerAddressesFor(int i11, @NotNull Continuation<? super List<Address>> continuation) {
        this.addressesLocalDataSource.invalidateCustomerAddresses();
        return fetchCustomerAddresses(i11, continuation);
    }

    @Nullable
    public Object getCustomerAddressesWithCache(int i11, @NotNull Continuation<? super List<Address>> continuation) {
        boolean z11;
        CustomerAddressLocalDataModel customerAddresses = this.addressesLocalDataSource.getCustomerAddresses();
        boolean featureFlag = this.talabatFeatureFlag.getFeatureFlag(KillSwitchFeatureFlagsKeys.APP_LAUNCH_DATA_CACHE, true);
        boolean z12 = false;
        if (customerAddresses != null) {
            Collection result = customerAddresses.getResult();
            if (result == null || result.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && featureFlag) {
                z12 = true;
            }
        }
        if (!z12) {
            return fetchAndCachAddressToPrefs(i11, continuation);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatcherIO.plus(new CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this))), (CoroutineContext) null, (CoroutineStart) null, new CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3(this, i11, (Continuation<? super CustomerAddressesRepositoryImpl$getCustomerAddressesWithCache$3>) null), 3, (Object) null);
        return customerAddresses.getResult();
    }

    public void refreshCacheAddresses(@NotNull List<Address> list) {
        Intrinsics.checkNotNullParameter(list, "addresses");
        this.addressesLocalDataSource.cacheCustomerAddresses(new CustomerAddressLocalDataModel(list));
    }

    @NotNull
    public Single<CustomerAddressesRepository.Result> updateAddress(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Single<R> onErrorResumeNext = this.addressRemoteDataSource.updateAddress(address.f58343id, this.addressDtoMapper.mapToAddressPayload(address)).map(new a(this)).onErrorResumeNext(new b());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "addressRemoteDataSource.…epositoryException(it)) }");
        return onErrorResumeNext;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerAddressesRepositoryImpl(AddressApi addressApi2, AddressApi addressApi3, AddressRemoteDataSource addressRemoteDataSource2, AddressDtoMapper addressDtoMapper2, Customer customer2, AddressesLocalDataSource addressesLocalDataSource2, CoroutineDispatcher coroutineDispatcher, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(addressApi2, addressApi3, addressRemoteDataSource2, addressDtoMapper2, customer2, (i11 & 32) != 0 ? new AddressesLocalDataSourceImp((SharedPreferences) null, (Gson) null, 3, (DefaultConstructorMarker) null) : addressesLocalDataSource2, (i11 & 64) != 0 ? Dispatchers.getIO() : coroutineDispatcher, iTalabatFeatureFlag);
    }
}
