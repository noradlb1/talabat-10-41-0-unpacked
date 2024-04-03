package com.deliveryhero.contract.model;

import com.deliveryhero.contract.model.FileMessage;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/contract/model/FileMessageData;", "", "file", "Ljava/io/File;", "thumbnailSizes", "", "Lcom/deliveryhero/contract/model/FileMessage$ThumbnailSize;", "correlationID", "", "(Ljava/io/File;Ljava/util/List;Ljava/lang/String;)V", "getCorrelationID", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "getThumbnailSizes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileMessageData {
    @NotNull
    private final String correlationID;
    @NotNull
    private final File file;
    @NotNull
    private final List<FileMessage.ThumbnailSize> thumbnailSizes;

    public FileMessageData(@NotNull File file2, @NotNull List<FileMessage.ThumbnailSize> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(list, "thumbnailSizes");
        Intrinsics.checkNotNullParameter(str, "correlationID");
        this.file = file2;
        this.thumbnailSizes = list;
        this.correlationID = str;
    }

    public static /* synthetic */ FileMessageData copy$default(FileMessageData fileMessageData, File file2, List<FileMessage.ThumbnailSize> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            file2 = fileMessageData.file;
        }
        if ((i11 & 2) != 0) {
            list = fileMessageData.thumbnailSizes;
        }
        if ((i11 & 4) != 0) {
            str = fileMessageData.correlationID;
        }
        return fileMessageData.copy(file2, list, str);
    }

    @NotNull
    public final File component1() {
        return this.file;
    }

    @NotNull
    public final List<FileMessage.ThumbnailSize> component2() {
        return this.thumbnailSizes;
    }

    @NotNull
    public final String component3() {
        return this.correlationID;
    }

    @NotNull
    public final FileMessageData copy(@NotNull File file2, @NotNull List<FileMessage.ThumbnailSize> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(list, "thumbnailSizes");
        Intrinsics.checkNotNullParameter(str, "correlationID");
        return new FileMessageData(file2, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileMessageData)) {
            return false;
        }
        FileMessageData fileMessageData = (FileMessageData) obj;
        return Intrinsics.areEqual((Object) this.file, (Object) fileMessageData.file) && Intrinsics.areEqual((Object) this.thumbnailSizes, (Object) fileMessageData.thumbnailSizes) && Intrinsics.areEqual((Object) this.correlationID, (Object) fileMessageData.correlationID);
    }

    @NotNull
    public final String getCorrelationID() {
        return this.correlationID;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @NotNull
    public final List<FileMessage.ThumbnailSize> getThumbnailSizes() {
        return this.thumbnailSizes;
    }

    public int hashCode() {
        return (((this.file.hashCode() * 31) + this.thumbnailSizes.hashCode()) * 31) + this.correlationID.hashCode();
    }

    @NotNull
    public String toString() {
        return "FileMessageData(file=" + this.file + ", thumbnailSizes=" + this.thumbnailSizes + ", correlationID=" + this.correlationID + ')';
    }
}
