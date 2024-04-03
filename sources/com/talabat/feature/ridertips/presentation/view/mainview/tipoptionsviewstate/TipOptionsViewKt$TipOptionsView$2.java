package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsViewKt$TipOptionsView$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TipOptionsDetailsDisplayModel f58876g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Boolean, Unit> f58877h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58878i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58879j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f58880k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f58881l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipOptionsViewKt$TipOptionsView$2(TipOptionsDetailsDisplayModel tipOptionsDetailsDisplayModel, Function2<? super Integer, ? super Boolean, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, boolean z11, int i11) {
        super(2);
        this.f58876g = tipOptionsDetailsDisplayModel;
        this.f58877h = function2;
        this.f58878i = function0;
        this.f58879j = function02;
        this.f58880k = z11;
        this.f58881l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TipOptionsViewKt.TipOptionsView(this.f58876g, this.f58877h, this.f58878i, this.f58879j, this.f58880k, composer, this.f58881l | 1);
    }
}
