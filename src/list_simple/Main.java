package list_simple;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
       List student = new List();
       String menu[]={"Add First", "Add Last", "Add", "Size", "Print", "Last","Previous",
           "Remove First","Remove Last", "Remove" ,"Exit"};
       String name, opt;
       do{
           opt=(String)JOptionPane.showInputDialog(
                   null, //por defecto -> cuadro de dialogo
                   "Selected option", //mensaje del cuadro dialogo
                   "Main menu", //titulo del cuadro de diagolo
                   3, //tipo de imagen 0,1,2,3
                   null, //icon ninguno
                   menu, //vector con los elementos del menu
                   menu[1]); //elemento por defecto del menu    
           
           switch(opt)
           {
               case "Add First":
                   name =  JOptionPane.showInputDialog("Enter name");
                   student.AddFirst(name);
                   JOptionPane.showMessageDialog(null,"created student");
                   break;
                   
               case "Print":
                   JOptionPane.showMessageDialog(null, student.toString());
                   break;
                   
               case "Last":
                    JOptionPane.showMessageDialog(null, "The last node is: " +
                            student.Last().getData());
                    break;
                    
               case "Add Last":
                   name =  JOptionPane.showInputDialog("Enter name");
                   student.AddLast(name);
                   JOptionPane.showMessageDialog(null,"created student");
                   break;
                   
               case "Previous":
                   name =  JOptionPane.showInputDialog("Enter name");
                   Node pre = student.Previous(name);
                   if(pre==null)
                       JOptionPane.showMessageDialog(null,name + " haven´t previous or not exist");
                   else
                        JOptionPane.showMessageDialog(null, "the previous of "+ name + " is: " + pre.getData());
                   break;
                   
               case "Add":
                   name =  JOptionPane.showInputDialog("Enter name");
                   int pos;
                   do{
                       pos = Integer.parseInt(JOptionPane.showInputDialog("Enter position"));
                   }while(pos<1 || pos>student.Size()+1);                   
                   student.Add(name, pos);
                   JOptionPane.showMessageDialog(null,"created student");
                   break;
                   
               case "Size":
                   JOptionPane.showMessageDialog(null,"the size of student´s list is: " + student.Size());
                   break;
                   
               case "Remove First":
                   if(student.RemoveFirst())
                       JOptionPane.showMessageDialog(null,"deleted element ");
                   else
                       JOptionPane.showMessageDialog(null,"the list is empty");
                   break;
           }
           
       }while(!opt.equals("Exit"));
       

    }
}