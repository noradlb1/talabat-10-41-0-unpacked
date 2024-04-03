package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckboxDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: androidx.compose.material.DefaultCheckboxColors} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: androidx.compose.material.DefaultCheckboxColors} */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00eb, code lost:
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00ed;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.CheckboxColors m1144colorszjMxDiM(long r30, long r32, long r34, long r36, long r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r29 = this;
            r0 = r40
            r1 = 469524104(0x1bfc5e88, float:4.1750992E-22)
            r0.startReplaceableGroup(r1)
            r1 = r42 & 1
            r2 = 6
            if (r1 == 0) goto L_0x001a
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1181getSecondary0d7_KjU()
            r20 = r3
            goto L_0x001c
        L_0x001a:
            r20 = r30
        L_0x001c:
            r1 = r42 & 2
            if (r1 == 0) goto L_0x003a
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1178getOnSurface0d7_KjU()
            r5 = 1058642330(0x3f19999a, float:0.6)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 14
            r10 = 0
            long r3 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r3, r5, r6, r7, r8, r9, r10)
            r22 = r3
            goto L_0x003c
        L_0x003a:
            r22 = r32
        L_0x003c:
            r1 = r42 & 4
            if (r1 == 0) goto L_0x004c
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1183getSurface0d7_KjU()
            r6 = r3
            goto L_0x004e
        L_0x004c:
            r6 = r34
        L_0x004e:
            r1 = r42 & 8
            if (r1 == 0) goto L_0x007d
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1178getOnSurface0d7_KjU()
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r1 = r1.getDisabled(r0, r2)
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 14
            r11 = 0
            r30 = r3
            r32 = r1
            r33 = r5
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r11
            long r3 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r24 = r3
            goto L_0x007f
        L_0x007d:
            r24 = r36
        L_0x007f:
            r1 = r42 & 16
            if (r1 == 0) goto L_0x00a4
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r1 = r1.getDisabled(r0, r2)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r8 = 0
            r30 = r20
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r8
            long r1 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r26 = r1
            goto L_0x00a6
        L_0x00a4:
            r26 = r38
        L_0x00a6:
            r1 = 5
            java.lang.Object[] r2 = new java.lang.Object[r1]
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r20)
            r4 = 0
            r2[r4] = r3
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r22)
            r5 = 1
            r2[r5] = r3
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r6)
            r5 = 2
            r2[r5] = r3
            r3 = 3
            androidx.compose.ui.graphics.Color r5 = androidx.compose.ui.graphics.Color.m2909boximpl(r24)
            r2[r3] = r5
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r26)
            r5 = 4
            r2[r5] = r3
            r3 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r3)
            r3 = r4
        L_0x00d3:
            if (r4 >= r1) goto L_0x00df
            r5 = r2[r4]
            boolean r5 = r0.changed((java.lang.Object) r5)
            r3 = r3 | r5
            int r4 = r4 + 1
            goto L_0x00d3
        L_0x00df:
            java.lang.Object r1 = r40.rememberedValue()
            if (r3 != 0) goto L_0x00ed
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0126
        L_0x00ed:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 14
            r8 = 0
            r30 = r6
            r32 = r1
            r33 = r2
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r8
            long r8 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r10 = 0
            r30 = r20
            r37 = r10
            long r12 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            r30 = r24
            long r16 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r30, r32, r33, r34, r35, r36, r37)
            androidx.compose.material.DefaultCheckboxColors r1 = new androidx.compose.material.DefaultCheckboxColors
            r5 = r1
            r28 = 0
            r10 = r20
            r14 = r24
            r18 = r26
            r5.<init>(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28)
            r0.updateRememberedValue(r1)
        L_0x0126:
            r40.endReplaceableGroup()
            androidx.compose.material.DefaultCheckboxColors r1 = (androidx.compose.material.DefaultCheckboxColors) r1
            r40.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CheckboxDefaults.m1144colorszjMxDiM(long, long, long, long, long, androidx.compose.runtime.Composer, int, int):androidx.compose.material.CheckboxColors");
    }
}
