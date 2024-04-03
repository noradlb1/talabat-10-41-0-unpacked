package com.talabat.sdsquad.extentions;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a*\u0010\u0006\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"show", "", "Landroid/view/View;", "", "defaultVisibility", "", "showIf", "isVisible", "Lkotlin/Function0;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ViewExtentionsKt {
    @JvmOverloads
    public static final void show(@NotNull View view, boolean z11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        show$default(view, z11, 0, 2, (Object) null);
    }

    @JvmOverloads
    public static final void show(@NotNull View view, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z11) {
            i11 = 0;
        }
        view.setVisibility(i11);
    }

    public static /* synthetic */ void show$default(View view, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 8;
        }
        show(view, z11, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r4.invoke().booleanValue() == true) goto L_0x0016;
     */
    @org.jetbrains.annotations.Nullable
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View showIf(@org.jetbrains.annotations.Nullable android.view.View r2, int r3, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<java.lang.Boolean> r4) {
        /*
            if (r2 != 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x0004:
            r0 = 0
            if (r4 == 0) goto L_0x0015
            java.lang.Object r4 = r4.invoke()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r1 = 1
            if (r4 != r1) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r1 = r0
        L_0x0016:
            if (r1 == 0) goto L_0x0019
            r3 = r0
        L_0x0019:
            r2.setVisibility(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.sdsquad.extentions.ViewExtentionsKt.showIf(android.view.View, int, kotlin.jvm.functions.Function0):android.view.View");
    }

    @Nullable
    @JvmOverloads
    public static final View showIf(@Nullable View view, @Nullable Function0<Boolean> function0) {
        return showIf$default(view, 0, function0, 1, (Object) null);
    }

    public static /* synthetic */ View showIf$default(View view, int i11, Function0 function0, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 8;
        }
        return showIf(view, i11, function0);
    }
}
