package com.deliveryhero.repository.gccchat;

import android.content.Context;
import com.deliveryhero.chatsdk.domain.model.Config;
import com.deliveryhero.chatsdk.domain.model.MetaData;
import com.deliveryhero.chatsdk.domain.model.messages.AdminMessage;
import com.deliveryhero.chatsdk.domain.model.messages.ChannelFrozenMessage;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage;
import com.deliveryhero.chatsdk.domain.model.messages.ConfigUpdateMessage;
import com.deliveryhero.chatsdk.domain.model.messages.LocationMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import com.deliveryhero.chatsdk.domain.model.messages.TextMessage;
import com.deliveryhero.chatsdk.domain.model.messages.Thumbnail;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.ConfigMessage;
import com.deliveryhero.contract.model.FileMessage;
import com.deliveryhero.contract.model.SenderType;
import com.deliveryhero.contract.model.User;
import com.deliveryhero.customerchat.R;
import com.deliveryhero.customerchat.commons.TimeUtilKt;
import com.deliveryhero.repository.gccchat.model.GccBaseLocationMessage;
import com.deliveryhero.repository.gccchat.model.GccChannelFrozenMessage;
import com.deliveryhero.repository.gccchat.model.GccChatAdminMessage;
import com.deliveryhero.repository.gccchat.model.GccChatConfigMessage;
import com.deliveryhero.repository.gccchat.model.GccChatConfigUpdateMessage;
import com.deliveryhero.repository.gccchat.model.GccChatFileMessage;
import com.deliveryhero.repository.gccchat.model.GccChatUserMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/deliveryhero/repository/gccchat/GccChatMessageToBaseMessageMapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getOrDefaultThumbnail", "", "Lcom/deliveryhero/contract/model/FileMessage$Thumbnail;", "thumbnails", "Lcom/deliveryhero/chatsdk/domain/model/messages/Thumbnail;", "url", "", "map", "Lcom/deliveryhero/contract/model/BaseMessage;", "message", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "messages", "mapAdminMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChatAdminMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/AdminMessage;", "mapChannelFrozenMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChannelFrozenMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/ChannelFrozenMessage;", "mapConfigMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChatConfigMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigMessage;", "mapConfigUpdateMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChatConfigUpdateMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/ConfigUpdateMessage;", "mapFileMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChatFileMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/FileMessage;", "mapLocationMessage", "Lcom/deliveryhero/repository/gccchat/model/GccBaseLocationMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/LocationMessage;", "mapTextMessage", "Lcom/deliveryhero/repository/gccchat/model/GccChatUserMessage;", "Lcom/deliveryhero/chatsdk/domain/model/messages/TextMessage;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatMessageToBaseMessageMapper {
    @NotNull
    private final Context context;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdminMessage.Type.values().length];
            iArr[AdminMessage.Type.JOINED.ordinal()] = 1;
            iArr[AdminMessage.Type.LEFT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GccChatMessageToBaseMessageMapper(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final List<FileMessage.Thumbnail> getOrDefaultThumbnail(List<Thumbnail> list, String str) {
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsJVMKt.listOf(new FileMessage.Thumbnail(str, 200, 200, 200, 200));
        }
        Iterable<Thumbnail> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Thumbnail thumbnail : iterable) {
            arrayList.add(new FileMessage.Thumbnail(thumbnail.getUrl(), thumbnail.getMaxWidth(), thumbnail.getMaxHeight(), thumbnail.getRealWidth(), thumbnail.getRealHeight()));
        }
        return arrayList;
    }

    private final GccChatAdminMessage mapAdminMessage(AdminMessage adminMessage) {
        String str;
        BaseMessage.MetaData metaData;
        String id2 = adminMessage.getId();
        long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(adminMessage.getTimestamp());
        int i11 = WhenMappings.$EnumSwitchMapping$0[adminMessage.getType().ordinal()];
        if (i11 == 1) {
            str = this.context.getString(R.string.customer_chat_user_joined_channel, new Object[]{adminMessage.getUserNickname()});
        } else if (i11 == 2) {
            str = this.context.getString(R.string.customer_chat_user_left_channel, new Object[]{adminMessage.getUserNickname()});
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "when (message.type) {\n  …e\n            )\n        }");
        MetaData metadata = adminMessage.getMetadata();
        if (metadata != null) {
            metaData = new BaseMessage.MetaData(metadata.getUserCount());
        } else {
            metaData = null;
        }
        return new GccChatAdminMessage(id2, convertNanosToMillis, str2, metaData, (String) null, 16, (DefaultConstructorMarker) null);
    }

    private final GccChannelFrozenMessage mapChannelFrozenMessage(ChannelFrozenMessage channelFrozenMessage) {
        return new GccChannelFrozenMessage(channelFrozenMessage.getId(), TimeUtilKt.convertNanosToMillis(channelFrozenMessage.getTimestamp()), (BaseMessage.MetaData) null, (String) null, 12, (DefaultConstructorMarker) null);
    }

    private final GccChatConfigMessage mapConfigMessage(ConfigMessage configMessage) {
        BaseMessage.MetaData metaData;
        String id2 = configMessage.getId();
        long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(configMessage.getTimestamp());
        Iterable<Config> configs = configMessage.getConfigs();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(configs, 10));
        for (Config config : configs) {
            arrayList.add(new ConfigMessage.Config(config.getName(), config.getData()));
        }
        MetaData metadata = configMessage.getMetadata();
        if (metadata != null) {
            metaData = new BaseMessage.MetaData(metadata.getUserCount());
        } else {
            metaData = null;
        }
        return new GccChatConfigMessage(id2, convertNanosToMillis, arrayList, metaData, configMessage.getCorrelationId());
    }

    private final GccChatConfigUpdateMessage mapConfigUpdateMessage(ConfigUpdateMessage configUpdateMessage) {
        return new GccChatConfigUpdateMessage(configUpdateMessage.getId(), TimeUtilKt.convertNanosToMillis(configUpdateMessage.getTimestamp()), (BaseMessage.MetaData) null, (String) null, 12, (DefaultConstructorMarker) null);
    }

    private final GccChatFileMessage mapFileMessage(com.deliveryhero.chatsdk.domain.model.messages.FileMessage fileMessage) {
        BaseMessage.MetaData metaData;
        String id2 = fileMessage.getId();
        long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(fileMessage.getTimestamp());
        String url = fileMessage.getUrl();
        User user = new User(fileMessage.getSender().getUserId(), fileMessage.getSender().getNickname(), SenderType.USER);
        List<FileMessage.Thumbnail> orDefaultThumbnail = getOrDefaultThumbnail(fileMessage.getThumbnails(), fileMessage.getUrl());
        MetaData metadata = fileMessage.getMetadata();
        if (metadata != null) {
            metaData = new BaseMessage.MetaData(metadata.getUserCount());
        } else {
            metaData = null;
        }
        return new GccChatFileMessage(id2, convertNanosToMillis, user, url, orDefaultThumbnail, metaData, fileMessage.getCorrelationId());
    }

    private final GccBaseLocationMessage mapLocationMessage(LocationMessage locationMessage) {
        BaseMessage.MetaData metaData;
        String id2 = locationMessage.getId();
        long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(locationMessage.getTimestamp());
        double latitude = locationMessage.getLocation().getLatitude();
        double longitude = locationMessage.getLocation().getLongitude();
        User user = new User(locationMessage.getSender().getUserId(), locationMessage.getSender().getNickname(), SenderType.USER);
        MetaData metadata = locationMessage.getMetadata();
        if (metadata != null) {
            metaData = new BaseMessage.MetaData(metadata.getUserCount());
        } else {
            metaData = null;
        }
        return new GccBaseLocationMessage(id2, convertNanosToMillis, latitude, longitude, user, metaData, locationMessage.getCorrelationId());
    }

    private final GccChatUserMessage mapTextMessage(TextMessage textMessage) {
        BaseMessage.MetaData metaData;
        String id2 = textMessage.getId();
        long convertNanosToMillis = TimeUtilKt.convertNanosToMillis(textMessage.getTimestamp());
        String message = textMessage.getMessage();
        Map<String, String> translations = textMessage.getTranslations();
        User user = new User(textMessage.getSender().getUserId(), textMessage.getSender().getNickname(), SenderType.USER);
        MetaData metadata = textMessage.getMetadata();
        if (metadata != null) {
            metaData = new BaseMessage.MetaData(metadata.getUserCount());
        } else {
            metaData = null;
        }
        return new GccChatUserMessage(id2, convertNanosToMillis, message, translations, user, metaData, textMessage.getCorrelationId());
    }

    @NotNull
    public final List<BaseMessage> map(@NotNull List<? extends Message> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Iterable<Message> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Message map : iterable) {
            arrayList.add(map(map));
        }
        return arrayList;
    }

    @NotNull
    public final BaseMessage map(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof AdminMessage) {
            return mapAdminMessage((AdminMessage) message);
        }
        if (message instanceof TextMessage) {
            return mapTextMessage((TextMessage) message);
        }
        if (message instanceof com.deliveryhero.chatsdk.domain.model.messages.FileMessage) {
            return mapFileMessage((com.deliveryhero.chatsdk.domain.model.messages.FileMessage) message);
        }
        if (message instanceof LocationMessage) {
            return mapLocationMessage((LocationMessage) message);
        }
        if (message instanceof com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage) {
            return mapConfigMessage((com.deliveryhero.chatsdk.domain.model.messages.ConfigMessage) message);
        }
        if (message instanceof ConfigUpdateMessage) {
            return mapConfigUpdateMessage((ConfigUpdateMessage) message);
        }
        if (message instanceof ChannelFrozenMessage) {
            return mapChannelFrozenMessage((ChannelFrozenMessage) message);
        }
        throw new IllegalArgumentException("unknown message type");
    }
}
