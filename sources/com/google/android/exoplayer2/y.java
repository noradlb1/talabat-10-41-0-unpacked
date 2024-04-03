package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioAttributes f35080a;

    public /* synthetic */ y(AudioAttributes audioAttributes) {
        this.f35080a = audioAttributes;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAudioAttributesChanged(this.f35080a);
    }
}
