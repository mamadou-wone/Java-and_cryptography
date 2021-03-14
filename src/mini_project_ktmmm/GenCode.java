package mini_project_ktmmm;
import java.util.*; 
class GenCode {
    
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
    
    public String ChooseLetter(String prenom, String nom, String numero){
            String num = "";
            String code ="";
        try {
            char[] prenom_list = ConcateElement(prenom).toCharArray();
            char[] nom_list = ConcateElement(nom).toCharArray();
            char[] num_list = ConcateElement(numero).toCharArray();
  

            int max_num_prenom = prenom_list.length;
            int max_num_nom = nom_list.length;
            int max_num = num_list.length;
            int NomPosition = PositionNum(max_num_nom);
            int PrenomPosition = PositionNum(max_num_prenom);
            int NumeroPosion;
            for (int i = 0; i < 6; i++) {
                NumeroPosion = PositionNum(max_num);
                num += num_list[NumeroPosion];
            }
            code += num + prenom_list[PrenomPosition] + nom_list[NomPosition];
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite "+ e.getMessage());
        }
        return code;
    }
}

    
