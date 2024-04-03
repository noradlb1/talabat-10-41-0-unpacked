package io.flutter.plugins.videoplayer;

import android.content.Context;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import d00.l;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
import java.util.Objects;

public class VideoPlayerPlugin implements FlutterPlugin, Messages.AndroidVideoPlayerApi {
    private static final String TAG = "VideoPlayerPlugin";
    private FlutterState flutterState;
    private final VideoPlayerOptions options = new VideoPlayerOptions();
    private final LongSparseArray<VideoPlayer> videoPlayers = new LongSparseArray<>();

    public static final class FlutterState {

        /* renamed from: a  reason: collision with root package name */
        public final Context f14396a;

        /* renamed from: b  reason: collision with root package name */
        public final BinaryMessenger f14397b;

        /* renamed from: c  reason: collision with root package name */
        public final KeyForAssetFn f14398c;

        /* renamed from: d  reason: collision with root package name */
        public final KeyForAssetAndPackageName f14399d;

        /* renamed from: e  reason: collision with root package name */
        public final TextureRegistry f14400e;

        public FlutterState(Context context, BinaryMessenger binaryMessenger, KeyForAssetFn keyForAssetFn, KeyForAssetAndPackageName keyForAssetAndPackageName, TextureRegistry textureRegistry) {
            this.f14396a = context;
            this.f14397b = binaryMessenger;
            this.f14398c = keyForAssetFn;
            this.f14399d = keyForAssetAndPackageName;
            this.f14400e = textureRegistry;
        }

        public void a(VideoPlayerPlugin videoPlayerPlugin, BinaryMessenger binaryMessenger) {
            a.m(binaryMessenger, videoPlayerPlugin);
        }

        public void b(BinaryMessenger binaryMessenger) {
            a.m(binaryMessenger, (Messages.AndroidVideoPlayerApi) null);
        }
    }

    public interface KeyForAssetAndPackageName {
        String get(String str, String str2);
    }

    public interface KeyForAssetFn {
        String get(String str);
    }

    public VideoPlayerPlugin() {
    }

    private void disposeAllPlayers() {
        for (int i11 = 0; i11 < this.videoPlayers.size(); i11++) {
            this.videoPlayers.valueAt(i11).a();
        }
        this.videoPlayers.clear();
    }

    /* access modifiers changed from: private */
    public void onDestroy() {
        disposeAllPlayers();
    }

    public static void registerWith(@NonNull PluginRegistry.Registrar registrar) {
        registrar.addViewDestroyListener(new l(new VideoPlayerPlugin(registrar)));
    }

    @NonNull
    public Messages.TextureMessage create(@NonNull Messages.CreateMessage createMessage) {
        VideoPlayer videoPlayer;
        String str;
        TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.flutterState.f14400e.createSurfaceTexture();
        BinaryMessenger binaryMessenger = this.flutterState.f14397b;
        EventChannel eventChannel = new EventChannel(binaryMessenger, "flutter.io/videoPlayer/videoEvents" + createSurfaceTexture.id());
        if (createMessage.getAsset() != null) {
            if (createMessage.getPackageName() != null) {
                str = this.flutterState.f14399d.get(createMessage.getAsset(), createMessage.getPackageName());
            } else {
                str = this.flutterState.f14398c.get(createMessage.getAsset());
            }
            Context context = this.flutterState.f14396a;
            videoPlayer = new VideoPlayer(context, eventChannel, createSurfaceTexture, "asset:///" + str, (String) null, new HashMap(), this.options);
        } else {
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = createSurfaceTexture;
            videoPlayer = new VideoPlayer(this.flutterState.f14396a, eventChannel, surfaceTextureEntry, createMessage.getUri(), createMessage.getFormatHint(), createMessage.getHttpHeaders(), this.options);
        }
        this.videoPlayers.put(createSurfaceTexture.id(), videoPlayer);
        return new Messages.TextureMessage.Builder().setTextureId(Long.valueOf(createSurfaceTexture.id())).build();
    }

    public void dispose(@NonNull Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).a();
        this.videoPlayers.remove(textureMessage.getTextureId().longValue());
    }

    public void initialize() {
        disposeAllPlayers();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        FlutterInjector instance = FlutterInjector.instance();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        FlutterLoader flutterLoader = instance.flutterLoader();
        Objects.requireNonNull(flutterLoader);
        b bVar = new b(flutterLoader);
        FlutterLoader flutterLoader2 = instance.flutterLoader();
        Objects.requireNonNull(flutterLoader2);
        FlutterState flutterState2 = new FlutterState(applicationContext, binaryMessenger, bVar, new c(flutterLoader2), flutterPluginBinding.getTextureRegistry());
        this.flutterState = flutterState2;
        flutterState2.a(this, flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (this.flutterState == null) {
            Log.wtf(TAG, "Detached from the engine before registering to it.");
        }
        this.flutterState.b(flutterPluginBinding.getBinaryMessenger());
        this.flutterState = null;
        initialize();
    }

    public void pause(@NonNull Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).c();
    }

    public void play(@NonNull Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).d();
    }

    @NonNull
    public Messages.PositionMessage position(@NonNull Messages.TextureMessage textureMessage) {
        VideoPlayer videoPlayer = this.videoPlayers.get(textureMessage.getTextureId().longValue());
        Messages.PositionMessage build = new Messages.PositionMessage.Builder().setPosition(Long.valueOf(videoPlayer.b())).setTextureId(textureMessage.getTextureId()).build();
        videoPlayer.f();
        return build;
    }

    public void seekTo(@NonNull Messages.PositionMessage positionMessage) {
        this.videoPlayers.get(positionMessage.getTextureId().longValue()).e(positionMessage.getPosition().intValue());
    }

    public void setLooping(@NonNull Messages.LoopingMessage loopingMessage) {
        this.videoPlayers.get(loopingMessage.getTextureId().longValue()).h(loopingMessage.getIsLooping().booleanValue());
    }

    public void setMixWithOthers(@NonNull Messages.MixWithOthersMessage mixWithOthersMessage) {
        this.options.mixWithOthers = mixWithOthersMessage.getMixWithOthers().booleanValue();
    }

    public void setPlaybackSpeed(@NonNull Messages.PlaybackSpeedMessage playbackSpeedMessage) {
        this.videoPlayers.get(playbackSpeedMessage.getTextureId().longValue()).i(playbackSpeedMessage.getSpeed().doubleValue());
    }

    public void setVolume(@NonNull Messages.VolumeMessage volumeMessage) {
        this.videoPlayers.get(volumeMessage.getTextureId().longValue()).j(volumeMessage.getVolume().doubleValue());
    }

    private VideoPlayerPlugin(PluginRegistry.Registrar registrar) {
        FlutterState flutterState2 = new FlutterState(registrar.context(), registrar.messenger(), new d(registrar), new e(registrar), registrar.textures());
        this.flutterState = flutterState2;
        flutterState2.a(this, registrar.messenger());
    }
}
