package com.designsystem.ds_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32421g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32422h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32423i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32424j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List<DSIconButtonModel> f32425k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32426l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f32427m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32428n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$2(Modifier modifier, String str, String str2, DSIconButtonModel dSIconButtonModel, List<DSIconButtonModel> list, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11, int i12) {
        super(2);
        this.f32421g = modifier;
        this.f32422h = str;
        this.f32423i = str2;
        this.f32424j = dSIconButtonModel;
        this.f32425k = list;
        this.f32426l = dSNavigationBarAnimationBehaviour;
        this.f32427m = i11;
        this.f32428n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSNavigationBarWithIconButtonsKt.DSNavigationBarWithIconButtons(this.f32421g, this.f32422h, this.f32423i, this.f32424j, this.f32425k, this.f32426l, composer, this.f32427m | 1, this.f32428n);
    }
}
