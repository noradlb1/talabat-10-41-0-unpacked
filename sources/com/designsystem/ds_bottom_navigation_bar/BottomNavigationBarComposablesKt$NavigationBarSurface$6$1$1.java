package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$1 extends Lambda implements Function1<DSBottomNavigationBarItem, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<DSBottomNavigationBarItem> f30561g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<DSBottomNavigationBarItem, Unit> f30562h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f30563i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$1(List<DSBottomNavigationBarItem> list, Function1<? super DSBottomNavigationBarItem, Unit> function1, MutableState<Integer> mutableState) {
        super(1);
        this.f30561g = list;
        this.f30562h = function1;
        this.f30563i = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSBottomNavigationBarItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSBottomNavigationBarItem dSBottomNavigationBarItem) {
        Intrinsics.checkNotNullParameter(dSBottomNavigationBarItem, "newSelectedItem");
        BottomNavigationBarComposablesKt.m8253NavigationBarSurface$lambda7(this.f30563i, BottomNavigationBarComposablesKt.indexOfOrFirst(this.f30561g, dSBottomNavigationBarItem));
        this.f30562h.invoke(dSBottomNavigationBarItem);
    }
}
