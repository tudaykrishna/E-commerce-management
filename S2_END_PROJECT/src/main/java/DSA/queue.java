package DSA;

public class queue {
    public Object[] stk;
    public int size;
    public int rear;
    public int count;

    public queue(int initialCapacity)
    {
        if(initialCapacity<1)
            throw new IllegalArgumentException("initialCapacity must be >=1");
        stk= new Object[initialCapacity];
        size= initialCapacity;
        rear = 0;
    }
    public queue()
    {
        stk=null;
        size=0;
        rear=0;
        count=0;
    }
    public Object[] update(){
        return stk;
    }
    public boolean equeue(String element){
        if (count == size){
            return false;
        }
        stk[rear] = element;
        count++;
        rear++;
        return true;
    }
    public Object dequeue()
    {
        if (count==0)
        {
            return false;
        }
        count--;
        for (int i = 0;i < stk.length-1; i++){
            stk[i] = stk[i+1];
        }
        stk[--rear]=0;
        return stk[rear];
    }
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}