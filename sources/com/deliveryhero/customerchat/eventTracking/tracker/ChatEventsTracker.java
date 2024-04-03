package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.FeatureFlagProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;", "", "trackChatClientDisconnectedEvent", "", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackChatUiClosedEvent", "trackChatUiOpenedEvent", "trackFeatureFlagSetEvent", "featureFlagProperties", "Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/FeatureFlagProperties;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatEventsTracker {
    @Nullable
    Object trackChatClientDisconnectedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackChatUiClosedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackChatUiOpenedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackFeatureFlagSetEvent(@NotNull EventMetadata eventMetadata, @NotNull FeatureFlagProperties featureFlagProperties, @NotNull Continuation<? super Unit> continuation);
}
