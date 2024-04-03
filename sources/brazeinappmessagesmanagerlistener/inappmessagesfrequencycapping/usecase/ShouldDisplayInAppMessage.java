package brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.usecase;

import brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.repo.InAppMessagesCappingRepo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/usecase/ShouldDisplayInAppMessage;", "", "repo", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/repo/InAppMessagesCappingRepo;", "(Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/repo/InAppMessagesCappingRepo;)V", "invoke", "", "currentTimeStamp", "", "categoryName", "", "isTimeStampWithinTimeFrame", "timeMillis", "currentTimeMillis", "timeFrameSeconds", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShouldDisplayInAppMessage {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MILLIS_PER_SECOND = 1000;
    @NotNull
    private final InAppMessagesCappingRepo repo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/usecase/ShouldDisplayInAppMessage$Companion;", "", "()V", "MILLIS_PER_SECOND", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ShouldDisplayInAppMessage(@NotNull InAppMessagesCappingRepo inAppMessagesCappingRepo) {
        Intrinsics.checkNotNullParameter(inAppMessagesCappingRepo, "repo");
        this.repo = inAppMessagesCappingRepo;
    }

    public static /* synthetic */ boolean invoke$default(ShouldDisplayInAppMessage shouldDisplayInAppMessage, long j11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return shouldDisplayInAppMessage.invoke(j11, str);
    }

    private final boolean isTimeStampWithinTimeFrame(long j11, long j12, long j13) {
        return (j12 - (j13 * ((long) 1000))) + 1 <= j11 && j11 < j12;
    }

    public final boolean invoke(long j11, @Nullable String str) {
        boolean z11;
        boolean z12;
        String str2 = str;
        String highPriorityCategoryIdentifier = this.repo.getHighPriorityCategoryIdentifier();
        if (str2 != null) {
            z11 = str2.equals(highPriorityCategoryIdentifier);
        } else {
            z11 = false;
        }
        List<Long> inAppMessagesDisplayRecord = this.repo.getInAppMessagesDisplayRecord();
        int maxLimitForDisplay = this.repo.getCappingConfiguration().getMaxLimitForDisplay();
        long timeInSeconds = this.repo.getCappingConfiguration().getTimeInSeconds();
        ArrayList arrayList = new ArrayList();
        for (Object next : inAppMessagesDisplayRecord) {
            if (isTimeStampWithinTimeFrame(((Number) next).longValue(), j11, timeInSeconds)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() >= maxLimitForDisplay) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 && !z11) {
            return false;
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList);
        mutableList.add(Long.valueOf(j11));
        this.repo.updateInAppMessageDisplayRecord(mutableList);
        return true;
    }
}
