package com.designsystem.ds_button_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit> f30841g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f30842h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30843i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f30844j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$2(Function4<? super Boolean, ? super MutableInteractionSource, ? super Composer, ? super Integer, Unit> function4, MutableInteractionSource mutableInteractionSource, int i11, MutableState<Boolean> mutableState) {
        super(2);
        this.f30841g = function4;
        this.f30842h = mutableInteractionSource;
        this.f30843i = i11;
        this.f30844j = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.f30841g.invoke(Boolean.valueOf(DSAnimatedShrinkButtonKt.m8300DSAnimatedShrinkButton$lambda2(this.f30844j)), this.f30842h, composer, Integer.valueOf(((this.f30843i >> 6) & 896) | 48));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
