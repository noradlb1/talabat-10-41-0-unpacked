package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.ImageMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;", "", "trackCameraLaunchedEvent", "", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackGalleryLaunchedEvent", "trackGridLaunchedEvent", "trackImageSelectedEvent", "imageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/ImageMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackImageUploadCanceledEvent", "trackImageUploadedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageEventsTracker {
    @Nullable
    Object trackCameraLaunchedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackGalleryLaunchedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackGridLaunchedEvent(@NotNull EventMetadata eventMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackImageSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull ImageMetadata imageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackImageUploadCanceledEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackImageUploadedEvent(@NotNull EventMetadata eventMetadata, @Nullable ImageMetadata imageMetadata, @NotNull Continuation<? super Unit> continuation);
}
