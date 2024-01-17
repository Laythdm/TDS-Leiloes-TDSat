/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    public void cadastrarProduto(ProdutosDTO produto) {

        try {

            conectaDAO db = new conectaDAO();
            db.connectDB();

            String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
            PreparedStatement consulta = db.connectDB().prepareStatement(sql);
            consulta.setString(1, produto.getNome());
            consulta.setInt(2, produto.getValor());
            consulta.setString(3, produto.getStatus());

            consulta.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");

        } catch (SQLException e) {
            System.out.println("erro ao cadastrar");
        }

    }

    public static ArrayList<ProdutosDTO> listar() {
        ArrayList<ProdutosDTO> f = new ArrayList<ProdutosDTO>();
        try {
            conectaDAO db = new conectaDAO();
            db.connectDB();

            String sql = "SELECT * FROM produtos";
            PreparedStatement consulta = db.connectDB().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                ProdutosDTO cad = new ProdutosDTO();
                cad.setId(resposta.getInt("id"));
                cad.setNome(resposta.getString("nome"));
                cad.setValor(resposta.getInt("valor"));
                cad.setStatus(resposta.getString("status"));

                f.add(cad);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar");

        }
        return f;
    }

    public static void venderProduto(int id) {
        try {

            conectaDAO db = new conectaDAO();
            db.connectDB();

            String slq = "UPDATE produtos SET status=? WHERE id=?;";
            PreparedStatement consulta = db.connectDB().prepareStatement(slq);
            consulta.setString(1, "Vendido");
            consulta.setInt(2,id);

            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sucesso na venda");

        } catch (SQLException e) {
            System.out.println("erro ao atualizar status");
        }

    }

    public static ArrayList<ProdutosDTO> listarPorvenda() {
        ArrayList<ProdutosDTO> f = new ArrayList<ProdutosDTO>();
        try {
            conectaDAO db = new conectaDAO();
            db.connectDB();

            String sql = "SELECT * FROM produtos WHERE status='Vendido'";
            PreparedStatement consulta = db.connectDB().prepareStatement(sql);
            ResultSet resposta = consulta.executeQuery();

            while (resposta.next()) {
                ProdutosDTO cad = new ProdutosDTO();
                cad.setId(resposta.getInt("id"));
                cad.setNome(resposta.getString("nome"));
                cad.setValor(resposta.getInt("valor"));
                cad.setStatus(resposta.getString("status"));

                f.add(cad);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar");

        }
        return f;
    }

}
