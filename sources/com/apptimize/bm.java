package com.apptimize;

import com.apptimize.bk;
import com.apptimize.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bm {
    public static el a(bl blVar) {
        cm b11 = b(blVar.f41385b, blVar.f41384a);
        if (b11 == null) {
            return null;
        }
        return new el(b11, blVar.f41386c);
    }

    private static cm b(bk bkVar, String str) {
        long a11 = bkVar.a();
        String str2 = "Variant " + String.valueOf(a11);
        List<bt> a12 = a(bkVar, str);
        if (a12 == null) {
            return null;
        }
        return new cm(bv.f41512a, cf.f41640a, a11, (Long) null, str, (ApptimizeTestType) null, str2, a12, (Long) null, 1, 1);
    }

    public static List<bt> a(bk bkVar, String str) {
        if (bkVar instanceof bk.c) {
            return Collections.singletonList(new bt.a(str, ((bk.c) bkVar).b(), false, bv.f41512a, cf.f41640a));
        } else if (bkVar instanceof bk.d) {
            String b11 = ((bk.d) bkVar).b();
            if (b11 == null) {
                return null;
            }
            return Collections.singletonList(new bt.i(str, b11, false, bv.f41512a, cf.f41640a));
        } else if (bkVar instanceof bk.b) {
            Integer b12 = ((bk.b) bkVar).b();
            if (b12 == null) {
                return null;
            }
            return Collections.singletonList(new bt.e(str, b12, false, bv.f41512a, cf.f41640a));
        } else if (bkVar instanceof bk.a) {
            Double b13 = ((bk.a) bkVar).b();
            if (b13 == null) {
                return null;
            }
            return Collections.singletonList(new bt.d(str, b13, false, bv.f41512a, cf.f41640a));
        } else if (bkVar instanceof bk.e) {
            ArrayList arrayList = new ArrayList();
            for (bn bnVar : ((bk.e) bkVar).b()) {
                for (dc kVar : bnVar.f41388a.f41391a) {
                    arrayList.add(new bt.k(kVar, bv.f41512a, cf.f41640a));
                }
            }
            return arrayList;
        } else {
            throw new IllegalArgumentException("Unrecognized type of Variation");
        }
    }
}
