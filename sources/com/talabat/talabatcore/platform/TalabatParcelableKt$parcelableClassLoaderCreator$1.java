package com.talabat.talabatcore.platform;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"com/talabat/talabatcore/platform/TalabatParcelableKt$parcelableClassLoaderCreator$1", "Landroid/os/Parcelable$ClassLoaderCreator;", "createFromParcel", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Object;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class TalabatParcelableKt$parcelableClassLoaderCreator$1 implements Parcelable.ClassLoaderCreator<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2<Parcel, ClassLoader, T> f12029a;

    public TalabatParcelableKt$parcelableClassLoaderCreator$1(Function2<? super Parcel, ? super ClassLoader, ? extends T> function2) {
        this.f12029a = function2;
    }

    public T createFromParcel(@NotNull Parcel parcel, @NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        Intrinsics.checkNotNullParameter(classLoader, "loader");
        return this.f12029a.invoke(parcel, classLoader);
    }

    @NotNull
    public T[] newArray(int i11) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[i11];
    }

    @Nullable
    public T createFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        Intrinsics.reifiedOperationMarker(4, "T");
        ClassLoader classLoader = Object.class.getClassLoader();
        if (classLoader != null) {
            return createFromParcel(parcel, classLoader);
        }
        return null;
    }
}
