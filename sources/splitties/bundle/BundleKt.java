package splitties.bundle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import splitties.exceptions.ExceptionsKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u00030\u000bj\u0006\u0012\u0002\b\u0003`\fH\u0002\u001a \u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002¨\u0006\u000f"}, d2 = {"put", "", "Landroid/os/Bundle;", "key", "", "value", "", "putArray", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/Object;)V", "putArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "putSparseArrayOfParcelable", "Landroid/util/SparseArray;", "splitties-bundle_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BundleKt {
    public static final void put(@NotNull Bundle bundle, @NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof short[]) {
            bundle.putShortArray(str, (short[]) obj);
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof float[]) {
            bundle.putFloatArray(str, (float[]) obj);
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof char[]) {
            bundle.putCharArray(str, (char[]) obj);
        } else if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Bundle) {
            bundle.putBundle(str, (Bundle) obj);
        } else if (obj instanceof Object[]) {
            putArray(bundle, str, (Object[]) obj);
        } else if (obj instanceof ArrayList) {
            putArrayList(bundle, str, (ArrayList) obj);
        } else if (obj instanceof SparseArray) {
            putSparseArrayOfParcelable(bundle, str, (SparseArray) obj);
        } else if (obj instanceof Binder) {
            bundle.putBinder(str, (IBinder) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj == null) {
            bundle.putString(str, (String) obj);
        } else {
            ExceptionsKt.unsupported("Type " + obj.getClass().getCanonicalName() + " is not supported");
            throw new KotlinNothingValueException();
        }
    }

    private static final void putArray(Bundle bundle, String str, Object[] objArr) {
        if (objArr instanceof CharSequence[]) {
            bundle.putCharSequenceArray(str, (CharSequence[]) objArr);
        } else if (objArr instanceof String[]) {
            bundle.putStringArray(str, (String[]) objArr);
        } else if (objArr instanceof Parcelable[]) {
            bundle.putParcelableArray(str, (Parcelable[]) objArr);
        } else {
            ExceptionsKt.unsupported("Array type " + objArr.getClass().getCanonicalName() + " is not supported");
            throw new KotlinNothingValueException();
        }
    }

    private static final void putArrayList(Bundle bundle, String str, ArrayList<?> arrayList) {
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(arrayList);
        if (firstOrNull instanceof CharSequence) {
            bundle.putCharSequenceArrayList(str, arrayList);
        } else if (firstOrNull instanceof String) {
            bundle.putStringArrayList(str, arrayList);
        } else if (firstOrNull instanceof Parcelable) {
            bundle.putParcelableArrayList(str, arrayList);
        } else {
            boolean z11 = true;
            if (!(firstOrNull instanceof Integer) && firstOrNull != null) {
                z11 = false;
            }
            if (z11) {
                bundle.putIntegerArrayList(str, arrayList);
                return;
            }
            ExceptionsKt.unsupported("Type " + CollectionsKt___CollectionsKt.first(arrayList).getClass().getCanonicalName() + " in ArrayList is not supported");
            throw new KotlinNothingValueException();
        }
    }

    private static final void putSparseArrayOfParcelable(Bundle bundle, String str, SparseArray<?> sparseArray) {
        bundle.putSparseParcelableArray(str, sparseArray);
    }
}
