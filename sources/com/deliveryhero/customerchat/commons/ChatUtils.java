package com.deliveryhero.customerchat.commons;

import java.io.File;
import kotlin.Metadata;
import okhttp3.MultipartBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/commons/ChatUtils;", "", "generateMultipartBody", "Lokhttp3/MultipartBody$Part;", "file", "Ljava/io/File;", "generateUUIDString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatUtils {
    @NotNull
    MultipartBody.Part generateMultipartBody(@NotNull File file);

    @NotNull
    String generateUUIDString();
}
