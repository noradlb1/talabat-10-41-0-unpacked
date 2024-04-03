package com.deliveryhero.chatui.domain.imageselection.usecase;

import android.net.Uri;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/GetImagePathUseCase;", "", "getImageFromCamera", "", "getImageFromGallery", "imageUri", "Landroid/net/Uri;", "getSelectedGalleryImagePath", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetImagePathUseCase {
    @Nullable
    String getImageFromCamera();

    @NotNull
    String getImageFromGallery(@NotNull Uri uri);

    @NotNull
    String getSelectedGalleryImagePath();
}
