package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

@ExperimentalRoomApi
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public int f37458b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<Integer, String> f37459c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> f37460d = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() {
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.f37459c.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };
    private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub() {
        public void broadcastInvalidation(int i11, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f37460d) {
                String str = MultiInstanceInvalidationService.this.f37459c.get(Integer.valueOf(i11));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f37460d.beginBroadcast();
                for (int i12 = 0; i12 < beginBroadcast; i12++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f37460d.getBroadcastCookie(i12)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f37459c.get(Integer.valueOf(intValue));
                        if (i11 != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.f37460d.getBroadcastItem(i12).onInvalidation(strArr);
                        }
                    } catch (RemoteException e11) {
                        Log.w("ROOM", "Error invoking a remote callback", e11);
                    } catch (Throwable th2) {
                        MultiInstanceInvalidationService.this.f37460d.finishBroadcast();
                        throw th2;
                    }
                }
                MultiInstanceInvalidationService.this.f37460d.finishBroadcast();
            }
        }

        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f37460d) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i11 = multiInstanceInvalidationService.f37458b + 1;
                multiInstanceInvalidationService.f37458b = i11;
                if (multiInstanceInvalidationService.f37460d.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i11))) {
                    MultiInstanceInvalidationService.this.f37459c.put(Integer.valueOf(i11), str);
                    return i11;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f37458b--;
                return 0;
            }
        }

        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i11) {
            synchronized (MultiInstanceInvalidationService.this.f37460d) {
                MultiInstanceInvalidationService.this.f37460d.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f37459c.remove(Integer.valueOf(i11));
            }
        }
    };

    @Nullable
    public IBinder onBind(@NonNull Intent intent) {
        return this.mBinder;
    }
}
