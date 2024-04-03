package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.analytics.model.Contact;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.model.Product;
import com.deliveryhero.customerchat.analytics.model.User;
import com.deliveryhero.customerchat.eventTracking.data.CallMetadata;
import com.deliveryhero.customerchat.eventTracking.data.EventMetadata;
import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import com.deliveryhero.customerchat.eventTracking.factory.EventsFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/factory/CallEventsFactory;", "Lcom/deliveryhero/customerchat/eventTracking/factory/EventsFactory;", "createInAppCallButtonClicked", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "eventMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/EventMetadata;", "callMetadata", "Lcom/deliveryhero/customerchat/eventTracking/data/CallMetadata;", "createInAppCallButtonShown", "createInAppCallCancelled", "createInAppCallEnded", "createInAppCallErrorCaused", "createInAppCallMuteButtonClicked", "createInAppCallPickedUp", "createInAppCallRejected", "createInAppCallRingStarted", "createInAppCallSpeakerButtonClicked", "createInAppCallSurveyDisplayed", "createInAppCallSurveySubmitted", "createInAppCallTimedOut", "createInAppCallUserRegistered", "createTraditionalCallButtonClicked", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CallEventsFactory extends EventsFactory {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Contact createContactObject(@NotNull CallEventsFactory callEventsFactory, @NotNull EventMetadata eventMetadata) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createContactObject(callEventsFactory, eventMetadata);
        }

        @NotNull
        public static Product createProductObject(@NotNull CallEventsFactory callEventsFactory, @Nullable UserProperties userProperties) {
            return EventsFactory.DefaultImpls.createProductObject(callEventsFactory, userProperties);
        }

        @NotNull
        public static User createUserObject(@NotNull CallEventsFactory callEventsFactory, @NotNull EventMetadata eventMetadata, @Nullable UserProperties userProperties) {
            Intrinsics.checkNotNullParameter(eventMetadata, "eventMetadata");
            return EventsFactory.DefaultImpls.createUserObject(callEventsFactory, eventMetadata, userProperties);
        }
    }

    @NotNull
    EventCreationRequest createInAppCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallButtonShown(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallCancelled(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallEnded(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallErrorCaused(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallMuteButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallPickedUp(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallRejected(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallRingStarted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallSpeakerButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallSurveyDisplayed(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallSurveySubmitted(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallTimedOut(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createInAppCallUserRegistered(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);

    @NotNull
    EventCreationRequest createTraditionalCallButtonClicked(@NotNull EventMetadata eventMetadata, @NotNull CallMetadata callMetadata);
}
