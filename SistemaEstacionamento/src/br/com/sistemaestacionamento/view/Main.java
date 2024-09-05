package br.com.sistemaestacionamento.view;

import javax.swing.JOptionPane;

import br.com.sistemaestacionamento.crud.CrudEstacionamento;

public class Main {
	//import all classes
	public static void main(String[] args) {
		CrudEstacionamento crudEstacionamento = new CrudEstacionamento();
		
		int opcao = 0;
		
		while(opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, 
					".:: ESTACIONAMENTO 24H ::. \n" + 
					"1: Cadastramento \n" +
					"2: Listagem Geral \n" +
					"3: Listagem Única \n" +
					"4: Atualizar Info \n" +
					"5: Deletar Info \n" +
					"6: Selecionar Registro \n" +
					"9: Finalizar Programa \n"
					));
			switch(opcao) {
			case 1:
				crudEstacionamento.create();
			break;
			case 2:
				crudEstacionamento.read();
			break;
			case 3:
				crudEstacionamento.readone();
			break;
			case 4:
				crudEstacionamento.update();
			break;
			case 5:
				crudEstacionamento.delete();
			break;
			case 6:
				crudEstacionamento.select();
			break;
			case 9:
				 System.exit(0);
			break;
			default:
				JOptionPane.showConfirmDialog(null, "Entre com uma opção válida!");
			
			
			}
			
		}
	}

}