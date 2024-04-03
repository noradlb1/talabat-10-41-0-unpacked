package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    private static final String TAG = "WebViewAssetLoader";
    private final List<PathMatcher> mMatchers;

    public static final class AssetsPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        @Nullable
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openAsset(str));
            } catch (IOException e11) {
                Log.e(WebViewAssetLoader.TAG, "Error opening asset path: " + str, e11);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }
    }

    public static final class Builder {
        private String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
        @NonNull
        private final List<Pair<String, PathHandler>> mHandlerList = new ArrayList();
        private boolean mHttpAllowed;

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            this.mHandlerList.add(Pair.create(str, pathHandler));
            return this;
        }

        @NonNull
        public WebViewAssetLoader build() {
            ArrayList arrayList = new ArrayList();
            for (Pair next : this.mHandlerList) {
                arrayList.add(new PathMatcher(this.mDomain, (String) next.first, this.mHttpAllowed, (PathHandler) next.second));
            }
            return new WebViewAssetLoader(arrayList);
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            this.mDomain = str;
            return this;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z11) {
            this.mHttpAllowed = z11;
            return this;
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
        private static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
        @NonNull
        private final File mDirectory;

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            try {
                this.mDirectory = new File(AssetHelper.getCanonicalDirPath(file));
                if (!isAllowedInternalStorageDir(context)) {
                    throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
                }
            } catch (IOException e11) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e11);
            }
        }

        private boolean isAllowedInternalStorageDir(@NonNull Context context) throws IOException {
            String canonicalDirPath = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String canonicalDirPath2 = AssetHelper.getCanonicalDirPath(context.getCacheDir());
            String canonicalDirPath3 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(context));
            if ((!canonicalDirPath.startsWith(canonicalDirPath2) && !canonicalDirPath.startsWith(canonicalDirPath3)) || canonicalDirPath.equals(canonicalDirPath2) || canonicalDirPath.equals(canonicalDirPath3)) {
                return false;
            }
            for (String str : FORBIDDEN_DATA_DIRS) {
                if (canonicalDirPath.startsWith(canonicalDirPath3 + str)) {
                    return false;
                }
            }
            return true;
        }

        @WorkerThread
        @NonNull
        public WebResourceResponse handle(@NonNull String str) {
            try {
                File canonicalFileIfChild = AssetHelper.getCanonicalFileIfChild(this.mDirectory, str);
                if (canonicalFileIfChild != null) {
                    return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, AssetHelper.openFile(canonicalFileIfChild));
                }
                Log.e(WebViewAssetLoader.TAG, String.format("The requested file: %s is outside the mounted directory: %s", new Object[]{str, this.mDirectory}));
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException e11) {
                Log.e(WebViewAssetLoader.TAG, "Error opening the requested path: " + str, e11);
            }
        }
    }

    public interface PathHandler {
        @WorkerThread
        @Nullable
        WebResourceResponse handle(@NonNull String str);
    }

    @VisibleForTesting
    public static class PathMatcher {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f37933a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f37934b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final String f37935c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public final PathHandler f37936d;

        public PathMatcher(@NonNull String str, @NonNull String str2, boolean z11, @NonNull PathHandler pathHandler) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            } else if (str2.endsWith("/")) {
                this.f37934b = str;
                this.f37935c = str2;
                this.f37933a = z11;
                this.f37936d = pathHandler;
            } else {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
        }

        @WorkerThread
        @NonNull
        public String getSuffixPath(@NonNull String str) {
            return str.replaceFirst(this.f37935c, "");
        }

        @WorkerThread
        @Nullable
        public PathHandler match(@NonNull Uri uri) {
            if (uri.getScheme().equals(ProxyConfig.MATCH_HTTP) && !this.f37933a) {
                return null;
            }
            if ((uri.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.f37934b) && uri.getPath().startsWith(this.f37935c)) {
                return this.f37936d;
            }
            return null;
        }
    }

    public static final class ResourcesPathHandler implements PathHandler {
        private AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        @Nullable
        public WebResourceResponse handle(@NonNull String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openResource(str));
            } catch (Resources.NotFoundException e11) {
                Log.e(WebViewAssetLoader.TAG, "Resource not found from the path: " + str, e11);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException e12) {
                Log.e(WebViewAssetLoader.TAG, "Error opening resource from the path: " + str, e12);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }
    }

    public WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        this.mMatchers = list;
    }

    @WorkerThread
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        WebResourceResponse handle;
        for (PathMatcher next : this.mMatchers) {
            PathHandler match = next.match(uri);
            if (match != null && (handle = match.handle(next.getSuffixPath(uri.getPath()))) != null) {
                return handle;
            }
        }
        return null;
    }
}
