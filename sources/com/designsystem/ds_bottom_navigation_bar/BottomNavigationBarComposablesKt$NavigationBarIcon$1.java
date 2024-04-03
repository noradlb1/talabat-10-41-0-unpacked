package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$NavigationBarIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBottomNavigationBarItem f30550g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30551h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30552i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$NavigationBarIcon$1(DSBottomNavigationBarItem dSBottomNavigationBarItem, boolean z11, int i11) {
        super(2);
        this.f30550g = dSBottomNavigationBarItem;
        this.f30551h = z11;
        this.f30552i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationBarComposablesKt.NavigationBarIcon(this.f30550g, this.f30551h, composer, this.f30552i | 1);
    }
}
