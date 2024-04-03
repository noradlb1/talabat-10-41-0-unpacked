package brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.repo;

import android.content.SharedPreferences;
import brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.models.InAppMessagesCappingConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/repo/InAppMessagesCappingRepoImpl;", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/repo/InAppMessagesCappingRepo;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getCappingConfiguration", "Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/models/InAppMessagesCappingConfig;", "getHighPriorityCategoryIdentifier", "", "getInAppMessagesDisplayRecord", "", "", "updateInAppMessageDisplayRecord", "", "updatedRecord", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessagesCappingRepoImpl implements InAppMessagesCappingRepo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String IAM_DISPLAY_RECORD = "IAM_DISPLAY_RECORD";
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/repo/InAppMessagesCappingRepoImpl$Companion;", "", "()V", "IAM_DISPLAY_RECORD", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InAppMessagesCappingRepoImpl(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    @NotNull
    public InAppMessagesCappingConfig getCappingConfiguration() {
        return new InAppMessagesCappingConfig(604800, 3);
    }

    @NotNull
    public String getHighPriorityCategoryIdentifier() {
        return "high_priority";
    }

    @NotNull
    public List<Long> getInAppMessagesDisplayRecord() {
        Set<String> stringSet = this.sharedPreferences.getStringSet(IAM_DISPLAY_RECORD, SetsKt__SetsKt.emptySet());
        if (stringSet == null) {
            stringSet = SetsKt__SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(stringSet, 10));
        for (String str : stringSet) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList.add(Long.valueOf(Long.parseLong(str)));
        }
        return arrayList;
    }

    public void updateInAppMessageDisplayRecord(@NotNull List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "updatedRecord");
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        Iterable<Number> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Number longValue : iterable) {
            arrayList.add(String.valueOf(longValue.longValue()));
        }
        edit.putStringSet(IAM_DISPLAY_RECORD, CollectionsKt___CollectionsKt.toSet(arrayList));
        edit.apply();
    }
}
