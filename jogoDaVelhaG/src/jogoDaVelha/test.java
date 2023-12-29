package jogoDaVelha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Tabuleiro tab= new Tabuleiro();
		tab.notificarAberturaTESTE(0, 0, true, false);
		tab.notificarAberturaTESTE(2, 1, false, true);
		tab.notificarAberturaTESTE(1, 2, true, false);
		tab.notificarAberturaTESTE(2, 0, true, false);
		tab.notificarAberturaTESTE(1, 1, false, true);
		assertTrue(tab.verificarVitoria());
		
	}
	public boolean testeV(Campo campo1, Campo campo2, Campo campo3) {
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
		return false;
	}
	

}
