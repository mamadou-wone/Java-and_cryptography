package mini_project_ktmmm;
import java.util.*; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.BreakNode;
class GenCode {
    public static String letters [] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"};
    
    public boolean thioro;
    public String ShuffleLetter(String code){
    char[] code_list = code.toCharArray();
    String NewCode = "";
    ArrayList<Character> CodeList = new ArrayList<>();
        for (int i = 0; i < code_list.length; i++) {
            CodeList.add(code_list[i]);
        }
        Collections.shuffle(CodeList);
     for(char index: CodeList){
         NewCode += index;
     }
       return NewCode;
    }
    
    public int PositionNum(int max_num){
        int NumeroPosion = (int) Math.round(Math.random() * (max_num - 1));
        return NumeroPosion;
    }

    public String ConcateElement(String element){
        Boolean isPresent = element.contains(" ");
        String NewString = "";
        if (isPresent) {
            NewString = element.replace(" ",  "");
        }else{
            NewString = element;
        }
        return NewString;
    }
    
    public boolean verifLetters(char[] list){
       boolean retour = false;
        ArrayList<String> allLettList = new ArrayList<String>();
        for (String letter : letters) {
            allLettList.add(letter);
        }
        for (Character c : list) {
            if (allLettList.contains(Character.toString(c).toLowerCase())) {
                retour = true;
            }else{
            retour = false;
                 JFrame jFrame = new JFrame();
                 JOptionPane.showMessageDialog(jFrame, "Les Champs nom et prenom ne doivent contenir que des lettres","ATTENTION!", JOptionPane.WARNING_MESSAGE);
                 break;
            }
        }
        
        return retour;
    }
    
    public boolean verifNumber(char[] num_list){
         boolean retour = false;
         ArrayList<Integer> allNum = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            allNum.add(i);
        }
         if(num_list.length != 9){
               System.out.println("Respecter les données de saisie");
                 JFrame jFrame = new JFrame();
                 JOptionPane.showMessageDialog(jFrame, "Respecter les Données dans le champ numéro","ATTENTION!", JOptionPane.WARNING_MESSAGE);
          
               retour = false;
            }else {
                for (Character index:num_list){
                    if (allNum.contains(Character.getNumericValue(index))){
                        retour = true;
                        System.out.println(index + " est à l'index numero " + allNum.indexOf(Character.getNumericValue(index)));
                    }else {
                        retour = false;
                       
                    }
                }
            }
         return retour;
    }
    
    public String ChooseLetter(String prenom, String nom, String numero){
            String num = "";
            String code ="";
        try {
            char[] prenom_list = ConcateElement(prenom).toCharArray();
            char[] nom_list = ConcateElement(nom).toCharArray();
            char[] num_list = ConcateElement(numero).toCharArray();
            
            boolean verif = verifNumber(num_list);
            char newNumList[] = null;
            boolean start = true;
            if (verif) {
                this.thioro = true;
                newNumList = num_list;
            }else{
                this.thioro = false;
            }

            int max_num_prenom = prenom_list.length;
            int max_num_nom = nom_list.length;
            int max_num = newNumList.length;
            int NomPosition = PositionNum(max_num_nom);
            int PrenomPosition = PositionNum(max_num_prenom);
            int NumeroPosion;
            for (int i = 0; i < 6; i++) {
                NumeroPosion = PositionNum(max_num);
                num += newNumList[NumeroPosion];
            }
            code += num + prenom_list[PrenomPosition] + nom_list[NomPosition];
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite "+ e.getMessage());
        }
        return code;
    }
}

    
