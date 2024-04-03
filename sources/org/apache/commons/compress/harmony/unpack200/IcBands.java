package org.apache.commons.compress.harmony.unpack200;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.compress.harmony.unpack200.bytecode.ConstantPoolEntry;
import v20.a;

public class IcBands extends BandSet {
    private final String[] cpClass;
    private final String[] cpUTF8;
    private IcTuple[] icAll;
    private Map outerClassToTuples;
    private Map thisClassToTuple;

    public IcBands(Segment segment) {
        super(segment);
        this.cpClass = segment.getCpBands().getCpClass();
        this.cpUTF8 = segment.getCpBands().getCpUTF8();
    }

    public IcTuple[] getIcTuples() {
        return this.icAll;
    }

    public IcTuple[] getRelevantIcTuples(String str, ClassConstantPool classConstantPool) {
        IcTuple icTuple;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        List list = (List) this.outerClassToTuples.get(str);
        if (list != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                IcTuple icTuple2 = (IcTuple) list.get(i11);
                hashSet.add(icTuple2);
                arrayList.add(icTuple2);
            }
        }
        List entries = classConstantPool.entries();
        for (int i12 = 0; i12 < entries.size(); i12++) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) entries.get(i12);
            if ((constantPoolEntry instanceof CPClass) && (icTuple = (IcTuple) this.thisClassToTuple.get(((CPClass) constantPoolEntry).f27755name)) != null && hashSet.add(icTuple)) {
                arrayList.add(icTuple);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        ArrayList arrayList3 = new ArrayList();
        while (arrayList2.size() > 0) {
            arrayList3.clear();
            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                IcTuple icTuple3 = (IcTuple) arrayList2.get(i13);
                IcTuple icTuple4 = (IcTuple) this.thisClassToTuple.get(icTuple3.outerClassString());
                if (icTuple4 != null && !icTuple3.outerIsAnonymous()) {
                    arrayList3.add(icTuple4);
                }
            }
            arrayList2.clear();
            for (int i14 = 0; i14 < arrayList3.size(); i14++) {
                IcTuple icTuple5 = (IcTuple) arrayList3.get(i14);
                if (hashSet.add(icTuple5)) {
                    arrayList.add(icTuple5);
                    arrayList2.add(icTuple5);
                }
            }
        }
        Collections.sort(arrayList, new a());
        int size = arrayList.size();
        IcTuple[] icTupleArr = new IcTuple[size];
        for (int i15 = 0; i15 < size; i15++) {
            icTupleArr[i15] = (IcTuple) arrayList.get(i15);
        }
        return icTupleArr;
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception {
        int i11;
        int i12;
        String str;
        String str2;
        InputStream inputStream2 = inputStream;
        int innerClassCount = this.header.getInnerClassCount();
        int[] decodeBandInt = decodeBandInt("ic_this_class", inputStream2, Codec.UDELTA5, innerClassCount);
        String[] references = getReferences(decodeBandInt, this.cpClass);
        int[] decodeBandInt2 = decodeBandInt("ic_flags", inputStream2, Codec.UNSIGNED5, innerClassCount);
        int countBit16 = SegmentUtils.countBit16(decodeBandInt2);
        int[] decodeBandInt3 = decodeBandInt("ic_outer_class", inputStream2, Codec.DELTA5, countBit16);
        String[] strArr = new String[countBit16];
        for (int i13 = 0; i13 < countBit16; i13++) {
            int i14 = decodeBandInt3[i13];
            if (i14 == 0) {
                strArr[i13] = null;
            } else {
                strArr[i13] = this.cpClass[i14 - 1];
            }
        }
        int[] decodeBandInt4 = decodeBandInt("ic_name", inputStream2, Codec.DELTA5, countBit16);
        String[] strArr2 = new String[countBit16];
        for (int i15 = 0; i15 < countBit16; i15++) {
            int i16 = decodeBandInt4[i15];
            if (i16 == 0) {
                strArr2[i15] = null;
            } else {
                strArr2[i15] = this.cpUTF8[i16 - 1];
            }
        }
        this.icAll = new IcTuple[references.length];
        int i17 = 0;
        for (int i18 = 0; i18 < references.length; i18++) {
            String str3 = references[i18];
            int i19 = decodeBandInt2[i18];
            int i21 = decodeBandInt[i18];
            if ((65536 & i19) != 0) {
                String str4 = strArr[i17];
                String str5 = strArr2[i17];
                i17++;
                i11 = decodeBandInt4[i17] - 1;
                i12 = decodeBandInt3[i17] - 1;
                str = str5;
                str2 = str4;
            } else {
                str2 = null;
                str = null;
                i12 = -1;
                i11 = -1;
            }
            this.icAll[i18] = new IcTuple(str3, i19, str2, str, i21, i12, i11, i18);
        }
    }

    public void unpack() throws IOException, Pack200Exception {
        IcTuple[] icTuples = getIcTuples();
        this.thisClassToTuple = new HashMap(icTuples.length);
        this.outerClassToTuples = new HashMap(icTuples.length);
        int i11 = 0;
        while (i11 < icTuples.length) {
            IcTuple icTuple = icTuples[i11];
            if (this.thisClassToTuple.put(icTuple.thisClassString(), icTuple) == null) {
                if ((!icTuple.isAnonymous() && !icTuple.outerIsAnonymous()) || icTuple.nestedExplicitFlagSet()) {
                    String outerClassString = icTuple.outerClassString();
                    List list = (List) this.outerClassToTuples.get(outerClassString);
                    if (list == null) {
                        list = new ArrayList();
                        this.outerClassToTuples.put(outerClassString, list);
                    }
                    list.add(icTuple);
                }
                i11++;
            } else {
                throw new Error("Collision detected in <thisClassString, IcTuple> mapping. There are at least two inner clases with the same name.");
            }
        }
    }
}
