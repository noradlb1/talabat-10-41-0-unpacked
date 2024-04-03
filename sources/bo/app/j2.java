package bo.app;

import com.braze.events.IEventSubscriber;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J*\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J*\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&J+\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\u0006\u0010\f\u001a\u00028\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\n\u0010\rJ\b\u0010\n\u001a\u00020\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lbo/app/j2;", "", "T", "Lcom/braze/events/IEventSubscriber;", "subscriber", "Ljava/lang/Class;", "eventClass", "", "c", "", "a", "b", "message", "(Ljava/lang/Object;Ljava/lang/Class;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public interface j2 {
    void a();

    <T> void a(T t11, Class<T> cls);

    <T> boolean a(IEventSubscriber<T> iEventSubscriber, Class<T> cls);

    <T> boolean b(IEventSubscriber<T> iEventSubscriber, Class<T> cls);

    <T> void c(IEventSubscriber<T> iEventSubscriber, Class<T> cls);
}
