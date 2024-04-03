package com.designsystem.extensions;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\b"}, d2 = {"onTab", "", "Lcom/google/android/material/tabs/TabLayout;", "selected", "Lkotlin/Function1;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "reselected", "unselected", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TabLayoutExtensionsKt {
    public static final void onTab(@NotNull TabLayout tabLayout, @NotNull Function1<? super TabLayout.Tab, Unit> function1, @NotNull Function1<? super TabLayout.Tab, Unit> function12, @NotNull Function1<? super TabLayout.Tab, Unit> function13) {
        Intrinsics.checkNotNullParameter(tabLayout, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selected");
        Intrinsics.checkNotNullParameter(function12, "reselected");
        Intrinsics.checkNotNullParameter(function13, "unselected");
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayoutExtensionsKt$onTab$4(function1, function12, function13));
    }

    public static /* synthetic */ void onTab$default(TabLayout tabLayout, Function1 function1, Function1 function12, Function1 function13, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function1 = TabLayoutExtensionsKt$onTab$1.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            function12 = TabLayoutExtensionsKt$onTab$2.INSTANCE;
        }
        if ((i11 & 4) != 0) {
            function13 = TabLayoutExtensionsKt$onTab$3.INSTANCE;
        }
        onTab(tabLayout, function1, function12, function13);
    }
}
