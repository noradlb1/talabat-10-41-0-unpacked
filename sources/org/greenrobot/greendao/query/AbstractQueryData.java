package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f27885a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractDao<T, ?> f27886b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f27887c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Long, WeakReference<Q>> f27888d = new HashMap();

    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.f27886b = abstractDao;
        this.f27885a = str;
        this.f27887c = strArr;
    }

    public abstract Q a();

    public Q b() {
        Q q11;
        long id2 = Thread.currentThread().getId();
        synchronized (this.f27888d) {
            WeakReference weakReference = this.f27888d.get(Long.valueOf(id2));
            if (weakReference != null) {
                q11 = (AbstractQuery) weakReference.get();
            } else {
                q11 = null;
            }
            if (q11 == null) {
                d();
                q11 = a();
                this.f27888d.put(Long.valueOf(id2), new WeakReference(q11));
            } else {
                String[] strArr = this.f27887c;
                System.arraycopy(strArr, 0, q11.f27883d, 0, strArr.length);
            }
        }
        return q11;
    }

    public Q c(Q q11) {
        if (Thread.currentThread() != q11.f27884e) {
            return b();
        }
        String[] strArr = this.f27887c;
        System.arraycopy(strArr, 0, q11.f27883d, 0, strArr.length);
        return q11;
    }

    public void d() {
        synchronized (this.f27888d) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.f27888d.entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next().getValue()).get() == null) {
                    it.remove();
                }
            }
        }
    }
}
