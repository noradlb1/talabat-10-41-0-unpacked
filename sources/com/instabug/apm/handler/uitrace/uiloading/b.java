package com.instabug.apm.handler.uitrace.uiloading;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.model.d;
import com.instabug.apm.model.e;
import com.instabug.apm.util.a;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = 29)
public class b implements a {
    private long b(e[] eVarArr) {
        return eVarArr[2].b() - eVarArr[0].b();
    }

    private long c(e[] eVarArr) {
        return eVarArr[0].c();
    }

    private long d(e[] eVarArr) {
        if (m(eVarArr)) {
            return eVarArr[10].b() - eVarArr[8].b();
        }
        return 0;
    }

    private long e(e[] eVarArr) {
        return eVarArr[8].c();
    }

    private long f(e[] eVarArr) {
        return eVarArr[8].b() - eVarArr[6].b();
    }

    private long g(e[] eVarArr) {
        return eVarArr[6].c();
    }

    private long h(e[] eVarArr) {
        return eVarArr[0].c();
    }

    private long i(e[] eVarArr) {
        return eVarArr[5].b() - eVarArr[3].b();
    }

    private long j(e[] eVarArr) {
        return eVarArr[3].c();
    }

    private long k(e[] eVarArr) {
        long b11;
        e eVar;
        if (!l(eVarArr) || !m(eVarArr)) {
            b11 = eVarArr[8].b();
            eVar = eVarArr[0];
        } else {
            b11 = eVarArr[10].b();
            eVar = eVarArr[0];
        }
        return b11 - eVar.b();
    }

    private boolean l(e[] eVarArr) {
        return !(eVarArr[10] instanceof d);
    }

    private boolean m(e[] eVarArr) {
        return eVarArr[10].b() > eVarArr[8].b();
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
