package com.talabat.gem.adapters.data;

import buisnessmodels.Cart;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a*\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0007\u001a\b\u0010\n\u001a\u00020\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*\n\u0010\u000b\"\u00020\u00032\u00020\u0003¨\u0006\f"}, d2 = {"TICK_INTERVAL_MILLIS", "", "onSubTotalChanged", "Ljava/util/Timer;", "Lcom/talabat/gem/adapters/data/SubTotalChangeObserver;", "intervalMillis", "onUpdated", "Lkotlin/Function1;", "", "", "subTotalAmount", "SubTotalChangeObserver", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemDataSourcesKt {
    private static final long TICK_INTERVAL_MILLIS = 500;

    @NotNull
    @GemDataSource
    public static final Timer onSubTotalChanged(long j11, @NotNull Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onUpdated");
        Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        double subTotalAmount = subTotalAmount();
        doubleRef.element = subTotalAmount;
        function1.invoke(Double.valueOf(subTotalAmount));
        Timer timer = TimersKt.timer((String) null, false);
        timer.schedule(new GemDataSourcesKt$onSubTotalChanged$$inlined$timer$default$1(doubleRef, function1), 0, j11);
        return timer;
    }

    public static /* synthetic */ Timer onSubTotalChanged$default(long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 500;
        }
        return onSubTotalChanged(j11, function1);
    }

    @GemDataSource
    public static final double subTotalAmount() {
        Integer num;
        Integer num2;
        Cart instance = Cart.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        if (restaurant != null) {
            num = Integer.valueOf(restaurant.f13872id);
        } else {
            num = null;
        }
        Restaurant restaurant2 = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant2 != null) {
            num2 = Integer.valueOf(restaurant2.f13872id);
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual((Object) num, (Object) num2)) {
            instance = null;
        }
        if (instance != null) {
            return (double) instance.getCartSubTotal();
        }
        return 0.0d;
    }
}
