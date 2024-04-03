package com.checkout.eventlogger.domain.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.visa.checkout.Profile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u0000 ,:\u0001,BO\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\u0003J\u0010\u0010\t\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\u0003J\u0010\u0010\n\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0003Jj\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0001HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0003R\u0019\u0010\u0011\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\u0003R\u0019\u0010\u000f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b\"\u0010\u0003R\u0019\u0010\u0010\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\u0003R\u0019\u0010\u0012\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b$\u0010\u0003R\u0019\u0010\u000e\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b%\u0010\u0003R\u0019\u0010\u0014\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b&\u0010\u0003R\u0019\u0010\u0013\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b'\u0010\u0003R\u0019\u0010\f\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b(\u0010\u0003R\u0019\u0010\r\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b)\u0010\u0003¨\u0006-"}, d2 = {"Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "productIdentifier", "productVersion", "environment", "appPackageName", "appPackageVersion", "appInstallId", "deviceName", "platform", "osVersion", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAppInstallId", "getAppPackageName", "getAppPackageVersion", "getDeviceName", "getEnvironment", "getOsVersion", "getPlatform", "getProductIdentifier", "getProductVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class RemoteProcessorMetadata {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f44246a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f44247b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f44248c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f44249d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f44250e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final String f44251f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f44252g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final String f44253h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final String f44254i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata$Companion;", "Landroid/content/Context;", "context", "", "environment", "productIdentifier", "productVersion", "Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "from", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/checkout/eventlogger/domain/model/RemoteProcessorMetadata;", "<init>", "()V", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RemoteProcessorMetadata from(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, Profile.ENVIRONMENT);
            Intrinsics.checkNotNullParameter(str2, "productIdentifier");
            Intrinsics.checkNotNullParameter(str3, "productVersion");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str4 = Build.MANUFACTURER + " - " + Build.MODEL;
            String str5 = "API-" + Build.VERSION.SDK_INT;
            String str6 = packageInfo.packageName;
            String str7 = str6 != null ? str6 : "unknown";
            String str8 = packageInfo.versionName;
            String str9 = str8 != null ? str8 : "unknown";
            String uuid = new UUID(packageInfo.firstInstallTime, packageInfo.lastUpdateTime).toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "UUID(\n                  …             ).toString()");
            return new RemoteProcessorMetadata(str2, str3, str, str7, str9, uuid, str4, "Android", str5);
        }
    }

    public RemoteProcessorMetadata(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(str2, "productVersion");
        Intrinsics.checkNotNullParameter(str3, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(str4, "appPackageName");
        Intrinsics.checkNotNullParameter(str5, "appPackageVersion");
        Intrinsics.checkNotNullParameter(str6, "appInstallId");
        Intrinsics.checkNotNullParameter(str7, "deviceName");
        Intrinsics.checkNotNullParameter(str8, "platform");
        Intrinsics.checkNotNullParameter(str9, AnalyticsAttribute.OS_VERSION_ATTRIBUTE);
        this.f44246a = str;
        this.f44247b = str2;
        this.f44248c = str3;
        this.f44249d = str4;
        this.f44250e = str5;
        this.f44251f = str6;
        this.f44252g = str7;
        this.f44253h = str8;
        this.f44254i = str9;
    }

    public static /* synthetic */ RemoteProcessorMetadata copy$default(RemoteProcessorMetadata remoteProcessorMetadata, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i11, Object obj) {
        RemoteProcessorMetadata remoteProcessorMetadata2 = remoteProcessorMetadata;
        int i12 = i11;
        return remoteProcessorMetadata.copy((i12 & 1) != 0 ? remoteProcessorMetadata2.f44246a : str, (i12 & 2) != 0 ? remoteProcessorMetadata2.f44247b : str2, (i12 & 4) != 0 ? remoteProcessorMetadata2.f44248c : str3, (i12 & 8) != 0 ? remoteProcessorMetadata2.f44249d : str4, (i12 & 16) != 0 ? remoteProcessorMetadata2.f44250e : str5, (i12 & 32) != 0 ? remoteProcessorMetadata2.f44251f : str6, (i12 & 64) != 0 ? remoteProcessorMetadata2.f44252g : str7, (i12 & 128) != 0 ? remoteProcessorMetadata2.f44253h : str8, (i12 & 256) != 0 ? remoteProcessorMetadata2.f44254i : str9);
    }

    @NotNull
    public final String component1() {
        return this.f44246a;
    }

    @NotNull
    public final String component2() {
        return this.f44247b;
    }

    @NotNull
    public final String component3() {
        return this.f44248c;
    }

    @NotNull
    public final String component4() {
        return this.f44249d;
    }

    @NotNull
    public final String component5() {
        return this.f44250e;
    }

    @NotNull
    public final String component6() {
        return this.f44251f;
    }

    @NotNull
    public final String component7() {
        return this.f44252g;
    }

    @NotNull
    public final String component8() {
        return this.f44253h;
    }

    @NotNull
    public final String component9() {
        return this.f44254i;
    }

    @NotNull
    public final RemoteProcessorMetadata copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(str2, "productVersion");
        Intrinsics.checkNotNullParameter(str3, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(str4, "appPackageName");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "appPackageVersion");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "appInstallId");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "deviceName");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "platform");
        String str14 = str9;
        Intrinsics.checkNotNullParameter(str14, AnalyticsAttribute.OS_VERSION_ATTRIBUTE);
        return new RemoteProcessorMetadata(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteProcessorMetadata)) {
            return false;
        }
        RemoteProcessorMetadata remoteProcessorMetadata = (RemoteProcessorMetadata) obj;
        return Intrinsics.areEqual((Object) this.f44246a, (Object) remoteProcessorMetadata.f44246a) && Intrinsics.areEqual((Object) this.f44247b, (Object) remoteProcessorMetadata.f44247b) && Intrinsics.areEqual((Object) this.f44248c, (Object) remoteProcessorMetadata.f44248c) && Intrinsics.areEqual((Object) this.f44249d, (Object) remoteProcessorMetadata.f44249d) && Intrinsics.areEqual((Object) this.f44250e, (Object) remoteProcessorMetadata.f44250e) && Intrinsics.areEqual((Object) this.f44251f, (Object) remoteProcessorMetadata.f44251f) && Intrinsics.areEqual((Object) this.f44252g, (Object) remoteProcessorMetadata.f44252g) && Intrinsics.areEqual((Object) this.f44253h, (Object) remoteProcessorMetadata.f44253h) && Intrinsics.areEqual((Object) this.f44254i, (Object) remoteProcessorMetadata.f44254i);
    }

    @NotNull
    public final String getAppInstallId() {
        return this.f44251f;
    }

    @NotNull
    public final String getAppPackageName() {
        return this.f44249d;
    }

    @NotNull
    public final String getAppPackageVersion() {
        return this.f44250e;
    }

    @NotNull
    public final String getDeviceName() {
        return this.f44252g;
    }

    @NotNull
    public final String getEnvironment() {
        return this.f44248c;
    }

    @NotNull
    public final String getOsVersion() {
        return this.f44254i;
    }

    @NotNull
    public final String getPlatform() {
        return this.f44253h;
    }

    @NotNull
    public final String getProductIdentifier() {
        return this.f44246a;
    }

    @NotNull
    public final String getProductVersion() {
        return this.f44247b;
    }

    public int hashCode() {
        String str = this.f44246a;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f44247b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f44248c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f44249d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f44250e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f44251f;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f44252g;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f44253h;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f44254i;
        if (str9 != null) {
            i11 = str9.hashCode();
        }
        return hashCode8 + i11;
    }

    @NotNull
    public String toString() {
        return "RemoteProcessorMetadata(productIdentifier=" + this.f44246a + ", productVersion=" + this.f44247b + ", environment=" + this.f44248c + ", appPackageName=" + this.f44249d + ", appPackageVersion=" + this.f44250e + ", appInstallId=" + this.f44251f + ", deviceName=" + this.f44252g + ", platform=" + this.f44253h + ", osVersion=" + this.f44254i + ")";
    }
}
