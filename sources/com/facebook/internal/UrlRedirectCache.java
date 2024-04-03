package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/UrlRedirectCache;", "", "()V", "redirectContentTag", "", "tag", "urlRedirectFileLruCache", "Lcom/facebook/internal/FileLruCache;", "cacheUriRedirect", "", "fromUri", "Landroid/net/Uri;", "toUri", "clearCache", "getCache", "getRedirectedUri", "uri", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UrlRedirectCache {
    @NotNull
    public static final UrlRedirectCache INSTANCE = new UrlRedirectCache();
    @NotNull
    private static final String redirectContentTag;
    @NotNull
    private static final String tag;
    @Nullable
    private static FileLruCache urlRedirectFileLruCache;

    static {
        String simpleName = Reflection.getOrCreateKotlinClass(UrlRedirectCache.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "UrlRedirectCache";
        }
        tag = simpleName;
        redirectContentTag = Intrinsics.stringPlus(simpleName, "_Redirect");
    }

    private UrlRedirectCache() {
    }

    @JvmStatic
    public static final void cacheUriRedirect(@Nullable Uri uri, @Nullable Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                FileLruCache cache = getCache();
                String uri3 = uri.toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "fromUri.toString()");
                outputStream = cache.openPutStream(uri3, redirectContentTag);
                String uri4 = uri2.toString();
                Intrinsics.checkNotNullExpressionValue(uri4, "toUri.toString()");
                byte[] bytes = uri4.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
            } catch (IOException e11) {
                Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e11.getMessage()));
            } catch (Throwable th2) {
                Utility.closeQuietly(outputStream);
                throw th2;
            }
            Utility.closeQuietly(outputStream);
        }
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e11) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, tag, Intrinsics.stringPlus("clearCache failed ", e11.getMessage()));
        }
    }

    @JvmStatic
    @NotNull
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            fileLruCache = urlRedirectFileLruCache;
            if (fileLruCache == null) {
                fileLruCache = new FileLruCache(tag, new FileLruCache.Limits());
            }
            urlRedirectFileLruCache = fileLruCache;
        }
        return fileLruCache;
    }

    @JvmStatic
    @Nullable
    public static final Uri getRedirectedUri(@Nullable Uri uri) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        HashSet hashSet = new HashSet();
        hashSet.add(uri2);
        try {
            FileLruCache cache = getCache();
            InputStream inputStream = cache.get(uri2, redirectContentTag);
            inputStreamReader = null;
            boolean z11 = false;
            while (true) {
                if (inputStream == null) {
                    break;
                }
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                } catch (IOException e11) {
                    e = e11;
                    try {
                        Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader3 = inputStreamReader;
                    }
                }
                try {
                    char[] cArr = new char[128];
                    StringBuilder sb2 = new StringBuilder();
                    for (int read = inputStreamReader2.read(cArr, 0, 128); read > 0; read = inputStreamReader2.read(cArr, 0, 128)) {
                        sb2.append(cArr, 0, read);
                    }
                    Utility.closeQuietly(inputStreamReader2);
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "urlBuilder.toString()");
                    if (!hashSet.contains(sb3)) {
                        hashSet.add(sb3);
                        inputStreamReader = inputStreamReader2;
                        z11 = true;
                        String str = sb3;
                        inputStream = cache.get(sb3, redirectContentTag);
                        uri2 = str;
                    } else if (Intrinsics.areEqual((Object) sb3, (Object) uri2)) {
                        inputStreamReader = inputStreamReader2;
                        z11 = true;
                    } else {
                        Logger.Companion.log(LoggingBehavior.CACHE, 6, tag, "A loop detected in UrlRedirectCache");
                        Utility.closeQuietly(inputStreamReader2);
                        return null;
                    }
                } catch (IOException e12) {
                    e = e12;
                    inputStreamReader = inputStreamReader2;
                    Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
                    Utility.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader3 = inputStreamReader2;
                    Utility.closeQuietly(inputStreamReader3);
                    throw th;
                }
            }
            if (z11) {
                Uri parse = Uri.parse(uri2);
                Utility.closeQuietly(inputStreamReader);
                return parse;
            }
        } catch (IOException e13) {
            e = e13;
            inputStreamReader = null;
            Logger.Companion.log(LoggingBehavior.CACHE, 4, tag, Intrinsics.stringPlus("IOException when accessing cache: ", e.getMessage()));
            Utility.closeQuietly(inputStreamReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
            Utility.closeQuietly(inputStreamReader3);
            throw th;
        }
        Utility.closeQuietly(inputStreamReader);
        return null;
    }
}
