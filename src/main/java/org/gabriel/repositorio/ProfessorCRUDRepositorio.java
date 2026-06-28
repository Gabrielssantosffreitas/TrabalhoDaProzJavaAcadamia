package org.gabriel.repositorio;

import org.gabriel.execoe.NaoEncontradoExecao;
import org.gabriel.modelos.ProfessorModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProfessorCRUDRepositorio {

    // CREATE
    public void criar(ProfessorModelo professorModelo) {
        String sql = "INSERT INTO PROFESSOR (nome, email, telefone, cpf, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, professorModelo.getNome());
            ps.setString(2, professorModelo.getEmail());
            ps.setString(3, professorModelo.getTelefone());
            ps.setString(4, professorModelo.getCpf());
            ps.setString(5, professorModelo.getSenha());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar professor", e);
        }
    }

    // READ POR CPF
    public ProfessorModelo selecionarPorCpf(String cpf) {
        String sql = "SELECT * FROM PROFESSOR WHERE cpf = ?";
        ProfessorModelo professorModelo = null;

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    professorModelo = new ProfessorModelo(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else {
                    throw new NaoEncontradoExecao("Não foi possível encontrar esse professor.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar professor", e);
        }

        return professorModelo;
    }

    // READ TODOS
    public List<ProfessorModelo> selecionar() {
        String sql = "SELECT * FROM PROFESSOR";
        List<ProfessorModelo> professorModeloList = new LinkedList<>();

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                professorModeloList.add(new ProfessorModelo(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar professores", e);
        }

        return professorModeloList;
    }

    // UPDATE
    public void atualizar(ProfessorModelo professorModelo) {
        String sql = "UPDATE PROFESSOR SET nome = ?, email = ?, telefone = ?, senha = ? WHERE cpf = ?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, professorModelo.getNome());
            ps.setString(2, professorModelo.getEmail());
            ps.setString(3, professorModelo.getTelefone());
            ps.setString(4, professorModelo.getSenha());
            ps.setString(5, professorModelo.getCpf());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar professor", e);
        }
    }

    // DELETE
    public void deletar(String cpf) {
        String sql = "DELETE FROM PROFESSOR WHERE cpf = ?";

        try (Connection conn = ConexaoRepositorio.connection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cpf);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar professor", e);
        }
    }
}
