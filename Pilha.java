
package pilha;

public class Pilha<T> {
    private int topo;
    private T[] elementos;
    
    public Pilha(int tamanho){
          elementos =(T[]) new Object[tamanho];
          this.topo = -1;
    }
    
    public boolean isFull(){
        return topo == elementos.length - 1;
        
    }
    
    public boolean isEmpty(){
        return this.topo == -1;
    }
    
    public boolean push(T novoDado){
        if(!this.isFull()){
            this.topo++;
            elementos[topo] = novoDado;
            return true;
        } else{
            return false;
        } 
    }
    
    public T pop(){
        T retorno = elementos[topo];
        topo--;
        return retorno;   
    }
    
    public int size(){
        return topo + 1;
    }
    
    public T peek(){
        return elementos[topo];
    }
    
    public void limpar() {
        topo = -1; 
        elementos = (T[]) new Object[10];
    }
    
    @Override
    public String toString(){
        StringBuilder retorno = new StringBuilder();
        for(int i = topo; i >= 0; i--){
            retorno.append(elementos[i] + "\n");
        }
        retorno.append("-----------");
        return retorno.toString();
    }
}