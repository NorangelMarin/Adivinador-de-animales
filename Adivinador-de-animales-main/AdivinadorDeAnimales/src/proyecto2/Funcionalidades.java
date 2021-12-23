package proyecto2;

/**
 *
 * @author Jenderson Quintero y Norangel Marin.
 */
public class Funcionalidades {
    private final Arbol arbol;
    private final Grafico grafico;

    /**
     * Constructor de las funcionalidades utilizadas en la interfaz
     * @param arbol
     * @param grafico 
     */
    public Funcionalidades(Arbol arbol, Grafico grafico){
        this.arbol = arbol;
        this.grafico = grafico;
    }
    
    /**
     * Método que actualiza el Arbol que se muestra en el Panel.
     */
    public void actualizarArbol(){
        grafico.setArbol(arbol);
    }
}
