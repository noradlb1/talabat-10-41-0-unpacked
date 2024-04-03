package i5;

import com.airbnb.lottie.LottieListener;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.widgets.lottie.LottieWidgetFactory;

public final /* synthetic */ class a implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Host f34477a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34478b;

    public /* synthetic */ a(Host host, String str) {
        this.f34477a = host;
        this.f34478b = str;
    }

    public final void onResult(Object obj) {
        LottieWidgetFactory.m8224create$lambda2$lambda1$lambda0(this.f34477a, this.f34478b, (Throwable) obj);
    }
}
