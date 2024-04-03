package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.GlProgram;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {
    private static final String FRAGMENT_SHADER = "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n";
    private static final String TAG = "ProjectionRenderer";
    private static final float[] TEX_MATRIX_BOTTOM = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_LEFT = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_RIGHT = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    private static final float[] TEX_MATRIX_TOP = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    private static final float[] TEX_MATRIX_WHOLE = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    private static final String VERTEX_SHADER = "uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n";
    @Nullable
    private MeshData leftMeshData;
    private int mvpMatrixHandle;
    private int positionHandle;
    private GlProgram program;
    @Nullable
    private MeshData rightMeshData;
    private int stereoMode;
    private int texCoordsHandle;
    private int textureHandle;
    private int uTexMatrixHandle;

    public static class MeshData {
        /* access modifiers changed from: private */
        public final int drawMode;
        /* access modifiers changed from: private */
        public final FloatBuffer textureBuffer;
        /* access modifiers changed from: private */
        public final FloatBuffer vertexBuffer;
        /* access modifiers changed from: private */
        public final int vertexCount;

        public MeshData(Projection.SubMesh subMesh) {
            this.vertexCount = subMesh.getVertexCount();
            this.vertexBuffer = GlUtil.createBuffer(subMesh.vertices);
            this.textureBuffer = GlUtil.createBuffer(subMesh.textureCoords);
            int i11 = subMesh.mode;
            if (i11 == 1) {
                this.drawMode = 5;
            } else if (i11 != 2) {
                this.drawMode = 4;
            } else {
                this.drawMode = 6;
            }
        }
    }

    public static boolean isSupported(Projection projection) {
        Projection.Mesh mesh = projection.leftMesh;
        Projection.Mesh mesh2 = projection.rightMesh;
        if (mesh.getSubMeshCount() == 1 && mesh.getSubMesh(0).textureId == 0 && mesh2.getSubMeshCount() == 1 && mesh2.getSubMesh(0).textureId == 0) {
            return true;
        }
        return false;
    }

    public void draw(int i11, float[] fArr, boolean z11) {
        MeshData meshData;
        float[] fArr2;
        if (z11) {
            meshData = this.rightMeshData;
        } else {
            meshData = this.leftMeshData;
        }
        if (meshData != null) {
            int i12 = this.stereoMode;
            if (i12 == 1) {
                if (z11) {
                    fArr2 = TEX_MATRIX_BOTTOM;
                } else {
                    fArr2 = TEX_MATRIX_TOP;
                }
            } else if (i12 != 2) {
                fArr2 = TEX_MATRIX_WHOLE;
            } else if (z11) {
                fArr2 = TEX_MATRIX_RIGHT;
            } else {
                fArr2 = TEX_MATRIX_LEFT;
            }
            GLES20.glUniformMatrix3fv(this.uTexMatrixHandle, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(this.mvpMatrixHandle, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i11);
            GLES20.glUniform1i(this.textureHandle, 0);
            try {
                GlUtil.checkGlError();
            } catch (GlUtil.GlException e11) {
                Log.e(TAG, "Failed to bind uniforms", e11);
            }
            GLES20.glVertexAttribPointer(this.positionHandle, 3, 5126, false, 12, meshData.vertexBuffer);
            try {
                GlUtil.checkGlError();
            } catch (GlUtil.GlException e12) {
                Log.e(TAG, "Failed to load position data", e12);
            }
            GLES20.glVertexAttribPointer(this.texCoordsHandle, 2, 5126, false, 8, meshData.textureBuffer);
            try {
                GlUtil.checkGlError();
            } catch (GlUtil.GlException e13) {
                Log.e(TAG, "Failed to load texture data", e13);
            }
            GLES20.glDrawArrays(meshData.drawMode, 0, meshData.vertexCount);
            try {
                GlUtil.checkGlError();
            } catch (GlUtil.GlException e14) {
                Log.e(TAG, "Failed to render", e14);
            }
        }
    }

    public void init() {
        try {
            GlProgram glProgram = new GlProgram(VERTEX_SHADER, FRAGMENT_SHADER);
            this.program = glProgram;
            this.mvpMatrixHandle = glProgram.getUniformLocation("uMvpMatrix");
            this.uTexMatrixHandle = this.program.getUniformLocation("uTexMatrix");
            this.positionHandle = this.program.getAttributeArrayLocationAndEnable("aPosition");
            this.texCoordsHandle = this.program.getAttributeArrayLocationAndEnable("aTexCoords");
            this.textureHandle = this.program.getUniformLocation("uTexture");
        } catch (GlUtil.GlException e11) {
            Log.e(TAG, "Failed to initialize the program", e11);
        }
    }

    public void setProjection(Projection projection) {
        if (isSupported(projection)) {
            this.stereoMode = projection.stereoMode;
            MeshData meshData = new MeshData(projection.leftMesh.getSubMesh(0));
            this.leftMeshData = meshData;
            if (!projection.singleMesh) {
                meshData = new MeshData(projection.rightMesh.getSubMesh(0));
            }
            this.rightMeshData = meshData;
        }
    }

    public void shutdown() {
        GlProgram glProgram = this.program;
        if (glProgram != null) {
            try {
                glProgram.delete();
            } catch (GlUtil.GlException e11) {
                Log.e(TAG, "Failed to delete the shader program", e11);
            }
        }
    }
}
