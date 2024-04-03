package com.talabat.userandlocation.customerinfo.domain.repo;

import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "", "fetchCustomerInfo", "Ldatamodels/CustomerInfo;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedCustomerInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerInfoRepository {
    @Nullable
    Object fetchCustomerInfo(int i11, @NotNull Continuation<? super CustomerInfo> continuation);

    @Nullable
    Object getCachedCustomerInfo(@NotNull Continuation<? super CustomerInfo> continuation);
}
