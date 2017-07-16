package com.merlan.theater.data.repository;

/**
 * @auther meilan_xie
 */

import com.merlan.theater.data.entity.Auditorium;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuditoriumRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Test
    public void testFindUserByMail() {
        this.entityManager.persist(new Auditorium(null, "room5", new HashSet<String>(), new HashSet<String>()));
        this.entityManager.persist(new Auditorium(null, "room6", new HashSet<String>(), new HashSet<String>()));
        Auditorium auditorium = this.auditoriumRepository.findByName("room5");
        assertThat(auditorium.getName()).isEqualTo("room5");
        auditorium = this.auditoriumRepository.findByName("dummy");
        assertNull(auditorium);
    }

}
