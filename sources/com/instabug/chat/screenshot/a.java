package com.instabug.chat.screenshot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import com.instabug.library.screenshot.ExtraScreenshotHelper;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.ref.WeakReference;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class a implements ExtraScreenshotHelper.OnCaptureListener {

    /* renamed from: d  reason: collision with root package name */
    private static a f46153d;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f46154a;

    /* renamed from: b  reason: collision with root package name */
    private ExtraScreenshotHelper f46155b = new ExtraScreenshotHelper();

    /* renamed from: c  reason: collision with root package name */
    private String f46156c;

    private a() {
    }

    private com.instabug.chat.model.a a(Uri uri) {
        com.instabug.chat.model.a aVar = new com.instabug.chat.model.a();
        aVar.d("offline");
        aVar.e("extra_image").b(uri.getPath()).c(uri.getLastPathSegment());
        return aVar;
    }

    public static a a() {
        if (f46153d == null) {
            f46153d = new a();
        }
        return f46153d;
    }

    private void a(Context context, String str, com.instabug.chat.model.a aVar) {
        context.startActivity(com.instabug.chat.ui.a.a(context, str, aVar));
    }

    public void a(Context context, String str) {
        this.f46154a = new WeakReference(context);
        this.f46156c = str;
        this.f46155b.init(this);
    }

    public void onExtraScreenshotCaptured(Uri uri) {
        Context context;
        InstabugSDKLogger.v("IBG-BR", "ExtraScreenshot Captured Uri: " + uri);
        this.f46155b.release();
        WeakReference weakReference = this.f46154a;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            a(context, this.f46156c, a(uri));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onExtraScreenshotError(Throwable th2) {
        Context context;
        WeakReference weakReference = this.f46154a;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            a(context, this.f46156c, (com.instabug.chat.model.a) null);
        }
    }
}
