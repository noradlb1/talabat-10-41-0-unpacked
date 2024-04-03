package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "", "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventDiskStore {
    @NotNull
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    @NotNull
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventDiskStore.class.getName();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MovedClassObjectInputStream extends ObjectInputStream {
        @NotNull
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        @NotNull
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public MovedClassObjectInputStream(@Nullable InputStream inputStream) {
            super(inputStream);
        }

        @NotNull
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    private AppEventDiskStore() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0099 A[Catch:{ Exception -> 0x0035 }] */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x00a0 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00a0 }
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0083, Exception -> 0x004d, all -> 0x0049 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x0084, Exception -> 0x0047 }
            if (r3 == 0) goto L_0x003f
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x0084, Exception -> 0x0047 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch:{ Exception -> 0x0035 }
            r1.delete()     // Catch:{ Exception -> 0x0035 }
            goto L_0x003d
        L_0x0035:
            r1 = move-exception
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r2, r4, r1)     // Catch:{ all -> 0x00a0 }
        L_0x003d:
            r2 = r3
            goto L_0x0097
        L_0x003f:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x0084, Exception -> 0x0047 }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0084, Exception -> 0x0047 }
            throw r3     // Catch:{ FileNotFoundException -> 0x0084, Exception -> 0x0047 }
        L_0x0047:
            r3 = move-exception
            goto L_0x004f
        L_0x0049:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L_0x006d
        L_0x004d:
            r3 = move-exception
            r4 = r2
        L_0x004f:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x006c }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x006c }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0063 }
            r1.delete()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0097
        L_0x0063:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L_0x0068:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x00a0 }
            goto L_0x0097
        L_0x006c:
            r2 = move-exception
        L_0x006d:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x007a }
            r1.delete()     // Catch:{ Exception -> 0x007a }
            goto L_0x0082
        L_0x007a:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x00a0 }
        L_0x0082:
            throw r2     // Catch:{ all -> 0x00a0 }
        L_0x0083:
            r4 = r2
        L_0x0084:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0091 }
            r1.delete()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0097
        L_0x0091:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00a0 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L_0x0068
        L_0x0097:
            if (r2 != 0) goto L_0x009e
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x00a0 }
            r2.<init>()     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r0)
            return r2
        L_0x00a0:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    @JvmStatic
    public static final void saveEventsToDisk$facebook_core_release(@Nullable PersistedEvents persistedEvents) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream2.writeObject(persistedEvents);
                Utility.closeQuietly(objectOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility.closeQuietly(objectOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            Log.w(TAG, "Got unexpected exception while persisting events: ", th);
            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
        }
    }
}
