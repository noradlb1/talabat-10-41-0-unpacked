package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.data.ErrorMessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.MessageMetadata;
import com.deliveryhero.customerchat.eventTracking.data.TranslationMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J!\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "", "trackErrorSendingMessageEvent", "", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "errorMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/ErrorMessageMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackMessageDeliveredEvent", "messageMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackMessageQuickResponseSelectedEvent", "trackMessageSentEvent", "trackTranslationActivatedEvent", "translationMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/TranslationMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackTranslationDeactivatedEvent", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MessageEventsTracker {
    @Nullable
    Object trackErrorSendingMessageEvent(@NotNull EventMetadata eventMetadata, @NotNull ErrorMessageMetadata errorMessageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackMessageDeliveredEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackMessageQuickResponseSelectedEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackMessageSentEvent(@NotNull EventMetadata eventMetadata, @NotNull MessageMetadata messageMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackTranslationActivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackTranslationDeactivatedEvent(@NotNull EventMetadata eventMetadata, @NotNull TranslationMetadata translationMetadata, @NotNull Continuation<? super Unit> continuation);
}
