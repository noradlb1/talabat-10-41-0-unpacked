package com.deliveryhero.customerchat.eventTracking.tracker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/tracker/AnalyticsWrapper;", "", "chatEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;", "imageEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;", "locationEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;", "messageEventsTracker", "Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "(Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;)V", "getChatEventsTracker", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/ChatEventsTracker;", "getImageEventsTracker", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/ImageEventsTracker;", "getLocationEventsTracker", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/LocationEventsTracker;", "getMessageEventsTracker", "()Lcom/deliveryhero/customerchat/eventTracking/tracker/MessageEventsTracker;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsWrapper {
    @NotNull
    private final ChatEventsTracker chatEventsTracker;
    @NotNull
    private final ImageEventsTracker imageEventsTracker;
    @NotNull
    private final LocationEventsTracker locationEventsTracker;
    @NotNull
    private final MessageEventsTracker messageEventsTracker;

    public AnalyticsWrapper(@NotNull ChatEventsTracker chatEventsTracker2, @NotNull ImageEventsTracker imageEventsTracker2, @NotNull LocationEventsTracker locationEventsTracker2, @NotNull MessageEventsTracker messageEventsTracker2) {
        Intrinsics.checkNotNullParameter(chatEventsTracker2, "chatEventsTracker");
        Intrinsics.checkNotNullParameter(imageEventsTracker2, "imageEventsTracker");
        Intrinsics.checkNotNullParameter(locationEventsTracker2, "locationEventsTracker");
        Intrinsics.checkNotNullParameter(messageEventsTracker2, "messageEventsTracker");
        this.chatEventsTracker = chatEventsTracker2;
        this.imageEventsTracker = imageEventsTracker2;
        this.locationEventsTracker = locationEventsTracker2;
        this.messageEventsTracker = messageEventsTracker2;
    }

    public static /* synthetic */ AnalyticsWrapper copy$default(AnalyticsWrapper analyticsWrapper, ChatEventsTracker chatEventsTracker2, ImageEventsTracker imageEventsTracker2, LocationEventsTracker locationEventsTracker2, MessageEventsTracker messageEventsTracker2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            chatEventsTracker2 = analyticsWrapper.chatEventsTracker;
        }
        if ((i11 & 2) != 0) {
            imageEventsTracker2 = analyticsWrapper.imageEventsTracker;
        }
        if ((i11 & 4) != 0) {
            locationEventsTracker2 = analyticsWrapper.locationEventsTracker;
        }
        if ((i11 & 8) != 0) {
            messageEventsTracker2 = analyticsWrapper.messageEventsTracker;
        }
        return analyticsWrapper.copy(chatEventsTracker2, imageEventsTracker2, locationEventsTracker2, messageEventsTracker2);
    }

    @NotNull
    public final ChatEventsTracker component1() {
        return this.chatEventsTracker;
    }

    @NotNull
    public final ImageEventsTracker component2() {
        return this.imageEventsTracker;
    }

    @NotNull
    public final LocationEventsTracker component3() {
        return this.locationEventsTracker;
    }

    @NotNull
    public final MessageEventsTracker component4() {
        return this.messageEventsTracker;
    }

    @NotNull
    public final AnalyticsWrapper copy(@NotNull ChatEventsTracker chatEventsTracker2, @NotNull ImageEventsTracker imageEventsTracker2, @NotNull LocationEventsTracker locationEventsTracker2, @NotNull MessageEventsTracker messageEventsTracker2) {
        Intrinsics.checkNotNullParameter(chatEventsTracker2, "chatEventsTracker");
        Intrinsics.checkNotNullParameter(imageEventsTracker2, "imageEventsTracker");
        Intrinsics.checkNotNullParameter(locationEventsTracker2, "locationEventsTracker");
        Intrinsics.checkNotNullParameter(messageEventsTracker2, "messageEventsTracker");
        return new AnalyticsWrapper(chatEventsTracker2, imageEventsTracker2, locationEventsTracker2, messageEventsTracker2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsWrapper)) {
            return false;
        }
        AnalyticsWrapper analyticsWrapper = (AnalyticsWrapper) obj;
        return Intrinsics.areEqual((Object) this.chatEventsTracker, (Object) analyticsWrapper.chatEventsTracker) && Intrinsics.areEqual((Object) this.imageEventsTracker, (Object) analyticsWrapper.imageEventsTracker) && Intrinsics.areEqual((Object) this.locationEventsTracker, (Object) analyticsWrapper.locationEventsTracker) && Intrinsics.areEqual((Object) this.messageEventsTracker, (Object) analyticsWrapper.messageEventsTracker);
    }

    @NotNull
    public final ChatEventsTracker getChatEventsTracker() {
        return this.chatEventsTracker;
    }

    @NotNull
    public final ImageEventsTracker getImageEventsTracker() {
        return this.imageEventsTracker;
    }

    @NotNull
    public final LocationEventsTracker getLocationEventsTracker() {
        return this.locationEventsTracker;
    }

    @NotNull
    public final MessageEventsTracker getMessageEventsTracker() {
        return this.messageEventsTracker;
    }

    public int hashCode() {
        return (((((this.chatEventsTracker.hashCode() * 31) + this.imageEventsTracker.hashCode()) * 31) + this.locationEventsTracker.hashCode()) * 31) + this.messageEventsTracker.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnalyticsWrapper(chatEventsTracker=" + this.chatEventsTracker + ", imageEventsTracker=" + this.imageEventsTracker + ", locationEventsTracker=" + this.locationEventsTracker + ", messageEventsTracker=" + this.messageEventsTracker + ')';
    }
}
