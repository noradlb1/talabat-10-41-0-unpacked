package com.deliveryhero.chatui.data.datasource;

import android.net.Uri;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;", "", "createImageFile", "Ljava/io/File;", "imageFileName", "", "getEditedImageFile", "cameraFilePath", "quality", "", "isAutoRotated", "", "getImageFileUri", "Landroid/net/Uri;", "imageFile", "isFileExisted", "path", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageFileProvider {
    @NotNull
    File createImageFile(@NotNull String str) throws IOException;

    @Nullable
    File getEditedImageFile(@NotNull String str, int i11, boolean z11);

    @NotNull
    Uri getImageFileUri(@NotNull File file);

    boolean isFileExisted(@NotNull String str);
}
