package com.deliveryhero.impression.compose;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"impression", "Landroidx/compose/ui/Modifier;", "trackerCompose", "Lcom/deliveryhero/impression/compose/ComposeImpressionTracker;", "position", "", "parentPosition", "(Landroidx/compose/ui/Modifier;Lcom/deliveryhero/impression/compose/ComposeImpressionTracker;ILjava/lang/Integer;)Landroidx/compose/ui/Modifier;", "impression-tracking_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ImpressionModifierKt {
    @NotNull
    public static final Modifier impression(@NotNull Modifier modifier, @NotNull ComposeImpressionTracker composeImpressionTracker, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(composeImpressionTracker, "trackerCompose");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new ImpressionModifierKt$impression$1(i11, num, composeImpressionTracker), 1, (Object) null);
    }

    public static /* synthetic */ Modifier impression$default(Modifier modifier, ComposeImpressionTracker composeImpressionTracker, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        return impression(modifier, composeImpressionTracker, i11, num);
    }
}
