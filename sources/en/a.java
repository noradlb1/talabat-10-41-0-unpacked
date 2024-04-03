package en;

import android.widget.ImageView;
import com.talabat.feature.mission.control.presentation.extensions.ImageViewExtensionsKt;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61980b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f61981c;

    public /* synthetic */ a(String str, ImageView imageView) {
        this.f61980b = str;
        this.f61981c = imageView;
    }

    public final void run() {
        ImageViewExtensionsKt.m10229loadCenterInsideWithGlide$lambda0(this.f61980b, this.f61981c);
    }
}
