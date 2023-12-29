package jogoDaVelha;

import java.util.ArrayList;
import java.util.List;


public class Campo {
    final int linha;
    final int coluna;
    boolean marcadoX= false;
    boolean marcado0=false;
    
    boolean aberto= false;
    private List<ObservadorJV> observadores= new ArrayList<>();
	public void registrarObservador(ObservadorJV observado) {
		observadores.add(observado);
		
	}
	public void notificarObservador () {
		observadores.stream().forEach(c -> c.eventoOcorreu(this));
	}
    
    public Campo(int linha, int coluna) {
    	this.linha= linha;
    	this.coluna= coluna;
    	
    }
    public void marcarTeste() {
    	marcadoX=true;
    }
    public void marcarTeste2() {
    	marcado0=true;
    }
    public void reiniciarCampo() {
    	marcadoX= false;
        marcado0=false;
        aberto= false;
    }
    public void abrirCampo(int linha, int coluna, boolean X, boolean Y) {
    	if (linha==this.linha && coluna==this.coluna && !aberto) {
    		aberto=true;
    		marcadoX= X;
    		marcado0= Y;
    	}
    }
}
