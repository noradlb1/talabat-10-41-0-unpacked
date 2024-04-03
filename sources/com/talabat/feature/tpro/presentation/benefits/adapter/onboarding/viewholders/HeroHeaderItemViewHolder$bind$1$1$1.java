package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.viewholders;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HeroHeaderItemViewHolder$bind$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f59261g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ HeroHeaderItemViewHolder f59262h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeroHeaderItemViewHolder$bind$1$1$1(Function1<? super Integer, Unit> function1, HeroHeaderItemViewHolder heroHeaderItemViewHolder) {
        super(0);
        this.f59261g = function1;
        this.f59262h = heroHeaderItemViewHolder;
    }

    public final void invoke() {
        this.f59261g.invoke(Integer.valueOf(this.f59262h.getLayoutPosition()));
    }
}
