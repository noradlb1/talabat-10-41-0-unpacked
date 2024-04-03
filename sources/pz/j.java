package pz;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyEmbedderResponder;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f24071b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f24072c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f24073d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f24074e;

    public /* synthetic */ j(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, long j11, KeyEvent keyEvent) {
        this.f24071b = keyEmbedderResponder;
        this.f24072c = keyPair;
        this.f24073d = j11;
        this.f24074e = keyEvent;
    }

    public final void run() {
        this.f24071b.lambda$synchronizePressingKey$0(this.f24072c, this.f24073d, this.f24074e);
    }
}
