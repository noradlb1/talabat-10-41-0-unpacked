package com.instabug.commons.diagnostics;

import android.content.Context;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.commons.diagnostics.event.DiagnosticEvent;
import com.instabug.commons.diagnostics.reporter.DiagnosticsReporter;
import com.instabug.commons.f;
import com.instabug.commons.g;
import com.instabug.commons.utils.a;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class d implements g {
    /* access modifiers changed from: private */
    public static final /* synthetic */ CalibrationDiagnosticEvent b(int i11) {
        return new CalibrationDiagnosticEvent(i11, (CalibrationDiagnosticEvent.b) null, 2, (DefaultConstructorMarker) null);
    }

    private final void c(Context context) {
        DiagnosticsLocator diagnosticsLocator = DiagnosticsLocator.INSTANCE;
        if (a.a()) {
            Sequence<DiagnosticEvent> map = SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(new f(a.f46307a.b()).a(context).b()), b.f46310a), c.f46311a);
            DiagnosticsReporter reporter = DiagnosticsLocator.getReporter();
            for (DiagnosticEvent report : map) {
                reporter.report(report);
            }
        }
    }

    private final com.instabug.commons.configurations.a d() {
        return DiagnosticsLocator.getConfigHandler();
    }

    public void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void b() {
    }

    public void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void c() {
    }

    public void a() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            c(applicationContext);
        }
    }

    public void a(@NotNull SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(sDKCoreEvent, "sdkCoreEvent");
        if (Intrinsics.areEqual((Object) sDKCoreEvent.getType(), (Object) SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED)) {
            d().a(sDKCoreEvent.getValue());
        }
    }
}
