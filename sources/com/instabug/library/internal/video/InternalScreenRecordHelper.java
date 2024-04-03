package com.instabug.library.internal.video;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.invoker.p;
import com.instabug.library.util.l;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.io.File;

public class InternalScreenRecordHelper implements ScreenRecordingContract, p.a {
    private static InternalScreenRecordHelper INSTANCE;
    /* access modifiers changed from: private */
    public boolean canStopRecording;
    @Nullable
    private p fab;
    @Nullable
    private ScreenRecordingFileHolder fileHolder;
    private boolean isCurrentlyRecording = false;
    /* access modifiers changed from: private */
    public final Subject<Boolean> stopSubject = BehaviorSubject.createDefault(Boolean.FALSE);

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (InternalScreenRecordHelper.this.isRecording()) {
                InternalScreenRecordHelper.this.stopSubject.onNext(Boolean.TRUE);
            }
        }
    }

    public class b implements Consumer {
        public b() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) {
            boolean unused = InternalScreenRecordHelper.this.canStopRecording = bool.booleanValue();
        }
    }

    private InternalScreenRecordHelper() {
    }

    public static synchronized InternalScreenRecordHelper getInstance() {
        InternalScreenRecordHelper internalScreenRecordHelper;
        synchronized (InternalScreenRecordHelper.class) {
            if (INSTANCE == null) {
                INSTANCE = new InternalScreenRecordHelper();
            }
            internalScreenRecordHelper = INSTANCE;
        }
        return internalScreenRecordHelper;
    }

    private void resetFab() {
        p pVar = this.fab;
        if (pVar != null) {
            pVar.l();
            this.fab.k();
        }
    }

    public void c() {
        ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(4, (Uri) null));
    }

    public void cancel() {
        if (isRecording()) {
            resetFab();
        }
    }

    public void clear() {
        this.isCurrentlyRecording = false;
        ScreenRecordingFileHolder screenRecordingFileHolder = this.fileHolder;
        if (screenRecordingFileHolder != null) {
            screenRecordingFileHolder.clear();
        }
    }

    public void d() {
        ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(2, getAutoScreenRecordingFileUri()));
    }

    public void delete() {
        ScreenRecordingFileHolder screenRecordingFileHolder = this.fileHolder;
        if (screenRecordingFileHolder != null) {
            screenRecordingFileHolder.delete();
        }
    }

    public void e(File file) {
        ScreenRecordingFileHolder screenRecordingFileHolder = this.fileHolder;
        if (screenRecordingFileHolder != null) {
            screenRecordingFileHolder.setAutoScreenRecordingFile(file);
        }
    }

    public void f() {
        p pVar = this.fab;
        if (pVar != null) {
            pVar.p();
        }
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        ScreenRecordingFileHolder screenRecordingFileHolder = this.fileHolder;
        if (screenRecordingFileHolder == null) {
            return null;
        }
        return screenRecordingFileHolder.getAutoScreenRecordingFileUri();
    }

    public Observable<Boolean> getIsStoppableObservable() {
        return this.stopSubject.hide().doOnNext(new b());
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void init() {
        InvocationManager.getInstance().switchOffInvocation();
        this.fileHolder = ScreenRecordingFileHolder.getInstance();
        if (this.fab == null) {
            this.fab = new p(this);
        }
        this.fab.k();
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isRecording() {
        return this.isCurrentlyRecording;
    }

    public void pause() {
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void release() {
        p pVar = this.fab;
        if (pVar != null) {
            pVar.l();
        }
        InvocationManager.getInstance().switchOnInvocation();
        if (Instabug.getApplicationContext() != null) {
            l.b(Instabug.getApplicationContext());
        }
        this.stopSubject.onNext(Boolean.FALSE);
        this.isCurrentlyRecording = false;
    }

    public void start() {
        this.isCurrentlyRecording = true;
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                ComponentName unused = applicationContext.startForegroundService(ScreenRecordingService.a(applicationContext, -1, InstabugMediaProjectionIntent.getMediaProjectionIntent(), true));
            } else {
                applicationContext.startService(ScreenRecordingService.a(applicationContext, -1, InstabugMediaProjectionIntent.getMediaProjectionIntent(), true));
            }
        }
        new Handler().postDelayed(new a(), 1000);
    }

    public void stop(int i11) {
        if (this.canStopRecording) {
            ScreenRecordingEventBus.getInstance().post(new ScreenRecordingEvent(1, getAutoScreenRecordingFileUri(), i11));
            release();
        }
    }
}
