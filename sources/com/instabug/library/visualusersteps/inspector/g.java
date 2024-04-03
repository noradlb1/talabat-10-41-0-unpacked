package com.instabug.library.visualusersteps.inspector;

import android.graphics.Rect;
import android.view.View;
import com.instabug.library.util.ListUtils;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

class g implements Function {
    /* renamed from: a */
    public Collection apply(Collection collection) {
        return a(ListUtils.toList(collection));
    }

    private Collection a(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            View view = (View) list.get(i11);
            if (!a(view, (Collection) list.subList(i11, list.size()))) {
                linkedHashSet.add(view);
            }
        }
        return linkedHashSet;
    }

    private boolean a(View view, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (a(view, (View) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return false;
        }
        return a(view).intersect(a(view2));
    }

    private Rect a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
