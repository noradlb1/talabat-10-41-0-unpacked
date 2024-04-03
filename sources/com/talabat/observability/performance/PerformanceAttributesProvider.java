package com.talabat.observability.performance;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.talabat.observability.ObservabilityManagerIntegrator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/observability/performance/PerformanceAttributesProvider;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "()V", "firebaseInstanceId", "", "getAttributes", "", "getFirebaseInstanceId", "Companion", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerformanceAttributesProvider implements PerformanceTrackingAttributesProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FIREBASE_INSTANCE_ID = "firebaseInstanceId";
    @NotNull
    private static final String PERSEUS_CLIENT_ID = "perseusClientId";
    @NotNull
    private static final String PERSEUS_SESSION_ID = "perseusSessionId";
    @Nullable
    private String firebaseInstanceId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/observability/performance/PerformanceAttributesProvider$Companion;", "", "()V", "FIREBASE_INSTANCE_ID", "", "PERSEUS_CLIENT_ID", "PERSEUS_SESSION_ID", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public Map<String, String> getAttributes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ObservabilityManagerIntegrator observabilityManagerIntegrator = ObservabilityManagerIntegrator.INSTANCE;
        String invoke = observabilityManagerIntegrator.getPerseusSessionId().invoke();
        String str = "";
        if (invoke == null) {
            invoke = str;
        }
        linkedHashMap.put("perseusSessionId", invoke);
        String invoke2 = observabilityManagerIntegrator.getPerseusClientId().invoke();
        if (invoke2 == null) {
            invoke2 = str;
        }
        linkedHashMap.put("perseusClientId", invoke2);
        String firebaseInstanceId2 = getFirebaseInstanceId();
        if (firebaseInstanceId2 != null) {
            str = firebaseInstanceId2;
        }
        linkedHashMap.put(FIREBASE_INSTANCE_ID, str);
        return linkedHashMap;
    }

    @Nullable
    public final String getFirebaseInstanceId() {
        String str;
        if (this.firebaseInstanceId == null) {
            Task<String> id2 = FirebaseInstallations.getInstance().getId();
            Intrinsics.checkNotNullExpressionValue(id2, "getInstance().id");
            if (id2.isSuccessful()) {
                str = id2.getResult();
            } else {
                str = null;
            }
            this.firebaseInstanceId = str;
        }
        return this.firebaseInstanceId;
    }
}
