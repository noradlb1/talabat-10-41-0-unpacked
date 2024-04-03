package com.talabat.talabatcore.platform;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/talabat/talabatcore/platform/TalabatParcelableKt$parcelableCreator$1", "Landroid/os/Parcelable$Creator;", "createFromParcel", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class TalabatParcelableKt$parcelableCreator$1 implements Parcelable.Creator<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<Parcel, T> f12030a;

    public TalabatParcelableKt$parcelableCreator$1(Function1<? super Parcel, ? extends T> function1) {
        this.f12030a = function1;
    }

    public T createFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "source");
        return this.f12030a.invoke(parcel);
    }

    @NotNull
    public T[] newArray(int i11) {
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[i11];
    }
}
