package com.designsystem.ds_bottom_navigation_bar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBottomNavigationBar$Content$3 extends Lambda implements Function1<DSBottomNavigationBarItem, Unit> {
    public static final DSBottomNavigationBar$Content$3 INSTANCE = new DSBottomNavigationBar$Content$3();

    public DSBottomNavigationBar$Content$3() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DSBottomNavigationBarItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DSBottomNavigationBarItem dSBottomNavigationBarItem) {
        Intrinsics.checkNotNullParameter(dSBottomNavigationBarItem, "it");
    }
}
