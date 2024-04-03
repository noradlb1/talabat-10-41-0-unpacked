package com.deliveryhero.contract.configuration;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.location.LocationProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "", "chatLogger", "Lcom/deliveryhero/contract/ChatLogger;", "locationProvider", "Lcom/deliveryhero/contract/location/LocationProvider;", "(Lcom/deliveryhero/contract/ChatLogger;Lcom/deliveryhero/contract/location/LocationProvider;)V", "getChatLogger", "()Lcom/deliveryhero/contract/ChatLogger;", "setChatLogger", "(Lcom/deliveryhero/contract/ChatLogger;)V", "getLocationProvider", "()Lcom/deliveryhero/contract/location/LocationProvider;", "setLocationProvider", "(Lcom/deliveryhero/contract/location/LocationProvider;)V", "apply", "", "configBuilder", "Lcom/deliveryhero/contract/configuration/CustomerChatConfigurationBuilder;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatFeatureCallbacks {
    @Nullable
    private ChatLogger chatLogger;
    @Nullable
    private LocationProvider locationProvider;

    public ChatFeatureCallbacks() {
        this((ChatLogger) null, (LocationProvider) null, 3, (DefaultConstructorMarker) null);
    }

    public ChatFeatureCallbacks(@Nullable ChatLogger chatLogger2, @Nullable LocationProvider locationProvider2) {
        this.chatLogger = chatLogger2;
        this.locationProvider = locationProvider2;
    }

    public final void apply(@NotNull CustomerChatConfigurationBuilder customerChatConfigurationBuilder) {
        Intrinsics.checkNotNullParameter(customerChatConfigurationBuilder, "configBuilder");
        LocationProvider locationProvider2 = customerChatConfigurationBuilder.getLocationProvider();
        if (locationProvider2 == null) {
            locationProvider2 = this.locationProvider;
        }
        this.locationProvider = locationProvider2;
        ChatLogger logger = customerChatConfigurationBuilder.getLogger();
        if (logger == null) {
            logger = this.chatLogger;
        }
        this.chatLogger = logger;
    }

    @Nullable
    public final ChatLogger getChatLogger() {
        return this.chatLogger;
    }

    @Nullable
    public final LocationProvider getLocationProvider() {
        return this.locationProvider;
    }

    public final void setChatLogger(@Nullable ChatLogger chatLogger2) {
        this.chatLogger = chatLogger2;
    }

    public final void setLocationProvider(@Nullable LocationProvider locationProvider2) {
        this.locationProvider = locationProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatFeatureCallbacks(ChatLogger chatLogger2, LocationProvider locationProvider2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : chatLogger2, (i11 & 2) != 0 ? null : locationProvider2);
    }
}
