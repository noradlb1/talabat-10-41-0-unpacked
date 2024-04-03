package com.designsystem.ds_button_v2.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30845g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30846h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30847i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30848j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function4<Boolean, MutableInteractionSource, Composer, Integer, Unit> f30849k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30850l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30851m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$3(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, boolean z13, Function4<? super Boolean, ? super MutableInteractionSource, ? super Composer, ? super Integer, Unit> function4, int i11, int i12) {
        super(2);
        this.f30845g = dSButtonTheme;
        this.f30846h = z11;
        this.f30847i = z12;
        this.f30848j = z13;
        this.f30849k = function4;
        this.f30850l = i11;
        this.f30851m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(this.f30845g, this.f30846h, this.f30847i, this.f30848j, this.f30849k, composer, this.f30850l | 1, this.f30851m);
    }
}
