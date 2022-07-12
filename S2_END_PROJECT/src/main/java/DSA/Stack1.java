package DSA;

public class Stack1 {
    protected Object[] stk;
    protected int size;
    protected int top;

    public Stack1(int initialcapacity)
    {
        if(initialcapacity < 1)
        {
            throw new IllegalArgumentException ("initialcapacity must be >= 1");
        }
        stk = new Object[initialcapacity];
        size = initialcapacity;
        top = 0;
    }

    public Stack1()
    { stk = null;
        size = top = 0;
    }

    public Object[] update() {

        return stk;
    }
    public boolean push(String element)
    {
        if( top==size)
        {
        return false;
        }
        stk[top] = element;
        top++;
        return true;
    }

    public Object pop()
    {
        if( top==0 )
        {
            return false;
        }
        top--;
        return stk[top];
    }
    
}