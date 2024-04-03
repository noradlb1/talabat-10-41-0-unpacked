package com.designsystem.ds_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32409g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32410h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32411i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32412j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarActionButtonModel f32413k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32414l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32415m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32416n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarWithActionButtonKt$DSNavigationBarWithActionButton$2(Modifier modifier, String str, String str2, DSIconButtonModel dSIconButtonModel, DSNavigationBarActionButtonModel dSNavigationBarActionButtonModel, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11, int i12) {
        super(2);
        this.f32409g = modifier;
        this.f32410h = str;
        this.f32411i = str2;
        this.f32412j = dSIconButtonModel;
        this.f32413k = dSNavigationBarActionButtonModel;
        this.f32414l = dSNavigationBarAnimationBehaviour;
        this.f32415m = i11;
        this.f32416n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSNavigationBarWithActionButtonKt.DSNavigationBarWithActionButton(this.f32409g, this.f32410h, this.f32411i, this.f32412j, this.f32413k, this.f32414l, composer, this.f32415m | 1, this.f32416n);
    }
}
