package com.designsystem.ds_fixed_footer;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class FixedFooterComposablesKt$FixedFooterCard$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31241g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31242h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f31243i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f31244j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31245k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedFooterComposablesKt$FixedFooterCard$3(Modifier modifier, boolean z11, boolean z12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f31241g = modifier;
        this.f31242h = z11;
        this.f31243i = z12;
        this.f31244j = function3;
        this.f31245k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        FixedFooterComposablesKt.FixedFooterCard(this.f31241g, this.f31242h, this.f31243i, this.f31244j, composer, this.f31245k | 1);
    }
}
