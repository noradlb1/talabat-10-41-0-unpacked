package org.greenrobot.greendao;

import java.util.HashMap;
import java.util.Map;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public abstract class AbstractDaoMaster {
    protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap = new HashMap();

    /* renamed from: db  reason: collision with root package name */
    protected final Database f27859db;
    protected final int schemaVersion;

    public AbstractDaoMaster(Database database, int i11) {
        this.f27859db = database;
        this.schemaVersion = i11;
    }

    public Database getDatabase() {
        return this.f27859db;
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType identityScopeType);

    public void registerDaoClass(Class<? extends AbstractDao<?, ?>> cls) {
        this.daoConfigMap.put(cls, new DaoConfig(this.f27859db, cls));
    }
}
