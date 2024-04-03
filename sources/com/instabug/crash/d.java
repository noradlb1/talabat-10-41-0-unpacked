package com.instabug.crash;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.commons.models.Incident;
import com.instabug.commons.threading.a;
import com.instabug.crash.diagnostics.b;
import com.instabug.crash.models.a;
import com.instabug.crash.settings.g;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.model.Report;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ReportHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.lang.Thread;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: c  reason: collision with root package name */
    public static Boolean f46394c = Boolean.FALSE;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f46395a = Thread.getDefaultUncaughtExceptionHandler();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Context f46396b;

    public d(@Nullable Context context) {
        this.f46396b = context;
        d();
    }

    private void a() {
        AutoScreenRecordingEventBus.getInstance().post(ScreenRecordingService.Action.STOP_DELETE);
    }

    private boolean c() {
        return g.a().c();
    }

    private void d() {
        f46394c = Boolean.TRUE;
    }

    @NonNull
    public Report b() {
        SettingsManager instance = SettingsManager.getInstance();
        Report report = new Report();
        if (instance.getOnReportCreatedListener() != null) {
            try {
                instance.getOnReportCreatedListener().onReportCreated(report);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-CR", "Exception occurred in report Submit Handler ", e11);
            }
        }
        return report;
    }

    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        InstabugSDKLogger.e("IBG-CR", "InstabugUncaughtExceptionHandler Caught an Unhandled Exception: " + th2.getClass().getCanonicalName(), th2);
        if (!CrashReportingUtility.isCrashReportingEnabled()) {
            InstabugSDKLogger.d("IBG-CR", "Crash reporting is disabled, skipping...");
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f46395a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
                return;
            }
            return;
        }
        try {
            DiagnosticsLocator.getReporter().report(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new b(), CalibrationDiagnosticEvent.Action.Captured));
            com.instabug.crash.di.d.c().a("Crash");
            InstabugSDKLogger.e("IBG-Crash", "CrashReporting InstabugUncaughtExceptionHandler Caught an Unhandled Exception: " + th2.getClass().getCanonicalName(), th2);
            SettingsManager.getInstance().setCrashedSession(true);
            a aVar = new a(new com.instabug.commons.threading.d(thread), new a.C0054a.C0055a(th2), thread);
            if (com.instabug.crash.screenrecording.a.a().isEnabled() && SettingsManager.getInstance().autoScreenRecordingEnabled()) {
                a();
            }
            if (c()) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f46395a;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th2);
                    return;
                }
                return;
            }
            Context context = this.f46396b;
            if (context == null) {
                InstabugSDKLogger.e("IBG-CR", "Instabug context was null while persisting crash");
                return;
            }
            State state = State.getState(context);
            com.instabug.crash.utils.b.a(state);
            ReportHelper.update(state, b());
            com.instabug.crash.models.a a11 = a(new a.b().a(state), aVar.a(), aVar.b(), this.f46396b);
            AttachmentsUtility.encryptAttachments(a11.a());
            a(this.f46396b, a11);
            CommonsLocator.getSessionLinker().a((Incident) a11, 1);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f46395a;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th2);
            }
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-CR", "Error: " + e11.getMessage() + " while saving crash");
        } catch (IOException e12) {
            InstabugSDKLogger.e("IBG-CR", "Error: " + e12.getMessage() + " while saving crash");
        } catch (OutOfMemoryError e13) {
            IBGDiagnostics.reportNonFatalAndLog(e13, "OOM in uncaughtExceptionHandler", "IBG-CR");
        }
    }

    public void a(Context context, com.instabug.crash.models.a aVar) throws IOException, JSONException {
        State h11 = aVar.h();
        if (h11 != null) {
            InstabugSDKLogger.v("IBG-CR", "caching crash " + aVar.e());
            h11.setUri(DiskUtils.with(context).writeOperation(new WriteStateToFileDiskOperation(DiskUtils.createStateTextFile(context, "crash_state"), h11.toJson())).execute());
            com.instabug.crash.cache.b.b(aVar);
        }
    }

    @NonNull
    public com.instabug.crash.models.a a(com.instabug.crash.models.a aVar, JSONObject jSONObject, @Nullable JSONArray jSONArray, Context context) {
        InstabugSDKLogger.v("IBG-CR", "Updating crash before persisting to disk");
        aVar.a(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).e(jSONArray != null ? JSONArrayInstrumentation.toString(jSONArray) : null).a(a.C0057a.READY_TO_BE_SENT).a(false);
        if (InstabugCore.getExtraAttachmentFiles() != null && InstabugCore.getExtraAttachmentFiles().size() >= 1) {
            for (Map.Entry next : InstabugCore.getExtraAttachmentFiles().entrySet()) {
                Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(context, (Uri) next.getKey(), (String) next.getValue());
                if (newFileAttachmentUri != null) {
                    aVar.a(newFileAttachmentUri);
                }
            }
        }
        return aVar;
    }
}
