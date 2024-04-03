package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31210g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31211h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31212i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List<Function2<Composer, Integer, Unit>> f31213j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<List<? extends Function2<? super Composer, ? super Integer, Unit>>, Composer, Integer, Unit> f31214k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31215l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31216m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$2(Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function3<? super List<? extends Function2<? super Composer, ? super Integer, Unit>>, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f31210g = modifier;
        this.f31211h = z11;
        this.f31212i = function2;
        this.f31213j = list;
        this.f31214k = function3;
        this.f31215l = i11;
        this.f31216m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSFixedFooterWithButtonsKt.DSFixedFooterWithButtons(this.f31210g, this.f31211h, this.f31212i, this.f31213j, this.f31214k, composer, this.f31215l | 1, this.f31216m);
    }
}
