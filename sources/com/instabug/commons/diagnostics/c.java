package com.instabug.commons.diagnostics;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class c extends AdaptedFunctionReference implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c f46311a = new c();

    public c() {
        super(1, CalibrationDiagnosticEvent.class, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "<init>(ILcom/instabug/commons/diagnostics/event/CalibrationDiagnosticEvent$OSExitReasonMapper;)V", 0);
    }

    @NotNull
    public final CalibrationDiagnosticEvent a(int i11) {
        return d.b(i11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return a(((Number) obj).intValue());
    }
}
