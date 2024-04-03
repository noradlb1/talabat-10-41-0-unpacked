package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> f2468g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScopeImpl f2469h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f2470i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, int i11) {
        super(2);
        this.f2468g = function3;
        this.f2469h = boxWithConstraintsScopeImpl;
        this.f2470i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945019079, i11, -1, "androidx.compose.foundation.layout.BoxWithConstraints.<anonymous>.<anonymous>.<anonymous> (BoxWithConstraints.kt:68)");
            }
            this.f2468g.invoke(this.f2469h, composer, Integer.valueOf((this.f2470i >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
