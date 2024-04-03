package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;

public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SceneRenderer f35072b;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.f35072b = sceneRenderer;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f35072b.lambda$init$0(surfaceTexture);
    }
}
