package com.instabug.library.networkv2.service.userattributes;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import java.util.List;

class b {
    public void a(List list) {
        UserAttributesDbHelper.insertBulk(list);
    }

    public void a() {
        UserAttributeCacheManager.deleteAll(1);
    }
}
