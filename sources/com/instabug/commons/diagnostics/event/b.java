package com.instabug.commons.diagnostics.event;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class b implements CalibrationDiagnosticEvent.IncidentType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f46323a = "unknown";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f46324b = a.f46322a;

    @NotNull
    public String getDiagnosticsName() {
        return this.f46323a;
    }

    @NotNull
    public Function0 getReportingPredicate() {
        return this.f46324b;
    }
}
