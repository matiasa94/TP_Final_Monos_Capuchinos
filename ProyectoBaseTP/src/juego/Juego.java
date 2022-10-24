package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Enemigo[] depredadores = new Enemigo[10];
	int cantSerpientes = 0;
	Arbol[] arboles = new Arbol[cantSerpientes + 13];
	String[] name = {"serpiente", "puma"};
	int[] posiciones = {160,320,480,640};
	Random rand = new Random();
	int cont = 0;

	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		
		
		this.entorno = new Entorno(this, "Attack on Titan, Final Season - Grupo ... - v1", 800, 600);
		//cargamos el array depredadores
		for (int i = 0; i<10; i++) {
			this.depredadores [i] = new Enemigo(posiciones[rand.nextInt(0, 4)]+ i*300,name[rand.nextInt(0, 2)]);
			if (this.depredadores[i].getNombre().equals("serpiente"))cantSerpientes ++; 
		}
		//cargamos el array de arboles
		for (int i = 0; i<arboles.length; i++) {
			this.arboles[i]= new Arbol(posiciones[rand.nextInt(0,4)]+i*200);
			//con esto evitamos que los arboles no se pisen
			if(i>0) {
				if(this.arboles[i-1].getX()>this.arboles[i].getX()-100 || this.arboles[i-1].getX()< this.arboles[i].getX()+100 ) {
					this.arboles[i].setX(this.arboles[i-1].getX()+200);
				}
			}
			if(i<depredadores.length-1) {
				if(depredadores[i].getNombre().equals("serpiente")) {
					arboles[i].setX( depredadores[i].getX());
				}
			}
		}
		


		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		
        this.entorno.dibujarRectangulo(400, 300, 800, 600, 0, Color.cyan);
        this.entorno.dibujarRectangulo(400, 500, 800, 200, 0, Color.green);
        
        for(Arbol ar: arboles) {
        	ar.dibujarse(entorno);
        	ar.moverse();
        	if(ar.getX()==0) ar.setState(false);
        }
        for(Enemigo e: depredadores) {
        	e.dibujarse(entorno);
        	e.moverse();
        	if (e.getX() == 0) e.setState(false);
        }


  		if (!estanMuertos(depredadores)) {
        	entorno.escribirTexto("NIVEL FINALIZADO CON EXITO!", 50, 50);
  		}
        



		entorno.escribirTexto("la posicion del puma es: " + depredadores[0].getX(), 100, 100);
		entorno.escribirTexto("los segundos son "+cantSerpientes, 120, 120);

		

		 
		

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
	
	public boolean estanMuertos (Enemigo[] depredadores){
		boolean estado = false;
		for(Enemigo en: depredadores) {
			if(en.getState()) estado = true;
		}
		return estado;
		
		
	}
}
