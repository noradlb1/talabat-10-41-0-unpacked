package com.talabat.helpcenter.domain.usecases;

import androidx.lifecycle.LiveData;
import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0003H\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/talabat/helpcenter/domain/usecases/UnreadMessagesLiveData;", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "", "e", "f", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/helpcenter/domain/usecases/GetUnreadMessagesUseCase;", "unreadMessagesUseCase", "Lcom/talabat/helpcenter/domain/usecases/GetUnreadMessagesUseCase;", "", "unreadChatMessagesEnabled", "Z", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/talabat/helpcenter/domain/usecases/GetUnreadMessagesUseCase;Z)V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0})
public final class UnreadMessagesLiveData extends LiveData<UnreadChatMessages> {
    @NotNull
    private final CoroutineScope coroutineScope;
    @Nullable
    private Job job;
    private final boolean unreadChatMessagesEnabled;
    /* access modifiers changed from: private */
    @NotNull
    public final GetUnreadMessagesUseCase unreadMessagesUseCase;

    public UnreadMessagesLiveData(@NotNull CoroutineScope coroutineScope2, @NotNull GetUnreadMessagesUseCase getUnreadMessagesUseCase, boolean z11) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(getUnreadMessagesUseCase, "unreadMessagesUseCase");
        this.coroutineScope = coroutineScope2;
        this.unreadMessagesUseCase = getUnreadMessagesUseCase;
        this.unreadChatMessagesEnabled = z11;
    }

    public void e() {
        super.e();
        if (this.unreadChatMessagesEnabled) {
            this.job = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UnreadMessagesLiveData$onActive$1(this, (Continuation<? super UnreadMessagesLiveData$onActive$1>) null), 3, (Object) null);
        }
    }

    public void f() {
        super.f();
        Job job2 = this.job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }
}
