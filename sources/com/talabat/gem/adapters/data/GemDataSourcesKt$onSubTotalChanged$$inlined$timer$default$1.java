package com.talabat.gem.adapters.data;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemDataSourcesKt$onSubTotalChanged$$inlined$timer$default$1 extends TimerTask {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.DoubleRef f59868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f59869c;

    public GemDataSourcesKt$onSubTotalChanged$$inlined$timer$default$1(Ref.DoubleRef doubleRef, Function1 function1) {
        this.f59868b = doubleRef;
        this.f59869c = function1;
    }

    public void run() {
        boolean z11;
        double subTotalAmount = GemDataSourcesKt.subTotalAmount();
        Ref.DoubleRef doubleRef = this.f59868b;
        if (doubleRef.element == subTotalAmount) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            doubleRef.element = subTotalAmount;
            this.f59869c.invoke(Double.valueOf(subTotalAmount));
        }
    }
}
