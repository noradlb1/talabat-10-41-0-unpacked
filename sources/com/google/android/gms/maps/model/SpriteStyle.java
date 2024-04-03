package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.StampStyle;

public class SpriteStyle extends StampStyle {

    public static final class Builder extends StampStyle.Builder<Builder> {
        private Builder() {
        }

        public /* synthetic */ Builder(zzs zzs) {
        }

        @NonNull
        public SpriteStyle build() {
            return new SpriteStyle(this.zza);
        }

        @NonNull
        public Builder self() {
            return this;
        }
    }

    public SpriteStyle(@NonNull BitmapDescriptor bitmapDescriptor) {
        super(bitmapDescriptor);
    }

    @NonNull
    public static Builder newBuilder(@NonNull BitmapDescriptor bitmapDescriptor) {
        return (Builder) new Builder((zzs) null).stamp(bitmapDescriptor);
    }
}
