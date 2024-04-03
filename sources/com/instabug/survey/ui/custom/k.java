package com.instabug.survey.ui.custom;

import android.content.res.Resources;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.ResourcesUtils;
import com.instabug.survey.R;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

public final class k implements l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final j f52499a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final View f52500b;

    public k(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "ratingView");
        this.f52499a = jVar;
        this.f52500b = jVar;
    }

    private final String a(Resources resources, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        sb2.append(' ');
        sb2.append(b(resources, i11));
        sb2.append(" of 5 ");
        sb2.append(ResourcesUtils.getSelectedText(resources, ((float) i11) <= this.f52499a.getRating()));
        return sb2.toString();
    }

    private final String b(Resources resources, int i11) {
        String string = resources.getString(i11 == 1 ? R.string.ib_star : R.string.ib_stars);
        Intrinsics.checkNotNullExpressionValue(string, "if (position == 1)\n     …String(R.string.ib_stars)");
        return string;
    }

    public int a(float f11, float f12) {
        return this.f52499a.a(f11, f12);
    }

    @NotNull
    public List a() {
        return CollectionsKt___CollectionsKt.toList(new IntRange(1, 5));
    }

    public void a(int i11) {
        this.f52499a.a((float) i11, true);
        Resources resources = b().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        AccessibilityUtils.sendTextEvent(a(resources, i11));
    }

    public void a(int i11, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
        Resources resources = b().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        accessibilityNodeInfoCompat.setText(a(resources, i11));
        accessibilityNodeInfoCompat.setBoundsInParent(this.f52499a.a(i11));
    }

    @NotNull
    public View b() {
        return this.f52500b;
    }
}
