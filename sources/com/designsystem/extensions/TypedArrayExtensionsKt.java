package com.designsystem.extensions;

import android.content.res.TypedArray;
import androidx.annotation.AnyRes;
import androidx.annotation.StyleableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a4\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\f\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"getEnum", "T", "", "Landroid/content/res/TypedArray;", "index", "", "(Landroid/content/res/TypedArray;I)Ljava/lang/Enum;", "default", "(Landroid/content/res/TypedArray;ILjava/lang/Enum;)Ljava/lang/Enum;", "getFloatOrNull", "", "(Landroid/content/res/TypedArray;I)Ljava/lang/Float;", "getIntOrNull", "(Landroid/content/res/TypedArray;I)Ljava/lang/Integer;", "getResourceIdOrNull", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TypedArrayExtensionsKt {
    public static final /* synthetic */ <T extends Enum<T>> T getEnum(TypedArray typedArray, int i11, T t11) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        Intrinsics.checkNotNullParameter(t11, "default");
        int i12 = typedArray.getInt(i11, -1);
        if (i12 < 0) {
            return t11;
        }
        Intrinsics.reifiedOperationMarker(5, "T");
        return new Enum[0][i12];
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull TypedArray typedArray, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        float f11 = typedArray.getFloat(i11, -1.0f);
        if (f11 == -1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        return Float.valueOf(f11);
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull TypedArray typedArray, int i11) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        if (typedArray.hasValue(i11)) {
            return Integer.valueOf(typedArray.getInt(i11, 0));
        }
        return null;
    }

    @Nullable
    @AnyRes
    public static final Integer getResourceIdOrNull(@NotNull TypedArray typedArray, @StyleableRes int i11) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        int resourceId = typedArray.getResourceId(i11, -1);
        if (resourceId == -1) {
            return null;
        }
        return Integer.valueOf(resourceId);
    }

    public static final /* synthetic */ <T extends Enum<T>> T getEnum(TypedArray typedArray, int i11) {
        Intrinsics.checkNotNullParameter(typedArray, "<this>");
        int i12 = typedArray.getInt(i11, -1);
        if (i12 < 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(5, "T");
        return new Enum[0][i12];
    }
}
