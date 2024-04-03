package j$.util;

import j$.util.function.Consumer;
import java.util.Comparator;
import java.util.function.Consumer;

public interface Spliterator<T> {

    public final /* synthetic */ class Wrapper implements java.util.Spliterator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.Spliterator convert(Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof K ? ((K) spliterator).f28551a : spliterator instanceof J ? I.a((J) spliterator) : new Wrapper();
        }

        public final /* synthetic */ int characteristics() {
            return Spliterator.this.characteristics();
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Spliterator spliterator = Spliterator.this;
            if (obj instanceof Wrapper) {
                obj = Spliterator.this;
            }
            return spliterator.equals(obj);
        }

        public final /* synthetic */ long estimateSize() {
            return Spliterator.this.estimateSize();
        }

        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.this.forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final /* synthetic */ Comparator getComparator() {
            return Spliterator.this.getComparator();
        }

        public final /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.this.getExactSizeIfKnown();
        }

        public final /* synthetic */ boolean hasCharacteristics(int i11) {
            return Spliterator.this.hasCharacteristics(i11);
        }

        public final /* synthetic */ int hashCode() {
            return Spliterator.this.hashCode();
        }

        public final /* synthetic */ boolean tryAdvance(java.util.function.Consumer consumer) {
            return Spliterator.this.a(Consumer.VivifiedWrapper.convert(consumer));
        }

        public final /* synthetic */ java.util.Spliterator trySplit() {
            return convert(Spliterator.this.trySplit());
        }
    }

    boolean a(j$.util.function.Consumer consumer);

    int characteristics();

    long estimateSize();

    void forEachRemaining(j$.util.function.Consumer consumer);

    Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i11);

    Spliterator trySplit();
}
