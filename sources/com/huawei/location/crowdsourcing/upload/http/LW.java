package com.huawei.location.crowdsourcing.upload.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.crowdsourcing.upload.http.Vw;
import com.huawei.location.lite.common.log.LogConsole;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LW extends Vw {
    private File E5 = new File("");

    public LW(@NonNull String str) {
        super(Vw.yn.PUT, str);
    }

    public LW Vw(@NonNull String str) {
        this.E5 = new File(str);
        return this;
    }

    @Nullable
    public InputStream b() {
        if (!this.E5.exists()) {
            LogConsole.e("UploadRequest", "file not exist");
            return null;
        }
        try {
            return new FileInputStream(this.E5);
        } catch (FileNotFoundException unused) {
            LogConsole.e("UploadRequest", "file open failed");
            return null;
        }
    }
}
