package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public SubMesh getSubMesh(int i11) {
            return this.subMeshes[i11];
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i11, float[] fArr, float[] fArr2, int i12) {
            boolean z11;
            this.textureId = i11;
            if (((long) fArr.length) * 2 == ((long) fArr2.length) * 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i12;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public Projection(Mesh mesh, int i11) {
        this(mesh, mesh, i11);
    }

    public static Projection createEquirectangular(int i11) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i11);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i11) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i11;
        this.singleMesh = mesh == mesh2;
    }

    public static Projection createEquirectangular(float f11, int i11, int i12, float f12, float f13, int i13) {
        int i14;
        float f14;
        int i15;
        float[] fArr;
        int i16;
        int i17;
        int i18;
        float f15 = f11;
        int i19 = i11;
        int i21 = i12;
        float f16 = f12;
        float f17 = f13;
        Assertions.checkArgument(f15 > 0.0f);
        Assertions.checkArgument(i19 >= 1);
        Assertions.checkArgument(i21 >= 1);
        Assertions.checkArgument(f16 > 0.0f && f16 <= 180.0f);
        Assertions.checkArgument(f17 > 0.0f && f17 <= 360.0f);
        float radians = (float) Math.toRadians((double) f16);
        float radians2 = (float) Math.toRadians((double) f17);
        float f18 = radians / ((float) i19);
        float f19 = radians2 / ((float) i21);
        int i22 = i21 + 1;
        int i23 = ((i22 * 2) + 2) * i19;
        float[] fArr2 = new float[(i23 * 3)];
        float[] fArr3 = new float[(i23 * 2)];
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i24 < i19) {
            float f21 = radians / 2.0f;
            float f22 = (((float) i24) * f18) - f21;
            int i27 = i24 + 1;
            float f23 = (((float) i27) * f18) - f21;
            int i28 = 0;
            while (i28 < i22) {
                float f24 = f22;
                int i29 = i27;
                int i31 = 0;
                int i32 = 2;
                while (i31 < i32) {
                    if (i31 == 0) {
                        f14 = f24;
                        i14 = i22;
                    } else {
                        i14 = i22;
                        f14 = f23;
                    }
                    float f25 = ((float) i28) * f19;
                    float f26 = f19;
                    int i33 = i25 + 1;
                    int i34 = i28;
                    double d11 = (double) f15;
                    float f27 = f18;
                    double d12 = (double) ((f25 + 3.1415927f) - (radians2 / 2.0f));
                    int i35 = i31;
                    double d13 = (double) f14;
                    float[] fArr4 = fArr3;
                    float f28 = f23;
                    fArr2[i25] = -((float) (Math.sin(d12) * d11 * Math.cos(d13)));
                    int i36 = i33 + 1;
                    int i37 = i24;
                    fArr2[i33] = (float) (d11 * Math.sin(d13));
                    int i38 = i36 + 1;
                    fArr2[i36] = (float) (d11 * Math.cos(d12) * Math.cos(d13));
                    int i39 = i26 + 1;
                    fArr4[i26] = f25 / radians2;
                    int i41 = i39 + 1;
                    fArr4[i39] = (((float) (i37 + i35)) * f27) / radians;
                    if (i34 == 0 && i35 == 0) {
                        i18 = i12;
                        i17 = i34;
                        i16 = i35;
                    } else {
                        i18 = i12;
                        i17 = i34;
                        i16 = i35;
                        if (!(i17 == i18 && i16 == 1)) {
                            fArr = fArr4;
                            i15 = 2;
                            i26 = i41;
                            i25 = i38;
                            i31 = i16 + 1;
                            i21 = i18;
                            i28 = i17;
                            fArr3 = fArr;
                            i32 = i15;
                            i24 = i37;
                            i22 = i14;
                            f19 = f26;
                            f18 = f27;
                            f23 = f28;
                        }
                    }
                    System.arraycopy(fArr2, i38 - 3, fArr2, i38, 3);
                    i38 += 3;
                    fArr = fArr4;
                    i15 = 2;
                    System.arraycopy(fArr, i41 - 2, fArr, i41, 2);
                    i41 += 2;
                    i26 = i41;
                    i25 = i38;
                    i31 = i16 + 1;
                    i21 = i18;
                    i28 = i17;
                    fArr3 = fArr;
                    i32 = i15;
                    i24 = i37;
                    i22 = i14;
                    f19 = f26;
                    f18 = f27;
                    f23 = f28;
                }
                float f29 = f18;
                float f31 = f19;
                int i42 = i22;
                float f32 = f23;
                int i43 = i24;
                int i44 = i28;
                int i45 = i21;
                int i46 = i32;
                float[] fArr5 = fArr3;
                int i47 = i44 + 1;
                f22 = f24;
                i27 = i29;
                i22 = i42;
                f18 = f29;
                f23 = f32;
                int i48 = i47;
                i21 = i45;
                i28 = i48;
            }
            i19 = i11;
            i24 = i27;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i13);
    }
}
