package com.deliveryhero.chatsdk.factory;

import com.deliveryhero.chatsdk.Channel;
import com.deliveryhero.chatsdk.ChannelListener;
import com.deliveryhero.chatsdk.domain.ChannelImpl;
import com.deliveryhero.chatsdk.domain.HTTPRepository;
import com.deliveryhero.chatsdk.domain.SocketRepository;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatsdk/factory/ChannelFactory;", "", "()V", "createChannel", "Lcom/deliveryhero/chatsdk/Channel;", "channelId", "", "socketRepository", "Lcom/deliveryhero/chatsdk/domain/SocketRepository;", "httpRepository", "Lcom/deliveryhero/chatsdk/domain/HTTPRepository;", "listener", "Lcom/deliveryhero/chatsdk/ChannelListener;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChannelFactory {
    @NotNull
    public static final ChannelFactory INSTANCE = new ChannelFactory();

    private ChannelFactory() {
    }

    @NotNull
    public final Channel createChannel(@NotNull String str, @NotNull SocketRepository socketRepository, @NotNull HTTPRepository hTTPRepository, @NotNull ChannelListener channelListener) {
        Intrinsics.checkNotNullParameter(str, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(socketRepository, "socketRepository");
        Intrinsics.checkNotNullParameter(hTTPRepository, "httpRepository");
        Intrinsics.checkNotNullParameter(channelListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ChannelImpl(str, socketRepository, hTTPRepository, channelListener);
    }
}
