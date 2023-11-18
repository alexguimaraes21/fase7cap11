package br.com.fiap.fase7cap11.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fase7cap11.models.Conta;
import br.com.fiap.fase7cap11.models.Lancamento;
import br.com.fiap.fase7cap11.models.TipoInvestimento;
import br.com.fiap.fase7cap11.models.TipoLancamento;
import br.com.fiap.fase7cap11.models.Usuario;
import br.com.fiap.fase7cap11.utils.DbConnection;

public class LancamentoDao implements ICrudDao<Lancamento> {
	
	private Connection getConnection() throws SQLException {
		return DbConnection.getConnection();
	}

	@Override
	public List<Lancamento> getAll() {
		
		List<Lancamento> contas = new ArrayList<Lancamento>();
		String sql = "SELECT TL.cd_lancamento, TL.vl_lancamento, TL.dt_lancamento, TL.ds_lancamento, "
				+ "TTL.cd_tipo, TTL.ds_tipo, "
				+ "TU.cd_usuario, TU.vl_cpf_usuario, TU.nm_usuario, TU.ck_usuario_ativo, TU.ds_email, "
				+ "TC.cd_conta, TC.vl_agencia, TC.vl_conta, TC.vl_banco, "
				+ "TCU.cd_usuario AS conta_usuario, TCU.vl_cpf_usuario AS conta_usuario_cpf, TCU.nm_usuario AS conta_usuario_nome, "
				+ "TCU.ck_usuario_ativo AS conta_usuario_ativo, TCU.ds_email AS conta_usuario_email, "
				+ "TTI.cd_tipo_investimento, TTI.ds_tipo_investimento, TTI.vl_rendimento_mensal, TTI.prazo_minimo_investimento "
				+ "FROM T_LANCAMENTO TL "
				+ "INNER JOIN T_CONTA TC ON TC.cd_conta = TL.cd_conta "
				+ "INNER JOIN T_USUARIO TCU ON TCU.cd_usuario = TC.cd_usuario "
				+ "INNER JOIN T_TIPO_LANCAMENTO TTL ON TTL.cd_tipo = TL.cd_tipo "
				+ "LEFT JOIN T_TIPO_INVESTIMENTO TTI ON TTI.cd_tipo_investimento = TL.cd_tipo_investimento "
				+ "INNER JOIN T_USUARIO TU ON TU.cd_usuario = TL.cd_usuario "
				+ "ORDER BY cd_lancamento ASC";
		try(Statement stmt = getConnection().createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				Lancamento lancamento = criarLancamento(rs);
				contas.add(lancamento);
			}
			getConnection().close();
		} catch(SQLException e) {
			System.out.println("Erro ao extrair os lançamentos. Erro [ " + e.getMessage() + " ].");
			System.out.println("Trace do erro [ " + e.getStackTrace().toString() + " ].");
		} 
		return contas;
	}

	@Override
	public Lancamento getById(Long id) {
		Lancamento lancamento = null;
		String sql = "SELECT TL.cd_lancamento, TL.vl_lancamento, TL.dt_lancamento, TL.ds_lancamento, "
				+ "TTL.cd_tipo, TTL.ds_tipo, "
				+ "TU.cd_usuario, TU.vl_cpf_usuario, TU.nm_usuario, TU.ck_usuario_ativo, TU.ds_email, "
				+ "TC.cd_conta, TC.vl_agencia, TC.vl_conta, TC.vl_banco, "
				+ "TCU.cd_usuario AS conta_usuario, TCU.vl_cpf_usuario AS conta_usuario_cpf, TCU.nm_usuario AS conta_usuario_nome, "
				+ "TCU.ck_usuario_ativo AS conta_usuario_ativo, TCU.ds_email AS conta_usuario_email, "
				+ "TTI.cd_tipo_investimento, TTI.ds_tipo_investimento, TTI.vl_rendimento_mensal, TTI.prazo_minimo_investimento "
				+ "FROM T_LANCAMENTO TL "
				+ "INNER JOIN T_CONTA TC ON TC.cd_conta = TL.cd_conta "
				+ "INNER JOIN T_USUARIO TCU ON TCU.cd_usuario = TC.cd_usuario "
				+ "INNER JOIN T_TIPO_LANCAMENTO TTL ON TTL.cd_tipo = TL.cd_tipo "
				+ "LEFT JOIN T_TIPO_INVESTIMENTO TTI ON TTI.cd_tipo_investimento = TL.cd_tipo_investimento "
				+ "INNER JOIN T_USUARIO TU ON TU.cd_usuario = TL.cd_usuario "
				+ "WHERE TL.cd_lancamento = ?";
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					lancamento = criarLancamento(rs);
				}
			}
			getConnection().close();
		} catch (SQLException e) {
			System.out.println("Erro ao extrair o lançamento com ID [ " + id + " ]. Erro [ " + e.getMessage() + " ].");
			System.out.println("Trace do erro [ " + e.getStackTrace().toString() + " ].");
		}
		return lancamento;
	}

	@Override
	public void save(Lancamento t) {
		String sql = "";
		if ((t.getId() != null && t.getId() > 0) && (t.getTipoLancamento().getId() == 3L)) {
			sql = "UPDATE T_LANCAMENTO SET vl_lancamento = ?, dt_lancamento = ?, ds_lancamento = ?, cd_tipo = ?, "
					+ "cd_usuario = ?, cd_conta = ?, cd_tipo_investimento = ? WHERE cd_lancamento = ?";
		} else if (t.getId() != null && t.getId() > 0) {
			sql = "UPDATE T_LANCAMENTO SET vl_lancamento = ?, dt_lancamento = ?, ds_lancamento = ?, cd_tipo = ?, "
					+ "cd_usuario = ?, cd_conta = ? WHERE cd_lancamento = ?";			
		} else if (t.getTipoLancamento().getId() == 3L) {
			sql = "INSERT INTO T_LANCAMENTO (vl_lancamento, dt_lancamento, ds_lancamento, cd_tipo, "
					+ " cd_usuario, cd_conta, cd_tipo_investimento, cd_lancamento) VALUES (?, ?, ?, ?, ?, ?, ?, SEQ_LANCAMENTO.NEXTVAL)";
		} else {
			sql = "INSERT INTO T_LANCAMENTO (vl_lancamento, dt_lancamento, ds_lancamento, cd_tipo, "
					+ " cd_usuario, cd_conta, cd_lancamento) VALUES (?, ?, ?, ?, ?, ?, SEQ_LANCAMENTO.NEXTVAL)";
		}
		try(PreparedStatement stmt = getConnection().prepareStatement(sql)) {
			stmt.setDouble(1, t.getVlLancamento());
			java.sql.Date dataLancamento = new java.sql.Date(t.getDtLancamento().getTime());
			stmt.setDate(2, dataLancamento);
			stmt.setString(3, t.getDsLancamento());
			stmt.setLong(4, t.getTipoLancamento().getId());
			stmt.setLong(5, t.getUsuario().getId());
			stmt.setLong(6, t.getConta().getId());
			if(t.getTipoLancamento().getId() == 3L) {
				stmt.setLong(7, t.getTipoInvestimento().getId());
				if(t.getId() != null && t.getId() > 0) {
					stmt.setLong(8, t.getId());
				}
			} else {
				if(t.getId() != null && t.getId() > 0) {
					stmt.setLong(7, t.getId());
				}
			}
			stmt.executeUpdate();
			getConnection().close();
		} catch (SQLException e) {
			System.out.println("Erro ao salvar ou atualizar um lançamento. Erro [ " + e.getMessage() + " ].");
			System.out.println("Trace do erro [ " + e.getStackTrace().toString() + " ].");
		}
	}

	@Override
	public void delete(Long id) {
		try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM T_LANCAMENTO WHERE cd_lancamento = ?")) {
			stmt.setLong(1, id);
			stmt.executeQuery();
			stmt.executeUpdate();
			getConnection().close();
		} catch (SQLException e) {
			System.out.println("Erro ao remover a conta com ID [ " + id + " ]. Erro [ " + e.getMessage() + " ].");
			System.out.println("Trace do erro [ " + e.getStackTrace().toString() + " ].");
		}
	}
	
	private static Lancamento criarLancamento(ResultSet rs) throws SQLException {
		TipoLancamento tipoLancamento = new TipoLancamento();
		tipoLancamento.setId(rs.getLong("cd_tipo"));
		tipoLancamento.setDsTipo(rs.getString("ds_tipo"));
		
		TipoInvestimento tipoInvestimento = new TipoInvestimento();
		tipoInvestimento.setId(rs.getLong("cd_tipo_investimento"));
		tipoInvestimento.setDsTipoInvestimento(rs.getString("ds_tipo_investimento"));
		tipoInvestimento.setVlRendimentoMensal(rs.getDouble("vl_rendimento_mensal"));
		tipoInvestimento.setPrazoMinimoInvestimento(rs.getInt("prazo_minimo_investimento"));
		
		Usuario contaUsuario = new Usuario();
		contaUsuario.setId(rs.getLong("conta_usuario"));
		contaUsuario.setCkUsuarioAtivo(rs.getInt("conta_usuario_ativo") != 0 ? true : false);
		contaUsuario.setDsEmail(rs.getString("conta_usuario_email"));
		contaUsuario.setNmUsuario(rs.getString("conta_usuario_nome"));
		contaUsuario.setVlCpf(rs.getString("conta_usuario_cpf"));
		
		Conta conta = new Conta();
		conta.setId(rs.getLong("cd_conta"));
		conta.setVlAgencia(rs.getString("vl_agencia"));
		conta.setVlConta(rs.getString("vl_conta"));
		conta.setVlBanco(rs.getString("vl_banco"));
		conta.setUsuario(contaUsuario);		
		
		Usuario usuario = new Usuario();
		usuario.setCkUsuarioAtivo(rs.getInt("ck_usuario_ativo") != 0 ? true : false);
		usuario.setDsEmail(rs.getString("ds_email"));
		usuario.setId(rs.getLong("cd_usuario"));
		usuario.setNmUsuario(rs.getString("nm_usuario"));
		usuario.setVlCpf(rs.getString("vl_cpf_usuario"));
		
		Lancamento lancamento = new Lancamento();
		lancamento.setId(rs.getLong("cd_lancamento"));
		lancamento.setVlLancamento(rs.getDouble("vl_lancamento"));
		lancamento.setDtLancamento(rs.getDate("dt_lancamento"));
		lancamento.setDsLancamento(rs.getString("ds_lancamento"));
		lancamento.setTipoLancamento(tipoLancamento);
		lancamento.setTipoInvestimento(tipoInvestimento);
		lancamento.setUsuario(usuario);
		lancamento.setConta(conta);
		return lancamento;
	}
	
}
