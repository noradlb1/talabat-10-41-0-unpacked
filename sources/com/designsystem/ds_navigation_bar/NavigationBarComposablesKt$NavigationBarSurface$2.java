package com.designsystem.ds_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt$NavigationBarSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32445g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32446h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f32447i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32448j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<Dp, Composer, Integer, Unit> f32449k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32450l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Float f32451m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Float f32452n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f32453o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarComposablesKt$NavigationBarSurface$2(String str, String str2, Modifier modifier, DSIconButtonModel dSIconButtonModel, Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, Float f11, Float f12, int i11) {
        super(2);
        this.f32445g = str;
        this.f32446h = str2;
        this.f32447i = modifier;
        this.f32448j = dSIconButtonModel;
        this.f32449k = function3;
        this.f32450l = dSNavigationBarAnimationBehaviour;
        this.f32451m = f11;
        this.f32452n = f12;
        this.f32453o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationBarComposablesKt.NavigationBarSurface(this.f32445g, this.f32446h, this.f32447i, this.f32448j, this.f32449k, this.f32450l, this.f32451m, this.f32452n, composer, this.f32453o | 1);
    }
}
