package com.facebook.bolts;

import android.net.Uri;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AppLink;", "", "sourceUrl", "Landroid/net/Uri;", "targets", "", "Lcom/facebook/bolts/AppLink$Target;", "webUrl", "(Landroid/net/Uri;Ljava/util/List;Landroid/net/Uri;)V", "getSourceUrl", "()Landroid/net/Uri;", "getTargets", "()Ljava/util/List;", "getWebUrl", "Target", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppLink {
    @NotNull
    private final Uri sourceUrl;
    @NotNull
    private final List<Target> targets;
    @NotNull
    private final Uri webUrl;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AppLink$Target;", "", "packageName", "", "className", "url", "Landroid/net/Uri;", "appName", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getClassName", "getPackageName", "getUrl", "()Landroid/net/Uri;", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Target {
        @NotNull
        private final String appName;
        @NotNull
        private final String className;
        @NotNull
        private final String packageName;
        @NotNull
        private final Uri url;

        public Target(@NotNull String str, @NotNull String str2, @NotNull Uri uri, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_CLASS_NAME);
            Intrinsics.checkNotNullParameter(uri, "url");
            Intrinsics.checkNotNullParameter(str3, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
            this.packageName = str;
            this.className = str2;
            this.url = uri;
            this.appName = str3;
        }

        @NotNull
        public final String getAppName() {
            return this.appName;
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        @NotNull
        public final String getPackageName() {
            return this.packageName;
        }

        @NotNull
        public final Uri getUrl() {
            return this.url;
        }
    }

    public AppLink(@NotNull Uri uri, @Nullable List<Target> list, @NotNull Uri uri2) {
        Intrinsics.checkNotNullParameter(uri, "sourceUrl");
        Intrinsics.checkNotNullParameter(uri2, "webUrl");
        this.sourceUrl = uri;
        this.webUrl = uri2;
        this.targets = list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @NotNull
    public final Uri getSourceUrl() {
        return this.sourceUrl;
    }

    @NotNull
    public final List<Target> getTargets() {
        List<Target> unmodifiableList = Collections.unmodifiableList(this.targets);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(field)");
        return unmodifiableList;
    }

    @NotNull
    public final Uri getWebUrl() {
        return this.webUrl;
    }
}
