package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterKt$DSFixedFooter$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31199g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31200h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31201i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31202j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f31203k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31204l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterKt$DSFixedFooter$2(Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11, int i12) {
        super(2);
        this.f31199g = modifier;
        this.f31200h = z11;
        this.f31201i = function2;
        this.f31202j = function22;
        this.f31203k = i11;
        this.f31204l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSFixedFooterKt.DSFixedFooter(this.f31199g, this.f31200h, this.f31201i, this.f31202j, composer, this.f31203k | 1, this.f31204l);
    }
}
