package NunesSports.api.produtos;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutosDAO {

    private final EntityManager entityManager;

    public ProdutosDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Produtos produtos) {
        entityManager.persist(produtos);
    }

    public Produtos read(Long id) {
        return entityManager.find(Produtos.class, id);
    }

    public void update(Produtos produtos) {
        entityManager.merge(produtos);
    }

    public void remove(Produtos produtos) {
        entityManager.remove(produtos);
    }
}
