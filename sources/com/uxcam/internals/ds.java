package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ds {

    /* renamed from: a  reason: collision with root package name */
    public final List f13229a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public long f13230b;

    /* renamed from: c  reason: collision with root package name */
    public gb f13231c;

    /* renamed from: d  reason: collision with root package name */
    public int f13232d = 1;

    public ds(gb gbVar, bz bzVar) {
        this.f13231c = gbVar;
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        bzVar.b(allocate);
        new da("wide", 8).a(allocate);
        new da("mdat", 1).a(allocate);
        this.f13230b = (long) allocate.position();
        allocate.putLong(0);
        allocate.flip();
        ((bx) gbVar).write(allocate);
    }
}
