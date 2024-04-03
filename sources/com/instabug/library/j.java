package com.instabug.library;

import com.instabug.library.diagnostics.diagnostics_db.n;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import java.util.List;

class j implements Runnable {
    public j(c0 c0Var) {
    }

    public void run() {
        DatabaseManager.clearAll();
        IBGDbManager.getInstance().delete(InstabugDbContract.BugEntry.TABLE_NAME, (String) null, (List<IBGWhereArg>) null);
        IBGDbManager.getInstance().delete("fatal_hangs_table", (String) null, (List<IBGWhereArg>) null);
        IBGDbManager.getInstance().delete("terminations_table", (String) null, (List<IBGWhereArg>) null);
        n.a();
    }
}
