package d1;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f11585b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f11586c;

    public /* synthetic */ b(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f11585b = fontCallback;
        this.f11586c = typeface;
    }

    public final void run() {
        this.f11585b.lambda$callbackSuccessAsync$0(this.f11586c);
    }
}
