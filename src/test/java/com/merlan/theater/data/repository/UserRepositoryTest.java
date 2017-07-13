package com.merlan.theater.data.repository;

/**
 * @auther meilan_xie
 */

import com.merlan.theater.data.entity.User;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByMail() {
        this.entityManager.persist(new User("merlan", "xie", "meilan_xie@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate()));
        User user = this.userRepository.findByEmail("meilan_xie@epam.com");
        assertThat(user.getEmail()).isEqualTo("meilan_xie@epam.com");
    }

    @Test
    public void testFindUserByUserId() {
        this.entityManager.persist(new User("merlan", "xie", "meilan_xie@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate()));
        User user = this.userRepository.findByUserId(new Long("100"));
        //userId is set to be started from 100 in hsqldb
        assertThat(user.getUserId()).isEqualTo(new Long("100"));
    }

}
