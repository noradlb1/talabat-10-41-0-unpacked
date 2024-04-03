package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {

    /* renamed from: d  reason: collision with root package name */
    public T f27955d;
    private final Class<T> daoMasterClass;

    /* renamed from: e  reason: collision with root package name */
    public S f27956e;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    public void setUp() throws Exception {
        Class<Database> cls = Database.class;
        super.setUp();
        try {
            this.f27955d = (AbstractDaoMaster) this.daoMasterClass.getConstructor(new Class[]{cls}).newInstance(new Object[]{this.f27964c});
            this.daoMasterClass.getMethod("createAllTables", new Class[]{cls, Boolean.TYPE}).invoke((Object) null, new Object[]{this.f27964c, Boolean.FALSE});
            this.f27956e = this.f27955d.newSession();
        } catch (Exception e11) {
            throw new RuntimeException("Could not prepare DAO session test", e11);
        }
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z11) {
        super(z11);
        this.daoMasterClass = cls;
    }
}
