package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Stable
public final class PlatformRipple extends Ripple {
    private PlatformRipple(boolean z11, float f11, State<Color> state) {
        super(z11, f11, state, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ PlatformRipple(boolean z11, float f11, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, state);
    }

    @Composable
    private final ViewGroup findNearestViewGroup(Composer composer, int i11) {
        composer.startReplaceableGroup(-1737891121);
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        while (!(consume instanceof ViewGroup)) {
            ViewParent parent = ((View) consume).getParent();
            if (parent instanceof View) {
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                consume = parent;
            } else {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        composer.endReplaceableGroup();
        return viewGroup;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b2, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004b, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x004d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.material.ripple.RippleIndicationInstance m1476rememberUpdatedRippleInstance942rkJo(@org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.InteractionSource r12, boolean r13, float r14, @org.jetbrains.annotations.NotNull androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r15, @org.jetbrains.annotations.NotNull androidx.compose.runtime.State<androidx.compose.material.ripple.RippleAlpha> r16, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r17, int r18) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r17
            java.lang.String r3 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r3)
            java.lang.String r3 = "color"
            r7 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
            java.lang.String r3 = "rippleAlpha"
            r8 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r3)
            r3 = 331259447(0x13be9e37, float:4.8118755E-27)
            r2.startReplaceableGroup(r3)
            int r3 = r18 >> 15
            r3 = r3 & 14
            android.view.ViewGroup r3 = r11.findNearestViewGroup(r2, r3)
            r4 = 1643267286(0x61f244d6, float:5.5863403E20)
            r2.startReplaceableGroup(r4)
            boolean r4 = r3.isInEditMode()
            if (r4 == 0) goto L_0x0068
            r3 = -3686552(0xffffffffffc7bf68, float:NaN)
            r2.startReplaceableGroup(r3)
            boolean r1 = r2.changed((java.lang.Object) r12)
            boolean r3 = r2.changed((java.lang.Object) r11)
            r1 = r1 | r3
            java.lang.Object r3 = r17.rememberedValue()
            if (r1 != 0) goto L_0x004d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x005c
        L_0x004d:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r3 = new androidx.compose.material.ripple.CommonRippleIndicationInstance
            r9 = 0
            r4 = r3
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r4.<init>(r5, r6, r7, r8, r9)
            r2.updateRememberedValue(r3)
        L_0x005c:
            r17.endReplaceableGroup()
            androidx.compose.material.ripple.CommonRippleIndicationInstance r3 = (androidx.compose.material.ripple.CommonRippleIndicationInstance) r3
            r17.endReplaceableGroup()
            r17.endReplaceableGroup()
            return r3
        L_0x0068:
            r17.endReplaceableGroup()
            int r4 = r3.getChildCount()
            r5 = 0
        L_0x0070:
            if (r5 >= r4) goto L_0x007e
            android.view.View r6 = r3.getChildAt(r5)
            boolean r9 = r6 instanceof androidx.compose.material.ripple.RippleContainer
            if (r9 == 0) goto L_0x007b
            goto L_0x007f
        L_0x007b:
            int r5 = r5 + 1
            goto L_0x0070
        L_0x007e:
            r6 = 0
        L_0x007f:
            if (r6 != 0) goto L_0x0092
            androidx.compose.material.ripple.RippleContainer r6 = new androidx.compose.material.ripple.RippleContainer
            android.content.Context r4 = r3.getContext()
            java.lang.String r5 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r6.<init>(r4)
            r3.addView(r6)
        L_0x0092:
            r3 = -3686095(0xffffffffffc7c131, float:NaN)
            r2.startReplaceableGroup(r3)
            boolean r1 = r2.changed((java.lang.Object) r12)
            boolean r3 = r2.changed((java.lang.Object) r11)
            r1 = r1 | r3
            boolean r3 = r2.changed((java.lang.Object) r6)
            r1 = r1 | r3
            java.lang.Object r3 = r17.rememberedValue()
            if (r1 != 0) goto L_0x00b4
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x00c6
        L_0x00b4:
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r3 = new androidx.compose.material.ripple.AndroidRippleIndicationInstance
            r9 = r6
            androidx.compose.material.ripple.RippleContainer r9 = (androidx.compose.material.ripple.RippleContainer) r9
            r10 = 0
            r4 = r3
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r2.updateRememberedValue(r3)
        L_0x00c6:
            r17.endReplaceableGroup()
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r3 = (androidx.compose.material.ripple.AndroidRippleIndicationInstance) r3
            r17.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.PlatformRipple.m1476rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource, boolean, float, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):androidx.compose.material.ripple.RippleIndicationInstance");
    }
}
