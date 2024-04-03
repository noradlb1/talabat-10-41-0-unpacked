package com.uxcam.internals;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.facebook.appevents.UserDataStore;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.uxcam.internals.gu;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class fn {

    /* renamed from: d  reason: collision with root package name */
    public static final Timer f13373d = new Timer();

    /* renamed from: e  reason: collision with root package name */
    public static boolean f13374e = false;

    /* renamed from: f  reason: collision with root package name */
    public static dg f13375f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13376g;

    /* renamed from: h  reason: collision with root package name */
    public static gi f13377h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f13378i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f13379j = false;

    /* renamed from: k  reason: collision with root package name */
    public static long f13380k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static WeakReference f13381l;

    /* renamed from: m  reason: collision with root package name */
    public static ArrayList f13382m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public static ArrayList f13383n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public static ArrayList f13384o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public static int f13385p = 0;

    /* renamed from: q  reason: collision with root package name */
    public static fn f13386q;

    /* renamed from: r  reason: collision with root package name */
    public static int f13387r = ((int) TimeUnit.SECONDS.toMillis(1));

    /* renamed from: s  reason: collision with root package name */
    public static boolean f13388s = false;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f13389a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final File f13390b;

    /* renamed from: c  reason: collision with root package name */
    public ab f13391c;

    public class aa implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f13392a;

        public aa(CountDownLatch countDownLatch) {
            this.f13392a = countDownLatch;
        }

        public void run() {
            try {
                fn.f13386q = new fn();
                this.f13392a.countDown();
            } catch (Exception e11) {
                e11.printStackTrace();
                fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
                a11.a("site_of_error", "ScreenVideoHandler::getInstance()::run()");
                a11.a("reason", e11.getMessage());
                a11.a(2);
            }
        }
    }

    public interface ab {
        void a();
    }

    public fn() {
        File c11 = c();
        by.b();
        this.f13390b = new File(c11, "video.mp4");
        f13388s = g();
        e();
    }

    public static fn b() {
        if (f13386q == null) {
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                new Handler(Looper.getMainLooper()).post(new aa(countDownLatch));
                countDownLatch.await(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
                a11.a("site_of_error", "ScreenVideoHandler::getInstance()");
                a11.a("reason", e11.getMessage());
                a11.a(2);
            }
        }
        return f13386q;
    }

    public static boolean g() {
        return true;
    }

    public static void h() {
        f13386q = null;
        f13377h = null;
        dg dgVar = f13375f;
        if (dgVar != null) {
            dgVar.clear();
            f13375f = null;
        }
        fm.f13362a = 0;
    }

    public void a(gi giVar) {
        if (f13375f.size() == 0 && f13376g && gm.f13457f) {
            fm.f13362a = 0;
            f13376g = false;
            gu.ab a11 = gu.a(UserDataStore.FIRST_NAME);
            f13375f.size();
            a11.getClass();
            try {
                giVar.a();
                gu.a(UserDataStore.FIRST_NAME).getClass();
                a();
            } catch (Exception e11) {
                a();
                gu.a(UserDataStore.FIRST_NAME).getClass();
                fx a12 = new fx().a(AgentHealth.DEFAULT_KEY);
                a12.a("site_of_error", "ScreenVideoHandler::finishEncodingAndSendHttp()");
                a12.a("reason", e11.getMessage());
                a12.a(2);
            }
            f13386q = null;
            f13377h = null;
            f13375f.clear();
            f13375f = null;
            fm.f13362a = 0;
            i();
        }
    }

    public final File c() {
        File file = new File(by.c());
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public final void d() {
        fl a11 = fl.a();
        a11.getClass();
        a11.a(new Rect());
        a11.f13357b = false;
        f13387r = gm.f13458g;
        hl.a("the timer delay is : ").append(f13387r);
    }

    public final void e() {
        String str;
        if (!f13388s) {
            f();
            str = "JCodec";
        } else if (Build.MODEL.contains("SM-G93")) {
            d();
            gu.a(UserDataStore.FIRST_NAME).getClass();
            f13378i = true;
            cm cmVar = new cm();
            File file = new File(by.c());
            if (!file.exists()) {
                file.mkdir();
            }
            cmVar.f13134b = this.f13390b.getAbsolutePath();
            cmVar.f13133a.add(new fo(this));
            new Thread(new fp(this, cmVar)).start();
            str = "GLMediaCodec";
        } else {
            d();
            gu.a(UserDataStore.FIRST_NAME).getClass();
            f13378i = true;
            gs gsVar = new gs();
            File file2 = new File(by.c());
            if (!file2.exists()) {
                file2.mkdir();
            }
            gsVar.f13489a = this.f13390b.getAbsolutePath();
            gsVar.f13490b = new go();
            gsVar.f13492d.add(new fq(this));
            gsVar.f13491c.start();
            str = "MediaCodec";
        }
        fx a11 = new fx().a("Initialized Media Codec");
        a11.a("site_of_error", "ScreenVideoHandler::takeScreenshotShotAndEncode()");
        fx a12 = a11.a("codec_type", str);
        int i11 = gm.f13458g;
        a12.a("frame_time", "" + i11);
        a12.a(1);
    }

    public final void f() {
        f13388s = false;
        try {
            if (f13377h == null) {
                File file = new File(by.c());
                if (!file.exists()) {
                    file.mkdir();
                }
                int i11 = gm.f13452a;
                f13377h = new gi(new File(file, "video.mp4"));
            }
            gu.a(UserDataStore.FIRST_NAME).getClass();
        } catch (IOException e11) {
            gu.f13504c.getClass();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ScreenVideoHandler::initializeJCodec()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
        f13375f = new dg();
        d();
    }

    public final void i() {
        try {
            hu.a("encodingComplete", (Map) null);
            if (gm.C && this.f13390b.exists()) {
                File file = this.f13390b;
                il ilVar = new il(file);
                ilVar.a();
                ia.c(file);
                ia.c(ilVar.f13644b);
                fx fxVar = new fx();
                fxVar.a("site_of_error", "ScreenVideoHandler::startUploadService()");
                fxVar.a("Encoding Complete").a(1);
            }
            Intent intent = new Intent(ia.f13617c, HttpPostService.class);
            intent.putExtra("arg_which_service", "screen_upload");
            ia.f13617c.startService(intent);
        } catch (Exception e11) {
            fx fxVar2 = new fx();
            fxVar2.a("EXCEPTION");
            fxVar2.a("site_of_error", "ScreenVideoHandler::startUploadService()");
            fxVar2.a("reason", e11.getMessage());
            fxVar2.a(2);
        }
    }

    public final void a() {
        ab abVar = this.f13391c;
        if (abVar != null) {
            abVar.a();
            this.f13391c = null;
        }
    }
}
