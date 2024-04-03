package com.instabug.library.annotation;

import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class f implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f34117a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f34118b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f34119c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private Stack f34120d = new Stack();

    private void d() {
        this.f34117a.clear();
        this.f34117a.addAll(this.f34119c);
        this.f34117a.addAll(this.f34118b);
    }

    public void a(e eVar) {
        this.f34119c.add(eVar);
        d();
        this.f34120d.add(eVar);
    }

    public void b(e eVar) {
        this.f34118b.add(eVar);
        d();
        this.f34120d.add(eVar);
    }

    public int c(e eVar) {
        return this.f34117a.indexOf(eVar);
    }

    public void e(e eVar) {
        if (!this.f34118b.remove(eVar)) {
            this.f34119c.remove(eVar);
        }
        this.f34117a.remove(eVar);
        while (true) {
            int indexOf = this.f34120d.indexOf(eVar);
            if (indexOf != -1) {
                this.f34120d.remove(indexOf);
            } else {
                return;
            }
        }
    }

    @Nullable
    public e c() {
        if (this.f34120d.size() <= 0) {
            return null;
        }
        e eVar = (e) this.f34120d.pop();
        if (eVar.a()) {
            return null;
        }
        e(eVar);
        return eVar;
    }

    public List a() {
        return this.f34117a;
    }

    public int b() {
        return this.f34117a.size();
    }

    public void d(@Nullable e eVar) {
        if (eVar != null) {
            this.f34120d.push(eVar);
        }
    }

    public e a(int i11) {
        return (e) this.f34117a.get(i11);
    }
}
