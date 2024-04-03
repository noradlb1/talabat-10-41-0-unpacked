package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34947a;

    public /* synthetic */ j(PlaybackInfo playbackInfo) {
        this.f34947a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackSuppressionReasonChanged(this.f34947a.playbackSuppressionReason);
    }
}
