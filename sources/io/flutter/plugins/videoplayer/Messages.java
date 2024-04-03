package io.flutter.plugins.videoplayer;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;

public class Messages {

    public interface AndroidVideoPlayerApi {
        @NonNull
        TextureMessage create(@NonNull CreateMessage createMessage);

        void dispose(@NonNull TextureMessage textureMessage);

        void initialize();

        void pause(@NonNull TextureMessage textureMessage);

        void play(@NonNull TextureMessage textureMessage);

        @NonNull
        PositionMessage position(@NonNull TextureMessage textureMessage);

        void seekTo(@NonNull PositionMessage positionMessage);

        void setLooping(@NonNull LoopingMessage loopingMessage);

        void setMixWithOthers(@NonNull MixWithOthersMessage mixWithOthersMessage);

        void setPlaybackSpeed(@NonNull PlaybackSpeedMessage playbackSpeedMessage);

        void setVolume(@NonNull VolumeMessage volumeMessage);
    }

    public static class AndroidVideoPlayerApiCodec extends StandardMessageCodec {
        public static final AndroidVideoPlayerApiCodec INSTANCE = new AndroidVideoPlayerApiCodec();

        private AndroidVideoPlayerApiCodec() {
        }

        public Object e(byte b11, @NonNull ByteBuffer byteBuffer) {
            switch (b11) {
                case Byte.MIN_VALUE:
                    return CreateMessage.a((ArrayList) d(byteBuffer));
                case -127:
                    return LoopingMessage.a((ArrayList) d(byteBuffer));
                case -126:
                    return MixWithOthersMessage.a((ArrayList) d(byteBuffer));
                case -125:
                    return PlaybackSpeedMessage.a((ArrayList) d(byteBuffer));
                case -124:
                    return PositionMessage.a((ArrayList) d(byteBuffer));
                case -123:
                    return TextureMessage.a((ArrayList) d(byteBuffer));
                case -122:
                    return VolumeMessage.a((ArrayList) d(byteBuffer));
                default:
                    return super.e(b11, byteBuffer);
            }
        }

        public void n(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CreateMessage) {
                byteArrayOutputStream.write(128);
                n(byteArrayOutputStream, ((CreateMessage) obj).b());
            } else if (obj instanceof LoopingMessage) {
                byteArrayOutputStream.write(129);
                n(byteArrayOutputStream, ((LoopingMessage) obj).b());
            } else if (obj instanceof MixWithOthersMessage) {
                byteArrayOutputStream.write(130);
                n(byteArrayOutputStream, ((MixWithOthersMessage) obj).b());
            } else if (obj instanceof PlaybackSpeedMessage) {
                byteArrayOutputStream.write(131);
                n(byteArrayOutputStream, ((PlaybackSpeedMessage) obj).b());
            } else if (obj instanceof PositionMessage) {
                byteArrayOutputStream.write(Opcodes.IINC);
                n(byteArrayOutputStream, ((PositionMessage) obj).b());
            } else if (obj instanceof TextureMessage) {
                byteArrayOutputStream.write(Opcodes.I2L);
                n(byteArrayOutputStream, ((TextureMessage) obj).b());
            } else if (obj instanceof VolumeMessage) {
                byteArrayOutputStream.write(134);
                n(byteArrayOutputStream, ((VolumeMessage) obj).b());
            } else {
                super.n(byteArrayOutputStream, obj);
            }
        }
    }

    public static final class CreateMessage {
        @Nullable
        private String asset;
        @Nullable
        private String formatHint;
        @NonNull
        private Map<String, String> httpHeaders;
        @Nullable
        private String packageName;
        @Nullable
        private String uri;

        public static final class Builder {
            @Nullable
            private String asset;
            @Nullable
            private String formatHint;
            @Nullable
            private Map<String, String> httpHeaders;
            @Nullable
            private String packageName;
            @Nullable
            private String uri;

            @NonNull
            public CreateMessage build() {
                CreateMessage createMessage = new CreateMessage();
                createMessage.setAsset(this.asset);
                createMessage.setUri(this.uri);
                createMessage.setPackageName(this.packageName);
                createMessage.setFormatHint(this.formatHint);
                createMessage.setHttpHeaders(this.httpHeaders);
                return createMessage;
            }

            @NonNull
            public Builder setAsset(@Nullable String str) {
                this.asset = str;
                return this;
            }

            @NonNull
            public Builder setFormatHint(@Nullable String str) {
                this.formatHint = str;
                return this;
            }

            @NonNull
            public Builder setHttpHeaders(@NonNull Map<String, String> map) {
                this.httpHeaders = map;
                return this;
            }

            @NonNull
            public Builder setPackageName(@Nullable String str) {
                this.packageName = str;
                return this;
            }

            @NonNull
            public Builder setUri(@Nullable String str) {
                this.uri = str;
                return this;
            }
        }

        @NonNull
        public static CreateMessage a(@NonNull ArrayList<Object> arrayList) {
            CreateMessage createMessage = new CreateMessage();
            createMessage.setAsset((String) arrayList.get(0));
            createMessage.setUri((String) arrayList.get(1));
            createMessage.setPackageName((String) arrayList.get(2));
            createMessage.setFormatHint((String) arrayList.get(3));
            createMessage.setHttpHeaders((Map) arrayList.get(4));
            return createMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.asset);
            arrayList.add(this.uri);
            arrayList.add(this.packageName);
            arrayList.add(this.formatHint);
            arrayList.add(this.httpHeaders);
            return arrayList;
        }

        @Nullable
        public String getAsset() {
            return this.asset;
        }

        @Nullable
        public String getFormatHint() {
            return this.formatHint;
        }

        @NonNull
        public Map<String, String> getHttpHeaders() {
            return this.httpHeaders;
        }

        @Nullable
        public String getPackageName() {
            return this.packageName;
        }

        @Nullable
        public String getUri() {
            return this.uri;
        }

        public void setAsset(@Nullable String str) {
            this.asset = str;
        }

        public void setFormatHint(@Nullable String str) {
            this.formatHint = str;
        }

        public void setHttpHeaders(@NonNull Map<String, String> map) {
            if (map != null) {
                this.httpHeaders = map;
                return;
            }
            throw new IllegalStateException("Nonnull field \"httpHeaders\" is null.");
        }

        public void setPackageName(@Nullable String str) {
            this.packageName = str;
        }

        public void setUri(@Nullable String str) {
            this.uri = str;
        }
    }

    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    public static final class LoopingMessage {
        @NonNull
        private Boolean isLooping;
        @NonNull
        private Long textureId;

        public static final class Builder {
            @Nullable
            private Boolean isLooping;
            @Nullable
            private Long textureId;

            @NonNull
            public LoopingMessage build() {
                LoopingMessage loopingMessage = new LoopingMessage();
                loopingMessage.setTextureId(this.textureId);
                loopingMessage.setIsLooping(this.isLooping);
                return loopingMessage;
            }

            @NonNull
            public Builder setIsLooping(@NonNull Boolean bool) {
                this.isLooping = bool;
                return this;
            }

            @NonNull
            public Builder setTextureId(@NonNull Long l11) {
                this.textureId = l11;
                return this;
            }
        }

        @NonNull
        public static LoopingMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            LoopingMessage loopingMessage = new LoopingMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            loopingMessage.setTextureId(l11);
            loopingMessage.setIsLooping((Boolean) arrayList.get(1));
            return loopingMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.textureId);
            arrayList.add(this.isLooping);
            return arrayList;
        }

        @NonNull
        public Boolean getIsLooping() {
            return this.isLooping;
        }

        @NonNull
        public Long getTextureId() {
            return this.textureId;
        }

        public void setIsLooping(@NonNull Boolean bool) {
            if (bool != null) {
                this.isLooping = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"isLooping\" is null.");
        }

        public void setTextureId(@NonNull Long l11) {
            if (l11 != null) {
                this.textureId = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"textureId\" is null.");
        }
    }

    public static final class MixWithOthersMessage {
        @NonNull
        private Boolean mixWithOthers;

        public static final class Builder {
            @Nullable
            private Boolean mixWithOthers;

            @NonNull
            public MixWithOthersMessage build() {
                MixWithOthersMessage mixWithOthersMessage = new MixWithOthersMessage();
                mixWithOthersMessage.setMixWithOthers(this.mixWithOthers);
                return mixWithOthersMessage;
            }

            @NonNull
            public Builder setMixWithOthers(@NonNull Boolean bool) {
                this.mixWithOthers = bool;
                return this;
            }
        }

        @NonNull
        public static MixWithOthersMessage a(@NonNull ArrayList<Object> arrayList) {
            MixWithOthersMessage mixWithOthersMessage = new MixWithOthersMessage();
            mixWithOthersMessage.setMixWithOthers((Boolean) arrayList.get(0));
            return mixWithOthersMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.mixWithOthers);
            return arrayList;
        }

        @NonNull
        public Boolean getMixWithOthers() {
            return this.mixWithOthers;
        }

        public void setMixWithOthers(@NonNull Boolean bool) {
            if (bool != null) {
                this.mixWithOthers = bool;
                return;
            }
            throw new IllegalStateException("Nonnull field \"mixWithOthers\" is null.");
        }
    }

    public static final class PlaybackSpeedMessage {
        @NonNull
        private Double speed;
        @NonNull
        private Long textureId;

        public static final class Builder {
            @Nullable
            private Double speed;
            @Nullable
            private Long textureId;

            @NonNull
            public PlaybackSpeedMessage build() {
                PlaybackSpeedMessage playbackSpeedMessage = new PlaybackSpeedMessage();
                playbackSpeedMessage.setTextureId(this.textureId);
                playbackSpeedMessage.setSpeed(this.speed);
                return playbackSpeedMessage;
            }

            @NonNull
            public Builder setSpeed(@NonNull Double d11) {
                this.speed = d11;
                return this;
            }

            @NonNull
            public Builder setTextureId(@NonNull Long l11) {
                this.textureId = l11;
                return this;
            }
        }

        @NonNull
        public static PlaybackSpeedMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            PlaybackSpeedMessage playbackSpeedMessage = new PlaybackSpeedMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            playbackSpeedMessage.setTextureId(l11);
            playbackSpeedMessage.setSpeed((Double) arrayList.get(1));
            return playbackSpeedMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.textureId);
            arrayList.add(this.speed);
            return arrayList;
        }

        @NonNull
        public Double getSpeed() {
            return this.speed;
        }

        @NonNull
        public Long getTextureId() {
            return this.textureId;
        }

        public void setSpeed(@NonNull Double d11) {
            if (d11 != null) {
                this.speed = d11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"speed\" is null.");
        }

        public void setTextureId(@NonNull Long l11) {
            if (l11 != null) {
                this.textureId = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"textureId\" is null.");
        }
    }

    public static final class PositionMessage {
        @NonNull
        private Long position;
        @NonNull
        private Long textureId;

        public static final class Builder {
            @Nullable
            private Long position;
            @Nullable
            private Long textureId;

            @NonNull
            public PositionMessage build() {
                PositionMessage positionMessage = new PositionMessage();
                positionMessage.setTextureId(this.textureId);
                positionMessage.setPosition(this.position);
                return positionMessage;
            }

            @NonNull
            public Builder setPosition(@NonNull Long l11) {
                this.position = l11;
                return this;
            }

            @NonNull
            public Builder setTextureId(@NonNull Long l11) {
                this.textureId = l11;
                return this;
            }
        }

        @NonNull
        public static PositionMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            long j12;
            PositionMessage positionMessage = new PositionMessage();
            Object obj = arrayList.get(0);
            Long l12 = null;
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j12 = (long) ((Integer) obj).intValue();
                } else {
                    j12 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j12);
            }
            positionMessage.setTextureId(l11);
            Object obj2 = arrayList.get(1);
            if (obj2 != null) {
                if (obj2 instanceof Integer) {
                    j11 = (long) ((Integer) obj2).intValue();
                } else {
                    j11 = ((Long) obj2).longValue();
                }
                l12 = Long.valueOf(j11);
            }
            positionMessage.setPosition(l12);
            return positionMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.textureId);
            arrayList.add(this.position);
            return arrayList;
        }

        @NonNull
        public Long getPosition() {
            return this.position;
        }

        @NonNull
        public Long getTextureId() {
            return this.textureId;
        }

        public void setPosition(@NonNull Long l11) {
            if (l11 != null) {
                this.position = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"position\" is null.");
        }

        public void setTextureId(@NonNull Long l11) {
            if (l11 != null) {
                this.textureId = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"textureId\" is null.");
        }
    }

    public static final class TextureMessage {
        @NonNull
        private Long textureId;

        public static final class Builder {
            @Nullable
            private Long textureId;

            @NonNull
            public TextureMessage build() {
                TextureMessage textureMessage = new TextureMessage();
                textureMessage.setTextureId(this.textureId);
                return textureMessage;
            }

            @NonNull
            public Builder setTextureId(@NonNull Long l11) {
                this.textureId = l11;
                return this;
            }
        }

        @NonNull
        public static TextureMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            TextureMessage textureMessage = new TextureMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            textureMessage.setTextureId(l11);
            return textureMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(this.textureId);
            return arrayList;
        }

        @NonNull
        public Long getTextureId() {
            return this.textureId;
        }

        public void setTextureId(@NonNull Long l11) {
            if (l11 != null) {
                this.textureId = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"textureId\" is null.");
        }
    }

    public static final class VolumeMessage {
        @NonNull
        private Long textureId;
        @NonNull
        private Double volume;

        public static final class Builder {
            @Nullable
            private Long textureId;
            @Nullable
            private Double volume;

            @NonNull
            public VolumeMessage build() {
                VolumeMessage volumeMessage = new VolumeMessage();
                volumeMessage.setTextureId(this.textureId);
                volumeMessage.setVolume(this.volume);
                return volumeMessage;
            }

            @NonNull
            public Builder setTextureId(@NonNull Long l11) {
                this.textureId = l11;
                return this;
            }

            @NonNull
            public Builder setVolume(@NonNull Double d11) {
                this.volume = d11;
                return this;
            }
        }

        @NonNull
        public static VolumeMessage a(@NonNull ArrayList<Object> arrayList) {
            Long l11;
            long j11;
            VolumeMessage volumeMessage = new VolumeMessage();
            Object obj = arrayList.get(0);
            if (obj == null) {
                l11 = null;
            } else {
                if (obj instanceof Integer) {
                    j11 = (long) ((Integer) obj).intValue();
                } else {
                    j11 = ((Long) obj).longValue();
                }
                l11 = Long.valueOf(j11);
            }
            volumeMessage.setTextureId(l11);
            volumeMessage.setVolume((Double) arrayList.get(1));
            return volumeMessage;
        }

        @NonNull
        public ArrayList<Object> b() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.textureId);
            arrayList.add(this.volume);
            return arrayList;
        }

        @NonNull
        public Long getTextureId() {
            return this.textureId;
        }

        @NonNull
        public Double getVolume() {
            return this.volume;
        }

        public void setTextureId(@NonNull Long l11) {
            if (l11 != null) {
                this.textureId = l11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"textureId\" is null.");
        }

        public void setVolume(@NonNull Double d11) {
            if (d11 != null) {
                this.volume = d11;
                return;
            }
            throw new IllegalStateException("Nonnull field \"volume\" is null.");
        }
    }

    @NonNull
    public static ArrayList<Object> a(@NonNull Throwable th2) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th2 instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th2;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
        } else {
            arrayList.add(th2.toString());
            arrayList.add(th2.getClass().getSimpleName());
            arrayList.add("Cause: " + th2.getCause() + ", Stacktrace: " + Log.getStackTraceString(th2));
        }
        return arrayList;
    }
}
