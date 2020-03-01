package br.com.DAO;

import br.com.Factory.ConnectionFactory;
import br.com.Model.ModelAlunos;
import br.com.Model.ModelHistorico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class HistoricoDAO {

    private Connection connection;

    public HistoricoDAO() {
        this.connection = new ConnectionFactory().getConnection();

    }

    public ArrayList<ModelHistorico> listarAlunos(String nome) throws Exception {
        ArrayList<ModelHistorico> listarAlunoss = new ArrayList();
        try {
            String sql = "SELECT nome, rm FROM tbl_alunos WHERE nome LIKE '%" + nome + "%'ORDER BY rm DESC;";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModelHistorico mH = new ModelHistorico();
                mH.setNome(rs.getString("nome"));
                mH.setRm(rs.getInt("rm"));

                listarAlunoss.add(mH);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar alunos", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return listarAlunoss;

    }

    public void pesquisaCampos(ModelHistorico mH) {

        int rm = mH.getRm();
        String sql = "SELECT * FROM  tbl_alunos where rm=" + rm;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setNome(rs.getString("nome"));
                mH.setRa(rs.getString("ra"));
                mH.setRm(rs.getInt("rm"));
                mH.setDataNasc(rs.getString("data_nascimento"));

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar sua busca, verifique se o RA do aluno está no sistema, caso contrário basta alterar na parte de cadastros!");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void pesquisaHistorico(ModelHistorico mH) {

        int rm = mH.getRm();
        String sql = "SELECT * FROM  tbl_historico where rm=" + rm;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setNacionalidade(rs.getString("nacionalidade"));
                mH.setNascimento(rs.getString("cidade_nascimento"));
                mH.setEstado(rs.getString("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "Indentificamos que o aluno ainda não possui registro de histórico, preencha os campos e prossiga..");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void gravaCabecalho(ModelHistorico mH) {

        String sql = "INSERT INTO tbl_historico (nome_aluno,ra,rm,cidade_nascimento,nacionalidade,data_nasc,estado) VALUES (?,?,?,?,?,?,?) ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getNome());
            stmt.setString(2, mH.getRa());
            stmt.setInt(3, mH.getRm());
            stmt.setString(4, mH.getNascimento());
            stmt.setString(5, mH.getNacionalidade());
            stmt.setString(6, mH.getDataNasc());
            stmt.setString(7, mH.getEstado());
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar dados do cabeçalho!");

        }

    }

    public void verificaRegistro(ModelHistorico mH) {
        int rm = mH.getRm();
        String sql = "SELECT * FROM tbl_historico WHERE rm = '" + rm + "' LIMIT 1";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setExistente(true);

            } else {
                mH.setExistente(false);

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void atualizaDados(ModelHistorico mH) {
        String sql = "UPDATE tbl_historico SET nome_aluno=?, ra=?, cidade_nascimento=?, nacionalidade=?, data_nasc=?, estado=? WHERE rm=?";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getNome());
            stmt.setString(2, mH.getRa());
            stmt.setString(3, mH.getNascimento());
            stmt.setString(4, mH.getNacionalidade());
            stmt.setString(5, mH.getDataNasc());
            stmt.setString(6, mH.getEstado());
            stmt.setInt(7, mH.getRm());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }

    public void atualizaNotas(ModelHistorico mH) {
        String sql = "UPDATE tbl_historico SET lp_1=?, a_1=?, edf_1=?, hist_1=?, geo_1=?, mat_1=?, cienc_1=?, ingl_1=?,"
                + "lp_2=?, a_2=?,edf_2=?,hist_2=?,geo_2=?,mat_2=?,cienc_2=?,ingl_2=?,"
                + "lp_3=?,a_3=?,edf_3=?,hist_3=?,geo_3=?,mat_3=?,cienc_3=?,ingl_3=?,"
                + "lp_4=?,a_4=?,edf_4=?,hist_4=?,geo_4=?,mat_4=?,cienc_4=?,ingl_4=?,"
                + "lp_5=?,a_5=?,edf_5=?,hist_5=?,mat_5=?,geo_5=?,ingl_5=?,cienc_5=?"
                + " WHERE rm=?";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getPrimeiroAnoLP());
            stmt.setString(2, mH.getPrimerioAnoArte());
            stmt.setString(3, mH.getPrimeiroAnoEDFisica());
            stmt.setString(4, mH.getPrimerioAnoHistoria());
            stmt.setString(5, mH.getPrimeiroAnoGeo());
            stmt.setString(6, mH.getPrimeiroAnoMat());
            stmt.setString(7, mH.getPrimeiroAnoCienc());
            stmt.setString(8, mH.getPrimeiroAnoIngl());
            // segundo ano
            stmt.setString(9, mH.getSegundoAnoLP());
            stmt.setString(10, mH.getSegundoAnoArte());
            stmt.setString(11, mH.getSegundoAnoEDFisica());
            stmt.setString(12, mH.getSegundoAnoHistoria());
            stmt.setString(13, mH.getSegundoAnoGeo());
            stmt.setString(14, mH.getSegundoAnoMat());
            stmt.setString(15, mH.getSegundoAnoCienc());
            stmt.setString(16, mH.getSegundoAnoIngl());
            // terceiro ano 
            stmt.setString(17, mH.getTerceiroAnoLP());
            stmt.setString(18, mH.getTerceiroAnoArte());
            stmt.setString(19, mH.getTerceiroAnoEDFisica());
            stmt.setString(20, mH.getTerceiroAnoHistoria());
            stmt.setString(21, mH.getTerceiroAnoGeo());
            stmt.setString(22, mH.getTerceiroAnoMat());
            stmt.setString(23, mH.getTerceiroAnoCienc());
            stmt.setString(24, mH.getTerceiroAnoIngl());
            // quarto ano 
            stmt.setString(25, mH.getQuartoAnoLP());
            stmt.setString(26, mH.getQuartoAnoArte());
            stmt.setString(27, mH.getQuartoAnoEDFisica());
            stmt.setString(28, mH.getQuartoAnoHistoria());
            stmt.setString(29, mH.getQuartoAnoGeo());
            stmt.setString(30, mH.getQuartoAnoMat());
            stmt.setString(31, mH.getQuartoAnoCienc());
            stmt.setString(32, mH.getQuartoAnoIngl());
            // quinto ano 
            stmt.setString(33, mH.getQuintoAnoLP());
            stmt.setString(34, mH.getQuintoAnoArte());
            stmt.setString(35, mH.getQuintoAnoEDFisica());
            stmt.setString(36, mH.getQuintoAnoHistoria());
            stmt.setString(37, mH.getQuintoAnoMat());
            stmt.setString(38, mH.getQuintoAnoGeo());
            stmt.setString(39, mH.getQuintoAnoIngl());
            stmt.setString(40, mH.getQuintoAnoCienc());

            stmt.setInt(41, mH.getRm());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }

    public void atualizaBimestre(ModelHistorico mH) {
        String sql = "UPDATE tbl_historico SET lp1b=?, a1b=?, edf1b=?, hist1b=?, geo1b=?, mat1b=?, cienc1b=?, ingl1b=?,"
                + "lp2b=?, a2b=?,edf2b=?,hist2b=?,geo2b=?,mat2b=?,cienc2b=?,ingl2b=?,"
                + "lp3b=?,a3b=?,edf3b=?,hist3b=?,geo3b=?,mat3b=?,cienc3b=?,ingl3b=?,"
                + "lp4b=?,a4b=?,edf4b=?,hist4b=?,geo4b=?,mat4b=?,cienc4b=?,ingl4b=?"
                + " WHERE rm=?";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getPrimeiroBimestreLP());
            stmt.setString(2, mH.getPrimeiroBimestreArte());
            stmt.setString(3, mH.getPrimeiroBimestreEDFisica());
            stmt.setString(4, mH.getPrimeiroBimestreHistoria());
            stmt.setString(5, mH.getPrimeiroBimestreGeo());
            stmt.setString(6, mH.getPrimeiroBimestreMat());
            stmt.setString(7, mH.getPrimeiroBimestreCienc());
            stmt.setString(8, mH.getPrimeiroBimestreIngl());

            // segundo bimestre
            stmt.setString(9, mH.getSegundoBimestreLP());
            stmt.setString(10, mH.getSegundoBimestreArte());
            stmt.setString(11, mH.getSegundoBimestreEDFisica());
            stmt.setString(12, mH.getSegundoBimestreHistoria());
            stmt.setString(13, mH.getSegundoBimestreGeo());
            stmt.setString(14, mH.getSegundoBimestreMat());
            stmt.setString(15, mH.getSegundoBimestreCienc());
            stmt.setString(16, mH.getSegundoBimestreIngl());
            // terceiro bimestre 
            stmt.setString(17, mH.getTerceiroBimestreLP());
            stmt.setString(18, mH.getTerceiroBimestreArte());
            stmt.setString(19, mH.getTerceiroBimestreEDFisica());
            stmt.setString(20, mH.getTerceiroBimestreHistoria());
            stmt.setString(21, mH.getTerceiroBimestreGeo());
            stmt.setString(22, mH.getTerceiroBimestreMat());
            stmt.setString(23, mH.getTerceiroBimestreCienc());
            stmt.setString(24, mH.getTerceiroBimestreIngl());
            // quarto bimestre
            stmt.setString(25, mH.getQuartoBimestreLP());
            stmt.setString(26, mH.getQuartoBimestreArte());
            stmt.setString(27, mH.getQuartoBimestreEDFisica());
            stmt.setString(28, mH.getQuartoBimestreHistoria());
            stmt.setString(29, mH.getQuartoBimestreGeo());
            stmt.setString(30, mH.getQuartoBimestreMat());
            stmt.setString(31, mH.getQuartoBimestreCienc());
            stmt.setString(32, mH.getQuartoBimestreIngl());

            stmt.setInt(33, mH.getRm());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }

    public void pesquisaNotas(ModelHistorico mH) {

        int rm = mH.getRm();
        String sql = "SELECT * FROM  tbl_historico where rm=" + rm;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setPrimeiroAnoLP(rs.getString("lp_1"));
                mH.setPrimerioAnoArte(rs.getString("a_1"));
                mH.setPrimeiroAnoEDFisica(rs.getString("edf_1"));
                mH.setPrimerioAnoHistoria(rs.getString("hist_1"));
                mH.setPrimeiroAnoGeo(rs.getString("geo_1"));
                mH.setPrimeiroAnoMat(rs.getString("mat_1"));
                mH.setPrimeiroAnoCienc(rs.getString("cienc_1"));
                mH.setPrimeiroAnoIngl(rs.getString("ingl_1"));

                mH.setSegundoAnoLP(rs.getString("lp_2"));
                mH.setSegundoAnoArte(rs.getString("a_2"));
                mH.setSegundoAnoEDFisica(rs.getString("edf_2"));
                mH.setSegundoAnoHistoria(rs.getString("hist_2"));
                mH.setSegundoAnoGeo(rs.getString("geo_2"));
                mH.setSegundoAnoMat(rs.getString("mat_2"));
                mH.setSegundoAnoCienc(rs.getString("cienc_2"));
                mH.setSegundoAnoIngl(rs.getString("ingl_2"));

                mH.setTerceiroAnoLP(rs.getString("lp_3"));
                mH.setTerceiroAnoArte(rs.getString("a_3"));
                mH.setTerceiroAnoEDFisica(rs.getString("edf_3"));
                mH.setTerceiroAnoHistoria(rs.getString("hist_3"));
                mH.setTerceiroAnoGeo(rs.getString("geo_3"));
                mH.setTerceiroAnoMat(rs.getString("mat_3"));
                mH.setTerceiroAnoCienc(rs.getString("cienc_3"));
                mH.setTerceiroAnoIngl(rs.getString("ingl_3"));

                mH.setQuartoAnoLP(rs.getString("lp_4"));
                mH.setQuartoAnoArte(rs.getString("a_4"));
                mH.setQuartoAnoEDFisica(rs.getString("edf_4"));
                mH.setQuartoAnoHistoria(rs.getString("hist_4"));
                mH.setQuartoAnoGeo(rs.getString("geo_4"));
                mH.setQuartoAnoMat(rs.getString("mat_4"));
                mH.setQuartoAnoCienc(rs.getString("cienc_4"));
                mH.setQuartoAnoIngl(rs.getString("ingl_4"));

                mH.setQuintoAnoLP(rs.getString("lp_5"));
                mH.setQuintoAnoArte(rs.getString("a_5"));
                mH.setQuintoAnoEDFisica(rs.getString("edf_5"));
                mH.setQuintoAnoHistoria(rs.getString("hist_5"));
                mH.setQuintoAnoGeo(rs.getString("geo_5"));
                mH.setQuintoAnoMat(rs.getString("mat_5"));
                mH.setQuintoAnoCienc(rs.getString("cienc_5"));
                mH.setQuintoAnoIngl(rs.getString("ingl_5"));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar sua busca!");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void pesquisaBimestres(ModelHistorico mH) {

        int rm = mH.getRm();
        String sql = "SELECT * FROM  tbl_historico where rm=" + rm;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setPrimeiroBimestreLP(rs.getString("lp1b"));
                mH.setPrimeiroBimestreArte(rs.getString("a1b"));
                mH.setPrimeiroBimestreEDFisica(rs.getString("edf1b"));
                mH.setPrimeiroBimestreHistoria(rs.getString("hist1b"));
                mH.setPrimeiroBimestreGeo(rs.getString("geo1b"));
                mH.setPrimeiroBimestreMat(rs.getString("mat1b"));
                mH.setPrimeiroBimestreCienc(rs.getString("cienc1b"));
                mH.setPrimeiroBimestreIngl(rs.getString("ingl1b"));

                mH.setSegundoBimestreLP(rs.getString("lp2b"));
                mH.setSegundoBimestreArte(rs.getString("a2b"));
                mH.setSegundoBimestreEDFisica(rs.getString("edf2b"));
                mH.setSegundoBimestreHistoria(rs.getString("hist2b"));
                mH.setSegundoBimestreGeo(rs.getString("geo2b"));
                mH.setSegundoBimestreMat(rs.getString("mat2b"));
                mH.setSegundoBimestreCienc(rs.getString("cienc2b"));
                mH.setSegundoBimestreIngl(rs.getString("ingl2b"));

                mH.setTerceiroBimestreLP(rs.getString("lp3b"));
                mH.setTerceiroBimestreArte(rs.getString("a3b"));
                mH.setTerceiroBimestreEDFisica(rs.getString("edf3b"));
                mH.setTerceiroBimestreHistoria(rs.getString("hist3b"));
                mH.setTerceiroBimestreGeo(rs.getString("geo3b"));
                mH.setTerceiroBimestreMat(rs.getString("mat3b"));
                mH.setTerceiroBimestreCienc(rs.getString("cienc3b"));
                mH.setTerceiroBimestreIngl(rs.getString("ingl3b"));

                mH.setQuartoBimestreLP(rs.getString("lp4b"));
                mH.setQuartoBimestreArte(rs.getString("a4b"));
                mH.setQuartoBimestreEDFisica(rs.getString("edf4b"));
                mH.setQuartoBimestreHistoria(rs.getString("hist4b"));
                mH.setQuartoBimestreGeo(rs.getString("geo4b"));
                mH.setQuartoBimestreMat(rs.getString("mat4b"));
                mH.setQuartoBimestreCienc(rs.getString("cienc4b"));
                mH.setQuartoBimestreIngl(rs.getString("ingl4b"));

            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar sua busca!");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void atualizaRodaPe(ModelHistorico mH) {

        String sql = "UPDATE tbl_historico SET ano1=?,serie1=?,escola1=?,cidade1=?,estado1=?,"
                + "ano2=?,serie2=?,escola2=?,cidade2=?,estado2=?,"
                + "ano3=?,serie3=?,escola3=?,cidade3=?,estado3=?,"
                + "ano4=?,serie4=?,escola4=?,cidade4=?,estado4=?,"
                + "ano5=?,serie5=?,escola5=?,cidade5=?,estado5=?, aptoACursar=?, ensino=?, anoConcluido=?, letivoConcluido=? WHERE rm = ? ";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getAno1());
            stmt.setString(2, mH.getSerei1());
            stmt.setString(3, mH.getEscola1());
            stmt.setString(4, mH.getCidade1());
            stmt.setString(5, mH.getEstado1());

            stmt.setString(6, mH.getAno2());
            stmt.setString(7, mH.getSerei2());
            stmt.setString(8, mH.getEscola2());
            stmt.setString(9, mH.getCidade2());
            stmt.setString(10, mH.getEstado2());

            stmt.setString(11, mH.getAno3());
            stmt.setString(12, mH.getSerei3());
            stmt.setString(13, mH.getEscola3());
            stmt.setString(14, mH.getCidade3());
            stmt.setString(15, mH.getEstado3());

            stmt.setString(16, mH.getAno4());
            stmt.setString(17, mH.getSerei4());
            stmt.setString(18, mH.getEscola4());
            stmt.setString(19, mH.getCidade4());
            stmt.setString(20, mH.getEstado4());

            stmt.setString(21, mH.getAno5());
            stmt.setString(22, mH.getSerei5());
            stmt.setString(23, mH.getEscola5());
            stmt.setString(24, mH.getCidade5());
            stmt.setString(25, mH.getEstado5());
            
            stmt.setString(26, mH.getAptoACursar());
            stmt.setString(27, mH.getEnsino());
            stmt.setString(28, mH.getAnoConcluido());
            stmt.setString(29, mH.getLetivoConcluido());
            
            stmt.setInt(30, mH.getRm());

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }
    
    
    public void pesquisaRodaPe(ModelHistorico mH) {
    
        int rm = mH.getRm();
        String sql = "SELECT * FROM tbl_historico WHERE rm =" +rm;
         try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                mH.setAno1(rs.getString("ano1"));
                mH.setSerei1(rs.getString("serie1"));
                mH.setEscola1(rs.getString("escola1"));
                mH.setCidade1(rs.getString("cidade1"));
                mH.setEstado1(rs.getString("estado1"));
                
                mH.setAno2(rs.getString("ano2"));
                mH.setSerei2(rs.getString("serie2"));
                mH.setEscola2(rs.getString("escola2"));
                mH.setCidade2(rs.getString("cidade2"));
                mH.setEstado2(rs.getString("estado2"));
                
                mH.setAno3(rs.getString("ano3"));
                mH.setSerei3(rs.getString("serie3"));
                mH.setEscola3(rs.getString("escola3"));
                mH.setCidade3(rs.getString("cidade3"));
                mH.setEstado3(rs.getString("estado3"));
                
                mH.setAno4(rs.getString("ano4"));
                mH.setSerei4(rs.getString("serie4"));
                mH.setEscola4(rs.getString("escola4"));
                mH.setCidade4(rs.getString("cidade4"));
                mH.setEstado4(rs.getString("estado4"));
                
                mH.setAno5(rs.getString("ano5"));
                mH.setSerei5(rs.getString("serie5"));
                mH.setEscola5(rs.getString("escola5"));
                mH.setCidade5(rs.getString("cidade5"));
                mH.setEstado5(rs.getString("estado5"));
                
                mH.setAptoACursar(rs.getString("aptoACursar"));
                mH.setEnsino(rs.getString("ensino"));
                mH.setAnoConcluido(rs.getString("anoConcluido"));
                mH.setLetivoConcluido(rs.getString("letivoConcluido"));
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel retornar sua busca!");

            }
            stmt.close();
            rs.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
     public void atualizaDados_Aluno(ModelHistorico mH) {
        String sql = "UPDATE tbl_alunos SET nome=?,ra=?, data_nascimento=? WHERE rm=?";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mH.getNome());
            stmt.setString(2, mH.getRa());
            stmt.setString(3, mH.getDataNasc());
            stmt.setInt(4, mH.getRm());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        }

    }

}
