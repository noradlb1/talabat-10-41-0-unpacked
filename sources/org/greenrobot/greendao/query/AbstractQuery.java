package org.greenrobot.greendao.query;

import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

abstract class AbstractQuery<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractDao<T, ?> f27880a;

    /* renamed from: b  reason: collision with root package name */
    public final InternalQueryDaoAccess<T> f27881b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27882c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f27883d;

    /* renamed from: e  reason: collision with root package name */
    public final Thread f27884e = Thread.currentThread();

    public AbstractQuery(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.f27880a = abstractDao;
        this.f27881b = new InternalQueryDaoAccess<>(abstractDao);
        this.f27882c = str;
        this.f27883d = strArr;
    }

    public static String[] b(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = objArr[i11];
            if (obj != null) {
                strArr[i11] = obj.toString();
            } else {
                strArr[i11] = null;
            }
        }
        return strArr;
    }

    public void a() {
        if (Thread.currentThread() != this.f27884e) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }

    public AbstractQuery<T> setParameter(int i11, Object obj) {
        a();
        if (obj != null) {
            this.f27883d[i11] = obj.toString();
        } else {
            this.f27883d[i11] = null;
        }
        return this;
    }

    public AbstractQuery<T> setParameter(int i11, Date date) {
        return setParameter(i11, (Object) date != null ? Long.valueOf(date.getTime()) : null);
    }

    public AbstractQuery<T> setParameter(int i11, Boolean bool) {
        return setParameter(i11, (Object) bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
    }
}
