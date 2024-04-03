package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f6976g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f6977h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuBoxScope f6978i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f6979j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6980k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f6981l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f6976g = mutableTransitionState;
        this.f6977h = mutableState;
        this.f6978i = exposedDropdownMenuBoxScope;
        this.f6979j = modifier;
        this.f6980k = function3;
        this.f6981l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(395026654, i11, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.<anonymous> (ExposedDropdownMenu.kt:273)");
            }
            MenuKt.DropdownMenuContent(this.f6976g, this.f6977h, ExposedDropdownMenuBoxScope.CC.b(this.f6978i, this.f6979j, false, 1, (Object) null), this.f6980k, composer, MutableTransitionState.$stable | 48 | (this.f6981l & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
