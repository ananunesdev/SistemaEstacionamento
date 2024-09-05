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
					"0",
					"1",
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
						+ "\n ----------------------------------------\n"; 
			}
			JOptionPane.showMessageDialog(null, veiculos);
			cmd.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void readone () {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			Estacionamento estacionamento = new Estacionamento();
			
			estacionamento.setPlaca(JOptionPane.showInputDialog("Insira a placa: "));
			
			String sql = "select * from veiculos where placa = ?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			cmd.setString(1, estacionamento.getPlaca());
			ResultSet resultado = cmd.executeQuery();
		
			String veiculos;
		
			veiculos = ".:: VEÍCULO ENCONTRADO ::.\n";
		
			while(resultado.next()) {
				veiculos += "ID: " + resultado.getInt("id") 
						+ "- Placa: " + resultado.getString("placa") 
						+ "\n ----------------------------------------\n"
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
	
	public static void update () {
		try {
			Connection conexao = ConnectionFactory.createConnection();
	        Estacionamento estacionamento = new Estacionamento();
	        
	        estacionamento.setPlaca(JOptionPane.showInputDialog("Placa do Veículo: "));
	        estacionamento.setValor(Float.parseFloat(JOptionPane.showInputDialog("Valor do tempo estacionado: ")));
	        String[] status = {
	                "0",
	                "1",
	        };
	        
	        String statusSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o status do veículo: ", "Status do Veículo: ", JOptionPane.QUESTION_MESSAGE, null, status, status[0]); 
	        
	        estacionamento.setStatus(statusSelecionado);
	        
	        String sql = "UPDATE veiculos SET valor=?, status=? WHERE placa=?;";
	        
	        PreparedStatement cmd = conexao.prepareStatement(sql);
	        cmd.setFloat(1, estacionamento.getValor());  // Atualiza o valor
	        cmd.setString(2, estacionamento.getStatus()); // Atualiza o status
	        cmd.setString(3, estacionamento.getPlaca());  // Usa a placa no WHERE para encontrar o veículo
	        
	        cmd.execute();
	        JOptionPane.showMessageDialog(null, "Veículo Atualizado!");
	        cmd.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void delete () {
		try {
			Connection conexao = ConnectionFactory.createConnection();
	        Estacionamento estacionamento = new Estacionamento();
	        
	        estacionamento.setPlaca(JOptionPane.showInputDialog("Placa do Veículo: "));
	        String sql = "delete from veiculos where placa = ?;";
	        
	        PreparedStatement cmd = conexao.prepareStatement(sql);
	        cmd.setString(1, estacionamento.getPlaca());
	        
	        cmd.execute();
	        JOptionPane.showMessageDialog(null, "Veículo deletado com sucesso!");
			cmd.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}
