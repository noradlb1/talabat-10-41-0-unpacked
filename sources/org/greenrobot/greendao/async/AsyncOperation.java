package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;

    /* renamed from: a  reason: collision with root package name */
    public final OperationType f27862a;

    /* renamed from: b  reason: collision with root package name */
    public final AbstractDao<Object, Object> f27863b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f27864c;
    private volatile boolean completed;

    /* renamed from: d  reason: collision with root package name */
    public final int f27865d;
    private final Database database;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f27866e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f27867f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Throwable f27868g;

    /* renamed from: h  reason: collision with root package name */
    public final Exception f27869h;

    /* renamed from: i  reason: collision with root package name */
    public volatile Object f27870i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f27871j;

    /* renamed from: k  reason: collision with root package name */
    public int f27872k;

    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    public AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Database database2, Object obj, int i11) {
        Exception exc;
        this.f27862a = operationType;
        this.f27865d = i11;
        this.f27863b = abstractDao;
        this.database = database2;
        this.f27864c = obj;
        if ((i11 & 4) != 0) {
            exc = new Exception("AsyncOperation was created here");
        } else {
            exc = null;
        }
        this.f27869h = exc;
    }

    public Database a() {
        Database database2 = this.database;
        return database2 != null ? database2 : this.f27863b.getDatabase();
    }

    public boolean b(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && a() == asyncOperation.a();
    }

    public void c() {
        this.f27866e = 0;
        this.f27867f = 0;
        this.completed = false;
        this.f27868g = null;
        this.f27870i = null;
        this.f27871j = 0;
    }

    public synchronized void d() {
        this.completed = true;
        notifyAll();
    }

    public Exception getCreatorStacktrace() {
        return this.f27869h;
    }

    public long getDuration() {
        if (this.f27867f != 0) {
            return this.f27867f - this.f27866e;
        }
        throw new DaoException("This operation did not yet complete");
    }

    public int getMergedOperationsCount() {
        return this.f27871j;
    }

    public Object getParameter() {
        return this.f27864c;
    }

    public synchronized Object getResult() {
        if (!this.completed) {
            waitForCompletion();
        }
        if (this.f27868g == null) {
        } else {
            throw new AsyncDaoException(this, this.f27868g);
        }
        return this.f27870i;
    }

    public int getSequenceNumber() {
        return this.f27872k;
    }

    public Throwable getThrowable() {
        return this.f27868g;
    }

    public long getTimeCompleted() {
        return this.f27867f;
    }

    public long getTimeStarted() {
        return this.f27866e;
    }

    public OperationType getType() {
        return this.f27862a;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public boolean isCompletedSucessfully() {
        return this.completed && this.f27868g == null;
    }

    public boolean isFailed() {
        return this.f27868g != null;
    }

    public boolean isMergeTx() {
        return (this.f27865d & 1) != 0;
    }

    public void setThrowable(Throwable th2) {
        this.f27868g = th2;
    }

    public synchronized Object waitForCompletion() {
        while (!this.completed) {
            try {
                wait();
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for operation to complete", e11);
            }
        }
        return this.f27870i;
    }

    public synchronized boolean waitForCompletion(int i11) {
        if (!this.completed) {
            try {
                wait((long) i11);
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for operation to complete", e11);
            }
        }
        return this.completed;
    }
}
