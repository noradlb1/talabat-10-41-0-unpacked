package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldScrollKt$textFieldScrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldScrollerPosition f3612g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3613h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3614i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldScrollKt$textFieldScrollable$2(TextFieldScrollerPosition textFieldScrollerPosition, boolean z11, MutableInteractionSource mutableInteractionSource) {
        super(3);
        this.f3612g = textFieldScrollerPosition;
        this.f3613h = z11;
        this.f3614i = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r13, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r14, int r15) {
        /*
            r12 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r13 = 805428266(0x3001dc2a, float:4.72428E-10)
            r14.startReplaceableGroup(r13)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0017
            r0 = -1
            java.lang.String r1 = "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:62)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r15, r0, r1)
        L_0x0017:
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r13 = r14.consume(r13)
            androidx.compose.ui.unit.LayoutDirection r15 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r0 = 1
            r1 = 0
            if (r13 != r15) goto L_0x0027
            r13 = r0
            goto L_0x0028
        L_0x0027:
            r13 = r1
        L_0x0028:
            androidx.compose.foundation.text.TextFieldScrollerPosition r15 = r12.f3612g
            androidx.compose.foundation.gestures.Orientation r15 = r15.getOrientation()
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r15 == r2) goto L_0x0037
            if (r13 != 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r7 = r1
            goto L_0x0038
        L_0x0037:
            r7 = r0
        L_0x0038:
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.f3612g
            r15 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r15)
            boolean r15 = r14.changed((java.lang.Object) r13)
            java.lang.Object r2 = r14.rememberedValue()
            if (r15 != 0) goto L_0x0052
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r2 != r15) goto L_0x005a
        L_0x0052:
            androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1$1 r2 = new androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2$controller$1$1
            r2.<init>(r13)
            r14.updateRememberedValue(r2)
        L_0x005a:
            r14.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.foundation.gestures.ScrollableState r4 = androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState(r2, r14, r1)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.f3612g
            androidx.compose.foundation.gestures.Orientation r5 = r13.getOrientation()
            boolean r13 = r12.f3613h
            if (r13 == 0) goto L_0x0081
            androidx.compose.foundation.text.TextFieldScrollerPosition r13 = r12.f3612g
            float r13 = r13.getMaximum()
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 != 0) goto L_0x007c
            r13 = r0
            goto L_0x007d
        L_0x007c:
            r13 = r1
        L_0x007d:
            if (r13 != 0) goto L_0x0081
            r6 = r0
            goto L_0x0082
        L_0x0081:
            r6 = r1
        L_0x0082:
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r9 = r12.f3614i
            r10 = 16
            r11 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0095
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0095:
            r14.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollKt$textFieldScrollable$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
