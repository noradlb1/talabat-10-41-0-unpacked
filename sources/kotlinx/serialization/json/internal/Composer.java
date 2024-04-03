package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000fH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\nR\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00118\u0006@DX\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", "", "", "indent", "unIndent", "nextItem", "space", "", "v", "print", "", "", "", "", "", "", "", "", "value", "printQuoted", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "<set-?>", "writingFirst", "Z", "getWritingFirst", "()Z", "a", "(Z)V", "<init>", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public class Composer {
    @NotNull
    @JvmField

    /* renamed from: sb  reason: collision with root package name */
    public final JsonStringBuilder f26442sb;
    private boolean writingFirst = true;

    public Composer(@NotNull JsonStringBuilder jsonStringBuilder) {
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        this.f26442sb = jsonStringBuilder;
    }

    public final void a(boolean z11) {
        this.writingFirst = z11;
    }

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public final void print(char c11) {
        this.f26442sb.append(c11);
    }

    public final void printQuoted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.f26442sb.appendQuoted(str);
    }

    public void space() {
    }

    public void unIndent() {
    }

    public final void print(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "v");
        this.f26442sb.append(str);
    }

    public void print(float f11) {
        this.f26442sb.append(String.valueOf(f11));
    }

    public void print(double d11) {
        this.f26442sb.append(String.valueOf(d11));
    }

    public void print(byte b11) {
        this.f26442sb.append((long) b11);
    }

    public void print(short s11) {
        this.f26442sb.append((long) s11);
    }

    public void print(int i11) {
        this.f26442sb.append((long) i11);
    }

    public void print(long j11) {
        this.f26442sb.append(j11);
    }

    public void print(boolean z11) {
        this.f26442sb.append(String.valueOf(z11));
    }
}
