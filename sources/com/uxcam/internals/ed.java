package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ed extends am {

    /* renamed from: b  reason: collision with root package name */
    public List f13252b = new LinkedList();

    public ed(da daVar) {
        super(daVar);
        an anVar = an.f13002a;
    }

    public void a(ByteBuffer byteBuffer) {
        for (am b11 : this.f13252b) {
            b11.b(byteBuffer);
        }
    }

    public void b(StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder();
        Iterator it = this.f13252b.iterator();
        while (it.hasNext()) {
            ((am) it.next()).a(sb3);
            if (it.hasNext()) {
                sb3.append(",\n");
            }
        }
        sb2.append(sb3.toString().replaceAll("([^\n]*)\n", "  $1\n"));
    }

    public void a(StringBuilder sb2) {
        super.a(sb2);
        sb2.append(": {\n");
        b(sb2);
        sb2.append("\n}");
    }
}
