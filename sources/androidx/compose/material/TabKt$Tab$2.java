package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$Tab$2 extends Lambda implements Function3<ColumnScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5734g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5735h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5736i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(3);
        this.f5734g = function2;
        this.f5735h = function22;
        this.f5736i = i11;
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
            TabKt.TabBaselineLayout(this.f5734g, this.f5735h, composer, (this.f5736i >> 12) & 112);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
