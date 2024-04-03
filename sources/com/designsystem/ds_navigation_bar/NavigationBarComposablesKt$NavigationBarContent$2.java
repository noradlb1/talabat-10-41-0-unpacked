package com.designsystem.ds_navigation_bar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt$NavigationBarContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f32429g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32430h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RowScope f32431i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32432j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32433k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarComposablesKt$NavigationBarContent$2(String str, String str2, RowScope rowScope, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11) {
        super(2);
        this.f32429g = str;
        this.f32430h = str2;
        this.f32431i = rowScope;
        this.f32432j = dSNavigationBarAnimationBehaviour;
        this.f32433k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationBarComposablesKt.NavigationBarContent(this.f32429g, this.f32430h, this.f32431i, this.f32432j, composer, this.f32433k | 1);
    }
}
