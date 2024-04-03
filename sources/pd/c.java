package pd;

import android.graphics.Bitmap;
import com.instabug.library.util.OnVideoFrameReady;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnVideoFrameReady f57170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f57171c;

    public /* synthetic */ c(OnVideoFrameReady onVideoFrameReady, Bitmap bitmap) {
        this.f57170b = onVideoFrameReady;
        this.f57171c = bitmap;
    }

    public final void run() {
        this.f57170b.onReady(this.f57171c);
    }
}
