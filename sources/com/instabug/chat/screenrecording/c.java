package com.instabug.chat.screenrecording;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.chat.eventbus.b;
import com.instabug.chat.model.d;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.chat.network.f;
import com.instabug.chat.ui.a;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordingContract;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class c implements ScreenRecordingContract {

    /* renamed from: e  reason: collision with root package name */
    private static c f46148e;

    /* renamed from: a  reason: collision with root package name */
    private String f46149a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f46150b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Disposable f46151c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Disposable f46152d;

    public static c a() {
        if (f46148e == null) {
            f46148e = new c();
        }
        return f46148e;
    }

    /* access modifiers changed from: private */
    public void a(@Nullable Uri uri) {
        if (uri != null) {
            a(this.f46149a, uri);
            b(uri);
        }
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(a.a(currentActivity, this.f46149a));
        }
    }

    private void a(k kVar, Uri uri) {
        for (com.instabug.chat.model.a aVar : kVar.b()) {
            if (aVar.f() != null && aVar.f().equals("extra_video")) {
                InstabugSDKLogger.d("IBG-Core", "Setting attachment type to Video");
                aVar.c(uri.getLastPathSegment());
                aVar.b(uri.getPath());
                aVar.a(true);
                return;
            }
        }
    }

    private void a(String str) {
        this.f46150b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, android.net.Uri r6) {
        /*
            r4 = this;
            com.instabug.chat.model.k r0 = new com.instabug.chat.model.k
            java.lang.String r1 = com.instabug.library.user.UserManagerWrapper.getUserName()
            java.lang.String r2 = com.instabug.library.user.UserManagerWrapper.getUserEmail()
            java.lang.String r3 = com.instabug.library.core.InstabugCore.getPushNotificationToken()
            r0.<init>(r1, r2, r3)
            com.instabug.chat.model.k r0 = r0.b((java.lang.String) r5)
            java.lang.String r1 = ""
            com.instabug.chat.model.k r0 = r0.a((java.lang.String) r1)
            long r1 = com.instabug.library.util.InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()
            com.instabug.chat.model.k r0 = r0.a((long) r1)
            long r1 = com.instabug.library.util.InstabugDateFormatter.getCurrentUTCTimeStampInSeconds()
            com.instabug.chat.model.k r0 = r0.b((long) r1)
            com.instabug.chat.model.i r1 = com.instabug.chat.model.i.INBOUND
            com.instabug.chat.model.k r0 = r0.a((com.instabug.chat.model.i) r1)
            if (r6 == 0) goto L_0x0067
            com.instabug.chat.model.a r1 = new com.instabug.chat.model.a
            r1.<init>()
            java.lang.String r2 = r6.getLastPathSegment()
            r1.c(r2)
            java.lang.String r6 = r6.getPath()
            r1.b(r6)
            java.lang.String r6 = "extra_video"
            r1.e(r6)
            java.lang.String r6 = "offline"
            r1.d(r6)
            r6 = 0
            r1.a((boolean) r6)
            java.lang.String r6 = r0.f()
            r4.a((java.lang.String) r6)
            com.instabug.chat.model.j r6 = com.instabug.chat.model.j.STAY_OFFLINE
            r0.a((com.instabug.chat.model.j) r6)
            java.util.ArrayList r6 = r0.b()
            r6.add(r1)
        L_0x0067:
            com.instabug.chat.model.d r5 = com.instabug.chat.cache.k.a(r5)
            if (r5 == 0) goto L_0x00a0
            java.util.ArrayList r6 = r5.f()
            if (r6 == 0) goto L_0x00a0
            com.instabug.chat.model.b r6 = r5.a()
            com.instabug.chat.model.b r1 = com.instabug.chat.model.b.WAITING_ATTACHMENT_MESSAGE
            if (r6 != r1) goto L_0x0081
            com.instabug.chat.model.b r6 = com.instabug.chat.model.b.SENT
        L_0x007d:
            r5.a((com.instabug.chat.model.b) r6)
            goto L_0x008c
        L_0x0081:
            com.instabug.chat.model.b r6 = r5.a()
            com.instabug.chat.model.b r1 = com.instabug.chat.model.b.SENT
            if (r6 == r1) goto L_0x008c
            com.instabug.chat.model.b r6 = com.instabug.chat.model.b.READY_TO_BE_SENT
            goto L_0x007d
        L_0x008c:
            java.util.ArrayList r6 = r5.f()
            r6.add(r0)
            com.instabug.library.internal.storage.cache.InMemoryCache r6 = com.instabug.chat.cache.k.b()
            if (r6 == 0) goto L_0x00a0
            java.lang.String r0 = r5.getId()
            r6.put(r0, r5)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.chat.screenrecording.c.a(java.lang.String, android.net.Uri):void");
    }

    private void b(Uri uri) {
        d a11 = com.instabug.chat.cache.k.a(this.f46149a);
        if (a11 != null) {
            ArrayList f11 = a11.f();
            String str = this.f46150b;
            for (int i11 = 0; i11 < f11.size(); i11++) {
                k kVar = (k) f11.get(i11);
                InstabugSDKLogger.d("IBG-Core", "getting message with ID: " + kVar.f());
                if (kVar.f().equals(str)) {
                    a(kVar, uri);
                    kVar.a(j.READY_TO_BE_SENT);
                }
            }
            InMemoryCache b11 = com.instabug.chat.cache.k.b();
            if (b11 != null) {
                b11.put(a11.getId(), a11);
            }
            InstabugSDKLogger.d("IBG-Core", "video is encoded and updated in its message");
            if (Instabug.getApplicationContext() != null) {
                f.b().start();
                return;
            }
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Hanging Chat is null and can't be updated");
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.f46149a = str;
    }

    private void c() {
        Disposable disposable = this.f46151c;
        if (disposable != null && !disposable.isDisposed()) {
            this.f46151c.dispose();
        }
        Disposable disposable2 = this.f46152d;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.f46152d.dispose();
        }
    }

    public boolean b() {
        return InternalScreenRecordHelper.getInstance().isRecording();
    }

    public void c(String str) {
        this.f46149a = str;
        InternalScreenRecordHelper.getInstance().init();
        Disposable disposable = this.f46151c;
        if (disposable == null || disposable.isDisposed()) {
            this.f46151c = ScreenRecordingEventBus.getInstance().subscribe(new a(this));
        }
        this.f46152d = b.a().subscribe(new b(this, str));
    }

    public void clear() {
        c();
        InternalScreenRecordHelper.getInstance().clear();
    }

    public void delete() {
        InternalScreenRecordHelper.getInstance().delete();
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        return InternalScreenRecordHelper.getInstance().getAutoScreenRecordingFileUri();
    }

    public boolean isEnabled() {
        return InternalScreenRecordHelper.getInstance().isEnabled();
    }
}
