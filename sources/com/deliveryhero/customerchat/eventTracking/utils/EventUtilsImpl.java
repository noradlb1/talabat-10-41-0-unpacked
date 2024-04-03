package com.deliveryhero.customerchat.eventTracking.utils;

import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtilsImpl;", "Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtils;", "()V", "generateTimeStamp", "", "generateUUID", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventUtilsImpl implements EventUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TIME_STAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/utils/EventUtilsImpl$Companion;", "", "()V", "TIME_STAMP_FORMAT", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public String generateTimeStamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_STAMP_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "formattedDate.format(Date())");
        return format;
    }

    @NotNull
    public String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }
}
