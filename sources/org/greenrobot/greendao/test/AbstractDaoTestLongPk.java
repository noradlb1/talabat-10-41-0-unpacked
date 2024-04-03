package org.greenrobot.greendao.test;

import junit.framework.TestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;

public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T> extends AbstractDaoTestSinglePk<D, T, Long> {
    public AbstractDaoTestLongPk(Class<D> cls) {
        super(cls);
    }

    /* renamed from: j */
    public Long f() {
        return Long.valueOf(this.f27962a.nextLong());
    }

    public void testAssignPk() {
        if (this.f27959f.isEntityUpdateable()) {
            Object d11 = d(null);
            if (d11 != null) {
                Object d12 = d(null);
                this.f27958e.insert(d11);
                this.f27958e.insert(d12);
                Long l11 = (Long) this.f27959f.getKey(d11);
                TestCase.assertNotNull(l11);
                Long l12 = (Long) this.f27959f.getKey(d12);
                TestCase.assertNotNull(l12);
                TestCase.assertFalse(l11.equals(l12));
                TestCase.assertNotNull(this.f27958e.load(l11));
                TestCase.assertNotNull(this.f27958e.load(l12));
                return;
            }
            DaoLog.d("Skipping testAssignPk for " + this.f27957d + " (createEntity returned null for null key)");
            return;
        }
        DaoLog.d("Skipping testAssignPk for not updateable " + this.f27957d);
    }
}
