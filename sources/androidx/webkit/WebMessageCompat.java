package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public class WebMessageCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TYPE_ARRAY_BUFFER = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TYPE_STRING = 0;
    @Nullable
    private final byte[] mArrayBuffer;
    @Nullable
    private final WebMessagePortCompat[] mPorts;
    @Nullable
    private final String mString;
    private final int mType;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public WebMessageCompat(@Nullable String str) {
        this(str, (WebMessagePortCompat[]) null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public byte[] getArrayBuffer() {
        return this.mArrayBuffer;
    }

    @Nullable
    public String getData() {
        return this.mString;
    }

    @Nullable
    public WebMessagePortCompat[] getPorts() {
        return this.mPorts;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getType() {
        return this.mType;
    }

    public WebMessageCompat(@Nullable String str, @Nullable WebMessagePortCompat[] webMessagePortCompatArr) {
        this.mString = str;
        this.mArrayBuffer = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WebMessageCompat(@NonNull byte[] bArr) {
        this(bArr, (WebMessagePortCompat[]) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WebMessageCompat(@NonNull byte[] bArr, @Nullable WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.mArrayBuffer = bArr;
        this.mString = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 1;
    }
}
