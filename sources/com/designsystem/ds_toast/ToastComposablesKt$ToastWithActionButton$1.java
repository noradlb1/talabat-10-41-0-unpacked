package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastWithActionButton$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33268g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33269h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f33270i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastWithActionButton$1(Function0<Unit> function0, int i11, String str) {
        super(2);
        this.f33268g = function0;
        this.f33269h = i11;
        this.f33270i = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r2 = r27
            r1 = r28 & 11
            r1 = r1 ^ 2
            if (r1 != 0) goto L_0x0016
            boolean r1 = r27.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r27.skipToGroupEnd()
            goto L_0x00af
        L_0x0016:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r10 = 0
            com.designsystem.ds_theme.DSDimens r4 = r1.getDimens(r2, r10)
            float r6 = r4.m8842getDsSD9Ej5fM()
            com.designsystem.ds_theme.DSDimens r4 = r1.getDimens(r2, r10)
            float r4 = r4.m8844getDsXsD9Ej5fM()
            r5 = 0
            r7 = 0
            r8 = 10
            r9 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.foundation.interaction.MutableInteractionSource r12 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.f33268g
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r2.startReplaceableGroup(r4)
            boolean r4 = r2.changed((java.lang.Object) r3)
            java.lang.Object r5 = r27.rememberedValue()
            if (r4 != 0) goto L_0x0057
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x005f
        L_0x0057:
            com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$1$1$1 r5 = new com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$1$1$1
            r5.<init>(r3)
            r2.updateRememberedValue(r5)
        L_0x005f:
            r27.endReplaceableGroup()
            r17 = r5
            kotlin.jvm.functions.Function0 r17 = (kotlin.jvm.functions.Function0) r17
            r18 = 28
            r19 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.lang.String r4 = "ToastActionButtonTestTag"
            androidx.compose.ui.Modifier r21 = androidx.compose.ui.platform.TestTagKt.testTag(r3, r4)
            java.lang.String r3 = r0.f33270i
            if (r3 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            java.lang.String r3 = ""
        L_0x007b:
            r25 = r3
            com.designsystem.ds_theme.DSTypography r3 = r1.getTypography(r2, r10)
            androidx.compose.ui.text.TextStyle r20 = r3.getDsLink()
            com.designsystem.ds_theme.DSColors r1 = r1.getColors(r2, r10)
            long r3 = r1.m8774getDsNeutralWhite0d7_KjU()
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 64
            r24 = 32760(0x7ff8, float:4.5907E-41)
            r1 = r25
            r2 = r21
            r21 = r27
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
