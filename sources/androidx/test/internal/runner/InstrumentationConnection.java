package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.LogUtil;
import androidx.test.internal.util.ParcelableIBinder;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Beta
public class InstrumentationConnection {
    public static final String BROADCAST_FILTER = "androidx.test.runner.InstrumentationConnection.event";
    private static final String BUNDLE_KEY_CLIENTS = "instr_clients";
    private static final String BUNDLE_KEY_CLIENT_MESSENGER = "instr_client_msgr";
    private static final String BUNDLE_KEY_CLIENT_TYPE = "instr_client_type";
    private static final String BUNDLE_KEY_UUID = "instr_uuid";
    private static final InstrumentationConnection DEFAULT_INSTANCE = new InstrumentationConnection(InstrumentationRegistry.getInstrumentation().getTargetContext());
    private static final int MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST = 3;
    private static final int MSG_PERFORM_CLEANUP = 11;
    private static final int MSG_PERFORM_CLEANUP_FINISHED = 12;
    private static final int MSG_REG_CLIENT = 8;
    private static final int MSG_REMOTE_ADD_CLIENT = 0;
    private static final int MSG_REMOTE_REMOVE_CLIENT = 1;
    private static final int MSG_REMOVE_CLIENTS_IN_BUNDLE = 7;
    private static final int MSG_REMOVE_INSTRUMENTATION = 5;
    private static final int MSG_TERMINATE = 2;
    private static final int MSG_UN_REG_CLIENT = 9;
    private static final String TAG = "InstrConnection";
    /* access modifiers changed from: private */
    public static MonitoringInstrumentation.ActivityFinisher activityFinisher;
    /* access modifiers changed from: private */
    public static Instrumentation instrumentation;

    /* renamed from: a  reason: collision with root package name */
    public IncomingHandler f37690a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    public final BroadcastReceiver f37691b = new MessengerReceiver();
    private Context targetContext;

    @VisibleForTesting
    public static class IncomingHandler extends Handler {
        @VisibleForTesting

        /* renamed from: a  reason: collision with root package name */
        public Messenger f37693a = new Messenger(this);
        @VisibleForTesting

        /* renamed from: b  reason: collision with root package name */
        public Set<Messenger> f37694b = new HashSet();
        @VisibleForTesting

        /* renamed from: c  reason: collision with root package name */
        public Map<String, Set<Messenger>> f37695c = new HashMap();
        /* access modifiers changed from: private */
        public final Map<UUID, CountDownLatch> latches = new HashMap();

        public IncomingHandler(Looper looper) {
            super(looper);
            if (Looper.getMainLooper() == looper || Looper.myLooper() == looper) {
                throw new IllegalStateException("This handler should not be using the main thread looper nor the instrumentation thread looper.");
            }
        }

        /* access modifiers changed from: private */
        public void associateLatch(final UUID uuid, final CountDownLatch countDownLatch) {
            runSyncTask(new Callable<Void>() {
                public Void call() {
                    IncomingHandler.this.latches.put(uuid, countDownLatch);
                    return null;
                }
            });
        }

        private void clientsRegistrationFromBundle(Bundle bundle, boolean z11) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "clientsRegistrationFromBundle called", new Object[0]);
            if (bundle == null) {
                Log.w(InstrumentationConnection.TAG, "The client bundle is null, ignoring...");
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(InstrumentationConnection.BUNDLE_KEY_CLIENTS);
            if (stringArrayList == null) {
                Log.w(InstrumentationConnection.TAG, "No clients found in the given bundle");
                return;
            }
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Parcelable[] parcelableArray = bundle.getParcelableArray(String.valueOf(next));
                if (parcelableArray != null) {
                    for (Parcelable parcelable : parcelableArray) {
                        if (z11) {
                            registerClient(next, (Messenger) parcelable);
                        } else {
                            unregisterClient(next, (Messenger) parcelable);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void disassociateLatch(final UUID uuid) {
            runSyncTask(new Callable<Void>() {
                public Void call() {
                    IncomingHandler.this.latches.remove(uuid);
                    return null;
                }
            });
        }

        /* access modifiers changed from: private */
        public void doDie() {
            Log.i(InstrumentationConnection.TAG, "terminating process");
            sendMessageToOtherInstr(5, (Bundle) null);
            this.f37694b.clear();
            this.f37695c.clear();
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "quitting looper...", new Object[0]);
            getLooper().quit();
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "finishing instrumentation...", new Object[0]);
            InstrumentationConnection.instrumentation.finish(0, (Bundle) null);
            Instrumentation unused = InstrumentationConnection.instrumentation = null;
            MonitoringInstrumentation.ActivityFinisher unused2 = InstrumentationConnection.activityFinisher = null;
        }

        /* access modifiers changed from: private */
        public Set<Messenger> getClientsForType(final String str) {
            FutureTask futureTask = new FutureTask(new Callable<Set<Messenger>>() {
                public Set<Messenger> call() {
                    return IncomingHandler.this.f37695c.get(str);
                }
            });
            post(futureTask);
            try {
                return (Set) futureTask.get();
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11);
            } catch (ExecutionException e12) {
                throw new IllegalStateException(e12.getCause());
            }
        }

        private void instrBinderDied(Messenger messenger) {
            Message obtainMessage = obtainMessage(5);
            obtainMessage.replyTo = messenger;
            sendMessage(obtainMessage);
        }

        private void notifyLatch(UUID uuid) {
            if (uuid == null || !this.latches.containsKey(uuid)) {
                String valueOf = String.valueOf(uuid);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
                sb2.append("Latch not found ");
                sb2.append(valueOf);
                Log.w(InstrumentationConnection.TAG, sb2.toString());
                return;
            }
            this.latches.get(uuid).countDown();
        }

        private void registerClient(String str, Messenger messenger) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "registerClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            Set set = this.f37695c.get(str);
            if (set == null) {
                HashSet hashSet = new HashSet();
                hashSet.add(messenger);
                this.f37695c.put(str, hashSet);
                return;
            }
            set.add(messenger);
        }

        /* access modifiers changed from: private */
        public <T> T runSyncTask(Callable<T> callable) {
            FutureTask futureTask = new FutureTask(callable);
            post(futureTask);
            try {
                return futureTask.get();
            } catch (InterruptedException e11) {
                throw new IllegalStateException(e11.getCause());
            } catch (ExecutionException e12) {
                throw new IllegalStateException(e12.getCause());
            }
        }

        private void sendMessageToOtherInstr(int i11, Bundle bundle) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "sendMessageToOtherInstr() called with: what = [%s], data = [%s]", Integer.valueOf(i11), bundle);
            for (Messenger sendMessageWithReply : this.f37694b) {
                sendMessageWithReply(sendMessageWithReply, i11, bundle);
            }
        }

        private void sendMessageWithReply(Messenger messenger, int i11, Bundle bundle) {
            StringBuilder sb2 = new StringBuilder(45);
            sb2.append("sendMessageWithReply type: ");
            sb2.append(i11);
            sb2.append(" called");
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, sb2.toString(), new Object[0]);
            Message obtainMessage = obtainMessage(i11);
            obtainMessage.replyTo = this.f37693a;
            if (bundle != null) {
                obtainMessage.setData(bundle);
            }
            if (!this.f37695c.isEmpty()) {
                Bundle data = obtainMessage.getData();
                data.putStringArrayList(InstrumentationConnection.BUNDLE_KEY_CLIENTS, new ArrayList(this.f37695c.keySet()));
                for (Map.Entry next : this.f37695c.entrySet()) {
                    data.putParcelableArray(String.valueOf(next.getKey()), (Messenger[]) ((Set) next.getValue()).toArray(new Messenger[((Set) next.getValue()).size()]));
                }
                obtainMessage.setData(data);
            }
            try {
                messenger.send(obtainMessage);
            } catch (RemoteException e11) {
                Log.w(InstrumentationConnection.TAG, "The remote process is terminated unexpectedly", e11);
                instrBinderDied(messenger);
            }
        }

        private void unregisterClient(String str, Messenger messenger) {
            String str2;
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "unregisterClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            if (!this.f37695c.containsKey(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "There are no registered clients for type: ".concat(valueOf);
                } else {
                    str2 = new String("There are no registered clients for type: ");
                }
                Log.w(InstrumentationConnection.TAG, str2);
                return;
            }
            Set set = this.f37695c.get(str);
            if (!set.contains(messenger)) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78);
                sb2.append("Could not unregister client for type ");
                sb2.append(str);
                sb2.append(" because it doesn't seem to be registered");
                Log.w(InstrumentationConnection.TAG, sb2.toString());
                return;
            }
            set.remove(messenger);
            if (set.isEmpty()) {
                this.f37695c.remove(str);
            }
        }

        public void handleMessage(Message message) {
            int i11 = message.what;
            switch (i11) {
                case 0:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_ADD_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    return;
                case 1:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_REMOVE_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), message.replyTo);
                    return;
                case 2:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_TERMINATE)", new Object[0]);
                    doDie();
                    return;
                case 3:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST)", new Object[0]);
                    if (this.f37694b.add(message.replyTo)) {
                        sendMessageWithReply(message.replyTo, 4, (Bundle) null);
                        return;
                    } else {
                        Log.w(InstrumentationConnection.TAG, "Broadcast with existing binder was received, ignoring it..");
                        return;
                    }
                case 4:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_ADD_INSTRUMENTATION)", new Object[0]);
                    if (this.f37694b.add(message.replyTo)) {
                        if (!this.f37695c.isEmpty()) {
                            sendMessageWithReply(message.replyTo, 6, (Bundle) null);
                        }
                        clientsRegistrationFromBundle(message.getData(), true);
                        return;
                    }
                    Log.w(InstrumentationConnection.TAG, "Message with existing binder was received, ignoring it..");
                    return;
                case 5:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOVE_INSTRUMENTATION)", new Object[0]);
                    if (!this.f37694b.remove(message.replyTo)) {
                        Log.w(InstrumentationConnection.TAG, "Attempting to remove a non-existent binder!");
                        return;
                    }
                    return;
                case 6:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_ADD_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), true);
                    return;
                case 7:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOVE_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), false);
                    return;
                case 8:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REG_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    sendMessageToOtherInstr(0, message.getData());
                    return;
                case 9:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_UN_REG_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString(InstrumentationConnection.BUNDLE_KEY_CLIENT_TYPE), (Messenger) message.getData().getParcelable(InstrumentationConnection.BUNDLE_KEY_CLIENT_MESSENGER));
                    sendMessageToOtherInstr(1, message.getData());
                    return;
                case 10:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_REMOTE_CLEANUP_REQUEST)", new Object[0]);
                    if (this.f37694b.isEmpty()) {
                        Message obtainMessage = obtainMessage(12);
                        obtainMessage.setData(message.getData());
                        sendMessage(obtainMessage);
                        return;
                    }
                    sendMessageToOtherInstr(11, message.getData());
                    return;
                case 11:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_PERFORM_CLEANUP)", new Object[0]);
                    InstrumentationConnection.instrumentation.runOnMainSync(InstrumentationConnection.activityFinisher);
                    sendMessageWithReply(message.replyTo, 12, message.getData());
                    return;
                case 12:
                    LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "handleMessage(MSG_PERFORM_CLEANUP_FINISHED)", new Object[0]);
                    notifyLatch((UUID) message.getData().getSerializable(InstrumentationConnection.BUNDLE_KEY_UUID));
                    return;
                default:
                    StringBuilder sb2 = new StringBuilder(42);
                    sb2.append("Unknown message code received: ");
                    sb2.append(i11);
                    Log.w(InstrumentationConnection.TAG, sb2.toString());
                    super.handleMessage(message);
                    return;
            }
        }
    }

    @VisibleForTesting
    public class MessengerReceiver extends BroadcastReceiver {
        public MessengerReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            LogUtil.logDebugWithProcess(InstrumentationConnection.TAG, "Broadcast received", new Object[0]);
            Bundle bundleExtra = intent.getBundleExtra("new_instrumentation_binder");
            if (bundleExtra == null) {
                Log.w(InstrumentationConnection.TAG, "Broadcast intent doesn't contain any extras, ignoring it..");
                return;
            }
            ParcelableIBinder parcelableIBinder = (ParcelableIBinder) bundleExtra.getParcelable("new_instrumentation_binder");
            if (parcelableIBinder != null) {
                Messenger messenger = new Messenger(parcelableIBinder.getIBinder());
                Message obtainMessage = InstrumentationConnection.this.f37690a.obtainMessage(3);
                obtainMessage.replyTo = messenger;
                InstrumentationConnection.this.f37690a.sendMessage(obtainMessage);
            }
        }
    }

    @VisibleForTesting
    public InstrumentationConnection(@NonNull Context context) {
        this.targetContext = (Context) Checks.checkNotNull(context, "Context can't be null");
    }

    public static InstrumentationConnection getInstance() {
        return DEFAULT_INSTANCE;
    }

    public synchronized Set<Messenger> getClientsForType(String str) {
        return this.f37690a.getClientsForType(str);
    }

    public synchronized void init(Instrumentation instrumentation2, MonitoringInstrumentation.ActivityFinisher activityFinisher2) {
        LogUtil.logDebugWithProcess(TAG, "init", new Object[0]);
        if (this.f37690a == null) {
            instrumentation = instrumentation2;
            activityFinisher = activityFinisher2;
            HandlerThread handlerThread = new HandlerThread("InstrumentationConnectionThread");
            handlerThread.start();
            this.f37690a = new IncomingHandler(handlerThread.getLooper());
            Intent intent = new Intent(BROADCAST_FILTER);
            Bundle bundle = new Bundle();
            bundle.putParcelable("new_instrumentation_binder", new ParcelableIBinder(this.f37690a.f37693a.getBinder()));
            intent.putExtra("new_instrumentation_binder", bundle);
            try {
                this.targetContext.sendBroadcast(intent);
                this.targetContext.registerReceiver(this.f37691b, new IntentFilter(BROADCAST_FILTER));
            } catch (SecurityException unused) {
                Log.i(TAG, "Could not send broadcast or register receiver (isolatedProcess?)");
            }
        }
        return;
    }

    public synchronized void registerClient(String str, Messenger messenger) {
        boolean z11;
        String str2;
        if (this.f37690a != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Checks.checkState(z11, "Instrumentation Connection in not yet initialized");
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Register client of type: ".concat(valueOf);
        } else {
            str2 = new String("Register client of type: ");
        }
        Log.i(TAG, str2);
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_CLIENT_TYPE, str);
        bundle.putParcelable(BUNDLE_KEY_CLIENT_MESSENGER, messenger);
        Message obtainMessage = this.f37690a.obtainMessage(8);
        obtainMessage.setData(bundle);
        this.f37690a.sendMessage(obtainMessage);
    }

    public synchronized void requestRemoteInstancesActivityCleanup() {
        boolean z11;
        IncomingHandler incomingHandler;
        if (this.f37690a != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Checks.checkState(z11, "Instrumentation Connection in not yet initialized");
        UUID randomUUID = UUID.randomUUID();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f37690a.associateLatch(randomUUID, countDownLatch);
        Message obtainMessage = this.f37690a.obtainMessage(10);
        obtainMessage.replyTo = this.f37690a.f37693a;
        Bundle data = obtainMessage.getData();
        data.putSerializable(BUNDLE_KEY_UUID, randomUUID);
        obtainMessage.setData(data);
        this.f37690a.sendMessage(obtainMessage);
        try {
            if (!countDownLatch.await(2, TimeUnit.SECONDS)) {
                String valueOf = String.valueOf(randomUUID);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 60);
                sb2.append("Timed out while attempting to perform activity clean up for ");
                sb2.append(valueOf);
                Log.w(TAG, sb2.toString());
            }
            incomingHandler = this.f37690a;
        } catch (InterruptedException e11) {
            try {
                String valueOf2 = String.valueOf(randomUUID);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 61);
                sb3.append("Interrupted while waiting for response from message with id: ");
                sb3.append(valueOf2);
                Log.e(TAG, sb3.toString(), e11);
                incomingHandler = this.f37690a;
            } catch (Throwable th2) {
                this.f37690a.disassociateLatch(randomUUID);
                throw th2;
            }
        }
        incomingHandler.disassociateLatch(randomUUID);
        return;
    }

    public synchronized void terminate() {
        LogUtil.logDebugWithProcess(TAG, "Terminate is called", new Object[0]);
        IncomingHandler incomingHandler = this.f37690a;
        if (incomingHandler != null) {
            Object unused = incomingHandler.runSyncTask(new Callable<Void>() {
                public Void call() {
                    InstrumentationConnection.this.f37690a.doDie();
                    return null;
                }
            });
            this.targetContext.unregisterReceiver(this.f37691b);
            this.f37690a = null;
        }
    }

    public synchronized void unregisterClient(String str, Messenger messenger) {
        boolean z11;
        String str2;
        if (this.f37690a != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Checks.checkState(z11, "Instrumentation Connection in not yet initialized");
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Unregister client of type: ".concat(valueOf);
        } else {
            str2 = new String("Unregister client of type: ");
        }
        Log.i(TAG, str2);
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_CLIENT_TYPE, str);
        bundle.putParcelable(BUNDLE_KEY_CLIENT_MESSENGER, messenger);
        Message obtainMessage = this.f37690a.obtainMessage(9);
        obtainMessage.setData(bundle);
        this.f37690a.sendMessage(obtainMessage);
    }
}
