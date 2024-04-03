package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class s implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f34992a;

    public /* synthetic */ s(MediaMetadata mediaMetadata) {
        this.f34992a = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaMetadataChanged(this.f34992a);
    }
}
