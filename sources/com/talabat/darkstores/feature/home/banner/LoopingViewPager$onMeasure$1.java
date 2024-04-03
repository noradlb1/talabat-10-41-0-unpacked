package com.talabat.darkstores.feature.home.banner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "w", "", "h", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoopingViewPager$onMeasure$1 extends Lambda implements Function2<Integer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoopingViewPager f56432g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoopingViewPager$onMeasure$1(LoopingViewPager loopingViewPager) {
        super(2);
        this.f56432g = loopingViewPager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11, int i12) {
        LoopingViewPager$onMeasure$1.super.onMeasure(i11, i12);
    }
}
