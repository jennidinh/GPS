import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<AnyType> {

	private Comparator<? super AnyType> cmp;
	private int currentSize;
	private AnyType[] arr;
	private static final int DEFAULT_CAPACITY = 100;

	public PriorityQueue() {
		cmp = null;
		currentSize = 0;
		arr = (AnyType[]) new Object[DEFAULT_CAPACITY + 1];
	}
	
	public PriorityQueue( Comparator<? super AnyType> c )
    {
        currentSize = 0;
        cmp = c;
        arr = (AnyType[]) new Object[ DEFAULT_CAPACITY + 1 ];
    }

	public boolean add(AnyType x) {
		if (currentSize + 1 == arr.length)
			doubleArray();

		// Percolate up
		int hole = ++currentSize;

		arr[0] = x;

		for (; compare(x, arr[hole / 2]) < 0; hole /= 2)
			arr[hole] = arr[hole / 2];
		arr[hole] = x;

		return true;
	}

	public AnyType remove() {
		AnyType minItem = findMin();
		arr[1] = arr[currentSize--];
		percolateDown(1);

		return minItem;
	}

	public boolean isEmpty() {
		
		if (currentSize == 0) {
			
			return true;
		}
		return false;
	}
	private void doubleArray() {
		AnyType[] newArray;

		newArray = (AnyType[]) new Object[arr.length * 2];
		for (int i = 0; i < arr.length; i++)
			newArray[i] = arr[i];
		arr = newArray;
	}

	private int compare(AnyType lhs, AnyType rhs) {
		if (cmp == null)
			return ((Comparable) lhs).compareTo(rhs);
		else
			return cmp.compare(lhs, rhs);
			
		//return ((Comparable) lhs).compareTo(rhs);
	}
	
	public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new NoSuchElementException( );
        return arr[ 1 ];
    }
	
	private void percolateDown( int hole )
    {
        int child;
        AnyType tmp = arr[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    compare( arr[ child + 1 ], arr[ child ] ) < 0 )
                child++;
            if( compare( arr[ child ], tmp ) < 0 )
                arr[ hole ] = arr[ child ];
            else
                break;
        }
        arr[ hole ] = tmp;
    }
    
}
