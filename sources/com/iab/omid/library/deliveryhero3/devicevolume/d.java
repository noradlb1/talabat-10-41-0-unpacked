package com.iab.omid.library.deliveryhero3.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.util.MimeTypes;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f44942a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f44943b;

    /* renamed from: c  reason: collision with root package name */
    private final a f44944c;

    /* renamed from: d  reason: collision with root package name */
    private final c f44945d;

    /* renamed from: e  reason: collision with root package name */
    private float f44946e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f44942a = context;
        this.f44943b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f44944c = aVar;
        this.f44945d = cVar;
    }

    private float a() {
        return this.f44944c.a(this.f44943b.getStreamVolume(3), this.f44943b.getStreamMaxVolume(3));
    }

    private boolean a(float f11) {
        return f11 != this.f44946e;
    }

    private void b() {
        this.f44945d.a(this.f44946e);
    }

    public void c() {
        this.f44946e = a();
        b();
        this.f44942a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f44942a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z11) {
        super.onChange(z11);
        float a11 = a();
        if (a(a11)) {
            this.f44946e = a11;
            b();
        }
    }
}
