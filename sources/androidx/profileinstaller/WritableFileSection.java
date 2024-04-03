package androidx.profileinstaller;

import androidx.annotation.NonNull;

class WritableFileSection {

    /* renamed from: a  reason: collision with root package name */
    public final FileSectionType f37402a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37403b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f37404c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37405d;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i11, @NonNull byte[] bArr, boolean z11) {
        this.f37402a = fileSectionType;
        this.f37403b = i11;
        this.f37404c = bArr;
        this.f37405d = z11;
    }
}
