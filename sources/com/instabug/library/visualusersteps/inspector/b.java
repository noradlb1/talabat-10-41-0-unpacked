package com.instabug.library.visualusersteps.inspector;

import android.view.View;
import io.reactivex.functions.Predicate;

class b implements Predicate {
    /* renamed from: a */
    public boolean test(View view) {
        return view.getVisibility() == 0;
    }
}
