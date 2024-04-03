package com.instabug.bug.view.reporting.bugreporting;

import com.instabug.bug.extendedbugreport.a;
import com.instabug.bug.view.reporting.g0;
import com.instabug.bug.view.reporting.i0;

public class b extends g0 {
    public b(i0 i0Var) {
        super(i0Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.instabug.bug.view.reporting.i0) r0.get();
     */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r2 = this;
            java.lang.ref.WeakReference<V> r0 = r2.f34200f
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.get()
            com.instabug.bug.view.reporting.i0 r0 = (com.instabug.bug.view.reporting.i0) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.j()
            goto L_0x0013
        L_0x0011:
            java.lang.String r0 = ""
        L_0x0013:
            com.instabug.library.InstabugCustomTextPlaceHolder$Key r1 = com.instabug.library.InstabugCustomTextPlaceHolder.Key.COMMENT_FIELD_HINT_FOR_BUG_REPORT
            java.lang.String r0 = com.instabug.library.util.PlaceHolderUtils.getPlaceHolder(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.reporting.bugreporting.b.a():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.instabug.bug.view.reporting.i0) r0.get();
     */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_RETURN_ANNOTATION"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h() {
        /*
            r2 = this;
            java.lang.ref.WeakReference<V> r0 = r2.f34200f
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.get()
            com.instabug.bug.view.reporting.i0 r0 = (com.instabug.bug.view.reporting.i0) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.v()
            goto L_0x0013
        L_0x0011:
            java.lang.String r0 = ""
        L_0x0013:
            com.instabug.library.InstabugCustomTextPlaceHolder$Key r1 = com.instabug.library.InstabugCustomTextPlaceHolder.Key.REPORT_BUG
            java.lang.String r0 = com.instabug.library.util.PlaceHolderUtils.getPlaceHolder(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.view.reporting.bugreporting.b.h():java.lang.String");
    }

    public boolean i() {
        return !com.instabug.bug.settings.b.f().e().isEmpty() || com.instabug.bug.settings.b.f().d() != a.DISABLED;
    }

    public String u() {
        return "bug";
    }
}
