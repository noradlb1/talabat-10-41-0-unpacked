package com.deliveryhero.chatui.data;

import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatui/data/CameraImageRepository;", "", "cacheImageInfo", "", "imageAbsolutePath", "", "getEditedImageFile", "Ljava/io/File;", "quality", "", "isAutoRotated", "", "getImagePath", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CameraImageRepository {
    void cacheImageInfo(@NotNull String str);

    @Nullable
    File getEditedImageFile(int i11, boolean z11);

    @NotNull
    String getImagePath();
}
