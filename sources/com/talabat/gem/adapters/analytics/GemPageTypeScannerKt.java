package com.talabat.gem.adapters.analytics;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"GemPageTypeScanner", "Lkotlin/Function0;", "", "Landroid/app/Application;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemPageTypeScannerKt {
    @NotNull
    public static final Function0<String> GemPageTypeScanner(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        application.registerActivityLifecycleCallbacks(new GemPageTypeScannerKt$GemPageTypeScanner$1(objectRef));
        return new GemPageTypeScannerKt$GemPageTypeScanner$2(objectRef);
    }
}
