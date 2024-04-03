package com.instabug.commons.diagnostics.reporter;

import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.DiagnosticEvent;
import com.instabug.library.diagnostics.IBGDiagnostics;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class a implements DiagnosticsReporter {
    private final boolean a() {
        return DiagnosticsLocator.getConfigProvider().a();
    }

    public void report(@NotNull DiagnosticEvent diagnosticEvent) {
        Intrinsics.checkNotNullParameter(diagnosticEvent, "event");
        if (com.instabug.commons.utils.a.a() && a() && diagnosticEvent.getReportingPredicate().invoke().booleanValue()) {
            IBGDiagnostics.logEventImmediately(diagnosticEvent.getKey(), diagnosticEvent.getCount());
            String format = String.format("SDK diagnostic event %s reported.", Arrays.copyOf(new Object[]{diagnosticEvent.toString()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            com.instabug.commons.logging.a.b(format);
        }
    }
}
