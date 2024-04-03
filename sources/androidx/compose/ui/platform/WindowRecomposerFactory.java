package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.InternalComposeUiApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory;", "", "createRecomposer", "Landroidx/compose/runtime/Recomposer;", "windowRootView", "Landroid/view/View;", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalComposeUiApi
public interface WindowRecomposerFactory {
    @NotNull
    public static final Companion Companion = Companion.f10071a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/WindowRecomposerFactory$Companion;", "", "()V", "LifecycleAware", "Landroidx/compose/ui/platform/WindowRecomposerFactory;", "getLifecycleAware$annotations", "getLifecycleAware", "()Landroidx/compose/ui/platform/WindowRecomposerFactory;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final WindowRecomposerFactory LifecycleAware = WindowRecomposerFactory$Companion$LifecycleAware$1.INSTANCE;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f10071a = new Companion();

        private Companion() {
        }

        public static /* synthetic */ void getLifecycleAware$annotations() {
        }

        @NotNull
        public final WindowRecomposerFactory getLifecycleAware() {
            return LifecycleAware;
        }
    }

    @NotNull
    Recomposer createRecomposer(@NotNull View view);
}
