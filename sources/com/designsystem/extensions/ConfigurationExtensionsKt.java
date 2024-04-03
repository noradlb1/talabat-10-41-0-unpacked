package com.designsystem.extensions;

import android.content.res.Configuration;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"isArabicLanguage", "", "Landroid/content/res/Configuration;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ConfigurationExtensionsKt {
    public static final boolean isArabicLanguage(@NotNull Configuration configuration) {
        String str;
        Intrinsics.checkNotNullParameter(configuration, "<this>");
        if (Build.VERSION.SDK_INT >= 24) {
            str = configuration.getLocales().get(0).getLanguage();
        } else {
            str = configuration.locale.getLanguage();
        }
        return Intrinsics.areEqual((Object) str, (Object) ArchiveStreamFactory.AR);
    }
}
