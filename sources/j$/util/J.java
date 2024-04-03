package j$.util;

public interface J extends Spliterator {
    void forEachRemaining(Object obj);

    boolean tryAdvance(Object obj);

    J trySplit();
}
