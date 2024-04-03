package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class gy extends ff {

    public static class aa extends an {
        public aa() {
            new HashMap();
        }
    }

    static {
        new aa();
    }

    public gy() {
        super(new da("tmcd"));
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) -49);
    }

    public void a(StringBuilder sb2) {
        sb2.append(this.f13001a.f13186a + ": {\n");
        sb2.append("entry: ");
        hc.a(this, sb2, "flags", "timescale", "frameDuration", "numFrames");
        sb2.append(",\nexts: [\n");
        b(sb2);
        sb2.append("\n]\n");
        sb2.append("}\n");
    }
}
