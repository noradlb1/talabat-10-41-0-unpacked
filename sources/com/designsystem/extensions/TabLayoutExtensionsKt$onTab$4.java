package com.designsystem.extensions;

import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/designsystem/extensions/TabLayoutExtensionsKt$onTab$4", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TabLayoutExtensionsKt$onTab$4 implements TabLayout.OnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<TabLayout.Tab, Unit> f33290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<TabLayout.Tab, Unit> f33291b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<TabLayout.Tab, Unit> f33292c;

    public TabLayoutExtensionsKt$onTab$4(Function1<? super TabLayout.Tab, Unit> function1, Function1<? super TabLayout.Tab, Unit> function12, Function1<? super TabLayout.Tab, Unit> function13) {
        this.f33290a = function1;
        this.f33291b = function12;
        this.f33292c = function13;
    }

    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.f33291b.invoke(tab);
    }

    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.f33290a.invoke(tab);
    }

    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.f33292c.invoke(tab);
    }
}
