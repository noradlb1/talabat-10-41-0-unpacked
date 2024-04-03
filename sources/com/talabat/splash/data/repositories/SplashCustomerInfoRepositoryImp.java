package com.talabat.splash.data.repositories;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFeatureFlagsKeys;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.EventType;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.userandlocation.customerinfo.domain.repo.CustomerInfoRepository;
import datamodels.CustomerInfo;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepositoryImp;", "Lcom/talabat/splash/data/repositories/SplashCustomerInfoRepository;", "customerInfoRepository", "Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;", "dispatcherIO", "Lkotlinx/coroutines/CoroutineDispatcher;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/userandlocation/customerinfo/domain/repo/CustomerInfoRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getCustomerInfo", "Ldatamodels/CustomerInfo;", "params", "Lcom/talabat/splash/data/repositories/Params;", "(Lcom/talabat/splash/data/repositories/Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleThrowable", "", "throwable", "", "isCacheFlagEnabled", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplashCustomerInfoRepositoryImp implements SplashCustomerInfoRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final CustomerInfoRepository customerInfoRepository;
    @NotNull
    private final CoroutineDispatcher dispatcherIO;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public SplashCustomerInfoRepositoryImp(@NotNull CustomerInfoRepository customerInfoRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(customerInfoRepository2, "customerInfoRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcherIO");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.customerInfoRepository = customerInfoRepository2;
        this.dispatcherIO = coroutineDispatcher;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public final void handleThrowable(Throwable th2) {
        String name2 = EventType.UnExpectedScenario.name();
        Pair[] pairArr = new Pair[1];
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        ObservabilityManager.trackEvent(name2, "getCustomerInfoFormSplashErrors", (Map<String, String>) MapsKt__MapsKt.mutableMapOf(pairArr));
    }

    private final boolean isCacheFlagEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(KillSwitchFeatureFlagsKeys.APP_LAUNCH_DATA_CACHE, true);
    }

    @Nullable
    public Object getCustomerInfo(@NotNull Params params, @NotNull Continuation<? super CustomerInfo> continuation) {
        if (params.isLoggedIn() && params.getCachedCustomerInfo() == null) {
            Object fetchCustomerInfo = this.customerInfoRepository.fetchCustomerInfo(params.getCountryId(), continuation);
            if (fetchCustomerInfo == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return fetchCustomerInfo;
            }
            return (CustomerInfo) fetchCustomerInfo;
        } else if (!params.isLoggedIn() || params.getCachedCustomerInfo() == null) {
            return null;
        } else {
            if (isCacheFlagEnabled()) {
                CoroutinesKt.launchCatching(GlobalScope.INSTANCE, new SplashCustomerInfoRepositoryImp$getCustomerInfo$2(this), this.dispatcherIO, new SplashCustomerInfoRepositoryImp$getCustomerInfo$3(this, params, (Continuation<? super SplashCustomerInfoRepositoryImp$getCustomerInfo$3>) null));
                return params.getCachedCustomerInfo();
            }
            Object fetchCustomerInfo2 = this.customerInfoRepository.fetchCustomerInfo(params.getCountryId(), continuation);
            if (fetchCustomerInfo2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return fetchCustomerInfo2;
            }
            return (CustomerInfo) fetchCustomerInfo2;
        }
    }
}
