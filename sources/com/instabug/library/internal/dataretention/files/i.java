package com.instabug.library.internal.dataretention.files;

import androidx.annotation.NonNull;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

public abstract class i {
    @NonNull
    public abstract f a(@NonNull File file);

    @NonNull
    public j a(@NonNull String str) {
        return new h(this, str);
    }

    @NonNull
    public Collection b(@NonNull String str) {
        LinkedList linkedList = new LinkedList();
        try {
            File file = new File(str);
            File[] listFiles = file.listFiles();
            if (file.exists() && listFiles != null) {
                for (File a11 : listFiles) {
                    linkedList.add(a(a11));
                }
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while getting files to delete", e11);
        }
        return linkedList;
    }
}
