package com.instabug.survey.ui.custom;

import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b extends ExploreByTouchHelper {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final l f52439a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f52440b = LazyKt__LazyJVMKt.lazy(new a(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@NotNull l lVar) {
        super(lVar.b());
        Intrinsics.checkNotNullParameter(lVar, "provider");
        this.f52439a = lVar;
    }

    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat a() {
        return (AccessibilityNodeInfoCompat.AccessibilityActionCompat) this.f52440b.getValue();
    }

    public int getVirtualViewAt(float f11, float f12) {
        return this.f52439a.a(f11, f12);
    }

    public void getVisibleVirtualViews(@Nullable List list) {
        if (list != null) {
            list.addAll(this.f52439a.a());
        }
    }

    public boolean onPerformActionForVirtualView(int i11, int i12, @Nullable Bundle bundle) {
        if (i12 != 16) {
            return false;
        }
        this.f52439a.a(i11);
        return true;
    }

    public void onPopulateNodeForVirtualView(int i11, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "node");
        this.f52439a.a(i11, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(a());
        accessibilityNodeInfoCompat.setImportantForAccessibility(true);
        accessibilityNodeInfoCompat.setFocusable(true);
    }
}
