package com.google.android.exoplayer2.extractor.jpeg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

final class MotionPhotoDescription {
    public final List<ContainerItem> items;
    public final long photoPresentationTimestampUs;

    public static final class ContainerItem {
        public final long length;
        public final String mime;
        public final long padding;
        public final String semantic;

        public ContainerItem(String str, String str2, long j11, long j12) {
            this.mime = str;
            this.semantic = str2;
            this.length = j11;
            this.padding = j12;
        }
    }

    public MotionPhotoDescription(long j11, List<ContainerItem> list) {
        this.photoPresentationTimestampUs = j11;
        this.items = list;
    }

    @Nullable
    public MotionPhotoMetadata getMotionPhotoMetadata(long j11) {
        long j12;
        if (this.items.size() < 2) {
            return null;
        }
        long j13 = j11;
        long j14 = -1;
        long j15 = -1;
        long j16 = -1;
        long j17 = -1;
        boolean z11 = false;
        for (int size = this.items.size() - 1; size >= 0; size--) {
            ContainerItem containerItem = this.items.get(size);
            boolean equals = MimeTypes.VIDEO_MP4.equals(containerItem.mime) | z11;
            if (size == 0) {
                j13 -= containerItem.padding;
                j12 = 0;
            } else {
                j12 = j13 - containerItem.length;
            }
            long j18 = j13;
            j13 = j12;
            long j19 = j18;
            if (!equals || j13 == j19) {
                z11 = equals;
            } else {
                j17 = j19 - j13;
                j16 = j13;
                z11 = false;
            }
            if (size == 0) {
                j14 = j13;
                j15 = j19;
            }
        }
        if (j16 == -1 || j17 == -1 || j14 == -1 || j15 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j14, j15, this.photoPresentationTimestampUs, j16, j17);
    }
}
