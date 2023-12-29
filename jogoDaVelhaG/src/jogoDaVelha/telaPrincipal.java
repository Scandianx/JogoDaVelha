package jogoDaVelha;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class telaPrincipal extends JFrame {
	public static List<botao> botoes= new ArrayList<>();
	public telaPrincipal () {
		setTitle("Jogo da velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		JPanel painel = new JPanel(new GridLayout(3, 3));
		setVisible(true);
		painel.setVisible(true);
		add(painel);
		Tabuleiro tab= new Tabuleiro();
		for (int i=0; i < 3; i++) {
			for(int c=0; c<3; c++) {
			botao botaoteste= new botao(i, c);
			botoes.add(botaoteste);
			painel.add(botaoteste);
			botaoteste.registrarObservador(tab);
			}
			
		}
		
		
	}
	public static void alguemGanhou() {
		if ((Tabuleiro.contadorJogador-1)%2==0) {
		
			JOptionPane.showMessageDialog(null, "O jogador X ganhou");
		
		}
		else {
			
				JOptionPane.showMessageDialog(null, "O jogador 0 ganhou");
			
		}
		botoes.stream().forEach(v-> v.reiniciarBotao());
	}
	public static void main (String[] args) {
		new telaPrincipal();
	}
	public static void empate() {
		JOptionPane.showMessageDialog(null, "Empate! :)");
		botoes.stream().forEach(v-> v.reiniciarBotao());
		
	}

	
}
