package Jdbc_BankingProject;

	import java.util.Scanner;

	public class Bank_View {
		static Scanner sc=new Scanner(System.in);
		public static void main(String[] args) {
			Bank_Controller controller=new Bank_Controller();
			while(true) 
			{
				System.out.println("Enter your choice");
				System.out.println("1.Insert");
				System.out.println("2.Find by id");
				System.out.println("3.Findall");
				System.out.println("4.Update email");
				System.out.println("5.Delete");
				
				int Choice=sc.nextInt();
				switch (Choice) {
				case 1:
					Bank b =createBankObject();
					controller.insert(b);
					break;
				case 2:
					System.out.println("enter id");
					controller.find(sc.nextInt());
					
					break;
				case 3:
					controller.fetchall();
					sc.nextLine();
					break;
				case 4:
					System.out.println("Enter id");
					int id =sc.nextInt();
					System.out.println("Enter new email");
					sc.nextLine();
					String newEmail=sc.nextLine();
					controller.update(id, newEmail);
					break;
				case 5:
					System.out.println("Enter id");
					controller.delete(sc.nextInt());
					break;

				default:
					System.out.println("invalid input....");
					break;

				}
			}
		}
		private static Bank createBankObject() {
			Bank b=new Bank();
			System.out.println("Enter id");
			b.setId(sc.nextInt());
			
			System.out.println("Enter name");
			sc.nextLine();
			b.setBname(sc.nextLine());
			
			System.out.println("Enter email");
			b.setEmail(sc.nextLine());
			
			System.out.println("Enter password");
			b.setPassword(sc.nextLine());
			
			System.out.println("Enter address");
			b.setAddress(sc.nextLine());
			
			
			return b;
		}

	}

