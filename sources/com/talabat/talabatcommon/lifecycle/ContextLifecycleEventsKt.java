package com.talabat.talabatcommon.lifecycle;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0004¨\u0006\u0007"}, d2 = {"withLifecycleEvents", "", "Landroid/content/Context;", "observe", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/lifecycle/ContextLifecycleEvents;", "Lkotlin/ExtensionFunctionType;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContextLifecycleEventsKt {
    @ContextsDsl
    public static final void withLifecycleEvents(@Nullable Context context, @NotNull Function1<? super ContextLifecycleEvents, Unit> function1) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(function1, "observe");
        ContextLifecycleEvents contextLifecycleEvents = new ContextLifecycleEvents();
        function1.invoke(contextLifecycleEvents);
        if (context != null) {
            if (!(context instanceof LifecycleOwner)) {
                context = null;
            }
            if (context != null && (lifecycle = ((LifecycleOwner) context).getLifecycle()) != null) {
                lifecycle.addObserver(new ContextLifecycleEventsKt$withLifecycleEvents$3(contextLifecycleEvents));
            }
        }
    }
}
