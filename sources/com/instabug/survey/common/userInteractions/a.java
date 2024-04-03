package com.instabug.survey.common.userInteractions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.survey.common.models.e;
import com.instabug.survey.common.models.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    @Nullable
    public static i a(long j11, @NonNull String str, int i11) {
        return b.a(Long.valueOf(j11), str, i11);
    }

    public static void a(List list) {
        b.a(list);
    }

    public static void a(@NonNull List list, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            i userInteraction = eVar.getUserInteraction();
            userInteraction.c(eVar.getSurveyId());
            userInteraction.a(str);
            arrayList.add(userInteraction);
        }
        b.b((List) arrayList);
    }
}
