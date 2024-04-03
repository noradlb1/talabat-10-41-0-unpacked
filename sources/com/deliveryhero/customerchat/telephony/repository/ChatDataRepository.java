package com.deliveryhero.customerchat.telephony.repository;

import com.deliveryhero.customerchat.telephony.util.logging.TelephonyLogger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0011\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/repository/ChatDataRepository;", "", "getTelephonyLogger", "Lcom/deliveryhero/customerchat/telephony/util/logging/TelephonyLogger;", "getUserID", "", "shouldClearVOIPCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatDataRepository {
    @NotNull
    TelephonyLogger getTelephonyLogger();

    @NotNull
    String getUserID();

    @Nullable
    Object shouldClearVOIPCache(@NotNull Continuation<? super Boolean> continuation);
}
