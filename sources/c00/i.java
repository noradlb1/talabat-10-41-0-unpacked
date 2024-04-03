package c00;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.sharedpreferences.Messages;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class i {
    @NonNull
    public static MessageCodec<Object> a() {
        return new StandardMessageCodec();
    }

    public static /* synthetic */ void b(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        try {
            arrayList.add(0, sharedPreferencesApi.remove((String) ((ArrayList) obj).get(0)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void c(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.setBool((String) arrayList2.get(0), (Boolean) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void d(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.setString((String) arrayList2.get(0), (String) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void e(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        Long l11;
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        String str = (String) arrayList2.get(0);
        Number number = (Number) arrayList2.get(1);
        if (number == null) {
            l11 = null;
        } else {
            try {
                l11 = Long.valueOf(number.longValue());
            } catch (Throwable th2) {
                arrayList = Messages.a(th2);
            }
        }
        arrayList.add(0, sharedPreferencesApi.setInt(str, l11));
        reply.reply(arrayList);
    }

    public static /* synthetic */ void f(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.setDouble((String) arrayList2.get(0), (Double) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void g(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.setStringList((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void h(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.clear((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static /* synthetic */ void i(Messages.SharedPreferencesApi sharedPreferencesApi, Object obj, BasicMessageChannel.Reply reply) {
        ArrayList<Object> arrayList = new ArrayList<>();
        ArrayList arrayList2 = (ArrayList) obj;
        try {
            arrayList.add(0, sharedPreferencesApi.getAll((String) arrayList2.get(0), (List) arrayList2.get(1)));
        } catch (Throwable th2) {
            arrayList = Messages.a(th2);
        }
        reply.reply(arrayList);
    }

    public static void j(@NonNull BinaryMessenger binaryMessenger, @Nullable Messages.SharedPreferencesApi sharedPreferencesApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.remove", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel.setMessageHandler(new a(sharedPreferencesApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setBool", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel2.setMessageHandler(new b(sharedPreferencesApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setString", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel3.setMessageHandler(new c(sharedPreferencesApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setInt", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel4.setMessageHandler(new d(sharedPreferencesApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setDouble", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel5.setMessageHandler(new e(sharedPreferencesApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.setStringList", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel6.setMessageHandler(new f(sharedPreferencesApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.clear", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel7.setMessageHandler(new g(sharedPreferencesApi));
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.SharedPreferencesApi.getAll", a(), binaryMessenger.makeBackgroundTaskQueue());
        if (sharedPreferencesApi != null) {
            basicMessageChannel8.setMessageHandler(new h(sharedPreferencesApi));
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }
}
