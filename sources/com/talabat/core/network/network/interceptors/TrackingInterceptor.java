package com.talabat.core.network.network.interceptors;

import com.facebook.internal.security.CertificateUtil;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.fwf.domain.events.BackendExperimentEvent;
import com.talabat.core.fwf.domain.events.BackendExperimentObservabilityEvent;
import com.talabat.core.tracking.domain.PlatformName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/network/network/interceptors/TrackingInterceptor;", "Lokhttp3/Interceptor;", "observabilityManager", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "trackingManager", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "(Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isValidHeaderValue", "", "keyValue", "", "", "Companion", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackingInterceptor implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TRACKING_HEADER = "x-ab-test-participated";
    @NotNull
    private final FunWithFlagsObservabilityPort observabilityManager;
    @NotNull
    private final FunWithFlagsTrackingPort trackingManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/network/network/interceptors/TrackingInterceptor$Companion;", "", "()V", "TRACKING_HEADER", "", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TrackingInterceptor(@NotNull FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, @NotNull FunWithFlagsTrackingPort funWithFlagsTrackingPort) {
        Intrinsics.checkNotNullParameter(funWithFlagsObservabilityPort, "observabilityManager");
        Intrinsics.checkNotNullParameter(funWithFlagsTrackingPort, "trackingManager");
        this.observabilityManager = funWithFlagsObservabilityPort;
        this.trackingManager = funWithFlagsTrackingPort;
    }

    private final boolean isValidHeaderValue(List<String> list) {
        return list.size() > 1 && (StringsKt__StringsJVMKt.isBlank(list.get(0)) ^ true) && (StringsKt__StringsJVMKt.isBlank(list.get(1)) ^ true);
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        String str = proceed.headers().get(TRACKING_HEADER);
        if (str != null) {
            for (String trim : StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.trim((CharSequence) trim).toString(), new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null);
                if (isValidHeaderValue(split$default)) {
                    this.observabilityManager.trackFWFExpEvents(new BackendExperimentObservabilityEvent((String) split$default.get(0), (String) split$default.get(1)).attributes());
                    BackendExperimentEvent backendExperimentEvent = new BackendExperimentEvent((String) split$default.get(0), (String) split$default.get(1));
                    Map<String, Object> attributes = backendExperimentEvent.attributes(PlatformName.GOOGLE_ANALYTICS);
                    ArrayList arrayList = new ArrayList(attributes.size());
                    for (Map.Entry next : attributes.entrySet()) {
                        arrayList.add(TuplesKt.to(next.getKey(), String.valueOf(next.getValue())));
                    }
                    this.trackingManager.track(backendExperimentEvent.name(PlatformName.GOOGLE_ANALYTICS), MapsKt__MapsKt.toMap(arrayList));
                }
            }
        }
        return proceed;
    }
}
