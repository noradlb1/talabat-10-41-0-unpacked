package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ag extends ff {

    /* renamed from: d  reason: collision with root package name */
    public static Set f12982d;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashSet hashSet = new HashSet();
        f12982d = hashSet;
        hashSet.add("raw ");
        ((HashSet) f12982d).add("twos");
        ((HashSet) f12982d).add("sowt");
        ((HashSet) f12982d).add("fl32");
        ((HashSet) f12982d).add("fl64");
        ((HashSet) f12982d).add("in24");
        ((HashSet) f12982d).add("in32");
        ((HashSet) f12982d).add("lpcm");
        dk dkVar = dk.Left;
        at atVar = at.STEREO_LEFT;
        hashMap.put(dkVar, atVar);
        dk dkVar2 = dk.Right;
        at atVar2 = at.STEREO_RIGHT;
        hashMap.put(dkVar2, atVar2);
        hashMap.put(dk.HeadphonesLeft, atVar);
        hashMap.put(dk.HeadphonesRight, atVar2);
        dk dkVar3 = dk.LeftTotal;
        hashMap.put(dkVar3, atVar);
        dk dkVar4 = dk.RightTotal;
        hashMap.put(dkVar4, atVar2);
        dk dkVar5 = dk.LeftWide;
        hashMap.put(dkVar5, atVar);
        dk dkVar6 = dk.RightWide;
        hashMap.put(dkVar6, atVar2);
        hashMap2.put(dkVar, at.FRONT_LEFT);
        hashMap2.put(dkVar2, at.FRONT_RIGHT);
        hashMap2.put(dk.LeftCenter, at.FRONT_CENTER_LEFT);
        hashMap2.put(dk.RightCenter, at.FRONT_CENTER_RIGHT);
        hashMap2.put(dk.Center, at.CENTER);
        dk dkVar7 = dk.CenterSurround;
        at atVar3 = at.REAR_CENTER;
        hashMap2.put(dkVar7, atVar3);
        hashMap2.put(dk.CenterSurroundDirect, atVar3);
        dk dkVar8 = dk.LeftSurround;
        at atVar4 = at.REAR_LEFT;
        hashMap2.put(dkVar8, atVar4);
        hashMap2.put(dk.LeftSurroundDirect, atVar4);
        dk dkVar9 = dk.RightSurround;
        at atVar5 = at.REAR_RIGHT;
        hashMap2.put(dkVar9, atVar5);
        hashMap2.put(dk.RightSurroundDirect, atVar5);
        hashMap2.put(dk.RearSurroundLeft, at.SIDE_LEFT);
        hashMap2.put(dk.RearSurroundRight, at.SIDE_RIGHT);
        dk dkVar10 = dk.LFE2;
        at atVar6 = at.LFE;
        hashMap2.put(dkVar10, atVar6);
        hashMap2.put(dk.LFEScreen, atVar6);
        hashMap2.put(dkVar3, atVar);
        hashMap2.put(dkVar4, atVar2);
        hashMap2.put(dkVar5, atVar);
        hashMap2.put(dkVar6, atVar2);
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        byteBuffer.putInt(0);
        byteBuffer.putShort(0);
        byteBuffer.putShort(0);
        short s11 = (short) 0;
        byteBuffer.putShort(s11);
        byteBuffer.putShort(s11);
        byteBuffer.putInt((int) Math.round(((double) 0.0f) * 65536.0d));
        c(byteBuffer);
    }

    public void a(StringBuilder sb2) {
        sb2.append(this.f13001a.f13186a + ": {\n");
        sb2.append("entry: ");
        hc.a(this, sb2, "channelCount", "sampleSize", "sampleRat", "revision", "vendor", "compressionId", "pktSize", "samplesPerPkt", "bytesPerPkt", "bytesPerFrame", "bytesPerSample", "version", "lpcmFlags");
        sb2.append(",\nexts: [\n");
        b(sb2);
        sb2.append("\n]\n");
        sb2.append("}\n");
    }
}
