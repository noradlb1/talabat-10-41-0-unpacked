package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3650g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3651h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f3652i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$drawSelectionHandle$1(boolean z11, ResolvedTextDirection resolvedTextDirection, boolean z12) {
        super(3);
        this.f3650g = z11;
        this.f3651h = resolvedTextDirection;
        this.f3652i = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006d, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x006f;
     */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r11, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1538687176(0xffffffffa4497f38, float:-4.3692686E-17)
            r12.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0017
            r1 = -1
            java.lang.String r2 = "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:112)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r13, r1, r2)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            java.lang.Object r13 = r12.consume(r13)
            androidx.compose.foundation.text.selection.TextSelectionColors r13 = (androidx.compose.foundation.text.selection.TextSelectionColors) r13
            long r1 = r13.m1074getHandleColor0d7_KjU()
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            r0 = 4
            java.lang.Object[] r3 = new java.lang.Object[r0]
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m2909boximpl(r1)
            r5 = 0
            r3[r5] = r4
            boolean r4 = r10.f3650g
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r6 = 1
            r3[r6] = r4
            r4 = 2
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r10.f3651h
            r3[r4] = r6
            boolean r4 = r10.f3652i
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r6 = 3
            r3[r6] = r4
            boolean r4 = r10.f3650g
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r10.f3651h
            boolean r7 = r10.f3652i
            r8 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r12.startReplaceableGroup(r8)
            r8 = r5
        L_0x0055:
            if (r5 >= r0) goto L_0x0061
            r9 = r3[r5]
            boolean r9 = r12.changed((java.lang.Object) r9)
            r8 = r8 | r9
            int r5 = r5 + 1
            goto L_0x0055
        L_0x0061:
            java.lang.Object r0 = r12.rememberedValue()
            if (r8 != 0) goto L_0x006f
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r0 != r3) goto L_0x007b
        L_0x006f:
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 r8 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
            r0 = r8
            r3 = r4
            r4 = r6
            r5 = r7
            r0.<init>(r1, r3, r4, r5)
            r12.updateRememberedValue(r8)
        L_0x007b:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.draw.DrawModifierKt.drawWithCache(r13, r0)
            androidx.compose.ui.Modifier r11 = r11.then(r13)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x0091
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0091:
            r12.endReplaceableGroup()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
