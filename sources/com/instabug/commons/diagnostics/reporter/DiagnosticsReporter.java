package com.instabug.commons.diagnostics.reporter;

import com.instabug.commons.diagnostics.event.DiagnosticEvent;
import org.jetbrains.annotations.NotNull;

public interface DiagnosticsReporter {
    void report(@NotNull DiagnosticEvent diagnosticEvent);
}
