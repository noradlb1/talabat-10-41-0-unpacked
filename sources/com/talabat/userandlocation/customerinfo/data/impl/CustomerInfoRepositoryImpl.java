package com.talabat.userandlocation.customerinfo.data.impl;

import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource;
import com.talabat.userandlocation.customerinfo.data.remote.CustomerInfoRemoteDataSource;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoEmptyCacheException;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/impl/CustomerInfoRepositoryImpl;", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "customerInfoLocalDataSource", "Lcom/talabat/userandlocation/customerinfo/data/local/CustomerInfoLocalDataSource;", "customerInfoRemoteDataSource", "Lcom/talabat/userandlocation/customerinfo/data/remote/CustomerInfoRemoteDataSource;", "proCentralizationStatusWrapper", "Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/userandlocation/customerinfo/data/local/CustomerInfoLocalDataSource;Lcom/talabat/userandlocation/customerinfo/data/remote/CustomerInfoRemoteDataSource;Lcom/talabat/feature/subscriptions/domain/wrapper/ProCentralizationStatusWrapper;)V", "fetchCustomerInfo", "Ldatamodels/CustomerInfo;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedCustomerInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerInfoRepositoryImpl implements CustomerInfoRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerInfoLocalDataSource customerInfoLocalDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerInfoRemoteDataSource customerInfoRemoteDataSource;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final ProCentralizationStatusWrapper proCentralizationStatusWrapper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomerInfoRepositoryImpl(@NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource2, @NotNull CustomerInfoRemoteDataSource customerInfoRemoteDataSource2, @NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper2) {
        this((CoroutineDispatcher) null, customerInfoLocalDataSource2, customerInfoRemoteDataSource2, proCentralizationStatusWrapper2, 1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(customerInfoLocalDataSource2, "customerInfoLocalDataSource");
        Intrinsics.checkNotNullParameter(customerInfoRemoteDataSource2, "customerInfoRemoteDataSource");
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper2, "proCentralizationStatusWrapper");
    }

    @JvmOverloads
    public CustomerInfoRepositoryImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource2, @NotNull CustomerInfoRemoteDataSource customerInfoRemoteDataSource2, @NotNull ProCentralizationStatusWrapper proCentralizationStatusWrapper2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(customerInfoLocalDataSource2, "customerInfoLocalDataSource");
        Intrinsics.checkNotNullParameter(customerInfoRemoteDataSource2, "customerInfoRemoteDataSource");
        Intrinsics.checkNotNullParameter(proCentralizationStatusWrapper2, "proCentralizationStatusWrapper");
        this.dispatcher = coroutineDispatcher;
        this.customerInfoLocalDataSource = customerInfoLocalDataSource2;
        this.customerInfoRemoteDataSource = customerInfoRemoteDataSource2;
        this.proCentralizationStatusWrapper = proCentralizationStatusWrapper2;
    }

    @Nullable
    public Object fetchCustomerInfo(int i11, @NotNull Continuation<? super CustomerInfo> continuation) {
        return BuildersKt.withContext(this.dispatcher, new CustomerInfoRepositoryImpl$fetchCustomerInfo$2(this, i11, (Continuation<? super CustomerInfoRepositoryImpl$fetchCustomerInfo$2>) null), continuation);
    }

    @Nullable
    public Object getCachedCustomerInfo(@NotNull Continuation<? super CustomerInfo> continuation) {
        CustomerInfo customerInfo = this.customerInfoLocalDataSource.getCustomerInfo();
        if (customerInfo != null) {
            return customerInfo;
        }
        throw new CustomerInfoEmptyCacheException();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerInfoRepositoryImpl(CoroutineDispatcher coroutineDispatcher, CustomerInfoLocalDataSource customerInfoLocalDataSource2, CustomerInfoRemoteDataSource customerInfoRemoteDataSource2, ProCentralizationStatusWrapper proCentralizationStatusWrapper2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher, customerInfoLocalDataSource2, customerInfoRemoteDataSource2, proCentralizationStatusWrapper2);
    }
}
