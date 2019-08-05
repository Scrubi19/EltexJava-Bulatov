package ru.sp.db.data.database.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sp.db.data.database.TodoDAO;
import ru.sp.db.data.database.entities.TodoEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TodoEntityManagerDao implements TodoDAO {
    private final EntityManager em;

    public TodoEntityManagerDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<TodoEntity> getAll() {
        Query query = em.createQuery("select entity from TodoEntity entity");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(TodoEntity todoEntity) {
        em.getTransaction().begin();
        em.persist(todoEntity);
        em.getTransaction().commit();
    }
}
