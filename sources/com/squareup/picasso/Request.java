package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class Request {
    private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    public int f53458a;

    /* renamed from: b  reason: collision with root package name */
    public long f53459b;

    /* renamed from: c  reason: collision with root package name */
    public int f53460c;
    public final boolean centerCrop;
    public final int centerCropGravity;
    public final boolean centerInside;
    public final Bitmap.Config config;
    public final boolean hasRotationPivot;
    public final boolean onlyScaleDown;
    public final Picasso.Priority priority;
    public final boolean purgeable;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final String stableKey;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    public static final class Builder {
        private boolean centerCrop;
        private int centerCropGravity;
        private boolean centerInside;
        private Bitmap.Config config;
        private boolean hasRotationPivot;
        private boolean onlyScaleDown;
        private Picasso.Priority priority;
        private boolean purgeable;
        private int resourceId;
        private float rotationDegrees;
        private float rotationPivotX;
        private float rotationPivotY;
        private String stableKey;
        private int targetHeight;
        private int targetWidth;
        private List<Transformation> transformations;
        private Uri uri;

        public boolean a() {
            return (this.uri == null && this.resourceId == 0) ? false : true;
        }

        public boolean b() {
            return this.priority != null;
        }

        public Request build() {
            boolean z11 = this.centerInside;
            if (z11 && this.centerCrop) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.centerCrop && this.targetWidth == 0 && this.targetHeight == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (z11 && this.targetWidth == 0 && this.targetHeight == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.priority == null) {
                    this.priority = Picasso.Priority.NORMAL;
                }
                Request request = r2;
                Request request2 = new Request(this.uri, this.resourceId, this.stableKey, this.transformations, this.targetWidth, this.targetHeight, this.centerCrop, this.centerInside, this.centerCropGravity, this.onlyScaleDown, this.rotationDegrees, this.rotationPivotX, this.rotationPivotY, this.hasRotationPivot, this.purgeable, this.config, this.priority);
                return request;
            }
        }

        public boolean c() {
            return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
        }

        public Builder centerCrop() {
            return centerCrop(17);
        }

        public Builder centerInside() {
            if (!this.centerCrop) {
                this.centerInside = true;
                return this;
            }
            throw new IllegalStateException("Center inside can not be used after calling centerCrop");
        }

        public Builder clearCenterCrop() {
            this.centerCrop = false;
            this.centerCropGravity = 17;
            return this;
        }

        public Builder clearCenterInside() {
            this.centerInside = false;
            return this;
        }

        public Builder clearOnlyScaleDown() {
            this.onlyScaleDown = false;
            return this;
        }

        public Builder clearResize() {
            this.targetWidth = 0;
            this.targetHeight = 0;
            this.centerCrop = false;
            this.centerInside = false;
            return this;
        }

        public Builder clearRotation() {
            this.rotationDegrees = 0.0f;
            this.rotationPivotX = 0.0f;
            this.rotationPivotY = 0.0f;
            this.hasRotationPivot = false;
            return this;
        }

        public Builder config(@NonNull Bitmap.Config config2) {
            if (config2 != null) {
                this.config = config2;
                return this;
            }
            throw new IllegalArgumentException("config == null");
        }

        public Builder onlyScaleDown() {
            if (this.targetHeight == 0 && this.targetWidth == 0) {
                throw new IllegalStateException("onlyScaleDown can not be applied without resize");
            }
            this.onlyScaleDown = true;
            return this;
        }

        public Builder priority(@NonNull Picasso.Priority priority2) {
            if (priority2 == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.priority == null) {
                this.priority = priority2;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public Builder purgeable() {
            this.purgeable = true;
            return this;
        }

        public Builder resize(@Px int i11, @Px int i12) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i12 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i12 == 0 && i11 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.targetWidth = i11;
                this.targetHeight = i12;
                return this;
            }
        }

        public Builder rotate(float f11) {
            this.rotationDegrees = f11;
            return this;
        }

        public Builder setResourceId(@DrawableRes int i11) {
            if (i11 != 0) {
                this.resourceId = i11;
                this.uri = null;
                return this;
            }
            throw new IllegalArgumentException("Image resource ID may not be 0.");
        }

        public Builder setUri(@NonNull Uri uri2) {
            if (uri2 != null) {
                this.uri = uri2;
                this.resourceId = 0;
                return this;
            }
            throw new IllegalArgumentException("Image URI may not be null.");
        }

        public Builder stableKey(@Nullable String str) {
            this.stableKey = str;
            return this;
        }

        public Builder transform(@NonNull Transformation transformation) {
            if (transformation == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (transformation.key() != null) {
                if (this.transformations == null) {
                    this.transformations = new ArrayList(2);
                }
                this.transformations.add(transformation);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public Builder(@NonNull Uri uri2) {
            setUri(uri2);
        }

        public Builder centerCrop(int i11) {
            if (!this.centerInside) {
                this.centerCrop = true;
                this.centerCropGravity = i11;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        public Builder rotate(float f11, float f12, float f13) {
            this.rotationDegrees = f11;
            this.rotationPivotX = f12;
            this.rotationPivotY = f13;
            this.hasRotationPivot = true;
            return this;
        }

        public Builder(@DrawableRes int i11) {
            setResourceId(i11);
        }

        public Builder(Uri uri2, int i11, Bitmap.Config config2) {
            this.uri = uri2;
            this.resourceId = i11;
            this.config = config2;
        }

        public Builder transform(@NonNull List<? extends Transformation> list) {
            if (list != null) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    transform((Transformation) list.get(i11));
                }
                return this;
            }
            throw new IllegalArgumentException("Transformation list must not be null.");
        }

        private Builder(Request request) {
            this.uri = request.uri;
            this.resourceId = request.resourceId;
            this.stableKey = request.stableKey;
            this.targetWidth = request.targetWidth;
            this.targetHeight = request.targetHeight;
            this.centerCrop = request.centerCrop;
            this.centerInside = request.centerInside;
            this.centerCropGravity = request.centerCropGravity;
            this.rotationDegrees = request.rotationDegrees;
            this.rotationPivotX = request.rotationPivotX;
            this.rotationPivotY = request.rotationPivotY;
            this.hasRotationPivot = request.hasRotationPivot;
            this.purgeable = request.purgeable;
            this.onlyScaleDown = request.onlyScaleDown;
            if (request.transformations != null) {
                this.transformations = new ArrayList(request.transformations);
            }
            this.config = request.config;
            this.priority = request.priority;
        }
    }

    public String a() {
        Uri uri2 = this.uri;
        if (uri2 != null) {
            return String.valueOf(uri2.getPath());
        }
        return Integer.toHexString(this.resourceId);
    }

    public boolean b() {
        return this.transformations != null;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public String c() {
        long nanoTime = System.nanoTime() - this.f53459b;
        if (nanoTime > TOO_LONG_LOG) {
            return f() + SignatureVisitor.EXTENDS + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
        }
        return f() + SignatureVisitor.EXTENDS + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    public boolean d() {
        return hasSize() || this.rotationDegrees != 0.0f;
    }

    public boolean e() {
        return d() || b();
    }

    public String f() {
        return "[R" + this.f53458a + AbstractJsonLexerKt.END_LIST;
    }

    public boolean hasSize() {
        return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Request{");
        int i11 = this.resourceId;
        if (i11 > 0) {
            sb2.append(i11);
        } else {
            sb2.append(this.uri);
        }
        List<Transformation> list = this.transformations;
        if (list != null && !list.isEmpty()) {
            for (Transformation key : this.transformations) {
                sb2.append(' ');
                sb2.append(key.key());
            }
        }
        if (this.stableKey != null) {
            sb2.append(" stableKey(");
            sb2.append(this.stableKey);
            sb2.append(')');
        }
        if (this.targetWidth > 0) {
            sb2.append(" resize(");
            sb2.append(this.targetWidth);
            sb2.append(AbstractJsonLexerKt.COMMA);
            sb2.append(this.targetHeight);
            sb2.append(')');
        }
        if (this.centerCrop) {
            sb2.append(" centerCrop");
        }
        if (this.centerInside) {
            sb2.append(" centerInside");
        }
        if (this.rotationDegrees != 0.0f) {
            sb2.append(" rotation(");
            sb2.append(this.rotationDegrees);
            if (this.hasRotationPivot) {
                sb2.append(" @ ");
                sb2.append(this.rotationPivotX);
                sb2.append(AbstractJsonLexerKt.COMMA);
                sb2.append(this.rotationPivotY);
            }
            sb2.append(')');
        }
        if (this.purgeable) {
            sb2.append(" purgeable");
        }
        if (this.config != null) {
            sb2.append(' ');
            sb2.append(this.config);
        }
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }

    private Request(Uri uri2, int i11, String str, List<Transformation> list, int i12, int i13, boolean z11, boolean z12, int i14, boolean z13, float f11, float f12, float f13, boolean z14, boolean z15, Bitmap.Config config2, Picasso.Priority priority2) {
        this.uri = uri2;
        this.resourceId = i11;
        this.stableKey = str;
        if (list == null) {
            this.transformations = null;
        } else {
            this.transformations = Collections.unmodifiableList(list);
        }
        this.targetWidth = i12;
        this.targetHeight = i13;
        this.centerCrop = z11;
        this.centerInside = z12;
        this.centerCropGravity = i14;
        this.onlyScaleDown = z13;
        this.rotationDegrees = f11;
        this.rotationPivotX = f12;
        this.rotationPivotY = f13;
        this.hasRotationPivot = z14;
        this.purgeable = z15;
        this.config = config2;
        this.priority = priority2;
    }
}
