package com.google.android.exoplayer2.scheduler;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequirementsWatcher.NetworkCallback f34995b;

    public /* synthetic */ a(RequirementsWatcher.NetworkCallback networkCallback) {
        this.f34995b = networkCallback;
    }

    public final void run() {
        this.f34995b.lambda$postRecheckNotMetNetworkRequirements$1();
    }
}
