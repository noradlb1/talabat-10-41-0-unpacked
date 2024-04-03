package com.designsystem.ds_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarKt$DSNavigationBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32398g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32399h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32400i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32401j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32402k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32403l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32404m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32405n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarKt$DSNavigationBar$2(Modifier modifier, String str, String str2, DSIconButtonModel dSIconButtonModel, Function2<? super Composer, ? super Integer, Unit> function2, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11, int i12) {
        super(2);
        this.f32398g = modifier;
        this.f32399h = str;
        this.f32400i = str2;
        this.f32401j = dSIconButtonModel;
        this.f32402k = function2;
        this.f32403l = dSNavigationBarAnimationBehaviour;
        this.f32404m = i11;
        this.f32405n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSNavigationBarKt.DSNavigationBar(this.f32398g, this.f32399h, this.f32400i, this.f32401j, this.f32402k, this.f32403l, composer, this.f32404m | 1, this.f32405n);
    }
}
