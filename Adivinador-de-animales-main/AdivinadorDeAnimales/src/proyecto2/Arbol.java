package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author Jenderson Quintero y Norangel Marin.
 */
public class Arbol {

    Nodo raiz;
    Txt txt;
    String info = "";

    /**
     * Constructor de la clase Arbol.
     */
    public Arbol() {
        this.raiz = new Nodo("León");
        txt = new Txt();
    }

    /**
     * Funcion para obtener la raiz del arbol.
     *
     * @return Nodo
     */
    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Vacia el arbol existente.
     */
    public void vaciarArbol() {
        raiz = new Nodo("León");
    }

    /**
     * Retorna true si la respuesta a la pregrunta ejercida al usuario fue
     * afirmativa.
     *
     * @param pregunta
     * @return boolean
     */
    public boolean Pregunta(String pregunta) {
        String respuesta = JOptionPane.showInputDialog(null, pregunta, "Adivinaré el animal!", 3);
        info += (respuesta + ",");
        return "SÍ.".equals(respuesta.toUpperCase()) || "SI.".equals(respuesta.toUpperCase()) || "SI".equals(respuesta.toUpperCase()) || "SÍ".equals(respuesta.toUpperCase()) || "S".equals(respuesta.toUpperCase());
    }

    /**
     * Retorna true si la respuesta a la pregrunta ejercida al usuario guardada
     * en el txt fue afirmativa.
     *
     * @param contenido
     * @param i
     * @return boolean
     */
    public boolean RespuestaTxt(String[] contenido, int i) {
        return "S".equals(contenido[i].toUpperCase()) || "SI.".equals(contenido[i].toUpperCase()) || contenido[i].toUpperCase().equals("SÍ") || contenido[i].toUpperCase().equals("SI") || contenido[i].toUpperCase().equals("SÍ.");
    }

    /**
     * Posee las mismas características que el procedimiento adivinador pero
     * funciona obteniendo los datos del txt. De esta manera el adivinador no
     * pierde la información al cerrar la interfaz.
     */
    public void AdivinadorPrev() {
        try {
            String[] contenido = txt.cargarTxt();
            if (contenido[0] != null) {
                int i = 0;
                while (i < contenido.length) {
                    if (RespuestaTxt(contenido, i)) {
                        // Caracteristicas nuevas añadidas
                        Nodo arbol = raiz;
                        while (arbol.getIzq() != null) {
                            i += 1;
                            if (RespuestaTxt(contenido, i)) {
                                arbol = arbol.getDer();
                            } else {
                                arbol = arbol.getIzq();
                            }
                        }
                        // Si Adivina...
                        String animal = arbol.getDato();
                        i += 1;
                        if (RespuestaTxt(contenido, i)) {
                            i += 1;
                        } else {
                            i += 1;
                            String nuevoAnimal = contenido[i];
                            i += 1;
                            String nuevaCaracteristica = contenido[i];
                            arbol.dato = nuevaCaracteristica;
                            arbol.izq = new Nodo(animal);
                            arbol.der = new Nodo(nuevoAnimal);
                        }
                        i += 1;
                    } else {
                        i += 1;
                    }
                }
            } else {
            }
        } catch (Exception e) {
        }
    }

    /**
     * Procedimiento que de acuedo a la información que tenga el arbol, intenta
     * adivinar el animal que está pensando el usuario. Organiza el arbol de
     * acuerdo a lo aprendido por el usuario.
     */
    public void Adivinador() {
        // Pregunta inicial
        if (Pregunta("¿Estás pensando en un animal?")) {
            // Caracteristicas nuevas añadidas
            Nodo arbol = raiz;
            while (arbol.getIzq() != null) {
                if (Pregunta("¿" + arbol.getDato() + "?")) {
                    arbol = arbol.getDer();
                } else {
                    arbol = arbol.getIzq();
                }
            }
            // Si Adivina...
            String animal = arbol.getDato();
            if (Pregunta("¿Es un/a " + animal + "?")) {
                JOptionPane.showMessageDialog(null, "¡LO LOGRÉ! ¡ADIVINÉ!", "Animal Localizado.", 1);
            } else {
                String nuevoAnimal = JOptionPane.showInputDialog(null, "¿Qué animal era?", "Aprendiendo...", 3);
                String nuevaCaracteristica = JOptionPane.showInputDialog(null, "¿Qué característica tiene un/a " + nuevoAnimal + " que lo diferencia de un " + animal + "?", "Aprendiendo...", 3);
                info += (nuevoAnimal + ",");
                info += (nuevaCaracteristica + ",");
                arbol.dato = nuevaCaracteristica;
                arbol.izq = new Nodo(animal);
                arbol.der = new Nodo(nuevoAnimal);
                JOptionPane.showMessageDialog(null, "¡Nuevo Conocimiento Adquirido!", "Base de conocimientos actualizada.", 1);
            }
            txt.escribirTxt(info);
            info = "";
        }
    }

}
