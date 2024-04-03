package com.instabug.anr.diagnostics;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class b implements CalibrationDiagnosticEvent.IncidentType {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f45060a = "anr";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f45061b = a.f45059a;

    @NotNull
    public String getDiagnosticsName() {
        return this.f45060a;
    }

    @NotNull
    public Function0 getReportingPredicate() {
        return this.f45061b;
    }
}
