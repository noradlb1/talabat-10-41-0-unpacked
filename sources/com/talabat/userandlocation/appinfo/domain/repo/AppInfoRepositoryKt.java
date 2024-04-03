package com.talabat.userandlocation.appinfo.domain.repo;

import io.reactivex.Completable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxCompletableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"fetchAppInfoCompletable", "Lio/reactivex/Completable;", "Lcom/talabat/userandlocation/appinfo/domain/repo/AppInfoRepository;", "countryId", "", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AppInfoRepositoryKt {
    @NotNull
    public static final Completable fetchAppInfoCompletable(@NotNull AppInfoRepository appInfoRepository, int i11) {
        Intrinsics.checkNotNullParameter(appInfoRepository, "<this>");
        return RxCompletableKt.rxCompletable$default((CoroutineContext) null, new AppInfoRepositoryKt$fetchAppInfoCompletable$1(appInfoRepository, i11, (Continuation<? super AppInfoRepositoryKt$fetchAppInfoCompletable$1>) null), 1, (Object) null);
    }
}
