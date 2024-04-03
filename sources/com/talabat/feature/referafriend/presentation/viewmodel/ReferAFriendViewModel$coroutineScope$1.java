package com.talabat.feature.referafriend.presentation.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/talabat/feature/referafriend/presentation/viewmodel/ReferAFriendViewModel$coroutineScope$1", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "job", "Lkotlinx/coroutines/CompletableJob;", "com_talabat_feature_refer-a-friend_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReferAFriendViewModel$coroutineScope$1 implements CoroutineScope {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReferAFriendViewModel f58735b;
    @NotNull
    private final CompletableJob job = JobKt.Job$default((Job) null, 1, (Object) null);

    public ReferAFriendViewModel$coroutineScope$1(ReferAFriendViewModel referAFriendViewModel) {
        this.f58735b = referAFriendViewModel;
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.job.plus(this.f58735b.getCoroutineDispatchersFactory().io());
    }
}
