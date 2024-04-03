package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDao;

public abstract class AbstractDaoTestStringPk<D extends AbstractDao<T, String>, T> extends AbstractDaoTestSinglePk<D, T, String> {
    public AbstractDaoTestStringPk(Class<D> cls) {
        super(cls);
    }

    /* renamed from: j */
    public String f() {
        int nextInt = this.f27962a.nextInt(30) + 1;
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < nextInt; i11++) {
            sb2.append((char) (this.f27962a.nextInt(25) + 97));
        }
        return sb2.toString();
    }
}
