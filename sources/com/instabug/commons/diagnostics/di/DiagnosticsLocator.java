package com.instabug.commons.diagnostics.di;

import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.commons.diagnostics.reporter.DiagnosticsReporter;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class DiagnosticsLocator {
    @NotNull
    public static final DiagnosticsLocator INSTANCE = new DiagnosticsLocator();
    @NotNull
    private static final Lazy configHandler$delegate = LazyKt__LazyJVMKt.lazy(a.f46314a);
    @NotNull
    private static final Lazy configProvider$delegate = LazyKt__LazyJVMKt.lazy(b.f46315a);
    @NotNull
    private static Function0<? extends CalibrationDiagnosticEvent.IncidentType> ndkIncidentTypeGetter = c.f46316a;
    @NotNull
    private static final Lazy reporter$delegate = LazyKt__LazyJVMKt.lazy(d.f46317a);

    public static final class a extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f46314a = new a();

        public a() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.diagnostics.configurations.c invoke() {
            return new com.instabug.commons.diagnostics.configurations.c();
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f46315a = new b();

        public b() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.diagnostics.configurations.a invoke() {
            return new com.instabug.commons.diagnostics.configurations.a();
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f46316a = new c();

        public c() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final b invoke() {
            return new b();
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final d f46317a = new d();

        public d() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.instabug.commons.diagnostics.reporter.a invoke() {
            return new com.instabug.commons.diagnostics.reporter.a();
        }
    }

    private DiagnosticsLocator() {
    }

    @NotNull
    public static final com.instabug.commons.configurations.a getConfigHandler() {
        return (com.instabug.commons.configurations.a) configHandler$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getConfigHandler$annotations() {
    }

    @NotNull
    public static final com.instabug.commons.diagnostics.configurations.b getConfigProvider() {
        return (com.instabug.commons.diagnostics.configurations.b) configProvider$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getConfigProvider$annotations() {
    }

    @NotNull
    public static final Function0<CalibrationDiagnosticEvent.IncidentType> getNdkIncidentTypeGetter() {
        return ndkIncidentTypeGetter;
    }

    @JvmStatic
    public static /* synthetic */ void getNdkIncidentTypeGetter$annotations() {
    }

    @NotNull
    public static final DiagnosticsReporter getReporter() {
        return (DiagnosticsReporter) reporter$delegate.getValue();
    }

    @JvmStatic
    public static /* synthetic */ void getReporter$annotations() {
    }

    public static final void setNdkIncidentTypeGetter(@NotNull Function0<? extends CalibrationDiagnosticEvent.IncidentType> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        ndkIncidentTypeGetter = function0;
    }
}
