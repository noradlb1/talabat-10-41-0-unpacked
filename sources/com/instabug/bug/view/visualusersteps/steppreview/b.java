package com.instabug.bug.view.visualusersteps.steppreview;

import android.os.Bundle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class b {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f45946d = new a((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f45947a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f45948b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f45949c;

    public b(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "screenShotUri");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        this.f45947a = str;
        this.f45948b = str2;
        this.f45949c = str3;
    }

    @JvmStatic
    @NotNull
    public static final b a(@NotNull Bundle bundle) {
        return f45946d.a(bundle);
    }

    @NotNull
    public final String a() {
        return this.f45949c;
    }

    @NotNull
    public final String b() {
        return this.f45948b;
    }

    @NotNull
    public final String c() {
        return this.f45947a;
    }

    @NotNull
    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putString("title", c());
        bundle.putString("screen_name", a());
        bundle.putString("uri", b());
        return bundle;
    }
}
