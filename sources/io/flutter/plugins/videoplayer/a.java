package io.flutter.plugins.videoplayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import d00.b;
import d00.c;
import d00.d;
import d00.e;
import d00.f;
import d00.g;
import d00.h;
import d00.i;
import d00.j;
import d00.k;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.videoplayer.Messages;
import java.util.ArrayList;

public final /* synthetic */ class a {
    @NonNull
    public static MessageCodec<Object> a() {
        return Messages.AndroidVideoPlayerApiCodec.INSTANCE;
    }

    public static /* synthetic */ void b(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.initialize();
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, androidVideoPlayerApi.create((Messages.CreateMessage) ((ArrayList) obj).get(0)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void d(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.setMixWithOthers((Messages.MixWithOthersMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void e(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.dispose((Messages.TextureMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void f(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.setLooping((Messages.LoopingMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void g(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.setVolume((Messages.VolumeMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void h(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.setPlaybackSpeed((Messages.PlaybackSpeedMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void i(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.play((Messages.TextureMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void j(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, androidVideoPlayerApi.position((Messages.TextureMessage) ((ArrayList) obj).get(0)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void k(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.seekTo((Messages.PositionMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void l(Messages.AndroidVideoPlayerApi androidVideoPlayerApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            androidVideoPlayerApi.pause((Messages.TextureMessage) ((ArrayList) obj).get(0));
            arrayList.add(0, (Object) null);
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static void m(@NonNull BinaryMessenger binaryMessenger, @Nullable Messages.AndroidVideoPlayerApi androidVideoPlayerApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.initialize", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel.setMessageHandler(new d00.a(androidVideoPlayerApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.create", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel2.setMessageHandler(new d(androidVideoPlayerApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.dispose", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel3.setMessageHandler(new e(androidVideoPlayerApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.setLooping", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel4.setMessageHandler(new f(androidVideoPlayerApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.setVolume", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel5.setMessageHandler(new g(androidVideoPlayerApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.setPlaybackSpeed", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel6.setMessageHandler(new h(androidVideoPlayerApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.play", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel7.setMessageHandler(new i(androidVideoPlayerApi));
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.position", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel8.setMessageHandler(new j(androidVideoPlayerApi));
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.seekTo", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel9.setMessageHandler(new k(androidVideoPlayerApi));
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.pause", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel10.setMessageHandler(new b(androidVideoPlayerApi));
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.AndroidVideoPlayerApi.setMixWithOthers", a());
        if (androidVideoPlayerApi != null) {
            basicMessageChannel11.setMessageHandler(new c(androidVideoPlayerApi));
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
