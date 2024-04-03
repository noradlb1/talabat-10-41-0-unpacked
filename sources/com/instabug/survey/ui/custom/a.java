package com.instabug.survey.ui.custom;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.instabug.survey.R;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class a extends Lambda implements Function0 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ b f52438g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(0);
        this.f52438g = bVar;
    }

    @NotNull
    /* renamed from: a */
    public final AccessibilityNodeInfoCompat.AccessibilityActionCompat invoke() {
        String string = this.f52438g.f52439a.b().getResources().getString(R.string.ib_action_select);
        Intrinsics.checkNotNullExpressionValue(string, "provider.view.resources.….string.ib_action_select)");
        return new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, string);
    }
}
