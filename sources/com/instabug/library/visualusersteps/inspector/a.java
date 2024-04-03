package com.instabug.library.visualusersteps.inspector;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class a implements k {
    @NonNull
    /* renamed from: b */
    public l a(@NonNull Activity activity) {
        return new m(a(activity));
    }

    @NonNull
    public Collection a(@NonNull Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView instanceof ViewGroup) {
            return a((ViewGroup) decorView, new LinkedHashSet());
        }
        return Collections.singleton(decorView);
    }

    @NonNull
    private Collection a(@NonNull ViewGroup viewGroup, @NonNull Collection collection) {
        collection.add(viewGroup);
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            collection.add(childAt);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, collection);
            }
        }
        return collection;
    }
}
