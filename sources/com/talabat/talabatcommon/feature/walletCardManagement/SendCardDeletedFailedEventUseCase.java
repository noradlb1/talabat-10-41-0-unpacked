package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeletedFailedEventUseCase;", "", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "invoke", "", "errorCode", "", "errorMessage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SendCardDeletedFailedEventUseCase {
    @NotNull
    private final CoroutineContext context;
    /* access modifiers changed from: private */
    @NotNull
    public final TalabatTracker tracker;

    public SendCardDeletedFailedEventUseCase(@NotNull TalabatTracker talabatTracker, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        this.tracker = talabatTracker;
        this.context = JobKt.Job$default((Job) null, 1, (Object) null).plus(coroutineDispatchersFactory.io());
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.context, new SendCardDeletedFailedEventUseCase$invoke$2(this, str, str2, (Continuation<? super SendCardDeletedFailedEventUseCase$invoke$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
