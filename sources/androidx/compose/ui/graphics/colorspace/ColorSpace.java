package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b&\u0018\u0000 )2\u00020\u0001:\u0001)B\u001a\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006B\"\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0013\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH&J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\bH&J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\bH&J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\u001e\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH&R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "", "name", "", "model", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "id", "", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "componentCount", "getComponentCount", "()I", "getId$ui_graphics_release", "isSrgb", "", "()Z", "isWideGamut", "getModel-xdoWZVw", "()J", "J", "getName", "()Ljava/lang/String;", "equals", "other", "fromXyz", "", "x", "", "y", "z", "v", "getMaxValue", "component", "getMinValue", "hashCode", "toString", "toXyz", "r", "g", "b", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ColorSpace {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MaxId = 63;
    public static final int MinId = -1;

    /* renamed from: id  reason: collision with root package name */
    private final int f9637id;
    private final long model;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f9638name;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace$Companion;", "", "()V", "MaxId", "", "MinId", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ColorSpace(String str, long j11, int i11) {
        this.f9638name = str;
        this.model = j11;
        this.f9637id = i11;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        } else if (i11 < -1 || i11 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public /* synthetic */ ColorSpace(String str, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11, i11);
    }

    public /* synthetic */ ColorSpace(String str, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(getClass()), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.f9637id == colorSpace.f9637id && Intrinsics.areEqual((Object) this.f9638name, (Object) colorSpace.f9638name)) {
            return ColorModel.m3308equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    @NotNull
    public final float[] fromXyz(float f11, float f12, float f13) {
        float[] fArr = new float[ColorModel.m3309getComponentCountimpl(this.model)];
        fArr[0] = f11;
        fArr[1] = f12;
        fArr[2] = f13;
        return fromXyz(fArr);
    }

    @NotNull
    public abstract float[] fromXyz(@NotNull float[] fArr);

    public final int getComponentCount() {
        return ColorModel.m3309getComponentCountimpl(this.model);
    }

    public final int getId$ui_graphics_release() {
        return this.f9637id;
    }

    public abstract float getMaxValue(int i11);

    public abstract float getMinValue(int i11);

    /* renamed from: getModel-xdoWZVw  reason: not valid java name */
    public final long m3317getModelxdoWZVw() {
        return this.model;
    }

    @NotNull
    public final String getName() {
        return this.f9638name;
    }

    public int hashCode() {
        return (((this.f9638name.hashCode() * 31) + ColorModel.m3310hashCodeimpl(this.model)) * 31) + this.f9637id;
    }

    public boolean isSrgb() {
        return false;
    }

    public abstract boolean isWideGamut();

    @NotNull
    public String toString() {
        return this.f9638name + " (id=" + this.f9637id + ", model=" + ColorModel.m3311toStringimpl(this.model) + ')';
    }

    @NotNull
    public final float[] toXyz(float f11, float f12, float f13) {
        return toXyz(new float[]{f11, f12, f13});
    }

    @NotNull
    public abstract float[] toXyz(@NotNull float[] fArr);

    private ColorSpace(String str, long j11) {
        this(str, j11, -1, (DefaultConstructorMarker) null);
    }
}
