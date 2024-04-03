package com.huawei.hms.analytics;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class av {
    private static final av klm = new av();
    private volatile au fgh;
    private volatile au ghi;
    private Map<String, ay> hij = new ConcurrentHashMap();
    private final Object ijk = new Object();
    private final Object ikl = new Object();
    public ax lmn = new ax();

    public static av lmn() {
        return klm;
    }

    public final au ikl() {
        if (this.fgh == null) {
            synchronized (this.ijk) {
                if (this.fgh == null) {
                    this.fgh = new aw(this.lmn.ghi);
                }
            }
        }
        return this.fgh;
    }

    public final au klm() {
        if (this.ghi == null) {
            synchronized (this.ikl) {
                if (this.ghi == null) {
                    this.ghi = new bf(this.lmn.ghi);
                }
            }
        }
        return this.ghi;
    }

    public final ay lmn(String str) {
        ay ayVar = this.hij.get(str);
        if (ayVar != null) {
            return ayVar;
        }
        ay ayVar2 = new ay();
        this.hij.put(str, ayVar2);
        return ayVar2;
    }
}
