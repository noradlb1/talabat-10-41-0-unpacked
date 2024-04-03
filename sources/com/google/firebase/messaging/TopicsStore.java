package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    @VisibleForTesting
    static final String KEY_TOPIC_OPERATIONS_QUEUE = "topic_operation_queue";
    @VisibleForTesting
    static final String PREFERENCES = "com.google.android.gms.appid";
    @GuardedBy("TopicsStore.class")
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences2, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences2;
    }

    @VisibleForTesting
    public static synchronized void clearCaches() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    @WorkerThread
    public static synchronized TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
            if (weakReference != null) {
                topicsStore = weakReference.get();
            } else {
                topicsStore = null;
            }
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences(PREFERENCES, 0), executor);
                topicsStore.initStore();
                topicsStoreWeakReference = new WeakReference<>(topicsStore);
            }
        }
        return topicsStore;
    }

    @WorkerThread
    private synchronized void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, KEY_TOPIC_OPERATIONS_QUEUE, ",", this.syncExecutor);
    }

    public synchronized boolean addTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.add(topicOperation.serialize());
    }

    public synchronized void clearTopicOperations() {
        this.topicOperationsQueue.clear();
    }

    @Nullable
    public synchronized TopicOperation getNextTopicOperation() {
        return TopicOperation.from(this.topicOperationsQueue.peek());
    }

    @NonNull
    public synchronized List<TopicOperation> getOperations() {
        ArrayList arrayList;
        List<String> list = this.topicOperationsQueue.toList();
        arrayList = new ArrayList(list.size());
        for (String from : list) {
            arrayList.add(TopicOperation.from(from));
        }
        return arrayList;
    }

    @Nullable
    public synchronized TopicOperation pollTopicOperation() {
        try {
        } catch (NoSuchElementException unused) {
            Log.e(Constants.TAG, "Polling operation queue failed");
            return null;
        }
        return TopicOperation.from(this.topicOperationsQueue.remove());
    }

    public synchronized boolean removeTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
    }
}
