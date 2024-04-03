package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/view/View;", "rootView", "Landroidx/compose/runtime/Recomposer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class WindowRecomposerFactory$Companion$LifecycleAware$1 implements WindowRecomposerFactory {
    public static final WindowRecomposerFactory$Companion$LifecycleAware$1 INSTANCE = new WindowRecomposerFactory$Companion$LifecycleAware$1();

    @NotNull
    public final Recomposer createRecomposer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(view, (CoroutineContext) null, (Lifecycle) null, 3, (Object) null);
    }
}
