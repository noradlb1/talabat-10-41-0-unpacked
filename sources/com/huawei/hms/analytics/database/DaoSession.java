package com.huawei.hms.analytics.database;

import com.huawei.hms.analytics.core.storage.Event;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final APIEventDao aPIEventDao;
    private final DaoConfig aPIEventDaoConfig;
    private final EventDao eventDao;
    private final DaoConfig eventDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(APIEventDao.class).clone();
        this.aPIEventDaoConfig = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(EventDao.class).clone();
        this.eventDaoConfig = clone2;
        clone2.initIdentityScope(identityScopeType);
        APIEventDao aPIEventDao2 = new APIEventDao(clone, this);
        this.aPIEventDao = aPIEventDao2;
        EventDao eventDao2 = new EventDao(clone2, this);
        this.eventDao = eventDao2;
        registerDao(APIEvent.class, aPIEventDao2);
        registerDao(Event.class, eventDao2);
    }

    public void clear() {
        this.aPIEventDaoConfig.clearIdentityScope();
        this.eventDaoConfig.clearIdentityScope();
    }

    public APIEventDao getAPIEventDao() {
        return this.aPIEventDao;
    }

    public EventDao getEventDao() {
        return this.eventDao;
    }
}
