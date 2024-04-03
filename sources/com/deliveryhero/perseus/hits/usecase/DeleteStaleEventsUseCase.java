package com.deliveryhero.perseus.hits.usecase;

import com.deliveryhero.perseus.data.local.PerseusHitsLocalDataStore;
import io.reactivex.Single;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import x5.a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/perseus/hits/usecase/DeleteStaleEventsUseCase;", "", "localDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;", "(Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;)V", "deleteStaleEvents", "Lio/reactivex/Single;", "", "currentTime", "Ljava/util/Calendar;", "retentionTime", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeleteStaleEventsUseCase {
    @NotNull
    private final PerseusHitsLocalDataStore localDataStore;

    public DeleteStaleEventsUseCase(@NotNull PerseusHitsLocalDataStore perseusHitsLocalDataStore) {
        Intrinsics.checkNotNullParameter(perseusHitsLocalDataStore, "localDataStore");
        this.localDataStore = perseusHitsLocalDataStore;
    }

    /* access modifiers changed from: private */
    public static final Integer deleteStaleEvents$lambda$0(DeleteStaleEventsUseCase deleteStaleEventsUseCase, Calendar calendar) {
        Intrinsics.checkNotNullParameter(deleteStaleEventsUseCase, "this$0");
        Intrinsics.checkNotNullParameter(calendar, "$today");
        return Integer.valueOf(deleteStaleEventsUseCase.localDataStore.deleteEventsOlderThan(calendar.getTimeInMillis()));
    }

    @NotNull
    public final Single<Integer> deleteStaleEvents(@NotNull Calendar calendar, int i11) {
        Intrinsics.checkNotNullParameter(calendar, "currentTime");
        Object clone = calendar.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone;
        calendar2.add(5, i11 * -1);
        Single<Integer> fromCallable = Single.fromCallable(new a(this, calendar2));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable { localData…han(today.timeInMillis) }");
        return fromCallable;
    }
}
