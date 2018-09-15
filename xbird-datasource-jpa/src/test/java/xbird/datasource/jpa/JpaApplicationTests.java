package xbird.datasource.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import xbird.datasource.jpa.repository.AuditRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JpaApplicationTests {

  @Autowired
  private AuditRepository auditRepository;
  
  @Test
  public void test() {
    System.out.println(auditRepository.count());
  }
  
}
