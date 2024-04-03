package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IcBands extends BandSet {
    private int bit16Count = 0;
    private final CpBands cpBands;
    private final Set innerClasses = new TreeSet();
    private final Map outerToInner = new HashMap();

    public class IcTuple implements Comparable {

        /* renamed from: b  reason: collision with root package name */
        public CPClass f27744b;

        /* renamed from: c  reason: collision with root package name */
        public int f27745c;

        /* renamed from: d  reason: collision with root package name */
        public CPClass f27746d;

        /* renamed from: e  reason: collision with root package name */
        public CPUTF8 f27747e;

        public IcTuple(CPClass cPClass, int i11, CPClass cPClass2, CPUTF8 cputf8) {
            this.f27744b = cPClass;
            this.f27745c = i11;
            this.f27746d = cPClass2;
            this.f27747e = cputf8;
        }

        public int compareTo(Object obj) {
            return this.f27744b.compareTo(((IcTuple) obj).f27744b);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0039 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof org.apache.commons.compress.harmony.pack200.IcBands.IcTuple
                r1 = 0
                if (r0 == 0) goto L_0x003a
                org.apache.commons.compress.harmony.pack200.IcBands$IcTuple r4 = (org.apache.commons.compress.harmony.pack200.IcBands.IcTuple) r4
                org.apache.commons.compress.harmony.pack200.CPClass r0 = r3.f27744b
                org.apache.commons.compress.harmony.pack200.CPClass r2 = r4.f27744b
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x003a
                int r0 = r3.f27745c
                int r2 = r4.f27745c
                if (r0 != r2) goto L_0x003a
                org.apache.commons.compress.harmony.pack200.CPClass r0 = r3.f27746d
                if (r0 == 0) goto L_0x0024
                org.apache.commons.compress.harmony.pack200.CPClass r2 = r4.f27746d
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x003a
                goto L_0x0028
            L_0x0024:
                org.apache.commons.compress.harmony.pack200.CPClass r0 = r4.f27746d
                if (r0 != 0) goto L_0x003a
            L_0x0028:
                org.apache.commons.compress.harmony.pack200.CPUTF8 r0 = r3.f27747e
                if (r0 == 0) goto L_0x0035
                org.apache.commons.compress.harmony.pack200.CPUTF8 r4 = r4.f27747e
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x003a
                goto L_0x0039
            L_0x0035:
                org.apache.commons.compress.harmony.pack200.CPUTF8 r4 = r4.f27747e
                if (r4 != 0) goto L_0x003a
            L_0x0039:
                r1 = 1
            L_0x003a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.pack200.IcBands.IcTuple.equals(java.lang.Object):boolean");
        }

        public boolean isAnonymous() {
            String cPClass = this.f27744b.toString();
            return Character.isDigit(cPClass.substring(cPClass.lastIndexOf(36) + 1).charAt(0));
        }

        public String toString() {
            return this.f27744b.toString();
        }
    }

    public IcBands(SegmentHeader segmentHeader, CpBands cpBands2, int i11) {
        super(i11, segmentHeader);
        this.cpBands = cpBands2;
    }

    private void addToMap(String str, IcTuple icTuple) {
        List<IcTuple> list = (List) this.outerToInner.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.outerToInner.put(str, arrayList);
            arrayList.add(icTuple);
            return;
        }
        for (IcTuple equals : list) {
            if (icTuple.equals(equals)) {
                return;
            }
        }
        list.add(icTuple);
    }

    private String getOuter(String str) {
        return str.substring(0, str.lastIndexOf(36));
    }

    private boolean namesArePredictable(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append('$');
        sb2.append(str3);
        return str.equals(sb2.toString()) && str3.indexOf(36) == -1;
    }

    public void addInnerClass(String str, String str2, String str3, int i11) {
        if (str2 == null && str3 == null) {
            IcTuple icTuple = new IcTuple(this.cpBands.getCPClass(str), i11, (CPClass) null, (CPUTF8) null);
            addToMap(getOuter(str), icTuple);
            this.innerClasses.add(icTuple);
        } else if (namesArePredictable(str, str2, str3)) {
            IcTuple icTuple2 = new IcTuple(this.cpBands.getCPClass(str), i11, (CPClass) null, (CPUTF8) null);
            addToMap(str2, icTuple2);
            this.innerClasses.add(icTuple2);
        } else {
            IcTuple icTuple3 = new IcTuple(this.cpBands.getCPClass(str), i11 | 65536, this.cpBands.getCPClass(str2), this.cpBands.getCPUtf8(str3));
            if (this.innerClasses.add(icTuple3)) {
                this.bit16Count++;
                addToMap(str2, icTuple3);
            }
        }
    }

    public void finaliseBands() {
        this.segmentHeader.setIc_count(this.innerClasses.size());
    }

    public IcTuple getIcTuple(CPClass cPClass) {
        for (IcTuple icTuple : this.innerClasses) {
            if (icTuple.f27744b.equals(cPClass)) {
                return icTuple;
            }
        }
        return null;
    }

    public List getInnerClassesForOuter(String str) {
        return (List) this.outerToInner.get(str);
    }

    public void pack(OutputStream outputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        PackingUtils.log("Writing internal class bands...");
        int size = this.innerClasses.size();
        int[] iArr = new int[size];
        int size2 = this.innerClasses.size();
        int[] iArr2 = new int[size2];
        int i13 = this.bit16Count;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        ArrayList arrayList = new ArrayList(this.innerClasses);
        int i14 = 0;
        for (int i15 = 0; i15 < size; i15++) {
            IcTuple icTuple = (IcTuple) arrayList.get(i15);
            iArr[i15] = icTuple.f27744b.getIndex();
            int i16 = icTuple.f27745c;
            iArr2[i15] = i16;
            if ((i16 & 65536) != 0) {
                CPClass cPClass = icTuple.f27746d;
                if (cPClass == null) {
                    i11 = 0;
                } else {
                    i11 = cPClass.getIndex() + 1;
                }
                iArr3[i14] = i11;
                CPUTF8 cputf8 = icTuple.f27747e;
                if (cputf8 == null) {
                    i12 = 0;
                } else {
                    i12 = cputf8.getIndex() + 1;
                }
                iArr4[i14] = i12;
                i14++;
            }
        }
        byte[] encodeBandInt = encodeBandInt("ic_this_class", iArr, Codec.UDELTA5);
        outputStream.write(encodeBandInt);
        PackingUtils.log("Wrote " + encodeBandInt.length + " bytes from ic_this_class[" + size + "]");
        byte[] encodeBandInt2 = encodeBandInt("ic_flags", iArr2, Codec.UNSIGNED5);
        outputStream.write(encodeBandInt2);
        PackingUtils.log("Wrote " + encodeBandInt2.length + " bytes from ic_flags[" + size2 + "]");
        BHSDCodec bHSDCodec = Codec.DELTA5;
        byte[] encodeBandInt3 = encodeBandInt("ic_outer_class", iArr3, bHSDCodec);
        outputStream.write(encodeBandInt3);
        PackingUtils.log("Wrote " + encodeBandInt3.length + " bytes from ic_outer_class[" + i13 + "]");
        byte[] encodeBandInt4 = encodeBandInt("ic_name", iArr4, bHSDCodec);
        outputStream.write(encodeBandInt4);
        PackingUtils.log("Wrote " + encodeBandInt4.length + " bytes from ic_name[" + i13 + "]");
    }
}
