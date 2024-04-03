package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;", "", "trackLocationClickedEvent", "", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackLocationPickerLaunchedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocationEventsTracker {
    @Nullable
    Object trackLocationClickedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackLocationPickerLaunchedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);
}
