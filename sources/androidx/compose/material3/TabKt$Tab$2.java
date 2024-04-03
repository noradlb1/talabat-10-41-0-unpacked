package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$Tab$2 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8524g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8525h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8526i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(3);
        this.f8524g = function2;
        this.f8525h = function22;
        this.f8526i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull ColumnScope columnScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$Tab");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1540996038, i11, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:118)");
            }
            TabKt.TabBaselineLayout(this.f8524g, this.f8525h, composer, (this.f8526i >> 12) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
