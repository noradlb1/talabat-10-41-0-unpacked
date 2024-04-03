package com.talabat.splash.data.repositories;

import com.talabat.splash.data.remote.DownloadManager;
import com.talabat.splash.domain.repository.DownloadsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/splash/data/repositories/DownloadsRepositoryImpl;", "Lcom/talabat/splash/domain/repository/DownloadsRepository;", "downloadManager", "Lcom/talabat/splash/data/remote/DownloadManager;", "(Lcom/talabat/splash/data/remote/DownloadManager;)V", "downLoad", "", "url", "", "type", "Lcom/talabat/splash/domain/repository/DownloadsRepository$Type;", "getLocalPath", "isDownloaded", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadsRepositoryImpl implements DownloadsRepository {
    @NotNull
    private final DownloadManager downloadManager;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadsRepository.Type.values().length];
            iArr[DownloadsRepository.Type.IMAGE.ordinal()] = 1;
            iArr[DownloadsRepository.Type.VIDEO.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DownloadsRepositoryImpl(@NotNull DownloadManager downloadManager2) {
        Intrinsics.checkNotNullParameter(downloadManager2, "downloadManager");
        this.downloadManager = downloadManager2;
    }

    public void downLoad(@NotNull String str, @NotNull DownloadsRepository.Type type) {
        DownloadManager.DownloadType downloadType;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        DownloadManager downloadManager2 = this.downloadManager;
        int i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i11 == 1) {
            downloadType = DownloadManager.DownloadType.IMAGE;
        } else if (i11 == 2) {
            downloadType = DownloadManager.DownloadType.VIDEO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        downloadManager2.enqueueDownload(str, downloadType);
    }

    @NotNull
    public String getLocalPath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return this.downloadManager.getLocalPath(str);
    }

    public boolean isDownloaded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return this.downloadManager.isDownloaded(str);
    }
}
