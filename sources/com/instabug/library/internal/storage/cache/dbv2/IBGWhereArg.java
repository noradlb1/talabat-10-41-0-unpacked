package com.instabug.library.internal.storage.cache.dbv2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.encryption.EncryptionManager;
import java.util.List;

public class IBGWhereArg {
    private final boolean encryptionEnabled;
    private final boolean transitive;
    private final String value;

    public IBGWhereArg(@NonNull String str, boolean z11) {
        boolean z12;
        this.value = str;
        this.transitive = z11;
        if (e0.c().a() == Feature.State.ENABLED) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.encryptionEnabled = z12;
    }

    public static String[] argsListToStringArray(@Nullable List<IBGWhereArg> list) {
        if (list == null) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11) != null) {
                strArr[i11] = list.get(i11).getValue();
            }
        }
        return strArr;
    }

    @Nullable
    public String getValue() {
        if (this.transitive || !this.encryptionEnabled) {
            return this.value;
        }
        return EncryptionManager.encrypt(this.value, 2);
    }
}
