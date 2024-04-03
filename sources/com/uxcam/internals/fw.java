package com.uxcam.internals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.newrelic.agent.android.harvest.AgentHealth;
import mz.r;

public class fw {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f13422a = new int[1];

    /* renamed from: b  reason: collision with root package name */
    public int f13423b = -1;

    public fw() {
        int a11 = cn.a(35633, "uniform mat4 uScreen;\nattribute vec2 aPosition;\nattribute vec2 aTexPos;\nvarying vec2 vTexPos;\nvoid main() {\n  vTexPos = aTexPos;\n  gl_Position = uScreen * vec4(aPosition.xy, 0.0, 1.0);\n}");
        int a12 = cn.a(35632, "precision mediump float;\nuniform sampler2D uTexture;\nvarying vec2 vTexPos;\nvoid main(void)\n{\n  gl_FragColor = texture2D(uTexture, vTexPos);\n}");
        int glCreateProgram = GLES20.glCreateProgram();
        this.f13423b = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, a11);
        GLES20.glAttachShader(this.f13423b, a12);
        GLES20.glLinkProgram(this.f13423b);
    }

    public void a() {
        GLES20.glUseProgram(this.f13423b);
        GLES20.glGenTextures(1, this.f13422a, 0);
        int i11 = this.f13422a[0];
        if (i11 != 0) {
            GLES20.glBindTexture(3553, i11);
            GLES20.glTexParameteri(3553, 10241, 9728);
            GLES20.glTexParameteri(3553, 10240, 9728);
            try {
                fm.a(true, (eh) new r());
            } catch (Exception e11) {
                fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
                a11.a("site_of_error", "ScreenshotTexture::onSurfaceCreated()");
                a11.a("reason", e11.getMessage());
                a11.a(2);
            }
        } else {
            throw new RuntimeException("Error loading texture");
        }
    }

    public static void a(Bitmap bitmap) {
        al a11 = al.a();
        Bitmap remove = a11.f12999a.isEmpty() ? null : a11.f12999a.remove();
        if (remove == null) {
            remove = al.a().f13000b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(remove.getWidth(), ia.a(remove.getHeight()), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(remove, 0.0f, 0.0f, (Paint) null);
        GLUtils.texImage2D(3553, 0, createBitmap, 0);
    }
}
