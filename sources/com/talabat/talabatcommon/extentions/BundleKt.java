package com.talabat.talabatcommon.extentions;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\t\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\bø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\bø\u0001\u0000\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0004\u001a\u001d\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0012H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0013H\u0004\u001a\u0017\u0010\u000b\u001a\u00020\t*\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0004\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\bH\u0004¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\bH\u0004¢\u0006\u0002\u0010\u0018\u001a\"\u0010\u000b\u001a\u00020\t*\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\bH\u0004¢\u0006\u0002\u0010\u0019\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001aH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001bH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001cH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001dH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001eH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u001fH\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020 H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020!H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\"H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020#H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020$H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020%H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020&H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020'H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020(H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020)H\u0004\u001a\u0015\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0004\u001a(\u0010*\u001a\u0004\u0018\u0001H+\"\n\b\u0000\u0010+\u0018\u0001*\u00020\u000f*\u00020\u00012\u0006\u0010,\u001a\u00020\fH\b¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011H\u0002\u001a%\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0012H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013H\u0002\u001a\u001f\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0002\u001a*\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\bH\u0002¢\u0006\u0002\u0010/\u001a*\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\bH\u0002¢\u0006\u0002\u00100\u001a*\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\bH\u0002¢\u0006\u0002\u00101\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001aH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001bH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001cH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001dH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001eH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u001fH\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0017H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020 H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020!H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\"H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020#H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020$H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020%H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020&H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020'H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020(H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020)H\u0002\u001a\u001d\u0010.\u001a\u00020\u0004*\u00020\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002\u0002\u0007\n\u0005\b20\u0001¨\u00062"}, d2 = {"bundle", "Landroid/os/Bundle;", "initFun", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "bundleOf", "pairs", "", "Lcom/talabat/talabatcommon/extentions/BundlePair;", "([Lcom/talabat/talabatcommon/extentions/BundlePair;)Landroid/os/Bundle;", "bundleTo", "", "value", "Landroid/os/Binder;", "Landroid/os/Parcelable;", "Landroid/util/Size;", "Landroid/util/SizeF;", "Landroid/util/SparseArray;", "Ljava/io/Serializable;", "n", "Ljava/lang/Void;", "(Ljava/lang/String;[Landroid/os/Parcelable;)Lcom/talabat/talabatcommon/extentions/BundlePair;", "", "(Ljava/lang/String;[Ljava/lang/CharSequence;)Lcom/talabat/talabatcommon/extentions/BundlePair;", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/talabat/talabatcommon/extentions/BundlePair;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "getParcelableCompat", "T", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "set", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BundleKt {
    @NotNull
    public static final Bundle bundle(@NotNull Function1<? super Bundle, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "initFun");
        Bundle bundle = new Bundle();
        function1.invoke(bundle);
        return bundle;
    }

    @NotNull
    public static final Bundle bundleOf(@NotNull Function1<? super Bundle, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "initFun");
        Bundle bundle = new Bundle();
        function1.invoke(bundle);
        return bundle;
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$1(str, z11));
    }

    public static final /* synthetic */ <T extends Parcelable> T getParcelableCompat(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (Parcelable) bundle.getParcelable(str, Parcelable.class);
        }
        T parcelable = bundle.getParcelable(str);
        Intrinsics.reifiedOperationMarker(2, "T");
        return parcelable;
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putBoolean(str, z11);
    }

    @NotNull
    public static final Bundle bundleOf(@NotNull BundlePair... bundlePairArr) {
        Intrinsics.checkNotNullParameter(bundlePairArr, "pairs");
        Bundle bundle = new Bundle();
        for (BundlePair apply : bundlePairArr) {
            apply.apply(bundle);
        }
        return bundle;
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, byte b11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$2(str, b11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, byte b11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putByte(str, b11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, short s11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$3(str, s11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, short s11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putShort(str, s11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$4(str, i11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putInt(str, i11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$5(str, j11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, long j11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putLong(str, j11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$6(str, f11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, float f11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putFloat(str, f11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, double d11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$7(str, d11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, double d11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putDouble(str, d11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$8(str, c11));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, char c11) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putChar(str, c11);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "value");
        return new BundlePair(new BundleKt$bundleTo$9(str, charSequence));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(charSequence, "value");
        bundle.putCharSequence(str, charSequence);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new BundlePair(new BundleKt$bundleTo$10(str, str2));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        bundle.putString(str, str2);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(bundle, "value");
        return new BundlePair(new BundleKt$bundleTo$11(str, bundle));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Bundle bundle2) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bundle2, "value");
        bundle.putBundle(str, bundle2);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(parcelable, "value");
        return new BundlePair(new BundleKt$bundleTo$12(str, parcelable));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(parcelable, "value");
        bundle.putParcelable(str, parcelable);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Serializable serializable) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(serializable, "value");
        return new BundlePair(new BundleKt$bundleTo$13(str, serializable));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Serializable serializable) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(serializable, "value");
        bundle.putSerializable(str, serializable);
    }

    @RequiresApi(18)
    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Binder binder) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(binder, "value");
        return new BundlePair(new BundleKt$bundleTo$14(str, binder));
    }

    @RequiresApi(18)
    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Binder binder) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(binder, "value");
        bundle.putBinder(str, binder);
    }

    @RequiresApi(21)
    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(size, "value");
        return new BundlePair(new BundleKt$bundleTo$15(str, size));
    }

    @RequiresApi(21)
    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(size, "value");
        bundle.putSize(str, size);
    }

    @RequiresApi(21)
    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull SizeF sizeF) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(sizeF, "value");
        return new BundlePair(new BundleKt$bundleTo$16(str, sizeF));
    }

    @RequiresApi(21)
    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull SizeF sizeF) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(sizeF, "value");
        bundle.putSizeF(str, sizeF);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(zArr, "value");
        return new BundlePair(new BundleKt$bundleTo$17(str, zArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(zArr, "value");
        bundle.putBooleanArray(str, zArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "value");
        return new BundlePair(new BundleKt$bundleTo$18(str, bArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(bArr, "value");
        bundle.putByteArray(str, bArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "value");
        return new BundlePair(new BundleKt$bundleTo$19(str, sArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(sArr, "value");
        bundle.putShortArray(str, sArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "value");
        return new BundlePair(new BundleKt$bundleTo$20(str, iArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(iArr, "value");
        bundle.putIntArray(str, iArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "value");
        return new BundlePair(new BundleKt$bundleTo$21(str, jArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(jArr, "value");
        bundle.putLongArray(str, jArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "value");
        return new BundlePair(new BundleKt$bundleTo$22(str, fArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(fArr, "value");
        bundle.putFloatArray(str, fArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "value");
        return new BundlePair(new BundleKt$bundleTo$23(str, dArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(dArr, "value");
        bundle.putDoubleArray(str, dArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "value");
        return new BundlePair(new BundleKt$bundleTo$24(str, cArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cArr, "value");
        bundle.putCharArray(str, cArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull CharSequence[] charSequenceArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequenceArr, "value");
        return new BundlePair(new BundleKt$bundleTo$25(str, charSequenceArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull CharSequence[] charSequenceArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(charSequenceArr, "value");
        bundle.putCharSequenceArray(str, charSequenceArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "value");
        return new BundlePair(new BundleKt$bundleTo$26(str, strArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(strArr, "value");
        bundle.putStringArray(str, strArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull Parcelable[] parcelableArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(parcelableArr, "value");
        return new BundlePair(new BundleKt$bundleTo$27(str, parcelableArr));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull Parcelable[] parcelableArr) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(parcelableArr, "value");
        bundle.putParcelableArray(str, parcelableArr);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @NotNull SparseArray<? extends Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(sparseArray, "value");
        return new BundlePair(new BundleKt$bundleTo$28(str, sparseArray));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @NotNull SparseArray<? extends Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(sparseArray, "value");
        bundle.putSparseParcelableArray(str, sparseArray);
    }

    @NotNull
    public static final BundlePair bundleTo(@NotNull String str, @Nullable Void voidR) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BundlePair(new BundleKt$bundleTo$29(str));
    }

    public static final void set(@NotNull Bundle bundle, @NotNull String str, @Nullable Void voidR) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        bundle.putString(str, (String) null);
    }
}
