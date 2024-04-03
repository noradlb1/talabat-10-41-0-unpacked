package com.deliveryhero.customerchat.eventTracking.factory;

import com.deliveryhero.customerchat.eventTracking.data.UserProperties;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/customerchat/eventTracking/data/UserProperties;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatEventsFactoryImpl$userProperties$2 extends Lambda implements Function0<UserProperties> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChatEventsFactoryImpl f29835g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatEventsFactoryImpl$userProperties$2(ChatEventsFactoryImpl chatEventsFactoryImpl) {
        super(0);
        this.f29835g = chatEventsFactoryImpl;
    }

    @Nullable
    public final UserProperties invoke() {
        return this.f29835g.userPropertiesDataStoreHelper.getLatestUserProperties();
    }
}
