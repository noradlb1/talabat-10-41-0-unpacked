package com.deliveryhero.chatui.domain.imageselection.usecase;

import com.deliveryhero.chatui.data.CameraImageRepository;
import com.deliveryhero.chatui.data.datasource.ImageFileProvider;
import com.deliveryhero.chatui.domain.imageselection.usecase.CacheGalleryImageStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageUseCaseImpl;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageUseCase;", "imageFileProvider", "Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;", "cameraImageRepository", "Lcom/deliveryhero/chatui/data/CameraImageRepository;", "(Lcom/deliveryhero/chatui/data/datasource/ImageFileProvider;Lcom/deliveryhero/chatui/data/CameraImageRepository;)V", "cacheGalleryImage", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageStatus;", "path", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CacheGalleryImageUseCaseImpl implements CacheGalleryImageUseCase {
    @NotNull
    private final CameraImageRepository cameraImageRepository;
    @NotNull
    private final ImageFileProvider imageFileProvider;

    public CacheGalleryImageUseCaseImpl(@NotNull ImageFileProvider imageFileProvider2, @NotNull CameraImageRepository cameraImageRepository2) {
        Intrinsics.checkNotNullParameter(imageFileProvider2, "imageFileProvider");
        Intrinsics.checkNotNullParameter(cameraImageRepository2, "cameraImageRepository");
        this.imageFileProvider = imageFileProvider2;
        this.cameraImageRepository = cameraImageRepository2;
    }

    @NotNull
    public CacheGalleryImageStatus cacheGalleryImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (!this.imageFileProvider.isFileExisted(str)) {
            return new CacheGalleryImageStatus.Error(new Throwable());
        }
        this.cameraImageRepository.cacheImageInfo(str);
        return CacheGalleryImageStatus.Success.INSTANCE;
    }
}
