package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

class DexProfileData {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37382a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37383b;

    /* renamed from: c  reason: collision with root package name */
    public final long f37384c;

    /* renamed from: d  reason: collision with root package name */
    public long f37385d;

    /* renamed from: e  reason: collision with root package name */
    public int f37386e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37387f;

    /* renamed from: g  reason: collision with root package name */
    public final int f37388g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public int[] f37389h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TreeMap<Integer, Integer> f37390i;

    public DexProfileData(@NonNull String str, @NonNull String str2, long j11, long j12, int i11, int i12, int i13, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.f37382a = str;
        this.f37383b = str2;
        this.f37384c = j11;
        this.f37385d = j12;
        this.f37386e = i11;
        this.f37387f = i12;
        this.f37388g = i13;
        this.f37389h = iArr;
        this.f37390i = treeMap;
    }
}
