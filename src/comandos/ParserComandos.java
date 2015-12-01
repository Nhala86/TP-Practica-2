package comandos;

public final class ParserComandos {
	
	private static final Comando[] comandos = {
			new Ayuda(),
			new Iniciar(),
			new CrearCelulaSimple(),
			new CrearCelulaCompleja(),
			new EliminarCelula(), 
			new Paso(), 
			new Vaciar(),
			new Salir(),
			new Guardar(), 
			new Cargar(),
	};
	
	/**
	 * 
	 * @return
	 */
	public static String AyudaComandos(){
		StringBuffer buffer = new StringBuffer();
		insertarSeparador(buffer);
		for(int j = 0; j < comandos.length; j++){
			buffer.append(comandos[j].textoAyuda());
		}
		insertarSeparador(buffer);
		return buffer.toString();
	}
	
	/**
	 * Metodo que genera una cadena de guiones como separador.
	 * @param buffer de 70 caracteres '_'
	 */
	private static void insertarSeparador(StringBuffer buffer){
		for(int i = 0; i < 70; i++)
			buffer.append('_');		
		buffer.append('\n');
	}
	
	/**
	 * 
	 * @param palabras
	 * @return
	 */
	public static Comando parseaComando(String[] palabras){
		int i = 0;
		boolean seguir = true;
		Comando comando = null;
		while(i < comandos.length && seguir){
			comando = comandos[i].parsea(palabras);
			if(comando != null)
				seguir = false;
			else i++;
		}
		return comando;
	}

}
