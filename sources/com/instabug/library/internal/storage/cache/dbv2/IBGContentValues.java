package com.instabug.library.internal.storage.cache.dbv2;

import android.content.ContentValues;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.encryption.EncryptionManager;
import java.util.HashMap;
import java.util.Map;

public class IBGContentValues {
    private final boolean isEncryptionEnabled;
    private final HashMap<String, Object> valuesMap = new HashMap<>();

    public IBGContentValues() {
        boolean z11;
        if (e0.c().a() == Feature.State.ENABLED) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isEncryptionEnabled = z11;
    }

    @Nullable
    public Object get(String str) {
        return this.valuesMap.get(str);
    }

    public void put(String str, String str2, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            HashMap<String, Object> hashMap = this.valuesMap;
            if (str2 == null) {
                str2 = null;
            }
            hashMap.put(str, str2);
            return;
        }
        this.valuesMap.put(str, EncryptionManager.encrypt(str2, 2));
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry next : this.valuesMap.entrySet()) {
            if (next.getValue() != null) {
                contentValues.put((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return contentValues;
    }

    public void put(String str, Byte b11, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, b11 == null ? null : String.valueOf(b11));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(b11), 2));
        }
    }

    public void put(String str, Short sh2, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, sh2 == null ? null : String.valueOf(sh2));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(sh2), 2));
        }
    }

    public void put(String str, Long l11, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, l11 == null ? null : String.valueOf(l11));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(l11), 2));
        }
    }

    public void put(String str, Integer num, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, num == null ? null : String.valueOf(num));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(num), 2));
        }
    }

    public void put(String str, Float f11, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, f11 == null ? null : String.valueOf(f11));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(f11), 2));
        }
    }

    public void put(String str, Double d11, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, d11 == null ? null : String.valueOf(d11));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(d11), 2));
        }
    }

    public void put(String str, Boolean bool, boolean z11) {
        if (z11 || !this.isEncryptionEnabled) {
            this.valuesMap.put(str, bool == null ? null : String.valueOf(bool));
        } else {
            this.valuesMap.put(str, EncryptionManager.encrypt(String.valueOf(bool), 2));
        }
    }
}
