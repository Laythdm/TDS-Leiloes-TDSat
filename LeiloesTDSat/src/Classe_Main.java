
public class Classe_Main {
    public static void main(String[] args) {
        conectaDAO n = new conectaDAO();
        n.connectDB();
        cadastroVIEW l = new cadastroVIEW();
        l.setVisible(true);
        
    }
}
