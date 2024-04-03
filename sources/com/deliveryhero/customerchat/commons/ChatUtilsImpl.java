package com.deliveryhero.customerchat.commons;

import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/customerchat/commons/ChatUtilsImpl;", "Lcom/deliveryhero/customerchat/commons/ChatUtils;", "()V", "multipartName", "", "multipartType", "generateMultipartBody", "Lokhttp3/MultipartBody$Part;", "file", "Ljava/io/File;", "generateUUIDString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatUtilsImpl implements ChatUtils {
    @NotNull
    private final String multipartName = "fileupload";
    @NotNull
    private final String multipartType = "multipart/form-data";

    @NotNull
    public MultipartBody.Part generateMultipartBody(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        MultipartBody.Part createFormData = MultipartBody.Part.createFormData(this.multipartName, file.getName(), RequestBody.create(MediaType.parse(this.multipartType), file));
        Intrinsics.checkNotNullExpressionValue(createFormData, "createFormData(multipartName, file.name, request)");
        return createFormData;
    }

    @NotNull
    public String generateUUIDString() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }
}
