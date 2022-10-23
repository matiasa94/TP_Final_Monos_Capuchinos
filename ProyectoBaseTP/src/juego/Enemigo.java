package juego;
import java.awt.Image;
import java.awt.Color;

import entorno.Herramientas;
import entorno.Entorno;

public class Enemigo {
    private int x;
    private int y;
    private String nombre;
    private Image img;
    private boolean state;
    
    public Enemigo(int x,  String name) {
        this.x = x;

        this.nombre = name;
        this.state = true;
        if (name.equals("serpiente")) {
        	this.y = 250;
            img = Herramientas.cargarImagen("serpiente.png");
        }else {
        	this.y=400;
            img = Herramientas.cargarImagen("puma1.png");
        }
    }
    
    public void moverse() {
        if(this.state) {
        	this.x = this.x - 1;
        }
    }
    
    public void dibujarse(Entorno e) {
    	if (this.state) {
    	e.dibujarImagen(img, this.x, this.y, 0, 1);
    	}
    }
    
    public void morirse() {
    	this.state = false;
    }
    

    
    
    //getters and setters

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}


}
