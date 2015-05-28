import java.util.Iterator;
import static java.lang.System.arraycopy;

public class SVector<T> implements IVector<T>, Iterable<T> {

    private T[] _array;
    private int _length;
    private int _cursor;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int index = -1;
            @Override
            public boolean hasNext() {
                return index < _cursor;
            }

            @Override
            public T next() {
                if(hasNext()){
                    index++;
                    return _array[index];
                }
                return null;
            }

            @Override
            public void remove() {
                if(index < 0){
                    return;
                }

                SVector.this.remove(index);
                if (index == 0) {
                    index = 0;
                } else {
                    index -= 1;
                }
            }
        };

    }

    public SVector(){
        _length = 1;
        _cursor = -1;
        _array = (T[])new Object[_length];
    }
    public void show(){
        for(int i =0 ; i < _length; i++)
        {
            System.out.print(_array[i].getClass().getName());
            System.out.println(_array[i]);
        }
    }

    public SVector(int size){
        if(size <= 0){
            _length = 1;
        }else{
            _length = size;
        }
        _array = (T[])new Object[_length];
        _cursor = -1;
    }

    @Override
    public void add(T o) {
        // TODO Auto-generated method stub

        if(_cursor+1 == _length){
            _length += 2;
            T[] tmpArray = _array.clone();
            _array = (T[])new Object[_length];
            arraycopy(tmpArray, 0, _array, 0, tmpArray.length);
        }
        _cursor++;
        _array[_cursor] = o;




    }

    @Override
    public void add(T o, int pos) {
        // TODO Auto-generated method stub
        if(pos < 0){
            return;
        }
        if(pos <= _cursor){
            T[] tmpArray = _array.clone();
            _array = (T[])new Object[_length+2];
            arraycopy(tmpArray, 0, _array, 0, pos);
            _array[pos] = o;
            arraycopy(tmpArray, pos, _array, pos+1, _length - pos);
            _length = _array.length;
            _cursor++;
        }else{
            if(pos >= _length){
                T[] tmpArray = _array.clone();
                _array = (T[])new Object[pos+2];
                arraycopy(tmpArray, 0, _array, 0, _length);
                _length = _array.length;
            }
            _array[pos] = o;
            _cursor = pos;
        }

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || index > _cursor)
            return;
        T[] tmpArray = _array.clone();
        arraycopy(tmpArray, 0, _array, 0, index);
        arraycopy(tmpArray, index + 1, _array, index, _length - index -1);
        _array[_cursor] = null;
        _cursor--;
    }

    @Override
    public T get(int index) {
        // TODO Auto-generated method stub
        if(index < 0 || index > _cursor)
            return null;
        return _array[index];
    }

    @Override
    public int indexOf(T o) {
        // TODO Auto-generated method stub
        for(int i = 0; i < _length; i++){
            if(o.equals(_array[i])){
                return i;
            }
        }
        return -1;
    }

}
