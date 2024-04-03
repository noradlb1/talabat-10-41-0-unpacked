package p8;

import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SphericalGLSurfaceView f35571b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f35572c;

    public /* synthetic */ a(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.f35571b = sphericalGLSurfaceView;
        this.f35572c = surfaceTexture;
    }

    public final void run() {
        this.f35571b.lambda$onSurfaceTextureAvailable$1(this.f35572c);
    }
}
