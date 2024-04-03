package com.instabug.survey.ui.custom;

import android.content.res.Resources;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.ResourcesUtils;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class c implements l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e f52441a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final View f52442b;

    public c(@NotNull e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "npsView");
        this.f52441a = eVar;
        this.f52442b = eVar;
    }

    private final String b(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        sb2.append(' ');
        Resources resources = this.f52441a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "npsView.resources");
        sb2.append(ResourcesUtils.getSelectedText(resources, i11 == this.f52441a.getScore()));
        return sb2.toString();
    }

    public int a(float f11, float f12) {
        return this.f52441a.a(f11, f12);
    }

    @NotNull
    public List a() {
        return CollectionsKt___CollectionsKt.toList(new IntRange(0, 10));
    }

    public void a(int i11) {
        this.f52441a.a(i11, true);
        AccessibilityUtils.sendTextEvent(b(i11));
    }

    public void a(int i11, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
        accessibilityNodeInfoCompat.setText(b(i11));
        accessibilityNodeInfoCompat.setBoundsInParent(this.f52441a.a(i11));
    }

    @NotNull
    public View b() {
        return this.f52442b;
    }
}
