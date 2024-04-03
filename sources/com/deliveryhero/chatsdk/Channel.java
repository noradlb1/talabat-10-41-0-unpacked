package com.deliveryhero.chatsdk;

import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.chatsdk.domain.model.messages.Message;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&JR\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H&J-\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&ø\u0001\u0000J5\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00032\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&ø\u0001\u0000J5\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00032\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&ø\u0001\u0000JO\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00032\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00032\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00070\u0011H&ø\u0001\u0000R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/deliveryhero/chatsdk/Channel;", "", "channelId", "", "getChannelId", "()Ljava/lang/String;", "dispose", "", "getMessages", "limit", "", "timestamp", "", "inverted", "", "correlationID", "completionHandler", "Lkotlin/Function1;", "Lkotlin/Result;", "", "Lcom/deliveryhero/chatsdk/domain/model/messages/Message;", "(ILjava/lang/Long;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "markAllMessagesAsRead", "sendConfigRequestMessage", "sendFileMessage", "file", "Ljava/io/File;", "sendLocationMessage", "location", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "sendMessage", "message", "language", "supportedTranslations", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Channel {
    void dispose();

    @NotNull
    String getChannelId();

    void getMessages(int i11, @Nullable Long l11, boolean z11, @NotNull String str, @NotNull Function1<? super Result<? extends List<? extends Message>>, Unit> function1);

    void markAllMessagesAsRead(@NotNull String str);

    void sendConfigRequestMessage(@NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1);

    void sendFileMessage(@NotNull File file, @NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1);

    void sendLocationMessage(@NotNull Location location, @NotNull String str, @NotNull Function1<? super Result<? extends Message>, Unit> function1);

    void sendMessage(@NotNull String str, @Nullable String str2, @Nullable List<String> list, @NotNull String str3, @NotNull Function1<? super Result<? extends Message>, Unit> function1);
}
