package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.GLES20;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public final class GlProgram {
    private static final int GL_SAMPLER_EXTERNAL_2D_Y2Y_EXT = 35815;
    private final Map<String, Attribute> attributeByName;
    private final Attribute[] attributes;
    private final int programId;
    private final Map<String, Uniform> uniformByName;
    private final Uniform[] uniforms;

    public static final class Attribute {
        @Nullable
        private Buffer buffer;
        private final int index;
        private final int location;

        /* renamed from: name  reason: collision with root package name */
        public final String f35065name;
        private int size;

        private Attribute(String str, int i11, int i12) {
            this.f35065name = str;
            this.index = i11;
            this.location = i12;
        }

        public static Attribute create(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr, 0);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveAttrib(i11, i12, i13, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.getCStringLength(bArr));
            return new Attribute(str, i12, GlProgram.getAttributeLocation(i11, str));
        }

        public void bind() throws GlUtil.GlException {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.location, this.size, 5126, false, 0, (Buffer) Assertions.checkNotNull(this.buffer, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.index);
            GlUtil.checkGlError();
        }

        public void setBuffer(float[] fArr, int i11) {
            this.buffer = GlUtil.createBuffer(fArr);
            this.size = i11;
        }
    }

    public static final class Uniform {
        private final float[] floatValue = new float[16];
        private int intValue;
        private final int location;

        /* renamed from: name  reason: collision with root package name */
        public final String f35066name;
        private int texIdValue;
        private int texUnitIndex;
        private final int type;

        private Uniform(String str, int i11, int i12) {
            this.f35066name = str;
            this.location = i11;
            this.type = i12;
        }

        public static Uniform create(int i11, int i12) {
            int i13 = i11;
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i14 = iArr[0];
            byte[] bArr = new byte[i14];
            GLES20.glGetActiveUniform(i11, i12, i14, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlProgram.getCStringLength(bArr));
            return new Uniform(str, GlProgram.getUniformLocation(i11, str), iArr2[0]);
        }

        public void bind() throws GlUtil.GlException {
            int i11;
            switch (this.type) {
                case 5124:
                    GLES20.glUniform1i(this.location, this.intValue);
                    return;
                case 5126:
                    GLES20.glUniform1fv(this.location, 1, this.floatValue, 0);
                    GlUtil.checkGlError();
                    return;
                case 35664:
                    GLES20.glUniform2fv(this.location, 1, this.floatValue, 0);
                    GlUtil.checkGlError();
                    return;
                case 35665:
                    GLES20.glUniform3fv(this.location, 1, this.floatValue, 0);
                    GlUtil.checkGlError();
                    return;
                case 35675:
                    GLES20.glUniformMatrix3fv(this.location, 1, false, this.floatValue, 0);
                    GlUtil.checkGlError();
                    return;
                case 35676:
                    GLES20.glUniformMatrix4fv(this.location, 1, false, this.floatValue, 0);
                    GlUtil.checkGlError();
                    return;
                case 35678:
                case GlProgram.GL_SAMPLER_EXTERNAL_2D_Y2Y_EXT /*35815*/:
                case 36198:
                    if (this.texIdValue != 0) {
                        GLES20.glActiveTexture(this.texUnitIndex + 33984);
                        GlUtil.checkGlError();
                        if (this.type == 35678) {
                            i11 = 3553;
                        } else {
                            i11 = 36197;
                        }
                        GlUtil.bindTexture(i11, this.texIdValue);
                        GLES20.glUniform1i(this.location, this.texUnitIndex);
                        GlUtil.checkGlError();
                        return;
                    }
                    throw new IllegalStateException("No call to setSamplerTexId() before bind.");
                default:
                    throw new IllegalStateException("Unexpected uniform type: " + this.type);
            }
        }

        public void setFloat(float f11) {
            this.floatValue[0] = f11;
        }

        public void setFloats(float[] fArr) {
            System.arraycopy(fArr, 0, this.floatValue, 0, fArr.length);
        }

        public void setInt(int i11) {
            this.intValue = i11;
        }

        public void setSamplerTexId(int i11, int i12) {
            this.texIdValue = i11;
            this.texUnitIndex = i12;
        }
    }

    public GlProgram(Context context, String str, String str2) throws IOException, GlUtil.GlException {
        this(loadAsset(context, str), loadAsset(context, str2));
    }

    private static void addShader(int i11, int i12, String str) throws GlUtil.GlException {
        int glCreateShader = GLES20.glCreateShader(i12);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z11 = true;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            z11 = false;
        }
        GlUtil.checkGlException(z11, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i11, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.checkGlError();
    }

    /* access modifiers changed from: private */
    public static int getAttributeLocation(int i11, String str) {
        return GLES20.glGetAttribLocation(i11, str);
    }

    /* access modifiers changed from: private */
    public static int getCStringLength(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] == 0) {
                return i11;
            }
        }
        return bArr.length;
    }

    /* access modifiers changed from: private */
    public static int getUniformLocation(int i11, String str) {
        return GLES20.glGetUniformLocation(i11, str);
    }

    public static String loadAsset(Context context, String str) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return Util.fromUtf8Bytes(Util.toByteArray(inputStream));
        } finally {
            Util.closeQuietly(inputStream);
        }
    }

    public void bindAttributesAndUniforms() throws GlUtil.GlException {
        for (Attribute bind : this.attributes) {
            bind.bind();
        }
        for (Uniform bind2 : this.uniforms) {
            bind2.bind();
        }
    }

    public void delete() throws GlUtil.GlException {
        GLES20.glDeleteProgram(this.programId);
        GlUtil.checkGlError();
    }

    public int getAttributeArrayLocationAndEnable(String str) throws GlUtil.GlException {
        int attributeLocation = getAttributeLocation(str);
        GLES20.glEnableVertexAttribArray(attributeLocation);
        GlUtil.checkGlError();
        return attributeLocation;
    }

    public void setBufferAttribute(String str, float[] fArr, int i11) {
        ((Attribute) Assertions.checkNotNull(this.attributeByName.get(str))).setBuffer(fArr, i11);
    }

    public void setFloatUniform(String str, float f11) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setFloat(f11);
    }

    public void setFloatsUniform(String str, float[] fArr) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setFloats(fArr);
    }

    public void setIntUniform(String str, int i11) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setInt(i11);
    }

    public void setSamplerTexIdUniform(String str, int i11, int i12) {
        ((Uniform) Assertions.checkNotNull(this.uniformByName.get(str))).setSamplerTexId(i11, i12);
    }

    public void use() throws GlUtil.GlException {
        GLES20.glUseProgram(this.programId);
        GlUtil.checkGlError();
    }

    public GlProgram(String str, String str2) throws GlUtil.GlException {
        int glCreateProgram = GLES20.glCreateProgram();
        this.programId = glCreateProgram;
        GlUtil.checkGlError();
        addShader(glCreateProgram, 35633, str);
        addShader(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        GlUtil.checkGlException(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.attributeByName = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.attributes = new Attribute[iArr2[0]];
        for (int i11 = 0; i11 < iArr2[0]; i11++) {
            Attribute create = Attribute.create(this.programId, i11);
            this.attributes[i11] = create;
            this.attributeByName.put(create.f35065name, create);
        }
        this.uniformByName = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.programId, 35718, iArr3, 0);
        this.uniforms = new Uniform[iArr3[0]];
        for (int i12 = 0; i12 < iArr3[0]; i12++) {
            Uniform create2 = Uniform.create(this.programId, i12);
            this.uniforms[i12] = create2;
            this.uniformByName.put(create2.f35066name, create2);
        }
        GlUtil.checkGlError();
    }

    private int getAttributeLocation(String str) {
        return getAttributeLocation(this.programId, str);
    }

    public int getUniformLocation(String str) {
        return getUniformLocation(this.programId, str);
    }
}
