

package br.rj.macae.femass.imovel.dao;





import br.rj.macae.femass.imovel.entidade.Imovel;
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
public class ImovelDAO implements IDAO {
    
    @Override
    public void cadastrar(Object o) throws SQLException {
        Imovel c = (Imovel)o;
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        
    }

     @Override
    public void alterar(Object o) throws SQLException {
        Imovel imovel = (Imovel) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.merge(imovel);
        em.getTransaction().commit();
        em.close();
      
           
    }

     @Override
    public void excluir(Object o) throws SQLException {
        Imovel imovel = (Imovel) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        imovel = em.merge(imovel);
        em.remove(imovel);
        em.getTransaction().commit();
        em.close();
        
    }

     @Override
    public List listarTodos() throws SQLException {
        
        try {
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            TypedQuery<Imovel> consulta = em.createQuery("SELECT c FROM Imovel c",Imovel.class);
            List<Imovel> imovels = consulta.getResultList();
            em.close();
            return imovels;
                        
        } catch (Exception e) {
            throw new SQLException("Erro ao tentar listar a imovel. \n" + e.getMessage());
        }
        
    }

     @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        return null;

    }
   
    
}
