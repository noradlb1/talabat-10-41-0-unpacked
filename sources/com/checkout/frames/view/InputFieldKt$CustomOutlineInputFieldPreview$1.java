package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$CustomOutlineInputFieldPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$CustomOutlineInputFieldPreview$1(MutableState<String> mutableState) {
        super(2);
        this.$text = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36) {
        /*
            r34 = this;
            r0 = r34
            r5 = r35
            r1 = r36 & 11
            r2 = 2
            if (r1 != r2) goto L_0x0015
            boolean r1 = r35.getSkipping()
            if (r1 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r35.skipToGroupEnd()
            goto L_0x009b
        L_0x0015:
            com.checkout.frames.style.view.InputFieldViewStyle r1 = new com.checkout.frames.style.view.InputFieldViewStyle
            r6 = r1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r3 = 1
            r4 = 0
            r7 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r2, r7, r3, r4)
            r3 = 56
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r2, r3)
            r8 = 0
            r9 = 0
            r10 = 0
            com.checkout.frames.view.ComposableSingletons$InputFieldKt r2 = com.checkout.frames.view.ComposableSingletons$InputFieldKt.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r2.m9330getLambda3$frames_release()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            androidx.compose.ui.graphics.Shape r19 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 126958(0x1efee, float:1.77906E-40)
            r25 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            com.checkout.frames.view.InputFieldState r2 = new com.checkout.frames.view.InputFieldState
            androidx.compose.runtime.MutableState<java.lang.String> r3 = r0.$text
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 30
            r33 = 0
            r26 = r2
            r27 = r3
            r26.<init>(r27, r28, r29, r30, r31, r32, r33)
            r3 = 0
            androidx.compose.runtime.MutableState<java.lang.String> r4 = r0.$text
            r6 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r6)
            boolean r6 = r5.changed((java.lang.Object) r4)
            java.lang.Object r7 = r35.rememberedValue()
            if (r6 != 0) goto L_0x0085
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x008d
        L_0x0085:
            com.checkout.frames.view.InputFieldKt$CustomOutlineInputFieldPreview$1$1$1 r7 = new com.checkout.frames.view.InputFieldKt$CustomOutlineInputFieldPreview$1$1$1
            r7.<init>(r4)
            r5.updateRememberedValue(r7)
        L_0x008d:
            r35.endReplaceableGroup()
            r4 = r7
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r6 = 8
            r7 = 4
            r5 = r35
            com.checkout.frames.view.InputFieldKt.InputField(r1, r2, r3, r4, r5, r6, r7)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.view.InputFieldKt$CustomOutlineInputFieldPreview$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
