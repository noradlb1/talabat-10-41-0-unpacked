package g3;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;

public final /* synthetic */ class i implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f44312b;

    public /* synthetic */ i(LottieComposition lottieComposition) {
        this.f44312b = lottieComposition;
    }

    public final Object call() {
        return LottieCompositionFactory.lambda$cache$8(this.f44312b);
    }
}
