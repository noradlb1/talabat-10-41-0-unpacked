package com.deliveryhero.chatui.data;

import com.deliveryhero.chatui.data.datasource.ImageFileProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/data/CameraImageRepositoryImpl;", "Lcom/deliveryhero/chatui/data/CameraImageRepository;", "imageFileProvider", "Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;", "(Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;)V", "imageAbsolutePath", "", "cacheImageInfo", "", "getEditedImageFile", "Ljava/io/File;", "quality", "", "isAutoRotated", "", "getImagePath", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CameraImageRepositoryImpl implements CameraImageRepository {
    @NotNull
    private String imageAbsolutePath = "";
    @NotNull
    private final ImageFileProvider imageFileProvider;

    public CameraImageRepositoryImpl(@NotNull ImageFileProvider imageFileProvider2) {
        Intrinsics.checkNotNullParameter(imageFileProvider2, "imageFileProvider");
        this.imageFileProvider = imageFileProvider2;
    }

    public void cacheImageInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "imageAbsolutePath");
        this.imageAbsolutePath = str;
    }

    @Nullable
    public File getEditedImageFile(int i11, boolean z11) {
        return this.imageFileProvider.getEditedImageFile(this.imageAbsolutePath, i11, z11);
    }

    @NotNull
    public String getImagePath() {
        return this.imageAbsolutePath;
    }
}
