package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "interval", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.lazy.grid.ComposableSingletons$LazyGridItemProviderKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$LazyGridItemProviderKt$lambda1$1 extends Lambda implements Function4<LazyGridIntervalContent, Integer, Composer, Integer, Unit> {
    public static final ComposableSingletons$LazyGridItemProviderKt$lambda1$1 INSTANCE = new ComposableSingletons$LazyGridItemProviderKt$lambda1$1();

    public ComposableSingletons$LazyGridItemProviderKt$lambda1$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyGridIntervalContent) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull LazyGridIntervalContent lazyGridIntervalContent, int i11, @Nullable Composer composer, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(lazyGridIntervalContent, SessionsConfigParameter.SYNC_INTERVAL);
        if ((i12 & 14) == 0) {
            i13 = (composer.changed((Object) lazyGridIntervalContent) ? 4 : 2) | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            i13 |= composer.changed(i11) ? 32 : 16;
        }
        if ((i13 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(637163000, i13, -1, "androidx.compose.foundation.lazy.grid.ComposableSingletons$LazyGridItemProviderKt.lambda-1.<anonymous> (LazyGridItemProvider.kt:86)");
            }
            lazyGridIntervalContent.getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(i11), composer, Integer.valueOf((i13 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
