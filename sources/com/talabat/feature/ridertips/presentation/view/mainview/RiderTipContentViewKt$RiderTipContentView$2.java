package com.talabat.feature.ridertips.presentation.view.mainview;

import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipContentViewKt$RiderTipContentView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58845g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RiderTipDisplayModel f58846h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Boolean, Unit> f58847i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58848j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f58849k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58850l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58851m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f58852n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f58853o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipContentViewKt$RiderTipContentView$2(Function0<Unit> function0, RiderTipDisplayModel riderTipDisplayModel, Function2<? super Integer, ? super Boolean, Unit> function2, Function0<Unit> function02, Function1<? super String, Unit> function1, Function0<Unit> function03, Function0<Unit> function04, boolean z11, int i11) {
        super(2);
        this.f58845g = function0;
        this.f58846h = riderTipDisplayModel;
        this.f58847i = function2;
        this.f58848j = function02;
        this.f58849k = function1;
        this.f58850l = function03;
        this.f58851m = function04;
        this.f58852n = z11;
        this.f58853o = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RiderTipContentViewKt.RiderTipContentView(this.f58845g, this.f58846h, this.f58847i, this.f58848j, this.f58849k, this.f58850l, this.f58851m, this.f58852n, composer, this.f58853o | 1);
    }
}
