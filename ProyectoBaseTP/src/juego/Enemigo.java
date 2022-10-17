package juego;
import java.awt.Image;
import java.awt.Color;

import entorno.Herramientas;
import entorno.Entorno;

public class Enemigo {
    int x;
    int y;
    String nombre;
    Image img;
    
    public Enemigo(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.nombre = name;
        if (name == "serpiente") {
            img = Herramientas.cargarImagen("serpiente.png");
        }else {
            img = Herramientas.cargarImagen("puma.png");
        }
    }
    
    public void moverse() {
        this.x = this.x - 1;
    }
    
    public void dibujarse(Entorno e) {
    	e.dibujarImagen(img, this.x, this.y, 0, 1);
    }

}
