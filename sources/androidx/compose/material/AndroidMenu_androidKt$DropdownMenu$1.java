package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidMenu_androidKt$DropdownMenu$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f3854g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f3855h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f3856i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f3857j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3858k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenu$1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f3854g = mutableTransitionState;
        this.f3855h = mutableState;
        this.f3856i = modifier;
        this.f3857j = function3;
        this.f3858k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            MutableTransitionState<Boolean> mutableTransitionState = this.f3854g;
            MutableState<TransformOrigin> mutableState = this.f3855h;
            Modifier modifier = this.f3856i;
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f3857j;
            int i12 = this.f3858k;
            MenuKt.DropdownMenuContent(mutableTransitionState, mutableState, modifier, function3, composer, MutableTransitionState.$stable | 48 | (i12 & 896) | ((i12 >> 6) & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
