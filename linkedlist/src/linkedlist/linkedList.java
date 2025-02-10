package linkedlist;

class Node{
	private int data;
	Node next = null;
	Node prev = null;
	
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
	
	Node(){
		next = null;
		prev = null;
	}
	public void alterData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
}

public class linkedList {
	private Node ini = null;
	private Node end = null;
	private int size;
	
	linkedList(int data){
		ini = new Node(data);
		end = ini;
		size = 1;
	}
	
	linkedList(){
		ini = null;
		end = null;
		size = 0;
	}
	
	public void push(int data) {
	    Node newNode = new Node(data);
	    
	    if (size == 0) {
	        ini = newNode;
	        end = newNode;
	    } else {
	        newNode.prev = end;
	        end.next = newNode;
	        end = newNode;
	    }
	    
	    size++;
	}

	
	

	
	public boolean empty() {
		return size == 0;
	}
	
	public int peek() {
	    if (size == 0) {
	        throw new RuntimeException("A Lista está vazia!");
	    }
	    return end.getData();
	}

	
	public int search(int index) {
	    if (index < 0 || index >= size) {
	        throw new RuntimeException("Index fora do range!");
	    }

	    // Casos especiais: primeiro e último elemento
	    if (index == 0) { 
	        return ini.getData(); 
	    } else if (index == size - 1) { 
	        return end.getData(); 
	    }

	    Node current;
	    int indexCurrent;

	    if (index <= size / 2) { // Busca da esquerda para o meio
	        indexCurrent = 1;
	        current = ini.next; // Começa do segundo elemento

	        while (indexCurrent != index) {
	            current = current.next;
	            indexCurrent++;
	        }
	    } else { // Busca da direita para o meio
	        indexCurrent = size - 2;
	        current = end.prev; // Começa do penúltimo elemento

	        while (indexCurrent != index) {
	            current = current.prev;
	            indexCurrent--;
	        }
	    }

	    return current.getData();
	}
	
	public int pop() {
	    if (size == 0) {
	        throw new RuntimeException("A lista está vazia!");
	    }

	    int data = end.getData();

	    if (size == 1) { // Se houver apenas um elemento
	        ini = null;
	        end = null;
	    } else {
	        end = end.prev;
	        end.next = null;
	    }

	    size--;
	    return data;
	}


}
