package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.compose.material.DefaultRadioButtonColors} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.compose.material.DefaultRadioButtonColors} */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0089, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x008b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* renamed from: colors-RGew2ao  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.RadioButtonColors m1352colorsRGew2ao(long r19, long r21, long r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r18 = this;
            r0 = r25
            r1 = 1370708026(0x51b3583a, float:9.6284918E10)
            r0.startReplaceableGroup(r1)
            r1 = r27 & 1
            r2 = 6
            if (r1 == 0) goto L_0x0019
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r3 = r1.m1181getSecondary0d7_KjU()
            r6 = r3
            goto L_0x001b
        L_0x0019:
            r6 = r19
        L_0x001b:
            r1 = r27 & 2
            if (r1 == 0) goto L_0x0038
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r8 = r1.m1178getOnSurface0d7_KjU()
            r10 = 1058642330(0x3f19999a, float:0.6)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            long r3 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            r8 = r3
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r1 = r27 & 4
            if (r1 == 0) goto L_0x005b
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r1 = r1.getColors(r0, r2)
            long r10 = r1.m1178getOnSurface0d7_KjU()
            androidx.compose.material.ContentAlpha r1 = androidx.compose.material.ContentAlpha.INSTANCE
            float r12 = r1.getDisabled(r0, r2)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 14
            r17 = 0
            long r1 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r10, r12, r13, r14, r15, r16, r17)
            r10 = r1
            goto L_0x005d
        L_0x005b:
            r10 = r23
        L_0x005d:
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m2909boximpl(r6)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r10)
            r4 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r4)
            boolean r1 = r0.changed((java.lang.Object) r1)
            boolean r2 = r0.changed((java.lang.Object) r2)
            r1 = r1 | r2
            boolean r2 = r0.changed((java.lang.Object) r3)
            r1 = r1 | r2
            java.lang.Object r2 = r25.rememberedValue()
            if (r1 != 0) goto L_0x008b
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0095
        L_0x008b:
            androidx.compose.material.DefaultRadioButtonColors r2 = new androidx.compose.material.DefaultRadioButtonColors
            r12 = 0
            r5 = r2
            r5.<init>(r6, r8, r10, r12)
            r0.updateRememberedValue(r2)
        L_0x0095:
            r25.endReplaceableGroup()
            androidx.compose.material.DefaultRadioButtonColors r2 = (androidx.compose.material.DefaultRadioButtonColors) r2
            r25.endReplaceableGroup()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.RadioButtonDefaults.m1352colorsRGew2ao(long, long, long, androidx.compose.runtime.Composer, int, int):androidx.compose.material.RadioButtonColors");
    }
}
