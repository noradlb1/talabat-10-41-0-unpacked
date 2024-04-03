package com.instabug.terminations.diagnostics;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class b implements CalibrationDiagnosticEvent.IncidentType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f52616a = "termination";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f52617b = a.f52615a;

    @NotNull
    public String getDiagnosticsName() {
        return this.f52616a;
    }

    @NotNull
    public Function0 getReportingPredicate() {
        return this.f52617b;
    }
}
