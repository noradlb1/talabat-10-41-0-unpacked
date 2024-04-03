package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.qc  reason: case insensitive filesystem */
public class C0425qc extends Y {

    /* renamed from: a  reason: collision with root package name */
    private Map<Character, Integer> f48545a;

    public C0425qc() {
        HashMap hashMap = new HashMap();
        this.f48545a = hashMap;
        hashMap.put('0', 0);
        this.f48545a.put(Character.valueOf(ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK), 1);
        this.f48545a.put('2', 2);
        this.f48545a.put('3', 3);
        this.f48545a.put('4', 4);
        this.f48545a.put('5', 5);
        this.f48545a.put('6', 6);
        this.f48545a.put('7', 7);
        this.f48545a.put('8', 8);
        this.f48545a.put('9', 9);
        this.f48545a.put('A', 10);
        this.f48545a.put('B', 11);
        this.f48545a.put('C', 12);
        this.f48545a.put('D', 13);
        this.f48545a.put('E', 14);
        this.f48545a.put('F', 15);
    }

    private Integer a(Character ch2) {
        if (this.f48545a.containsKey(ch2)) {
            return this.f48545a.get(ch2);
        }
        throw new V("_xor#the char should be [0-9A-F]");
    }

    private void a(List<C0435sc<?>> list) throws V {
        if (list == null || !(list.size() == 2 || list.size() == 3)) {
            throw new V("_xor#params error");
        } else if (list.get(0) == null) {
            throw new V("_xor#1st param null");
        }
    }

    public Cc a(X x11, List<C0435sc<?>> list) throws V {
        boolean z11;
        double d11;
        byte[] bArr;
        a(list);
        int i11 = 0;
        String scVar = list.get(0).toString();
        if (TextUtils.isEmpty(scVar)) {
            return Cc.f48270b;
        }
        C0435sc scVar2 = list.get(1);
        if (3 == list.size()) {
            C0435sc scVar3 = list.get(2);
            if (scVar3 instanceof C0430rc) {
                z11 = ((Boolean) ((C0430rc) scVar3).value()).booleanValue();
            } else {
                throw new V("_xor#wrong params");
            }
        } else {
            z11 = false;
        }
        if (scVar2 instanceof C0440tc) {
            d11 = ((Double) ((C0440tc) scVar2).value()).doubleValue();
        } else if (scVar2 instanceof C0450vc) {
            d11 = (double) ((Integer) ((C0450vc) scVar2).value()).intValue();
        } else {
            throw new V("_xor#only support number type");
        }
        if (!z11) {
            bArr = scVar.getBytes(StandardCharsets.UTF_8);
        } else {
            int length = scVar.length();
            if (length % 2 == 0) {
                byte[] bArr2 = new byte[(scVar.length() / 2)];
                for (int i12 = 0; i12 < length; i12 += 2) {
                    bArr2[i12 / 2] = (byte) ((a(Character.valueOf(scVar.charAt(i12))).intValue() * 16) + a(Character.valueOf(scVar.charAt(i12 + 1))).intValue());
                }
                bArr = bArr2;
            } else {
                throw new V("_xor#the length of string should be even");
            }
        }
        byte[] bArr3 = new byte[bArr.length];
        int length2 = bArr.length;
        int i13 = 0;
        while (i11 < length2) {
            bArr3[i13] = (byte) (bArr[i11] ^ ((int) d11));
            i11++;
            i13++;
        }
        return new Cc(new String(bArr3, StandardCharsets.UTF_8));
    }

    public String a() {
        return "_xor";
    }
}
