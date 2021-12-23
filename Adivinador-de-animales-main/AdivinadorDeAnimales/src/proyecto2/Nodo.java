package proyecto2;

/**
 *
 * @author Jenderson Quintero y Norangel Marin.
 */
public class Nodo {
    String dato;
    Nodo der;
    Nodo izq;

    /**
     * Constructor del Nodo.
     * @param dato int
     */
    public Nodo(String dato) {
        this.dato = dato;
        izq = null;
        der = null;
    }

    /**
     * Accedemos al dato del nodo
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * 
     * Accedemos al hijo derecho del nodo en cuestion.
     * @return the der
     */
    public Nodo getDer() {
        return der;
    }

    /**
     * Accedemos al hijo izquierdo del nodo en cuestion.
     * @return the izq
     */
    public Nodo getIzq() {
        return izq;
    }
    
    /**
     * Devuelve la cantidad de todos los nodos del arbol.
     * @param nodo
     * @return int 
     */
    public int getNodos(Nodo nodo){
        if (nodo == null) {
            return 0;
        }else{
            if (nodo.izq != null && nodo.der != null) {
                return getNodos(nodo.izq) + getNodos(nodo.der) + 1;
            }
            return getNodos(nodo.izq) + getNodos(nodo.der);
        }
    }
}
