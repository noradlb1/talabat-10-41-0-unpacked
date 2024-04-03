package zh;

import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f58059b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58060c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f58061d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ResizeStrategy f58062e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Transformation f58063f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f58064g;

    public /* synthetic */ a(ImageView imageView, String str, Integer num, ResizeStrategy resizeStrategy, Transformation transformation, Integer num2) {
        this.f58059b = imageView;
        this.f58060c = str;
        this.f58061d = num;
        this.f58062e = resizeStrategy;
        this.f58063f = transformation;
        this.f58064g = num2;
    }

    public final void run() {
        BindingAdaptersKt.m9633loadImageWithGlide$lambda1(this.f58059b, this.f58060c, this.f58061d, this.f58062e, this.f58063f, this.f58064g);
    }
}
