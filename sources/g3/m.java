package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import java.io.InputStream;
import java.util.concurrent.Callable;

public final /* synthetic */ class m implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InputStream f44319b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44320c;

    public /* synthetic */ m(InputStream inputStream, String str) {
        this.f44319b = inputStream;
        this.f44320c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.f44319b, this.f44320c);
    }
}
