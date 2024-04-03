package com.deliveryhero.chatsdk.util;

import com.deliveryhero.chatsdk.domain.model.PushNotificationData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/chatsdk/util/PushNotificationParser;", "", "()V", "BODY_KEY", "", "CHANNEL_ID_KEY", "CHANNEL_TYPE_KEY", "CORRELATION_KEY", "COUNTRY_KEY", "MESSAGE_ID_KEY", "MESSAGE_KEY", "PUSH_ALERT_KEY", "PUSH_ID_KEY", "SENDER_NAME_KEY", "TITLE_KEY", "canParse", "", "data", "", "parse", "Lcom/deliveryhero/chatsdk/domain/model/PushNotificationData;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushNotificationParser {
    @NotNull
    public static final String BODY_KEY = "body";
    @NotNull
    public static final String CHANNEL_ID_KEY = "channel_id";
    @NotNull
    public static final String CHANNEL_TYPE_KEY = "channel_type";
    @NotNull
    public static final String CORRELATION_KEY = "correlation";
    @NotNull
    public static final String COUNTRY_KEY = "country";
    @NotNull
    public static final PushNotificationParser INSTANCE = new PushNotificationParser();
    @NotNull
    public static final String MESSAGE_ID_KEY = "message_id";
    @NotNull
    public static final String MESSAGE_KEY = "message";
    @NotNull
    public static final String PUSH_ALERT_KEY = "push_alert";
    @NotNull
    public static final String PUSH_ID_KEY = "uid";
    @NotNull
    public static final String SENDER_NAME_KEY = "sender_name";
    @NotNull
    public static final String TITLE_KEY = "title";

    private PushNotificationParser() {
    }

    public final boolean canParse(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        if (!map.containsKey(CHANNEL_ID_KEY) || !map.containsKey(SENDER_NAME_KEY) || !map.containsKey("country") || !map.containsKey(CORRELATION_KEY) || !map.containsKey(PUSH_ID_KEY) || !map.containsKey("message_id") || !map.containsKey(CHANNEL_TYPE_KEY) || (!map.containsKey("message") && !map.containsKey("body"))) {
            return false;
        }
        return true;
    }

    @NotNull
    public final PushNotificationData parse(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        String str = (String) MapsKt__MapsKt.getValue(map, CHANNEL_ID_KEY);
        String str2 = (String) MapsKt__MapsKt.getValue(map, SENDER_NAME_KEY);
        String str3 = (String) MapsKt__MapsKt.getValue(map, "country");
        String str4 = (String) MapsKt__MapsKt.getValue(map, CORRELATION_KEY);
        String str5 = (String) MapsKt__MapsKt.getValue(map, "message_id");
        String str6 = (String) MapsKt__MapsKt.getValue(map, PUSH_ID_KEY);
        String str7 = map.get(PUSH_ALERT_KEY);
        String str8 = map.get("message");
        if (str8 == null && (str8 = map.get("body")) == null) {
            str8 = "";
        }
        return new PushNotificationData(str, str2, str4, str3, str5, str6, str8, str7, map.get("title"), (String) MapsKt__MapsKt.getValue(map, CHANNEL_TYPE_KEY));
    }
}
