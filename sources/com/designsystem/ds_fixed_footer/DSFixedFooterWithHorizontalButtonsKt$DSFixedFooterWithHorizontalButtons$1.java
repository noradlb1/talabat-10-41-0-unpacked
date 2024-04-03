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
public final class DSFixedFooterWithHorizontalButtonsKt$DSFixedFooterWithHorizontalButtons$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31221g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31222h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31223i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<Function2<Composer, Integer, Unit>> f31224j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31225k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31226l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithHorizontalButtonsKt$DSFixedFooterWithHorizontalButtons$1(Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, int i11, int i12) {
        super(2);
        this.f31221g = modifier;
        this.f31222h = z11;
        this.f31223i = function2;
        this.f31224j = list;
        this.f31225k = i11;
        this.f31226l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSFixedFooterWithHorizontalButtonsKt.DSFixedFooterWithHorizontalButtons(this.f31221g, this.f31222h, this.f31223i, this.f31224j, composer, this.f31225k | 1, this.f31226l);
    }
}
