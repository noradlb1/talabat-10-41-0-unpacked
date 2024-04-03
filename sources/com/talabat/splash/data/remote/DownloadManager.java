package com.talabat.splash.data.remote;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.talabat.splash.data.local.LocalCache;
import com.talabat.splash.data.remote.worker.DownloadWorker;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/splash/data/remote/DownloadManager;", "", "workManager", "Landroidx/work/WorkManager;", "localCache", "Lcom/talabat/splash/data/local/LocalCache;", "context", "Landroid/content/Context;", "(Landroidx/work/WorkManager;Lcom/talabat/splash/data/local/LocalCache;Landroid/content/Context;)V", "sharedPreference", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "buildData", "Landroidx/work/Data;", "url", "", "type", "Lcom/talabat/splash/data/remote/DownloadManager$DownloadType;", "enqueueDownload", "", "getLocalPath", "isDownloaded", "", "Companion", "DownloadType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadManager {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String SHARED_PREFERENCE_NAME = "splash_config";
    @NotNull
    private final LocalCache localCache;
    private final SharedPreferences sharedPreference;
    @NotNull
    private final WorkManager workManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/data/remote/DownloadManager$Companion;", "", "()V", "SHARED_PREFERENCE_NAME", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/data/remote/DownloadManager$DownloadType;", "", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum DownloadType {
        IMAGE,
        VIDEO
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadType.values().length];
            iArr[DownloadType.IMAGE.ordinal()] = 1;
            iArr[DownloadType.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DownloadManager(@NotNull WorkManager workManager2, @NotNull LocalCache localCache2, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(workManager2, "workManager");
        Intrinsics.checkNotNullParameter(localCache2, "localCache");
        Intrinsics.checkNotNullParameter(context, "context");
        this.workManager = workManager2;
        this.localCache = localCache2;
        this.sharedPreference = context.getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
    }

    private final Data buildData(String str, DownloadType downloadType) {
        int i11;
        Data.Builder builder = new Data.Builder();
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("url", str);
        int i12 = WhenMappings.$EnumSwitchMapping$0[downloadType.ordinal()];
        if (i12 == 1) {
            i11 = DownloadWorker.Type.IMAGE.ordinal();
        } else if (i12 == 2) {
            i11 = DownloadWorker.Type.VIDEO.ordinal();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        pairArr[1] = TuplesKt.to("type", Integer.valueOf(i11));
        pairArr[2] = TuplesKt.to(DownloadWorker.DATA_PREFERENCE_KEY, SHARED_PREFERENCE_NAME);
        Data build = builder.putAll((Map<String, Object>) MapsKt__MapsKt.mapOf(pairArr)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .putAl…       )\n        .build()");
        return build;
    }

    public final void enqueueDownload(@NotNull String str, @NotNull DownloadType downloadType) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(downloadType, "type");
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…TED)\n            .build()");
        WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DownloadWorker.class).setInputData(buildData(str, downloadType))).setConstraints(build)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "Builder(DownloadWorker::…nts)\n            .build()");
        this.workManager.enqueueUniqueWork(str, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build2);
    }

    @NotNull
    public final String getLocalPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String string = this.sharedPreference.getString(str, (String) null);
        if (string == null) {
            return "";
        }
        return string;
    }

    public final boolean isDownloaded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String string = this.sharedPreference.getString(str, (String) null);
        if (string == null || !this.localCache.fileExists(string)) {
            return false;
        }
        return true;
    }
}
