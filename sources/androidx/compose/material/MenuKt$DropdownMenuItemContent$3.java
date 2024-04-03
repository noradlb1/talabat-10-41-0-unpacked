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
public final class MenuKt$DropdownMenuItemContent$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4691g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4692h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4693i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f4694j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4695k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4696l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4697m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4698n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuItemContent$3(Function0<Unit> function0, Modifier modifier, boolean z11, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4691g = function0;
        this.f4692h = modifier;
        this.f4693i = z11;
        this.f4694j = paddingValues;
        this.f4695k = mutableInteractionSource;
        this.f4696l = function3;
        this.f4697m = i11;
        this.f4698n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MenuKt.DropdownMenuItemContent(this.f4691g, this.f4692h, this.f4693i, this.f4694j, this.f4695k, this.f4696l, composer, this.f4697m | 1, this.f4698n);
    }
}
