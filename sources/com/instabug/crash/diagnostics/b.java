package com.instabug.crash.diagnostics;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class b implements CalibrationDiagnosticEvent.IncidentType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f46403a = "crash";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f46404b = a.f46402a;

    @NotNull
    public String getDiagnosticsName() {
        return this.f46403a;
    }

    @NotNull
    public Function0 getReportingPredicate() {
        return this.f46404b;
    }
}
