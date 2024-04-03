package com.designsystem.ds_button_v2.composables;

import androidx.compose.runtime.Composer;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSAnimatedShrinkButtonKt$ButtonAnimatedShrinkSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30829g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30830h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f30831i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f30832j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30833k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f30834l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f30835m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSAnimatedShrinkButtonKt$ButtonAnimatedShrinkSurface$1(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, boolean z13, boolean z14, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f30829g = dSButtonTheme;
        this.f30830h = z11;
        this.f30831i = z12;
        this.f30832j = z13;
        this.f30833k = z14;
        this.f30834l = function2;
        this.f30835m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSAnimatedShrinkButtonKt.ButtonAnimatedShrinkSurface(this.f30829g, this.f30830h, this.f30831i, this.f30832j, this.f30833k, this.f30834l, composer, this.f30835m | 1);
    }
}
