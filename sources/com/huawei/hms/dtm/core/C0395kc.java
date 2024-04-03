package com.huawei.hms.dtm.core;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.huawei.hms.dtm.core.kc  reason: case insensitive filesystem */
public class C0395kc extends Y {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48507a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f48508b;

    /* renamed from: c  reason: collision with root package name */
    private String f48509c;

    public C0395kc() {
        this.f48507a = false;
        this.f48508b = false;
        this.f48509c = "_re";
    }

    public C0395kc(boolean z11, boolean z12, String str) {
        this.f48507a = z11;
        this.f48508b = z12;
        this.f48509c = str;
    }

    public C0430rc a(X x11, List<C0435sc<?>> list) throws V {
        if (list != null && list.size() == 2) {
            boolean z11 = false;
            if (!(list.get(0) == null || list.get(1) == null)) {
                String scVar = list.get(0).toString();
                String scVar2 = list.get(1).toString();
                try {
                    if (this.f48508b != (this.f48507a ? Pattern.compile(scVar2, 2) : Pattern.compile(scVar2)).matcher(scVar).matches()) {
                        z11 = true;
                    }
                    return C0430rc.a(z11);
                } catch (PatternSyntaxException unused) {
                    throw new V(this.f48509c + "#regular match failed");
                }
            }
        }
        throw new V(this.f48509c + "#wrong params");
    }

    public String a() {
        return "_re";
    }
}
