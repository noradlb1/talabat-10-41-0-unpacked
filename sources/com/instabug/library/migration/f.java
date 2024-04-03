package com.instabug.library.migration;

import android.content.Context;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final AbstractMigration[] f51490a = {new b(), new n(), new d(), new h(), new j(), new l(), new p()};

    private static Observable[] a(Context context) {
        ArrayList arrayList = new ArrayList();
        for (AbstractMigration abstractMigration : f51490a) {
            abstractMigration.initialize(context);
            if (a(abstractMigration)) {
                abstractMigration.doPreMigration();
                arrayList.add(abstractMigration.migrate());
            }
        }
        return a(arrayList);
    }

    public static void b(Context context) {
        Observable[] a11 = a(context);
        if (a11 != null && a11.length != 0) {
            Observable.merge(Arrays.asList(a11)).observeOn(Schedulers.io()).subscribeOn(Schedulers.io()).subscribe(new e());
        }
    }

    private static boolean a(AbstractMigration abstractMigration) {
        boolean z11 = abstractMigration.getMigrationVersion() <= 4 && abstractMigration.shouldMigrate();
        InstabugSDKLogger.d("IBG-Core", "Checking if should apply this migration: " + abstractMigration.getMigrationId() + ", result is " + z11 + " last migration version is " + SettingsManager.getInstance().getLastMigrationVersion() + " target migration version " + 4);
        return z11;
    }

    private static Observable[] a(ArrayList arrayList) {
        Observable[] observableArr = new Observable[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            observableArr[i11] = (Observable) arrayList.get(i11);
        }
        return observableArr;
    }
}
