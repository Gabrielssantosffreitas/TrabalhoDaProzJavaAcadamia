package org.gabriel.repositorio;

import org.gabriel.execoe.NaoEncontradoExecao;
import org.gabriel.modelos.PlanoDeTreinoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PlanoDeTreinoCRUDRepositorio {

    // CREATE
    public void criar(PlanoDeTreinoModelo plano) {
        String sql = "INSERT INTO plano_de_treino " +
                "(aluno_id, professor_id, data_criacao, data_inicio, data_fim, descricao) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, plano.getAlunoId());
            ps.setInt(2, plano.getProfessorId());
            ps.setDate(3, java.sql.Date.valueOf(plano.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(plano.getDataInicio()));
            ps.setDate(5, java.sql.Date.valueOf(plano.getDataFim()));
            ps.setString(6, plano.getDescricao());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar plano de treino", e);
        }
    }

    // SELECT POR ID
    public PlanoDeTreinoModelo selecionarPorId(int id) {
        String sql = "SELECT * FROM plano_de_treino WHERE id = ?";
        PlanoDeTreinoModelo plano = null;

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    plano = new PlanoDeTreinoModelo(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("professor_id"),
                            rs.getDate("data_criacao").toLocalDate(),
                            rs.getDate("data_inicio").toLocalDate(),
                            rs.getDate("data_fim").toLocalDate(),
                            rs.getString("descricao")
                    );
                } else {
                    throw new NaoEncontradoExecao("Plano de treino não encontrado.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar plano de treino", e);
        }

        return plano;
    }

    // SELECT POR ALUNO
    public List<PlanoDeTreinoModelo> selecionarPorAluno(int alunoId) {
        String sql = "SELECT * FROM plano_de_treino WHERE aluno_id = ?";
        List<PlanoDeTreinoModelo> lista = new LinkedList<>();

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, alunoId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new PlanoDeTreinoModelo(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("professor_id"),
                            rs.getDate("data_criacao").toLocalDate(),
                            rs.getDate("data_inicio").toLocalDate(),
                            rs.getDate("data_fim").toLocalDate(),
                            rs.getString("descricao")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar planos por aluno", e);
        }

        return lista;
    }

    // SELECT POR PROFESSOR
    public List<PlanoDeTreinoModelo> selecionarPorProfessor(int professorId) {
        String sql = "SELECT * FROM plano_de_treino WHERE professor_id = ?";
        List<PlanoDeTreinoModelo> lista = new LinkedList<>();

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, professorId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new PlanoDeTreinoModelo(
                            rs.getInt("id"),
                            rs.getInt("aluno_id"),
                            rs.getInt("professor_id"),
                            rs.getDate("data_criacao").toLocalDate(),
                            rs.getDate("data_inicio").toLocalDate(),
                            rs.getDate("data_fim").toLocalDate(),
                            rs.getString("descricao")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar planos por professor", e);
        }

        return lista;
    }

    // UPDATE
    public void atualizar(PlanoDeTreinoModelo plano) {
        String sql = "UPDATE plano_de_treino SET aluno_id=?, professor_id=?, data_inicio=?, data_fim=?, descricao=? WHERE id=?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, plano.getAlunoId());
            ps.setInt(2, plano.getProfessorId());
            ps.setDate(3, java.sql.Date.valueOf(plano.getDataInicio()));
            ps.setDate(4, java.sql.Date.valueOf(plano.getDataFim()));
            ps.setString(5, plano.getDescricao());
            ps.setInt(6, plano.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar plano de treino", e);
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM plano_de_treino WHERE id = ?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar plano de treino", e);
        }
    }
}
