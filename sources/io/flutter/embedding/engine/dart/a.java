package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DartMessenger f14177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f14179d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DartMessenger.HandlerInfo f14180e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f14181f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f14182g;

    public /* synthetic */ a(DartMessenger dartMessenger, String str, int i11, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j11) {
        this.f14177b = dartMessenger;
        this.f14178c = str;
        this.f14179d = i11;
        this.f14180e = handlerInfo;
        this.f14181f = byteBuffer;
        this.f14182g = j11;
    }

    public final void run() {
        this.f14177b.lambda$dispatchMessageToQueue$0(this.f14178c, this.f14179d, this.f14180e, this.f14181f, this.f14182g);
    }
}
