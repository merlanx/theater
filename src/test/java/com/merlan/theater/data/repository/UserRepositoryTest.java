package com.merlan.theater.data.repository;

/**
 * @auther meilan_xie
 */

import com.merlan.theater.data.entity.User;
import org.joda.time.DateTime;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testFindUserByMail() {
        User dummy = new User("merlan", "xie", "Dummy@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate(),0);
        this.entityManager.persist(dummy);
        User user = this.userRepository.findByEmail(dummy.getEmail());
        assertThat(user.getEmail()).isEqualTo("dummy@epam.com");
        user = this.userRepository.findByEmail("DUMMY");
        assertNull(user);
    }
    @Test
    public void testFindUserByMails() {
        User dummy = new User("merlan", "xie", "Dummy@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate(),0);
        User dummy2 = new User("merlan", "xie", "Dummy_2@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate(),0);
        this.entityManager.persist(dummy);
        this.entityManager.persist(dummy2);
        List<User> users = this.userRepository.findByEmails(Arrays.asList(new String[]{dummy.getEmail(), dummy2.getEmail()}));
        assertThat(users.size()).isEqualTo(2);
        users = this.userRepository.findByEmails(Arrays.asList(new String[]{"DUMMY"}));
        assertThat(users.size()).isEqualTo(0);
    }

    @Test
    public void testFindUserByUserId() {
        this.entityManager.persist(new User("dummy", "dummy", "dummy@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate(), 0));
        this.entityManager.persist(new User("dummy", "dummy", "dummy@163.com", new DateTime(2017, 07, 15,00,00,00).toDate(), 0));
        User user = this.userRepository.findByUserId(new Long("100"));
        //userId is set to be started from 100 in hsqldb， there are less than 200 users in the db
        assertThat(user.getUserId()).isEqualTo(new Long("100"));
        user = this.userRepository.findByUserId(new Long("200"));
        assertNull(user);
    }

    @Test(expected = Exception.class)
    public void throwsExceptionWhenSameWithSameMails() {
        this.entityManager.persist(new User("dummy", "dummy", "dummy@epam.com", new DateTime(2017, 07, 15,00,00,00).toDate(), 0));
        this.entityManager.persist(new User("dummy", "dummy", "dummy@epam.com", new DateTime(2017, 07, 15, 00, 00, 00).toDate(), 0));
    }
}
