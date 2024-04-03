package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBarKt$DSBottomNavigationBar$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30578g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<DSBottomNavigationBarItem> f30579h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DSBottomNavigationBarItem f30580i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<DSBottomNavigationBarItem, Unit> f30581j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30582k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBottomNavigationBarKt$DSBottomNavigationBar$1(Modifier modifier, List<DSBottomNavigationBarItem> list, DSBottomNavigationBarItem dSBottomNavigationBarItem, Function1<? super DSBottomNavigationBarItem, Unit> function1, int i11) {
        super(2);
        this.f30578g = modifier;
        this.f30579h = list;
        this.f30580i = dSBottomNavigationBarItem;
        this.f30581j = function1;
        this.f30582k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f30578g;
            List<DSBottomNavigationBarItem> list = this.f30579h;
            DSBottomNavigationBarItem dSBottomNavigationBarItem = this.f30580i;
            Function1<DSBottomNavigationBarItem, Unit> function1 = this.f30581j;
            int i12 = this.f30582k;
            BottomNavigationBarComposablesKt.NavigationBarSurface(modifier, list, dSBottomNavigationBarItem, function1, composer, (i12 & 14) | 64 | (i12 & 896) | (i12 & 7168), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
