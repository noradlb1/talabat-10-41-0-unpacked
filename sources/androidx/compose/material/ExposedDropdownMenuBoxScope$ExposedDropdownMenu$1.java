package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
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
public final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f4513g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f4514h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuBoxScope f4515i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f4516j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4517k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4518l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuBoxScope$ExposedDropdownMenu$1(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f4513g = mutableTransitionState;
        this.f4514h = mutableState;
        this.f4515i = exposedDropdownMenuBoxScope;
        this.f4516j = modifier;
        this.f4517k = function3;
        this.f4518l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            MenuKt.DropdownMenuContent(this.f4513g, this.f4514h, ExposedDropdownMenuBoxScope.DefaultImpls.exposedDropdownSize$default(this.f4515i, this.f4516j, false, 1, (Object) null), this.f4517k, composer, MutableTransitionState.$stable | 48 | (this.f4518l & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
