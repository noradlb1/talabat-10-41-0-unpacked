package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 implements ComponentCallbacks2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Configuration f10012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageVectorCache f10013c;

    public AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(Configuration configuration, ImageVectorCache imageVectorCache) {
        this.f10012b = configuration;
        this.f10013c = imageVectorCache;
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f10013c.prune(this.f10012b.updateFrom(configuration));
        this.f10012b.setTo(configuration);
    }

    public void onLowMemory() {
        this.f10013c.clear();
    }

    public void onTrimMemory(int i11) {
        this.f10013c.clear();
    }
}
