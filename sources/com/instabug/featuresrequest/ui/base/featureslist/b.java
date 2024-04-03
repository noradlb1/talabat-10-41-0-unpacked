package com.instabug.featuresrequest.ui.base.featureslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.listeners.a;

public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private n f46625a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f46626b;

    public b(n nVar, a aVar) {
        this.f46625a = nVar;
        this.f46626b = aVar;
    }

    public int getCount() {
        return this.f46625a.a();
    }

    public Object getItem(int i11) {
        return Integer.valueOf(i11);
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ib_fr_feature_request_item, viewGroup, false);
            eVar = new e(view, this.f46626b);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        this.f46625a.a(i11, eVar);
        view.setOnClickListener(new a(this, i11));
        return view;
    }
}
