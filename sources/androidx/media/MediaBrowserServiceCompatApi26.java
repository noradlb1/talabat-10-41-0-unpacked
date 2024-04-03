package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompatApi23;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(26)
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";

    /* renamed from: a  reason: collision with root package name */
    public static Field f36279a;

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((ServiceCompatProxy) this.f36277b).onLoadChildren(str, new ResultWrapper(result), bundle);
        }
    }

    public static class ResultWrapper {

        /* renamed from: a  reason: collision with root package name */
        public MediaBrowserService.Result f36280a;

        public ResultWrapper(MediaBrowserService.Result result) {
            this.f36280a = result;
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
            this.f36280a.detach();
        }

        public void sendResult(List<Parcel> list, int i11) {
            try {
                MediaBrowserServiceCompatApi26.f36279a.setInt(this.f36280a, i11);
            } catch (IllegalAccessException e11) {
                Log.w(MediaBrowserServiceCompatApi26.TAG, e11);
            }
            this.f36280a.sendResult(a(list));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, ResultWrapper resultWrapper, Bundle bundle);
    }

    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            f36279a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e11) {
            Log.w(TAG, e11);
        }
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static Bundle getBrowserRootHints(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }
}
