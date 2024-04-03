package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
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
public final class MenuKt$DropdownMenuContent$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f4676g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f4677h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4679j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4680k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4681l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuContent$3(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4676g = mutableTransitionState;
        this.f4677h = mutableState;
        this.f4678i = modifier;
        this.f4679j = function3;
        this.f4680k = i11;
        this.f4681l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MenuKt.DropdownMenuContent(this.f4676g, this.f4677h, this.f4678i, this.f4679j, composer, this.f4680k | 1, this.f4681l);
    }
}
