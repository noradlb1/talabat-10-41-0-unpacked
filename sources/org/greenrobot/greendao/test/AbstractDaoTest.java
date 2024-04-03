package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;

public abstract class AbstractDaoTest<D extends AbstractDao<T, K>, T, K> extends DbTest {

    /* renamed from: d  reason: collision with root package name */
    public final Class<D> f27957d;

    /* renamed from: e  reason: collision with root package name */
    public D f27958e;

    /* renamed from: f  reason: collision with root package name */
    public InternalUnitTestDaoAccess<T, K> f27959f;

    /* renamed from: g  reason: collision with root package name */
    public IdentityScope<K, T> f27960g;

    public AbstractDaoTest(Class<D> cls) {
        this(cls, true);
    }

    public void b() throws Exception {
        try {
            this.f27957d.getMethod("createTable", new Class[]{Database.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.f27964c, Boolean.FALSE});
        } catch (NoSuchMethodException unused) {
            DaoLog.i("No createTable method");
        }
    }

    public void setIdentityScopeBeforeSetUp(IdentityScope<K, T> identityScope) {
        this.f27960g = identityScope;
    }

    public void setUp() throws Exception {
        super.setUp();
        try {
            b();
            InternalUnitTestDaoAccess<T, K> internalUnitTestDaoAccess = new InternalUnitTestDaoAccess<>(this.f27964c, this.f27957d, this.f27960g);
            this.f27959f = internalUnitTestDaoAccess;
            this.f27958e = internalUnitTestDaoAccess.getDao();
        } catch (Exception e11) {
            throw new RuntimeException("Could not prepare DAO Test", e11);
        }
    }

    public AbstractDaoTest(Class<D> cls, boolean z11) {
        super(z11);
        this.f27957d = cls;
    }
}
