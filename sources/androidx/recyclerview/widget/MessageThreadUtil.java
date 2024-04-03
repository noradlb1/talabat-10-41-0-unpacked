package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {

    public static class MessageQueue {
        private SyncQueueItem mRoot;

        public synchronized SyncQueueItem next() {
            SyncQueueItem syncQueueItem = this.mRoot;
            if (syncQueueItem == null) {
                return null;
            }
            this.mRoot = syncQueueItem.next;
            return syncQueueItem;
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void removeMessages(int r5) {
            /*
                r4 = this;
                monitor-enter(r4)
            L_0x0001:
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r0 = r4.mRoot     // Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0011
                int r1 = r0.what     // Catch:{ all -> 0x0028 }
                if (r1 != r5) goto L_0x0011
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r0.next     // Catch:{ all -> 0x0028 }
                r4.mRoot = r1     // Catch:{ all -> 0x0028 }
                r0.recycle()     // Catch:{ all -> 0x0028 }
                goto L_0x0001
            L_0x0011:
                if (r0 == 0) goto L_0x0026
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r1 = r0.next     // Catch:{ all -> 0x0028 }
            L_0x0015:
                if (r1 == 0) goto L_0x0026
                androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem r2 = r1.next     // Catch:{ all -> 0x0028 }
                int r3 = r1.what     // Catch:{ all -> 0x0028 }
                if (r3 != r5) goto L_0x0023
                r0.next = r2     // Catch:{ all -> 0x0028 }
                r1.recycle()     // Catch:{ all -> 0x0028 }
                goto L_0x0024
            L_0x0023:
                r0 = r1
            L_0x0024:
                r1 = r2
                goto L_0x0015
            L_0x0026:
                monitor-exit(r4)
                return
            L_0x0028:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.MessageThreadUtil.MessageQueue.removeMessages(int):void");
        }

        public synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            SyncQueueItem syncQueueItem2 = this.mRoot;
            if (syncQueueItem2 == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            while (true) {
                SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                if (syncQueueItem3 != null) {
                    syncQueueItem2 = syncQueueItem3;
                } else {
                    syncQueueItem2.next = syncQueueItem;
                    return;
                }
            }
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>() {
            static final int LOAD_TILE = 3;
            static final int RECYCLE_TILE = 4;
            static final int REFRESH = 1;
            static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem next = AnonymousClass2.this.mQueue.next();
                        if (next == null) {
                            AnonymousClass2.this.mBackgroundRunning.set(false);
                            return;
                        }
                        int i11 = next.what;
                        if (i11 == 1) {
                            AnonymousClass2.this.mQueue.removeMessages(1);
                            backgroundCallback.refresh(next.arg1);
                        } else if (i11 == 2) {
                            AnonymousClass2.this.mQueue.removeMessages(2);
                            AnonymousClass2.this.mQueue.removeMessages(3);
                            backgroundCallback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        } else if (i11 == 3) {
                            backgroundCallback.loadTile(next.arg1, next.arg2);
                        } else if (i11 != 4) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        } else {
                            backgroundCallback.recycleTile((TileList.Tile) next.data);
                        }
                    }
                }
            };
            AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
            private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            final MessageQueue mQueue = new MessageQueue();

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            public void loadTile(int i11, int i12) {
                sendMessage(SyncQueueItem.obtainMessage(3, i11, i12));
            }

            public void recycleTile(TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object) tile));
            }

            public void refresh(int i11) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i11, (Object) null));
            }

            public void updateRange(int i11, int i12, int i13, int i14, int i15) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i11, i12, i13, i14, i15, (Object) null));
            }
        };
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>() {
            static final int ADD_TILE = 2;
            static final int REMOVE_TILE = 3;
            static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            private Runnable mMainThreadRunnable = new Runnable() {
                public void run() {
                    SyncQueueItem next = AnonymousClass1.this.mQueue.next();
                    while (next != null) {
                        int i11 = next.what;
                        if (i11 == 1) {
                            mainThreadCallback.updateItemCount(next.arg1, next.arg2);
                        } else if (i11 == 2) {
                            mainThreadCallback.addTile(next.arg1, (TileList.Tile) next.data);
                        } else if (i11 != 3) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        } else {
                            mainThreadCallback.removeTile(next.arg1, next.arg2);
                        }
                        next = AnonymousClass1.this.mQueue.next();
                    }
                }
            };
            final MessageQueue mQueue = new MessageQueue();

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void addTile(int i11, TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(2, i11, (Object) tile));
            }

            public void removeTile(int i11, int i12) {
                sendMessage(SyncQueueItem.obtainMessage(3, i11, i12));
            }

            public void updateItemCount(int i11, int i12) {
                sendMessage(SyncQueueItem.obtainMessage(1, i11, i12));
            }
        };
    }

    public static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        public static SyncQueueItem obtainMessage(int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                syncQueueItem = sPool;
                if (syncQueueItem == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    sPool = syncQueueItem.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i11;
                syncQueueItem.arg1 = i12;
                syncQueueItem.arg2 = i13;
                syncQueueItem.arg3 = i14;
                syncQueueItem.arg4 = i15;
                syncQueueItem.arg5 = i16;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                SyncQueueItem syncQueueItem = sPool;
                if (syncQueueItem != null) {
                    this.next = syncQueueItem;
                }
                sPool = this;
            }
        }

        public static SyncQueueItem obtainMessage(int i11, int i12, int i13) {
            return obtainMessage(i11, i12, i13, 0, 0, 0, (Object) null);
        }

        public static SyncQueueItem obtainMessage(int i11, int i12, Object obj) {
            return obtainMessage(i11, i12, 0, 0, 0, 0, obj);
        }
    }
}
