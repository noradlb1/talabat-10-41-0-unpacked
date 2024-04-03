package com.talabat.gem.adapters.presentation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0007¨\u0006\b"}, d2 = {"withGemFlowTracking", "", "Lcom/talabat/gem/adapters/presentation/GemView;", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemViewKt {
    @GemViewsDsl
    public static final void withGemFlowTracking(@NotNull GemView gemView, @NotNull Context context, @NotNull Function1<? super GemView, Unit> function1) {
        Intrinsics.checkNotNullParameter(gemView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "block");
        GemFlowTrackerKt.trackWithGemFlow(gemView, context);
        function1.invoke(gemView);
    }
}
