
package br.com.DAO;

import br.com.Factory.ConnectionFactory;
import br.com.Model.ModelProfessor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ProfessorDAO {
    private Connection connection;
    
    
    public ProfessorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    
    }
    
    
     public void cadastrarAluno(ModelProfessor mP) {

        String sql = "INSERT INTO tbl_prof (nome, data_nascimento, endereco, telefone, email) values (?,?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mP.getNome());
            stmt.setString(2, mP.getDataNascimento());
            stmt.setString(3, mP.getEndereco());
            stmt.setString(4, mP.getTelefone());
            stmt.setString(5, mP.getEmail());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor!", "Alerta", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(u);
        }

    }
     
        public ArrayList<ModelProfessor> pesquisarProfessores(String nome) throws Exception {
        ArrayList<ModelProfessor> listarProfessores = new ArrayList();
        try {
            String sql = "SELECT nome, data_nascimento, endereco, telefone, email FROM tbl_prof WHERE nome LIKE '%" + nome + "%';";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelProfessor mP = new ModelProfessor();
                mP.setDataNascimento(rs.getString("data_nascimento"));
                mP.setEmail(rs.getString("email"));
                mP.setEndereco(rs.getString("endereco"));
                mP.setNome(rs.getString("nome"));
                mP.setTelefone(rs.getString("telefone"));
                listarProfessores.add(mP);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar professores", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarProfessores;

    }
        
            public void apagarProfessor (ModelProfessor mP) {
       
           String sql = "DELETE FROM tbl_prof WHERE nome=? AND telefone=?";
           try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, mP.getNome());
           stmt.setString(2, mP.getTelefone());
           stmt.execute();
           stmt.close();
           } 
           catch (Exception e ) {
           JOptionPane.showMessageDialog(null, "Erro ao apagar aluno!", "ERRO", JOptionPane.ERROR_MESSAGE);
           }
           
       
       
       }
    
}
