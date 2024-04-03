package io.flutter.plugins.firebase.database;

import android.os.Handler;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.tekartik.sqflite.Constant;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.CharUtils;

class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String EVENT_TYPE_CHILD_ADDED = "_EventType.childAdded";
    private static final String EVENT_TYPE_CHILD_CHANGED = "_EventType.childChanged";
    private static final String EVENT_TYPE_CHILD_MOVED = "_EventType.childMoved";
    private static final String EVENT_TYPE_CHILD_REMOVED = "_EventType.childRemoved";
    private static final String EVENT_TYPE_VALUE = "_EventType.value";
    private static final String TAG = "MethodCallHandlerImpl";
    /* access modifiers changed from: private */
    public MethodChannel channel;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    private int nextHandle = 0;
    private final SparseArray<EventObserver> observers = new SparseArray<>();

    public class DefaultCompletionListener implements DatabaseReference.CompletionListener {
        private final MethodChannel.Result result;

        public DefaultCompletionListener(MethodChannel.Result result2) {
            this.result = result2;
        }

        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
            if (databaseError != null) {
                this.result.error(String.valueOf(databaseError.getCode()), databaseError.getMessage(), databaseError.getDetails());
            } else {
                this.result.success((Object) null);
            }
        }
    }

    public static class EventObserver implements ChildEventListener, ValueEventListener {
        private MethodChannel channel;
        private int handle;
        /* access modifiers changed from: private */
        public Query query;
        /* access modifiers changed from: private */
        public String requestedEventType;

        public EventObserver(MethodChannel methodChannel, String str, Query query2, int i11) {
            this.channel = methodChannel;
            this.requestedEventType = str;
            this.query = query2;
            this.handle = i11;
        }

        private ArrayList<String> getChildKeys(DataSnapshot dataSnapshot) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (dataSnapshot.hasChildren()) {
                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    arrayList.add(key.getKey());
                }
            }
            return arrayList;
        }

        private void sendEvent(String str, @NonNull DataSnapshot dataSnapshot, String str2) {
            if (str.equals(this.requestedEventType)) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("key", dataSnapshot.getKey());
                hashMap2.put("value", dataSnapshot.getValue());
                hashMap.put("handle", Integer.valueOf(this.handle));
                hashMap.put(StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME, hashMap2);
                hashMap.put("previousSiblingKey", str2);
                hashMap.put("childKeys", getChildKeys(dataSnapshot));
                this.channel.invokeMethod("Event", hashMap);
            }
        }

        public void onCancelled(@NonNull DatabaseError databaseError) {
            HashMap hashMap = new HashMap();
            hashMap.put("handle", Integer.valueOf(this.handle));
            hashMap.put("error", MethodCallHandlerImpl.asMap(databaseError));
            this.channel.invokeMethod("Error", hashMap);
        }

        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String str) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_ADDED, dataSnapshot, str);
        }

        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String str) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_CHANGED, dataSnapshot, str);
        }

        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String str) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_MOVED, dataSnapshot, str);
        }

        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_CHILD_REMOVED, dataSnapshot, (String) null);
        }

        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            sendEvent(MethodCallHandlerImpl.EVENT_TYPE_VALUE, dataSnapshot, (String) null);
        }
    }

    public MethodCallHandlerImpl(MethodChannel methodChannel) {
        this.channel = methodChannel;
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> asMap(DatabaseError databaseError) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.PARAM_ERROR_CODE, Integer.valueOf(databaseError.getCode()));
        hashMap.put("message", databaseError.getMessage());
        hashMap.put("details", databaseError.getDetails());
        return hashMap;
    }

    private Query getQuery(FirebaseDatabase firebaseDatabase, Map<String, Object> map) {
        Query reference = getReference(firebaseDatabase, map);
        Map map2 = (Map) map.get("parameters");
        if (map2 == null) {
            return reference;
        }
        Object obj = map2.get("orderBy");
        if ("child".equals(obj)) {
            reference = reference.orderByChild((String) map2.get("orderByChildKey"));
        } else if ("key".equals(obj)) {
            reference = reference.orderByKey();
        } else if ("value".equals(obj)) {
            reference = reference.orderByValue();
        } else if ("priority".equals(obj)) {
            reference = reference.orderByPriority();
        }
        if (map2.containsKey("startAt")) {
            Object obj2 = map2.get("startAt");
            if (map2.containsKey("startAtKey")) {
                String str = (String) map2.get("startAtKey");
                if (obj2 instanceof Boolean) {
                    reference = reference.startAt(((Boolean) obj2).booleanValue(), str);
                } else if (obj2 instanceof Number) {
                    reference = reference.startAt(((Number) obj2).doubleValue(), str);
                } else {
                    reference = reference.startAt((String) obj2, str);
                }
            } else if (obj2 instanceof Boolean) {
                reference = reference.startAt(((Boolean) obj2).booleanValue());
            } else if (obj2 instanceof Number) {
                reference = reference.startAt(((Number) obj2).doubleValue());
            } else {
                reference = reference.startAt((String) obj2);
            }
        }
        if (map2.containsKey("endAt")) {
            Object obj3 = map2.get("endAt");
            if (map2.containsKey("endAtKey")) {
                String str2 = (String) map2.get("endAtKey");
                if (obj3 instanceof Boolean) {
                    reference = reference.endAt(((Boolean) obj3).booleanValue(), str2);
                } else if (obj3 instanceof Number) {
                    reference = reference.endAt(((Number) obj3).doubleValue(), str2);
                } else {
                    reference = reference.endAt((String) obj3, str2);
                }
            } else if (obj3 instanceof Boolean) {
                reference = reference.endAt(((Boolean) obj3).booleanValue());
            } else if (obj3 instanceof Number) {
                reference = reference.endAt(((Number) obj3).doubleValue());
            } else {
                reference = reference.endAt((String) obj3);
            }
        }
        if (map2.containsKey("equalTo")) {
            Object obj4 = map2.get("equalTo");
            if (map2.containsKey("equalToKey")) {
                String str3 = (String) map2.get("equalToKey");
                if (obj4 instanceof Boolean) {
                    reference = reference.equalTo(((Boolean) obj4).booleanValue(), str3);
                } else if (obj4 instanceof Number) {
                    reference = reference.equalTo(((Number) obj4).doubleValue(), str3);
                } else {
                    reference = reference.equalTo((String) obj4, str3);
                }
            } else if (obj4 instanceof Boolean) {
                reference = reference.equalTo(((Boolean) obj4).booleanValue());
            } else if (obj4 instanceof Number) {
                reference = reference.equalTo(((Number) obj4).doubleValue());
            } else {
                reference = reference.equalTo((String) obj4);
            }
        }
        if (map2.containsKey("limitToFirst")) {
            reference = reference.limitToFirst(((Integer) map2.get("limitToFirst")).intValue());
        }
        if (map2.containsKey("limitToLast")) {
            return reference.limitToLast(((Integer) map2.get("limitToLast")).intValue());
        }
        return reference;
    }

    private DatabaseReference getReference(FirebaseDatabase firebaseDatabase, Map<String, Object> map) {
        String str = (String) map.get("path");
        DatabaseReference reference = firebaseDatabase.getReference();
        if (str != null) {
            return reference.child(str);
        }
        return reference;
    }

    public void d() {
        int size = this.observers.size();
        for (int i11 = 0; i11 < size; i11++) {
            EventObserver valueAt = this.observers.valueAt(i11);
            Query a11 = valueAt.query;
            if (valueAt.requestedEventType.equals(EVENT_TYPE_VALUE)) {
                a11.removeEventListener((ValueEventListener) valueAt);
            } else {
                a11.removeEventListener((ChildEventListener) valueAt);
            }
        }
        this.observers.clear();
    }

    public void onMethodCall(MethodCall methodCall, @NonNull final MethodChannel.Result result) {
        FirebaseDatabase firebaseDatabase;
        final Map map = (Map) methodCall.arguments();
        String str = (String) methodCall.argument("app");
        String str2 = (String) methodCall.argument("databaseURL");
        if (str != null && str2 != null) {
            firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance(str), str2);
        } else if (str != null) {
            firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance(str));
        } else if (str2 != null) {
            firebaseDatabase = FirebaseDatabase.getInstance(str2);
        } else {
            firebaseDatabase = FirebaseDatabase.getInstance();
        }
        String str3 = methodCall.method;
        str3.hashCode();
        char c11 = 65535;
        switch (str3.hashCode()) {
            case -2082411450:
                if (str3.equals("DatabaseReference#runTransaction")) {
                    c11 = 0;
                    break;
                }
                break;
            case -2059578349:
                if (str3.equals("DatabaseReference#setPriority")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1666493916:
                if (str3.equals("FirebaseDatabase#purgeOutstandingWrites")) {
                    c11 = 2;
                    break;
                }
                break;
            case -858161988:
                if (str3.equals("DatabaseReference#update")) {
                    c11 = 3;
                    break;
                }
                break;
            case -526424742:
                if (str3.equals("FirebaseDatabase#goOffline")) {
                    c11 = 4;
                    break;
                }
                break;
            case -429179942:
                if (str3.equals("OnDisconnect#set")) {
                    c11 = 5;
                    break;
                }
                break;
            case -283892250:
                if (str3.equals("FirebaseDatabase#setPersistenceCacheSizeBytes")) {
                    c11 = 6;
                    break;
                }
                break;
            case -43852798:
                if (str3.equals("OnDisconnect#cancel")) {
                    c11 = 7;
                    break;
                }
                break;
            case 195628283:
                if (str3.equals("Query#get")) {
                    c11 = 8;
                    break;
                }
                break;
            case 272980762:
                if (str3.equals("Query#keepSynced")) {
                    c11 = 9;
                    break;
                }
                break;
            case 485025361:
                if (str3.equals("OnDisconnect#update")) {
                    c11 = 10;
                    break;
                }
                break;
            case 734082383:
                if (str3.equals("DatabaseReference#set")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1210091107:
                if (str3.equals("FirebaseDatabase#setLoggingEnabled")) {
                    c11 = 12;
                    break;
                }
                break;
            case 1593173173:
                if (str3.equals("Query#removeObserver")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 1653150716:
                if (str3.equals("FirebaseDatabase#goOnline")) {
                    c11 = 14;
                    break;
                }
                break;
            case 1749611585:
                if (str3.equals("Query#observe")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2058796707:
                if (str3.equals("FirebaseDatabase#setPersistenceEnabled")) {
                    c11 = 16;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                DatabaseReference reference = getReference(firebaseDatabase, map);
                final MethodCall methodCall2 = methodCall;
                final DatabaseReference databaseReference = reference;
                final MethodChannel.Result result2 = result;
                reference.runTransaction(new Transaction.Handler() {
                    @NonNull
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                        Task task = taskCompletionSource.getTask();
                        final HashMap hashMap = new HashMap();
                        hashMap.put("transactionKey", methodCall2.argument("transactionKey"));
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("key", mutableData.getKey());
                        hashMap2.put("value", mutableData.getValue());
                        hashMap.put(StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME, hashMap2);
                        MethodCallHandlerImpl.this.handler.post(new Runnable() {
                            public void run() {
                                MethodCallHandlerImpl.this.channel.invokeMethod("DoTransaction", hashMap, new MethodChannel.Result() {
                                    public void error(String str, String str2, Object obj) {
                                        taskCompletionSource.setException(new Exception("Error code: " + str + "\nError message: " + str2 + "\nError details: " + obj));
                                    }

                                    public void notImplemented() {
                                        taskCompletionSource.setException(new Exception("DoTransaction not implemented on Dart side."));
                                    }

                                    public void success(Object obj) {
                                        taskCompletionSource.setResult((Map) obj);
                                    }
                                });
                            }
                        });
                        try {
                            mutableData.setValue(((Map) Tasks.await(task, (long) ((Integer) map.get("transactionTimeout")).intValue(), TimeUnit.MILLISECONDS)).get("value"));
                            return Transaction.success(mutableData);
                        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
                            Log.e(MethodCallHandlerImpl.TAG, "Unable to commit Snapshot update. Transaction failed.", e11);
                            if (e11 instanceof TimeoutException) {
                                Log.e(MethodCallHandlerImpl.TAG, "Transaction at " + databaseReference.toString() + " timed out.");
                            }
                            return Transaction.abort();
                        }
                    }

                    public void onComplete(DatabaseError databaseError, boolean z11, DataSnapshot dataSnapshot) {
                        final HashMap hashMap = new HashMap();
                        hashMap.put("transactionKey", methodCall2.argument("transactionKey"));
                        if (databaseError != null) {
                            hashMap.put("error", MethodCallHandlerImpl.asMap(databaseError));
                        }
                        hashMap.put("committed", Boolean.valueOf(z11));
                        if (dataSnapshot != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("key", dataSnapshot.getKey());
                            hashMap2.put("value", dataSnapshot.getValue());
                            hashMap.put(StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME, hashMap2);
                        }
                        MethodCallHandlerImpl.this.handler.post(new Runnable() {
                            public void run() {
                                result2.success(hashMap);
                            }
                        });
                    }
                });
                return;
            case 1:
                getReference(firebaseDatabase, map).setPriority(methodCall.argument("priority"), new DefaultCompletionListener(result));
                return;
            case 2:
                firebaseDatabase.purgeOutstandingWrites();
                result.success((Object) null);
                return;
            case 3:
                getReference(firebaseDatabase, map).updateChildren((Map) methodCall.argument("value"), new DefaultCompletionListener(result));
                return;
            case 4:
                firebaseDatabase.goOffline();
                result.success((Object) null);
                return;
            case 5:
                Object argument = methodCall.argument("value");
                Object argument2 = methodCall.argument("priority");
                DatabaseReference reference2 = getReference(firebaseDatabase, map);
                if (argument2 == null) {
                    reference2.onDisconnect().setValue(argument, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (argument2 instanceof String) {
                    reference2.onDisconnect().setValue(argument, (String) argument2, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (argument2 instanceof Double) {
                    reference2.onDisconnect().setValue(argument, ((Double) argument2).doubleValue(), (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else if (argument2 instanceof Map) {
                    reference2.onDisconnect().setValue(argument, (Map) argument2, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                } else {
                    return;
                }
            case 6:
                Object argument3 = methodCall.argument("cacheSize");
                Long l11 = 10485760L;
                if (argument3 instanceof Long) {
                    l11 = (Long) argument3;
                } else if (argument3 instanceof Integer) {
                    l11 = Long.valueOf((long) ((Integer) argument3).intValue());
                }
                try {
                    firebaseDatabase.setPersistenceCacheSizeBytes(l11.longValue());
                    result.success(Boolean.TRUE);
                    return;
                } catch (DatabaseException unused) {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 7:
                getReference(firebaseDatabase, map).onDisconnect().cancel(new DefaultCompletionListener(result));
                return;
            case 8:
                getReference(firebaseDatabase, map).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            result.error("get-failed", task.getException().getMessage(), (Object) null);
                            return;
                        }
                        DataSnapshot result = task.getResult();
                        HashMap hashMap = new HashMap();
                        hashMap.put("key", result.getKey());
                        hashMap.put("value", result.getValue());
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME, hashMap);
                        result.success(hashMap2);
                    }
                });
                return;
            case 9:
                getQuery(firebaseDatabase, map).keepSynced(((Boolean) methodCall.argument("value")).booleanValue());
                result.success((Object) null);
                return;
            case 10:
                getReference(firebaseDatabase, map).onDisconnect().updateChildren((Map) methodCall.argument("value"), new DefaultCompletionListener(result));
                return;
            case 11:
                Object argument4 = methodCall.argument("value");
                Object argument5 = methodCall.argument("priority");
                DatabaseReference reference3 = getReference(firebaseDatabase, map);
                if (argument5 != null) {
                    reference3.setValue(argument4, argument5, new DefaultCompletionListener(result));
                    return;
                } else {
                    reference3.setValue(argument4, (DatabaseReference.CompletionListener) new DefaultCompletionListener(result));
                    return;
                }
            case 12:
                if (((Boolean) methodCall.argument("enabled")).booleanValue()) {
                    firebaseDatabase.setLogLevel(Logger.Level.DEBUG);
                } else {
                    firebaseDatabase.setLogLevel(Logger.Level.INFO);
                }
                result.success((Object) null);
                return;
            case 13:
                Integer num = (Integer) methodCall.argument("handle");
                EventObserver eventObserver = this.observers.get(num.intValue());
                if (eventObserver != null) {
                    Query a11 = eventObserver.query;
                    if (eventObserver.requestedEventType.equals(EVENT_TYPE_VALUE)) {
                        a11.removeEventListener((ValueEventListener) eventObserver);
                    } else {
                        a11.removeEventListener((ChildEventListener) eventObserver);
                    }
                    this.observers.delete(num.intValue());
                    result.success((Object) null);
                    return;
                }
                result.error("unknown_handle", "removeObserver called on an unknown handle", (Object) null);
                return;
            case 14:
                firebaseDatabase.goOnline();
                result.success((Object) null);
                return;
            case 15:
                String str4 = (String) methodCall.argument(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
                int i11 = this.nextHandle;
                this.nextHandle = i11 + 1;
                Query query = getQuery(firebaseDatabase, map);
                EventObserver eventObserver2 = new EventObserver(this.channel, str4, query, i11);
                this.observers.put(i11, eventObserver2);
                if (EVENT_TYPE_VALUE.equals(str4)) {
                    query.addValueEventListener(eventObserver2);
                } else {
                    query.addChildEventListener(eventObserver2);
                }
                result.success(Integer.valueOf(i11));
                return;
            case 16:
                try {
                    firebaseDatabase.setPersistenceEnabled(((Boolean) methodCall.argument("enabled")).booleanValue());
                    result.success(Boolean.TRUE);
                    return;
                } catch (DatabaseException unused2) {
                    result.success(Boolean.FALSE);
                    return;
                }
            default:
                result.notImplemented();
                return;
        }
    }
}
