package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class t implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f35040a;

    public /* synthetic */ t(PlaybackInfo playbackInfo) {
        this.f35040a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$19(this.f35040a, (Player.Listener) obj);
    }
}
