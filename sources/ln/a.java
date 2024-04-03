package ln;

import android.widget.ImageView;
import com.talabat.feature.pharmacy.extensions.ViewExtensionsKt;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f62251b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62252c;

    public /* synthetic */ a(ImageView imageView, String str) {
        this.f62251b = imageView;
        this.f62252c = str;
    }

    public final void run() {
        ViewExtensionsKt.m10235loadImageWithGlide$lambda0(this.f62251b, this.f62252c);
    }
}
