package tracking.gtm.automation.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltracking/gtm/automation/utils/AutomationTestingIntegrator;", "", "()V", "isAutomationProcess", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "setAutomationProcess", "(Lkotlin/jvm/functions/Function0;)V", "isLiveAutomation", "setLiveAutomation", "trackedEvents", "Lorg/json/JSONArray;", "getTrackedEvents", "setTrackedEvents", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutomationTestingIntegrator {
    @NotNull
    public static final AutomationTestingIntegrator INSTANCE = new AutomationTestingIntegrator();
    @NotNull
    private static Function0<Boolean> isAutomationProcess = AutomationTestingIntegrator$isAutomationProcess$1.INSTANCE;
    @NotNull
    private static Function0<Boolean> isLiveAutomation = AutomationTestingIntegrator$isLiveAutomation$1.INSTANCE;
    @NotNull
    private static Function0<? extends JSONArray> trackedEvents = AutomationTestingIntegrator$trackedEvents$1.INSTANCE;

    private AutomationTestingIntegrator() {
    }

    @NotNull
    public final Function0<JSONArray> getTrackedEvents() {
        return trackedEvents;
    }

    @NotNull
    public final Function0<Boolean> isAutomationProcess() {
        return isAutomationProcess;
    }

    @NotNull
    public final Function0<Boolean> isLiveAutomation() {
        return isLiveAutomation;
    }

    public final void setAutomationProcess(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        isAutomationProcess = function0;
    }

    public final void setLiveAutomation(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        isLiveAutomation = function0;
    }

    public final void setTrackedEvents(@NotNull Function0<? extends JSONArray> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        trackedEvents = function0;
    }
}
