package g3;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class j implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f44313a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f44314b;

    public /* synthetic */ j(String str, AtomicBoolean atomicBoolean) {
        this.f44313a = str;
        this.f44314b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        LottieCompositionFactory.lambda$cache$9(this.f44313a, this.f44314b, (LottieComposition) obj);
    }
}
