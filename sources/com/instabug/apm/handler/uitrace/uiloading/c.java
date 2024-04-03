package com.instabug.apm.handler.uitrace.uiloading;

import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.model.d;
import com.instabug.apm.model.e;
import com.instabug.apm.util.a;
import java.util.concurrent.TimeUnit;

public class c implements a {
    private long b(e[] eVarArr) {
        return eVarArr[4].b() - eVarArr[1].b();
    }

    private long c(e[] eVarArr) {
        return eVarArr[1].c();
    }

    private long d(e[] eVarArr) {
        if (m(eVarArr)) {
            return eVarArr[10].b() - eVarArr[9].b();
        }
        return 0;
    }

    private long e(e[] eVarArr) {
        return eVarArr[9].c();
    }

    private long f(e[] eVarArr) {
        return eVarArr[9].b() - eVarArr[7].b();
    }

    private long g(e[] eVarArr) {
        return eVarArr[7].c();
    }

    private long h(e[] eVarArr) {
        return eVarArr[1].c();
    }

    private long i(e[] eVarArr) {
        return eVarArr[7].b() - eVarArr[4].b();
    }

    private long j(e[] eVarArr) {
        return eVarArr[4].c();
    }

    private long k(e[] eVarArr) {
        long b11;
        e eVar;
        if (!l(eVarArr) || !m(eVarArr)) {
            b11 = eVarArr[9].b();
            eVar = eVarArr[1];
        } else {
            b11 = eVarArr[10].b();
            eVar = eVarArr[1];
        }
        return b11 - eVar.b();
    }

    private boolean l(e[] eVarArr) {
        return !(eVarArr[10] instanceof d);
    }

    private boolean m(e[] eVarArr) {
        return eVarArr[10].b() > eVarArr[9].b();
    }

    @Nullable
    public i a(e[] eVarArr) {
        a.a(eVarArr, new d());
        if (eVarArr.length != 11) {
            return null;
        }
        i iVar = new i();
        iVar.c(h(eVarArr));
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        iVar.a(timeUnit.toMicros(k(eVarArr)));
        iVar.a("ac_on_c_mus", Long.valueOf(timeUnit.toMicros(b(eVarArr))));
        iVar.a("ac_on_c_mus_st", Long.valueOf(c(eVarArr)));
        iVar.a("ac_on_st_mus", Long.valueOf(timeUnit.toMicros(i(eVarArr))));
        iVar.a("ac_on_st_mus_st", Long.valueOf(j(eVarArr)));
        iVar.a("ac_on_r_mus", Long.valueOf(timeUnit.toMicros(f(eVarArr))));
        iVar.a("ac_on_r_mus_st", Long.valueOf(g(eVarArr)));
        if (l(eVarArr)) {
            long micros = timeUnit.toMicros(d(eVarArr));
            iVar.a("esl_mus", Long.valueOf(micros));
            if (micros != 0) {
                iVar.a("esl_mus_st", Long.valueOf(e(eVarArr)));
            }
        }
        return iVar;
    }
}
