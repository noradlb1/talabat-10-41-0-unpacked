package com.instabug.chat.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.instabug.library.OnSdkDismissCallback;
import com.instabug.library.internal.servicelocator.CoreServiceLocator;

public abstract class a {
    @Nullable
    public static SharedPreferences a(Context context) {
        return CoreServiceLocator.getInstabugSharedPreferences(context, "instabug_chat");
    }

    public static AttachmentTypesState a() {
        return b.e().a();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void a(@DrawableRes int i11) {
        c.a().b(i11);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void a(long j11) {
        c.a().c(j11);
    }

    public static void a(AttachmentTypesState attachmentTypesState) {
        b.e().b(attachmentTypesState);
    }

    public static void a(OnSdkDismissCallback onSdkDismissCallback) {
        b.e().a(onSdkDismissCallback);
    }

    public static void a(Runnable runnable) {
        b.e().c(runnable);
    }

    public static void a(String str) {
        b.e().d(str);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void a(boolean z11) {
        c.a().e(z11);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static long b() {
        return c.a().f();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void b(long j11) {
        c.a().g(j11);
    }

    public static void b(Context context) {
        c.d(a(context));
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void b(boolean z11) {
        c.a().h(z11);
    }

    @Nullable
    public static Runnable c() {
        return b.e().i();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void c(boolean z11) {
        c.a().j(z11);
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    @DrawableRes
    public static int d() {
        return c.a().i();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void d(boolean z11) {
        c.a().l(z11);
    }

    @Nullable
    public static OnSdkDismissCallback e() {
        return b.e().d();
    }

    public static void e(boolean z11) {
        b.e().a(z11);
    }

    @Nullable
    public static String f() {
        return b.e().j();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static long g() {
        return c.a().k();
    }

    public static boolean h() {
        AttachmentTypesState a11 = a();
        return a11.isScreenshotEnabled() || a11.isImageFromGalleryEnabled() || a11.isScreenRecordingEnabled();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static boolean i() {
        return c.a().m();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static boolean j() {
        return c.a().n();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static boolean k() {
        return c.a().o();
    }

    public static void l() {
        b.g();
        c.h();
    }

    public static boolean m() {
        return b.e().h();
    }
}
