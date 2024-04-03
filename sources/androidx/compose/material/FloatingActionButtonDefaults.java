package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    @Composable
    /* renamed from: elevation-ixp7dh8  reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1273elevationixp7dh8(float f11, float f12, Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-654132828);
        if ((i12 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 6);
        }
        float f13 = f11;
        if ((i12 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 12);
        }
        float f14 = (float) 8;
        FloatingActionButtonElevation r11 = m1274elevationxZ9QkE(f13, f12, Dp.m5478constructorimpl(f14), Dp.m5478constructorimpl(f14), composer, (i11 & 14) | 3456 | (i11 & 112) | (57344 & (i11 << 6)), 0);
        composer.endReplaceableGroup();
        return r11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: androidx.compose.material.DefaultFloatingActionButtonElevation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.material.DefaultFloatingActionButtonElevation} */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0073;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* renamed from: elevation-xZ9-QkE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.FloatingActionButtonElevation m1274elevationxZ9QkE(float r7, float r8, float r9, float r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r6 = this;
            r12 = 380403812(0x16ac8064, float:2.7869125E-25)
            r11.startReplaceableGroup(r12)
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0010
            r7 = 6
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
        L_0x0010:
            r1 = r7
            r7 = r13 & 2
            if (r7 == 0) goto L_0x001c
            r7 = 12
            float r7 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
        L_0x001c:
            r2 = r8
            r7 = r13 & 4
            r8 = 8
            if (r7 == 0) goto L_0x0028
            float r7 = (float) r8
            float r9 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
        L_0x0028:
            r3 = r9
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0032
            float r7 = (float) r8
            float r10 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r7)
        L_0x0032:
            r4 = r10
            r7 = 4
            java.lang.Object[] r8 = new java.lang.Object[r7]
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r1)
            r10 = 0
            r8[r10] = r9
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r2)
            r12 = 1
            r8[r12] = r9
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m5476boximpl(r3)
            r12 = 2
            r8[r12] = r9
            r9 = 3
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m5476boximpl(r4)
            r8[r9] = r12
            r9 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r11.startReplaceableGroup(r9)
            r9 = r10
        L_0x0059:
            if (r10 >= r7) goto L_0x0065
            r12 = r8[r10]
            boolean r12 = r11.changed((java.lang.Object) r12)
            r9 = r9 | r12
            int r10 = r10 + 1
            goto L_0x0059
        L_0x0065:
            java.lang.Object r7 = r11.rememberedValue()
            if (r9 != 0) goto L_0x0073
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x007d
        L_0x0073:
            androidx.compose.material.DefaultFloatingActionButtonElevation r7 = new androidx.compose.material.DefaultFloatingActionButtonElevation
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r11.updateRememberedValue(r7)
        L_0x007d:
            r11.endReplaceableGroup()
            androidx.compose.material.DefaultFloatingActionButtonElevation r7 = (androidx.compose.material.DefaultFloatingActionButtonElevation) r7
            r11.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.FloatingActionButtonDefaults.m1274elevationxZ9QkE(float, float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material.FloatingActionButtonElevation");
    }
}
