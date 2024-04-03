package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.StampStyle;

public class TextureStyle extends StampStyle {

    public static final class Builder extends StampStyle.Builder<Builder> {
        private Builder() {
        }

        public /* synthetic */ Builder(zzac zzac) {
        }

        @NonNull
        public TextureStyle build() {
            return new TextureStyle(this.zza, (zzad) null);
        }

        @NonNull
        public Builder self() {
            return this;
        }
    }

    public /* synthetic */ TextureStyle(BitmapDescriptor bitmapDescriptor, zzad zzad) {
        super(bitmapDescriptor);
    }

    @NonNull
    public static Builder newBuilder(@NonNull BitmapDescriptor bitmapDescriptor) {
        return (Builder) new Builder((zzac) null).stamp(bitmapDescriptor);
    }
}
