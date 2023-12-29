package jogoDaVelha;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class botao extends JButton {

	 private List<ObservadorJV> observadores= new ArrayList<>();
		public void registrarObservador(ObservadorJV observado) {
			observadores.add(observado);
			
		}
		public void notificarObservadorX () {
			observadores.stream().forEach(c -> c.notificarAbertura(this, true, false));
		}
		public void notificarObservadorO () {
			observadores.stream().forEach(c -> c.notificarAbertura(this, false, true));
		}
	int linha;
	int coluna;
	boolean aberto= false;

	public botao(int linha, int coluna) {
		this.linha=linha;
		this.coluna=coluna;
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (!aberto) {
				aberto= true;
				atualizarInterface();
				}
			}

			
		});
			
		
		
	}
	public void reiniciarBotao () {
		setText("");
		aberto=false;
	}
	private void atualizarInterface() {
		if (Tabuleiro.contadorJogador%2==0) {
			setText("X");
			setForeground(Color.red);
			Tabuleiro.contadorJogador++;
			notificarObservadorX();
			
		} 
		else {
			setText("O");
			setForeground(Color.blue);
			Tabuleiro.contadorJogador++;
			notificarObservadorO();
			
		}
		setFont(new Font("Arial", Font.PLAIN, 40));
		
		
	}
}
