package com.instabug.library.internal.storage.cache;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;

public class a extends InMemoryCache {
    public a(String str) {
        super(str);
    }

    public void invalidate() {
        for (AssetEntity assetEntity : getValues()) {
            InstabugSDKLogger.d("IBG-Core", "Delete file: " + assetEntity.getFile().getPath() + "," + assetEntity.getFile().delete());
        }
        super.invalidate();
    }
}
