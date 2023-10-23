package model.DAO;

import model.AlimentoRefeicao;
import model.Pessoa;

public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentorefeicao = new AlimentoRefeicao[25];

    public AlimentoRefeicaoDAO(RefeicoesDAO refeicaoDAO, AlimentoDAO alimentoDAO, PessoaDAO pessoaDAO) {
        AlimentoRefeicao alrf1 = new AlimentoRefeicao();
        alrf1.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf1.setRefeicao(refeicaoDAO.buscaPorId(0));
        alrf1.setAlimento(alimentoDAO.BuscaAlimentoID(4));
        alrf1.setPorcao(1);
        criaAlimentoRefeicao(alrf1);

        AlimentoRefeicao alrf2 = new AlimentoRefeicao();
        alrf2.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf2.setRefeicao(refeicaoDAO.buscaPorId(0));
        alrf2.setAlimento(alimentoDAO.BuscaAlimentoID(3));
        alrf2.setPorcao(1);
        criaAlimentoRefeicao(alrf2);

        AlimentoRefeicao alrf3 = new AlimentoRefeicao();
        alrf3.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf3.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf3.setAlimento(alimentoDAO.BuscaAlimentoID(0));
        alrf3.setPorcao(1);
        criaAlimentoRefeicao(alrf3);

        AlimentoRefeicao alrf4 = new AlimentoRefeicao();
        alrf4.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf4.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf4.setAlimento(alimentoDAO.BuscaAlimentoID(1));
        alrf4.setPorcao(1);
        criaAlimentoRefeicao(alrf4);

        AlimentoRefeicao alrf5 = new AlimentoRefeicao();
        alrf5.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf5.setRefeicao(refeicaoDAO.buscaPorId(1));
        alrf5.setAlimento(alimentoDAO.BuscaAlimentoID(2));
        alrf5.setPorcao(1);
        criaAlimentoRefeicao(alrf5);

        AlimentoRefeicao alrf6 = new AlimentoRefeicao();
        alrf6.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf6.setRefeicao(refeicaoDAO.buscaPorId(2));
        alrf6.setAlimento(alimentoDAO.BuscaAlimentoID(5));
        alrf6.setPorcao(1);
        criaAlimentoRefeicao(alrf6);

        AlimentoRefeicao alrf7 = new AlimentoRefeicao();
        alrf7.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf7.setRefeicao(refeicaoDAO.buscaPorId(2));
        alrf7.setAlimento(alimentoDAO.BuscaAlimentoID(6));
        alrf7.setPorcao(1);
        criaAlimentoRefeicao(alrf7);

        AlimentoRefeicao alrf8 = new AlimentoRefeicao();
        alrf8.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf8.setRefeicao(refeicaoDAO.buscaPorId(3));
        alrf8.setAlimento(alimentoDAO.BuscaAlimentoID(0));
        alrf8.setPorcao(1);
        criaAlimentoRefeicao(alrf8);

        AlimentoRefeicao alrf9 = new AlimentoRefeicao();
        alrf9.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf9.setRefeicao(refeicaoDAO.buscaPorId(3));
        alrf9.setAlimento(alimentoDAO.BuscaAlimentoID(1));
        alrf9.setPorcao(1);
        criaAlimentoRefeicao(alrf9);

        AlimentoRefeicao alrf10 = new AlimentoRefeicao();
        alrf10.setPessoa(pessoaDAO.buscaPorNome("iago"));
        alrf10.setRefeicao(refeicaoDAO.buscaPorId(3));
        alrf10.setAlimento(alimentoDAO.BuscaAlimentoID(2));
        alrf10.setPorcao(1);
        criaAlimentoRefeicao(alrf10);
    }

    public boolean criaAlimentoRefeicao(AlimentoRefeicao rf) {
        int proxAlimentoRefLivre = proxAlimentoRefLivre();
        for (int i = 0; i < alimentorefeicao.length; i++) {
            if (proxAlimentoRefLivre != -1) {
                alimentorefeicao[proxAlimentoRefLivre] = rf;
                return true;
            }
        }
        return false;
    }

    public int proxAlimentoRefLivre() {
        for (int i = 0; i < alimentorefeicao.length; i++) {
            if (alimentorefeicao[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean removeAlimentoRefeicao(long id) {
        for (int i = 0; i < alimentorefeicao.length; i++) {
            if (alimentorefeicao[i] != null && alimentorefeicao[i].getId() == id) {
                alimentorefeicao[i] = null;
                return true;
            }
        }
        return false;
    }

    public void mostraAlimentoRefeicao(Pessoa p) {
        for (int i = 0; i < alimentorefeicao.length; i++) {
            if (alimentorefeicao[i] != null && alimentorefeicao[i].getPessoa().getNome().equals(p.getNome())) {
                System.out.println("ID: " + alimentorefeicao[i].getId() + " --- Refeição: " + alimentorefeicao[i].getRefeicao().getNomeRefeicao() + "--- Alimentos: " + alimentorefeicao[i].getAlimento().getNome());
            }
        }
    }

    public AlimentoRefeicao[] buscaTodosPorPessoa(Pessoa p) {
        AlimentoRefeicao[] alrfs = new AlimentoRefeicao[10];
        for (int i = 0; i < alimentorefeicao.length; i++) {
            if (alimentorefeicao[i] != null && alimentorefeicao[i].getPessoa().equals(p)) {
                for (int j = 0; j < alrfs.length; j++) {
                    if (alrfs[i] == null) {
                        alrfs[i] = alimentorefeicao[i];
                    }
                }
            }

        }
        return alrfs;
    }
}
