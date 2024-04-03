package com.instabug.anr;

import android.app.ActivityManager;
import android.os.Debug;
import com.instabug.anr.di.c;
import com.instabug.anr.diagnostics.b;
import com.instabug.anr.model.a;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.diagnostics.di.DiagnosticsLocator;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.commons.models.Incident;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.DefensiveRunnableKt;
import java.io.IOException;
import kb.d;
import org.json.JSONException;

public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private boolean f45062a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45063b = false;

    /* renamed from: c  reason: collision with root package name */
    private a f45064c;

    /* renamed from: d  reason: collision with root package name */
    private a f45065d;

    /* renamed from: e  reason: collision with root package name */
    private f f45066e;

    public e(a aVar, a aVar2, f fVar) {
        this.f45064c = aVar;
        this.f45065d = aVar2;
        this.f45066e = fVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        while (Instabug.isEnabled() && !isInterrupted() && !this.f45063b) {
            if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger()) {
                ActivityManager.ProcessErrorStateInfo a11 = this.f45066e.a();
                boolean z11 = this.f45062a;
                if (z11 || this.f45064c == null) {
                    if (a11 == null) {
                        if (z11) {
                            c.c().a("Anr Recovery");
                        }
                        this.f45062a = false;
                    }
                } else if (a11 != null && a11.condition == 2) {
                    try {
                        DiagnosticsLocator.getReporter().report(new CalibrationDiagnosticEvent((CalibrationDiagnosticEvent.IncidentType) new b(), CalibrationDiagnosticEvent.Action.Captured));
                        c.c().a("Anr");
                        com.instabug.anr.model.b a12 = this.f45065d.a(a11.shortMsg, this.f45066e.b(a11), IncidentMetadata.Factory.create());
                        if (a12 != null) {
                            CommonsLocator.getSessionLinker().a((Incident) a12, 1);
                            this.f45064c.a(a12);
                        }
                    } catch (JSONException e11) {
                        InstabugSDKLogger.e("IBG-CR", "Couldn't create a new ANR object due to a JSON exception", e11);
                    } catch (IOException e12) {
                        InstabugSDKLogger.e("IBG-CR", "Couldn't create a new ANR object due to an IO exception", e12);
                    }
                    this.f45062a = true;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException unused) {
                InstabugSDKLogger.e("IBG-CR", "Can't detect ANR because InstabugANRDetector thread was interrupted.");
            }
        }
    }

    public void interrupt() {
        super.interrupt();
        this.f45063b = true;
    }

    public void run() {
        setName("Instabug ANR detector thread");
        DefensiveRunnableKt.runDefensive((Runnable) new d(this)).run();
    }
}
