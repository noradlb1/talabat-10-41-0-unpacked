package com.uxcam.internals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class ab {

    /* renamed from: a  reason: collision with root package name */
    public int f12960a;

    /* renamed from: b  reason: collision with root package name */
    public int f12961b;

    /* renamed from: c  reason: collision with root package name */
    public int f12962c;

    /* renamed from: d  reason: collision with root package name */
    public ew f12963d;

    /* renamed from: e  reason: collision with root package name */
    public int f12964e;

    /* renamed from: f  reason: collision with root package name */
    public long f12965f;

    /* renamed from: g  reason: collision with root package name */
    public List f12966g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public List f12967h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public int f12968i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f12969j = 0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12970k;

    /* renamed from: l  reason: collision with root package name */
    public List f12971l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public List f12972m;

    public ab(int i11, int i12, int i13) {
        this.f12960a = i11;
        this.f12961b = i12;
        this.f12962c = i13;
    }

    public abstract am a(ea eaVar);

    public void a(ew ewVar, int i11) {
        this.f12963d = ewVar;
        this.f12964e = i11;
    }

    public abstract long b();

    public gp a() {
        short s11;
        ew ewVar;
        int i11 = 0;
        if (this.f12971l.get(0) instanceof in) {
            in inVar = (in) this.f12971l.get(0);
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(new String[]{"pasp"}[0]);
            am.a(inVar, linkedList2, linkedList);
            Object[] array = linkedList.toArray((Object[]) Array.newInstance(el.class, 0));
            if ((array.length > 0 ? array[0] : null) != null) {
                ewVar = new ew(0, 0);
            } else {
                ewVar = new ew(1, 1);
            }
            i11 = (ewVar.f13301a * inVar.f13654i) / ewVar.f13302b;
            s11 = inVar.f13655j;
        } else {
            s11 = 0;
        }
        return new gp(i11, s11);
    }
}
