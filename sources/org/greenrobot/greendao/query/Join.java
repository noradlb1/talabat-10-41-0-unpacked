package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;

public class Join<SRC, DST> {

    /* renamed from: a  reason: collision with root package name */
    public final String f27891a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractDao<DST, ?> f27892b;

    /* renamed from: c  reason: collision with root package name */
    public final Property f27893c;

    /* renamed from: d  reason: collision with root package name */
    public final Property f27894d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27895e;

    /* renamed from: f  reason: collision with root package name */
    public final WhereCollector<DST> f27896f;

    public Join(String str, Property property, AbstractDao<DST, ?> abstractDao, Property property2, String str2) {
        this.f27891a = str;
        this.f27893c = property;
        this.f27892b = abstractDao;
        this.f27894d = property2;
        this.f27895e = str2;
        this.f27896f = new WhereCollector<>(abstractDao, str2);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f27896f.f(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    public String getTablePrefix() {
        return this.f27895e;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f27896f.f(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public Join<SRC, DST> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.f27896f.a(whereCondition, whereConditionArr);
        return this;
    }

    public Join<SRC, DST> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.f27896f.a(or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }
}
