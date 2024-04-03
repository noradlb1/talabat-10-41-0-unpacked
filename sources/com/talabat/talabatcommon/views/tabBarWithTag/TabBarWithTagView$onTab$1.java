package com.talabat.talabatcommon.views.tabBarWithTag;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/google/android/material/tabs/TabLayout$Tab;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabBarWithTagView$onTab$1 extends Lambda implements Function1<TabLayout.Tab, Unit> {
    public static final TabBarWithTagView$onTab$1 INSTANCE = new TabBarWithTagView$onTab$1();

    public TabBarWithTagView$onTab$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TabLayout.Tab) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "it");
    }
}
