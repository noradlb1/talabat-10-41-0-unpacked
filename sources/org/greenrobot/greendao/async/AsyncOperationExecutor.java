package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

class AsyncOperationExecutor implements Runnable, Handler.Callback {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private volatile int maxOperationCountToMerge = 50;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
    private volatile int waitForMergeMillis = 50;

    /* renamed from: org.greenrobot.greendao.async.AsyncOperationExecutor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27873a;

        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.greenrobot.greendao.async.AsyncOperation$OperationType[] r0 = org.greenrobot.greendao.async.AsyncOperation.OperationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27873a = r0
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Delete     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.DeleteInTxIterable     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.DeleteInTxArray     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Insert     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.InsertInTxIterable     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.InsertInTxArray     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.InsertOrReplace     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0060 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.InsertOrReplaceInTxIterable     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x006c }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.InsertOrReplaceInTxArray     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0078 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Update     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0084 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.UpdateInTxIterable     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0090 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.UpdateInTxArray     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x009c }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.TransactionRunnable     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.TransactionCallable     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.QueryList     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.QueryUnique     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00cc }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.DeleteByKey     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.DeleteAll     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Load     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.LoadAll     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x00fc }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Count     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = f27873a     // Catch:{ NoSuchFieldError -> 0x0108 }
                org.greenrobot.greendao.async.AsyncOperation$OperationType r1 = org.greenrobot.greendao.async.AsyncOperation.OperationType.Refresh     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.async.AsyncOperationExecutor.AnonymousClass1.<clinit>():void");
        }
    }

    private void executeOperation(AsyncOperation asyncOperation) {
        asyncOperation.f27866e = System.currentTimeMillis();
        try {
            switch (AnonymousClass1.f27873a[asyncOperation.f27862a.ordinal()]) {
                case 1:
                    asyncOperation.f27863b.delete(asyncOperation.f27864c);
                    break;
                case 2:
                    asyncOperation.f27863b.deleteInTx((Iterable) asyncOperation.f27864c);
                    break;
                case 3:
                    asyncOperation.f27863b.deleteInTx((T[]) (Object[]) asyncOperation.f27864c);
                    break;
                case 4:
                    asyncOperation.f27863b.insert(asyncOperation.f27864c);
                    break;
                case 5:
                    asyncOperation.f27863b.insertInTx((Iterable) asyncOperation.f27864c);
                    break;
                case 6:
                    asyncOperation.f27863b.insertInTx((T[]) (Object[]) asyncOperation.f27864c);
                    break;
                case 7:
                    asyncOperation.f27863b.insertOrReplace(asyncOperation.f27864c);
                    break;
                case 8:
                    asyncOperation.f27863b.insertOrReplaceInTx((Iterable) asyncOperation.f27864c);
                    break;
                case 9:
                    asyncOperation.f27863b.insertOrReplaceInTx((T[]) (Object[]) asyncOperation.f27864c);
                    break;
                case 10:
                    asyncOperation.f27863b.update(asyncOperation.f27864c);
                    break;
                case 11:
                    asyncOperation.f27863b.updateInTx((Iterable) asyncOperation.f27864c);
                    break;
                case 12:
                    asyncOperation.f27863b.updateInTx((T[]) (Object[]) asyncOperation.f27864c);
                    break;
                case 13:
                    executeTransactionRunnable(asyncOperation);
                    break;
                case 14:
                    executeTransactionCallable(asyncOperation);
                    break;
                case 15:
                    asyncOperation.f27870i = ((Query) asyncOperation.f27864c).forCurrentThread().list();
                    break;
                case 16:
                    asyncOperation.f27870i = ((Query) asyncOperation.f27864c).forCurrentThread().unique();
                    break;
                case 17:
                    asyncOperation.f27863b.deleteByKey(asyncOperation.f27864c);
                    break;
                case 18:
                    asyncOperation.f27863b.deleteAll();
                    break;
                case 19:
                    asyncOperation.f27870i = asyncOperation.f27863b.load(asyncOperation.f27864c);
                    break;
                case 20:
                    asyncOperation.f27870i = asyncOperation.f27863b.loadAll();
                    break;
                case 21:
                    asyncOperation.f27870i = Long.valueOf(asyncOperation.f27863b.count());
                    break;
                case 22:
                    asyncOperation.f27863b.refresh(asyncOperation.f27864c);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.f27862a);
            }
        } catch (Throwable th2) {
            asyncOperation.f27868g = th2;
        }
        asyncOperation.f27867f = System.currentTimeMillis();
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        executeOperation(asyncOperation);
        handleOperationCompleted(asyncOperation);
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        Database a11 = asyncOperation.a();
        a11.beginTransaction();
        try {
            asyncOperation.f27870i = ((Callable) asyncOperation.f27864c).call();
            a11.setTransactionSuccessful();
        } finally {
            a11.endTransaction();
        }
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        Database a11 = asyncOperation.a();
        a11.beginTransaction();
        try {
            ((Runnable) asyncOperation.f27864c).run();
            a11.setTransactionSuccessful();
        } finally {
            a11.endTransaction();
        }
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.d();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            this.handlerMainThread.sendMessage(this.handlerMainThread.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            int i11 = this.countOperationsCompleted + 1;
            this.countOperationsCompleted = i11;
            if (i11 == this.countOperationsEnqueued) {
                notifyAll();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation r8, org.greenrobot.greendao.async.AsyncOperation r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Async transaction could not be ended, success so far was: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r8)
            r1.add(r9)
            org.greenrobot.greendao.database.Database r8 = r8.a()
            r8.beginTransaction()
            r9 = 0
            r2 = r9
        L_0x0016:
            int r3 = r1.size()     // Catch:{ all -> 0x00b5 }
            if (r2 >= r3) goto L_0x0063
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00b5 }
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            r7.executeOperation(r3)     // Catch:{ all -> 0x00b5 }
            boolean r4 = r3.isFailed()     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x002c
            goto L_0x0063
        L_0x002c:
            int r4 = r1.size()     // Catch:{ all -> 0x00b5 }
            r5 = 1
            int r4 = r4 - r5
            if (r2 != r4) goto L_0x0060
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r4 = r7.queue     // Catch:{ all -> 0x00b5 }
            java.lang.Object r4 = r4.peek()     // Catch:{ all -> 0x00b5 }
            org.greenrobot.greendao.async.AsyncOperation r4 = (org.greenrobot.greendao.async.AsyncOperation) r4     // Catch:{ all -> 0x00b5 }
            int r6 = r7.maxOperationCountToMerge     // Catch:{ all -> 0x00b5 }
            if (r2 >= r6) goto L_0x005c
            boolean r3 = r3.b(r4)     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x005c
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r3 = r7.queue     // Catch:{ all -> 0x00b5 }
            java.lang.Object r3 = r3.remove()     // Catch:{ all -> 0x00b5 }
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            if (r3 != r4) goto L_0x0054
            r1.add(r3)     // Catch:{ all -> 0x00b5 }
            goto L_0x0060
        L_0x0054:
            org.greenrobot.greendao.DaoException r1 = new org.greenrobot.greendao.DaoException     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "Internal error: peeked op did not match removed op"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x00b5 }
            throw r1     // Catch:{ all -> 0x00b5 }
        L_0x005c:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x00b5 }
            goto L_0x0064
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0063:
            r5 = r9
        L_0x0064:
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x0069 }
            r9 = r5
            goto L_0x007c
        L_0x0069:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            org.greenrobot.greendao.DaoLog.i(r0, r8)
        L_0x007c:
            if (r9 == 0) goto L_0x0098
            int r8 = r1.size()
            java.util.Iterator r9 = r1.iterator()
        L_0x0086:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r9.next()
            org.greenrobot.greendao.async.AsyncOperation r0 = (org.greenrobot.greendao.async.AsyncOperation) r0
            r0.f27871j = r8
            r7.handleOperationCompleted(r0)
            goto L_0x0086
        L_0x0098:
            java.lang.String r8 = "Reverted merged transaction because one of the operations failed. Executing operations one by one instead..."
            org.greenrobot.greendao.DaoLog.i(r8)
            java.util.Iterator r8 = r1.iterator()
        L_0x00a1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00b4
            java.lang.Object r9 = r8.next()
            org.greenrobot.greendao.async.AsyncOperation r9 = (org.greenrobot.greendao.async.AsyncOperation) r9
            r9.c()
            r7.executeOperationAndPostCompleted(r9)
            goto L_0x00a1
        L_0x00b4:
            return
        L_0x00b5:
            r1 = move-exception
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x00ba }
            goto L_0x00cd
        L_0x00ba:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            org.greenrobot.greendao.DaoLog.i(r9, r8)
        L_0x00cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.async.AsyncOperationExecutor.mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation, org.greenrobot.greendao.async.AsyncOperation):void");
    }

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i11 = this.lastSequenceNumber + 1;
            this.lastSequenceNumber = i11;
            asyncOperation.f27872k = i11;
            this.queue.add(asyncOperation);
            this.countOperationsEnqueued++;
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener == null) {
            return false;
        }
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        return false;
    }

    public synchronized boolean isCompleted() {
        boolean z11;
        if (this.countOperationsEnqueued == this.countOperationsCompleted) {
            z11 = true;
        } else {
            z11 = false;
        }
        return z11;
    }

    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.queue.poll(1, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = this.queue.poll();
                        if (poll2 == null) {
                            this.executorRunning = false;
                            this.executorRunning = false;
                            return;
                        }
                    }
                }
                if (!poll2.isMergeTx() || (poll = this.queue.poll((long) this.waitForMergeMillis, TimeUnit.MILLISECONDS)) == null) {
                    executeOperationAndPostCompleted(poll2);
                } else if (poll2.b(poll)) {
                    mergeTxAndExecute(poll2, poll);
                } else {
                    executeOperationAndPostCompleted(poll2);
                    executeOperationAndPostCompleted(poll);
                }
            } catch (InterruptedException e11) {
                try {
                    DaoLog.w(Thread.currentThread().getName() + " was interruppted", e11);
                    return;
                } finally {
                    this.executorRunning = false;
                }
            }
        }
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public void setMaxOperationCountToMerge(int i11) {
        this.maxOperationCountToMerge = i11;
    }

    public void setWaitForMergeMillis(int i11) {
        this.waitForMergeMillis = i11;
    }

    public synchronized void waitForCompletion() {
        while (!isCompleted()) {
            try {
                wait();
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e11);
            }
        }
    }

    public synchronized boolean waitForCompletion(int i11) {
        if (!isCompleted()) {
            try {
                wait((long) i11);
            } catch (InterruptedException e11) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e11);
            }
        }
        return isCompleted();
    }
}
