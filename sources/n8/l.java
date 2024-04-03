package n8;

import com.google.android.exoplayer2.util.Util;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class l implements ThreadFactory {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35535b;

    public /* synthetic */ l(String str) {
        this.f35535b = str;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.lambda$newSingleThreadExecutor$3(this.f35535b, runnable);
    }
}
