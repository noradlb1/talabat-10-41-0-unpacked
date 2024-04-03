package com.talabat.core.tracking.data.common;

import com.talabat.core.tracking.domain.TestingUtils;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.lib.Integration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.GaEventsTrackingKt;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;
import tracking.gtm.datalayerLogger.DatalayerModel;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0016J.\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/tracking/data/common/DefaultTestingUtils;", "Lcom/talabat/core/tracking/domain/TestingUtils;", "()V", "isAutomationProcess", "", "()Z", "isLiveAutomation", "isLoggingEnabled", "loggingKey", "", "setLogEventForAutomation", "", "eventName", "attributes", "", "", "updateEventsTracker", "eventLog", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultTestingUtils implements TestingUtils {
    private final boolean isAutomationProcess;
    private final boolean isLiveAutomation;

    public DefaultTestingUtils() {
        AutomationTestingIntegrator automationTestingIntegrator = AutomationTestingIntegrator.INSTANCE;
        this.isLiveAutomation = automationTestingIntegrator.isLiveAutomation().invoke().booleanValue();
        this.isAutomationProcess = automationTestingIntegrator.isAutomationProcess().invoke().booleanValue();
    }

    public boolean isAutomationProcess() {
        return this.isAutomationProcess;
    }

    public boolean isLiveAutomation() {
        return this.isLiveAutomation;
    }

    public boolean isLoggingEnabled() {
        return DatalayerModel.INSTANCE.isLoggingEnabled();
    }

    @NotNull
    public String loggingKey() {
        return DatalayerModel.INSTANCE.getLoggingKey();
    }

    public void setLogEventForAutomation(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new DefaultTestingUtils$setLogEventForAutomation$1(str, map, (Continuation<? super DefaultTestingUtils$setLogEventForAutomation$1>) null), 3, (Object) null);
    }

    public void updateEventsTracker(@NotNull String str, @NotNull Map<String, ? extends Object> map, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        Intrinsics.checkNotNullParameter(str2, "eventLog");
        if (Integration.getGaEventsTracker() != null) {
            GaEventsTrackingKt.updateGaEventsTracker$default(str, (Map) map, str2, (List) null, 8, (Object) null);
        }
    }
}
