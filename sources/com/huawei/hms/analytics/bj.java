package com.huawei.hms.analytics;

import com.huawei.hms.analytics.database.LogConfig;
import com.huawei.hms.analytics.database.LogConfigDao;
import com.huawei.hms.analytics.database.LogEvent;
import com.huawei.hms.analytics.database.LogEventDao;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class bj extends AbstractDaoSession {
    private final DaoConfig ijk;
    private final DaoConfig ikl;
    public final LogEventDao klm;
    public final LogConfigDao lmn;

    public bj(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(LogEventDao.class).clone();
        this.ikl = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(LogConfigDao.class).clone();
        this.ijk = clone2;
        clone2.initIdentityScope(identityScopeType);
        LogEventDao logEventDao = new LogEventDao(clone, this);
        this.klm = logEventDao;
        LogConfigDao logConfigDao = new LogConfigDao(clone2, this);
        this.lmn = logConfigDao;
        registerDao(LogEvent.class, logEventDao);
        registerDao(LogConfig.class, logConfigDao);
    }

    public final void lmn() {
        this.ikl.clearIdentityScope();
        this.ijk.clearIdentityScope();
    }
}
