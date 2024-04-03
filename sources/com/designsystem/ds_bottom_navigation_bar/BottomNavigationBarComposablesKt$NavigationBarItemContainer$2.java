package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$NavigationBarItemContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30555g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30556h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSBottomNavigationBarItem f30557i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<DSBottomNavigationBarItem, Unit> f30558j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f30559k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30560l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$NavigationBarItemContainer$2(Modifier modifier, boolean z11, DSBottomNavigationBarItem dSBottomNavigationBarItem, Function1<? super DSBottomNavigationBarItem, Unit> function1, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f30555g = modifier;
        this.f30556h = z11;
        this.f30557i = dSBottomNavigationBarItem;
        this.f30558j = function1;
        this.f30559k = function3;
        this.f30560l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationBarComposablesKt.NavigationBarItemContainer(this.f30555g, this.f30556h, this.f30557i, this.f30558j, this.f30559k, composer, this.f30560l | 1);
    }
}
