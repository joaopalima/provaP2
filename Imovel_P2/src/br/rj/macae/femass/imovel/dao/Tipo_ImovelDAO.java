

package br.rj.macae.femass.imovel.dao;






import br.rj.macae.femass.imovel.entidade.Tipo_Imovel;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jorge
 */
public class Tipo_ImovelDAO implements IDAO {
    
    @Override
    public void cadastrar(Object o) throws SQLException {
        Tipo_Imovel c = (Tipo_Imovel)o;
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        
    }

     @Override
    public void alterar(Object o) throws SQLException {
        Tipo_Imovel tipo_imovel = (Tipo_Imovel) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.merge(tipo_imovel);
        em.getTransaction().commit();
        em.close();
      
           
    }

     @Override
    public void excluir(Object o) throws SQLException {
        Tipo_Imovel tipo_imovel = (Tipo_Imovel) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        tipo_imovel = em.merge(tipo_imovel);
        em.remove(tipo_imovel);
        em.getTransaction().commit();
        em.close();
        
    }

     @Override
    public List listarTodos() throws SQLException {
        
        try {
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            TypedQuery<Tipo_Imovel> consulta = em.createQuery("SELECT c FROM Tipo_Imovel c",Tipo_Imovel.class);
            List<Tipo_Imovel> tipo_imovels = consulta.getResultList();
            em.close();
            return tipo_imovels;
                        
        } catch (Exception e) {
            throw new SQLException("Erro ao tentar listar tipo do imovel. \n" + e.getMessage());
        }
        
    }

     @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        return null;

    }
   
    
}
