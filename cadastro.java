package Basededados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cadastro {

		public static final String cadastro = null;

		public static void main(String[] args) throws ParseException {
			String nome= null;
			String cpf= null;
			String email= null;
			String telefone= null;
			int opcao = 0;
			
			Scanner input = new Scanner(System.in);
			bancoconexao banco = new bancoconexao();
			banco.conectar();
			if(banco.estaConectado()) {
				String texto = input.nextLine();
				if(texto.isEmpty()==false) {
					System.out.println("Bem vindo(a)\n");
				}System.out.println("insira seu nome:\n");
				String n1 = input.nextLine();
				System.out.print("olá, "+n1);
				System.out.print("\ndigite uma opção\n");
				System.out.print("1 - Cadastro de clientes \n2 - Listar clientes cadastrados  \n3- Apagar cliente\n");
				
				opcao=input.nextInt();
				
				if(opcao==1) {
					//......................................................................................................................................................................................					
										
										
					//......................................................................................................................................................................................					
										
										class validaCPF {
											 public static boolean isCPF(String CPF) {
											        // considera-se erro CPF's formados por uma sequencia de numeros iguais
											        if (CPF.equals("00000000000") ||
											            CPF.equals("11111111111") ||
											            CPF.equals("22222222222") || CPF.equals("33333333333") ||
											            CPF.equals("44444444444") || CPF.equals("55555555555") ||
											            CPF.equals("66666666666") || CPF.equals("77777777777") ||
											            CPF.equals("88888888888") || CPF.equals("99999999999") ||
											            (CPF.length() != 11))
											            return(false);

											        char dig10, dig11;
											        int sm, i, r, num, peso;

											        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
											        try {
											        // Calculo do 1o. Digito Verificador
											            sm = 0;
											            peso = 10;
											            for (i=0; i<9; i++) {
											        // converte o i-esimo caractere do CPF em um numero:
											        // por exemplo, transforma o caractere '0' no inteiro 0
											        // (48 eh a posicao de '0' na tabela ASCII)
											            num = (int)(CPF.charAt(i) - 48);
											            sm = sm + (num * peso);
											            peso = peso - 1;
											            }

											            r = 11 - (sm % 11);
											            if ((r == 10) || (r == 11))
											                dig10 = '0';
											            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

											        // Calculo do 2o. Digito Verificador
											            sm = 0;
											            peso = 11;
											            for(i=0; i<10; i++) {
											            num = (int)(CPF.charAt(i) - 48);
											            sm = sm + (num * peso);
											            peso = peso - 1;
											            }

											            r = 11 - (sm % 11);
											            if ((r == 10) || (r == 11))
											                 dig11 = '0';
											            else dig11 = (char)(r + 48);

											        // Verifica se os digitos calculados conferem com os digitos informados.
											            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
											                 return(true);
											            else return(false);
											                } catch (InputMismatchException erro) {
											                return(false);
											            }
											        }

											        public static String imprimeCPF(String CPF) {
											            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
											            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
											        }
											    }
										
										while(true) {
										System.out.println("insira um Nome:\n");
										nome = input.nextLine();
											try {
												if(nome.isEmpty()==false) {
													if(nome.matches("[A-Za-z ]+")) {
														System.out.println("ok");
														break;
													}else {
														System.out.println("Digite um Nome válido");
													}
												}else {
													System.out.println("Não pode ficar vazio");
												}
											}catch(InputMismatchException e) {
												System.out.println("Digite um Nome válido");
											}
											}
										        
											    
										        while(true) {
												System.out.println("Digite seu CPF:\n");
											    cpf = input.nextLine();
											    validaCPF valcpf = new validaCPF();
													if(valcpf.isCPF(cpf)) {
														System.out.println("CPF correto, ");
														System.out.println(valcpf.isCPF(cpf));
														
													break;
													}else {
														System.out.printf("CPF incorreto, por favor digitar cpf válido");
														System.out.println(valcpf.isCPF(cpf));
													}
												 }
										        

//....................................................................................................................................
										        String nascimento= null;
												while(true)	{
												System.out.println("insira um nascimento:\n");
											    nascimento = input.nextLine();

													SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
													Date data = null;
													try {
														data = formato.parse(nascimento);
														break;
													}catch(InputMismatchException e) {
														System.out.println("Digite um data válida");
														
														}
													
												}
  //___________________________________________________________________________________________________________________________________________________
												
												while(true) {
														
														 try {
															 System.out.println("insira um email:");
																email = input.nextLine();
																if (email.isEmpty() == false) {
																		Integer.parseInt(email);
																		System.out.println("Erro. tente novemente.");
																		
																	}
																	
																 
																else {
																	System.out.println ("Esse campo deve estar preenchido");
																}
															}catch (Exception e) {
																if (email.matches("[a-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
																	break;
																} else {
																	System.out.println ("Digite um e-mail válido");
																}
																}
															}
//............................................................................................................................................
													while(true)	{
														System.out.println("insira um telefone:\n");
														 telefone = input.nextLine();
														try {
															if(telefone.isEmpty()==false) {
																if(telefone.matches("[0-9()-]+")) {
																	if(telefone.length()==11) {
																		System.out.println("ok");
																	break;}
																}else {
																	System.out.println("Digite um Nome válido");
																}
															}else {
																System.out.println("Não pode ficar vazio");
															}
														}catch(InputMismatchException e) {
															System.out.println("Digite um nome válido");
														}}
//.............................................................................................................................................
							
//.................................................................................................................................................
						banco.inserircontato(nome,cpf,nascimento,email,telefone);
													
				}
				else if(opcao==2) {
					
					banco.conectar();
					banco.listarContatos();
				}else if(opcao==3) {
					
					banco.conectar();
					Scanner input2 = new Scanner (System.in);
					System.out.println("digite o id do contato:");
					String id= input2.nextLine();
					banco.apagarcontato(id);
				}else{
					
					banco.desconectar();
					System.out.println("Não foi possivel conectar ao banco de dados");
				}
			}
			
		}

		


	
		}										