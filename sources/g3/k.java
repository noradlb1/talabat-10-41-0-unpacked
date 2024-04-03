package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class k implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f44315a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f44316b;

    public /* synthetic */ k(String str, AtomicBoolean atomicBoolean) {
        this.f44315a = str;
        this.f44316b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$10(this.f44315a, this.f44316b, (Throwable) obj);
    }
}
