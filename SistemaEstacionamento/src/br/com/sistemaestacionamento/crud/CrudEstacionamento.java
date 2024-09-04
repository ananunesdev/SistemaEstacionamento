package br.com.sistemaestacionamento.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.sistemaestacionamento.jdbc.ConnectionFactory;
import br.com.sistemaestacionamento.model.Estacionamento;

public class CrudEstacionamento {
	
	public static void create () {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			Estacionamento estacionamento = new Estacionamento();
			
			estacionamento.setPlaca(JOptionPane.showInputDialog("Placa do Veículo: "));
			String[] status = {
					"[0] Ausente",
					"[1] Presente",
			};
			
			
			String statusSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o status do veículo: ", "Status do Veículo: ", JOptionPane.QUESTION_MESSAGE, null, status, status[0]); 
			
			estacionamento.setStatus(statusSelecionado);
			
			String sql = "INSERT INTO veiculos(placa, status) VALUES (?,?);";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, estacionamento.getPlaca());
			cmd.setString(2, estacionamento.getStatus());
			
			cmd.execute();
			JOptionPane.showMessageDialog(null, "Veículo Inserido!");
			cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void read () {
		
	}
	
	public static void readone () {
		
	}
	
	public static void update () {
		
	}
	
	public static void delete () {
		
	}
}
