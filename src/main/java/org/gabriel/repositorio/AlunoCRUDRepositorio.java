package org.gabriel.repositorio;
import org.gabriel.execoe.NaoEncontradoExecao;
import org.gabriel.modelos.AlunoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AlunoCRUDRepositorio {





        // CREATE
        public void criar(AlunoModelo alunoModelo) {
            String sql = "INSERT INTO ALUNO (nome, email, telefone, cpf, senha) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, alunoModelo.getNome());
                ps.setString(2, alunoModelo.getEmail());
                ps.setString(3, alunoModelo.getTelefone());
                ps.setString(4, alunoModelo.getCpf());
                ps.setString(5, alunoModelo.getSenha());

                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao criar aluno", e);
            }
        }

        // READ POR CPF
        public AlunoModelo selecionarPorCpf(String cpf) {
            String sql = "SELECT * FROM ALUNO WHERE cpf = ?";
            AlunoModelo alunoModelo = null;

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cpf);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        alunoModelo = new AlunoModelo(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("cpf"),
                                rs.getString("telefone"),
                                rs.getString("email"),
                                rs.getString("senha")
                        );
                    } else {
                        throw new NaoEncontradoExecao("Não foi possível encontrar esse aluno.");
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar aluno", e);
            }

            return alunoModelo;
        }

        // READ TODOS
        public List<AlunoModelo> selecionar() {
            String sql = "SELECT * FROM ALUNO";
            List<AlunoModelo> alunoModeloList = new LinkedList<>();

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    alunoModeloList.add(new AlunoModelo(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    ));
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar alunos", e);
            }

            return alunoModeloList;
        }

        // UPDATE
        public void atualizar(AlunoModelo alunoModelo) {
            String sql = "UPDATE ALUNO SET nome = ?, email = ?, telefone = ?, senha = ? WHERE cpf = ?";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, alunoModelo.getNome());
                ps.setString(2, alunoModelo.getEmail());
                ps.setString(3, alunoModelo.getTelefone());
                ps.setString(4, alunoModelo.getSenha());
                ps.setString(5, alunoModelo.getCpf());

                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao atualizar aluno", e);
            }
        }

        // DELETE
        public void deletar(String cpf) {
            String sql = "DELETE FROM ALUNO WHERE cpf = ?";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cpf);

                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao deletar aluno", e);
            }
        }
}

