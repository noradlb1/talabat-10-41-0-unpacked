package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MenuKt$DropdownMenuItemContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7349g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7350h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7351i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7352j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7353k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f7354l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MenuItemColors f7355m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f7356n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7357o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7358p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuItemContent$2(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z11, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i11) {
        super(2);
        this.f7349g = function2;
        this.f7350h = function0;
        this.f7351i = modifier;
        this.f7352j = function22;
        this.f7353k = function23;
        this.f7354l = z11;
        this.f7355m = menuItemColors;
        this.f7356n = paddingValues;
        this.f7357o = mutableInteractionSource;
        this.f7358p = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MenuKt.DropdownMenuItemContent(this.f7349g, this.f7350h, this.f7351i, this.f7352j, this.f7353k, this.f7354l, this.f7355m, this.f7356n, this.f7357o, composer, this.f7358p | 1);
    }
}
