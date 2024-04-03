package com.uxcam.internals;

import com.facebook.appevents.UserDataStore;
import java.util.Timer;

public class fq implements bs {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fn f13395a;

    public fq(fn fnVar) {
        this.f13395a = fnVar;
    }

    public void a() {
        Timer timer = fn.f13373d;
        gu.a(UserDataStore.FIRST_NAME).getClass();
        this.f13395a.f();
        fx fxVar = new fx();
        fxVar.a("EXCEPTION");
        fxVar.a("site_of_error", "ScreenVideoHandler::initializeMediaCodec() -> encoderFailed()");
        fxVar.a("reason", "exception was not thrown ...");
        fxVar.a("invokes_next", "initializeJCodec()");
        fxVar.a("reason1", "Encoding failed with media codec.").a(2);
    }

    public void b() {
        Timer timer = fn.f13373d;
        gu.a(UserDataStore.FIRST_NAME).getClass();
        this.f13395a.a();
        fn fnVar = this.f13395a;
        fnVar.getClass();
        fm.f13362a = 0;
        fn.f13376g = false;
        fn.h();
        fnVar.i();
        fx fxVar = new fx();
        fxVar.a("EXCEPTION");
        fxVar.a("site_of_error", "ScreenVideoHandler::finishEncodingAndSendHttp() -> encoderSucceeded()");
        fxVar.a("reason", "Encoding complete with media codec.");
        fxVar.a("invokes_next", "encodingComplete() && finishEncodingAndSendHttpForKitkat()");
        fxVar.a(1);
    }
}
