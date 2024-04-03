package com.instabug.survey.utils;

import com.instabug.library.util.filters.Filter;
import com.instabug.survey.common.models.c;
import java.util.ArrayList;
import java.util.Iterator;

class f implements Filter {
    private boolean a(c cVar) {
        return j.a(cVar.a());
    }

    /* renamed from: a */
    public ArrayList apply(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (a(cVar)) {
                arrayList2.add(cVar);
            }
        }
        return arrayList2;
    }
}
