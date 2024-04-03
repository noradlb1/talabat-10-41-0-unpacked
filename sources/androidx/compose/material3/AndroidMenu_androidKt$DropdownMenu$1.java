package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
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
public final class AndroidMenu_androidKt$DropdownMenu$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f6342g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f6343h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6344i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6345j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6346k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f6342g = mutableTransitionState;
        this.f6343h = mutableState;
        this.f6344i = modifier;
        this.f6345j = function3;
        this.f6346k = i11;
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
                ComposerKt.traceEventStart(-1192563503, i11, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
            }
            MutableTransitionState<Boolean> mutableTransitionState = this.f6342g;
            MutableState<TransformOrigin> mutableState = this.f6343h;
            Modifier modifier = this.f6344i;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f6345j;
            int i12 = this.f6346k;
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, modifier, function3, composer, MutableTransitionState.$stable | 48 | (i12 & 896) | ((i12 >> 6) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
