package com.deliveryhero.chatui.domain.imageselection.usecase;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/deliveryhero/chatui/domain/imageselection/usecase/ImageSizeUseCaseImpl;", "Lcom/deliveryhero/chatui/domain/imageselection/usecase/ImageSizeUseCase;", "()V", "oneByte", "", "getImageSizeInKiloBytes", "", "imagePath", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageSizeUseCaseImpl implements ImageSizeUseCase {
    private final int oneByte = 1024;

    public long getImageSizeInKiloBytes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "imagePath");
        return new File(str).length() / ((long) this.oneByte);
    }
}
