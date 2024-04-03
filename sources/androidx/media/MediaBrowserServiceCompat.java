package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private static final float EPSILON = 1.0E-5f;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f36183f = Log.isLoggable("MBServiceCompat", 3);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayMap<IBinder, ConnectionRecord> f36184b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ConnectionRecord f36185c;

    /* renamed from: d  reason: collision with root package name */
    public final ServiceHandler f36186d = new ServiceHandler();

    /* renamed from: e  reason: collision with root package name */
    public MediaSessionCompat.Token f36187e;
    private MediaBrowserServiceImpl mImpl;

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            if (str != null) {
                this.mRootId = str;
                this.mExtras = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    public class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();
        public final int uid;

        public ConnectionRecord(String str, int i11, int i12, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i11;
            this.uid = i12;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(str, i11, i12);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        public void binderDied() {
            MediaBrowserServiceCompat.this.f36186d.post(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f36184b.remove(connectionRecord.callbacks.asBinder());
                }
            });
        }
    }

    public interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    @RequiresApi(23)
    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        public MediaBrowserServiceImplApi23() {
            super();
        }

        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            this.f36202b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        public void onLoadItem(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                /* renamed from: g */
                public void e(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.sendResult(null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.sendResult(obtain);
                }
            });
        }
    }

    @RequiresApi(26)
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        public MediaBrowserServiceImplApi26() {
            super();
        }

        public void d(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.f36202b, str, bundle);
            } else {
                super.d(str, bundle);
            }
        }

        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36185c;
            if (connectionRecord == null) {
                return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.f36202b);
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.f36185c.rootHints);
        }

        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            this.f36202b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                /* renamed from: g */
                public void e(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList, a());
                }
            }, bundle);
        }
    }

    @RequiresApi(28)
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        public MediaBrowserServiceImplApi28() {
            super();
        }

        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36185c;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.f36202b).getCurrentBrowserInfo());
        }
    }

    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MediaBrowserServiceCompat f36223a;
        private Messenger mMessenger;

        public void a(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        this.f36223a.e(str, connectionRecord, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        public Bundle getBrowserRootHints() {
            ConnectionRecord connectionRecord = this.f36223a.f36185c;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (connectionRecord.rootHints == null) {
                return null;
            } else {
                return new Bundle(this.f36223a.f36185c.rootHints);
            }
        }

        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = this.f36223a.f36185c;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public void notifyChildrenChanged(@NonNull final String str, final Bundle bundle) {
            this.f36223a.f36186d.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceImplBase.this.f36223a.f36184b.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceImplBase.this.f36223a.f36184b;
                        MediaBrowserServiceImplBase.this.a(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        public void onCreate() {
            this.mMessenger = new Messenger(this.f36223a.f36186d);
        }

        public void setSessionToken(final MediaSessionCompat.Token token) {
            this.f36223a.f36186d.post(new Runnable() {
                public void run() {
                    Iterator<ConnectionRecord> it = MediaBrowserServiceImplBase.this.f36223a.f36184b.values().iterator();
                    while (it.hasNext()) {
                        ConnectionRecord next = it.next();
                        try {
                            next.callbacks.onConnect(next.root.getRootId(), token, next.root.getExtras());
                        } catch (RemoteException unused) {
                            Log.w("MBServiceCompat", "Connection for " + next.pkg + " is no longer valid.");
                            it.remove();
                        }
                    }
                }
            });
        }

        public void notifyChildrenChanged(@NonNull final MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull final String str, final Bundle bundle) {
            this.f36223a.f36186d.post(new Runnable() {
                public void run() {
                    for (int i11 = 0; i11 < MediaBrowserServiceImplBase.this.f36223a.f36184b.size(); i11++) {
                        ConnectionRecord valueAt = MediaBrowserServiceImplBase.this.f36223a.f36184b.valueAt(i11);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.a(valueAt, str, bundle);
                            return;
                        }
                    }
                }
            });
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        public Result(Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f11 = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f11 < -1.0E-5f || f11 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public int a() {
            return this.mFlags;
        }

        public boolean b() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        public void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        public void d(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            } else if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            } else if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
            } else {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
        }

        public void e(T t11) {
        }

        public void f(int i11) {
            this.mFlags = i11;
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            c(bundle);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            d(bundle);
        }

        public void sendResult(T t11) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            e(t11);
        }
    }

    public class ServiceBinderImpl {
        public ServiceBinderImpl() {
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36184b.get(serviceCallbacks2.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str2);
                        return;
                    }
                    MediaBrowserServiceCompat.this.a(str2, connectionRecord, iBinder2, bundle2);
                }
            });
        }

        public void connect(String str, int i11, int i12, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (MediaBrowserServiceCompat.this.c(str, i12)) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final int i13 = i11;
                final int i14 = i12;
                final Bundle bundle2 = bundle;
                MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                    public void run() {
                        IBinder asBinder = serviceCallbacks2.asBinder();
                        MediaBrowserServiceCompat.this.f36184b.remove(asBinder);
                        ConnectionRecord connectionRecord = new ConnectionRecord(str2, i13, i14, bundle2, serviceCallbacks2);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat.f36185c = connectionRecord;
                        BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(str2, i14, bundle2);
                        connectionRecord.root = onGetRoot;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                        mediaBrowserServiceCompat2.f36185c = null;
                        if (onGetRoot == null) {
                            Log.i("MBServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                serviceCallbacks2.onConnectFailed();
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                            }
                        } else {
                            try {
                                mediaBrowserServiceCompat2.f36184b.put(asBinder, connectionRecord);
                                asBinder.linkToDeath(connectionRecord, 0);
                                if (MediaBrowserServiceCompat.this.f36187e != null) {
                                    serviceCallbacks2.onConnect(connectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.f36187e, connectionRecord.root.getExtras());
                                }
                            } catch (RemoteException unused2) {
                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                                MediaBrowserServiceCompat.this.f36184b.remove(asBinder);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i12 + " package=" + str);
        }

        public void disconnect(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.f36184b.remove(serviceCallbacks.asBinder());
                    if (remove != null) {
                        remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void getMediaItem(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36184b.get(serviceCallbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                            return;
                        }
                        MediaBrowserServiceCompat.this.f(str, connectionRecord, resultReceiver);
                    }
                });
            }
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, String str, int i11, int i12, Bundle bundle) {
            final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            final String str2 = str;
            final int i13 = i11;
            final int i14 = i12;
            final Bundle bundle2 = bundle;
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks2.asBinder();
                    MediaBrowserServiceCompat.this.f36184b.remove(asBinder);
                    ConnectionRecord connectionRecord = new ConnectionRecord(str2, i13, i14, bundle2, serviceCallbacks2);
                    MediaBrowserServiceCompat.this.f36184b.put(asBinder, connectionRecord);
                    try {
                        asBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void removeSubscription(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36184b.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!MediaBrowserServiceCompat.this.h(str, connectionRecord, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36184b.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.g(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                final ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final ResultReceiver resultReceiver2 = resultReceiver;
                MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                    public void run() {
                        ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36184b.get(serviceCallbacks2.asBinder());
                        if (connectionRecord == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                            return;
                        }
                        MediaBrowserServiceCompat.this.d(str2, bundle2, connectionRecord, resultReceiver2);
                    }
                });
            }
        }

        public void unregisterCallbacks(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    IBinder asBinder = serviceCallbacks.asBinder();
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.f36184b.remove(asBinder);
                    if (remove != null) {
                        asBinder.unlinkToDeath(remove, 0);
                    }
                }
            });
        }
    }

    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    public static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* renamed from: a  reason: collision with root package name */
        public final Messenger f36273a;

        public ServiceCallbacksCompat(Messenger messenger) {
            this.f36273a = messenger;
        }

        private void sendRequest(int i11, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.f36273a.send(obtain);
        }

        public IBinder asBinder() {
            return this.f36273a.getBinder();
        }

        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        public void onConnectFailed() throws RemoteException {
            sendRequest(2, (Bundle) null);
        }

        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            ArrayList arrayList;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                if (list instanceof ArrayList) {
                    arrayList = (ArrayList) list;
                } else {
                    arrayList = new ArrayList(list);
                }
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, arrayList);
            }
            sendRequest(3, bundle3);
        }
    }

    public final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        public ServiceHandler() {
            this.mServiceBinderImpl = new ServiceBinderImpl();
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    ServiceBinderImpl serviceBinderImpl = this.mServiceBinderImpl;
                    ServiceCallbacksCompat serviceCallbacksCompat = new ServiceCallbacksCompat(message.replyTo);
                    serviceBinderImpl.registerCallbacks(serviceCallbacksCompat, data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    return;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 2 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        public boolean sendMessageAtTime(Message message, long j11) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j11);
        }
    }

    public void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair pair : list) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, (Bundle) pair.second)) {
                return;
            }
        }
        list.add(new Pair(iBinder, bundle));
        connectionRecord.subscriptions.put(str, list);
        e(str, connectionRecord, bundle, (Bundle) null);
        this.f36185c = connectionRecord;
        onSubscribe(str, bundle);
        this.f36185c = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i11 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i12 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i11 == -1 && i12 == -1) {
            return list;
        }
        int i13 = i12 * i11;
        int i14 = i13 + i12;
        if (i11 < 0 || i12 < 1 || i13 >= list.size()) {
            return Collections.emptyList();
        }
        if (i14 > list.size()) {
            i14 = list.size();
        }
        return list.subList(i13, i14);
    }

    public boolean c(String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i11)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass4 r02 = new Result<Bundle>(str) {
            public void c(Bundle bundle) {
                resultReceiver.send(-1, bundle);
            }

            public void d(Bundle bundle) {
                resultReceiver.send(1, bundle);
            }

            /* renamed from: g */
            public void e(Bundle bundle) {
                resultReceiver.send(0, bundle);
            }
        };
        this.f36185c = connectionRecord;
        onCustomAction(str, bundle, r02);
        this.f36185c = null;
        if (!r02.b()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public void e(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        final ConnectionRecord connectionRecord2 = connectionRecord;
        final String str2 = str;
        final Bundle bundle3 = bundle;
        final Bundle bundle4 = bundle2;
        AnonymousClass1 r02 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* renamed from: g */
            public void e(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.f36184b.get(connectionRecord2.callbacks.asBinder()) == connectionRecord2) {
                    if ((a() & 1) != 0) {
                        list = MediaBrowserServiceCompat.this.b(list, bundle3);
                    }
                    try {
                        connectionRecord2.callbacks.onLoadChildren(str2, list, bundle3, bundle4);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + connectionRecord2.pkg);
                    }
                } else if (MediaBrowserServiceCompat.f36183f) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb2.append(connectionRecord2.pkg);
                    sb2.append(" id=");
                    sb2.append(str2);
                }
            }
        };
        this.f36185c = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, r02);
        } else {
            onLoadChildren(str, r02, bundle);
        }
        this.f36185c = null;
        if (!r02.b()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    public void f(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass2 r02 = new Result<MediaBrowserCompat.MediaItem>(str) {
            /* renamed from: g */
            public void e(MediaBrowserCompat.MediaItem mediaItem) {
                if ((a() & 2) != 0) {
                    resultReceiver.send(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.send(0, bundle);
            }
        };
        this.f36185c = connectionRecord;
        onLoadItem(str, r02);
        this.f36185c = null;
        if (!r02.b()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    public void g(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        AnonymousClass3 r02 = new Result<List<MediaBrowserCompat.MediaItem>>(str) {
            /* renamed from: g */
            public void e(List<MediaBrowserCompat.MediaItem> list) {
                if ((a() & 4) != 0 || list == null) {
                    resultReceiver.send(-1, (Bundle) null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.send(0, bundle);
            }
        };
        this.f36185c = connectionRecord;
        onSearch(str, bundle, r02);
        this.f36185c = null;
        if (!r02.b()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.f36187e;
    }

    public boolean h(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z11 = true;
        boolean z12 = false;
        if (iBinder == null) {
            try {
                if (connectionRecord.subscriptions.remove(str) == null) {
                    z11 = false;
                }
                return z11;
            } finally {
                this.f36185c = connectionRecord;
                onUnsubscribe(str);
                this.f36185c = null;
            }
        } else {
            List list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == ((Pair) it.next()).first) {
                        it.remove();
                        z12 = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            this.f36185c = connectionRecord;
            onUnsubscribe(str);
            this.f36185c = null;
            return z12;
        }
    }

    public void notifyChildrenChanged(@NonNull String str) {
        if (str != null) {
            this.mImpl.notifyChildrenChanged(str, (Bundle) null);
            return;
        }
        throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    }

    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            this.mImpl = new MediaBrowserServiceImplApi28();
        } else if (i11 >= 26) {
            this.mImpl = new MediaBrowserServiceImplApi26();
        } else {
            this.mImpl = new MediaBrowserServiceImplApi23();
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        result.sendError((Bundle) null);
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i11, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        result.f(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        result.f(2);
        result.sendResult(null);
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.f(4);
        result.sendResult(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.f36187e == null) {
            this.f36187e = token;
            this.mImpl.setSessionToken(token);
        } else {
            throw new IllegalStateException("The session token has already been set.");
        }
    }

    @RequiresApi(21)
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* renamed from: a  reason: collision with root package name */
        public final List<Bundle> f36201a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public Object f36202b;

        /* renamed from: c  reason: collision with root package name */
        public Messenger f36203c;

        public MediaBrowserServiceImplApi21() {
        }

        public void a(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.f36186d.post(new Runnable() {
                public void run() {
                    for (int i11 = 0; i11 < MediaBrowserServiceCompat.this.f36184b.size(); i11++) {
                        ConnectionRecord valueAt = MediaBrowserServiceCompat.this.f36184b.valueAt(i11);
                        if (valueAt.browserInfo.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.c(valueAt, str, bundle);
                        }
                    }
                }
            });
        }

        public void b(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.f36186d.post(new Runnable() {
                public void run() {
                    for (IBinder iBinder : MediaBrowserServiceCompat.this.f36184b.keySet()) {
                        ArrayMap<IBinder, ConnectionRecord> arrayMap = MediaBrowserServiceCompat.this.f36184b;
                        MediaBrowserServiceImplApi21.this.c(arrayMap.get(iBinder), str, bundle);
                    }
                }
            });
        }

        public void c(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle) pair.second)) {
                        MediaBrowserServiceCompat.this.e(str, connectionRecord, (Bundle) pair.second, bundle);
                    }
                }
            }
        }

        public void d(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.f36202b, str);
        }

        public Bundle getBrowserRootHints() {
            if (this.f36203c == null) {
                return null;
            }
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36185c;
            if (connectionRecord == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            } else if (connectionRecord.rootHints == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.f36185c.rootHints);
            }
        }

        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.f36185c;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        public void notifyChildrenChanged(String str, Bundle bundle) {
            d(str, bundle);
            b(str, bundle);
        }

        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.f36202b, intent);
        }

        public void onCreate() {
            Object createService = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            this.f36202b = createService;
            MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i11, Bundle bundle) {
            Bundle bundle2;
            IBinder iBinder;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.f36203c = new Messenger(MediaBrowserServiceCompat.this.f36186d);
                bundle2 = new Bundle();
                bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.f36203c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f36187e;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    if (extraBinder == null) {
                        iBinder = null;
                    } else {
                        iBinder = extraBinder.asBinder();
                    }
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, iBinder);
                } else {
                    this.f36201a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f36185c = new ConnectionRecord(str, -1, i11, bundle, (ServiceCallbacks) null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i11, bundle);
            MediaBrowserServiceCompat.this.f36185c = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
        }

        public void onLoadChildren(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) {
                public void detach() {
                    resultWrapper.detach();
                }

                /* renamed from: g */
                public void e(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem writeToParcel : list) {
                            Parcel obtain = Parcel.obtain();
                            writeToParcel.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.sendResult(arrayList);
                }
            });
        }

        public void setSessionToken(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.f36186d.postOrRun(new Runnable() {
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.f36201a.isEmpty()) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        if (extraBinder != null) {
                            for (Bundle putBinder : MediaBrowserServiceImplApi21.this.f36201a) {
                                BundleCompat.putBinder(putBinder, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.f36201a.clear();
                    }
                    MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.f36202b, token.getToken());
                }
            });
        }

        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            a(remoteUserInfo, str, bundle);
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        } else if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
        } else {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }
}
