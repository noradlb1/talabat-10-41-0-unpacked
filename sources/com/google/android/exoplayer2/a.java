package com.google.android.exoplayer2;

import com.google.android.exoplayer2.AudioFocusManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioFocusManager.AudioFocusListener f34907b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f34908c;

    public /* synthetic */ a(AudioFocusManager.AudioFocusListener audioFocusListener, int i11) {
        this.f34907b = audioFocusListener;
        this.f34908c = i11;
    }

    public final void run() {
        this.f34907b.lambda$onAudioFocusChange$0(this.f34908c);
    }
}
