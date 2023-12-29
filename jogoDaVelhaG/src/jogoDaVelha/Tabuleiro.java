package jogoDaVelha;

import java.util.ArrayList;
import java.util.List;




public class Tabuleiro implements ObservadorJV{
	static int contadorJogador=2;
	public Tabuleiro () {
		preencherTabuleiro();
	}
	public List<Campo> campos = new ArrayList<>();
	private void preencherTabuleiro() {
		for(int i=0; i<3; i++) {
			for (int c=0; c<3; c++) {
				Campo campo= new Campo(i, c);
				campo.registrarObservador(this);
				campos.add(campo);
			}
		}
	}
	public void reiniciarJogo() {
		campos.stream().forEach(v -> v.reiniciarCampo());
		contadorJogador=2;
	}
	
	public boolean verificarVitoria() {
		for (Campo campo1: campos) {
			for (Campo campo2: campos) {
				for (Campo campo3: campos) {
					if ((campo1.linha==campo2.linha && campo1.linha==campo3.linha) && ((campo1.marcado0 && campo2.marcado0 && campo3.marcado0) ||
							(campo1.marcadoX && campo2.marcadoX && campo3.marcadoX))&& (campo1!=campo2 && campo1!=campo3 && campo2!=campo3)) {
						return true;
					}
					else {
						if ((campo1.coluna==campo2.coluna && campo1.coluna==campo3.coluna) && ((campo1.marcado0 && campo2.marcado0 && campo3.marcado0) ||
							(campo1.marcadoX && campo2.marcadoX && campo3.marcadoX))&& (campo1!=campo2 && campo1!=campo3 && campo2!=campo3)) {
						return true;
						}
						else {
							if ((campo1.linha==0 && campo1.coluna==0 && campo2.linha==1 && campo2.coluna==1 && campo3.linha==2 && campo3.coluna==2) &&
									((campo1.marcado0 && campo2.marcado0 && campo3.marcado0)||(campo1.marcadoX && campo2.marcadoX && campo3.marcadoX))) {
								return true;
							}
							else {
								if ((campo1.linha==0 && campo1.coluna==2 && campo2.linha==1 && campo2.coluna==1 && campo3.linha==2 && campo3.coluna==0) &&
										((campo1.marcado0 && campo2.marcado0 && campo3.marcado0)||(campo1.marcadoX && campo2.marcadoX && campo3.marcadoX))) {
									return true;
								}
								
							}
						}
					}
				}
			}
		}
		return false;
	}

	
	@Override
	public void eventoOcorreu(Campo campo) {
		
		
	}
	public boolean empate() {
		return campos.stream().allMatch(c-> c.marcadoX || c.marcado0);
	}
	public void notificarAberturaTESTE(int linha, int coluna, boolean x, boolean o) {
		 campos.stream().forEach(v-> v.abrirCampo(linha, coluna, x, o));
	}

	 public void notificarAbertura(botao botao, boolean x, boolean o) {
		 campos.stream().forEach(v-> v.abrirCampo(botao.linha, botao.coluna, x, o));
		 if (verificarVitoria()) {
			 telaPrincipal.alguemGanhou();
			 reiniciarJogo();
			 
		 }
		 if (empate()) {
			 telaPrincipal.empate();
			 reiniciarJogo();
		 }
		 
	 }
	
}
