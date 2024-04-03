package com.uxcam.internals;

import com.uxcam.internals.bg;
import com.uxcam.internals.fh;
import com.uxcam.internals.gv;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ch extends ab {
    public int A;
    public boolean B = true;

    /* renamed from: n  reason: collision with root package name */
    public final List f13118n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public final dq f13119o = new dq();

    /* renamed from: p  reason: collision with root package name */
    public final de f13120p = new de();

    /* renamed from: q  reason: collision with root package name */
    public final de f13121q = new de();

    /* renamed from: r  reason: collision with root package name */
    public final List f13122r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public final gb f13123s;

    /* renamed from: t  reason: collision with root package name */
    public long f13124t = 0;

    /* renamed from: u  reason: collision with root package name */
    public long f13125u = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f13126v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f13127w = 0;

    /* renamed from: x  reason: collision with root package name */
    public long f13128x = 0;

    /* renamed from: y  reason: collision with root package name */
    public int f13129y = -1;

    /* renamed from: z  reason: collision with root package name */
    public long f13130z;

    public ch(gb gbVar, int i11, int i12, int i13) {
        super(i11, i12, i13);
        this.f13123s = gbVar;
        a(new ew(1, 1), 1);
    }

    public void a(dt dtVar) {
        if (!this.f12970k) {
            int i11 = (int) (dtVar.f13233a - this.f13128x);
            int i12 = this.f13126v;
            boolean z11 = false;
            if (i11 != i12) {
                int i13 = this.f13127w;
                if (i13 > 0) {
                    this.f13122r.add(new bg.aa(i13, i12));
                }
                this.f13126v = i11;
                this.f13127w = 0;
            }
            this.f13127w++;
            this.f13128x += dtVar.f13234b;
            int i14 = this.f13129y;
            if (!(i14 == -1 || i14 == 1)) {
                a(i14);
                this.f12968i = -1;
            }
            this.f12966g.add(dtVar.f13235c);
            this.f13121q.a(this.A + 1);
            this.A++;
            long j11 = this.f12965f;
            long j12 = dtVar.f13234b;
            this.f12965f = j11 + j12;
            long j13 = this.f13125u;
            if (!(j13 == -1 || j12 == j13)) {
                this.f13118n.add(new gv.aa((int) this.f13124t, (int) j13));
                this.f13124t = 0;
            }
            long j14 = dtVar.f13234b;
            this.f13125u = j14;
            this.f13124t++;
            this.f13130z += j14;
            int i15 = this.f12964e;
            if (i15 == 1 || i15 == 2) {
                z11 = true;
            }
            if (z11) {
                if (i15 == 1) {
                    int size = this.f12966g.size();
                    ew ewVar = this.f12963d;
                    if (size * ewVar.f13302b == ewVar.f13301a) {
                        a(1);
                        this.f13129y = 1;
                        return;
                    }
                }
                if (this.f12964e == 2) {
                    long j15 = this.f12965f;
                    if (j15 > 0) {
                        ew ewVar2 = this.f12963d;
                        if (j15 * ((long) ewVar2.f13302b) >= ((long) (ewVar2.f13301a * this.f12962c))) {
                            a(1);
                        }
                    }
                }
                this.f13129y = 1;
                return;
            }
            throw new AssertionError();
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }

    public long b() {
        return this.f13130z;
    }

    public void a(int i11) {
        if (this.f12966g.size() != 0) {
            dq dqVar = this.f13119o;
            long position = ((bx) this.f13123s).f13097a.position();
            int i12 = dqVar.f13228b;
            long[] jArr = dqVar.f13227a;
            if (i12 >= jArr.length) {
                long[] jArr2 = new long[(jArr.length + 128)];
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                dqVar.f13227a = jArr2;
            }
            long[] jArr3 = dqVar.f13227a;
            int i13 = dqVar.f13228b;
            dqVar.f13228b = i13 + 1;
            jArr3[i13] = position;
            for (ByteBuffer byteBuffer : this.f12966g) {
                this.f13120p.a(byteBuffer.remaining());
                ((bx) this.f13123s).f13097a.write(byteBuffer);
            }
            int i14 = this.f12968i;
            if (i14 == -1 || i14 != this.f12966g.size()) {
                this.f12967h.add(new fh.aa((long) (this.f12969j + 1), this.f12966g.size(), i11));
            }
            this.f12968i = this.f12966g.size();
            this.f12969j++;
            this.f12965f = 0;
            this.f12966g.clear();
        }
    }

    public am a(ea eaVar) {
        if (!this.f12970k) {
            a(this.f13129y);
            long j11 = this.f13124t;
            if (j11 > 0) {
                this.f13118n.add(new gv.aa((int) j11, (int) this.f13125u));
            }
            this.f12970k = true;
            hf hfVar = new hf();
            gp a11 = a();
            hd hdVar = r6;
            hd hdVar2 = new hd(this.f12960a, (((long) eaVar.f13243c) * this.f13130z) / ((long) this.f12962c), (float) a11.f13486a, (float) a11.f13487b, new Date().getTime(), new Date().getTime(), 1.0f, 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
            hdVar.f13131b = 15;
            hfVar.f13252b.add(hdVar);
            gp a12 = a();
            if (this.f12961b == 1) {
                ed edVar = new ed(new da("tapt"));
                int i11 = a12.f13486a;
                int i12 = a12.f13487b;
                ax axVar = new ax();
                axVar.f13035c = (float) i11;
                axVar.f13036d = (float) i12;
                edVar.f13252b.add(axVar);
                edVar.f13252b.add(new er(a12.f13486a, a12.f13487b));
                edVar.f13252b.add(new br(a12.f13486a, a12.f13487b));
                hfVar.f13252b.add(edVar);
            }
            dw dwVar = new dw();
            hfVar.f13252b.add(dwVar);
            dwVar.f13252b.add(new dx(this.f12962c, this.f13130z, 0, new Date().getTime(), new Date().getTime(), 0));
            dwVar.f13252b.add(new cz("mhlr", he.a(this.f12961b), "appl", 0, 0));
            dy dyVar = new dy();
            dwVar.f13252b.add(dyVar);
            int i13 = this.f12961b;
            int a13 = fy.a(i13);
            if (a13 == 0) {
                im imVar = new im(0, 0, 0, 0);
                imVar.f13131b = 1;
                dyVar.f13252b.add(imVar);
            } else if (a13 == 1) {
                gr grVar = new gr();
                grVar.f13131b = 1;
                dyVar.f13252b.add(grVar);
            } else if (a13 == 2) {
                ed edVar2 = new ed(new da("gmhd"));
                edVar2.f13252b.add(new cp(new da("gmin")));
                ed edVar3 = new ed(new da("tmcd"));
                edVar2.f13252b.add(edVar3);
                gx gxVar = new gx(new da("tcmi"));
                gxVar.f13510c = 0;
                gxVar.f13511d = 0;
                gxVar.f13512e = 12;
                gxVar.f13513f = new short[]{0, 0, 0};
                gxVar.f13514g = new short[]{255, 255, 255};
                gxVar.f13515h = "Lucida Grande";
                edVar3.f13252b.add(gxVar);
                dyVar.f13252b.add(edVar2);
            } else {
                StringBuilder a14 = hl.a("Handler ");
                a14.append(he.a(i13));
                a14.append(" not supported");
                throw new IllegalStateException(a14.toString());
            }
            dyVar.f13252b.add(new cz("dhlr", "url ", "appl", 0, 0));
            bk bkVar = new bk();
            dyVar.f13252b.add(bkVar);
            bl blVar = new bl(new da("dref"));
            bkVar.f13252b.add(blVar);
            blVar.f13252b.add(new dl(new da("alis", 0), ByteBuffer.wrap(new byte[]{0, 0, 0, 1})));
            ed edVar4 = new ed(new da("stbl"));
            dyVar.f13252b.add(edVar4);
            if (this.f13122r.size() > 0) {
                this.f13122r.add(new bg.aa(this.f13127w, this.f13126v));
                int i14 = Integer.MAX_VALUE;
                for (bg.aa aaVar : this.f13122r) {
                    int i15 = aaVar.f13065b;
                    if (i15 < i14) {
                        i14 = i15;
                    }
                }
                if (i14 > 0) {
                    for (bg.aa aaVar2 : this.f13122r) {
                        aaVar2.f13065b -= i14;
                    }
                }
                bg.aa aaVar3 = (bg.aa) this.f13122r.get(0);
                if (aaVar3.f13065b > 0) {
                    List<bo> list = this.f12972m;
                    if (list == null) {
                        ArrayList arrayList = new ArrayList();
                        this.f12972m = arrayList;
                        arrayList.add(new bo(this.f13130z, (long) aaVar3.f13065b, 1.0f));
                    } else {
                        for (bo boVar : list) {
                            boVar.f13082c += (long) aaVar3.f13065b;
                        }
                    }
                }
                edVar4.f13252b.add(new bg((bg.aa[]) this.f13122r.toArray(new bg.aa[0])));
            }
            if (this.f12972m != null) {
                ed edVar5 = new ed(new da("edts"));
                List list2 = this.f12972m;
                bp bpVar = new bp();
                bpVar.f13083c = list2;
                edVar5.f13252b.add(bpVar);
                hfVar.f13252b.add(edVar5);
            }
            ff[] ffVarArr = (ff[]) this.f12971l.toArray(new ff[0]);
            fe feVar = new fe();
            for (ff add : ffVarArr) {
                feVar.f13252b.add(add);
            }
            edVar4.f13252b.add(feVar);
            edVar4.f13252b.add(new fh((fh.aa[]) this.f12967h.toArray(new fh.aa[0])));
            int[] a15 = this.f13120p.a();
            fg fgVar = new fg();
            fgVar.f13310c = a15;
            edVar4.f13252b.add(fgVar);
            edVar4.f13252b.add(new gv((gv.aa[]) this.f13118n.toArray(new gv.aa[0])));
            dq dqVar = this.f13119o;
            int i16 = dqVar.f13228b;
            long[] jArr = new long[i16];
            System.arraycopy(dqVar.f13227a, 0, jArr, 0, i16);
            au auVar = new au();
            auVar.f13034c = jArr;
            edVar4.f13252b.add(auVar);
            if (!this.B) {
                de deVar = this.f13121q;
                if (deVar.f13191b > 0) {
                    int[] a16 = deVar.a();
                    gt gtVar = new gt();
                    gtVar.f13501c = a16;
                    edVar4.f13252b.add(gtVar);
                }
            }
            return hfVar;
        }
        throw new IllegalStateException("The muxer track has finished muxing");
    }
}
