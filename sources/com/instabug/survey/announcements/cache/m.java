package com.instabug.survey.announcements.cache;

import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.announcements.models.e;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

public abstract class m {
    private static Observable a(long j11, e eVar) {
        return Observable.create(new l(eVar, j11));
    }

    @Nullable
    private static List a(c cVar) {
        if (cVar.e() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(cVar.e().size());
        for (int i11 = 0; i11 < cVar.e().size(); i11++) {
            e eVar = (e) cVar.e().get(i11);
            if (eVar.b() != null && !eVar.b().equals("")) {
                arrayList.add(a(cVar.d(), eVar));
            }
        }
        return arrayList;
    }

    public static void a(a aVar) {
        InstabugSDKLogger.d("IBG-Surveys", "downloading announcement assets for: " + aVar.i());
        List a11 = aVar.c() != null ? a((c) aVar.c().get(0)) : null;
        if (a11 != null) {
            Observable.merge(a11).subscribe(new i(aVar));
        }
    }
}
