package com.talabat.observability.localTracer;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.core.dispatcher.data.RealCoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/observability/localTracer/PointOfInterestReporter;", "", "()V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "isTraceable", "", "tracesList", "", "", "Lcom/talabat/observability/localTracer/Trace;", "endTraceLog", "", "sectionOfInterest", "Lcom/talabat/observability/localTracer/SectionOfInterest;", "pointOfInterest", "Lcom/talabat/observability/localTracer/PointOfInterest;", "startTraceLog", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PointOfInterestReporter {
    @NotNull
    public static final PointOfInterestReporter INSTANCE = new PointOfInterestReporter();
    @NotNull
    private static final CoroutineDispatchersFactory coroutineDispatchersFactory = new RealCoroutineDispatchersFactory();
    private static final boolean isTraceable = false;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<String, Trace> tracesList = new LinkedHashMap();

    private PointOfInterestReporter() {
    }

    public final void endTraceLog(@NotNull SectionOfInterest sectionOfInterest, @NotNull PointOfInterest pointOfInterest) {
        Intrinsics.checkNotNullParameter(sectionOfInterest, "sectionOfInterest");
        Intrinsics.checkNotNullParameter(pointOfInterest, Param.POINT_OF_INTEREST);
    }

    public final void startTraceLog(@NotNull SectionOfInterest sectionOfInterest, @NotNull PointOfInterest pointOfInterest) {
        Intrinsics.checkNotNullParameter(sectionOfInterest, "sectionOfInterest");
        Intrinsics.checkNotNullParameter(pointOfInterest, Param.POINT_OF_INTEREST);
    }
}
