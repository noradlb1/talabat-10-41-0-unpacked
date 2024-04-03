package com.instabug.featuresrequest.ui.featuresmain.mainmyfeatures;

import com.instabug.featuresrequest.models.d;
import java.util.ArrayList;
import java.util.List;

public class a extends com.instabug.featuresrequest.ui.base.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f46796c;

    /* renamed from: b  reason: collision with root package name */
    private List f46797b;

    private a() {
        if (f46796c == null) {
            this.f46797b = new ArrayList();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class");
    }

    public static a e() {
        if (f46796c == null) {
            synchronized (a.class) {
                if (f46796c == null) {
                    f46796c = new a();
                }
            }
        }
        return f46796c;
    }

    public d a(int i11) {
        return (d) this.f46797b.get(i11);
    }

    public List b() {
        return this.f46797b;
    }

    public void c() {
        this.f46797b.clear();
    }

    public void d(List list) {
        this.f46797b.addAll(list);
    }

    public int f() {
        return this.f46797b.size();
    }
}
