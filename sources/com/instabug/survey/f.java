package com.instabug.survey;

import com.instabug.library.internal.storage.cache.db.InstabugDBInsertionListener;
import com.instabug.survey.cache.l;
import com.instabug.survey.common.userInteractions.a;
import java.util.List;

class f implements InstabugDBInsertionListener {
    public f(h hVar) {
    }

    /* renamed from: a */
    public void onDataInserted(String str) {
        List b11 = l.b();
        if (b11 != null && !b11.isEmpty()) {
            a.a(b11, str);
            l.a(b11);
        }
    }
}
