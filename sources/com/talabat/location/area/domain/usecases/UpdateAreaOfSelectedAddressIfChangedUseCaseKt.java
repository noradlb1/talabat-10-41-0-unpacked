package com.talabat.location.area.domain.usecases;

import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxCompletableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"updateAreaOfSelectedAddressIfChangedCompletable", "Lio/reactivex/Completable;", "Lcom/talabat/location/area/domain/usecases/UpdateAreaOfSelectedAddressIfChangedUseCase;", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseKt {
    @NotNull
    public static final Completable updateAreaOfSelectedAddressIfChangedCompletable(@NotNull UpdateAreaOfSelectedAddressIfChangedUseCase updateAreaOfSelectedAddressIfChangedUseCase) {
        Intrinsics.checkNotNullParameter(updateAreaOfSelectedAddressIfChangedUseCase, "<this>");
        return RxCompletableKt.rxCompletable$default((CoroutineContext) null, new UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1(updateAreaOfSelectedAddressIfChangedUseCase, (Continuation<? super UpdateAreaOfSelectedAddressIfChangedUseCaseKt$updateAreaOfSelectedAddressIfChangedCompletable$1>) null), 1, (Object) null);
    }
}
