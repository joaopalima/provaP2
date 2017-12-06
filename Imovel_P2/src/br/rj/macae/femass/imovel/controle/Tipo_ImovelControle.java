/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.imovel.controle;



import br.rj.macae.femass.imovel.dao.Tipo_ImovelDAO;
import br.rj.macae.femass.imovel.entidade.Tipo_Imovel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author jorge
 */
public class Tipo_ImovelControle {
    
    public void gravar(Tipo_Imovel r, JList listaTipo_Imovels) throws SQLException{
        if(r.getId()==null || r.getId()<=0){
            cadastrar(r, listaTipo_Imovels);
        }else{
            alterar(r, listaTipo_Imovels);
        }
    }
    private void cadastrar(Tipo_Imovel r, JList listaTipo_Imovels) throws SQLException{
        Tipo_ImovelDAO dao = new Tipo_ImovelDAO();
        dao.cadastrar(r);
        List tipo_imovels = dao.listarTodos();
        listaTipo_Imovels.setListData(tipo_imovels.toArray());
    }
    private void alterar(Tipo_Imovel r, JList listaTipo_Imovels) throws SQLException{
        Tipo_ImovelDAO dao = new Tipo_ImovelDAO();
        dao.alterar(r);
        List tipo_imovels = dao.listarTodos();
        listaTipo_Imovels.setListData(tipo_imovels.toArray());
    }
    public void excluir(Tipo_Imovel r, JList listaTipo_Imovels) throws SQLException{
        Tipo_ImovelDAO dao = new Tipo_ImovelDAO();
        dao.excluir(r);
        List tipo_imovels = dao.listarTodos();
        listaTipo_Imovels.setListData(tipo_imovels.toArray());
    }
    public void atualizarListaTipo_Imovels(JList listaTipo_Imovels) throws SQLException{
        Tipo_ImovelDAO dao = new Tipo_ImovelDAO();        
        List tipo_imovels = dao.listarTodos();
        listaTipo_Imovels.setListData(tipo_imovels.toArray());
    }
    
    
}
