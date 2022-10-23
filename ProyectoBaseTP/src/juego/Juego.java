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
			this.depredadores [i] = new Enemigo(posiciones[rand.nextInt(0, 4)]+i*150,name[rand.nextInt(0, 2)]);
		}
		// Inicializar lo que haga falta para el juego
		// ...

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
        
        
        for(Enemigo e: depredadores) {
        	e.dibujarse(entorno);
        	e.moverse();
        }
        
  		
        for(Enemigo e: depredadores) {
        	if(e.getX()==0)e.setState(false);
        	if(!e.getState() && cont < depredadores.length)cont++;
        }
        
        if(cont == depredadores.length) {
        	entorno.escribirTexto("NIVEL FINALIZADO CON EXITO!", 100, 100);
        }



		entorno.escribirTexto("la posicion del puma es: " + depredadores[0].getX(), 100, 100);
		entorno.escribirTexto("los segundos son "+cont, 120, 120);
		
		

		 
		

	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
