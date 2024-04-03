package com.talabat.core.fwf.domain.config;

import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/fwf/domain/config/IFWFManager;", "", "initialize", "", "customerEmail", "", "customerId", "googleClientId", "featuresKeys", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "observability", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "tracker", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "onFlagsFetched", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;Lkotlin/jvm/functions/Function0;)V", "com_talabat_core_fwf_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFWFManager {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void initialize$default(IFWFManager iFWFManager, String str, String str2, String str3, FWFKey[] fWFKeyArr, FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, FunWithFlagsTrackingPort funWithFlagsTrackingPort, Function0 function0, int i11, Object obj) {
            if (obj == null) {
                iFWFManager.initialize(str, str2, str3, fWFKeyArr, funWithFlagsObservabilityPort, funWithFlagsTrackingPort, (i11 & 64) != 0 ? null : function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
    }

    void initialize(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull FWFKey[] fWFKeyArr, @NotNull FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, @NotNull FunWithFlagsTrackingPort funWithFlagsTrackingPort, @Nullable Function0<Unit> function0);
}
