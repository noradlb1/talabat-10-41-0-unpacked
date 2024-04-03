package com.instabug.commons.diagnostics.event;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public interface DiagnosticEvent {
    int getCount();

    @NotNull
    String getKey();

    @NotNull
    Function0<Boolean> getReportingPredicate();
}
