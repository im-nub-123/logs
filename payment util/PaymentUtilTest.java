package com.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(LoggingExtension.class)
public class PaymentUtilTest{
 private PaymentUtil paymentUtil;
 @BeforeEach void setUp(){paymentUtil=new PaymentUtil();}
 @AfterEach void tearDown(){paymentUtil=null;}

 @Test void testMaskCardNumberValid(){assertEquals("**** **** **** 5678",paymentUtil.maskCardNumber("1234567812345678"),"Mask failed");}
 @Test void testMaskCardNumberNull(){assertEquals("Invalid card number",paymentUtil.maskCardNumber(null),"Null invalid");}
 @Test void testMaskCardNumberShort(){assertEquals("Invalid card number",paymentUtil.maskCardNumber("123"),"Short invalid");}

 @Test void testExpiredPast(){assertTrue(paymentUtil.isCardExpired(LocalDate.now().minusDays(1)),"Past expired");}
 @Test void testExpiredToday(){assertFalse(paymentUtil.isCardExpired(LocalDate.now()),"Today valid");}
 @Test void testExpiredFuture(){assertFalse(paymentUtil.isCardExpired(LocalDate.now().plusDays(1)),"Future valid");}
 @Test void testExpiredNull(){assertThrows(NullPointerException.class,()->paymentUtil.isCardExpired(null));}

 @Test void testFormatNormal(){assertEquals("$1234.50",paymentUtil.formatCurrency(1234.5,"$"),"Format");}
 @Test void testFormatRounded(){assertEquals("$1234.57",paymentUtil.formatCurrency(1234.567,"$"),"Round");}
 @Test void testFormatZero(){assertEquals("$0.00",paymentUtil.formatCurrency(0,"$"),"Zero");}
 @Test void testFormatNegative(){assertEquals("$-25.50",paymentUtil.formatCurrency(-25.5,"$"),"Negative");}
 @Test void testFormatNull(){assertThrows(NullPointerException.class,()->paymentUtil.formatCurrency(100,null));}
}
