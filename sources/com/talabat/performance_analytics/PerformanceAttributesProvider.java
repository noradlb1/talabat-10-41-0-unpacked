package com.talabat.performance_analytics;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAttributesProvider;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "perseusSessionId", "", "perseusClientId", "firebaseInstanceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttributes", "", "getFirebaseInstanceId", "Companion", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
    @NotNull
    private final String perseusClientId;
    @NotNull
    private final String perseusSessionId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAttributesProvider$Companion;", "", "()V", "FIREBASE_INSTANCE_ID", "", "PERSEUS_CLIENT_ID", "PERSEUS_SESSION_ID", "performance_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerformanceAttributesProvider(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "perseusSessionId");
        Intrinsics.checkNotNullParameter(str2, "perseusClientId");
        this.perseusSessionId = str;
        this.perseusClientId = str2;
        this.firebaseInstanceId = str3;
    }

    private final String getFirebaseInstanceId() {
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

    @NotNull
    public Map<String, String> getAttributes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("perseusSessionId", this.perseusSessionId);
        linkedHashMap.put("perseusClientId", this.perseusClientId);
        String str = this.firebaseInstanceId;
        if (str == null && (str = getFirebaseInstanceId()) == null) {
            str = "";
        }
        linkedHashMap.put(FIREBASE_INSTANCE_ID, str);
        return linkedHashMap;
    }
}
