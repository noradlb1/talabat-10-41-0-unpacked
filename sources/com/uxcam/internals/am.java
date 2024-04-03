package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

public abstract class am {

    /* renamed from: a  reason: collision with root package name */
    public da f13001a;

    public am(da daVar) {
        this.f13001a = daVar;
    }

    public static void a(am amVar, List list, Collection collection) {
        if (list.size() > 0) {
            String str = (String) list.remove(0);
            if (amVar instanceof ed) {
                for (am amVar2 : ((ed) amVar).f13252b) {
                    if (str == null || str.equals(amVar2.f13001a.f13186a)) {
                        a(amVar2, list, collection);
                    }
                }
            }
            list.add(0, str);
            return;
        }
        collection.add(amVar);
    }

    public abstract void a(ByteBuffer byteBuffer);

    public void b(ByteBuffer byteBuffer) {
        long j11;
        ByteBuffer duplicate = byteBuffer.duplicate();
        byteBuffer.position(byteBuffer.position() + Math.min(byteBuffer.remaining(), 8));
        a(byteBuffer);
        da daVar = this.f13001a;
        long position = (long) ((byteBuffer.position() - duplicate.position()) - 8);
        long j12 = 16;
        if (daVar.f13187b > 4294967296L) {
            j11 = 16;
        } else {
            j11 = 8;
        }
        daVar.f13187b = position + j11;
        da daVar2 = this.f13001a;
        if (daVar2.f13187b <= 4294967296L) {
            j12 = 8;
        }
        if (j12 == ((long) 8)) {
            daVar2.a(duplicate);
            return;
        }
        throw new AssertionError();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    public void a(StringBuilder sb2) {
        StringBuilder a11 = hl.a("'");
        a11.append(this.f13001a.f13186a);
        a11.append("'");
        sb2.append(a11.toString());
    }
}
