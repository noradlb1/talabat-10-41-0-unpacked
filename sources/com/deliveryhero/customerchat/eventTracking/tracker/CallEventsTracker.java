package com.deliveryhero.customerchat.eventTracking.tracker;

import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/CallEventsTracker;", "", "trackInAppCallButtonClicked", "", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "callMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "(Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackInAppCallButtonShown", "trackInAppCallCancelled", "trackInAppCallEnded", "trackInAppCallErrorCaused", "trackInAppCallMuteButtonClicked", "trackInAppCallPickedUp", "trackInAppCallRejected", "trackInAppCallRingStarted", "trackInAppCallSpeakerButtonClicked", "trackInAppCallSurveyDisplayed", "trackInAppCallSurveySubmitted", "trackInAppCallTimedOut", "trackInAppCallUserRegistered", "trackTraditionalCallButtonClicked", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CallEventsTracker {
    @Nullable
    Object trackInAppCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallButtonShown(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallCancelled(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallEnded(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallErrorCaused(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallMuteButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallPickedUp(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallRejected(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallRingStarted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallSpeakerButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallSurveyDisplayed(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallSurveySubmitted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallTimedOut(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackInAppCallUserRegistered(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object trackTraditionalCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata, @NotNull Continuation<? super Unit> continuation);
}
