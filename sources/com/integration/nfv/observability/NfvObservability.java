package com.integration.nfv.observability;

import com.talabat.observability.common.ApiStatus;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH&J,\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH&¨\u0006\u0012"}, d2 = {"Lcom/integration/nfv/observability/NfvObservability;", "", "getBaseNfvAttributes", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isNfvObservabilityEnabled", "", "sendCustomObservabilityEvent", "", "eventName", "eventType", "attributes", "", "sendObservabilityEvent", "apiName", "apiStatus", "Lcom/talabat/observability/common/ApiStatus;", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NfvObservability {
    @NotNull
    HashMap<String, String> getBaseNfvAttributes();

    boolean isNfvObservabilityEnabled();

    void sendCustomObservabilityEvent(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    void sendObservabilityEvent(@NotNull String str, @NotNull ApiStatus apiStatus, @NotNull Map<String, String> map);
}
