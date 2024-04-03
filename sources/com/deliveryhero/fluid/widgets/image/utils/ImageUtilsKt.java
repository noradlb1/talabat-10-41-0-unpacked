package com.deliveryhero.fluid.widgets.image.utils;

import android.graphics.drawable.Drawable;
import com.deliveryhero.fluid.Host;
import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import com.deliveryhero.fluid.widgets.image.ImageWidget;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¨\u0006\n"}, d2 = {"updateImage", "", "Lcom/deliveryhero/fluid/widgets/image/ImageWidget;", "host", "Lcom/deliveryhero/fluid/Host;", "image", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "loadingPlaceholder", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "errorPlaceholder", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageUtilsKt {
    public static final void updateImage(@NotNull ImageWidget imageWidget, @NotNull Host host, @Nullable ImageLocator imageLocator, @Nullable ImageLocator.Local local, @Nullable ImageLocator.Local local2) {
        Intrinsics.checkNotNullParameter(imageWidget, "<this>");
        Intrinsics.checkNotNullParameter(host, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        Logger logger = host.getLogger();
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String tag = logger.getTag();
            Logger.log$default(logger, tag, logLevel, StringsKt__IndentKt.trimIndent("Loading image: `" + imageLocator + "`;\n            loadingPlaceholder: `" + local + "`;\n            errorPlaceholder: `" + local2 + "`\n        "), (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        if (imageLocator instanceof ImageLocator.Local) {
            host.getImageLoader().load(imageWidget, (ImageLocator.Local) imageLocator);
        } else if (imageLocator instanceof ImageLocator.Remote) {
            host.getImageLoader().load(imageWidget, (ImageLocator.Remote) imageLocator, local, local2);
        } else {
            imageWidget.setImageDrawable((Drawable) null);
        }
    }
}
