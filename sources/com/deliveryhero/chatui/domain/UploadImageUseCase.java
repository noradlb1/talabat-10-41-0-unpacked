package com.deliveryhero.chatui.domain;

import com.deliveryhero.chatui.data.CameraImageRepository;
import com.deliveryhero.chatui.data.datasource.MediaStoreProvider;
import com.deliveryhero.chatui.domain.UploadPhotoStatus;
import com.deliveryhero.contract.model.BaseMessage;
import com.deliveryhero.contract.model.FileMessage;
import com.deliveryhero.contract.model.FileMessageData;
import com.deliveryhero.customerchat.service.ChannelService;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadImageUseCase;", "", "cameraImageRepository", "Lcom/deliveryhero/chatui/data/CameraImageRepository;", "service", "Lcom/deliveryhero/customerchat/service/ChannelService;", "mediaStoreProvider", "Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider;", "(Lcom/deliveryhero/chatui/data/CameraImageRepository;Lcom/deliveryhero/customerchat/service/ChannelService;Lcom/deliveryhero/chatui/data/datasource/MediaStoreProvider;)V", "execute", "", "saveImageToGallery", "", "correlationID", "", "callBack", "Lkotlin/Function1;", "Lcom/deliveryhero/chatui/domain/UploadPhotoStatus;", "THUMBNAIL", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UploadImageUseCase {
    public static final int HEIGHT = 200;
    public static final int QUALITY = 75;
    @NotNull
    public static final THUMBNAIL THUMBNAIL = new THUMBNAIL((DefaultConstructorMarker) null);
    public static final int WIDTH = 200;
    @NotNull
    private final CameraImageRepository cameraImageRepository;
    @NotNull
    private final MediaStoreProvider mediaStoreProvider;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final ChannelService f29400service;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/domain/UploadImageUseCase$THUMBNAIL;", "", "()V", "HEIGHT", "", "QUALITY", "WIDTH", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class THUMBNAIL {
        private THUMBNAIL() {
        }

        public /* synthetic */ THUMBNAIL(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UploadImageUseCase(@NotNull CameraImageRepository cameraImageRepository2, @NotNull ChannelService channelService, @NotNull MediaStoreProvider mediaStoreProvider2) {
        Intrinsics.checkNotNullParameter(cameraImageRepository2, "cameraImageRepository");
        Intrinsics.checkNotNullParameter(channelService, "service");
        Intrinsics.checkNotNullParameter(mediaStoreProvider2, "mediaStoreProvider");
        this.cameraImageRepository = cameraImageRepository2;
        this.f29400service = channelService;
        this.mediaStoreProvider = mediaStoreProvider2;
    }

    public final void execute(boolean z11, @NotNull String str, @NotNull Function1<? super UploadPhotoStatus, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "correlationID");
        Intrinsics.checkNotNullParameter(function1, "callBack");
        function1.invoke(UploadPhotoStatus.Loading.INSTANCE);
        File editedImageFile = this.cameraImageRepository.getEditedImageFile(75, true);
        if (editedImageFile == null) {
            function1.invoke(new UploadPhotoStatus.Error((BaseMessage) null, new Throwable()));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FileMessage.ThumbnailSize(200, 200));
        FileMessageData fileMessageData = new FileMessageData(editedImageFile, arrayList, str);
        if (z11) {
            this.mediaStoreProvider.saveToGallery(editedImageFile);
        }
        this.f29400service.sendFileMessage(fileMessageData, new UploadImageUseCase$execute$1(function1), new UploadImageUseCase$execute$2(function1));
    }
}
