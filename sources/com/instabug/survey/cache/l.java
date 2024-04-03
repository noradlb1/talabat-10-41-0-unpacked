package com.instabug.survey.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.models.Survey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ud.a;

public abstract class l {
    public static List a() {
        List list = (List) PoolProvider.getSurveysDBExecutor().executeAndGet(new i());
        return list != null ? list : new ArrayList();
    }

    public static void a(long j11) {
        PoolProvider.getSurveysDBExecutor().execute(new d(j11));
    }

    public static void a(Survey survey) {
        PoolProvider.getSurveysDBExecutor().execute(new f(survey));
    }

    public static void a(Survey survey, boolean z11, boolean z12) {
        PoolProvider.getSurveysDBExecutor().execute(new a(survey, z11, z12));
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Survey survey = (Survey) it.next();
            survey.resetUserInteractions();
            survey.resetUserAnswers();
        }
        b(list);
    }

    @Nullable
    public static Survey b(long j11) {
        return (Survey) PoolProvider.getSurveysDBExecutor().executeAndGet(new b(j11));
    }

    public static List b() {
        List list = (List) PoolProvider.getSurveysDBExecutor().executeAndGet(new g());
        return list != null ? list : new ArrayList();
    }

    @WorkerThread
    public static void b(List list) {
        PoolProvider.getSurveysDBExecutor().execute(new e(list));
    }

    public static List c() {
        List list = (List) PoolProvider.getSurveysDBExecutor().executeAndGet(new h());
        return list != null ? list : new ArrayList();
    }

    public static void c(Survey survey) {
        PoolProvider.getSurveysDBExecutor().execute(new j(survey));
    }

    public static boolean c(long j11) {
        Boolean bool = (Boolean) PoolProvider.getSurveysDBExecutor().executeAndGet(new c(j11));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @WorkerThread
    public static void d(Survey survey) {
        PoolProvider.getSurveysDBExecutor().execute(new k(survey));
    }

    public static void e(@NonNull Survey survey) {
        PoolProvider.getSurveysDBExecutor().execute(new a(survey));
    }
}
