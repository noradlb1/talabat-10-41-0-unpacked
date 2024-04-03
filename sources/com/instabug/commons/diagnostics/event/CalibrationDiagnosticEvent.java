package com.instabug.commons.diagnostics.event;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CalibrationDiagnosticEvent implements DiagnosticEvent {
    private final int count;
    @NotNull
    private final String key;
    @NotNull
    private final Function0<Boolean> reportingPredicate;

    @Retention(AnnotationRetention.RUNTIME)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    public @interface Action {
        @NotNull
        public static final String Captured = "captured";
        @NotNull
        public static final a Companion = a.f46321a;
        @NotNull
        public static final String Synced = "synced";

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ a f46321a = new a();

            private a() {
            }
        }
    }

    public interface IncidentType {
        @NotNull
        String getDiagnosticsName();

        @NotNull
        Function0<Boolean> getReportingPredicate();
    }

    public static final class a implements b {
        @NotNull
        public IncidentType a(int i11) {
            if (i11 == 10) {
                return new com.instabug.terminations.diagnostics.b();
            }
            if (i11 == 4) {
                return new com.instabug.crash.diagnostics.b();
            }
            if (i11 == 5) {
                return DiagnosticsLocator.getNdkIncidentTypeGetter().invoke();
            }
            if (i11 != 6) {
                return new b();
            }
            return new com.instabug.anr.diagnostics.b();
        }
    }

    public interface b {
        @NotNull
        IncidentType a(int i11);
    }

    @JvmOverloads
    public CalibrationDiagnosticEvent(int i11) {
        this(i11, (b) null, 2, (DefaultConstructorMarker) null);
    }

    public CalibrationDiagnosticEvent(@NotNull IncidentType incidentType, @Action @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(incidentType, "incidentType");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        Intrinsics.checkNotNullParameter(str2, "source");
        String format = String.format("%s_%s_%s", Arrays.copyOf(new Object[]{incidentType.getDiagnosticsName(), str2, str}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        String lowerCase = format.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.key = lowerCase;
        this.count = 1;
        this.reportingPredicate = incidentType.getReportingPredicate();
    }

    public int getCount() {
        return this.count;
    }

    @NotNull
    public String getKey() {
        return this.key;
    }

    @NotNull
    public Function0<Boolean> getReportingPredicate() {
        return this.reportingPredicate;
    }

    @NotNull
    public String toString() {
        String format = String.format("(key -> %s, count -> %d)", Arrays.copyOf(new Object[]{getKey(), Integer.valueOf(getCount())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CalibrationDiagnosticEvent(@NotNull IncidentType incidentType, @NotNull String str) {
        this(incidentType, str, ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        Intrinsics.checkNotNullParameter(incidentType, "incidentType");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalibrationDiagnosticEvent(int i11, b bVar, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? new a() : bVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CalibrationDiagnosticEvent(int i11, @NotNull b bVar) {
        this(bVar.a(i11), Action.Captured, "os");
        Intrinsics.checkNotNullParameter(bVar, "mapper");
    }
}
