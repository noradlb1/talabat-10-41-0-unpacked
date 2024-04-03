package com.checkout.frames.component.billingaddressfields;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BillingAddressDynamicInputComponent", "", "position", "", "inputComponentViewStyle", "Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "inputComponentState", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "onFocusChanged", "Lkotlin/Function2;", "", "onValueChange", "", "(ILcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDynamicInputComponentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BillingAddressDynamicInputComponent(int r8, @org.jetbrains.annotations.NotNull com.checkout.frames.style.view.BillingAddressInputComponentViewStyle r9, @org.jetbrains.annotations.NotNull com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> r12, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r13, int r14) {
        /*
            java.lang.String r0 = "inputComponentViewStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "inputComponentState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onFocusChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -245877010(0xfffffffff15836ee, float:-1.0706427E30)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            com.checkout.frames.style.view.InputComponentViewStyle r1 = r9.getInputComponentViewStyle()
            com.checkout.frames.component.base.InputComponentState r2 = r10.getInputComponentState()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r13.startReplaceableGroup(r3)
            boolean r4 = r13.changed((java.lang.Object) r11)
            boolean r0 = r13.changed((java.lang.Object) r0)
            r0 = r0 | r4
            java.lang.Object r4 = r13.rememberedValue()
            if (r0 != 0) goto L_0x0044
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r4 != r0) goto L_0x004c
        L_0x0044:
            com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$1$1 r4 = new com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$1$1
            r4.<init>(r11, r8)
            r13.updateRememberedValue(r4)
        L_0x004c:
            r13.endReplaceableGroup()
            r0 = r4
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r13.startReplaceableGroup(r3)
            boolean r3 = r13.changed((java.lang.Object) r12)
            boolean r4 = r13.changed((java.lang.Object) r4)
            r3 = r3 | r4
            java.lang.Object r4 = r13.rememberedValue()
            if (r3 != 0) goto L_0x0070
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0078
        L_0x0070:
            com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$2$1 r4 = new com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$2$1
            r4.<init>(r12, r8)
            r13.updateRememberedValue(r4)
        L_0x0078:
            r13.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r6 = 8
            r7 = 0
            r3 = r0
            r5 = r13
            com.checkout.frames.component.base.InputComponentKt.InputComponent(r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x008c
            goto L_0x009b
        L_0x008c:
            com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$3 r7 = new com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt$BillingAddressDynamicInputComponent$3
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r13.updateScope(r7)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.component.billingaddressfields.BillingAddressDynamicInputComponentKt.BillingAddressDynamicInputComponent(int, com.checkout.frames.style.view.BillingAddressInputComponentViewStyle, com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }
}
