/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.imovel.controle;



import br.rj.macae.femass.imovel.dao.ImovelDAO;
import br.rj.macae.femass.imovel.entidade.Imovel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author jorge
 */
public class ImovelControle {
    
    public void gravar(Imovel r, JList listaImovels) throws SQLException{
        if(r.getId()==null || r.getId()<=0){
            cadastrar(r, listaImovels);
        }else{
            alterar(r, listaImovels);
        }
    }
    private void cadastrar(Imovel r, JList listaImovels) throws SQLException{
        ImovelDAO dao = new ImovelDAO();
        dao.cadastrar(r);
        List imovels = dao.listarTodos();
        listaImovels.setListData(imovels.toArray());
    }
    private void alterar(Imovel r, JList listaImovels) throws SQLException{
        ImovelDAO dao = new ImovelDAO();
        dao.alterar(r);
        List imovels = dao.listarTodos();
        listaImovels.setListData(imovels.toArray());
    }
    public void excluir(Imovel r, JList listaImovels) throws SQLException{
        ImovelDAO dao = new ImovelDAO();
        dao.excluir(r);
        List imovels = dao.listarTodos();
        listaImovels.setListData(imovels.toArray());
    }
    public void atualizarListaImovels(JList listaImovels) throws SQLException{
        ImovelDAO dao = new ImovelDAO();        
        List imovels = dao.listarTodos();
        listaImovels.setListData(imovels.toArray());
    }
    
    
}
