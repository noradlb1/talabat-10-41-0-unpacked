package com.deliveryhero.customerchat.helpers.dateProvider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProvider;", "", "timeStamp", "", "getTimeStamp", "()J", "formatTime", "", "pattern", "getFormattedDate", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DateProvider {
    @NotNull
    public static final Companion Companion = Companion.f30008a;
    @NotNull
    public static final String DATE_PATTERN_HH_mm = "HH:mm";
    @NotNull
    public static final String DATE_PATTERN_yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProvider$Companion;", "", "()V", "DATE_PATTERN_HH_mm", "", "DATE_PATTERN_yyyyMMdd_HHmmss", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String DATE_PATTERN_HH_mm = "HH:mm";
        @NotNull
        public static final String DATE_PATTERN_yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f30008a = new Companion();

        private Companion() {
        }
    }

    @NotNull
    String formatTime(long j11, @NotNull String str);

    @NotNull
    String getFormattedDate(@NotNull String str);

    long getTimeStamp();
}
