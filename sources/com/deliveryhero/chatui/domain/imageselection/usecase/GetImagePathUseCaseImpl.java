package com.deliveryhero.chatui.domain.imageselection.usecase;

import android.net.Uri;
import com.deliveryhero.chatui.data.CameraImageRepository;
import com.deliveryhero.chatui.data.datasource.MediaStoreProvider;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetImagePathUseCaseImpl;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetImagePathUseCase;", "cameraImageRepository", "Lcom/deliveryhero/chatui/data/CameraImageRepository;", "mediaStoreProvider", "Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider;", "(Lcom/deliveryhero/chatui/data/CameraImageRepository;Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider;)V", "galleryImagePath", "", "getImageFromCamera", "getImageFromGallery", "imageUri", "Landroid/net/Uri;", "getSelectedGalleryImagePath", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetImagePathUseCaseImpl implements GetImagePathUseCase {
    @NotNull
    private final CameraImageRepository cameraImageRepository;
    private String galleryImagePath;
    @NotNull
    private final MediaStoreProvider mediaStoreProvider;

    public GetImagePathUseCaseImpl(@NotNull CameraImageRepository cameraImageRepository2, @NotNull MediaStoreProvider mediaStoreProvider2) {
        Intrinsics.checkNotNullParameter(cameraImageRepository2, "cameraImageRepository");
        Intrinsics.checkNotNullParameter(mediaStoreProvider2, "mediaStoreProvider");
        this.cameraImageRepository = cameraImageRepository2;
        this.mediaStoreProvider = mediaStoreProvider2;
    }

    @Nullable
    public String getImageFromCamera() {
        File editedImageFile = this.cameraImageRepository.getEditedImageFile(75, true);
        if (editedImageFile != null) {
            return editedImageFile.getAbsolutePath();
        }
        return null;
    }

    @NotNull
    public String getImageFromGallery(@NotNull Uri uri) {
        String str;
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "imageUri.toString()");
        if (StringsKt__StringsJVMKt.startsWith$default(uri2, "content://", false, 2, (Object) null)) {
            str = this.mediaStoreProvider.saveTempImage(uri);
        } else {
            str = uri.toString();
            Intrinsics.checkNotNullExpressionValue(str, "{\n            imageUri.toString()\n        }");
        }
        this.galleryImagePath = str;
        return str;
    }

    @NotNull
    public String getSelectedGalleryImagePath() {
        String str = this.galleryImagePath;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("galleryImagePath");
        return null;
    }
}
