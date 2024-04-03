package com.instabug.commons.diagnostics.di;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class b implements CalibrationDiagnosticEvent.IncidentType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f46319a = "ndk";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f46320b = a.f46318a;

    @NotNull
    public String getDiagnosticsName() {
        return this.f46319a;
    }

    @NotNull
    public Function0 getReportingPredicate() {
        return this.f46320b;
    }
}
