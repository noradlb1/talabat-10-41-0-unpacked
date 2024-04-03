package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;

abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {

    /* renamed from: f  reason: collision with root package name */
    public final int f27889f;

    /* renamed from: g  reason: collision with root package name */
    public final int f27890g;

    public AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
        super(abstractDao, str, strArr);
        this.f27889f = i11;
        this.f27890g = i12;
    }

    public void setLimit(int i11) {
        a();
        int i12 = this.f27889f;
        if (i12 != -1) {
            this.f27883d[i12] = Integer.toString(i11);
            return;
        }
        throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }

    public void setOffset(int i11) {
        a();
        int i12 = this.f27890g;
        if (i12 != -1) {
            this.f27883d[i12] = Integer.toString(i11);
            return;
        }
        throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }

    public AbstractQueryWithLimit<T> setParameter(int i11, Object obj) {
        if (i11 < 0 || (i11 != this.f27889f && i11 != this.f27890g)) {
            return (AbstractQueryWithLimit) super.setParameter(i11, obj);
        }
        throw new IllegalArgumentException("Illegal parameter index: " + i11);
    }
}
