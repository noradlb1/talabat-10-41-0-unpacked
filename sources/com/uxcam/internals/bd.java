package com.uxcam.internals;

import java.util.HashMap;
import java.util.Map;

public class bd {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f13061a;

    public static class aa implements hg {
        public void a(ek ekVar, ek ekVar2) {
            for (int i11 = 0; i11 < 3; i11++) {
                System.arraycopy(ekVar.f13284d[i11], 0, ekVar2.f13284d[i11], 0, Math.min(ekVar.a(i11) * ekVar.b(i11), ekVar2.a(i11) * ekVar2.b(i11)));
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f13061a = hashMap;
        HashMap hashMap2 = new HashMap();
        bc bcVar = bc.RGB;
        hashMap2.put(bcVar, new aa());
        bc bcVar2 = bc.YUV420;
        hashMap2.put(bcVar2, new fa(0, 0));
        bc bcVar3 = bc.YUV420J;
        hashMap2.put(bcVar3, new ez());
        bc bcVar4 = bc.YUV422;
        hashMap2.put(bcVar4, new fb(0, 0));
        bc bcVar5 = bc.YUV422_10;
        hashMap2.put(bcVar5, new fb(2, 0));
        hashMap.put(bcVar, hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(bcVar2, new aa());
        hashMap3.put(bcVar, new iw(0, 0));
        hashMap3.put(bcVar4, new ix(0, 0));
        hashMap3.put(bcVar5, new ix(0, 2));
        hashMap.put(bcVar2, hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(bcVar4, new aa());
        hashMap4.put(bcVar, new ja(0, 0));
        hashMap4.put(bcVar2, new jc(0, 0));
        hashMap4.put(bcVar3, new jb(0, 0));
        hashMap.put(bcVar4, hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(bcVar5, new aa());
        hashMap5.put(bcVar, new ja(2, 0));
        hashMap5.put(bcVar2, new jc(0, 2));
        hashMap5.put(bcVar3, new jb(0, 2));
        hashMap.put(bcVar5, hashMap5);
        HashMap hashMap6 = new HashMap();
        bc bcVar6 = bc.YUV444;
        hashMap6.put(bcVar6, new aa());
        hashMap6.put(bcVar, new jf(0, 0));
        hashMap6.put(bcVar2, new jg(0, 0));
        hashMap.put(bcVar6, hashMap6);
        HashMap hashMap7 = new HashMap();
        bc bcVar7 = bc.YUV444_10;
        hashMap7.put(bcVar7, new aa());
        hashMap7.put(bcVar, new jf(2, 0));
        hashMap7.put(bcVar2, new jg(0, 2));
        hashMap.put(bcVar7, hashMap7);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(bcVar3, new aa());
        hashMap8.put(bcVar, new iu());
        hashMap8.put(bcVar2, new iv());
        hashMap.put(bcVar3, hashMap8);
        HashMap hashMap9 = new HashMap();
        bc bcVar8 = bc.YUV422J;
        hashMap9.put(bcVar8, new aa());
        hashMap9.put(bcVar, new iy());
        hashMap9.put(bcVar2, new iz());
        hashMap9.put(bcVar3, new jc(0, 0));
        hashMap.put(bcVar8, hashMap9);
        HashMap hashMap10 = new HashMap();
        bc bcVar9 = bc.YUV444J;
        hashMap10.put(bcVar9, new aa());
        hashMap10.put(bcVar, new jd());
        hashMap10.put(bcVar2, new je());
        hashMap10.put(bcVar3, new jg(0, 0));
        hashMap.put(bcVar9, hashMap10);
    }
}
