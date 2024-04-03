package com.talabat.core.flutter.channels.domain.tpro;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/tpro/TProChannelCallback;", "", "getTProConfig", "", "", "arguments", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProStatus", "", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TProChannelCallback {
    @Nullable
    Object getTProConfig(@Nullable Object obj, @NotNull Continuation<? super Map<String, ? extends Object>> continuation);

    @Nullable
    Object updateProStatus(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation);
}
