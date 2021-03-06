package implementacao3;

public class ListaEncadeada implements ListaEncadeada_IF 
{
    private int dado;
    private ListaEncadeada proximo;
    
    public ListaEncadeada() 
    {
        dado = -1;
    }

    @Override
    public boolean isEmpty() {
        if(dado == -1)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        if(isEmpty())
            return 0;
        else
            return 1 + proximo.size();
    }

    @Override
    public int search(int element) throws Exception {
        if(isEmpty())
            throw new Exception("Elemento não encontrado");
        else
            if(dado == element)
                return dado;
            else
                return proximo.search(element);           
    }
     
    @Override
    public void insert(int element) {
        //Professor criei metodos auxiliar para poder alternar entrer inserir no Inicio e no Final
        InserirNoInicio(element);
    }
    
    //Metodo para inserir no Final
    private void InserirNoFinal(int element)
    {
       if(isEmpty())
        {
            dado = element;
            proximo = new ListaEncadeada();
        }
        else
            proximo.insert(element); 
    }

    //Metodo para inserir no Inicio
    public void InserirNoInicio(int element)
    {
        if(isEmpty())
        {
            dado = element;
            proximo = new ListaEncadeada();
        }
        else //conferir, ta adicionando no 2 lugar
        {
            ListaEncadeada aux = new ListaEncadeada();
            aux.dado = dado;
            aux.proximo = proximo;
            dado = element;
            proximo = aux;   
        }
    }
  
    @Override
    public void remove(int element) {
        if(isEmpty())
        {} 
        else
        {
           if(dado == element)
           {
               dado = proximo.dado;
               proximo = proximo.proximo;
           }     
           else
               proximo.remove(element);
        }
    }
     
    @Override
    public int[] toArray() {
        int[] resultado = new int[size()];
        CriarLista(resultado, this);
        return resultado;
    }
    
    private void CriarLista(int[] array, ListaEncadeada nova)
    {
       if(!nova.isEmpty())
       {
           AdicionarNoArray(array, nova.dado);
           CriarLista(array, nova.proximo);
       }       
    } 
    
    private void AdicionarNoArray(int[] array, int elemento)
    {
        for(int i=0; i<array.length; i++)
        {
            if(array[i] == 0) //Corrigir isso, se o tiver um elemento 0 inserido, vai da problema.
            {
                array[i] = elemento;
                break;
            }           
        }
    } 
}
