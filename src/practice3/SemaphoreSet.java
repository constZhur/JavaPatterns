package practice3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreSet <T> implements Set <T> {

    /**
     * @volatile - ключевое слово, благодаря которому переменная не
     * перезаписывается в кэш каждого задействованного ядра процессора.
     * Все запросы к переменной обращаются непосредственно к памяти.
     */
    private volatile Set <T> set = new HashSet<>();

    /**
     * @Semaphore - класс, который испольуется для синхронизации потоков,
     * благодаря чему программисты могут не синхронизировать их вручную.
     * В конструктор принимает:
     * int permits - количество потоков.
     * bool fair - порядок доступа среди потоков.
     * bool fair == true - доступ предоставляеется в том же порядке, в котором потоки его запрашивали.
     * bool fair == false - порядок доступа регулируется планировщиком потоков.
     * Класс имеет два метода:
     * @acquire() - получение разрешения
     * @release() - освобождение разрешения
     */
    private Semaphore semaphore = new Semaphore(1,false);

    @Override
    public int size() {
        int size = 0;
        try {
            semaphore.acquire();
            size = set.size();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean emptiness = false;
        try {
            semaphore.acquire();
            emptiness = set.isEmpty();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return emptiness;
    }

    @Override
    public boolean contains(Object o) {
        boolean temp = false;
        try {
            semaphore.acquire();
            temp = set.contains(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator <T> iterator;
        try {
            semaphore.acquire();
            iterator = set.iterator();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return iterator;
    }

    @Override
    public T[] toArray() {
        T[] t;
        try {
            semaphore.acquire();
            t = (T[]) set.toArray();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return t;
    }

    @Override
    public boolean add(T t) {
        boolean isAdded = false;
        try {
            semaphore.acquire();
            isAdded = set.add((T) t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return isAdded;
    }

    @Override
    public boolean remove(Object o) {
        boolean isRemoved = false;
        try {
            semaphore.acquire();
            isRemoved = set.remove(o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return isRemoved;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean isAdded = false;
        try {
            semaphore.acquire();
            isAdded = set.addAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return isAdded;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean isRemoved = false;
        try {
            semaphore.acquire();
            isRemoved = set.removeAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean isRemoved = false;
        try {
            semaphore.acquire();
            isRemoved = set.retainAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean result = false;
        try {
            semaphore.acquire();
            result = set.containsAll(c);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] objects;
        try {
            semaphore.acquire();
            objects = set.toArray(a);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
        return objects;
    }
}
