package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"paint", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PainterModifierKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.ui.draw.PainterModifierKt$paint$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.ui.draw.PainterModifierKt$paint$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier paint(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r9, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.painter.Painter r10, boolean r11, @org.jetbrains.annotations.NotNull androidx.compose.ui.Alignment r12, @org.jetbrains.annotations.NotNull androidx.compose.ui.layout.ContentScale r13, float r14, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.ColorFilter r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "painter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "alignment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "contentScale"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.ui.draw.PainterModifier r0 = new androidx.compose.ui.draw.PainterModifier
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x0029
            androidx.compose.ui.draw.PainterModifierKt$paint$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.ui.draw.PainterModifierKt$paint$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L_0x002d
        L_0x0029:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x002d:
            r8 = r1
            r1 = r0
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier r9 = r9.then(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.PainterModifierKt.paint(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, boolean, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter):androidx.compose.ui.Modifier");
    }

    public static /* synthetic */ Modifier paint$default(Modifier modifier, Painter painter, boolean z11, Alignment alignment, ContentScale contentScale, float f11, ColorFilter colorFilter, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i11 & 4) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i11 & 8) != 0) {
            contentScale = ContentScale.Companion.getInside();
        }
        ContentScale contentScale2 = contentScale;
        if ((i11 & 16) != 0) {
            f11 = 1.0f;
        }
        float f12 = f11;
        if ((i11 & 32) != 0) {
            colorFilter = null;
        }
        return paint(modifier, painter, z12, alignment2, contentScale2, f12, colorFilter);
    }
}
