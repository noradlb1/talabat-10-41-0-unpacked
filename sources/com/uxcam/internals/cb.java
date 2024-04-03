package com.uxcam.internals;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import org.jetbrains.annotations.NotNull;

public final class cb {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final View f13108a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Rect f13109b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final WindowManager.LayoutParams f13110c;

    public cb(@NotNull View view, @NotNull Rect rect, @NotNull WindowManager.LayoutParams layoutParams) {
        this.f13108a = view;
        this.f13109b = rect;
        this.f13110c = layoutParams;
    }
}
