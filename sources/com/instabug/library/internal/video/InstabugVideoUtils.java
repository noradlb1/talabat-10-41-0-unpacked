package com.instabug.library.internal.video;

import android.annotation.SuppressLint;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.IOException;

public class InstabugVideoUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0109, code lost:
        if (r9 == false) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011f  */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void genVideoUsingMuxer(java.lang.String r16, java.lang.String r17, int r18, int r19, boolean r20, boolean r21) throws java.io.IOException {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "The muxer has been released!"
            java.lang.String r4 = "The muxer skip release/stop since it has no written frames"
            java.lang.String r5 = "IBG-Core"
            android.media.MediaExtractor r6 = new android.media.MediaExtractor
            r6.<init>()
            r6.setDataSource(r0)
            int r7 = r6.getTrackCount()
            android.media.MediaMuxer r8 = new android.media.MediaMuxer
            r9 = 0
            r10 = r17
            r8.<init>(r10, r9)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>(r7)
            r11 = -1
            r12 = r9
        L_0x0027:
            if (r12 >= r7) goto L_0x0076
            android.media.MediaFormat r14 = r6.getTrackFormat(r12)
            java.lang.String r15 = "mime"
            java.lang.String r15 = r14.getString(r15)
            if (r15 == 0) goto L_0x0040
            java.lang.String r13 = "audio/"
            boolean r13 = r15.startsWith(r13)
            if (r13 == 0) goto L_0x0040
            if (r20 == 0) goto L_0x0040
            goto L_0x004d
        L_0x0040:
            if (r15 == 0) goto L_0x004f
            java.lang.String r13 = "video/"
            boolean r13 = r15.startsWith(r13)
            if (r13 == 0) goto L_0x004f
            if (r21 == 0) goto L_0x004f
        L_0x004d:
            r13 = 1
            goto L_0x0050
        L_0x004f:
            r13 = r9
        L_0x0050:
            if (r13 == 0) goto L_0x0073
            r6.selectTrack(r12)
            int r13 = r8.addTrack(r14)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r12)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r10.put(r15, r13)
            java.lang.String r13 = "max-input-size"
            boolean r15 = r14.containsKey(r13)
            if (r15 == 0) goto L_0x0073
            int r13 = r14.getInteger(r13)
            if (r13 <= r11) goto L_0x0073
            r11 = r13
        L_0x0073:
            int r12 = r12 + 1
            goto L_0x0027
        L_0x0076:
            if (r11 >= 0) goto L_0x007a
            r11 = 4096(0x1000, float:5.74E-42)
        L_0x007a:
            android.media.MediaMetadataRetriever r7 = new android.media.MediaMetadataRetriever
            r7.<init>()
            r7.setDataSource(r0)
            r12 = 24
            java.lang.String r12 = r7.extractMetadata(r12)
            r7.release()
            if (r12 == 0) goto L_0x0096
            int r7 = java.lang.Integer.parseInt(r12)
            if (r7 < 0) goto L_0x0096
            r8.setOrientationHint(r7)
        L_0x0096:
            if (r1 <= 0) goto L_0x009f
            int r1 = r1 * 1000
            long r12 = (long) r1
            r1 = 2
            r6.seekTo(r12, r1)
        L_0x009f:
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r11)
            android.media.MediaCodec$BufferInfo r7 = new android.media.MediaCodec$BufferInfo
            r7.<init>()
            r8.start()     // Catch:{ IllegalStateException -> 0x0104 }
            r11 = r9
        L_0x00ac:
            r7.offset = r9     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            int r12 = r6.readSampleData(r1, r9)     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r7.size = r12     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            if (r12 >= 0) goto L_0x00b9
            r7.size = r9     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            goto L_0x00c8
        L_0x00b9:
            long r12 = r6.getSampleTime()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r7.presentationTimeUs = r12     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            if (r2 <= 0) goto L_0x00d6
            int r14 = r2 * 1000
            long r14 = (long) r14     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x00d6
        L_0x00c8:
            r8.stop()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            java.io.File r1 = new java.io.File     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r1.<init>(r0)     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r1.delete()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            if (r11 == 0) goto L_0x0112
            goto L_0x010b
        L_0x00d6:
            int r12 = r6.getSampleFlags()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r7.flags = r12     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            int r12 = r6.getSampleTrackIndex()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            java.lang.Object r12 = r10.get(r12)     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            if (r12 == 0) goto L_0x00ac
            int r12 = r12.intValue()     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r8.writeSampleData(r12, r1, r7)     // Catch:{ IllegalStateException -> 0x0100, all -> 0x00fd }
            r6.advance()     // Catch:{ IllegalStateException -> 0x00fb, all -> 0x00f8 }
            r11 = 1
            goto L_0x00ac
        L_0x00f8:
            r0 = move-exception
            r9 = 1
            goto L_0x0116
        L_0x00fb:
            r9 = 1
            goto L_0x0104
        L_0x00fd:
            r0 = move-exception
            r9 = r11
            goto L_0x0116
        L_0x0100:
            r9 = r11
            goto L_0x0104
        L_0x0102:
            r0 = move-exception
            goto L_0x0116
        L_0x0104:
            java.lang.String r0 = "The source video file is malformed"
            com.instabug.library.util.InstabugSDKLogger.e(r5, r0)     // Catch:{ all -> 0x0102 }
            if (r9 == 0) goto L_0x0112
        L_0x010b:
            r8.release()
            com.instabug.library.util.InstabugSDKLogger.v(r5, r3)
            goto L_0x0115
        L_0x0112:
            com.instabug.library.util.InstabugSDKLogger.v(r5, r4)
        L_0x0115:
            return
        L_0x0116:
            if (r9 == 0) goto L_0x011f
            r8.release()
            com.instabug.library.util.InstabugSDKLogger.v(r5, r3)
            goto L_0x0122
        L_0x011f:
            com.instabug.library.util.InstabugSDKLogger.v(r5, r4)
        L_0x0122:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.InstabugVideoUtils.genVideoUsingMuxer(java.lang.String, java.lang.String, int, int, boolean, boolean):void");
    }

    @RequiresApi(api = 21)
    @Size(2)
    public static double[] getDimensInBounded(double d11, double d12, double d13, double d14) {
        double round = (double) Math.round(d11 > d12 ? d11 / d12 : d12 / d11);
        while (true) {
            if (d13 < d11 || d14 < d12) {
                d11 /= round;
                d12 /= round;
            } else {
                return new double[]{d11, d12};
            }
        }
    }

    @SuppressLint({"RESOURCE_LEAK"})
    private static int getVideoDuration(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        int i11 = 0;
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                i11 = Integer.parseInt(extractMetadata);
            }
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e11) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e11);
            }
        } catch (Exception e12) {
            InstabugSDKLogger.e("IBG-Core", String.format("Error: %s occurred during getting video file with path: %s duration", new Object[]{e12.getMessage(), str}));
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e13) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e13);
            }
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e14) {
                InstabugSDKLogger.d("IBG-Core", "Error while releasing mediaMetadataRetriever" + e14);
            }
            throw th2;
        }
        return i11;
    }

    private static boolean isDurationMoreThanAutoRecMaxDuration(int i11, int i12) {
        return i11 > i12;
    }

    public static File startTrim(File file, File file2, int i11) throws IOException {
        int videoDuration;
        if (file == null || file.length() <= 0 || !FileUtils.isVideoFile(file) || (videoDuration = getVideoDuration(file.getPath())) == 0 || !isDurationMoreThanAutoRecMaxDuration(videoDuration, i11)) {
            return file;
        }
        genVideoUsingMuxer(file.getPath(), file2.getPath(), videoDuration - i11, videoDuration, false, true);
        return file2;
    }
}
