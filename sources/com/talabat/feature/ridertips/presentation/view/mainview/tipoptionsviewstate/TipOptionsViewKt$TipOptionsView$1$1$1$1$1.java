package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsViewKt$TipOptionsView$1$1$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f58869g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Boolean, Unit> f58870h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f58871i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TipOptionDisplayModel f58872j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipOptionsViewKt$TipOptionsView$1$1$1$1$1(boolean z11, Function2<? super Integer, ? super Boolean, Unit> function2, int i11, TipOptionDisplayModel tipOptionDisplayModel) {
        super(0);
        this.f58869g = z11;
        this.f58870h = function2;
        this.f58871i = i11;
        this.f58872j = tipOptionDisplayModel;
    }

    public final void invoke() {
        if (!this.f58869g) {
            this.f58870h.invoke(Integer.valueOf(this.f58871i), Boolean.valueOf(!this.f58872j.getSelected()));
        } else if (!this.f58872j.getSelected() || this.f58872j.isCustomTip()) {
            this.f58870h.invoke(Integer.valueOf(this.f58871i), Boolean.valueOf(!this.f58872j.getSelected()));
        }
    }
}
