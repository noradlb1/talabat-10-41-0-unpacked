package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowKt$ScrollableTabRow$1 extends Lambda implements Function3<List<? extends TabPosition>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f8583g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$1(int i11) {
        super(3);
        this.f8583g = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<TabPosition>) (List) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull List<TabPosition> list, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(list, "tabPositions");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-913748678, i11, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:227)");
        }
        TabRowDefaults tabRowDefaults = TabRowDefaults.INSTANCE;
        tabRowDefaults.m1891Indicator9IZ8Weo(tabRowDefaults.tabIndicatorOffset(Modifier.Companion, list.get(this.f8583g)), 0.0f, 0, composer, KfsConstant.KFS_RSA_KEY_LEN_3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
