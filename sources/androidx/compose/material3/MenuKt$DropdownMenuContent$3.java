package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MenuKt$DropdownMenuContent$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f7327g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<TransformOrigin> f7328h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7329i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7330j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7331k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7332l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuContent$3(MutableTransitionState<Boolean> mutableTransitionState, MutableState<TransformOrigin> mutableState, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7327g = mutableTransitionState;
        this.f7328h = mutableState;
        this.f7329i = modifier;
        this.f7330j = function3;
        this.f7331k = i11;
        this.f7332l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MenuKt.DropdownMenuContent(this.f7327g, this.f7328h, this.f7329i, this.f7330j, composer, this.f7331k | 1, this.f7332l);
    }
}
