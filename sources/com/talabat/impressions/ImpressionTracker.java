package com.talabat.impressions;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&R0\u0010\u0003\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u0004\u0012\u00020\b0\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/impressions/ImpressionTracker;", "T", "", "onReachLimit", "Lkotlin/Function1;", "", "Lkotlin/Pair;", "", "", "getOnReachLimit", "()Lkotlin/jvm/functions/Function1;", "startTracking", "stopTracking", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImpressionTracker<T> {
    @NotNull
    Function1<List<? extends Pair<Integer, ? extends T>>, Unit> getOnReachLimit();

    void startTracking();

    void stopTracking();
}
