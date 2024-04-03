package g3;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;

public final /* synthetic */ class b implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f44298a;

    public /* synthetic */ b(LottieAnimationView lottieAnimationView) {
        this.f44298a = lottieAnimationView;
    }

    public final void onResult(Object obj) {
        this.f44298a.setComposition((LottieComposition) obj);
    }
}
