
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class MyList implements List<MusicComposition> {
    private MusicComposition[] elements = new MusicComposition[15];
    private int size = 0;
    private int indexm;
    protected transient int modCount = 0;

    public MyList() {

    }

    public MyList(MusicComposition element) {
        this.add(element);
    }

    public MyList(Collection e) {
        this.addAll(e);
    }

    public MusicComposition[] getElements() {
        return elements;
    }

    private void garbageCollector() {
        MusicComposition[] temp = new MusicComposition[elements.length];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    private void increaseSize() {
        MusicComposition[] temp = elements;
        int length = (int) (elements.length * 1.3);
        elements = new MusicComposition[length];
        for (int i = 0; i < temp.length; i++) {
            elements[i] = temp[i];
        }
    }

    @Override
    public int size() {
        return size; //size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<MusicComposition> iterator() {

        return new Iterator<MusicComposition>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public MusicComposition next() {
                return elements[index++];
            }

            @Override
            public void remove() {
                for (int i = index-1; i < size - 1; i++) {
                    elements[i] = elements[i + 1];
                }
                size--;
                index--;
                //garbageCollector();

            }
        };
    }

    @Override
    public Object[] toArray() {
        MusicComposition arr[] = new MusicComposition[size];
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(MusicComposition musicComposition) {
        if (size > elements.length) {
            this.increaseSize();
        }
        elements[size++] = musicComposition;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                for (int j = i; j < size - 1; j++)
                    elements[j] = elements[j + 1];
                size--;
                garbageCollector();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends MusicComposition> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            this.add((MusicComposition) iterator.next());
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MusicComposition> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            this.add(index, (MusicComposition) iterator.next());
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next());
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Collection<?> temp = c;
        Iterator<?> iterator = temp.iterator();
        while (iterator.hasNext()) {
                if (!this.contains(iterator.next()))
                    iterator.remove();
        }
        size=c.size();
        elements= c.toArray(new MusicComposition[size]);
        /*int counter = 0;
        int[] temp = new int[c.size()];
        while (iterator.hasNext()) {
            for (int i = 0; i < temp.length; i++) {
                if (this.contains(iterator.next())) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }
        }
        Iterator<?> secondIterator = c.iterator();
        size = c.size();
        elements = new MusicComposition[size];
        while (secondIterator.hasNext()) {
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 1) {

                    elements[counter++] = ((MusicComposition) secondIterator.next());
                } else {
                    secondIterator.next();
                }
            }
        }
        size = counter;*/
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        garbageCollector();

    }

    @Override
    public MusicComposition get(int index) {
        return elements[index];
    }

    @Override
    public MusicComposition set(int index, MusicComposition element) {
        MusicComposition previously = elements[index];
        elements[index] = element;
        return previously;
    }

    @Override
    public void add(int index, MusicComposition element) {
        MusicComposition temp = elements[index];

        if (!((index < elements.length) && (size + 1 < elements.length))) {
            this.increaseSize();
        }
        for (int i = size; i > index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index + 1] = temp;
        elements[index] = element;

        size++;

    }

    @Override
    public MusicComposition remove(int index) {
        MusicComposition previously = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        garbageCollector();
        return previously;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<MusicComposition> listIterator() {
        return new ListIterator<MusicComposition>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public MusicComposition next() {
                return elements[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public MusicComposition previous() {
                return elements[index--];
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                index--;
                size--;
                garbageCollector();
            }

            @Override
            public void set(MusicComposition musicComposition) {
                elements[index] = musicComposition;
            }

            @Override
            public void add(MusicComposition musicComposition) {
                index++;
                elements[index] = musicComposition;
            }
        };
    }

    @Override
    public ListIterator<MusicComposition> listIterator(int index) {
        indexm = index;
        return new ListIterator<MusicComposition>() {

            @Override
            public boolean hasNext() {
                return indexm < size;
            }

            @Override
            public MusicComposition next() {
                return elements[indexm++];
            }

            @Override
            public boolean hasPrevious() {
                return indexm > 0;
            }

            @Override
            public MusicComposition previous() {
                return elements[indexm--];
            }

            @Override
            public int nextIndex() {
                return indexm + 1;
            }

            @Override
            public int previousIndex() {
                return indexm - 1;
            }

            @Override
            public void remove() {
                indexm--;
                size--;
                garbageCollector();
            }

            @Override
            public void set(MusicComposition musicComposition) {
                elements[indexm] = musicComposition;
            }

            @Override
            public void add(MusicComposition musicComposition) {
                indexm++;
                elements[indexm] = musicComposition;
            }
        };
    }

    @Override
    public List<MusicComposition> subList(int fromIndex, int toIndex) {
        MusicComposition[] temp = new MusicComposition[elements.length];
        for (int i = fromIndex; i < toIndex; i++) {
            temp[i] = elements[i];
        }

        return Arrays.asList(temp);
    }

    @Override
    public void replaceAll(UnaryOperator<MusicComposition> operator) {
        final ListIterator<MusicComposition> li = this.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }

    }

    @Override
    public void sort(Comparator<? super MusicComposition> c) {
        Arrays.sort(elements, c);
    }

    @Override
    public Spliterator<MusicComposition> spliterator() {
        return new Spliterator<MusicComposition>() {
            @Override
            public boolean tryAdvance(Consumer<? super MusicComposition> action) {
                return false;
            }

            @Override
            public Spliterator<MusicComposition> trySplit() {
                return null;
            }

            @Override
            public void forEachRemaining(Consumer<? super MusicComposition> action) {

            }

            @Override
            public long getExactSizeIfKnown() {
                return 0;
            }

            @Override
            public boolean hasCharacteristics(int characteristics) {
                return false;
            }

            @Override
            public Comparator<? super MusicComposition> getComparator() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }
        };
    }
}
