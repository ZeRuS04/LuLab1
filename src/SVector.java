
public class SVector implements IVector {

	private Object[] _array;
	private int _length;
	private int _cursor;
	
	public SVector(){
		_length = 1;
		_cursor = 0;
		_array = new Object[_length];
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
			_cursor = 0;
			_array = new Object[_length];
		}else{
			_length = size;
			_array = new Object[_length];
			_cursor = 0;
		}
		
		
	}
	
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		
			if(_cursor == _length){
				_length += 2;
				Object[] tmpArray = _array.clone();
				_array = new Object[_length];
				_array = tmpArray;
			}
			_array[_cursor] = 0;
			_cursor++;
		

		
	}

	@Override
	public void add(Object o, int pos) {
		// TODO Auto-generated method stub
		if(pos < 0){
			return;
		}
		if(pos >= _length){
			Object[] tmpArray = _array.clone();
			_array = new Object[pos+2];
			System.arraycopy(tmpArray, 0, _array, 0, _length);
			_length = _array.length;
			_cursor = pos;
		}
		_array[_cursor] = o;
		_cursor++;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index > _cursor)
			return;
		Object[] tmpArray = _array.clone();
		System.arraycopy(tmpArray, 0, _array, 0, index);
		System.arraycopy(tmpArray, index+1, _array, index, _length-index);
		_array[_cursor] = null;
		_cursor--;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index > _cursor)
			return null;
		return _array[index];
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		for(int i = 0; i < _length; i++){
			if(o.equals(_array[i])){
				return i;
			}
		}
		return -1;
	}

}
