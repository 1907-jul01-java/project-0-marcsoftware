package com.revature.bank;
import java.util.Scanner;


public class Menu {
    
    String login_name="";
    DataManager session;

    public void displayCLI() {
    
        session = new DataManager();
        clearScreen(); // for consistancy
        System.out.println("---CLI---");

        Scanner reader = new Scanner(System.in);  
        
        String s = "";
        while(!s.equals("exit")){
            System.out.print(login_name+" > ");
            s = reader.nextLine(); 
            parseInput(s);
        }
        reader.close();
    }


    public   void parseInput(String cmd){
        
        //parse out args
        String[] args = cmd.split(" ");
        

        cmd = args[0];
        switch (cmd) {
            case "clear":
                clearScreen();
                break;
            
            case "print":
                printTable();
                break;
            
            case "login":
                login(args);
                break; 

            case "logout":
                logout();
                break;
            case "open":
                open();
                break;    
            case "register":
                register(args);
                break;                
            case "exit":
                System.exit(0); // added for maven
                break;
            default:
                System.out.println("command not found: "+cmd);
        }
        


    }


     void clearScreen() {  
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+
                            "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    } 

     void printTable(){
        System.out.println("________________________");

        
        session.printTable();
        System.out.println("________________________");
    }

 

 




     /**
    The Desciption of the method to explain what the method does
    @param the parameters used by the method
    @return the value returned by the method
    @throws what kind of exception does this method throw
    */
     void login(String[] args){
        
        String username=null,password=null;
        if(args.length==1){
        
            Scanner myObj = new Scanner(System.in);  
            System.out.print("Enter username: ");
            username = myObj.nextLine();  // Read user input
            
        }
        
        if(args.length==1 || args.length==2){
            
            Scanner myObj = new Scanner(System.in);  
            System.out.print("Enter password: ");
            password = myObj.nextLine();  // Read user input
            username=args[1];
            
        }
        
        if(args.length==3){

            username=args[1];
            password=args[2];
        }
        
        
        this.login_name= session.login(username,password);
        
    }

    void logout(){
        
        this.login_name=""; //refactor
         session.logout();
    }


    void open(){

        
        
         session.open();
    }

     /**
    The Desciption of the method to explain what the method does
    @param the parameters used by the method
    @return the value returned by the method
    @throws what kind of exception does this method throw
    */
    void register(String[] args){
        
        String username=null,password=null;
        if(args.length==1){
        
            Scanner myObj = new Scanner(System.in);  
            System.out.print("Enter desired username: ");
            username = myObj.nextLine();  // Read user input
            
        }
        
        if(args.length==1 || args.length==2){
            
            Scanner myObj = new Scanner(System.in);  
            System.out.print("Enter desired password: ");
            password = myObj.nextLine();  // Read user input

            username=args[1];
            
        }
        
        if(args.length==3){

            username=args[1];
            password=args[2];
        }
        
        
        
        session.register(username,password);
        
    }


}