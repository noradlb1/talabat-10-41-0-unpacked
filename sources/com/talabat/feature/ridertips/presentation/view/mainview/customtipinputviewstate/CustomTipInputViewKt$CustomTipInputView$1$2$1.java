package com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomTipInputViewKt$CustomTipInputView$1$2$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<FocusRequester> f58855g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTipInputViewKt$CustomTipInputView$1$2$1(MutableState<FocusRequester> mutableState) {
        super(1);
        this.f58855g = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        CustomTipInputViewKt.m10290CustomTipInputView$lambda4$lambda1(this.f58855g).requestFocus();
        return new CustomTipInputViewKt$CustomTipInputView$1$2$1$invoke$$inlined$onDispose$1();
    }
}
