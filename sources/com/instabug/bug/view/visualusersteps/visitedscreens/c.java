package com.instabug.bug.view.visualusersteps.visitedscreens;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.bug.R;
import com.instabug.bug.model.f;
import java.util.ArrayList;

public class c extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private d f45968a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f45969b = new ArrayList();

    public c(d dVar) {
        this.f45968a = dVar;
    }

    public f a(int i11) {
        return (f) this.f45969b.get(i11);
    }

    @NonNull
    /* renamed from: a */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ibg_bug_repro_steps_item, viewGroup, false), this.f45968a);
    }

    /* renamed from: a */
    public void onBindViewHolder(@NonNull b bVar, int i11) {
        bVar.b(a(i11));
    }

    public void b(ArrayList arrayList) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new a(this.f45969b, arrayList), true);
        this.f45969b.clear();
        this.f45969b.addAll(arrayList);
        calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this);
    }

    public int getItemCount() {
        return this.f45969b.size();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }
}
