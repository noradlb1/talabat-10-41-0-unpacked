package com.talabat.userandlocation.customerinfo.data.remote;

import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/remote/CustomerInfoRemoteDataSource;", "", "getCustomerInfo", "Ldatamodels/CustomerInfo;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ApiReturnedNullCustomerInfoException", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerInfoRemoteDataSource {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/remote/CustomerInfoRemoteDataSource$ApiReturnedNullCustomerInfoException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ApiReturnedNullCustomerInfoException extends Exception {
    }

    @Nullable
    Object getCustomerInfo(int i11, @NotNull Continuation<? super CustomerInfo> continuation);
}
