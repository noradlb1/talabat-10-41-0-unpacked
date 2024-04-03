package g3;

import com.airbnb.lottie.LottieCompositionFactory;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final /* synthetic */ class n implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZipInputStream f44321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f44322c;

    public /* synthetic */ n(ZipInputStream zipInputStream, String str) {
        this.f44321b = zipInputStream;
        this.f44322c = str;
    }

    public final Object call() {
        return LottieCompositionFactory.fromZipStreamSync(this.f44321b, this.f44322c);
    }
}
