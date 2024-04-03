package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidMenu_androidKt$DropdownMenuItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3868g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3869h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3870i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3871j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3872k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3873l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f3874m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3875n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenuItem$2(Function0<Unit> function0, Modifier modifier, boolean z11, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f3868g = function0;
        this.f3869h = modifier;
        this.f3870i = z11;
        this.f3871j = paddingValues;
        this.f3872k = mutableInteractionSource;
        this.f3873l = function3;
        this.f3874m = i11;
        this.f3875n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidMenu_androidKt.DropdownMenuItem(this.f3868g, this.f3869h, this.f3870i, this.f3871j, this.f3872k, this.f3873l, composer, this.f3874m | 1, this.f3875n);
    }
}
