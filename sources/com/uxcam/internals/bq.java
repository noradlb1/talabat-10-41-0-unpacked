package com.uxcam.internals;

import android.graphics.Bitmap;
import java.io.IOException;

public class bq {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13084d = true;

    /* renamed from: a  reason: collision with root package name */
    public final gi f13085a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f13086b;

    /* renamed from: c  reason: collision with root package name */
    public int f13087c;

    public bq(gi giVar) {
        gu.a("bq", "adding screenshot bitmap into videoooo inside constructor 111111111111111");
        this.f13085a = giVar;
    }

    public final void a(int i11) {
        try {
            Bitmap bitmap = this.f13086b;
            if (bitmap != null) {
                this.f13085a.a(bitmap, i11);
                if (hb.f13525h <= 0.0f) {
                    hb.f13525h = ia.d();
                }
            }
        } catch (IOException e11) {
            gu.a("bq").getClass();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "EncodeVideo::doEncode()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }
}
