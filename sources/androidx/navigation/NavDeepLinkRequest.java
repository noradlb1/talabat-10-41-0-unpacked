package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0011B%\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B\u000f\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", "", "uri", "Landroid/net/Uri;", "action", "", "mimeType", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getAction", "()Ljava/lang/String;", "getMimeType", "getUri", "()Landroid/net/Uri;", "toString", "Builder", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavDeepLinkRequest {
    @Nullable
    private final String action;
    @Nullable
    private final String mimeType;
    @Nullable
    private final Uri uri;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder;", "", "()V", "action", "", "mimeType", "uri", "Landroid/net/Uri;", "build", "Landroidx/navigation/NavDeepLinkRequest;", "setAction", "setMimeType", "setUri", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Nullable
        private String action;
        @Nullable
        private String mimeType;
        @Nullable
        private Uri uri;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLinkRequest$Builder;", "action", "", "fromMimeType", "mimeType", "fromUri", "uri", "Landroid/net/Uri;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Builder fromAction(@NotNull String str) {
                boolean z11;
                Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
                if (str.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    Builder builder = new Builder((DefaultConstructorMarker) null);
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
            }

            @JvmStatic
            @NotNull
            public final Builder fromMimeType(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "mimeType");
                Builder builder = new Builder((DefaultConstructorMarker) null);
                builder.setMimeType(str);
                return builder;
            }

            @JvmStatic
            @NotNull
            public final Builder fromUri(@NotNull Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                Builder builder = new Builder((DefaultConstructorMarker) null);
                builder.setUri(uri);
                return builder;
            }
        }

        private Builder() {
        }

        public /* synthetic */ Builder(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public static final Builder fromAction(@NotNull String str) {
            return Companion.fromAction(str);
        }

        @JvmStatic
        @NotNull
        public static final Builder fromMimeType(@NotNull String str) {
            return Companion.fromMimeType(str);
        }

        @JvmStatic
        @NotNull
        public static final Builder fromUri(@NotNull Uri uri2) {
            return Companion.fromUri(uri2);
        }

        @NotNull
        public final NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.uri, this.action, this.mimeType);
        }

        @NotNull
        public final Builder setAction(@NotNull String str) {
            boolean z11;
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            if (str.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.".toString());
        }

        @NotNull
        public final Builder setMimeType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            if (new Regex("^[-\\w*.]+/[-\\w+*.]+$").matches(str)) {
                this.mimeType = str;
                return this;
            }
            throw new IllegalArgumentException(("The given mimeType " + str + " does not match to required \"type/subtype\" format").toString());
        }

        @NotNull
        public final Builder setUri(@NotNull Uri uri2) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            this.uri = uri2;
            return this;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(@Nullable Uri uri2, @Nullable String str, @Nullable String str2) {
        this.uri = uri2;
        this.action = str;
        this.mimeType = str2;
    }

    @Nullable
    public String getAction() {
        return this.action;
    }

    @Nullable
    public String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NavDeepLinkRequest");
        sb2.append("{");
        if (getUri() != null) {
            sb2.append(" uri=");
            sb2.append(String.valueOf(getUri()));
        }
        if (getAction() != null) {
            sb2.append(" action=");
            sb2.append(getAction());
        }
        if (getMimeType() != null) {
            sb2.append(" mimetype=");
            sb2.append(getMimeType());
        }
        sb2.append(" }");
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLinkRequest(@NotNull Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
    }
}
