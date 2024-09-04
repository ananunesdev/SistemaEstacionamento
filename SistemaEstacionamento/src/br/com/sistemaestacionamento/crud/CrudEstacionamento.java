package br.com.sistemaestacionamento.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.sistemaestacionamento.model.Estacionamento;
import br.com.sistemaestacionamento.jdbc.ConnectionFactory;

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
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			Estacionamento estacionamento = new Estacionamento();
			
			String sql = "select * from veiculos;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			ResultSet resultado = cmd.executeQuery();
			
			String veiculos;
			
			veiculos = ".:: VEÍCULOS ENCONTRADOS ::.\n";
			
			while(resultado.next()) {
				veiculos += "ID: " + resultado.getInt("id") 
						+ "- Placa: " + resultado.getString("placa") 
						+ "- Valor: " + resultado.getFloat("valor") 
						+ "- Status: " + resultado.getString("status") 
						+ "\n ----------------------------------------\n"; 
			}
			JOptionPane.showMessageDialog(null, veiculos);
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void readone () {
		
	}
	
	public static void update () {
		
	}
	
	public static void delete () {
		
	}
}
