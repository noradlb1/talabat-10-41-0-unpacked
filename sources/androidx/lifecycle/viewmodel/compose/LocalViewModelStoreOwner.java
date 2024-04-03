package androidx.lifecycle.viewmodel.compose;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/lifecycle/viewmodel/compose/LocalViewModelStoreOwner;", "", "()V", "LocalViewModelStoreOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/ViewModelStoreOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/ViewModelStoreOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "viewModelStoreOwner", "lifecycle-viewmodel-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalViewModelStoreOwner {
    public static final int $stable = 0;
    @NotNull
    public static final LocalViewModelStoreOwner INSTANCE = new LocalViewModelStoreOwner();
    @NotNull
    private static final ProvidableCompositionLocal<ViewModelStoreOwner> LocalViewModelStoreOwner = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, LocalViewModelStoreOwner$LocalViewModelStoreOwner$1.INSTANCE, 1, (Object) null);

    private LocalViewModelStoreOwner() {
    }

    @Nullable
    @Composable
    @JvmName(name = "getCurrent")
    public final ViewModelStoreOwner getCurrent(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-584162872);
        ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) composer.consume(LocalViewModelStoreOwner);
        if (viewModelStoreOwner == null) {
            viewModelStoreOwner = ViewTreeViewModelStoreOwner.get((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        }
        composer.endReplaceableGroup();
        return viewModelStoreOwner;
    }

    @NotNull
    public final ProvidedValue<ViewModelStoreOwner> provides(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        return LocalViewModelStoreOwner.provides(viewModelStoreOwner);
    }
}
