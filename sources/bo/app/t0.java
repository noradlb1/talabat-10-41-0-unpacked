package bo.app;

import bo.app.n0;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class t0 {

    /* renamed from: a  reason: collision with root package name */
    final String f39397a;

    /* renamed from: b  reason: collision with root package name */
    final long[] f39398b;

    /* renamed from: c  reason: collision with root package name */
    boolean f39399c;

    /* renamed from: d  reason: collision with root package name */
    n0.c f39400d;

    /* renamed from: e  reason: collision with root package name */
    long f39401e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39402f;

    /* renamed from: g  reason: collision with root package name */
    private final File f39403g;

    public t0(String str, int i11, File file) {
        this.f39397a = str;
        this.f39402f = i11;
        this.f39403g = file;
        this.f39398b = new long[i11];
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (long append : this.f39398b) {
            sb2.append(' ');
            sb2.append(append);
        }
        return sb2.toString();
    }

    public void b(String[] strArr) {
        if (strArr.length == this.f39402f) {
            int i11 = 0;
            while (i11 < strArr.length) {
                try {
                    this.f39398b[i11] = Long.parseLong(strArr[i11]);
                    i11++;
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
            return;
        }
        throw a(strArr);
    }

    public IOException a(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File a(int i11) {
        File file = this.f39403g;
        return new File(file, this.f39397a + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + i11);
    }

    public File b(int i11) {
        File file = this.f39403g;
        return new File(file, this.f39397a + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + i11 + ".tmp");
    }
}
