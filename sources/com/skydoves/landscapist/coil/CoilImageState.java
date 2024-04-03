package com.skydoves.landscapist.coil;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState;", "", "()V", "Failure", "Loading", "None", "Success", "Lcom/skydoves/landscapist/coil/CoilImageState$None;", "Lcom/skydoves/landscapist/coil/CoilImageState$Loading;", "Lcom/skydoves/landscapist/coil/CoilImageState$Success;", "Lcom/skydoves/landscapist/coil/CoilImageState$Failure;", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CoilImageState {
    public static final int $stable = 0;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState$Failure;", "Lcom/skydoves/landscapist/coil/CoilImageState;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getErrorDrawable", "()Landroid/graphics/drawable/Drawable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Failure extends CoilImageState {
        public static final int $stable = 8;
        @Nullable
        private final Drawable errorDrawable;

        public Failure(@Nullable Drawable drawable) {
            super((DefaultConstructorMarker) null);
            this.errorDrawable = drawable;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, Drawable drawable, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                drawable = failure.errorDrawable;
            }
            return failure.copy(drawable);
        }

        @Nullable
        public final Drawable component1() {
            return this.errorDrawable;
        }

        @NotNull
        public final Failure copy(@Nullable Drawable drawable) {
            return new Failure(drawable);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.errorDrawable, (Object) ((Failure) obj).errorDrawable);
        }

        @Nullable
        public final Drawable getErrorDrawable() {
            return this.errorDrawable;
        }

        public int hashCode() {
            Drawable drawable = this.errorDrawable;
            if (drawable == null) {
                return 0;
            }
            return drawable.hashCode();
        }

        @NotNull
        public String toString() {
            Drawable drawable = this.errorDrawable;
            return "Failure(errorDrawable=" + drawable + ")";
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState$Loading;", "Lcom/skydoves/landscapist/coil/CoilImageState;", "progress", "", "(F)V", "getProgress", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Loading extends CoilImageState {
        public static final int $stable = 0;
        private final float progress;

        public Loading(float f11) {
            super((DefaultConstructorMarker) null);
            this.progress = f11;
        }

        public static /* synthetic */ Loading copy$default(Loading loading, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = loading.progress;
            }
            return loading.copy(f11);
        }

        public final float component1() {
            return this.progress;
        }

        @NotNull
        public final Loading copy(float f11) {
            return new Loading(f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.areEqual((Object) Float.valueOf(this.progress), (Object) Float.valueOf(((Loading) obj).progress));
        }

        public final float getProgress() {
            return this.progress;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.progress);
        }

        @NotNull
        public String toString() {
            float f11 = this.progress;
            return "Loading(progress=" + f11 + ")";
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState$None;", "Lcom/skydoves/landscapist/coil/CoilImageState;", "()V", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class None extends CoilImageState {
        public static final int $stable = 0;
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/skydoves/landscapist/coil/CoilImageState$Success;", "Lcom/skydoves/landscapist/coil/CoilImageState;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Success extends CoilImageState {
        public static final int $stable = 8;
        @Nullable
        private final Drawable drawable;

        public Success(@Nullable Drawable drawable2) {
            super((DefaultConstructorMarker) null);
            this.drawable = drawable2;
        }

        public static /* synthetic */ Success copy$default(Success success, Drawable drawable2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                drawable2 = success.drawable;
            }
            return success.copy(drawable2);
        }

        @Nullable
        public final Drawable component1() {
            return this.drawable;
        }

        @NotNull
        public final Success copy(@Nullable Drawable drawable2) {
            return new Success(drawable2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.drawable, (Object) ((Success) obj).drawable);
        }

        @Nullable
        public final Drawable getDrawable() {
            return this.drawable;
        }

        public int hashCode() {
            Drawable drawable2 = this.drawable;
            if (drawable2 == null) {
                return 0;
            }
            return drawable2.hashCode();
        }

        @NotNull
        public String toString() {
            Drawable drawable2 = this.drawable;
            return "Success(drawable=" + drawable2 + ")";
        }
    }

    private CoilImageState() {
    }

    public /* synthetic */ CoilImageState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
