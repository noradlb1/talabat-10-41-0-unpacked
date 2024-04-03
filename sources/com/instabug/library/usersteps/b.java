package com.instabug.library.usersteps;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.instabug.library.visualusersteps.d;
import com.instabug.library.visualusersteps.e;
import com.instabug.library.visualusersteps.j;
import com.instabug.library.visualusersteps.y;

class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f51999a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f52000b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f52001c;

    public b(g gVar, View view, String str, String str2) {
        this.f51999a = view;
        this.f52000b = str;
        this.f52001c = str2;
    }

    public void a(@Nullable d dVar, @Nullable e eVar) {
        if (eVar != null) {
            View view = this.f51999a;
            if (!(view instanceof EditText)) {
                y.d().b(dVar, this.f52000b, this.f52001c, eVar.b(), eVar.a());
            } else if (!view.isFocusable()) {
                y.d().b(dVar, this.f52000b, this.f52001c, eVar.b(), eVar.a());
            }
        }
    }
}
