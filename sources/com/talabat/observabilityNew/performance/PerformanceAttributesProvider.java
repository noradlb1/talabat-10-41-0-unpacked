package com.talabat.observabilityNew.performance;

import com.deliveryhero.performance.core.analytics.PerformanceTrackingAttributesProvider;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/observabilityNew/performance/PerformanceAttributesProvider;", "Lcom/deliveryhero/performance/core/analytics/PerformanceTrackingAttributesProvider;", "()V", "firebaseInstanceId", "", "talabatPerseusRepository", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "getTalabatPerseusRepository", "()Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "setTalabatPerseusRepository", "(Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;)V", "getAttributes", "", "getFirebaseInstanceId", "Companion", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    @Inject
    public TalabatPerseusRepository talabatPerseusRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/observabilityNew/performance/PerformanceAttributesProvider$Companion;", "", "()V", "FIREBASE_INSTANCE_ID", "", "PERSEUS_CLIENT_ID", "PERSEUS_SESSION_ID", "com_talabat_core_observability_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        linkedHashMap.put("perseusSessionId", getTalabatPerseusRepository().getMySessionId());
        linkedHashMap.put("perseusClientId", getTalabatPerseusRepository().getMyClientId());
        String firebaseInstanceId2 = getFirebaseInstanceId();
        if (firebaseInstanceId2 == null) {
            firebaseInstanceId2 = "";
        }
        linkedHashMap.put(FIREBASE_INSTANCE_ID, firebaseInstanceId2);
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

    @NotNull
    public final TalabatPerseusRepository getTalabatPerseusRepository() {
        TalabatPerseusRepository talabatPerseusRepository2 = this.talabatPerseusRepository;
        if (talabatPerseusRepository2 != null) {
            return talabatPerseusRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatPerseusRepository");
        return null;
    }

    public final void setTalabatPerseusRepository(@NotNull TalabatPerseusRepository talabatPerseusRepository2) {
        Intrinsics.checkNotNullParameter(talabatPerseusRepository2, "<set-?>");
        this.talabatPerseusRepository = talabatPerseusRepository2;
    }
}
