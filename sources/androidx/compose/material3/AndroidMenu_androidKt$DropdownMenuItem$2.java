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
public final class AndroidMenu_androidKt$DropdownMenuItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6356g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6357h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6358i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6359j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6360k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f6361l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MenuItemColors f6362m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6363n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6364o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f6365p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6366q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidMenu_androidKt$DropdownMenuItem$2(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, boolean z11, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6356g = function2;
        this.f6357h = function0;
        this.f6358i = modifier;
        this.f6359j = function22;
        this.f6360k = function23;
        this.f6361l = z11;
        this.f6362m = menuItemColors;
        this.f6363n = paddingValues;
        this.f6364o = mutableInteractionSource;
        this.f6365p = i11;
        this.f6366q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidMenu_androidKt.DropdownMenuItem(this.f6356g, this.f6357h, this.f6358i, this.f6359j, this.f6360k, this.f6361l, this.f6362m, this.f6363n, this.f6364o, composer, this.f6365p | 1, this.f6366q);
    }
}
