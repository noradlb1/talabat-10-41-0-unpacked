package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithVerticalButtonsKt$DSFixedFooterWithVerticalButtons$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31231g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31232h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31233i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<Function2<Composer, Integer, Unit>> f31234j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31235k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31236l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithVerticalButtonsKt$DSFixedFooterWithVerticalButtons$1(Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, int i11, int i12) {
        super(2);
        this.f31231g = modifier;
        this.f31232h = z11;
        this.f31233i = function2;
        this.f31234j = list;
        this.f31235k = i11;
        this.f31236l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSFixedFooterWithVerticalButtonsKt.DSFixedFooterWithVerticalButtons(this.f31231g, this.f31232h, this.f31233i, this.f31234j, composer, this.f31235k | 1, this.f31236l);
    }
}
