package com.uxcam.internals;

import com.visa.checkout.Profile;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.apache.commons.compress.archivers.tar.TarConstants;

public class fe extends ed {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f13308c = 0;

    public static class aa extends an {
        public aa() {
            HashMap hashMap = new HashMap();
            Class<in> cls = in.class;
            hashMap.put("ap4h", cls);
            hashMap.put("apch", cls);
            hashMap.put("apcn", cls);
            hashMap.put("apcs", cls);
            hashMap.put("apco", cls);
            hashMap.put("avc1", cls);
            hashMap.put("cvid", cls);
            hashMap.put("jpeg", cls);
            hashMap.put("smc ", cls);
            hashMap.put("rle ", cls);
            hashMap.put("rpza", cls);
            hashMap.put("kpcd", cls);
            hashMap.put("png ", cls);
            hashMap.put("mjpa", cls);
            hashMap.put("mjpb", cls);
            hashMap.put("SVQ1", cls);
            hashMap.put("SVQ3", cls);
            hashMap.put("mp4v", cls);
            hashMap.put("dvc ", cls);
            hashMap.put("dvcp", cls);
            hashMap.put("gif ", cls);
            hashMap.put("h263", cls);
            hashMap.put("tiff", cls);
            hashMap.put("raw ", cls);
            hashMap.put("2vuY", cls);
            hashMap.put("yuv2", cls);
            hashMap.put("v308", cls);
            hashMap.put("v408", cls);
            hashMap.put("v216", cls);
            hashMap.put("v410", cls);
            hashMap.put("v210", cls);
            hashMap.put("m2v1", cls);
            hashMap.put("m1v1", cls);
            hashMap.put("xd5b", cls);
            hashMap.put("dv5n", cls);
            hashMap.put("jp2h", cls);
            hashMap.put("mjp2", cls);
            Class<ag> cls2 = ag.class;
            hashMap.put("ac-3", cls2);
            hashMap.put("cac3", cls2);
            hashMap.put("ima4", cls2);
            hashMap.put("aac ", cls2);
            hashMap.put("celp", cls2);
            hashMap.put("hvxc", cls2);
            hashMap.put("twvq", cls2);
            hashMap.put(".mp1", cls2);
            hashMap.put(".mp2", cls2);
            hashMap.put("midi", cls2);
            hashMap.put("apvs", cls2);
            hashMap.put("alac", cls2);
            hashMap.put("aach", cls2);
            hashMap.put("aacl", cls2);
            hashMap.put("aace", cls2);
            hashMap.put("aacf", cls2);
            hashMap.put("aacp", cls2);
            hashMap.put("aacs", cls2);
            hashMap.put("samr", cls2);
            hashMap.put("AUDB", cls2);
            hashMap.put("ilbc", cls2);
            hashMap.put("ms\u0000\u0011", cls2);
            hashMap.put(new String(new byte[]{109, 115, 0, TarConstants.LF_LINK}), cls2);
            hashMap.put("aes3", cls2);
            hashMap.put(Profile.DataLevel.NONE, cls2);
            hashMap.put("raw ", cls2);
            hashMap.put("twos", cls2);
            hashMap.put("sowt", cls2);
            hashMap.put("MAC3 ", cls2);
            hashMap.put("MAC6 ", cls2);
            hashMap.put("ima4", cls2);
            hashMap.put("fl32", cls2);
            hashMap.put("fl64", cls2);
            hashMap.put("in24", cls2);
            hashMap.put("in32", cls2);
            hashMap.put("ulaw", cls2);
            hashMap.put("alaw", cls2);
            hashMap.put("dvca", cls2);
            hashMap.put("QDMC", cls2);
            hashMap.put("QDM2", cls2);
            hashMap.put("Qclp", cls2);
            hashMap.put(".mp3", cls2);
            hashMap.put("mp4a", cls2);
            hashMap.put("lpcm", cls2);
            Class<gy> cls3 = gy.class;
            hashMap.put("tmcd", cls3);
            hashMap.put("time", cls3);
            Class<ff> cls4 = ff.class;
            hashMap.put("c608", cls4);
            hashMap.put("c708", cls4);
            hashMap.put("text", cls4);
        }
    }

    static {
        new aa();
    }

    public fe(da daVar) {
        super(daVar);
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f13252b.size());
        super.a(byteBuffer);
    }

    public fe() {
        this(new da("stsd"));
    }
}
