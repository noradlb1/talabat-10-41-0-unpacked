package com.instabug.featuresrequest.ui.featuresmain.mainallfeatures;

import com.instabug.featuresrequest.models.d;
import java.util.ArrayList;
import java.util.List;

public class a extends com.instabug.featuresrequest.ui.base.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f46794c;

    /* renamed from: b  reason: collision with root package name */
    private List f46795b;

    private a() {
        if (f46794c == null) {
            this.f46795b = new ArrayList();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class");
    }

    public static a e() {
        if (f46794c == null) {
            synchronized (a.class) {
                if (f46794c == null) {
                    f46794c = new a();
                }
            }
        }
        return f46794c;
    }

    public d a(int i11) {
        return (d) this.f46795b.get(i11);
    }

    public List b() {
        return this.f46795b;
    }

    public void c() {
        this.f46795b.clear();
    }

    public void d(List list) {
        this.f46795b.addAll(list);
    }

    public int f() {
        return this.f46795b.size();
    }
}
