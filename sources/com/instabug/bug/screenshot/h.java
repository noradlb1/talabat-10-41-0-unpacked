package com.instabug.bug.screenshot;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.bug.BugPlugin;
import com.instabug.bug.model.d;
import com.instabug.bug.n;
import com.instabug.bug.p;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.model.Attachment;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;

public class h implements ExtraScreenshotHelper.OnCaptureListener {

    /* renamed from: c  reason: collision with root package name */
    private static h f45737c;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f45738a;

    /* renamed from: b  reason: collision with root package name */
    private final ExtraScreenshotHelper f45739b = new ExtraScreenshotHelper();

    private h() {
        InstabugStateEventBus.getInstance().subscribe(new g(this));
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        n.e().i();
        n.e().h();
        this.f45739b.cancel();
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            bugPlugin.setState(0);
        }
    }

    private void a(Context context, @Nullable Uri uri) {
        context.startActivity(p.a(context, uri));
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f45737c == null) {
                f45737c = new h();
            }
            hVar = f45737c;
        }
        return hVar;
    }

    public synchronized void a(Context context) {
        this.f45738a = new WeakReference(context);
        this.f45739b.init(this);
    }

    public synchronized void onExtraScreenshotCaptured(Uri uri) {
        Context context;
        InstabugSDKLogger.v("IBG-BR", "Extra screenshot captured, Uri: " + uri);
        this.f45739b.release();
        d c11 = n.e().c();
        if (c11 != null) {
            c11.a(uri, Attachment.Type.EXTRA_IMAGE);
            WeakReference weakReference = this.f45738a;
            if (!(weakReference == null || (context = (Context) weakReference.get()) == null)) {
                InstabugSDKLogger.d("IBG-BR", "starting feedback activity");
                a(context, uri);
            }
        } else {
            InstabugSDKLogger.w("IBG-BR", "Bug has been released");
        }
    }

    public synchronized void onExtraScreenshotError(Throwable th2) {
        Context context;
        this.f45739b.release();
        WeakReference weakReference = this.f45738a;
        if (!(weakReference == null || (context = (Context) weakReference.get()) == null)) {
            a(context, (Uri) null);
        }
    }
}
