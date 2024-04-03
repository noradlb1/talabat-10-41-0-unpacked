package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import i7.a;

public final class AudioAttributes implements Bundleable {
    public static final Bundleable.Creator<AudioAttributes> CREATOR = new a();
    public static final AudioAttributes DEFAULT = new Builder().build();
    private static final String FIELD_ALLOWED_CAPTURE_POLICY = Util.intToStringMaxRadix(3);
    private static final String FIELD_CONTENT_TYPE = Util.intToStringMaxRadix(0);
    private static final String FIELD_FLAGS = Util.intToStringMaxRadix(1);
    private static final String FIELD_SPATIALIZATION_BEHAVIOR = Util.intToStringMaxRadix(4);
    private static final String FIELD_USAGE = Util.intToStringMaxRadix(2);
    public final int allowedCapturePolicy;
    @Nullable
    private AudioAttributesV21 audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int spatializationBehavior;
    public final int usage;

    @RequiresApi(29)
    public static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static void setAllowedCapturePolicy(AudioAttributes.Builder builder, int i11) {
            AudioAttributes.Builder unused = builder.setAllowedCapturePolicy(i11);
        }
    }

    @RequiresApi(32)
    public static final class Api32 {
        private Api32() {
        }

        @DoNotInline
        public static void setSpatializationBehavior(AudioAttributes.Builder builder, int i11) {
            builder.setSpatializationBehavior(i11);
        }
    }

    @RequiresApi(21)
    public static final class AudioAttributesV21 {
        public final android.media.AudioAttributes audioAttributes;

        private AudioAttributesV21(AudioAttributes audioAttributes2) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(audioAttributes2.contentType).setFlags(audioAttributes2.flags).setUsage(audioAttributes2.usage);
            int i11 = Util.SDK_INT;
            if (i11 >= 29) {
                Api29.setAllowedCapturePolicy(usage, audioAttributes2.allowedCapturePolicy);
            }
            if (i11 >= 32) {
                Api32.setSpatializationBehavior(usage, audioAttributes2.spatializationBehavior);
            }
            this.audioAttributes = usage.build();
        }
    }

    public static final class Builder {
        private int allowedCapturePolicy = 1;
        private int contentType = 0;
        private int flags = 0;
        private int spatializationBehavior = 0;
        private int usage = 1;

        public AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage, this.allowedCapturePolicy, this.spatializationBehavior);
        }

        @CanIgnoreReturnValue
        public Builder setAllowedCapturePolicy(int i11) {
            this.allowedCapturePolicy = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setContentType(int i11) {
            this.contentType = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setFlags(int i11) {
            this.flags = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSpatializationBehavior(int i11) {
            this.spatializationBehavior = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUsage(int i11) {
            this.usage = i11;
            return this;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ AudioAttributes lambda$static$0(Bundle bundle) {
        Builder builder = new Builder();
        String str = FIELD_CONTENT_TYPE;
        if (bundle.containsKey(str)) {
            builder.setContentType(bundle.getInt(str));
        }
        String str2 = FIELD_FLAGS;
        if (bundle.containsKey(str2)) {
            builder.setFlags(bundle.getInt(str2));
        }
        String str3 = FIELD_USAGE;
        if (bundle.containsKey(str3)) {
            builder.setUsage(bundle.getInt(str3));
        }
        String str4 = FIELD_ALLOWED_CAPTURE_POLICY;
        if (bundle.containsKey(str4)) {
            builder.setAllowedCapturePolicy(bundle.getInt(str4));
        }
        String str5 = FIELD_SPATIALIZATION_BEHAVIOR;
        if (bundle.containsKey(str5)) {
            builder.setSpatializationBehavior(bundle.getInt(str5));
        }
        return builder.build();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage && this.allowedCapturePolicy == audioAttributes.allowedCapturePolicy && this.spatializationBehavior == audioAttributes.spatializationBehavior) {
            return true;
        }
        return false;
    }

    @RequiresApi(21)
    public AudioAttributesV21 getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            this.audioAttributesV21 = new AudioAttributesV21();
        }
        return this.audioAttributesV21;
    }

    public int hashCode() {
        return ((((((((527 + this.contentType) * 31) + this.flags) * 31) + this.usage) * 31) + this.allowedCapturePolicy) * 31) + this.spatializationBehavior;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_CONTENT_TYPE, this.contentType);
        bundle.putInt(FIELD_FLAGS, this.flags);
        bundle.putInt(FIELD_USAGE, this.usage);
        bundle.putInt(FIELD_ALLOWED_CAPTURE_POLICY, this.allowedCapturePolicy);
        bundle.putInt(FIELD_SPATIALIZATION_BEHAVIOR, this.spatializationBehavior);
        return bundle;
    }

    private AudioAttributes(int i11, int i12, int i13, int i14, int i15) {
        this.contentType = i11;
        this.flags = i12;
        this.usage = i13;
        this.allowedCapturePolicy = i14;
        this.spatializationBehavior = i15;
    }
}
