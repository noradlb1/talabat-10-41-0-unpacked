package bo.app;

import android.net.Uri;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lbo/app/v4;", "", "", "toString", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "a", "()Landroid/net/Uri;", "Ljava/net/URL;", "url", "Ljava/net/URL;", "b", "()Ljava/net/URL;", "<init>", "(Landroid/net/Uri;)V", "urlString", "(Ljava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class v4 {

    /* renamed from: a  reason: collision with root package name */
    private final String f39505a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f39506b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f39507c;

    public v4(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.f39506b = uri;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        this.f39505a = uri2;
        this.f39507c = new URL(uri2);
    }

    public final Uri a() {
        return this.f39506b;
    }

    public final URL b() {
        return this.f39507c;
    }

    public String toString() {
        return this.f39505a;
    }

    public v4(String str) {
        Intrinsics.checkNotNullParameter(str, "urlString");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(urlString)");
        this.f39506b = parse;
        this.f39505a = str;
        this.f39507c = new URL(str);
    }
}
