package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class l implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34952a;

    public /* synthetic */ l(PlaybackInfo playbackInfo) {
        this.f34952a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackParametersChanged(this.f34952a.playbackParameters);
    }
}
