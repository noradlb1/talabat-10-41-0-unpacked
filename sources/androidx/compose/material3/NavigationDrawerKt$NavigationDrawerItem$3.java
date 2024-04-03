package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$NavigationDrawerItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7514g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f7515h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7516i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f7517j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7518k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7519l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Shape f7520m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ NavigationDrawerItemColors f7521n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7522o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7523p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7524q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$NavigationDrawerItem$3(Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f7514g = function2;
        this.f7515h = z11;
        this.f7516i = function0;
        this.f7517j = modifier;
        this.f7518k = function22;
        this.f7519l = function23;
        this.f7520m = shape;
        this.f7521n = navigationDrawerItemColors;
        this.f7522o = mutableInteractionSource;
        this.f7523p = i11;
        this.f7524q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationDrawerKt.NavigationDrawerItem(this.f7514g, this.f7515h, this.f7516i, this.f7517j, this.f7518k, this.f7519l, this.f7520m, this.f7521n, this.f7522o, composer, this.f7523p | 1, this.f7524q);
    }
}
