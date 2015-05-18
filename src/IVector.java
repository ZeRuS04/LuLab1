/**
 * Саморасширяющаяся коллекция. Объекты хранятся в массиве в порядке добавления.
 */
public interface IVector {

    /**
     * Добавляет объект в коллекцию
     * @param o
     */
    void add(Object o);

    /**
     * Добавляет объект в коллекцию на указанную позицию
     * @param o
     * @param pos
     */
    void add(Object o, int pos);

    /**
     * Удаляет объект из коллекции, находящийся на указанной позиции
     * @param index
     */
    void remove(int index);

    /**
     * Возвращает объект, находящийся на определенной позиции
     * @param index
     * @return
     */
    Object get(int index);

    /**
     * Возвращает индекс объекта, если такой есть в векторе. Если такого нет, то -1.
     * @param o
     * @return
     */
    int indexOf(Object o);
}