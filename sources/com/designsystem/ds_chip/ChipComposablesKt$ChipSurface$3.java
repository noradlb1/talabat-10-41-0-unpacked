package com.designsystem.ds_chip;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ChipComposablesKt$ChipSurface$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30919g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30920h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30921i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f30922j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30923k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f30924l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipComposablesKt$ChipSurface$3(Modifier modifier, boolean z11, Function0<Unit> function0, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f30919g = modifier;
        this.f30920h = z11;
        this.f30921i = function0;
        this.f30922j = function3;
        this.f30923k = i11;
        this.f30924l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipComposablesKt.ChipSurface(this.f30919g, this.f30920h, this.f30921i, this.f30922j, composer, this.f30923k | 1, this.f30924l);
    }
}
