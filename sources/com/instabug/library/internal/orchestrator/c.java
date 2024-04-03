package com.instabug.library.internal.orchestrator;

import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.model.l;

public class c implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final l f50994a;

    public c(l lVar) {
        this.f50994a = lVar;
    }

    public void run() {
        UserAttributesDbHelper.insert(this.f50994a);
    }
}
