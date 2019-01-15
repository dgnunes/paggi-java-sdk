import br.com.paggi.auth.PaggiCredentialsValidator;
import br.com.paggi.auth.PaggiCredentials;
import org.junit.Assert;
import org.junit.Test;

public class PaggiCredentialsValidatorTest {
    @Test
    public void testValidToken(){
        PaggiCredentialsValidator validator = PaggiCredentialsValidator.withCredentials(new PaggiCredentials().withPartnerId(TestCredentials.PARTNERID).withToken(TestCredentials.TOKEN));

        Assert.assertTrue(validator.isValid());
   }

    @Test
    public void testInvalidToken(){
        PaggiCredentialsValidator validator = PaggiCredentialsValidator.withCredentials(new PaggiCredentials().withPartnerId(TestCredentials.PARTNERID).withToken(TestCredentials.INVALIDTOKEN));

        Assert.assertFalse(validator.isValid());
    }

    @Test
    public void testExpiringToken(){
        PaggiCredentialsValidator validator = PaggiCredentialsValidator.withCredentials(new PaggiCredentials().withPartnerId(TestCredentials.PARTNERID).withToken(TestCredentials.EXPIRINGTOKEN));

        Assert.assertFalse(validator.isValid());
    }


    @Test
    public void testExpiredToken() {
        PaggiCredentialsValidator validator = PaggiCredentialsValidator.withCredentials(new PaggiCredentials().withPartnerId(TestCredentials.PARTNERID).withToken(TestCredentials.EXPIREDTOKEN));

        Assert.assertFalse(validator.isValid());
    }

}
