package com.designsystem.extensions;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$Tab;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TabLayoutExtensionsKt$onTab$3 extends Lambda implements Function1<TabLayout.Tab, Unit> {
    public static final TabLayoutExtensionsKt$onTab$3 INSTANCE = new TabLayoutExtensionsKt$onTab$3();

    public TabLayoutExtensionsKt$onTab$3() {
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
