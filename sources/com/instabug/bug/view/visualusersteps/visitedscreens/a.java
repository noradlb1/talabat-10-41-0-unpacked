package com.instabug.bug.view.visualusersteps.visitedscreens;

import androidx.recyclerview.widget.DiffUtil;
import com.instabug.bug.model.f;
import java.util.List;

public class a extends DiffUtil.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final List f45959a;

    /* renamed from: b  reason: collision with root package name */
    private final List f45960b;

    public a(List list, List list2) {
        this.f45959a = list;
        this.f45960b = list2;
    }

    public boolean areContentsTheSame(int i11, int i12) {
        return ((f) this.f45960b.get(i12)).equals(this.f45959a.get(i11));
    }

    public boolean areItemsTheSame(int i11, int i12) {
        return ((f) this.f45959a.get(i11)).b() == ((f) this.f45960b.get(i12)).b();
    }

    public int getNewListSize() {
        return this.f45960b.size();
    }

    public int getOldListSize() {
        return this.f45959a.size();
    }
}
