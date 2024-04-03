package g3;

import com.airbnb.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f44299b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44300c;

    public /* synthetic */ d(LottieAnimationView lottieAnimationView, String str) {
        this.f44299b = lottieAnimationView;
        this.f44300c = str;
    }

    public final Object call() {
        return this.f44299b.lambda$fromAssets$2(this.f44300c);
    }
}
