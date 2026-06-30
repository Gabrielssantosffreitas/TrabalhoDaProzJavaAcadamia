package org.gabriel.repositorio;

import org.gabriel.modelos.ExercicioModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExercicioCRUDRepositorio {

    // CREATE
    public void criar(ExercicioModelo exercicio) {
        String sql = "INSERT INTO exercicio (plano_id, nome, series, repeticoes) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, exercicio.getPlanoId());
            ps.setString(2, exercicio.getNome());
            ps.setInt(3, exercicio.getSeries());
            ps.setInt(4, exercicio.getRepeticoes());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar exercício", e);
        }
    }

    // SELECT POR ID
    public ExercicioModelo selecionarPorId(int id) {
        String sql = "SELECT * FROM exercicio WHERE id = ?";
        ExercicioModelo exercicio = null;

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    exercicio = new ExercicioModelo(
                            rs.getInt("id"),
                            rs.getInt("plano_id"),
                            rs.getString("nome"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar exercício", e);
        }

        return exercicio;
    }

    // SELECT POR ALUNO (JOIN)
    public List<ExercicioModelo> selecionarPorAluno(int alunoId) {
        String sql =
                "SELECT e.* " +
                "FROM exercicio e " +
                "INNER JOIN plano_de_treino p ON e.plano_id = p.id " +
                "WHERE p.aluno_id = ?";

        List<ExercicioModelo> lista = new LinkedList<>();

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, alunoId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new ExercicioModelo(
                            rs.getInt("id"),
                            rs.getInt("plano_id"),
                            rs.getString("nome"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar exercícios por aluno", e);
        }

        return lista;
    }

    // UPDATE
    public void atualizar(ExercicioModelo exercicio) {
        String sql = "UPDATE exercicio SET nome=?, series=?, repeticoes=? WHERE id=?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, exercicio.getNome());
            ps.setInt(2, exercicio.getSeries());
            ps.setInt(3, exercicio.getRepeticoes());
            ps.setInt(4, exercicio.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar exercício", e);
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM exercicio WHERE id = ?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar exercício", e);
        }
    }
}