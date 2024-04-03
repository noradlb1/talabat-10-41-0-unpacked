package org.greenrobot.greendao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;
import junit.framework.TestCase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.StandardDatabase;

public abstract class DbTest extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";

    /* renamed from: a  reason: collision with root package name */
    public final Random f27962a;
    private Application application;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f27963b;

    /* renamed from: c  reason: collision with root package name */
    public Database f27964c;

    public DbTest() {
        this(true);
    }

    public Database a() {
        SQLiteDatabase sQLiteDatabase;
        if (this.f27963b) {
            sQLiteDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null);
        } else {
            getContext().deleteDatabase(DB_NAME);
            sQLiteDatabase = getContext().openOrCreateDatabase(DB_NAME, 0, (SQLiteDatabase.CursorFactory) null);
        }
        return new StandardDatabase(sQLiteDatabase);
    }

    public <T extends Application> T createApplication(Class<T> cls) {
        TestCase.assertNull("Application already created", this.application);
        try {
            T newApplication = Instrumentation.newApplication(cls, getContext());
            newApplication.onCreate();
            this.application = newApplication;
            return newApplication;
        } catch (Exception e11) {
            throw new RuntimeException("Could not create application " + cls, e11);
        }
    }

    public <T extends Application> T getApplication() {
        TestCase.assertNotNull("Application not yet created", this.application);
        return this.application;
    }

    public void setUp() throws Exception {
        DbTest.super.setUp();
        this.f27964c = a();
    }

    public void tearDown() throws Exception {
        if (this.application != null) {
            terminateApplication();
        }
        this.f27964c.close();
        if (!this.f27963b) {
            getContext().deleteDatabase(DB_NAME);
        }
        DbTest.super.tearDown();
    }

    public void terminateApplication() {
        TestCase.assertNotNull("Application not yet created", this.application);
        this.application.onTerminate();
        this.application = null;
    }

    public DbTest(boolean z11) {
        this.f27963b = z11;
        this.f27962a = new Random();
    }
}
