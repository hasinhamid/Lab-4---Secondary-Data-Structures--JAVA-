/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        int i=0;
        if(key.length()%2!=0){
            i=1;
        }
        int sum=0;
        for(    ;i<key.length();i+=2){
            int a=key.charAt(i);
            sum+=a;
        }
        return sum%ht.length; //remove this line
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int idx= hashFunction(key);
        FruitNode nd= new FruitNode(key, value);
        FruitNode ptr= ht[idx];
        if(ptr==null){
            ht[idx]=nd;
        }
        else{
            if((String)ptr.fruit[0]==key){
                ptr.fruit[1]=value;
                return;
            }
            if((int)ptr.fruit[1]<value){
                nd.next=ptr;
                ht[idx]=nd;
            }
            else{
                while ((int)ptr.fruit[1]>value && ptr.next!=null) {
                    if((String)ptr.fruit[0]==key){
                        ptr.fruit[1]=value;
                        return;
                    }
                    ptr=ptr.next;
                }
                nd.next=ptr.next;
                ptr.next=nd;
            }
        }

    }

}
