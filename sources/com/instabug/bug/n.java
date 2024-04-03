package com.instabug.bug;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.instabug.bug.di.a;
import com.instabug.bug.model.d;
import com.instabug.bug.network.i;
import com.instabug.bug.settings.b;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.UserEvent;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.MemoryUtils;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

@Instrumented
public class n {

    /* renamed from: e  reason: collision with root package name */
    private static n f45682e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public volatile d f45683a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f45684b;

    /* renamed from: c  reason: collision with root package name */
    private o f45685c = o.CANCEL;

    /* renamed from: d  reason: collision with root package name */
    private int f45686d = -1;

    private n() {
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        LinkedHashMap<Uri, String> extraAttachmentFiles = InstabugCore.getExtraAttachmentFiles();
        if (extraAttachmentFiles != null) {
            for (Map.Entry next : extraAttachmentFiles.entrySet()) {
                if (context != null) {
                    a(context, (Uri) next.getKey(), (String) next.getValue(), Attachment.Type.ATTACHMENT_FILE);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void a(Context context, @NonNull State state) {
        d dVar = this.f45683a;
        if (dVar != null) {
            state.setUri(DiskUtils.with(context).writeOperation(new WriteStateToFileDiskOperation(DiskUtils.createStateTextFile(context, InstabugDbContract.BugEntry.COLUMN_BUG_STATE), state.toJson())).execute());
            if (InstabugCore.getFeatureState(Feature.REPRO_STEPS) == Feature.State.ENABLED && InstabugCore.isReproStepsScreenshotEnabled() && dVar.getId() != null) {
                VisualUserStepsHelper.getVisualUserStepsFileObservable(context, dVar.getId()).subscribe(new l(this, dVar), new m(this));
            }
            a.a().a(dVar.a(com.instabug.bug.model.a.READY_TO_BE_SENT));
            this.f45683a = dVar;
        }
    }

    /* access modifiers changed from: private */
    public void c(Context context) {
        if (this.f45683a != null) {
            for (Attachment attachment : this.f45683a.a()) {
                if (!(attachment.getType() == null || attachment.getLocalPath() == null)) {
                    if (attachment.getType().equals(Attachment.Type.MAIN_SCREENSHOT) || attachment.getType().equals(Attachment.Type.EXTRA_IMAGE) || attachment.getType().equals(Attachment.Type.GALLERY_IMAGE)) {
                        try {
                            BitmapUtils.compressBitmapAndSave(context, new File(attachment.getLocalPath()));
                        } catch (Exception unused) {
                            InstabugSDKLogger.e("IBG-BR", "Failed to compress attachments");
                        }
                    }
                }
            }
        }
    }

    public static synchronized n e() {
        n nVar;
        synchronized (n.class) {
            if (f45682e == null) {
                f45682e = new n();
            }
            nVar = f45682e;
        }
        return nVar;
    }

    private void f(Context context) {
        ActionsOrchestrator.obtainOrchestrator(PoolProvider.newBackgroundExecutor("bug-start-state-orchestration-executor")).addWorkerThreadAction(new u(context)).orchestrate();
    }

    /* access modifiers changed from: private */
    public void j() {
        b f11 = b.f();
        if (f11.h() != null && e().d() != null && e().c() != null) {
            f11.h().call(t.a(e().d()), t.a(e().c().i()));
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (SynchronizationManager.getInstance() != null) {
            SynchronizationManager.getInstance().sync();
        }
    }

    public void a() {
        if (Instabug.getApplicationContext() == null) {
            return;
        }
        if (a.e().b()) {
            i();
        } else {
            b(Instabug.getApplicationContext());
        }
    }

    public void a(int i11) {
        this.f45686d = i11;
    }

    public void a(Context context, Uri uri, Attachment.Type type) {
        a(context, uri, (String) null, type);
    }

    public void a(Context context, Uri uri, @Nullable String str, Attachment.Type type) {
        if (c() != null) {
            Uri newFileAttachmentUri = type == Attachment.Type.GALLERY_VIDEO ? AttachmentsUtility.getNewFileAttachmentUri(context, uri, str, 50.0d) : AttachmentsUtility.getNewFileAttachmentUri(context, uri, str);
            if (newFileAttachmentUri != null) {
                c().a(newFileAttachmentUri, type);
                e(context);
            }
        }
    }

    public void a(Context context, File file, Attachment.Type type) {
        if (c() != null) {
            c().a(Uri.fromFile(file), type);
            e(context);
        }
    }

    public void a(d dVar) {
        this.f45683a = dVar;
        this.f45684b = false;
        this.f45685c = o.CANCEL;
    }

    public void a(o oVar) {
        this.f45685c = oVar;
    }

    public void a(boolean z11) {
        this.f45684b = z11;
    }

    public int b() {
        int i11 = this.f45686d;
        this.f45686d = -1;
        return i11;
    }

    public void b(Context context) {
        ActionsOrchestrator.obtainOrchestrator(PoolProvider.newBackgroundExecutor("bug-commit-orchestration-executor")).addWorkerThreadAction(new k(this, context)).orchestrate();
    }

    public void b(Context context, Uri uri, Attachment.Type type) {
        a(context, uri, (String) null, type);
    }

    @Nullable
    public d c() {
        return this.f45683a;
    }

    @Nullable
    public o d() {
        return this.f45685c;
    }

    public void d(Context context) {
        if (this.f45683a == null) {
            a(new com.instabug.bug.model.b().a(context));
            f(context);
        }
    }

    public void e(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("refresh.attachments"));
    }

    public boolean f() {
        return this.f45684b;
    }

    public void g() {
        a(true);
        a(o.ADD_ATTACHMENT);
        j();
    }

    public void h() {
        this.f45683a = null;
    }

    public void i() {
        if (!(this.f45683a == null || this.f45683a.a() == null)) {
            for (Attachment attachment : this.f45683a.a()) {
                if (attachment.getLocalPath() != null) {
                    DiskUtils.deleteFile(attachment.getLocalPath());
                }
            }
        }
        h();
    }

    public void k() {
        if (Instabug.getApplicationContext() != null) {
            i.b().start();
        }
    }

    public void m() {
        String str;
        State state;
        if (this.f45683a != null && this.f45683a.getState() != null) {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null && !MemoryUtils.isLowMemory(applicationContext) && InstabugCore.getFeatureState(Feature.USER_EVENTS) == Feature.State.ENABLED) {
                try {
                    State state2 = this.f45683a.getState();
                    JSONArray json = UserEvent.toJson(InstabugUserEventLogger.getInstance().getUserEvents());
                    state2.setUserEvents(!(json instanceof JSONArray) ? json.toString() : JSONArrayInstrumentation.toString(json));
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-BR", "Got error while parsing user events logs", e11);
                }
            }
            if ((this.f45683a == null ? null : this.f45683a.getState()) != null) {
                if (SettingsManager.getInstance().getOnReportCreatedListener() == null) {
                    this.f45683a.getState().setTags(InstabugCore.getTagsAsString());
                    this.f45683a.getState().updateConsoleLog();
                    Feature.State featureState = InstabugCore.getFeatureState(Feature.USER_DATA);
                    Feature.State state3 = Feature.State.ENABLED;
                    if (featureState == state3) {
                        this.f45683a.getState().setUserData(InstabugCore.getUserData());
                    }
                    if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == state3) {
                        this.f45683a.getState().setInstabugLog(InstabugLog.getLogs());
                    }
                }
                if (!InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER) || this.f45683a.getState().getCustomUserAttribute() == null) {
                    state = this.f45683a.getState();
                    str = UserAttributesDbHelper.getSDKUserAttributes();
                } else {
                    state = this.f45683a.getState();
                    str = UserAttributesDbHelper.getSDKUserAttributesAndAppendToIt("IBG_phone_number", this.f45683a.getState().getCustomUserAttribute());
                }
                state.setUserAttributes(str);
                this.f45683a.getState().updateVisualUserSteps();
                this.f45683a.getState().setCurrentView(InstabugCore.getCurrentView());
            }
        }
    }
}
