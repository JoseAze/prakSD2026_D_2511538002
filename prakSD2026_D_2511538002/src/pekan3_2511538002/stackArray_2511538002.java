package pekan3_2511538002;

public class stackArray_2511538002 {
static final int MAX_8002 =1000;
int top_8002;
int a_8002[] = new int[MAX_8002];
boolean isEmpty_8002() 
{ 
	return (top_8002< 0);
	
}
stackArray_2511538002()
{
	top_8002 = -1;
}
boolean push_8002(int x_8002)
{
	if (top_8002 >= (MAX_8002 - 1)) {
		System.out.println("Stack  Overfloe");
		 return false;
	}
	else {
		a_8002[++top_8002] =x_8002;
		System.out.println(x_8002 + " dimasukan dalam stack");
		return true;
	}
}

		int pop_8002() {
			if (top_8002<0) {
				System.out.println("Stack uderflow");
				return 0;
			}
			else {
				int x_8002 = a_8002[top_8002--];
				return x_8002;
			}
		}
		int peek_8002()
		{
			if (top_8002<0) {
				System.out.println("stack underflow");
				return 0;
			}else {
				int x_8002 = a_8002[top_8002];
				return x_8002;
		}
		}
		void print_8002() {
			for(int i_8002 = top_8002; i_8002 > -1; i_8002--) {
				System.out.println(" "+ a_8002[i_8002]);
			}
		}
	}

		
