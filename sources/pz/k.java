package pz;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyEmbedderResponder;
import io.flutter.embedding.android.KeyboardMap;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyEmbedderResponder f24075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KeyboardMap.KeyPair f24076c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ KeyEvent f24077d;

    public /* synthetic */ k(KeyEmbedderResponder keyEmbedderResponder, KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        this.f24075b = keyEmbedderResponder;
        this.f24076c = keyPair;
        this.f24077d = keyEvent;
    }

    public final void run() {
        this.f24075b.lambda$synchronizePressingKey$1(this.f24076c, this.f24077d);
    }
}
