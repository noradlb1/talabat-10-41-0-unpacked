package com.talabat.talabatcore.platform;

import android.os.Parcel;
import android.os.Parcelable;
import com.apptimize.c;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u001a\b\u0004\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0004H\bø\u0001\u0000\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0005\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0005\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0005H\b\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0005\u001a&\u0010\u0012\u001a\u0004\u0018\u0001H\u0002\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0013*\u00020\u0005H\b¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0017H\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a)\u0010\u0019\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\b¢\u0006\u0002\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u001a\u0014\u0010 \u001a\u00020\u001e*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\r\u001a\u0015\u0010!\u001a\u00020\u001e*\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000fH\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u001a,\u0010#\u001a\u00020\u001e\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0013*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u0001H\u0002H\b¢\u0006\u0002\u0010$\u001a9\u0010%\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0002*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u0001H\u00022\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001e0\tH\bø\u0001\u0000¢\u0006\u0002\u0010'\u001a+\u0010(\u001a\u00020\u001e\"\b\b\u0000\u0010\u0002*\u00020\u001a*\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u0001H\u00022\u0006\u0010)\u001a\u00020*¢\u0006\u0002\u0010+\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"parcelableClassLoaderCreator", "Landroid/os/Parcelable$ClassLoaderCreator;", "T", "create", "Lkotlin/Function2;", "Landroid/os/Parcel;", "Ljava/lang/ClassLoader;", "parcelableCreator", "Landroid/os/Parcelable$Creator;", "Lkotlin/Function1;", "readBigDecimal", "Ljava/math/BigDecimal;", "readBigInteger", "Ljava/math/BigInteger;", "readBoolean", "", "readDate", "Ljava/util/Date;", "readEnum", "", "(Landroid/os/Parcel;)Ljava/lang/Enum;", "readNullable", "reader", "Lkotlin/Function0;", "(Landroid/os/Parcel;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "readTypedObjectCompat", "Landroid/os/Parcelable;", "c", "(Landroid/os/Parcel;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;", "writeBigDecimal", "", "value", "writeBigInteger", "writeBoolean", "writeDate", "writeEnum", "(Landroid/os/Parcel;Ljava/lang/Enum;)V", "writeNullable", "writer", "(Landroid/os/Parcel;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "writeTypedObjectCompat", "parcelableFlags", "", "(Landroid/os/Parcel;Landroid/os/Parcelable;I)V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatParcelableKt {
    public static final /* synthetic */ <T> Parcelable.ClassLoaderCreator<T> parcelableClassLoaderCreator(Function2<? super Parcel, ? super ClassLoader, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "create");
        Intrinsics.needClassReification();
        return new TalabatParcelableKt$parcelableClassLoaderCreator$1(function2);
    }

    public static final /* synthetic */ <T> Parcelable.Creator<T> parcelableCreator(Function1<? super Parcel, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "create");
        Intrinsics.needClassReification();
        return new TalabatParcelableKt$parcelableCreator$1(function1);
    }

    @Nullable
    public static final BigDecimal readBigDecimal(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (parcel.readInt() != 0) {
            return new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        return null;
    }

    @Nullable
    public static final BigInteger readBigInteger(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (parcel.readInt() != 0) {
            return new BigInteger(parcel.createByteArray());
        }
        return null;
    }

    public static final boolean readBoolean(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final Date readDate(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (parcel.readInt() != 0) {
            return new Date(parcel.readLong());
        }
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T>> T readEnum(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(5, "T");
        return new Enum[0][readInt];
    }

    @Nullable
    public static final <T> T readNullable(@NotNull Parcel parcel, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        Intrinsics.checkNotNullParameter(function0, "reader");
        if (parcel.readInt() != 0) {
            return function0.invoke();
        }
        return null;
    }

    @Nullable
    public static final <T extends Parcelable> T readTypedObjectCompat(@NotNull Parcel parcel, @NotNull Parcelable.Creator<T> creator) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        Intrinsics.checkNotNullParameter(creator, c.f41585a);
        if (parcel.readInt() != 0) {
            return (Parcelable) creator.createFromParcel(parcel);
        }
        return null;
    }

    public static final void writeBigDecimal(@NotNull Parcel parcel, @Nullable BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (bigDecimal != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            return;
        }
        parcel.writeInt(0);
    }

    public static final void writeBigInteger(@NotNull Parcel parcel, @Nullable BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (bigInteger != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(bigInteger.toByteArray());
            return;
        }
        parcel.writeInt(0);
    }

    public static final void writeBoolean(@NotNull Parcel parcel, boolean z11) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static final void writeDate(@NotNull Parcel parcel, @Nullable Date date) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (date != null) {
            parcel.writeInt(1);
            parcel.writeLong(date.getTime());
            return;
        }
        parcel.writeInt(0);
    }

    public static final <T extends Enum<T>> void writeEnum(@NotNull Parcel parcel, @Nullable T t11) {
        int i11;
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (t11 != null) {
            i11 = t11.ordinal();
        } else {
            i11 = -1;
        }
        parcel.writeInt(i11);
    }

    public static final <T> void writeNullable(@NotNull Parcel parcel, @Nullable T t11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        Intrinsics.checkNotNullParameter(function1, "writer");
        if (t11 != null) {
            parcel.writeInt(1);
            function1.invoke(t11);
            return;
        }
        parcel.writeInt(0);
    }

    public static final <T extends Parcelable> void writeTypedObjectCompat(@NotNull Parcel parcel, @Nullable T t11, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (t11 != null) {
            parcel.writeInt(1);
            t11.writeToParcel(parcel, i11);
            return;
        }
        parcel.writeInt(0);
    }
}
