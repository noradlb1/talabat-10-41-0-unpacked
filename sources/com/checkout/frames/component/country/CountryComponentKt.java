package com.checkout.frames.component.country;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"CountryComponent", "", "style", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "injector", "Lcom/checkout/frames/di/base/Injector;", "onCountryUpdated", "Lkotlin/Function1;", "Lcom/checkout/base/model/Country;", "Lkotlin/ParameterName;", "name", "country", "goToCountryPicker", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/component/CountryComponentStyle;Lcom/checkout/frames/di/base/Injector;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CountryComponentKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CountryComponent(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CountryComponentStyle r17, @org.jetbrains.annotations.NotNull com.checkout.frames.di.base.Injector r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.checkout.base.model.Country, kotlin.Unit> r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22) {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "injector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onCountryUpdated"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "goToCountryPicker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -2049692069(0xffffffff85d42e5b, float:-1.9953412E-35)
            r5 = r21
            androidx.compose.runtime.Composer r0 = r5.startRestartGroup(r0)
            com.checkout.frames.component.country.CountryViewModel$Factory r8 = new com.checkout.frames.component.country.CountryViewModel$Factory
            r8.<init>(r2, r1)
            r5 = 1729797275(0x671a9c9b, float:7.301333E23)
            r0.startReplaceableGroup(r5)
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r5 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r6 = 6
            androidx.lifecycle.ViewModelStoreOwner r6 = r5.getCurrent(r0, r6)
            if (r6 == 0) goto L_0x0101
            r7 = 0
            boolean r5 = r6 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r5 == 0) goto L_0x004c
            r5 = r6
            androidx.lifecycle.HasDefaultViewModelProviderFactory r5 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r5
            androidx.lifecycle.viewmodel.CreationExtras r5 = r5.getDefaultViewModelCreationExtras()
            java.lang.String r9 = "{\n        viewModelStore…ModelCreationExtras\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            goto L_0x004e
        L_0x004c:
            androidx.lifecycle.viewmodel.CreationExtras$Empty r5 = androidx.lifecycle.viewmodel.CreationExtras.Empty.INSTANCE
        L_0x004e:
            r9 = r5
            java.lang.Class<com.checkout.frames.component.country.CountryViewModel> r5 = com.checkout.frames.component.country.CountryViewModel.class
            r11 = 36936(0x9048, float:5.1758E-41)
            r12 = 0
            r10 = r0
            androidx.lifecycle.ViewModel r5 = androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(r5, r6, r7, r8, r9, r10, r11, r12)
            r0.endReplaceableGroup()
            com.checkout.frames.component.country.CountryViewModel r5 = (com.checkout.frames.component.country.CountryViewModel) r5
            r5.prepare(r3)
            r6 = -1053076354(0xffffffffc13b547e, float:-11.708128)
            r0.startReplaceableGroup(r6)
            com.checkout.frames.style.view.InputComponentViewStyle r6 = r5.getComponentStyle()
            com.checkout.frames.style.view.InputFieldViewStyle r6 = r6.getInputFieldStyle()
            androidx.compose.ui.Modifier r7 = r6.getModifier()
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r8)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r9.getEmpty()
            if (r8 != r10) goto L_0x008d
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r8)
        L_0x008d:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = (androidx.compose.foundation.interaction.MutableInteractionSource) r8
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r14)
            boolean r14 = r0.changed((java.lang.Object) r4)
            java.lang.Object r15 = r0.rememberedValue()
            if (r14 != 0) goto L_0x00ac
            java.lang.Object r9 = r9.getEmpty()
            if (r15 != r9) goto L_0x00b4
        L_0x00ac:
            com.checkout.frames.component.country.CountryComponentKt$CountryComponent$1$2$1 r15 = new com.checkout.frames.component.country.CountryComponentKt$CountryComponent$1$2$1
            r15.<init>(r4)
            r0.updateRememberedValue(r15)
        L_0x00b4:
            r0.endReplaceableGroup()
            r14 = r15
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r15 = 28
            r16 = 0
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r16
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r6.setModifier(r7)
            r0.endReplaceableGroup()
            com.checkout.frames.style.view.InputComponentViewStyle r6 = r5.getComponentStyle()
            com.checkout.frames.component.base.InputComponentState r7 = r5.getComponentState()
            r8 = 0
            com.checkout.frames.component.country.CountryComponentKt$CountryComponent$2 r9 = com.checkout.frames.component.country.CountryComponentKt$CountryComponent$2.INSTANCE
            r10 = 3080(0xc08, float:4.316E-42)
            r11 = 4
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r0
            com.checkout.frames.component.base.InputComponentKt.InputComponent(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00ed
            goto L_0x0100
        L_0x00ed:
            com.checkout.frames.component.country.CountryComponentKt$CountryComponent$3 r7 = new com.checkout.frames.component.country.CountryComponentKt$CountryComponent$3
            r0 = r7
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x0100:
            return
        L_0x0101:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.component.country.CountryComponentKt.CountryComponent(com.checkout.frames.style.component.CountryComponentStyle, com.checkout.frames.di.base.Injector, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }
}
