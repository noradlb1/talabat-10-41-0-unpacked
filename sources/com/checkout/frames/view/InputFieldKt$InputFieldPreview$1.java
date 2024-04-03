package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$InputFieldPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$InputFieldPreview$1(MutableState<String> mutableState) {
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
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38) {
        /*
            r36 = this;
            r0 = r36
            r5 = r37
            r1 = r38 & 11
            r2 = 2
            if (r1 != r2) goto L_0x0015
            boolean r1 = r37.getSkipping()
            if (r1 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r37.skipToGroupEnd()
            goto L_0x00b4
        L_0x0015:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r2 = 1
            r3 = 0
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r4, r2, r3)
            r2 = 56
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r1, r2)
            com.checkout.frames.model.InputFieldColors r21 = new com.checkout.frames.model.InputFieldColors
            r20 = r21
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r28 = r1.m2954getTransparent0d7_KjU()
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1983(0x7bf, float:2.779E-42)
            r35 = 0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r34, r35)
            com.checkout.frames.style.view.InputFieldViewStyle r1 = new com.checkout.frames.style.view.InputFieldViewStyle
            r6 = r1
            r8 = 0
            r9 = 0
            r10 = 0
            com.checkout.frames.view.ComposableSingletons$InputFieldKt r2 = com.checkout.frames.view.ComposableSingletons$InputFieldKt.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r2.m9328getLambda1$frames_release()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 122862(0x1dfee, float:1.72166E-40)
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            com.checkout.frames.view.InputFieldState r2 = new com.checkout.frames.view.InputFieldState
            androidx.compose.runtime.MutableState<java.lang.String> r3 = r0.$text
            r28 = 0
            r29 = 0
            r32 = 30
            r26 = r2
            r27 = r3
            r26.<init>(r27, r28, r29, r30, r31, r32, r33)
            r3 = 0
            androidx.compose.runtime.MutableState<java.lang.String> r4 = r0.$text
            r6 = 1157296644(0x44faf204, float:2007.563)
            r5.startReplaceableGroup(r6)
            boolean r6 = r5.changed((java.lang.Object) r4)
            java.lang.Object r7 = r37.rememberedValue()
            if (r6 != 0) goto L_0x009e
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r7 != r6) goto L_0x00a6
        L_0x009e:
            com.checkout.frames.view.InputFieldKt$InputFieldPreview$1$1$1 r7 = new com.checkout.frames.view.InputFieldKt$InputFieldPreview$1$1$1
            r7.<init>(r4)
            r5.updateRememberedValue(r7)
        L_0x00a6:
            r37.endReplaceableGroup()
            r4 = r7
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r6 = 8
            r7 = 4
            r5 = r37
            com.checkout.frames.view.InputFieldKt.InputField(r1, r2, r3, r4, r5, r6, r7)
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.view.InputFieldKt$InputFieldPreview$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
