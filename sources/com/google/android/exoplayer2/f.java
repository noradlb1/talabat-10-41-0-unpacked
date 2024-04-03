package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f34937a;

    public /* synthetic */ f(TrackSelectionParameters trackSelectionParameters) {
        this.f34937a = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTrackSelectionParametersChanged(this.f34937a);
    }
}
