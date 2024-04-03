package com.instabug.library.visualusersteps.inspector;

import android.view.View;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

class e implements Function {
    /* renamed from: a */
    public Collection apply(Collection collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (!a(view, collection)) {
                linkedHashSet.add(view);
            }
        }
        return linkedHashSet;
    }

    private boolean a(View view, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((View) it.next()).getParent() == view) {
                return true;
            }
        }
        return false;
    }
}
