package en;

import com.bumptech.glide.RequestBuilder;
import com.talabat.feature.mission.control.presentation.extensions.ImageViewExtensionsKt$setupRetry$1;
import java.lang.ref.WeakReference;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f61982b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RequestBuilder f61983c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f61984d;

    public /* synthetic */ b(WeakReference weakReference, RequestBuilder requestBuilder, String str) {
        this.f61982b = weakReference;
        this.f61983c = requestBuilder;
        this.f61984d = str;
    }

    public final void run() {
        ImageViewExtensionsKt$setupRetry$1.m10230onLoadFailed$lambda1(this.f61982b, this.f61983c, this.f61984d);
    }
}
