package g3;

import com.airbnb.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f44296b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f44297c;

    public /* synthetic */ a(LottieAnimationView lottieAnimationView, int i11) {
        this.f44296b = lottieAnimationView;
        this.f44297c = i11;
    }

    public final Object call() {
        return this.f44296b.lambda$fromRawRes$1(this.f44297c);
    }
}
