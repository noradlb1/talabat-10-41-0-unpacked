package com.deliveryhero.chatui.domain.imageselection;

import com.deliveryhero.chatui.domain.imageselection.usecase.CacheGalleryImageStatus;
import com.deliveryhero.chatui.domain.imageselection.usecase.CacheGalleryImageUseCase;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetCameraImageUriStatus;
import com.deliveryhero.chatui.domain.imageselection.usecase.GetCameraImageUriUseCase;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0001¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/ImageSelectionUseCases;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageUseCase;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriUseCase;", "cacheGalleryImageUseCase", "getCameraImageUriUseCase", "(Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageUseCase;Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriUseCase;)V", "cacheGalleryImage", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/CacheGalleryImageStatus;", "path", "", "getCameraImageUri", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetCameraImageUriStatus;", "code", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSelectionUseCases implements CacheGalleryImageUseCase, GetCameraImageUriUseCase {
    private final /* synthetic */ CacheGalleryImageUseCase $$delegate_0;
    private final /* synthetic */ GetCameraImageUriUseCase $$delegate_1;

    public ImageSelectionUseCases(@NotNull CacheGalleryImageUseCase cacheGalleryImageUseCase, @NotNull GetCameraImageUriUseCase getCameraImageUriUseCase) {
        Intrinsics.checkNotNullParameter(cacheGalleryImageUseCase, "cacheGalleryImageUseCase");
        Intrinsics.checkNotNullParameter(getCameraImageUriUseCase, "getCameraImageUriUseCase");
        this.$$delegate_0 = cacheGalleryImageUseCase;
        this.$$delegate_1 = getCameraImageUriUseCase;
    }

    @NotNull
    public CacheGalleryImageStatus cacheGalleryImage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return this.$$delegate_0.cacheGalleryImage(str);
    }

    @NotNull
    public GetCameraImageUriStatus getCameraImageUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        return this.$$delegate_1.getCameraImageUri(str);
    }
}
