package org.gabriel.repositorio;
import org.gabriel.execoe.NaoEncontradoExecao;
import org.gabriel.modelos.AdiministradorModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdiministradorCRUDRepositorio {

        // CREATE
        public void criar(AdiministradorModelo adiministradorModelo) {
            String sql = "INSERT INTO ADMINISTRADOR (nome, email, telefone, cpf, senha) VALUES (?, ?, ?, ?, ?)";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, adiministradorModelo.getNome());
                ps.setString(2, adiministradorModelo.getEmail());
                ps.setString(3, adiministradorModelo.getTelefone());
                ps.setString(4, adiministradorModelo.getCpf());
                ps.setString(5, adiministradorModelo.getSenha());

                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao criar administrador", e);
            }
        }

        //  READ
        public AdiministradorModelo selecionarPorCpf(String cpf) {
            String sql = "SELECT * FROM ADMINISTRADOR WHERE cpf = ?";
            AdiministradorModelo adiministradorModelo = null;
            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cpf);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        adiministradorModelo = new AdiministradorModelo(rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone"),rs.getString("email"),rs.getString("senha"));
                    }else{
                        throw new NaoEncontradoExecao("Nao foi possivel encontrar esse adiministrador");
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar administrador", e);
            }
            return adiministradorModelo;
        }

        public List<AdiministradorModelo> selecionar() {
            String sql = "SELECT * FROM ADMINISTRADOR";
            List<AdiministradorModelo> adiministradorModeloList = new LinkedList<>();
            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {


                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        adiministradorModeloList.add(new AdiministradorModelo(rs.getString("nome"),rs.getString("cpf"),rs.getString("telefone"),rs.getString("email"),rs.getString("senha")));
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar administrador", e);
            }
            return adiministradorModeloList;
        }

        // UPDATE
        public void atualizar(AdiministradorModelo adiministradorModelo) {
            String sql = "UPDATE ADMINISTRADOR SET nome=?, email=?, telefone=?, senha=? WHERE cpf=?";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, adiministradorModelo.getNome());
                ps.setString(2, adiministradorModelo.getEmail());
                ps.setString(3, adiministradorModelo.getTelefone());
                ps.setString(4, adiministradorModelo.getSenha());
                ps.setString(5, adiministradorModelo.getCpf());


                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao atualizar administrador", e);
            }
        }

        // DELETE
        public void deletar(String cpf) {
            String sql = "DELETE FROM ADMINISTRADOR WHERE cpf = ?";

            try (Connection conn = ConexaoRepositorio.connection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cpf);
                ps.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao deletar administrador", e);
            }
        }
}

