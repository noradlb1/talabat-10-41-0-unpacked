package com.talabat.helpcenter.domain.repository;

import com.talabat.helpcenter.domain.entity.UnreadChatMessages;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/helpcenter/domain/repository/UnreadChatMessagesRepository;", "", "getUnreadMessages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/helpcenter/domain/entity/UnreadChatMessages;", "token", "", "isActive", "", "setActive", "", "active", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UnreadChatMessagesRepository {
    @NotNull
    Flow<UnreadChatMessages> getUnreadMessages(@NotNull String str);

    boolean isActive();

    @Nullable
    Object setActive(boolean z11, @NotNull Continuation<? super Unit> continuation);
}
