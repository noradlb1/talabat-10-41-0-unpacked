package com.talabat.splash.data.repositories;

import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepository;", "", "getCustomerInfo", "Ldatamodels/CustomerInfo;", "params", "Lcom/talabat/splash/data/repositories/Params;", "(Lcom/talabat/splash/data/repositories/Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SplashCustomerInfoRepository {
    @Nullable
    Object getCustomerInfo(@NotNull Params params, @NotNull Continuation<? super CustomerInfo> continuation);
}
