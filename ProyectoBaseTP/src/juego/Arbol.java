package juego;
import java.awt.Image;
import entorno.Herramientas;
import entorno.Entorno;
public class Arbol {
	private int x;
	private int y;
	private boolean state;
	private Image img;
	
	public Arbol(int x) {
		this.x = x;
		this.y = 320;
		this.state = true;
		this.img = Herramientas.cargarImagen("tree.png");
	}
	
    public void dibujarse(Entorno e) {
    	if (this.state) {
    	
    	e.dibujarImagen(img, this.x, this.y, 0, 1);
    	}
    }
    public void morirse() {
    	this.state = false;
    }
    public void moverse() {
    	if(this.state) x -= 1;
    }
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
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}

}
