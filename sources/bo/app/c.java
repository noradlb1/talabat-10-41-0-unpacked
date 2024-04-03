package bo.app;

import java.util.List;

public final class c extends n3 {
    public c(List<e2> list) {
        super(list);
    }

    public boolean a(w2 w2Var) {
        boolean z11 = false;
        for (e2 a11 : this.f39042b) {
            if (!a11.a(w2Var)) {
                return false;
            }
            z11 = true;
        }
        return z11;
    }
}
