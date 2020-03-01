package br.com.DAO;

import br.com.Factory.ConnectionFactory;
import br.com.Model.ModelAlunos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlunosDAO {

    private Connection connection;

    public AlunosDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public ArrayList<ModelAlunos> pesquisarAlunos(String nome) throws Exception {
        ArrayList<ModelAlunos> listarAlunos = new ArrayList();
        try {
            String sql = "SELECT nome, rm, ra,data_nascimento, endereco, telefone, data_ingresso, periodo, situacao FROM tbl_alunos WHERE nome LIKE '%" + nome + "%'ORDER BY rm DESC";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelAlunos mA = new ModelAlunos();
                mA.setNome(rs.getString("nome"));
                mA.setRM(rs.getInt("rm"));
                mA.setRA(rs.getString("ra"));
                mA.setDataNasc(rs.getString("data_nascimento"));
                mA.setEndereco(rs.getString("endereco"));
                mA.setTelefone(rs.getString("telefone"));
                mA.setDataIngresso(rs.getString("data_ingresso"));
                mA.setPeriodo(rs.getString("periodo"));
                mA.setSituacao(rs.getString("situacao"));

                listarAlunos.add(mA);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarAlunos;

    }

    public ArrayList<ModelAlunos> pesquisarAlunos_RM(String rm) throws Exception {
        ArrayList<ModelAlunos> listarAlunos = new ArrayList();
        try {
            String sql = "SELECT nome, rm, ra,data_nascimento, endereco, telefone, data_ingresso, periodo, situacao FROM tbl_alunos WHERE rm LIKE '%" + rm + "%'ORDER BY rm DESC";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelAlunos mA = new ModelAlunos();
                mA.setNome(rs.getString("nome"));
                mA.setRM(rs.getInt("rm"));
                mA.setRA(rs.getString("ra"));
                mA.setDataNasc(rs.getString("data_nascimento"));
                mA.setEndereco(rs.getString("endereco"));
                mA.setTelefone(rs.getString("telefone"));
                mA.setDataIngresso(rs.getString("data_ingresso"));
                mA.setPeriodo(rs.getString("periodo"));
                mA.setSituacao(rs.getString("situacao"));

                listarAlunos.add(mA);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarAlunos;

    }

    public ArrayList<ModelAlunos> pesquisarAlunos_RA(String ra) throws Exception {
        ArrayList<ModelAlunos> listarAlunos = new ArrayList();
        try {
            String sql = "SELECT nome, rm, ra,data_nascimento, endereco, telefone, data_ingresso, periodo, situacao FROM tbl_alunos WHERE ra LIKE '%" + ra + "%'ORDER BY rm DESC";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelAlunos mA = new ModelAlunos();
                mA.setNome(rs.getString("nome"));
                mA.setRM(rs.getInt("rm"));
                mA.setRA(rs.getString("ra"));
                mA.setDataNasc(rs.getString("data_nascimento"));
                mA.setEndereco(rs.getString("endereco"));
                mA.setTelefone(rs.getString("telefone"));
                mA.setDataIngresso(rs.getString("data_ingresso"));
                mA.setPeriodo(rs.getString("periodo"));
                mA.setSituacao(rs.getString("situacao"));

                listarAlunos.add(mA);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarAlunos;

    }

    public void cadastrarAluno(ModelAlunos mA) {

        String sql = "INSERT INTO tbl_alunos (nome, rm, ra, data_nascimento, endereco, telefone, data_ingresso, periodo, situacao) values (?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mA.getNome());
            stmt.setInt(2, mA.getRM());
            stmt.setString(3, mA.getRA());
            stmt.setString(4, mA.getDataNasc());
            stmt.setString(5, mA.getEndereco());
            stmt.setString(6, mA.getTelefone());
            stmt.setString(7, mA.getDataIngresso());
            stmt.setString(8, mA.getPeriodo());
            stmt.setString(9, mA.getSituacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno, verifique se já existe aluno com esse RM/RA", "Alerta", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(u);
        }

    }

    public void apagarAluno(ModelAlunos mA) {

        String sql = "DELETE FROM tbl_alunos WHERE nome=? AND rm=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mA.getNome());
            stmt.setInt(2, mA.getRM());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar aluno!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<ModelAlunos> pesquisarAlunos_Declaracao(String nome) throws Exception {
        ArrayList<ModelAlunos> listarAlunos = new ArrayList();
        try {
            String sql = "SELECT nome, ra FROM tbl_alunos WHERE nome LIKE '%" + nome + "%'ORDER BY rm DESC";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelAlunos mA = new ModelAlunos();
                mA.setNome(rs.getString("nome"));
                mA.setRA(rs.getString("ra"));
                listarAlunos.add(mA);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarAlunos;

    }

    public void pesquisaCampos(ModelAlunos mA) {

        String ra = mA.getRA();
        String sql = "SELECT * FROM  tbl_alunos where ra=" + ra;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mA.setDataNasc(rs.getString("data_nascimento"));
                mA.setPeriodo(rs.getString("periodo"));

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar sua busca, verifique se o RA do aluno está no sistema, caso contrário basta alterar na parte de cadastros!");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void alterarAluno(ModelAlunos mA) {
        String sql = "UPDATE tbl_alunos SET nome=?, ra=?, data_nascimento=?, endereco=?, telefone=?, data_ingresso=?, periodo=?, situacao=? WHERE rm=?";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mA.getNome());
            stmt.setString(2, mA.getRA());
            stmt.setString(3, mA.getDataNasc());
            stmt.setString(4, mA.getEndereco());
            stmt.setString(5, mA.getTelefone());
            stmt.setString(6, mA.getDataIngresso());
            stmt.setString(7, mA.getPeriodo());
            stmt.setString(8, mA.getSituacao());
            stmt.setInt(9, mA.getRM());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }

    public void retornaUltimoRM(ModelAlunos mA) {

        String sql = "SELECT rm FROM tbl_alunos ORDER BY rm DESC LIMIT 1";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mA.setRM(rs.getInt("rm"));

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar o ultimo RM cadastrado!");

            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {

        }

    }

}
