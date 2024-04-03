package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    public static class BrowserRoot {

        /* renamed from: a  reason: collision with root package name */
        public final String f36275a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f36276b;

        public BrowserRoot(String str, Bundle bundle) {
            this.f36275a = str;
            this.f36276b = bundle;
        }
    }

    public static class MediaBrowserServiceAdaptor extends MediaBrowserService {

        /* renamed from: b  reason: collision with root package name */
        public final ServiceCompatProxy f36277b;

        public MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.f36277b = serviceCompatProxy;
        }

        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i11, Bundle bundle) {
            Bundle bundle2;
            MediaSessionCompat.ensureClassLoader(bundle);
            ServiceCompatProxy serviceCompatProxy = this.f36277b;
            if (bundle == null) {
                bundle2 = null;
            } else {
                bundle2 = new Bundle(bundle);
            }
            BrowserRoot onGetRoot = serviceCompatProxy.onGetRoot(str, i11, bundle2);
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.f36275a, onGetRoot.f36276b);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.f36277b.onLoadChildren(str, new ResultWrapper(result));
        }
    }

    public static class ResultWrapper<T> {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserService.Result f36278a;

        public ResultWrapper(MediaBrowserService.Result result) {
            this.f36278a = result;
        }

        public List<MediaBrowser.MediaItem> a(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel next : list) {
                next.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(next));
                next.recycle();
            }
            return arrayList;
        }

        public void detach() {
            this.f36278a.detach();
        }

        public void sendResult(T t11) {
            if (t11 instanceof List) {
                this.f36278a.sendResult(a((List) t11));
            } else if (t11 instanceof Parcel) {
                Parcel parcel = (Parcel) t11;
                parcel.setDataPosition(0);
                this.f36278a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            } else {
                this.f36278a.sendResult((Object) null);
            }
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String str, int i11, Bundle bundle);

        void onLoadChildren(String str, ResultWrapper<List<Parcel>> resultWrapper);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static void notifyChildrenChanged(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    public static IBinder onBind(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void onCreate(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static void setSessionToken(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
