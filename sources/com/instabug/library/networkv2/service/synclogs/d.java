package com.instabug.library.networkv2.service.synclogs;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import java.io.File;
import java.io.UnsupportedEncodingException;

class d {
    public Request a(@NonNull File file, @Nullable String str, @Nullable String str2, @NonNull String str3) throws UnsupportedEncodingException {
        return new Request.Builder().url(Endpoints.PRODUCTION_LOGS_URL).type(2).method("POST").fileToUpload(new FileToUpload("log_file", file.getName(), file.getAbsolutePath(), "file")).addParameter(new RequestParameter(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, str3)).addHeader(new RequestParameter("Authorization", b(str, str2))).build();
    }

    @VisibleForTesting
    @NonNull
    public String b(@Nullable String str, @Nullable String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "null";
        }
        if (str == null) {
            str = "null";
        }
        return Request.BASIC_AUTH_VALUE_PREFIX.concat(Base64.encodeToString(str2.concat(CertificateUtil.DELIMITER).concat(str).getBytes("UTF-8"), 2));
    }
}
